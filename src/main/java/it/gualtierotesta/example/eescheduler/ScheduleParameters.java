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

/**
 * Container for schedule parameters
 *
 * @author Gualtiero Testa <http://www.gualtierotesta.it>
 */
class ScheduleParameters {

    private final String second;
    private final String minute;
    private final String hour;

    public ScheduleParameters(String second, String minute, String hour) {
        this.second = second;
        this.minute = minute;
        this.hour = hour;
    }

    public String getSecond() {
        return second;
    }

    public String getMinute() {
        return minute;
    }

    public String getHour() {
        return hour;
    }

    @Override
    public String toString() {
        return "ScheduleParameters{" + "second=" + second + ", minute=" + minute + ", hour=" + hour + '}';
    }

}
