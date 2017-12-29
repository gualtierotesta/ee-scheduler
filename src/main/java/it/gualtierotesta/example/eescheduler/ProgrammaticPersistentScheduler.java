/*
 * Copyright 2016 Gualtiero Testa <http://www.gualtierotesta.it>.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package it.gualtierotesta.example.eescheduler;

import java.util.logging.Logger;
import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import javax.ejb.ScheduleExpression;
import javax.ejb.Singleton;
import javax.ejb.Startup;
import javax.ejb.Timeout;
import javax.ejb.Timer;
import javax.ejb.TimerConfig;
import javax.ejb.TimerService;
import javax.inject.Inject;

/**
 * Programmatic persistent scheduler
 *
 * @author Gualtiero Testa <http://www.gualtierotesta.it>
 */
@Startup
@Singleton
public class ProgrammaticPersistentScheduler {

    private final Logger log = Logger.getLogger(getClass().getName());
    private Timer timer;

    @Resource
    private TimerService timerService;

    @Inject
    private MyService myService;

    @Inject
    private ConfigurationService configurationService;

    // We build the timer at appliation startup (see @Startup annotation)
    @PostConstruct
    public void postConstruct() {

        ScheduleExpression schedule = createScheduleExpression();

        TimerConfig timerConfig = createTimerConfig();

        timer = timerService.createCalendarTimer(schedule, timerConfig);

        log.info(String.format("%s initialized with schedule %s",
                getClass().getName(), timer.getSchedule()));
    }

    // This method is invoked at every scheduling event
    @Timeout
    public void process() {
        log.info(myService.sayCiao("ProgrammaticPersistentScheduler"));
    }

    // ScheduleExpression creation
    private ScheduleExpression createScheduleExpression() {
        // Get schedule parameters from the configuration service
        ScheduleParameters scheduleParameters = configurationService.readScheduleParameters();

        // build and return the ScheduleExpression as required by the TimerService
        ScheduleExpression schedule = new ScheduleExpression()
                .second(scheduleParameters.getSecond())
                .minute(scheduleParameters.getMinute())
                .hour(scheduleParameters.getHour());
        return schedule;
    }

    // TimerConfig creation
    private TimerConfig createTimerConfig() {
        TimerConfig timerConfig = new TimerConfig();

        // The name of the scheduler
        timerConfig.setInfo("ProgrammaticPersistentScheduler");

        // The scheduler is persistent.
        // Set to false if we do want a non persistent scheduler
        timerConfig.setPersistent(true);

        return timerConfig;
    }

}
