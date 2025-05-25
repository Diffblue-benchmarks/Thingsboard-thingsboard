package org.thingsboard.monitoring.data.cmd;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.thingsboard.server.common.data.query.EntityDataQuery;
import org.thingsboard.server.common.data.query.EntityKey;

class EntityDataCmdDiffblueTest {
  /**
   * Test {@link EntityDataCmd#equals(Object)}, and {@link EntityDataCmd#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link EntityDataCmd#equals(Object)}
   *   <li>{@link EntityDataCmd#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean EntityDataCmd.equals(Object)", "int EntityDataCmd.hashCode()"})
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    LatestValueCmd latestCmd = new LatestValueCmd();
    latestCmd.setKeys(new ArrayList<>());

    EntityDataCmd entityDataCmd = new EntityDataCmd();
    entityDataCmd.setCmdId(1);
    entityDataCmd.setLatestCmd(latestCmd);
    entityDataCmd.setQuery(null);

    LatestValueCmd latestCmd2 = new LatestValueCmd();
    latestCmd2.setKeys(new ArrayList<>());

    EntityDataCmd entityDataCmd2 = new EntityDataCmd();
    entityDataCmd2.setCmdId(1);
    entityDataCmd2.setLatestCmd(latestCmd2);
    entityDataCmd2.setQuery(null);

    // Act and Assert
    assertEquals(entityDataCmd, entityDataCmd2);
    int expectedHashCodeResult = entityDataCmd.hashCode();
    assertEquals(expectedHashCodeResult, entityDataCmd2.hashCode());
  }

  /**
   * Test {@link EntityDataCmd#equals(Object)}, and {@link EntityDataCmd#hashCode()}.
   * <ul>
   *   <li>When other is same.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link EntityDataCmd#equals(Object)}
   *   <li>{@link EntityDataCmd#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is same; then return equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean EntityDataCmd.equals(Object)", "int EntityDataCmd.hashCode()"})
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    LatestValueCmd latestCmd = new LatestValueCmd();
    latestCmd.setKeys(new ArrayList<>());

    EntityDataCmd entityDataCmd = new EntityDataCmd();
    entityDataCmd.setCmdId(1);
    entityDataCmd.setLatestCmd(latestCmd);
    entityDataCmd.setQuery(new EntityDataQuery());

    // Act and Assert
    assertEquals(entityDataCmd, entityDataCmd);
    int expectedHashCodeResult = entityDataCmd.hashCode();
    assertEquals(expectedHashCodeResult, entityDataCmd.hashCode());
  }

  /**
   * Test {@link EntityDataCmd#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link EntityDataCmd#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean EntityDataCmd.equals(Object)", "int EntityDataCmd.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    LatestValueCmd latestCmd = new LatestValueCmd();
    latestCmd.setKeys(new ArrayList<>());

    EntityDataCmd entityDataCmd = new EntityDataCmd();
    entityDataCmd.setCmdId(1);
    entityDataCmd.setLatestCmd(latestCmd);
    entityDataCmd.setQuery(new EntityDataQuery());

    LatestValueCmd latestCmd2 = new LatestValueCmd();
    latestCmd2.setKeys(new ArrayList<>());

    EntityDataCmd entityDataCmd2 = new EntityDataCmd();
    entityDataCmd2.setCmdId(1);
    entityDataCmd2.setLatestCmd(latestCmd2);
    entityDataCmd2.setQuery(new EntityDataQuery());

    // Act and Assert
    assertNotEquals(entityDataCmd, entityDataCmd2);
  }

  /**
   * Test {@link EntityDataCmd#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link EntityDataCmd#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean EntityDataCmd.equals(Object)", "int EntityDataCmd.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    LatestValueCmd latestCmd = new LatestValueCmd();
    latestCmd.setKeys(new ArrayList<>());

    EntityDataCmd entityDataCmd = new EntityDataCmd();
    entityDataCmd.setCmdId(2);
    entityDataCmd.setLatestCmd(latestCmd);
    entityDataCmd.setQuery(new EntityDataQuery());

    LatestValueCmd latestCmd2 = new LatestValueCmd();
    latestCmd2.setKeys(new ArrayList<>());

    EntityDataCmd entityDataCmd2 = new EntityDataCmd();
    entityDataCmd2.setCmdId(1);
    entityDataCmd2.setLatestCmd(latestCmd2);
    entityDataCmd2.setQuery(new EntityDataQuery());

    // Act and Assert
    assertNotEquals(entityDataCmd, entityDataCmd2);
  }

  /**
   * Test {@link EntityDataCmd#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link EntityDataCmd#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean EntityDataCmd.equals(Object)", "int EntityDataCmd.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
    // Arrange
    LatestValueCmd latestCmd = new LatestValueCmd();
    latestCmd.setKeys(new ArrayList<>());

    EntityDataCmd entityDataCmd = new EntityDataCmd();
    entityDataCmd.setCmdId(1);
    entityDataCmd.setLatestCmd(latestCmd);
    entityDataCmd.setQuery(null);

    LatestValueCmd latestCmd2 = new LatestValueCmd();
    latestCmd2.setKeys(new ArrayList<>());

    EntityDataCmd entityDataCmd2 = new EntityDataCmd();
    entityDataCmd2.setCmdId(1);
    entityDataCmd2.setLatestCmd(latestCmd2);
    entityDataCmd2.setQuery(new EntityDataQuery());

    // Act and Assert
    assertNotEquals(entityDataCmd, entityDataCmd2);
  }

  /**
   * Test {@link EntityDataCmd#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link EntityDataCmd#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean EntityDataCmd.equals(Object)", "int EntityDataCmd.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual4() {
    // Arrange
    LatestValueCmd latestCmd = mock(LatestValueCmd.class);
    doNothing().when(latestCmd).setKeys(Mockito.<List<EntityKey>>any());
    latestCmd.setKeys(new ArrayList<>());

    EntityDataCmd entityDataCmd = new EntityDataCmd();
    entityDataCmd.setCmdId(1);
    entityDataCmd.setLatestCmd(latestCmd);
    entityDataCmd.setQuery(null);

    LatestValueCmd latestCmd2 = new LatestValueCmd();
    latestCmd2.setKeys(new ArrayList<>());

    EntityDataCmd entityDataCmd2 = new EntityDataCmd();
    entityDataCmd2.setCmdId(1);
    entityDataCmd2.setLatestCmd(latestCmd2);
    entityDataCmd2.setQuery(null);

    // Act and Assert
    assertNotEquals(entityDataCmd, entityDataCmd2);
  }

  /**
   * Test {@link EntityDataCmd#equals(Object)}.
   * <ul>
   *   <li>When other is {@code null}.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link EntityDataCmd#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is 'null'; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean EntityDataCmd.equals(Object)", "int EntityDataCmd.hashCode()"})
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange
    LatestValueCmd latestCmd = new LatestValueCmd();
    latestCmd.setKeys(new ArrayList<>());

    EntityDataCmd entityDataCmd = new EntityDataCmd();
    entityDataCmd.setCmdId(1);
    entityDataCmd.setLatestCmd(latestCmd);
    entityDataCmd.setQuery(new EntityDataQuery());

    // Act and Assert
    assertNotEquals(entityDataCmd, null);
  }

  /**
   * Test {@link EntityDataCmd#equals(Object)}.
   * <ul>
   *   <li>When other is wrong type.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link EntityDataCmd#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is wrong type; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean EntityDataCmd.equals(Object)", "int EntityDataCmd.hashCode()"})
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange
    LatestValueCmd latestCmd = new LatestValueCmd();
    latestCmd.setKeys(new ArrayList<>());

    EntityDataCmd entityDataCmd = new EntityDataCmd();
    entityDataCmd.setCmdId(1);
    entityDataCmd.setLatestCmd(latestCmd);
    entityDataCmd.setQuery(new EntityDataQuery());

    // Act and Assert
    assertNotEquals(entityDataCmd, "Different type to EntityDataCmd");
  }

  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>default or parameterless constructor of {@link EntityDataCmd}
   *   <li>{@link EntityDataCmd#setCmdId(int)}
   *   <li>{@link EntityDataCmd#setLatestCmd(LatestValueCmd)}
   *   <li>{@link EntityDataCmd#setQuery(EntityDataQuery)}
   *   <li>{@link EntityDataCmd#toString()}
   *   <li>{@link EntityDataCmd#getCmdId()}
   *   <li>{@link EntityDataCmd#getLatestCmd()}
   *   <li>{@link EntityDataCmd#getQuery()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void EntityDataCmd.<init>()", "int EntityDataCmd.getCmdId()",
      "LatestValueCmd EntityDataCmd.getLatestCmd()", "EntityDataQuery EntityDataCmd.getQuery()",
      "void EntityDataCmd.setCmdId(int)", "void EntityDataCmd.setLatestCmd(LatestValueCmd)",
      "void EntityDataCmd.setQuery(EntityDataQuery)", "String EntityDataCmd.toString()"})
  void testGettersAndSetters() {
    // Arrange and Act
    EntityDataCmd actualEntityDataCmd = new EntityDataCmd();
    actualEntityDataCmd.setCmdId(1);
    LatestValueCmd latestCmd = new LatestValueCmd();
    latestCmd.setKeys(new ArrayList<>());
    actualEntityDataCmd.setLatestCmd(latestCmd);
    EntityDataQuery query = new EntityDataQuery();
    actualEntityDataCmd.setQuery(query);
    String actualToStringResult = actualEntityDataCmd.toString();
    int actualCmdId = actualEntityDataCmd.getCmdId();
    LatestValueCmd actualLatestCmd = actualEntityDataCmd.getLatestCmd();

    // Assert
    assertEquals(
        "EntityDataCmd(cmdId=1, query=EntityDataQuery(super=AbstractDataQuery(super=EntityCountQuery(entityFilter"
            + "=null, keyFilters=null), pageLink=null, entityFields=null, latestValues=null)), latestCmd=LatestValueCmd"
            + "(keys=[]))",
        actualToStringResult);
    assertEquals(1, actualCmdId);
    assertSame(latestCmd, actualLatestCmd);
    assertSame(query, actualEntityDataCmd.getQuery());
  }
}
