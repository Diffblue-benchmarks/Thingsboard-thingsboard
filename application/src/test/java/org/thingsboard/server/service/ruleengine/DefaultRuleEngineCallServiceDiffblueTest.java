package org.thingsboard.server.service.ruleengine;

import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import java.util.UUID;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.aot.DisabledInAotMode;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.thingsboard.server.cluster.TbClusterService;
import org.thingsboard.server.common.msg.queue.TbCallback;
import org.thingsboard.server.gen.transport.TransportProtos;
import org.thingsboard.server.service.queue.TbPackCallback;
import org.thingsboard.server.service.queue.TbPackProcessingContext;

@ContextConfiguration(classes = {DefaultRuleEngineCallService.class})
@ExtendWith(SpringExtension.class)
@DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_EACH_TEST_METHOD)
@DisabledInAotMode
class DefaultRuleEngineCallServiceDiffblueTest {
  @Autowired
  private DefaultRuleEngineCallService defaultRuleEngineCallService;

  @MockBean
  private TbClusterService tbClusterService;

  /**
   * Test
   * {@link DefaultRuleEngineCallService#onQueueMsg(RestApiCallResponseMsgProto, TbCallback)}.
   * <ul>
   *   <li>Then calls {@link TbPackProcessingContext#onSuccess(UUID)}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link DefaultRuleEngineCallService#onQueueMsg(TransportProtos.RestApiCallResponseMsgProto, TbCallback)}
   */
  @Test
  @DisplayName("Test onQueueMsg(RestApiCallResponseMsgProto, TbCallback); then calls onSuccess(UUID)")
  void testOnQueueMsg_thenCallsOnSuccess() {
    // Arrange
    TransportProtos.RestApiCallResponseMsgProto restApiCallResponseMsg = TransportProtos.RestApiCallResponseMsgProto
        .getDefaultInstance();
    TbPackProcessingContext<Object> ctx = mock(TbPackProcessingContext.class);
    doNothing().when(ctx).onSuccess(Mockito.<UUID>any());

    // Act
    defaultRuleEngineCallService.onQueueMsg(restApiCallResponseMsg, new TbPackCallback<>(UUID.randomUUID(), ctx));

    // Assert
    verify(ctx).onSuccess(isA(UUID.class));
  }
}
