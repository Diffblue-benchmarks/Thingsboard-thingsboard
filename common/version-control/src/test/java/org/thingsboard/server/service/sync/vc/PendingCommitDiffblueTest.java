package org.thingsboard.server.service.sync.vc;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;
import java.util.function.BiFunction;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.thingsboard.server.common.data.id.TenantId;

class PendingCommitDiffblueTest {
  /**
   * Test
   * {@link PendingCommit#PendingCommit(TenantId, String, UUID, String, String, String, String)}.
   * <ul>
   *   <li>When randomUUID.</li>
   *   <li>Then return VersionName is {@code 1.0.2}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link PendingCommit#PendingCommit(TenantId, String, UUID, String, String, String, String)}
   */
  @Test
  @DisplayName("Test new PendingCommit(TenantId, String, UUID, String, String, String, String); when randomUUID; then return VersionName is '1.0.2'")
  void testNewPendingCommit_whenRandomUUID_thenReturnVersionNameIs102() {
    // Arrange
    TenantId tenantId = new TenantId(UUID.randomUUID());
    UUID txId = UUID.randomUUID();

    // Act
    PendingCommit actualPendingCommit = new PendingCommit(tenantId, "42", txId, "janedoe/featurebranch", "1.0.2",
        "JaneDoe", "jane.doe@example.org");

    // Assert
    assertEquals("1.0.2", actualPendingCommit.getVersionName());
    assertEquals("42", actualPendingCommit.getNodeId());
    assertEquals("JaneDoe", actualPendingCommit.getAuthorName());
    assertEquals("jane.doe@example.org", actualPendingCommit.getAuthorEmail());
    assertEquals("janedoe/featurebranch", actualPendingCommit.getBranch());
    assertTrue(actualPendingCommit.getChunkedMsgs().isEmpty());
    assertSame(tenantId, actualPendingCommit.getTenantId());
    assertSame(txId, actualPendingCommit.getTxId());
  }

  /**
   * Test {@link PendingCommit#getChunkedMsgs()}.
   * <p>
   * Method under test: {@link PendingCommit#getChunkedMsgs()}
   */
  @Test
  @DisplayName("Test getChunkedMsgs()")
  void testGetChunkedMsgs() {
    // Arrange
    TenantId tenantId = new TenantId(UUID.randomUUID());

    // Act and Assert
    assertTrue((new PendingCommit(tenantId, "42", UUID.randomUUID(), "janedoe/featurebranch", "1.0.2", "JaneDoe",
        "jane.doe@example.org")).getChunkedMsgs().isEmpty());
  }

  /**
   * Test {@link PendingCommit#getChunkedMsgs()}.
   * <p>
   * Method under test: {@link PendingCommit#getChunkedMsgs()}
   */
  @Test
  @DisplayName("Test getChunkedMsgs()")
  void testGetChunkedMsgs2() {
    // Arrange
    TenantId tenantId = new TenantId(UUID.randomUUID());

    PendingCommit pendingCommit = new PendingCommit(tenantId, "42", UUID.randomUUID(), "janedoe/featurebranch", "1.0.2",
        "JaneDoe", "jane.doe@example.org");
    pendingCommit.setChunkedMsgs(new HashMap<>());

    // Act and Assert
    assertTrue(pendingCommit.getChunkedMsgs().isEmpty());
  }

  /**
   * Test {@link PendingCommit#getChunkedMsgs()}.
   * <ul>
   *   <li>Given {@link HashMap#HashMap()} computeIfPresent {@code foo} and
   * {@link BiFunction}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PendingCommit#getChunkedMsgs()}
   */
  @Test
  @DisplayName("Test getChunkedMsgs(); given HashMap() computeIfPresent 'foo' and BiFunction")
  void testGetChunkedMsgs_givenHashMapComputeIfPresentFooAndBiFunction() {
    // Arrange
    HashMap<String, String[]> chunkedMsgs = new HashMap<>();
    chunkedMsgs.computeIfPresent("foo", mock(BiFunction.class));
    TenantId tenantId = new TenantId(UUID.randomUUID());

    PendingCommit pendingCommit = new PendingCommit(tenantId, "42", UUID.randomUUID(), "janedoe/featurebranch", "1.0.2",
        "JaneDoe", "jane.doe@example.org");
    pendingCommit.setChunkedMsgs(chunkedMsgs);

    // Act and Assert
    assertTrue(pendingCommit.getChunkedMsgs().isEmpty());
  }

