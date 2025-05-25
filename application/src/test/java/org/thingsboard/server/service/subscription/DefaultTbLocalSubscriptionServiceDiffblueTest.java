package org.thingsboard.server.service.subscription;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.UUID;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;
import org.thingsboard.server.common.data.id.TenantId;

@ExtendWith(MockitoExtension.class)
class DefaultTbLocalSubscriptionServiceDiffblueTest {
  @InjectMocks
  private DefaultTbLocalSubscriptionService defaultTbLocalSubscriptionService;

  /**
   * Test {@link DefaultTbLocalSubscriptionService#getSubsLock(TenantId)}.
   * <p>
   * Method under test: {@link DefaultTbLocalSubscriptionService#getSubsLock(TenantId)}
   */
  @Test
  @DisplayName("Test getSubsLock(TenantId)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Lock DefaultTbLocalSubscriptionService.getSubsLock(TenantId)"})
  void testGetSubsLock() {
    // Arrange and Act
    Lock actualSubsLock = defaultTbLocalSubscriptionService
        .getSubsLock(new TenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")));

    // Assert
    assertTrue(actualSubsLock instanceof ReentrantLock);
    assertEquals(0, ((ReentrantLock) actualSubsLock).getHoldCount());
    assertEquals(0, ((ReentrantLock) actualSubsLock).getQueueLength());
    assertFalse(((ReentrantLock) actualSubsLock).hasQueuedThreads());
    assertFalse(((ReentrantLock) actualSubsLock).isFair());
    assertFalse(((ReentrantLock) actualSubsLock).isHeldByCurrentThread());
    assertFalse(((ReentrantLock) actualSubsLock).isLocked());
  }
}
