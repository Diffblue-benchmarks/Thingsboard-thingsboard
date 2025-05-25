package org.thingsboard.rule.engine.metadata;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import com.google.common.util.concurrent.AsyncFunction;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.UUID;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.thingsboard.server.common.data.EntityType;
import org.thingsboard.server.common.data.id.AlarmId;
import org.thingsboard.server.common.data.id.EntityId;

class TbAbstractNodeWithFetchToDiffblueTest {
  /**
   * Test {@link TbAbstractNodeWithFetchTo#checkIfEntityIsPresentOrThrow(String)}.
   * <p>
   * Method under test: {@link TbAbstractNodeWithFetchTo#checkIfEntityIsPresentOrThrow(String)}
   */
  @Test
  @DisplayName("Test checkIfEntityIsPresentOrThrow(String)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"AsyncFunction TbAbstractNodeWithFetchTo.checkIfEntityIsPresentOrThrow(String)"})
  void testCheckIfEntityIsPresentOrThrow() throws Exception {
    // Arrange
    TbFetchDeviceCredentialsNode tbFetchDeviceCredentialsNode = new TbFetchDeviceCredentialsNode();

    // Act
    AsyncFunction<EntityId, EntityId> actualCheckIfEntityIsPresentOrThrowResult = tbFetchDeviceCredentialsNode
        .checkIfEntityIsPresentOrThrow("Not all who wander are lost");
    UUID id = UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9");
    AlarmId alarmId = new AlarmId(id);
    ListenableFuture<EntityId> actualApplyResult = actualCheckIfEntityIsPresentOrThrowResult.apply(alarmId);

    // Assert
    assertNull(tbFetchDeviceCredentialsNode.config);
    assertNull(tbFetchDeviceCredentialsNode.fetchTo);
    assertEquals(EntityType.ALARM, alarmId.getEntityType());
    assertFalse(alarmId.isNullUid());
    assertTrue(actualApplyResult.isDone());
    assertSame(alarmId, actualApplyResult.get());
    assertSame(id, alarmId.getId());
  }

  /**
   * Test {@link TbAbstractNodeWithFetchTo#checkIfEntityIsPresentOrThrow(String)}.
   * <ul>
   *   <li>Then {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link TbAbstractNodeWithFetchTo#checkIfEntityIsPresentOrThrow(String)}
   */
  @Test
  @DisplayName("Test checkIfEntityIsPresentOrThrow(String); then 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"AsyncFunction TbAbstractNodeWithFetchTo.checkIfEntityIsPresentOrThrow(String)"})
  void testCheckIfEntityIsPresentOrThrow_thenNull() throws Exception {
    // Arrange
    TbFetchDeviceCredentialsNode tbFetchDeviceCredentialsNode = new TbFetchDeviceCredentialsNode();

    // Act and Assert
    assertNull(tbFetchDeviceCredentialsNode.config);
    assertNull(tbFetchDeviceCredentialsNode.fetchTo);
    assertNull(null);
    assertTrue(
        tbFetchDeviceCredentialsNode.checkIfEntityIsPresentOrThrow("Not all who wander are lost").apply(null).isDone());
  }

  /**
   * Test {@link TbAbstractNodeWithFetchTo#checkIfEntityIsPresentOrThrow(String)}.
   * <ul>
   *   <li>Then {@link TbFetchDeviceCredentialsNode} (default constructor) {@link TbAbstractNodeWithFetchTo#config} is {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link TbAbstractNodeWithFetchTo#checkIfEntityIsPresentOrThrow(String)}
   */
  @Test
  @DisplayName("Test checkIfEntityIsPresentOrThrow(String); then TbFetchDeviceCredentialsNode (default constructor) config is 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"AsyncFunction TbAbstractNodeWithFetchTo.checkIfEntityIsPresentOrThrow(String)"})
  void testCheckIfEntityIsPresentOrThrow_thenTbFetchDeviceCredentialsNodeConfigIsNull() {
    // Arrange
    TbFetchDeviceCredentialsNode tbFetchDeviceCredentialsNode = new TbFetchDeviceCredentialsNode();

    // Act
    tbFetchDeviceCredentialsNode.checkIfEntityIsPresentOrThrow("Not all who wander are lost");

    // Assert that nothing has changed
    assertNull(tbFetchDeviceCredentialsNode.config);
    assertNull(tbFetchDeviceCredentialsNode.fetchTo);
  }
}
