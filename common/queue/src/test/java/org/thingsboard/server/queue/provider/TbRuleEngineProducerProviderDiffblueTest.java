package org.thingsboard.server.queue.provider;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class TbRuleEngineProducerProviderDiffblueTest {
  @InjectMocks private TbRuleEngineProducerProvider tbRuleEngineProducerProvider;

  @Mock private TbRuleEngineQueueFactory tbRuleEngineQueueFactory;

  /**
   * Test {@link TbRuleEngineProducerProvider#init()}.
   *
   * <p>Method under test: {@link TbRuleEngineProducerProvider#init()}
   */
  @Test
  @DisplayName("Test init()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void TbRuleEngineProducerProvider.init()"})
  void testInit() {
    // Arrange
    when(tbRuleEngineQueueFactory.createTbCoreMsgProducer()).thenThrow(new RuntimeException());

    // Act and Assert
    assertThrows(RuntimeException.class, () -> tbRuleEngineProducerProvider.init());
    verify(tbRuleEngineQueueFactory).createTbCoreMsgProducer();
  }

  /**
   * Test {@link TbRuleEngineProducerProvider#getTbVersionControlMsgProducer()}.
   *
   * <p>Method under test: {@link TbRuleEngineProducerProvider#getTbVersionControlMsgProducer()}
   */
  @Test
  @DisplayName("Test getTbVersionControlMsgProducer()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "org.thingsboard.server.queue.TbQueueProducer TbRuleEngineProducerProvider.getTbVersionControlMsgProducer()"
  })
  void testGetTbVersionControlMsgProducer() {
    // Arrange, Act and Assert
    assertThrows(
        RuntimeException.class,
        () -> tbRuleEngineProducerProvider.getTbVersionControlMsgProducer());
  }
}
