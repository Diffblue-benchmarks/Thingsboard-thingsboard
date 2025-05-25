package org.thingsboard.server.service.subscription;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.annotation.DirtiesContext.ClassMode;

@DirtiesContext(classMode = ClassMode.AFTER_EACH_TEST_METHOD)
@ExtendWith(MockitoExtension.class)
class SubscriptionModificationResultDiffblueTest {
  @InjectMocks
  private SubscriptionModificationResult subscriptionModificationResult;

  @Mock
  private TbEntitySubEvent tbEntitySubEvent;

  /**
   * Test {@link SubscriptionModificationResult#hasEvent()}.
   * <ul>
   *   <li>Given {@link SubscriptionModificationResult} Event is {@code null}.</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SubscriptionModificationResult#hasEvent()}
   */
  @Test
  @DisplayName("Test hasEvent(); given SubscriptionModificationResult Event is 'null'; then return 'false'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean SubscriptionModificationResult.hasEvent()"})
  void testHasEvent_givenSubscriptionModificationResultEventIsNull_thenReturnFalse() {
    // Arrange
    subscriptionModificationResult.setEvent(null);

    // Act and Assert
    assertFalse(subscriptionModificationResult.hasEvent());
  }

  /**
   * Test {@link SubscriptionModificationResult#hasEvent()}.
   * <ul>
   *   <li>Given {@link TbEntitySubEvent}.</li>
   *   <li>Then return {@code true}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SubscriptionModificationResult#hasEvent()}
   */
  @Test
  @DisplayName("Test hasEvent(); given TbEntitySubEvent; then return 'true'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean SubscriptionModificationResult.hasEvent()"})
  void testHasEvent_givenTbEntitySubEvent_thenReturnTrue() {
    // Arrange, Act and Assert
    assertTrue(subscriptionModificationResult.hasEvent());
  }
}
