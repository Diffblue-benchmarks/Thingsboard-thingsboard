package org.thingsboard.server.service.edge.rpc.processor.oauth2;

import static org.junit.jupiter.api.Assertions.assertNull;
import static org.mockito.Mockito.mock;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.thingsboard.server.common.data.edge.EdgeEvent;
import org.thingsboard.server.common.data.edge.EdgeEventActionType;
import org.thingsboard.server.gen.edge.v1.EdgeVersion;

class OAuth2EdgeProcessorDiffblueTest {
  /**
   * Test
   * {@link OAuth2EdgeProcessor#convertOAuth2DomainEventToDownlink(EdgeEvent, EdgeVersion)}.
   * <ul>
   *   <li>Given {@code POST_ATTRIBUTES}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link OAuth2EdgeProcessor#convertOAuth2DomainEventToDownlink(EdgeEvent, EdgeVersion)}
   */
  @Test
  @DisplayName("Test convertOAuth2DomainEventToDownlink(EdgeEvent, EdgeVersion); given 'POST_ATTRIBUTES'")
  void testConvertOAuth2DomainEventToDownlink_givenPostAttributes() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    OAuth2EdgeProcessor oAuth2EdgeProcessor = new OAuth2EdgeProcessor();

    EdgeEvent edgeEvent = new EdgeEvent();
    edgeEvent.setAction(EdgeEventActionType.POST_ATTRIBUTES);

    // Act and Assert
    assertNull(oAuth2EdgeProcessor.convertOAuth2DomainEventToDownlink(edgeEvent, EdgeVersion.V_3_8_0));
  }

  /**
   * Test
   * {@link OAuth2EdgeProcessor#convertOAuth2DomainEventToDownlink(EdgeEvent, EdgeVersion)}.
   * <ul>
   *   <li>When {@link EdgeEvent#EdgeEvent()}.</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link OAuth2EdgeProcessor#convertOAuth2DomainEventToDownlink(EdgeEvent, EdgeVersion)}
   */
  @Test
  @DisplayName("Test convertOAuth2DomainEventToDownlink(EdgeEvent, EdgeVersion); when EdgeEvent(); then return 'null'")
  void testConvertOAuth2DomainEventToDownlink_whenEdgeEvent_thenReturnNull() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    OAuth2EdgeProcessor oAuth2EdgeProcessor = new OAuth2EdgeProcessor();

    // Act and Assert
    assertNull(oAuth2EdgeProcessor.convertOAuth2DomainEventToDownlink(new EdgeEvent(), EdgeVersion.V_3_3_0));
  }

  /**
   * Test
   * {@link OAuth2EdgeProcessor#convertOAuth2DomainEventToDownlink(EdgeEvent, EdgeVersion)}.
   * <ul>
   *   <li>When {@link EdgeEvent}.</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link OAuth2EdgeProcessor#convertOAuth2DomainEventToDownlink(EdgeEvent, EdgeVersion)}
   */
  @Test
  @DisplayName("Test convertOAuth2DomainEventToDownlink(EdgeEvent, EdgeVersion); when EdgeEvent; then return 'null'")
  void testConvertOAuth2DomainEventToDownlink_whenEdgeEvent_thenReturnNull2() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertNull(
        (new OAuth2EdgeProcessor()).convertOAuth2DomainEventToDownlink(mock(EdgeEvent.class), EdgeVersion.V_3_3_0));
  }

  /**
   * Test
   * {@link OAuth2EdgeProcessor#convertOAuth2ClientEventToDownlink(EdgeEvent, EdgeVersion)}.
   * <ul>
   *   <li>Given {@code ADDED}.</li>
   *   <li>When {@link EdgeEvent#EdgeEvent()} Action is {@code ADDED}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link OAuth2EdgeProcessor#convertOAuth2ClientEventToDownlink(EdgeEvent, EdgeVersion)}
   */
  @Test
  @DisplayName("Test convertOAuth2ClientEventToDownlink(EdgeEvent, EdgeVersion); given 'ADDED'; when EdgeEvent() Action is 'ADDED'")
  void testConvertOAuth2ClientEventToDownlink_givenAdded_whenEdgeEventActionIsAdded() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    OAuth2EdgeProcessor oAuth2EdgeProcessor = new OAuth2EdgeProcessor();

    EdgeEvent edgeEvent = new EdgeEvent();
    edgeEvent.setAction(EdgeEventActionType.ADDED);

    // Act and Assert
    assertNull(oAuth2EdgeProcessor.convertOAuth2ClientEventToDownlink(edgeEvent, EdgeVersion.V_3_3_0));
  }

  /**
   * Test
   * {@link OAuth2EdgeProcessor#convertOAuth2ClientEventToDownlink(EdgeEvent, EdgeVersion)}.
   * <ul>
   *   <li>Given {@code POST_ATTRIBUTES}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link OAuth2EdgeProcessor#convertOAuth2ClientEventToDownlink(EdgeEvent, EdgeVersion)}
   */
  @Test
  @DisplayName("Test convertOAuth2ClientEventToDownlink(EdgeEvent, EdgeVersion); given 'POST_ATTRIBUTES'")
  void testConvertOAuth2ClientEventToDownlink_givenPostAttributes() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    OAuth2EdgeProcessor oAuth2EdgeProcessor = new OAuth2EdgeProcessor();

    EdgeEvent edgeEvent = new EdgeEvent();
    edgeEvent.setAction(EdgeEventActionType.POST_ATTRIBUTES);

    // Act and Assert
    assertNull(oAuth2EdgeProcessor.convertOAuth2ClientEventToDownlink(edgeEvent, EdgeVersion.V_3_8_0));
  }

  /**
   * Test
   * {@link OAuth2EdgeProcessor#convertOAuth2ClientEventToDownlink(EdgeEvent, EdgeVersion)}.
   * <ul>
   *   <li>When {@link EdgeEvent#EdgeEvent()}.</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link OAuth2EdgeProcessor#convertOAuth2ClientEventToDownlink(EdgeEvent, EdgeVersion)}
   */
  @Test
  @DisplayName("Test convertOAuth2ClientEventToDownlink(EdgeEvent, EdgeVersion); when EdgeEvent(); then return 'null'")
  void testConvertOAuth2ClientEventToDownlink_whenEdgeEvent_thenReturnNull() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    OAuth2EdgeProcessor oAuth2EdgeProcessor = new OAuth2EdgeProcessor();

    // Act and Assert
    assertNull(oAuth2EdgeProcessor.convertOAuth2ClientEventToDownlink(new EdgeEvent(), EdgeVersion.V_3_3_0));
  }

  /**
   * Test
   * {@link OAuth2EdgeProcessor#convertOAuth2ClientEventToDownlink(EdgeEvent, EdgeVersion)}.
   * <ul>
   *   <li>When {@link EdgeEvent}.</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link OAuth2EdgeProcessor#convertOAuth2ClientEventToDownlink(EdgeEvent, EdgeVersion)}
   */
  @Test
  @DisplayName("Test convertOAuth2ClientEventToDownlink(EdgeEvent, EdgeVersion); when EdgeEvent; then return 'null'")
  void testConvertOAuth2ClientEventToDownlink_whenEdgeEvent_thenReturnNull2() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertNull(
        (new OAuth2EdgeProcessor()).convertOAuth2ClientEventToDownlink(mock(EdgeEvent.class), EdgeVersion.V_3_3_0));
  }
}
