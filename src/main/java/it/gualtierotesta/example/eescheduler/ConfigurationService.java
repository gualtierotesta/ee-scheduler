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

import javax.ejb.Stateless;

/**
 * Configuration Service
 *
 * @author Gualtiero Testa <http://www.gualtierotesta.it>
 */
@Stateless
public class ConfigurationService {

    public ScheduleParameters readScheduleParameters() {

        // Read configuration parameters from DB, property file ....
        // Here we define fixed values in the code
        String second = "*/13";
        String minute = "*";
        String hour = "*";

        return new ScheduleParameters(second, minute, hour);
    }

}
