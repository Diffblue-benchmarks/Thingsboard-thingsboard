package org.thingsboard.server.service.sync.vc;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.thingsboard.server.common.data.id.TenantId;

class PendingCommitDiffblueTest {
  /**
   * Test {@link PendingCommit#PendingCommit(TenantId, String, UUID, String, String, String,
   * String)}.
   *
   * <ul>
   *   <li>Then return VersionName is {@code 1.0.2}.
   * </ul>
   *
   * <p>Method under test: {@link PendingCommit#PendingCommit(TenantId, String, UUID, String,
   * String, String, String)}
   */
  @Test
  @DisplayName(
      "Test new PendingCommit(TenantId, String, UUID, String, String, String, String); then return VersionName is '1.0.2'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void PendingCommit.<init>(TenantId, String, UUID, String, String, String, String)"
  })
  void testNewPendingCommit_thenReturnVersionNameIs102() {
    // Arrange
    TenantId tenantId = new TenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    UUID txId = UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9");

    // Act
    PendingCommit actualPendingCommit =
        new PendingCommit(
            tenantId,
            "42",
            txId,
            "janedoe/featurebranch",
            "1.0.2",
            "JaneDoe",
            "jane.doe@example.org");

    // Assert
    assertEquals("1.0.2", actualPendingCommit.getVersionName());
    assertEquals("42", actualPendingCommit.getNodeId());
    assertEquals("784f394c-42b6-435a-983c-b7beff2784f9", actualPendingCommit.getWorkingBranch());
    assertEquals("JaneDoe", actualPendingCommit.getAuthorName());
    assertEquals("jane.doe@example.org", actualPendingCommit.getAuthorEmail());
    assertEquals("janedoe/featurebranch", actualPendingCommit.getBranch());
    assertTrue(actualPendingCommit.getChunkedMsgs().isEmpty());
    assertSame(tenantId, actualPendingCommit.getTenantId());
    assertSame(txId, actualPendingCommit.getTxId());
  }

  /**
   * Test {@link PendingCommit#getChunkedMsgs()}.
   *
   * <p>Method under test: {@link PendingCommit#getChunkedMsgs()}
   */
  @Test
  @DisplayName("Test getChunkedMsgs()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Map PendingCommit.getChunkedMsgs()"})
  void testGetChunkedMsgs() {
    // Arrange
    TenantId tenantId = new TenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    PendingCommit pendingCommit =
        new PendingCommit(
            tenantId,
            "42",
            UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"),
            "janedoe/featurebranch",
            "1.0.2",
            "JaneDoe",
            "jane.doe@example.org");

    // Act and Assert
    assertTrue(pendingCommit.getChunkedMsgs().isEmpty());
  }

  /**
   * Test {@link PendingCommit#getChunkedMsgs()}.
   *
   * <p>Method under test: {@link PendingCommit#getChunkedMsgs()}
   */
  @Test
  @DisplayName("Test getChunkedMsgs()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Map PendingCommit.getChunkedMsgs()"})
  void testGetChunkedMsgs2() {
    // Arrange
    TenantId tenantId = new TenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    PendingCommit pendingCommit =
        new PendingCommit(
            tenantId,
            "42",
            UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"),
            "janedoe/featurebranch",
            "1.0.2",
            "JaneDoe",
            "jane.doe@example.org");
    pendingCommit.setChunkedMsgs(new HashMap<>());

    // Act and Assert
    assertTrue(pendingCommit.getChunkedMsgs().isEmpty());
  }

  /**
   * Test {@link PendingCommit#equals(Object)}, and {@link PendingCommit#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link PendingCommit#equals(Object)}
   *   <li>{@link PendingCommit#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean PendingCommit.equals(Object)", "int PendingCommit.hashCode()"})
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    TenantId tenantId = new TenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    PendingCommit pendingCommit =
        new PendingCommit(
            tenantId,
            "42",
            UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"),
            "janedoe/featurebranch",
            "1.0.2",
            "JaneDoe",
            "jane.doe@example.org");
    TenantId tenantId2 = new TenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    PendingCommit pendingCommit2 =
        new PendingCommit(
            tenantId2,
            "42",
            UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"),
            "janedoe/featurebranch",
            "1.0.2",
            "JaneDoe",
            "jane.doe@example.org");

    // Act and Assert
    assertEquals(pendingCommit, pendingCommit2);
    assertEquals(pendingCommit.hashCode(), pendingCommit2.hashCode());
  }

  /**
   * Test {@link PendingCommit#equals(Object)}, and {@link PendingCommit#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link PendingCommit#equals(Object)}
   *   <li>{@link PendingCommit#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean PendingCommit.equals(Object)", "int PendingCommit.hashCode()"})
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual2() {
    // Arrange
    PendingCommit pendingCommit =
        new PendingCommit(
            null,
            "42",
            UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"),
            "janedoe/featurebranch",
            "1.0.2",
            "JaneDoe",
            "jane.doe@example.org");
    PendingCommit pendingCommit2 =
        new PendingCommit(
            null,
            "42",
            UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"),
            "janedoe/featurebranch",
            "1.0.2",
            "JaneDoe",
            "jane.doe@example.org");

    // Act and Assert
    assertEquals(pendingCommit, pendingCommit2);
    assertEquals(pendingCommit.hashCode(), pendingCommit2.hashCode());
  }

  /**
   * Test {@link PendingCommit#equals(Object)}, and {@link PendingCommit#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link PendingCommit#equals(Object)}
   *   <li>{@link PendingCommit#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean PendingCommit.equals(Object)", "int PendingCommit.hashCode()"})
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual3() {
    // Arrange
    TenantId tenantId = new TenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    PendingCommit pendingCommit =
        new PendingCommit(
            tenantId,
            null,
            UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"),
            "janedoe/featurebranch",
            "1.0.2",
            "JaneDoe",
            "jane.doe@example.org");
    TenantId tenantId2 = new TenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    PendingCommit pendingCommit2 =
        new PendingCommit(
            tenantId2,
            null,
            UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"),
            "janedoe/featurebranch",
            "1.0.2",
            "JaneDoe",
            "jane.doe@example.org");

    // Act and Assert
    assertEquals(pendingCommit, pendingCommit2);
    assertEquals(pendingCommit.hashCode(), pendingCommit2.hashCode());
  }

  /**
   * Test {@link PendingCommit#equals(Object)}, and {@link PendingCommit#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link PendingCommit#equals(Object)}
   *   <li>{@link PendingCommit#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean PendingCommit.equals(Object)", "int PendingCommit.hashCode()"})
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual4() {
    // Arrange
    TenantId tenantId = new TenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    PendingCommit pendingCommit =
        new PendingCommit(
            tenantId,
            "42",
            UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"),
            null,
            "1.0.2",
            "JaneDoe",
            "jane.doe@example.org");
    TenantId tenantId2 = new TenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    PendingCommit pendingCommit2 =
        new PendingCommit(
            tenantId2,
            "42",
            UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"),
            null,
            "1.0.2",
            "JaneDoe",
            "jane.doe@example.org");

    // Act and Assert
    assertEquals(pendingCommit, pendingCommit2);
    assertEquals(pendingCommit.hashCode(), pendingCommit2.hashCode());
  }

  /**
   * Test {@link PendingCommit#equals(Object)}, and {@link PendingCommit#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link PendingCommit#equals(Object)}
   *   <li>{@link PendingCommit#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean PendingCommit.equals(Object)", "int PendingCommit.hashCode()"})
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual5() {
    // Arrange
    TenantId tenantId = new TenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    PendingCommit pendingCommit =
        new PendingCommit(
            tenantId,
            "42",
            UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"),
            "janedoe/featurebranch",
            null,
            "JaneDoe",
            "jane.doe@example.org");
    TenantId tenantId2 = new TenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    PendingCommit pendingCommit2 =
        new PendingCommit(
            tenantId2,
            "42",
            UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"),
            "janedoe/featurebranch",
            null,
            "JaneDoe",
            "jane.doe@example.org");

    // Act and Assert
    assertEquals(pendingCommit, pendingCommit2);
    assertEquals(pendingCommit.hashCode(), pendingCommit2.hashCode());
  }

  /**
   * Test {@link PendingCommit#equals(Object)}, and {@link PendingCommit#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link PendingCommit#equals(Object)}
   *   <li>{@link PendingCommit#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean PendingCommit.equals(Object)", "int PendingCommit.hashCode()"})
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual6() {
    // Arrange
    TenantId tenantId = new TenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    PendingCommit pendingCommit =
        new PendingCommit(
            tenantId,
            "42",
            UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"),
            "janedoe/featurebranch",
            "1.0.2",
            null,
            "jane.doe@example.org");
    TenantId tenantId2 = new TenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    PendingCommit pendingCommit2 =
        new PendingCommit(
            tenantId2,
            "42",
            UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"),
            "janedoe/featurebranch",
            "1.0.2",
            null,
            "jane.doe@example.org");

    // Act and Assert
    assertEquals(pendingCommit, pendingCommit2);
    assertEquals(pendingCommit.hashCode(), pendingCommit2.hashCode());
  }

  /**
   * Test {@link PendingCommit#equals(Object)}, and {@link PendingCommit#hashCode()}.
   *
   * <ul>
   *   <li>When other is same.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link PendingCommit#equals(Object)}
   *   <li>{@link PendingCommit#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is same; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean PendingCommit.equals(Object)", "int PendingCommit.hashCode()"})
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    TenantId tenantId = new TenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    PendingCommit pendingCommit =
        new PendingCommit(
            tenantId,
            "42",
            UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"),
            "janedoe/featurebranch",
            "1.0.2",
            "JaneDoe",
            "jane.doe@example.org");

    // Act and Assert
    assertEquals(pendingCommit, pendingCommit);
    int expectedHashCodeResult = pendingCommit.hashCode();
    assertEquals(expectedHashCodeResult, pendingCommit.hashCode());
  }

  /**
   * Test {@link PendingCommit#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link PendingCommit#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean PendingCommit.equals(Object)", "int PendingCommit.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    TenantId tenantId = new TenantId(UUID.randomUUID());
    PendingCommit pendingCommit =
        new PendingCommit(
            tenantId,
            "42",
            UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"),
            "janedoe/featurebranch",
            "1.0.2",
            "JaneDoe",
            "jane.doe@example.org");
    TenantId tenantId2 = new TenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    // Act and Assert
    assertNotEquals(
        pendingCommit,
        new PendingCommit(
            tenantId2,
            "42",
            UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"),
            "janedoe/featurebranch",
            "1.0.2",
            "JaneDoe",
            "jane.doe@example.org"));
  }

  /**
   * Test {@link PendingCommit#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link PendingCommit#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean PendingCommit.equals(Object)", "int PendingCommit.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    PendingCommit pendingCommit =
        new PendingCommit(
            null,
            "42",
            UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"),
            "janedoe/featurebranch",
            "1.0.2",
            "JaneDoe",
            "jane.doe@example.org");
    TenantId tenantId = new TenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    // Act and Assert
    assertNotEquals(
        pendingCommit,
        new PendingCommit(
            tenantId,
            "42",
            UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"),
            "janedoe/featurebranch",
            "1.0.2",
            "JaneDoe",
            "jane.doe@example.org"));
  }

  /**
   * Test {@link PendingCommit#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link PendingCommit#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean PendingCommit.equals(Object)", "int PendingCommit.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
    // Arrange
    TenantId tenantId = new TenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    PendingCommit pendingCommit =
        new PendingCommit(
            tenantId,
            "784f394c-42b6-435a-983c-b7beff2784f9",
            UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"),
            "janedoe/featurebranch",
            "1.0.2",
            "JaneDoe",
            "jane.doe@example.org");
    TenantId tenantId2 = new TenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    // Act and Assert
    assertNotEquals(
        pendingCommit,
        new PendingCommit(
            tenantId2,
            "42",
            UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"),
            "janedoe/featurebranch",
            "1.0.2",
            "JaneDoe",
            "jane.doe@example.org"));
  }

  /**
   * Test {@link PendingCommit#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link PendingCommit#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean PendingCommit.equals(Object)", "int PendingCommit.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual4() {
    // Arrange
    TenantId tenantId = new TenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    PendingCommit pendingCommit =
        new PendingCommit(
            tenantId,
            null,
            UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"),
            "janedoe/featurebranch",
            "1.0.2",
            "JaneDoe",
            "jane.doe@example.org");
    TenantId tenantId2 = new TenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    // Act and Assert
    assertNotEquals(
        pendingCommit,
        new PendingCommit(
            tenantId2,
            "42",
            UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"),
            "janedoe/featurebranch",
            "1.0.2",
            "JaneDoe",
            "jane.doe@example.org"));
  }

  /**
   * Test {@link PendingCommit#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link PendingCommit#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean PendingCommit.equals(Object)", "int PendingCommit.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual5() {
    // Arrange
    TenantId tenantId = new TenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    PendingCommit pendingCommit =
        new PendingCommit(
            tenantId,
            "42",
            UUID.randomUUID(),
            "janedoe/featurebranch",
            "1.0.2",
            "JaneDoe",
            "jane.doe@example.org");
    TenantId tenantId2 = new TenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    // Act and Assert
    assertNotEquals(
        pendingCommit,
        new PendingCommit(
            tenantId2,
            "42",
            UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"),
            "janedoe/featurebranch",
            "1.0.2",
            "JaneDoe",
            "jane.doe@example.org"));
  }

  /**
   * Test {@link PendingCommit#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link PendingCommit#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean PendingCommit.equals(Object)", "int PendingCommit.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual6() {
    // Arrange
    TenantId tenantId = new TenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    PendingCommit pendingCommit =
        new PendingCommit(
            tenantId,
            "42",
            UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"),
            "42",
            "1.0.2",
            "JaneDoe",
            "jane.doe@example.org");
    TenantId tenantId2 = new TenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    // Act and Assert
    assertNotEquals(
        pendingCommit,
        new PendingCommit(
            tenantId2,
            "42",
            UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"),
            "janedoe/featurebranch",
            "1.0.2",
            "JaneDoe",
            "jane.doe@example.org"));
  }

  /**
   * Test {@link PendingCommit#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link PendingCommit#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean PendingCommit.equals(Object)", "int PendingCommit.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual7() {
    // Arrange
    TenantId tenantId = new TenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    PendingCommit pendingCommit =
        new PendingCommit(
            tenantId,
            "42",
            UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"),
            null,
            "1.0.2",
            "JaneDoe",
            "jane.doe@example.org");
    TenantId tenantId2 = new TenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    // Act and Assert
    assertNotEquals(
        pendingCommit,
        new PendingCommit(
            tenantId2,
            "42",
            UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"),
            "janedoe/featurebranch",
            "1.0.2",
            "JaneDoe",
            "jane.doe@example.org"));
  }

  /**
   * Test {@link PendingCommit#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link PendingCommit#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean PendingCommit.equals(Object)", "int PendingCommit.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual8() {
    // Arrange
    TenantId tenantId = new TenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    PendingCommit pendingCommit =
        new PendingCommit(
            tenantId,
            "42",
            UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"),
            "janedoe/featurebranch",
            "42",
            "JaneDoe",
            "jane.doe@example.org");
    TenantId tenantId2 = new TenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    // Act and Assert
    assertNotEquals(
        pendingCommit,
        new PendingCommit(
            tenantId2,
            "42",
            UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"),
            "janedoe/featurebranch",
            "1.0.2",
            "JaneDoe",
            "jane.doe@example.org"));
  }

  /**
   * Test {@link PendingCommit#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link PendingCommit#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean PendingCommit.equals(Object)", "int PendingCommit.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual9() {
    // Arrange
    TenantId tenantId = new TenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    PendingCommit pendingCommit =
        new PendingCommit(
            tenantId,
            "42",
            UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"),
            "janedoe/featurebranch",
            null,
            "JaneDoe",
            "jane.doe@example.org");
    TenantId tenantId2 = new TenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    // Act and Assert
    assertNotEquals(
        pendingCommit,
        new PendingCommit(
            tenantId2,
            "42",
            UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"),
            "janedoe/featurebranch",
            "1.0.2",
            "JaneDoe",
            "jane.doe@example.org"));
  }

  /**
   * Test {@link PendingCommit#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link PendingCommit#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean PendingCommit.equals(Object)", "int PendingCommit.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual10() {
    // Arrange
    TenantId tenantId = new TenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    PendingCommit pendingCommit =
        new PendingCommit(
            tenantId,
            "42",
            UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"),
            "janedoe/featurebranch",
            "1.0.2",
            "42",
            "jane.doe@example.org");
    TenantId tenantId2 = new TenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    // Act and Assert
    assertNotEquals(
        pendingCommit,
        new PendingCommit(
            tenantId2,
            "42",
            UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"),
            "janedoe/featurebranch",
            "1.0.2",
            "JaneDoe",
            "jane.doe@example.org"));
  }

  /**
   * Test {@link PendingCommit#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link PendingCommit#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean PendingCommit.equals(Object)", "int PendingCommit.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual11() {
    // Arrange
    TenantId tenantId = new TenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    PendingCommit pendingCommit =
        new PendingCommit(
            tenantId,
            "42",
            UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"),
            "janedoe/featurebranch",
            "1.0.2",
            null,
            "jane.doe@example.org");
    TenantId tenantId2 = new TenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    // Act and Assert
    assertNotEquals(
        pendingCommit,
        new PendingCommit(
            tenantId2,
            "42",
            UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"),
            "janedoe/featurebranch",
            "1.0.2",
            "JaneDoe",
            "jane.doe@example.org"));
  }

  /**
   * Test {@link PendingCommit#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link PendingCommit#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean PendingCommit.equals(Object)", "int PendingCommit.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual12() {
    // Arrange
    TenantId tenantId = new TenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    PendingCommit pendingCommit =
        new PendingCommit(
            tenantId,
            "42",
            UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"),
            "janedoe/featurebranch",
            "1.0.2",
            "JaneDoe",
            "john.smith@example.org");
    TenantId tenantId2 = new TenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    // Act and Assert
    assertNotEquals(
        pendingCommit,
        new PendingCommit(
            tenantId2,
            "42",
            UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"),
            "janedoe/featurebranch",
            "1.0.2",
            "JaneDoe",
            "jane.doe@example.org"));
  }

  /**
   * Test {@link PendingCommit#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link PendingCommit#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean PendingCommit.equals(Object)", "int PendingCommit.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual13() {
    // Arrange
    TenantId tenantId = new TenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    PendingCommit pendingCommit =
        new PendingCommit(
            tenantId,
            "42",
            UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"),
            "janedoe/featurebranch",
            "1.0.2",
            "JaneDoe",
            null);
    TenantId tenantId2 = new TenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    // Act and Assert
    assertNotEquals(
        pendingCommit,
        new PendingCommit(
            tenantId2,
            "42",
            UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"),
            "janedoe/featurebranch",
            "1.0.2",
            "JaneDoe",
            "jane.doe@example.org"));
  }

  /**
   * Test {@link PendingCommit#equals(Object)}.
   *
   * <ul>
   *   <li>When other is {@code null}.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link PendingCommit#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is 'null'; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean PendingCommit.equals(Object)", "int PendingCommit.hashCode()"})
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange
    TenantId tenantId = new TenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    // Act and Assert
    assertNotEquals(
        new PendingCommit(
            tenantId,
            "42",
            UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"),
            "janedoe/featurebranch",
            "1.0.2",
            "JaneDoe",
            "jane.doe@example.org"),
        null);
  }

  /**
   * Test {@link PendingCommit#equals(Object)}.
   *
   * <ul>
   *   <li>When other is wrong type.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link PendingCommit#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is wrong type; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean PendingCommit.equals(Object)", "int PendingCommit.hashCode()"})
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange
    TenantId tenantId = new TenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    // Act and Assert
    assertNotEquals(
        new PendingCommit(
            tenantId,
            "42",
            UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"),
            "janedoe/featurebranch",
            "1.0.2",
            "JaneDoe",
            "jane.doe@example.org"),
        "Different type to PendingCommit");
  }

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
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
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "String PendingCommit.getAuthorEmail()",
    "String PendingCommit.getAuthorName()",
    "String PendingCommit.getBranch()",
    "String PendingCommit.getNodeId()",
    "TenantId PendingCommit.getTenantId()",
    "UUID PendingCommit.getTxId()",
    "String PendingCommit.getVersionName()",
    "String PendingCommit.getWorkingBranch()",
    "void PendingCommit.setAuthorEmail(String)",
    "void PendingCommit.setAuthorName(String)",
    "void PendingCommit.setBranch(String)",
    "void PendingCommit.setChunkedMsgs(Map)",
    "void PendingCommit.setVersionName(String)",
    "String PendingCommit.toString()"
  })
  void testGettersAndSetters() {
    // Arrange
    TenantId tenantId = new TenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    UUID txId = UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9");

    PendingCommit pendingCommit =
        new PendingCommit(
            tenantId,
            "42",
            txId,
            "janedoe/featurebranch",
            "1.0.2",
            "JaneDoe",
            "jane.doe@example.org");

    // Act
    pendingCommit.setAuthorEmail("jane.doe@example.org");
    pendingCommit.setAuthorName("JaneDoe");
    pendingCommit.setBranch("janedoe/featurebranch");
    pendingCommit.setChunkedMsgs(new HashMap<>());
    pendingCommit.setVersionName("1.0.2");
    String actualToStringResult = pendingCommit.toString();
    String actualAuthorEmail = pendingCommit.getAuthorEmail();
    String actualAuthorName = pendingCommit.getAuthorName();
    String actualBranch = pendingCommit.getBranch();
    String actualNodeId = pendingCommit.getNodeId();
    TenantId actualTenantId = pendingCommit.getTenantId();
    UUID actualTxId = pendingCommit.getTxId();
    String actualVersionName = pendingCommit.getVersionName();

    // Assert
    assertEquals("1.0.2", actualVersionName);
    assertEquals("42", actualNodeId);
    assertEquals("784f394c-42b6-435a-983c-b7beff2784f9", actualTxId.toString());
    assertEquals("784f394c-42b6-435a-983c-b7beff2784f9", pendingCommit.getWorkingBranch());
    assertEquals("JaneDoe", actualAuthorName);
    assertEquals(
        "PendingCommit(txId=784f394c-42b6-435a-983c-b7beff2784f9, nodeId=42, tenantId=784f394c-42b6-435a-983c"
            + "-b7beff2784f9, workingBranch=784f394c-42b6-435a-983c-b7beff2784f9, branch=janedoe/featurebranch,"
            + " versionName=1.0.2, authorName=JaneDoe, authorEmail=jane.doe@example.org, chunkedMsgs={})",
        actualToStringResult);
    assertEquals("jane.doe@example.org", actualAuthorEmail);
    assertEquals("janedoe/featurebranch", actualBranch);
    assertSame(tenantId, actualTenantId);
    assertSame(txId, actualTxId);
  }
}
