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
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.concurrent.Executor;
import org.eclipse.californium.core.coap.Request;
import org.eclipse.californium.core.network.Exchange;
import org.eclipse.californium.core.network.Exchange.Origin;
import org.eclipse.californium.core.server.DelivererException;
import org.eclipse.californium.core.server.resources.Resource;
import org.eclipse.leshan.server.californium.RootResource;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class TbCoapServerMessageDelivererDiffblueTest {
  /**
   * Test {@link TbCoapServerMessageDeliverer#findResource(Exchange)} with {@code exchange}.
   *
   * <ul>
   *   <li>Then return {@link RootResource} (default constructor).
   * </ul>
   *
   * <p>Method under test: {@link TbCoapServerMessageDeliverer#findResource(Exchange)}
   */
  @Test
  @DisplayName(
      "Test findResource(Exchange) with 'exchange'; then return RootResource (default constructor)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Resource TbCoapServerMessageDeliverer.findResource(Exchange)"})
  void testFindResourceWithExchange_thenReturnRootResource() throws DelivererException {
    // Arrange
    RootResource root = new RootResource();
    TbCoapServerMessageDeliverer tbCoapServerMessageDeliverer =
        new TbCoapServerMessageDeliverer(root);
    Exchange exchange =
        new Exchange(Request.newDelete(), "Peers Identity", Origin.LOCAL, mock(Executor.class));

    // Act
    Resource actualFindResourceResult = tbCoapServerMessageDeliverer.findResource(exchange);

    // Assert
    assertSame(root, actualFindResourceResult);
  }
}
