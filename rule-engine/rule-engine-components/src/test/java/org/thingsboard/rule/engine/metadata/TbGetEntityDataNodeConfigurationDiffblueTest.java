package org.thingsboard.rule.engine.metadata;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.BiFunction;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.thingsboard.rule.engine.data.RelationsQuery;
import org.thingsboard.rule.engine.util.TbMsgSource;
import org.thingsboard.server.common.data.relation.EntitySearchDirection;
import org.thingsboard.server.common.data.relation.RelationEntityTypeFilter;

class TbGetEntityDataNodeConfigurationDiffblueTest {
  /**
   * Test {@link TbGetEntityDataNodeConfiguration#defaultConfiguration()}.
   * <ul>
   *   <li>Given {@link HashMap#HashMap()} computeIfPresent {@code foo} and
   * {@link BiFunction}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link TbGetEntityDataNodeConfiguration#defaultConfiguration()}
   */
  @Test
  @DisplayName("Test defaultConfiguration(); given HashMap() computeIfPresent 'foo' and BiFunction")
  void testDefaultConfiguration_givenHashMapComputeIfPresentFooAndBiFunction() {
    // Arrange
    HashMap<String, String> dataMapping = new HashMap<>();
    dataMapping.computeIfPresent("foo", mock(BiFunction.class));

    TbGetEntityDataNodeConfiguration tbGetEntityDataNodeConfiguration = new TbGetEntityDataNodeConfiguration();
    tbGetEntityDataNodeConfiguration.setDataMapping(dataMapping);

    // Act
    TbGetEntityDataNodeConfiguration actualDefaultConfigurationResult = tbGetEntityDataNodeConfiguration
        .defaultConfiguration();

    // Assert
    Map<String, String> dataMapping2 = actualDefaultConfigurationResult.getDataMapping();
    assertEquals(1, dataMapping2.size());
    assertEquals("threshold", dataMapping2.get("alarmThreshold"));
    assertEquals(DataToFetch.ATTRIBUTES, actualDefaultConfigurationResult.getDataToFetch());
    assertEquals(TbMsgSource.METADATA, actualDefaultConfigurationResult.getFetchTo());
  }

  /**
   * Test {@link TbGetEntityDataNodeConfiguration#defaultConfiguration()}.
   * <ul>
   *   <li>Given {@link TbGetEntityDataNodeConfiguration} (default
   * constructor).</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link TbGetEntityDataNodeConfiguration#defaultConfiguration()}
   */
  @Test
  @DisplayName("Test defaultConfiguration(); given TbGetEntityDataNodeConfiguration (default constructor)")
  void testDefaultConfiguration_givenTbGetEntityDataNodeConfiguration() {
    // Arrange and Act
    TbGetEntityDataNodeConfiguration actualDefaultConfigurationResult = (new TbGetEntityDataNodeConfiguration())
        .defaultConfiguration();

    // Assert
    Map<String, String> dataMapping = actualDefaultConfigurationResult.getDataMapping();
    assertEquals(1, dataMapping.size());
    assertEquals("threshold", dataMapping.get("alarmThreshold"));
    assertEquals(DataToFetch.ATTRIBUTES, actualDefaultConfigurationResult.getDataToFetch());
    assertEquals(TbMsgSource.METADATA, actualDefaultConfigurationResult.getFetchTo());
  }

  /**
   * Test {@link TbGetEntityDataNodeConfiguration#defaultConfiguration()}.
   * <ul>
   *   <li>Then return {@link TbGetRelatedDataNodeConfiguration}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link TbGetEntityDataNodeConfiguration#defaultConfiguration()}
   */
  @Test
  @DisplayName("Test defaultConfiguration(); then return TbGetRelatedDataNodeConfiguration")
  void testDefaultConfiguration_thenReturnTbGetRelatedDataNodeConfiguration() {
    // Arrange and Act
    TbGetRelatedDataNodeConfiguration actualDefaultConfigurationResult = (new TbGetRelatedDataNodeConfiguration())
        .defaultConfiguration();

    // Assert
    assertTrue(actualDefaultConfigurationResult instanceof TbGetRelatedDataNodeConfiguration);
    RelationsQuery relationsQuery = ((TbGetRelatedDataNodeConfiguration) actualDefaultConfigurationResult)
        .getRelationsQuery();
    List<RelationEntityTypeFilter> filters = relationsQuery.getFilters();
    assertEquals(1, filters.size());
    RelationEntityTypeFilter getResult = filters.get(0);
    assertEquals("Contains", getResult.getRelationType());
    Map<String, String> dataMapping = actualDefaultConfigurationResult.getDataMapping();
    assertEquals(1, dataMapping.size());
    assertEquals("sn", dataMapping.get("serialNumber"));
    assertEquals(1, relationsQuery.getMaxLevel());
    assertEquals(EntitySearchDirection.FROM, relationsQuery.getDirection());
    assertFalse(relationsQuery.isFetchLastLevelOnly());
    assertFalse(getResult.isNegate());
    assertTrue(getResult.getEntityTypes().isEmpty());
  }

