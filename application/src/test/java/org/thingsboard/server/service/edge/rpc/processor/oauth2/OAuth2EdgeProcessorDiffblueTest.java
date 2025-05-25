package org.thingsboard.server.service.edge.rpc.processor.oauth2;

import static org.junit.jupiter.api.Assertions.assertNull;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;
import org.thingsboard.server.common.data.edge.EdgeEvent;
import org.thingsboard.server.common.data.edge.EdgeEventActionType;
import org.thingsboard.server.gen.edge.v1.EdgeVersion;

@ExtendWith(MockitoExtension.class)
class OAuth2EdgeProcessorDiffblueTest {
  @InjectMocks
  private OAuth2EdgeProcessor oAuth2EdgeProcessor;

  /**
   * Test {@link OAuth2EdgeProcessor#convertOAuth2DomainEventToDownlink(EdgeEvent, EdgeVersion)}.
   * <ul>
   *   <li>When {@code V_3_3_0}.</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link OAuth2EdgeProcessor#convertOAuth2DomainEventToDownlink(EdgeEvent, EdgeVersion)}
   */
  @Test
  @DisplayName("Test convertOAuth2DomainEventToDownlink(EdgeEvent, EdgeVersion); when 'V_3_3_0'; then return 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "org.thingsboard.server.gen.edge.v1.DownlinkMsg OAuth2EdgeProcessor.convertOAuth2DomainEventToDownlink(EdgeEvent, EdgeVersion)"})
  void testConvertOAuth2DomainEventToDownlink_whenV330_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull(oAuth2EdgeProcessor.convertOAuth2DomainEventToDownlink(new EdgeEvent(), EdgeVersion.V_3_3_0));
  }

  /**
   * Test {@link OAuth2EdgeProcessor#convertOAuth2ClientEventToDownlink(EdgeEvent, EdgeVersion)}.
   * <ul>
   *   <li>Given {@code ADDED}.</li>
   *   <li>When {@link EdgeEvent#EdgeEvent()} Action is {@code ADDED}.</li>
   * </ul>
   * <p>
   * Method under test: {@link OAuth2EdgeProcessor#convertOAuth2ClientEventToDownlink(EdgeEvent, EdgeVersion)}
   */
  @Test
  @DisplayName("Test convertOAuth2ClientEventToDownlink(EdgeEvent, EdgeVersion); given 'ADDED'; when EdgeEvent() Action is 'ADDED'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "org.thingsboard.server.gen.edge.v1.DownlinkMsg OAuth2EdgeProcessor.convertOAuth2ClientEventToDownlink(EdgeEvent, EdgeVersion)"})
  void testConvertOAuth2ClientEventToDownlink_givenAdded_whenEdgeEventActionIsAdded() {
    // Arrange
    EdgeEvent edgeEvent = new EdgeEvent();
    edgeEvent.setAction(EdgeEventActionType.ADDED);

    // Act and Assert
    assertNull(oAuth2EdgeProcessor.convertOAuth2ClientEventToDownlink(edgeEvent, EdgeVersion.V_3_3_0));
  }

  /**
   * Test {@link OAuth2EdgeProcessor#convertOAuth2ClientEventToDownlink(EdgeEvent, EdgeVersion)}.
   * <ul>
   *   <li>When {@link EdgeEvent#EdgeEvent()}.</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link OAuth2EdgeProcessor#convertOAuth2ClientEventToDownlink(EdgeEvent, EdgeVersion)}
   */
  @Test
  @DisplayName("Test convertOAuth2ClientEventToDownlink(EdgeEvent, EdgeVersion); when EdgeEvent(); then return 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "org.thingsboard.server.gen.edge.v1.DownlinkMsg OAuth2EdgeProcessor.convertOAuth2ClientEventToDownlink(EdgeEvent, EdgeVersion)"})
  void testConvertOAuth2ClientEventToDownlink_whenEdgeEvent_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull(oAuth2EdgeProcessor.convertOAuth2ClientEventToDownlink(new EdgeEvent(), EdgeVersion.V_3_3_0));
  }
}
