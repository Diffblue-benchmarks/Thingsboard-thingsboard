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
package org.thingsboard.server.coapserver;

import static org.junit.jupiter.api.Assertions.assertSame;
import static org.mockito.Mockito.mock;
import java.util.concurrent.Executor;
import org.eclipse.californium.core.coap.Request;
import org.eclipse.californium.core.network.Exchange;
import org.eclipse.californium.core.server.DelivererException;
import org.eclipse.leshan.server.californium.RootResource;
import org.junit.jupiter.api.Test;

class TbCoapServerMessageDelivererDiffblueTest {
  /**
   * Method under test:
   * {@link TbCoapServerMessageDeliverer#findResource(Exchange)}
   */
  @Test
  void testFindResource() throws DelivererException {
    // Arrange
    RootResource root = new RootResource();
    TbCoapServerMessageDeliverer tbCoapServerMessageDeliverer = new TbCoapServerMessageDeliverer(root);

    // Act and Assert
    assertSame(root, tbCoapServerMessageDeliverer.findResource(
        new Exchange(Request.newDelete(), "Peers Identity", Exchange.Origin.LOCAL, mock(Executor.class))));
  }
}
