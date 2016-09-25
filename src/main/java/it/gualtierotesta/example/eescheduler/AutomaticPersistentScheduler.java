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
import javax.ejb.Schedule;
import javax.ejb.Singleton;
import javax.ejb.Startup;
import javax.inject.Inject;

/**
 * Example of an automatic persistent scheduler
 *
 * @author Gualtiero Testa <http://www.gualtierotesta.it>
 */
@Startup
@Singleton
public class AutomaticPersistentScheduler {

    private final Logger log = Logger.getLogger(getClass().getName());

    @Inject
    private MyService myService;

    @Schedule(second = "*/5",
            minute = "*",
            hour = "*",
            info = "AutomaticPersistentScheduler",
            persistent = true)
    public void process() {
        log.info(myService.sayCiao("AutomaticPersistentScheduler"));
    }

    @PostConstruct
    public void postConstruct() {
        log.info(getClass().getName() + ": Initialized");
    }

}
