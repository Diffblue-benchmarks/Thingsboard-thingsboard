package org.thingsboard.rule.engine.metadata;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.thingsboard.rule.engine.data.RelationsQuery;
import org.thingsboard.rule.engine.util.TbMsgSource;
import org.thingsboard.server.common.data.relation.EntitySearchDirection;
import org.thingsboard.server.common.data.relation.RelationEntityTypeFilter;

class TbGetRelatedDataNodeConfigurationDiffblueTest {
  /**
   * Test {@link TbGetRelatedDataNodeConfiguration#defaultConfiguration()}.
   *
   * <p>Method under test: {@link TbGetRelatedDataNodeConfiguration#defaultConfiguration()}
   */
  @Test
  @DisplayName("Test defaultConfiguration()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "TbGetRelatedDataNodeConfiguration TbGetRelatedDataNodeConfiguration.defaultConfiguration()"
  })
  void testDefaultConfiguration() {
    // Arrange and Act
    TbGetRelatedDataNodeConfiguration actualDefaultConfigurationResult =
        new TbGetRelatedDataNodeConfiguration().defaultConfiguration();

    // Assert
    RelationsQuery relationsQuery = actualDefaultConfigurationResult.getRelationsQuery();
    List<RelationEntityTypeFilter> filters = relationsQuery.getFilters();
    assertEquals(1, filters.size());
    RelationEntityTypeFilter getResult = filters.get(0);
    assertEquals("Contains", getResult.getRelationType());
    Map<String, String> dataMapping = actualDefaultConfigurationResult.getDataMapping();
    assertEquals(1, dataMapping.size());
    assertEquals("sn", dataMapping.get("serialNumber"));
    assertEquals(1, relationsQuery.getMaxLevel());
    assertEquals(DataToFetch.ATTRIBUTES, actualDefaultConfigurationResult.getDataToFetch());
    assertEquals(TbMsgSource.METADATA, actualDefaultConfigurationResult.getFetchTo());
    assertEquals(EntitySearchDirection.FROM, relationsQuery.getDirection());
    assertFalse(relationsQuery.isFetchLastLevelOnly());
    assertFalse(getResult.isNegate());
    assertTrue(getResult.getEntityTypes().isEmpty());
  }

  /**
   * Test {@link TbGetRelatedDataNodeConfiguration#equals(Object)}, and {@link
   * TbGetRelatedDataNodeConfiguration#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link TbGetRelatedDataNodeConfiguration#equals(Object)}
   *   <li>{@link TbGetRelatedDataNodeConfiguration#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean TbGetRelatedDataNodeConfiguration.equals(Object)",
    "int TbGetRelatedDataNodeConfiguration.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    TbGetRelatedDataNodeConfiguration tbGetRelatedDataNodeConfiguration =
        new TbGetRelatedDataNodeConfiguration();
    TbGetRelatedDataNodeConfiguration tbGetRelatedDataNodeConfiguration2 =
        new TbGetRelatedDataNodeConfiguration();

    // Act and Assert
    assertEquals(tbGetRelatedDataNodeConfiguration, tbGetRelatedDataNodeConfiguration2);
    int expectedHashCodeResult = tbGetRelatedDataNodeConfiguration.hashCode();
    assertEquals(expectedHashCodeResult, tbGetRelatedDataNodeConfiguration2.hashCode());
  }

  /**
   * Test {@link TbGetRelatedDataNodeConfiguration#equals(Object)}, and {@link
   * TbGetRelatedDataNodeConfiguration#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link TbGetRelatedDataNodeConfiguration#equals(Object)}
   *   <li>{@link TbGetRelatedDataNodeConfiguration#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean TbGetRelatedDataNodeConfiguration.equals(Object)",
    "int TbGetRelatedDataNodeConfiguration.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual2() {
    // Arrange
    RelationsQuery relationsQuery = new RelationsQuery();
    relationsQuery.setDirection(EntitySearchDirection.FROM);
    relationsQuery.setFetchLastLevelOnly(true);
    relationsQuery.setFilters(new ArrayList<>());
    relationsQuery.setMaxLevel(3);

    TbGetRelatedDataNodeConfiguration tbGetRelatedDataNodeConfiguration =
        new TbGetRelatedDataNodeConfiguration();
    tbGetRelatedDataNodeConfiguration.setRelationsQuery(relationsQuery);

    RelationsQuery relationsQuery2 = new RelationsQuery();
    relationsQuery2.setDirection(EntitySearchDirection.FROM);
    relationsQuery2.setFetchLastLevelOnly(true);
    relationsQuery2.setFilters(new ArrayList<>());
    relationsQuery2.setMaxLevel(3);

    TbGetRelatedDataNodeConfiguration tbGetRelatedDataNodeConfiguration2 =
        new TbGetRelatedDataNodeConfiguration();
    tbGetRelatedDataNodeConfiguration2.setRelationsQuery(relationsQuery2);

    // Act and Assert
    assertEquals(tbGetRelatedDataNodeConfiguration, tbGetRelatedDataNodeConfiguration2);
    int expectedHashCodeResult = tbGetRelatedDataNodeConfiguration.hashCode();
    assertEquals(expectedHashCodeResult, tbGetRelatedDataNodeConfiguration2.hashCode());
  }

  /**
   * Test {@link TbGetRelatedDataNodeConfiguration#equals(Object)}, and {@link
   * TbGetRelatedDataNodeConfiguration#hashCode()}.
   *
   * <ul>
   *   <li>When other is same.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link TbGetRelatedDataNodeConfiguration#equals(Object)}
   *   <li>{@link TbGetRelatedDataNodeConfiguration#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is same; then return equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean TbGetRelatedDataNodeConfiguration.equals(Object)",
    "int TbGetRelatedDataNodeConfiguration.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    TbGetRelatedDataNodeConfiguration tbGetRelatedDataNodeConfiguration =
        new TbGetRelatedDataNodeConfiguration();

    // Act and Assert
    assertEquals(tbGetRelatedDataNodeConfiguration, tbGetRelatedDataNodeConfiguration);
    int expectedHashCodeResult = tbGetRelatedDataNodeConfiguration.hashCode();
    assertEquals(expectedHashCodeResult, tbGetRelatedDataNodeConfiguration.hashCode());
  }

  /**
   * Test {@link TbGetRelatedDataNodeConfiguration#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link TbGetRelatedDataNodeConfiguration#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean TbGetRelatedDataNodeConfiguration.equals(Object)",
    "int TbGetRelatedDataNodeConfiguration.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new TbGetRelatedDataNodeConfiguration(), 1);
  }

  /**
   * Test {@link TbGetRelatedDataNodeConfiguration#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link TbGetRelatedDataNodeConfiguration#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean TbGetRelatedDataNodeConfiguration.equals(Object)",
    "int TbGetRelatedDataNodeConfiguration.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    RelationsQuery relationsQuery = new RelationsQuery();
    relationsQuery.setDirection(EntitySearchDirection.FROM);
    relationsQuery.setFetchLastLevelOnly(true);
    relationsQuery.setFilters(new ArrayList<>());
    relationsQuery.setMaxLevel(3);

    TbGetRelatedDataNodeConfiguration tbGetRelatedDataNodeConfiguration =
        new TbGetRelatedDataNodeConfiguration();
    tbGetRelatedDataNodeConfiguration.setRelationsQuery(relationsQuery);

    // Act and Assert
    assertNotEquals(tbGetRelatedDataNodeConfiguration, new TbGetRelatedDataNodeConfiguration());
  }

  /**
   * Test {@link TbGetRelatedDataNodeConfiguration#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link TbGetRelatedDataNodeConfiguration#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean TbGetRelatedDataNodeConfiguration.equals(Object)",
    "int TbGetRelatedDataNodeConfiguration.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
    // Arrange
    TbGetRelatedDataNodeConfiguration tbGetRelatedDataNodeConfiguration =
        new TbGetRelatedDataNodeConfiguration();
    tbGetRelatedDataNodeConfiguration.setDataToFetch(DataToFetch.ATTRIBUTES);

    // Act and Assert
    assertNotEquals(tbGetRelatedDataNodeConfiguration, new TbGetRelatedDataNodeConfiguration());
  }

  /**
   * Test {@link TbGetRelatedDataNodeConfiguration#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link TbGetRelatedDataNodeConfiguration#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean TbGetRelatedDataNodeConfiguration.equals(Object)",
    "int TbGetRelatedDataNodeConfiguration.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual4() {
    // Arrange
    TbGetRelatedDataNodeConfiguration tbGetRelatedDataNodeConfiguration =
        new TbGetRelatedDataNodeConfiguration();

    RelationsQuery relationsQuery = new RelationsQuery();
    relationsQuery.setDirection(EntitySearchDirection.FROM);
    relationsQuery.setFetchLastLevelOnly(true);
    relationsQuery.setFilters(new ArrayList<>());
    relationsQuery.setMaxLevel(3);

    TbGetRelatedDataNodeConfiguration tbGetRelatedDataNodeConfiguration2 =
        new TbGetRelatedDataNodeConfiguration();
    tbGetRelatedDataNodeConfiguration2.setRelationsQuery(relationsQuery);

    // Act and Assert
    assertNotEquals(tbGetRelatedDataNodeConfiguration, tbGetRelatedDataNodeConfiguration2);
  }

  /**
   * Test {@link TbGetRelatedDataNodeConfiguration#equals(Object)}.
   *
   * <ul>
   *   <li>When other is {@code null}.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link TbGetRelatedDataNodeConfiguration#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is 'null'; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean TbGetRelatedDataNodeConfiguration.equals(Object)",
    "int TbGetRelatedDataNodeConfiguration.hashCode()"
  })
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new TbGetRelatedDataNodeConfiguration(), null);
  }

  /**
   * Test {@link TbGetRelatedDataNodeConfiguration#equals(Object)}.
   *
   * <ul>
   *   <li>When other is wrong type.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link TbGetRelatedDataNodeConfiguration#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is wrong type; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean TbGetRelatedDataNodeConfiguration.equals(Object)",
    "int TbGetRelatedDataNodeConfiguration.hashCode()"
  })
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(
        new TbGetRelatedDataNodeConfiguration(),
        "Different type to TbGetRelatedDataNodeConfiguration");
  }

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>default or parameterless constructor of {@link TbGetRelatedDataNodeConfiguration}
   *   <li>{@link TbGetRelatedDataNodeConfiguration#setRelationsQuery(RelationsQuery)}
   *   <li>{@link TbGetRelatedDataNodeConfiguration#toString()}
   *   <li>{@link TbGetRelatedDataNodeConfiguration#getRelationsQuery()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void TbGetRelatedDataNodeConfiguration.<init>()",
    "RelationsQuery TbGetRelatedDataNodeConfiguration.getRelationsQuery()",
    "void TbGetRelatedDataNodeConfiguration.setRelationsQuery(RelationsQuery)",
    "String TbGetRelatedDataNodeConfiguration.toString()"
  })
  void testGettersAndSetters() {
    // Arrange and Act
    TbGetRelatedDataNodeConfiguration actualTbGetRelatedDataNodeConfiguration =
        new TbGetRelatedDataNodeConfiguration();
    RelationsQuery relationsQuery = new RelationsQuery();
    relationsQuery.setDirection(EntitySearchDirection.FROM);
    relationsQuery.setFetchLastLevelOnly(true);
    relationsQuery.setFilters(new ArrayList<>());
    relationsQuery.setMaxLevel(3);
    actualTbGetRelatedDataNodeConfiguration.setRelationsQuery(relationsQuery);
    String actualToStringResult = actualTbGetRelatedDataNodeConfiguration.toString();
    RelationsQuery actualRelationsQuery =
        actualTbGetRelatedDataNodeConfiguration.getRelationsQuery();

    // Assert
    assertEquals(
        "TbGetRelatedDataNodeConfiguration(relationsQuery=RelationsQuery(direction=FROM, maxLevel=3, filters=[],"
            + " fetchLastLevelOnly=true))",
        actualToStringResult);
    assertNull(actualTbGetRelatedDataNodeConfiguration.getDataMapping());
    assertNull(actualTbGetRelatedDataNodeConfiguration.getDataToFetch());
    assertNull(actualTbGetRelatedDataNodeConfiguration.getFetchTo());
    assertSame(relationsQuery, actualRelationsQuery);
  }
}
