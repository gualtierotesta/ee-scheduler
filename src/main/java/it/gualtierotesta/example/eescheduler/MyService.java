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

import java.util.Date;
import javax.ejb.Stateless;

/**
 * Dummy EJB service
 *
 * @author Gualtiero Testa <http://www.gualtierotesta.it>
 */
@Stateless
public class MyService {

    public String sayCiao(String toWhom) {
        return String.format("Ciao %s. It is %s", toWhom, new Date());
    }
}
