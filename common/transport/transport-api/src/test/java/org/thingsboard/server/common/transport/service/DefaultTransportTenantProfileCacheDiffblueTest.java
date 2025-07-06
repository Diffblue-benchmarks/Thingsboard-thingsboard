package org.thingsboard.server.common.transport.service;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.UUID;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.annotation.DirtiesContext.ClassMode;
import org.thingsboard.server.common.data.id.TenantId;
import org.thingsboard.server.common.data.id.TenantProfileId;

@DirtiesContext(classMode = ClassMode.AFTER_EACH_TEST_METHOD)
@ExtendWith(MockitoExtension.class)
class DefaultTransportTenantProfileCacheDiffblueTest {
  @InjectMocks private DefaultTransportTenantProfileCache defaultTransportTenantProfileCache;

  /**
   * Test {@link DefaultTransportTenantProfileCache#put(TenantId, TenantProfileId)} with {@code
   * tenantId}, {@code profileId}.
   *
   * <ul>
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link DefaultTransportTenantProfileCache#put(TenantId, TenantProfileId)}
   */
  @Test
  @DisplayName(
      "Test put(TenantId, TenantProfileId) with 'tenantId', 'profileId'; then return 'false'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean DefaultTransportTenantProfileCache.put(TenantId, TenantProfileId)"})
  void testPutWithTenantIdProfileId_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse(
        defaultTransportTenantProfileCache.put(
            new TenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")), null));
  }

  /**
   * Test {@link DefaultTransportTenantProfileCache#remove(TenantProfileId)}.
   *
   * <ul>
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link DefaultTransportTenantProfileCache#remove(TenantProfileId)}
   */
  @Test
  @DisplayName("Test remove(TenantProfileId); then return 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"java.util.Set DefaultTransportTenantProfileCache.remove(TenantProfileId)"})
  void testRemove_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull(
        defaultTransportTenantProfileCache.remove(
            new TenantProfileId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"))));
  }
}
