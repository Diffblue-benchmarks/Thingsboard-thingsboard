package org.thingsboard.rule.engine.gcp.pubsub;

import static org.mockito.Mockito.anyLong;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import com.google.cloud.pubsub.v1.Publisher;
import java.util.concurrent.TimeUnit;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class TbPubSubNodeDiffblueTest {
  @Mock private Publisher publisher;

  @InjectMocks private TbPubSubNode tbPubSubNode;

  /**
   * Test {@link TbPubSubNode#destroy()}.
   *
   * <ul>
   *   <li>Given {@link Publisher} {@link Publisher#awaitTermination(long, TimeUnit)} return {@code
   *       true}.
   *   <li>Then calls {@link Publisher#awaitTermination(long, TimeUnit)}.
   * </ul>
   *
   * <p>Method under test: {@link TbPubSubNode#destroy()}
   */
  @Test
  @DisplayName(
      "Test destroy(); given Publisher awaitTermination(long, TimeUnit) return 'true'; then calls awaitTermination(long, TimeUnit)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void TbPubSubNode.destroy()"})
  void testDestroy_givenPublisherAwaitTerminationReturnTrue_thenCallsAwaitTermination()
      throws InterruptedException {
    // Arrange
    when(publisher.awaitTermination(anyLong(), Mockito.<TimeUnit>any())).thenReturn(true);
    doNothing().when(publisher).shutdown();

    // Act
    tbPubSubNode.destroy();

    // Assert
    verify(publisher).awaitTermination(1L, TimeUnit.SECONDS);
    verify(publisher).shutdown();
  }

  /**
   * Test {@link TbPubSubNode#destroy()}.
   *
   * <ul>
   *   <li>Given {@link Publisher} {@link Publisher#shutdown()} throw {@link
   *       RuntimeException#RuntimeException()}.
   * </ul>
   *
   * <p>Method under test: {@link TbPubSubNode#destroy()}
   */
  @Test
  @DisplayName("Test destroy(); given Publisher shutdown() throw RuntimeException()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void TbPubSubNode.destroy()"})
  void testDestroy_givenPublisherShutdownThrowRuntimeException() {
    // Arrange
    doThrow(new RuntimeException()).when(publisher).shutdown();

    // Act
    tbPubSubNode.destroy();

    // Assert
    verify(publisher).shutdown();
  }
}
