package org.thingsboard.server.coapserver;

import static org.junit.jupiter.api.Assertions.assertSame;
import static org.mockito.Mockito.mock;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.concurrent.Executor;
import org.eclipse.californium.core.coap.Request;
import org.eclipse.californium.core.network.Exchange;
import org.eclipse.californium.core.network.Exchange.Origin;
import org.eclipse.californium.core.server.DelivererException;
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
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "org.eclipse.californium.core.server.resources.Resource TbCoapServerMessageDeliverer.findResource(Exchange)"
  })
  void testFindResourceWithExchange_thenReturnRootResource() throws DelivererException {
    // Arrange
    RootResource root = new RootResource();
    TbCoapServerMessageDeliverer tbCoapServerMessageDeliverer =
        new TbCoapServerMessageDeliverer(root);

    // Act and Assert
    assertSame(
        root,
        tbCoapServerMessageDeliverer.findResource(
            new Exchange(
                Request.newDelete(), "Peers Identity", Origin.LOCAL, mock(Executor.class))));
  }
}
