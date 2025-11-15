/**
 * Copyright © 2016-2024 The Thingsboard Authors
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.thingsboard.server.dao.cassandra.guava;

import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import com.datastax.dse.driver.internal.core.session.DefaultDseSession;
import com.datastax.oss.driver.api.core.session.Session;
import org.junit.jupiter.api.Test;

class DefaultGuavaSessionDiffblueTest {
  /**
   * Method under test: {@link DefaultGuavaSession#DefaultGuavaSession(Session)}
   */
  @Test
  void testNewDefaultGuavaSession() {
    // Arrange
    DefaultDseSession delegate = new DefaultDseSession(null);

    // Act and Assert
    Session delegate2 = (new DefaultGuavaSession(delegate)).getDelegate();
    assertTrue(delegate2 instanceof DefaultDseSession);
    assertSame(delegate, delegate2);
  }
}