  /**
   * Test {@link TbGetEntityDataNodeConfiguration#equals(Object)}, and
   * {@link TbGetEntityDataNodeConfiguration#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link TbGetEntityDataNodeConfiguration#equals(Object)}
   *   <li>{@link TbGetEntityDataNodeConfiguration#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    TbGetEntityDataNodeConfiguration tbGetEntityDataNodeConfiguration = new TbGetEntityDataNodeConfiguration();
    TbGetEntityDataNodeConfiguration tbGetEntityDataNodeConfiguration2 = new TbGetEntityDataNodeConfiguration();

    // Act and Assert
    assertEquals(tbGetEntityDataNodeConfiguration, tbGetEntityDataNodeConfiguration2);
    int expectedHashCodeResult = tbGetEntityDataNodeConfiguration.hashCode();
    assertEquals(expectedHashCodeResult, tbGetEntityDataNodeConfiguration2.hashCode());
  }

  /**
   * Test {@link TbGetEntityDataNodeConfiguration#equals(Object)}, and
   * {@link TbGetEntityDataNodeConfiguration#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link TbGetEntityDataNodeConfiguration#equals(Object)}
   *   <li>{@link TbGetEntityDataNodeConfiguration#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual2() {
    // Arrange
    TbGetEntityDataNodeConfiguration tbGetEntityDataNodeConfiguration = new TbGetEntityDataNodeConfiguration();
    tbGetEntityDataNodeConfiguration.setDataToFetch(DataToFetch.ATTRIBUTES);
    tbGetEntityDataNodeConfiguration.setFetchTo(TbMsgSource.DATA);
    tbGetEntityDataNodeConfiguration.setDataMapping(new HashMap<>());
    TbGetRelatedDataNodeConfiguration tbGetRelatedDataNodeConfiguration = mock(TbGetRelatedDataNodeConfiguration.class);
    when(tbGetRelatedDataNodeConfiguration.getDataToFetch()).thenReturn(DataToFetch.ATTRIBUTES);
    when(tbGetRelatedDataNodeConfiguration.getDataMapping()).thenReturn(new HashMap<>());
    when(tbGetRelatedDataNodeConfiguration.getFetchTo()).thenReturn(TbMsgSource.DATA);
    when(tbGetRelatedDataNodeConfiguration.canEqual(Mockito.<Object>any())).thenReturn(true);

    // Act and Assert
    assertEquals(tbGetEntityDataNodeConfiguration, tbGetRelatedDataNodeConfiguration);
    int notExpectedHashCodeResult = tbGetEntityDataNodeConfiguration.hashCode();
    assertNotEquals(notExpectedHashCodeResult, tbGetRelatedDataNodeConfiguration.hashCode());
  }

  /**
   * Test {@link TbGetEntityDataNodeConfiguration#equals(Object)}, and
   * {@link TbGetEntityDataNodeConfiguration#hashCode()}.
   * <ul>
   *   <li>When other is same.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link TbGetEntityDataNodeConfiguration#equals(Object)}
   *   <li>{@link TbGetEntityDataNodeConfiguration#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is same; then return equal")
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    TbGetEntityDataNodeConfiguration tbGetEntityDataNodeConfiguration = new TbGetEntityDataNodeConfiguration();

    // Act and Assert
    assertEquals(tbGetEntityDataNodeConfiguration, tbGetEntityDataNodeConfiguration);
    int expectedHashCodeResult = tbGetEntityDataNodeConfiguration.hashCode();
    assertEquals(expectedHashCodeResult, tbGetEntityDataNodeConfiguration.hashCode());
  }

  /**
   * Test {@link TbGetEntityDataNodeConfiguration#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link TbGetEntityDataNodeConfiguration#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    TbGetRelatedDataNodeConfiguration tbGetRelatedDataNodeConfiguration = new TbGetRelatedDataNodeConfiguration();

    // Act and Assert
    assertNotEquals(tbGetRelatedDataNodeConfiguration, new TbGetEntityDataNodeConfiguration());
  }

  /**
   * Test {@link TbGetEntityDataNodeConfiguration#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link TbGetEntityDataNodeConfiguration#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    TbGetEntityDataNodeConfiguration tbGetEntityDataNodeConfiguration = new TbGetEntityDataNodeConfiguration();

    // Act and Assert
    assertNotEquals(tbGetEntityDataNodeConfiguration, new TbGetRelatedDataNodeConfiguration());
  }

  /**
   * Test {@link TbGetEntityDataNodeConfiguration#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link TbGetEntityDataNodeConfiguration#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
    // Arrange, Act and Assert
    assertNotEquals(new TbGetEntityDataNodeConfiguration(), mock(TbFetchDeviceCredentialsNodeConfiguration.class));
  }

  /**
   * Test {@link TbGetEntityDataNodeConfiguration#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link TbGetEntityDataNodeConfiguration#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual4() {
    // Arrange
    TbGetEntityDataNodeConfiguration tbGetEntityDataNodeConfiguration = new TbGetEntityDataNodeConfiguration();
    TbGetRelatedDataNodeConfiguration tbGetRelatedDataNodeConfiguration = mock(TbGetRelatedDataNodeConfiguration.class);
    when(tbGetRelatedDataNodeConfiguration.getDataMapping()).thenReturn(new HashMap<>());
    when(tbGetRelatedDataNodeConfiguration.getFetchTo()).thenReturn(TbMsgSource.DATA);
    when(tbGetRelatedDataNodeConfiguration.canEqual(Mockito.<Object>any())).thenReturn(true);

    // Act and Assert
    assertNotEquals(tbGetEntityDataNodeConfiguration, tbGetRelatedDataNodeConfiguration);
  }

  /**
   * Test {@link TbGetEntityDataNodeConfiguration#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link TbGetEntityDataNodeConfiguration#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual5() {
    // Arrange
    TbGetEntityDataNodeConfiguration tbGetEntityDataNodeConfiguration = new TbGetEntityDataNodeConfiguration();
    tbGetEntityDataNodeConfiguration.setFetchTo(TbMsgSource.DATA);
    tbGetEntityDataNodeConfiguration.setDataMapping(new HashMap<>());
    TbGetRelatedDataNodeConfiguration tbGetRelatedDataNodeConfiguration = mock(TbGetRelatedDataNodeConfiguration.class);
    when(tbGetRelatedDataNodeConfiguration.getDataToFetch()).thenReturn(DataToFetch.ATTRIBUTES);
    when(tbGetRelatedDataNodeConfiguration.getDataMapping()).thenReturn(new HashMap<>());
    when(tbGetRelatedDataNodeConfiguration.getFetchTo()).thenReturn(TbMsgSource.DATA);
    when(tbGetRelatedDataNodeConfiguration.canEqual(Mockito.<Object>any())).thenReturn(true);

    // Act and Assert
    assertNotEquals(tbGetEntityDataNodeConfiguration, tbGetRelatedDataNodeConfiguration);
  }

  /**
   * Test {@link TbGetEntityDataNodeConfiguration#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link TbGetEntityDataNodeConfiguration#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual6() {
    // Arrange
    TbGetEntityDataNodeConfiguration tbGetEntityDataNodeConfiguration = new TbGetEntityDataNodeConfiguration();
    tbGetEntityDataNodeConfiguration.setDataToFetch(DataToFetch.LATEST_TELEMETRY);
    tbGetEntityDataNodeConfiguration.setFetchTo(TbMsgSource.DATA);
    tbGetEntityDataNodeConfiguration.setDataMapping(new HashMap<>());
    TbGetRelatedDataNodeConfiguration tbGetRelatedDataNodeConfiguration = mock(TbGetRelatedDataNodeConfiguration.class);
    when(tbGetRelatedDataNodeConfiguration.getDataToFetch()).thenReturn(DataToFetch.ATTRIBUTES);
    when(tbGetRelatedDataNodeConfiguration.getDataMapping()).thenReturn(new HashMap<>());
    when(tbGetRelatedDataNodeConfiguration.getFetchTo()).thenReturn(TbMsgSource.DATA);
    when(tbGetRelatedDataNodeConfiguration.canEqual(Mockito.<Object>any())).thenReturn(true);

    // Act and Assert
    assertNotEquals(tbGetEntityDataNodeConfiguration, tbGetRelatedDataNodeConfiguration);
  }

  /**
   * Test {@link TbGetEntityDataNodeConfiguration#equals(Object)}.
   * <ul>
   *   <li>When other is {@code null}.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link TbGetEntityDataNodeConfiguration#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is 'null'; then return not equal")
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new TbGetEntityDataNodeConfiguration(), null);
  }

  /**
   * Test {@link TbGetEntityDataNodeConfiguration#equals(Object)}.
   * <ul>
   *   <li>When other is wrong type.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link TbGetEntityDataNodeConfiguration#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is wrong type; then return not equal")
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new TbGetEntityDataNodeConfiguration(), "Different type to TbGetEntityDataNodeConfiguration");
  }

  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>default or parameterless constructor of
   * {@link TbGetEntityDataNodeConfiguration}
   *   <li>{@link TbGetEntityDataNodeConfiguration#setDataToFetch(DataToFetch)}
   *   <li>{@link TbGetEntityDataNodeConfiguration#toString()}
   *   <li>{@link TbGetEntityDataNodeConfiguration#getDataToFetch()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  void testGettersAndSetters() {
    // Arrange and Act
    TbGetEntityDataNodeConfiguration actualTbGetEntityDataNodeConfiguration = new TbGetEntityDataNodeConfiguration();
    actualTbGetEntityDataNodeConfiguration.setDataToFetch(DataToFetch.ATTRIBUTES);
    String actualToStringResult = actualTbGetEntityDataNodeConfiguration.toString();

    // Assert that nothing has changed
    assertEquals("TbGetEntityDataNodeConfiguration(dataToFetch=ATTRIBUTES)", actualToStringResult);
    assertEquals(DataToFetch.ATTRIBUTES, actualTbGetEntityDataNodeConfiguration.getDataToFetch());
  }
}