  /**
   * Test {@link PendingCommit#equals(Object)}, and
   * {@link PendingCommit#hashCode()}.
   * <ul>
   *   <li>When other is same.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link PendingCommit#equals(Object)}
   *   <li>{@link PendingCommit#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is same; then return equal")
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    TenantId tenantId = new TenantId(UUID.randomUUID());
    PendingCommit pendingCommit = new PendingCommit(tenantId, "42", UUID.randomUUID(), "janedoe/featurebranch", "1.0.2",
        "JaneDoe", "jane.doe@example.org");

    // Act and Assert
    assertEquals(pendingCommit, pendingCommit);
    int expectedHashCodeResult = pendingCommit.hashCode();
    assertEquals(expectedHashCodeResult, pendingCommit.hashCode());
  }

  /**
   * Test {@link PendingCommit#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link PendingCommit#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    TenantId tenantId = new TenantId(UUID.randomUUID());
    PendingCommit pendingCommit = new PendingCommit(tenantId, "42", UUID.randomUUID(), "janedoe/featurebranch", "1.0.2",
        "JaneDoe", "jane.doe@example.org");
    TenantId tenantId2 = new TenantId(UUID.randomUUID());

    // Act and Assert
    assertNotEquals(pendingCommit, new PendingCommit(tenantId2, "42", UUID.randomUUID(), "janedoe/featurebranch",
        "1.0.2", "JaneDoe", "jane.doe@example.org"));
  }

  /**
   * Test {@link PendingCommit#equals(Object)}.
   * <ul>
   *   <li>When other is {@code null}.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link PendingCommit#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is 'null'; then return not equal")
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange
    TenantId tenantId = new TenantId(UUID.randomUUID());

    // Act and Assert
    assertNotEquals(new PendingCommit(tenantId, "42", UUID.randomUUID(), "janedoe/featurebranch", "1.0.2", "JaneDoe",
        "jane.doe@example.org"), null);
  }

  /**
   * Test {@link PendingCommit#equals(Object)}.
   * <ul>
   *   <li>When other is wrong type.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link PendingCommit#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is wrong type; then return not equal")
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange
    TenantId tenantId = new TenantId(UUID.randomUUID());

    // Act and Assert
    assertNotEquals(new PendingCommit(tenantId, "42", UUID.randomUUID(), "janedoe/featurebranch", "1.0.2", "JaneDoe",
        "jane.doe@example.org"), "Different type to PendingCommit");
  }

  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link PendingCommit#setAuthorEmail(String)}
   *   <li>{@link PendingCommit#setAuthorName(String)}
   *   <li>{@link PendingCommit#setBranch(String)}
   *   <li>{@link PendingCommit#setChunkedMsgs(Map)}
   *   <li>{@link PendingCommit#setVersionName(String)}
   *   <li>{@link PendingCommit#toString()}
   *   <li>{@link PendingCommit#getAuthorEmail()}
   *   <li>{@link PendingCommit#getAuthorName()}
   *   <li>{@link PendingCommit#getBranch()}
   *   <li>{@link PendingCommit#getNodeId()}
   *   <li>{@link PendingCommit#getTenantId()}
   *   <li>{@link PendingCommit#getTxId()}
   *   <li>{@link PendingCommit#getVersionName()}
   *   <li>{@link PendingCommit#getWorkingBranch()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  void testGettersAndSetters() {
    // Arrange
    TenantId tenantId = new TenantId(UUID.randomUUID());
    UUID txId = UUID.randomUUID();
    PendingCommit pendingCommit = new PendingCommit(tenantId, "42", txId, "janedoe/featurebranch", "1.0.2", "JaneDoe",
        "jane.doe@example.org");

    // Act
    pendingCommit.setAuthorEmail("jane.doe@example.org");
    pendingCommit.setAuthorName("JaneDoe");
    pendingCommit.setBranch("janedoe/featurebranch");
    pendingCommit.setChunkedMsgs(new HashMap<>());
    pendingCommit.setVersionName("1.0.2");
    pendingCommit.toString();
    String actualAuthorEmail = pendingCommit.getAuthorEmail();
    String actualAuthorName = pendingCommit.getAuthorName();
    String actualBranch = pendingCommit.getBranch();
    String actualNodeId = pendingCommit.getNodeId();
    TenantId actualTenantId = pendingCommit.getTenantId();
    UUID actualTxId = pendingCommit.getTxId();
    String actualVersionName = pendingCommit.getVersionName();
    pendingCommit.getWorkingBranch();

    // Assert that nothing has changed
    assertEquals("1.0.2", actualVersionName);
    assertEquals("42", actualNodeId);
    assertEquals("JaneDoe", actualAuthorName);
    assertEquals("jane.doe@example.org", actualAuthorEmail);
    assertEquals("janedoe/featurebranch", actualBranch);
    assertSame(tenantId, actualTenantId);
    assertSame(txId, actualTxId);
  }
}
