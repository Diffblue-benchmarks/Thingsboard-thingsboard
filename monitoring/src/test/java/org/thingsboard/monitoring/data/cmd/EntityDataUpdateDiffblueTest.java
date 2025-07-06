package org.thingsboard.monitoring.data.cmd;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.thingsboard.server.common.data.id.AlarmId;
import org.thingsboard.server.common.data.query.EntityData;
import org.thingsboard.server.common.data.query.EntityKeyType;
import org.thingsboard.server.common.data.query.TsValue;

class EntityDataUpdateDiffblueTest {
  /**
   * Test {@link EntityDataUpdate#getLatest(UUID, String)}.
   *
   * <ul>
   *   <li>Given {@link AlarmId#AlarmId(UUID)} with id is fromString {@code
   *       784f394c-42b6-435a-983c-b7beff2784f9}.
   * </ul>
   *
   * <p>Method under test: {@link EntityDataUpdate#getLatest(UUID, String)}
   */
  @Test
  @DisplayName(
      "Test getLatest(UUID, String); given AlarmId(UUID) with id is fromString '784f394c-42b6-435a-983c-b7beff2784f9'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String EntityDataUpdate.getLatest(UUID, String)"})
  void testGetLatest_givenAlarmIdWithIdIsFromString784f394c42b6435a983cB7beff2784f9() {
    // Arrange
    ArrayList<EntityData> update = new ArrayList<>();
    AlarmId entityId = new AlarmId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    HashMap<EntityKeyType, Map<String, TsValue>> latest = new HashMap<>();
    update.add(new EntityData(entityId, latest, new HashMap<>()));

    EntityDataUpdate entityDataUpdate = new EntityDataUpdate();
    entityDataUpdate.setUpdate(update);

    // Act and Assert
    assertNull(
        entityDataUpdate.getLatest(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"), "Key"));
  }

  /**
   * Test {@link EntityDataUpdate#getLatest(UUID, String)}.
   *
   * <ul>
   *   <li>Given {@link AlarmId#AlarmId(UUID)} with id is randomUUID.
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link EntityDataUpdate#getLatest(UUID, String)}
   */
  @Test
  @DisplayName(
      "Test getLatest(UUID, String); given AlarmId(UUID) with id is randomUUID; then return 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String EntityDataUpdate.getLatest(UUID, String)"})
  void testGetLatest_givenAlarmIdWithIdIsRandomUUID_thenReturnNull() {
    // Arrange
    ArrayList<EntityData> update = new ArrayList<>();
    AlarmId entityId = new AlarmId(UUID.randomUUID());
    HashMap<EntityKeyType, Map<String, TsValue>> latest = new HashMap<>();
    update.add(new EntityData(entityId, latest, new HashMap<>()));

    EntityDataUpdate entityDataUpdate = new EntityDataUpdate();
    entityDataUpdate.setUpdate(update);

    // Act and Assert
    assertNull(
        entityDataUpdate.getLatest(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"), "Key"));
  }

  /**
   * Test {@link EntityDataUpdate#getLatest(UUID, String)}.
   *
   * <ul>
   *   <li>Given {@link EntityDataUpdate} (default constructor) Update is {@link
   *       ArrayList#ArrayList()}.
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link EntityDataUpdate#getLatest(UUID, String)}
   */
  @Test
  @DisplayName(
      "Test getLatest(UUID, String); given EntityDataUpdate (default constructor) Update is ArrayList(); then return 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String EntityDataUpdate.getLatest(UUID, String)"})
  void testGetLatest_givenEntityDataUpdateUpdateIsArrayList_thenReturnNull() {
    // Arrange
    EntityDataUpdate entityDataUpdate = new EntityDataUpdate();
    entityDataUpdate.setUpdate(new ArrayList<>());

    // Act and Assert
    assertNull(
        entityDataUpdate.getLatest(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"), "Key"));
  }

  /**
   * Test {@link EntityDataUpdate#getLatest(UUID, String)}.
   *
   * <ul>
   *   <li>Given {@link EntityDataUpdate} (default constructor).
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link EntityDataUpdate#getLatest(UUID, String)}
   */
  @Test
  @DisplayName(
      "Test getLatest(UUID, String); given EntityDataUpdate (default constructor); then return 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String EntityDataUpdate.getLatest(UUID, String)"})
  void testGetLatest_givenEntityDataUpdate_thenReturnNull() {
    // Arrange
    EntityDataUpdate entityDataUpdate = new EntityDataUpdate();

    // Act and Assert
    assertNull(
        entityDataUpdate.getLatest(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"), "Key"));
  }

  /**
   * Test {@link EntityDataUpdate#getLatest(UUID, String)}.
   *
   * <ul>
   *   <li>Given {@link HashMap#HashMap()} {@code TIME_SERIES} is {@link HashMap#HashMap()}.
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link EntityDataUpdate#getLatest(UUID, String)}
   */
  @Test
  @DisplayName(
      "Test getLatest(UUID, String); given HashMap() 'TIME_SERIES' is HashMap(); then return 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String EntityDataUpdate.getLatest(UUID, String)"})
  void testGetLatest_givenHashMapTimeSeriesIsHashMap_thenReturnNull() {
    // Arrange
    HashMap<EntityKeyType, Map<String, TsValue>> latest = new HashMap<>();
    latest.put(EntityKeyType.TIME_SERIES, new HashMap<>());
    AlarmId entityId = new AlarmId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    EntityData entityData = new EntityData(entityId, latest, new HashMap<>());

    ArrayList<EntityData> update = new ArrayList<>();
    update.add(entityData);

    EntityDataUpdate entityDataUpdate = new EntityDataUpdate();
    entityDataUpdate.setUpdate(update);

    // Act and Assert
    assertNull(
        entityDataUpdate.getLatest(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"), "Key"));
  }

  /**
   * Test {@link EntityDataUpdate#equals(Object)}, and {@link EntityDataUpdate#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link EntityDataUpdate#equals(Object)}
   *   <li>{@link EntityDataUpdate#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean EntityDataUpdate.equals(Object)", "int EntityDataUpdate.hashCode()"})
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    EntityDataUpdate entityDataUpdate = new EntityDataUpdate();
    entityDataUpdate.setUpdate(new ArrayList<>());

    EntityDataUpdate entityDataUpdate2 = new EntityDataUpdate();
    entityDataUpdate2.setUpdate(new ArrayList<>());

    // Act and Assert
    assertEquals(entityDataUpdate, entityDataUpdate2);
    int expectedHashCodeResult = entityDataUpdate.hashCode();
    assertEquals(expectedHashCodeResult, entityDataUpdate2.hashCode());
  }

  /**
   * Test {@link EntityDataUpdate#equals(Object)}, and {@link EntityDataUpdate#hashCode()}.
   *
   * <ul>
   *   <li>When other is same.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link EntityDataUpdate#equals(Object)}
   *   <li>{@link EntityDataUpdate#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is same; then return equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean EntityDataUpdate.equals(Object)", "int EntityDataUpdate.hashCode()"})
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    EntityDataUpdate entityDataUpdate = new EntityDataUpdate();
    entityDataUpdate.setUpdate(new ArrayList<>());

    // Act and Assert
    assertEquals(entityDataUpdate, entityDataUpdate);
    int expectedHashCodeResult = entityDataUpdate.hashCode();
    assertEquals(expectedHashCodeResult, entityDataUpdate.hashCode());
  }

  /**
   * Test {@link EntityDataUpdate#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link EntityDataUpdate#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean EntityDataUpdate.equals(Object)", "int EntityDataUpdate.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    ArrayList<EntityData> update = new ArrayList<>();
    HashMap<EntityKeyType, Map<String, TsValue>> latest = new HashMap<>();
    update.add(new EntityData(null, latest, new HashMap<>()));

    EntityDataUpdate entityDataUpdate = new EntityDataUpdate();
    entityDataUpdate.setUpdate(update);

    EntityDataUpdate entityDataUpdate2 = new EntityDataUpdate();
    entityDataUpdate2.setUpdate(new ArrayList<>());

    // Act and Assert
    assertNotEquals(entityDataUpdate, entityDataUpdate2);
  }

  /**
   * Test {@link EntityDataUpdate#equals(Object)}.
   *
   * <ul>
   *   <li>When other is {@code null}.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link EntityDataUpdate#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is 'null'; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean EntityDataUpdate.equals(Object)", "int EntityDataUpdate.hashCode()"})
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange
    EntityDataUpdate entityDataUpdate = new EntityDataUpdate();
    entityDataUpdate.setUpdate(new ArrayList<>());

    // Act and Assert
    assertNotEquals(entityDataUpdate, null);
  }

  /**
   * Test {@link EntityDataUpdate#equals(Object)}.
   *
   * <ul>
   *   <li>When other is wrong type.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link EntityDataUpdate#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is wrong type; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean EntityDataUpdate.equals(Object)", "int EntityDataUpdate.hashCode()"})
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange
    EntityDataUpdate entityDataUpdate = new EntityDataUpdate();
    entityDataUpdate.setUpdate(new ArrayList<>());

    // Act and Assert
    assertNotEquals(entityDataUpdate, "Different type to EntityDataUpdate");
  }

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>default or parameterless constructor of {@link EntityDataUpdate}
   *   <li>{@link EntityDataUpdate#setUpdate(List)}
   *   <li>{@link EntityDataUpdate#toString()}
   *   <li>{@link EntityDataUpdate#getUpdate()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void EntityDataUpdate.<init>()",
    "List EntityDataUpdate.getUpdate()",
    "void EntityDataUpdate.setUpdate(List)",
    "String EntityDataUpdate.toString()"
  })
  void testGettersAndSetters() {
    // Arrange and Act
    EntityDataUpdate actualEntityDataUpdate = new EntityDataUpdate();
    ArrayList<EntityData> update = new ArrayList<>();
    actualEntityDataUpdate.setUpdate(update);
    String actualToStringResult = actualEntityDataUpdate.toString();
    List<EntityData> actualUpdate = actualEntityDataUpdate.getUpdate();

    // Assert
    assertEquals("EntityDataUpdate(update=[])", actualToStringResult);
    assertTrue(actualUpdate.isEmpty());
    assertSame(update, actualUpdate);
  }
}
