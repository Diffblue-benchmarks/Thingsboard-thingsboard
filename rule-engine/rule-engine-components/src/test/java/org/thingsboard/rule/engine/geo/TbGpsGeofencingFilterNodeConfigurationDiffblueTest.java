package org.thingsboard.rule.engine.geo;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class TbGpsGeofencingFilterNodeConfigurationDiffblueTest {
  /**
   * Test {@link TbGpsGeofencingFilterNodeConfiguration#defaultConfiguration()}.
   * <ul>
   *   <li>Then return LatitudeKeyName is {@code latitude}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link TbGpsGeofencingFilterNodeConfiguration#defaultConfiguration()}
   */
  @Test
  @DisplayName("Test defaultConfiguration(); then return LatitudeKeyName is 'latitude'")
  void testDefaultConfiguration_thenReturnLatitudeKeyNameIsLatitude() {
    // Arrange and Act
    TbGpsGeofencingFilterNodeConfiguration actualDefaultConfigurationResult = (new TbGpsGeofencingFilterNodeConfiguration())
        .defaultConfiguration();

    // Assert
    assertEquals("latitude", actualDefaultConfigurationResult.getLatitudeKeyName());
    assertEquals("longitude", actualDefaultConfigurationResult.getLongitudeKeyName());
    assertEquals("ss_perimeter", actualDefaultConfigurationResult.getPerimeterKeyName());
    assertNull(actualDefaultConfigurationResult.getCenterLatitude());
    assertNull(actualDefaultConfigurationResult.getCenterLongitude());
    assertNull(actualDefaultConfigurationResult.getRange());
    assertNull(actualDefaultConfigurationResult.getPolygonsDefinition());
    assertNull(actualDefaultConfigurationResult.getRangeUnit());
    assertEquals(PerimeterType.POLYGON, actualDefaultConfigurationResult.getPerimeterType());
    assertTrue(actualDefaultConfigurationResult.isFetchPerimeterInfoFromMessageMetadata());
  }

  /**
   * Test {@link TbGpsGeofencingFilterNodeConfiguration#defaultConfiguration()}.
   * <ul>
   *   <li>Then return {@link TbGpsGeofencingActionNodeConfiguration}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link TbGpsGeofencingFilterNodeConfiguration#defaultConfiguration()}
   */
  @Test
  @DisplayName("Test defaultConfiguration(); then return TbGpsGeofencingActionNodeConfiguration")
  void testDefaultConfiguration_thenReturnTbGpsGeofencingActionNodeConfiguration() {
    // Arrange and Act
    TbGpsGeofencingActionNodeConfiguration actualDefaultConfigurationResult = (new TbGpsGeofencingActionNodeConfiguration())
        .defaultConfiguration();

    // Assert
    assertTrue(actualDefaultConfigurationResult instanceof TbGpsGeofencingActionNodeConfiguration);
    assertEquals("MINUTES",
        ((TbGpsGeofencingActionNodeConfiguration) actualDefaultConfigurationResult).getMinInsideDurationTimeUnit());
    assertEquals("MINUTES",
        ((TbGpsGeofencingActionNodeConfiguration) actualDefaultConfigurationResult).getMinOutsideDurationTimeUnit());
    assertEquals(1, ((TbGpsGeofencingActionNodeConfiguration) actualDefaultConfigurationResult).getMinInsideDuration());
    assertEquals(1,
        ((TbGpsGeofencingActionNodeConfiguration) actualDefaultConfigurationResult).getMinOutsideDuration());
    assertTrue(((TbGpsGeofencingActionNodeConfiguration) actualDefaultConfigurationResult)
        .isReportPresenceStatusOnEachMessage());
  }

  /**
   * Test {@link TbGpsGeofencingFilterNodeConfiguration#equals(Object)}, and
   * {@link TbGpsGeofencingFilterNodeConfiguration#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link TbGpsGeofencingFilterNodeConfiguration#equals(Object)}
   *   <li>{@link TbGpsGeofencingFilterNodeConfiguration#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    TbGpsGeofencingFilterNodeConfiguration tbGpsGeofencingFilterNodeConfiguration = new TbGpsGeofencingFilterNodeConfiguration();
    TbGpsGeofencingFilterNodeConfiguration tbGpsGeofencingFilterNodeConfiguration2 = new TbGpsGeofencingFilterNodeConfiguration();

    // Act and Assert
    assertEquals(tbGpsGeofencingFilterNodeConfiguration, tbGpsGeofencingFilterNodeConfiguration2);
    int expectedHashCodeResult = tbGpsGeofencingFilterNodeConfiguration.hashCode();
    assertEquals(expectedHashCodeResult, tbGpsGeofencingFilterNodeConfiguration2.hashCode());
  }

  /**
   * Test {@link TbGpsGeofencingFilterNodeConfiguration#equals(Object)}, and
   * {@link TbGpsGeofencingFilterNodeConfiguration#hashCode()}.
   * <ul>
   *   <li>When other is same.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link TbGpsGeofencingFilterNodeConfiguration#equals(Object)}
   *   <li>{@link TbGpsGeofencingFilterNodeConfiguration#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is same; then return equal")
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    TbGpsGeofencingFilterNodeConfiguration tbGpsGeofencingFilterNodeConfiguration = new TbGpsGeofencingFilterNodeConfiguration();

    // Act and Assert
    assertEquals(tbGpsGeofencingFilterNodeConfiguration, tbGpsGeofencingFilterNodeConfiguration);
    int expectedHashCodeResult = tbGpsGeofencingFilterNodeConfiguration.hashCode();
    assertEquals(expectedHashCodeResult, tbGpsGeofencingFilterNodeConfiguration.hashCode());
  }

  /**
   * Test {@link TbGpsGeofencingFilterNodeConfiguration#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link TbGpsGeofencingFilterNodeConfiguration#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    TbGpsGeofencingActionNodeConfiguration tbGpsGeofencingActionNodeConfiguration = new TbGpsGeofencingActionNodeConfiguration();

    // Act and Assert
    assertNotEquals(tbGpsGeofencingActionNodeConfiguration, new TbGpsGeofencingFilterNodeConfiguration());
  }

  /**
   * Test {@link TbGpsGeofencingFilterNodeConfiguration#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link TbGpsGeofencingFilterNodeConfiguration#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    TbGpsGeofencingFilterNodeConfiguration tbGpsGeofencingFilterNodeConfiguration = new TbGpsGeofencingFilterNodeConfiguration();

    // Act and Assert
    assertNotEquals(tbGpsGeofencingFilterNodeConfiguration, new TbGpsGeofencingActionNodeConfiguration());
  }

  /**
   * Test {@link TbGpsGeofencingFilterNodeConfiguration#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link TbGpsGeofencingFilterNodeConfiguration#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
    // Arrange
    TbGpsGeofencingFilterNodeConfiguration tbGpsGeofencingFilterNodeConfiguration = new TbGpsGeofencingFilterNodeConfiguration();
    TbGpsGeofencingActionNodeConfiguration tbGpsGeofencingActionNodeConfiguration = mock(
        TbGpsGeofencingActionNodeConfiguration.class);
    when(tbGpsGeofencingActionNodeConfiguration.isFetchPerimeterInfoFromMessageMetadata()).thenReturn(true);
    when(tbGpsGeofencingActionNodeConfiguration.getCenterLatitude()).thenReturn(10.0d);
    when(tbGpsGeofencingActionNodeConfiguration.canEqual(Mockito.<Object>any())).thenReturn(true);

    // Act and Assert
    assertNotEquals(tbGpsGeofencingFilterNodeConfiguration, tbGpsGeofencingActionNodeConfiguration);
  }

  /**
   * Test {@link TbGpsGeofencingFilterNodeConfiguration#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link TbGpsGeofencingFilterNodeConfiguration#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual4() {
    // Arrange
    TbGpsGeofencingFilterNodeConfiguration tbGpsGeofencingFilterNodeConfiguration = new TbGpsGeofencingFilterNodeConfiguration();
    TbGpsGeofencingActionNodeConfiguration tbGpsGeofencingActionNodeConfiguration = mock(
        TbGpsGeofencingActionNodeConfiguration.class);
    when(tbGpsGeofencingActionNodeConfiguration.isFetchPerimeterInfoFromMessageMetadata()).thenReturn(false);
    when(tbGpsGeofencingActionNodeConfiguration.getCenterLatitude()).thenReturn(10.0d);
    when(tbGpsGeofencingActionNodeConfiguration.canEqual(Mockito.<Object>any())).thenReturn(true);

    // Act and Assert
    assertNotEquals(tbGpsGeofencingFilterNodeConfiguration, tbGpsGeofencingActionNodeConfiguration);
  }

  /**
   * Test {@link TbGpsGeofencingFilterNodeConfiguration#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link TbGpsGeofencingFilterNodeConfiguration#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual5() {
    // Arrange
    TbGpsGeofencingFilterNodeConfiguration tbGpsGeofencingFilterNodeConfiguration = new TbGpsGeofencingFilterNodeConfiguration();
    TbGpsGeofencingActionNodeConfiguration tbGpsGeofencingActionNodeConfiguration = mock(
        TbGpsGeofencingActionNodeConfiguration.class);
    when(tbGpsGeofencingActionNodeConfiguration.getCenterLongitude()).thenReturn(10.0d);
    when(tbGpsGeofencingActionNodeConfiguration.isFetchPerimeterInfoFromMessageMetadata()).thenReturn(false);
    when(tbGpsGeofencingActionNodeConfiguration.getCenterLatitude()).thenReturn(null);
    when(tbGpsGeofencingActionNodeConfiguration.canEqual(Mockito.<Object>any())).thenReturn(true);

    // Act and Assert
    assertNotEquals(tbGpsGeofencingFilterNodeConfiguration, tbGpsGeofencingActionNodeConfiguration);
  }

  /**
   * Test {@link TbGpsGeofencingFilterNodeConfiguration#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link TbGpsGeofencingFilterNodeConfiguration#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual6() {
    // Arrange
    TbGpsGeofencingFilterNodeConfiguration tbGpsGeofencingFilterNodeConfiguration = new TbGpsGeofencingFilterNodeConfiguration();
    TbGpsGeofencingActionNodeConfiguration tbGpsGeofencingActionNodeConfiguration = mock(
        TbGpsGeofencingActionNodeConfiguration.class);
    when(tbGpsGeofencingActionNodeConfiguration.getRange()).thenReturn(10.0d);
    when(tbGpsGeofencingActionNodeConfiguration.getCenterLongitude()).thenReturn(null);
    when(tbGpsGeofencingActionNodeConfiguration.isFetchPerimeterInfoFromMessageMetadata()).thenReturn(false);
    when(tbGpsGeofencingActionNodeConfiguration.getCenterLatitude()).thenReturn(null);
    when(tbGpsGeofencingActionNodeConfiguration.canEqual(Mockito.<Object>any())).thenReturn(true);

    // Act and Assert
    assertNotEquals(tbGpsGeofencingFilterNodeConfiguration, tbGpsGeofencingActionNodeConfiguration);
  }

  /**
   * Test {@link TbGpsGeofencingFilterNodeConfiguration#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link TbGpsGeofencingFilterNodeConfiguration#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual7() {
    // Arrange
    TbGpsGeofencingFilterNodeConfiguration tbGpsGeofencingFilterNodeConfiguration = new TbGpsGeofencingFilterNodeConfiguration();
    TbGpsGeofencingActionNodeConfiguration tbGpsGeofencingActionNodeConfiguration = mock(
        TbGpsGeofencingActionNodeConfiguration.class);
    when(tbGpsGeofencingActionNodeConfiguration.getLatitudeKeyName()).thenReturn("Latitude Key Name");
    when(tbGpsGeofencingActionNodeConfiguration.getLongitudeKeyName()).thenReturn("Longitude Key Name");
    when(tbGpsGeofencingActionNodeConfiguration.getPerimeterKeyName()).thenReturn("Perimeter Key Name");
    when(tbGpsGeofencingActionNodeConfiguration.getPolygonsDefinition()).thenReturn("Polygons Definition");
    when(tbGpsGeofencingActionNodeConfiguration.getPerimeterType()).thenReturn(PerimeterType.CIRCLE);
    when(tbGpsGeofencingActionNodeConfiguration.getRangeUnit()).thenReturn(RangeUnit.METER);
    when(tbGpsGeofencingActionNodeConfiguration.getRange()).thenReturn(null);
    when(tbGpsGeofencingActionNodeConfiguration.getCenterLongitude()).thenReturn(null);
    when(tbGpsGeofencingActionNodeConfiguration.isFetchPerimeterInfoFromMessageMetadata()).thenReturn(false);
    when(tbGpsGeofencingActionNodeConfiguration.getCenterLatitude()).thenReturn(null);
    when(tbGpsGeofencingActionNodeConfiguration.canEqual(Mockito.<Object>any())).thenReturn(true);

    // Act and Assert
    assertNotEquals(tbGpsGeofencingFilterNodeConfiguration, tbGpsGeofencingActionNodeConfiguration);
  }

  /**
   * Test {@link TbGpsGeofencingFilterNodeConfiguration#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link TbGpsGeofencingFilterNodeConfiguration#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual8() {
    // Arrange
    TbGpsGeofencingFilterNodeConfiguration tbGpsGeofencingFilterNodeConfiguration = new TbGpsGeofencingFilterNodeConfiguration();
    TbGpsGeofencingActionNodeConfiguration tbGpsGeofencingActionNodeConfiguration = mock(
        TbGpsGeofencingActionNodeConfiguration.class);
    when(tbGpsGeofencingActionNodeConfiguration.getLatitudeKeyName()).thenReturn(null);
    when(tbGpsGeofencingActionNodeConfiguration.getLongitudeKeyName()).thenReturn("Longitude Key Name");
    when(tbGpsGeofencingActionNodeConfiguration.getPerimeterKeyName()).thenReturn("Perimeter Key Name");
    when(tbGpsGeofencingActionNodeConfiguration.getPolygonsDefinition()).thenReturn("Polygons Definition");
    when(tbGpsGeofencingActionNodeConfiguration.getPerimeterType()).thenReturn(PerimeterType.CIRCLE);
    when(tbGpsGeofencingActionNodeConfiguration.getRangeUnit()).thenReturn(RangeUnit.METER);
    when(tbGpsGeofencingActionNodeConfiguration.getRange()).thenReturn(null);
    when(tbGpsGeofencingActionNodeConfiguration.getCenterLongitude()).thenReturn(null);
    when(tbGpsGeofencingActionNodeConfiguration.isFetchPerimeterInfoFromMessageMetadata()).thenReturn(false);
    when(tbGpsGeofencingActionNodeConfiguration.getCenterLatitude()).thenReturn(null);
    when(tbGpsGeofencingActionNodeConfiguration.canEqual(Mockito.<Object>any())).thenReturn(true);

    // Act and Assert
    assertNotEquals(tbGpsGeofencingFilterNodeConfiguration, tbGpsGeofencingActionNodeConfiguration);
  }

  /**
   * Test {@link TbGpsGeofencingFilterNodeConfiguration#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link TbGpsGeofencingFilterNodeConfiguration#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual9() {
    // Arrange
    TbGpsGeofencingFilterNodeConfiguration tbGpsGeofencingFilterNodeConfiguration = new TbGpsGeofencingFilterNodeConfiguration();
    tbGpsGeofencingFilterNodeConfiguration.setLatitudeKeyName("Latitude Key Name");
    TbGpsGeofencingActionNodeConfiguration tbGpsGeofencingActionNodeConfiguration = mock(
        TbGpsGeofencingActionNodeConfiguration.class);
    when(tbGpsGeofencingActionNodeConfiguration.getLatitudeKeyName()).thenReturn("Latitude Key Name");
    when(tbGpsGeofencingActionNodeConfiguration.getLongitudeKeyName()).thenReturn("Longitude Key Name");
    when(tbGpsGeofencingActionNodeConfiguration.getPerimeterKeyName()).thenReturn("Perimeter Key Name");
    when(tbGpsGeofencingActionNodeConfiguration.getPolygonsDefinition()).thenReturn("Polygons Definition");
    when(tbGpsGeofencingActionNodeConfiguration.getPerimeterType()).thenReturn(PerimeterType.CIRCLE);
    when(tbGpsGeofencingActionNodeConfiguration.getRangeUnit()).thenReturn(RangeUnit.METER);
    when(tbGpsGeofencingActionNodeConfiguration.getRange()).thenReturn(null);
    when(tbGpsGeofencingActionNodeConfiguration.getCenterLongitude()).thenReturn(null);
    when(tbGpsGeofencingActionNodeConfiguration.isFetchPerimeterInfoFromMessageMetadata()).thenReturn(false);
    when(tbGpsGeofencingActionNodeConfiguration.getCenterLatitude()).thenReturn(null);
    when(tbGpsGeofencingActionNodeConfiguration.canEqual(Mockito.<Object>any())).thenReturn(true);

    // Act and Assert
    assertNotEquals(tbGpsGeofencingFilterNodeConfiguration, tbGpsGeofencingActionNodeConfiguration);
  }

  /**
   * Test {@link TbGpsGeofencingFilterNodeConfiguration#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link TbGpsGeofencingFilterNodeConfiguration#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual10() {
    // Arrange
    TbGpsGeofencingFilterNodeConfiguration tbGpsGeofencingFilterNodeConfiguration = new TbGpsGeofencingFilterNodeConfiguration();
    tbGpsGeofencingFilterNodeConfiguration.setCenterLatitude(10.0d);
    TbGpsGeofencingActionNodeConfiguration tbGpsGeofencingActionNodeConfiguration = mock(
        TbGpsGeofencingActionNodeConfiguration.class);
    when(tbGpsGeofencingActionNodeConfiguration.getLatitudeKeyName()).thenReturn("Latitude Key Name");
    when(tbGpsGeofencingActionNodeConfiguration.getLongitudeKeyName()).thenReturn("Longitude Key Name");
    when(tbGpsGeofencingActionNodeConfiguration.getPerimeterKeyName()).thenReturn("Perimeter Key Name");
    when(tbGpsGeofencingActionNodeConfiguration.getPolygonsDefinition()).thenReturn("Polygons Definition");
    when(tbGpsGeofencingActionNodeConfiguration.getPerimeterType()).thenReturn(PerimeterType.CIRCLE);
    when(tbGpsGeofencingActionNodeConfiguration.getRangeUnit()).thenReturn(RangeUnit.METER);
    when(tbGpsGeofencingActionNodeConfiguration.getRange()).thenReturn(null);
    when(tbGpsGeofencingActionNodeConfiguration.getCenterLongitude()).thenReturn(null);
    when(tbGpsGeofencingActionNodeConfiguration.isFetchPerimeterInfoFromMessageMetadata()).thenReturn(false);
    when(tbGpsGeofencingActionNodeConfiguration.getCenterLatitude()).thenReturn(null);
    when(tbGpsGeofencingActionNodeConfiguration.canEqual(Mockito.<Object>any())).thenReturn(true);

    // Act and Assert
    assertNotEquals(tbGpsGeofencingFilterNodeConfiguration, tbGpsGeofencingActionNodeConfiguration);
  }

  /**
   * Test {@link TbGpsGeofencingFilterNodeConfiguration#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link TbGpsGeofencingFilterNodeConfiguration#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual11() {
    // Arrange
    TbGpsGeofencingFilterNodeConfiguration tbGpsGeofencingFilterNodeConfiguration = new TbGpsGeofencingFilterNodeConfiguration();
    tbGpsGeofencingFilterNodeConfiguration.setCenterLongitude(10.0d);
    TbGpsGeofencingActionNodeConfiguration tbGpsGeofencingActionNodeConfiguration = mock(
        TbGpsGeofencingActionNodeConfiguration.class);
    when(tbGpsGeofencingActionNodeConfiguration.getLatitudeKeyName()).thenReturn("Latitude Key Name");
    when(tbGpsGeofencingActionNodeConfiguration.getLongitudeKeyName()).thenReturn("Longitude Key Name");
    when(tbGpsGeofencingActionNodeConfiguration.getPerimeterKeyName()).thenReturn("Perimeter Key Name");
    when(tbGpsGeofencingActionNodeConfiguration.getPolygonsDefinition()).thenReturn("Polygons Definition");
    when(tbGpsGeofencingActionNodeConfiguration.getPerimeterType()).thenReturn(PerimeterType.CIRCLE);
    when(tbGpsGeofencingActionNodeConfiguration.getRangeUnit()).thenReturn(RangeUnit.METER);
    when(tbGpsGeofencingActionNodeConfiguration.getRange()).thenReturn(null);
    when(tbGpsGeofencingActionNodeConfiguration.getCenterLongitude()).thenReturn(null);
    when(tbGpsGeofencingActionNodeConfiguration.isFetchPerimeterInfoFromMessageMetadata()).thenReturn(false);
    when(tbGpsGeofencingActionNodeConfiguration.getCenterLatitude()).thenReturn(null);
    when(tbGpsGeofencingActionNodeConfiguration.canEqual(Mockito.<Object>any())).thenReturn(true);

    // Act and Assert
    assertNotEquals(tbGpsGeofencingFilterNodeConfiguration, tbGpsGeofencingActionNodeConfiguration);
  }

  /**
   * Test {@link TbGpsGeofencingFilterNodeConfiguration#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link TbGpsGeofencingFilterNodeConfiguration#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual12() {
    // Arrange
    TbGpsGeofencingFilterNodeConfiguration tbGpsGeofencingFilterNodeConfiguration = new TbGpsGeofencingFilterNodeConfiguration();
    tbGpsGeofencingFilterNodeConfiguration.setRange(10.0d);
    TbGpsGeofencingActionNodeConfiguration tbGpsGeofencingActionNodeConfiguration = mock(
        TbGpsGeofencingActionNodeConfiguration.class);
    when(tbGpsGeofencingActionNodeConfiguration.getLatitudeKeyName()).thenReturn("Latitude Key Name");
    when(tbGpsGeofencingActionNodeConfiguration.getLongitudeKeyName()).thenReturn("Longitude Key Name");
    when(tbGpsGeofencingActionNodeConfiguration.getPerimeterKeyName()).thenReturn("Perimeter Key Name");
    when(tbGpsGeofencingActionNodeConfiguration.getPolygonsDefinition()).thenReturn("Polygons Definition");
    when(tbGpsGeofencingActionNodeConfiguration.getPerimeterType()).thenReturn(PerimeterType.CIRCLE);
    when(tbGpsGeofencingActionNodeConfiguration.getRangeUnit()).thenReturn(RangeUnit.METER);
    when(tbGpsGeofencingActionNodeConfiguration.getRange()).thenReturn(null);
    when(tbGpsGeofencingActionNodeConfiguration.getCenterLongitude()).thenReturn(null);
    when(tbGpsGeofencingActionNodeConfiguration.isFetchPerimeterInfoFromMessageMetadata()).thenReturn(false);
    when(tbGpsGeofencingActionNodeConfiguration.getCenterLatitude()).thenReturn(null);
    when(tbGpsGeofencingActionNodeConfiguration.canEqual(Mockito.<Object>any())).thenReturn(true);

    // Act and Assert
    assertNotEquals(tbGpsGeofencingFilterNodeConfiguration, tbGpsGeofencingActionNodeConfiguration);
  }

  /**
   * Test {@link TbGpsGeofencingFilterNodeConfiguration#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link TbGpsGeofencingFilterNodeConfiguration#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual13() {
    // Arrange
    TbGpsGeofencingFilterNodeConfiguration tbGpsGeofencingFilterNodeConfiguration = new TbGpsGeofencingFilterNodeConfiguration();
    TbGpsGeofencingActionNodeConfiguration tbGpsGeofencingActionNodeConfiguration = mock(
        TbGpsGeofencingActionNodeConfiguration.class);
    when(tbGpsGeofencingActionNodeConfiguration.getLatitudeKeyName()).thenReturn(null);
    when(tbGpsGeofencingActionNodeConfiguration.getLongitudeKeyName()).thenReturn(null);
    when(tbGpsGeofencingActionNodeConfiguration.getPerimeterKeyName()).thenReturn("Perimeter Key Name");
    when(tbGpsGeofencingActionNodeConfiguration.getPolygonsDefinition()).thenReturn("Polygons Definition");
    when(tbGpsGeofencingActionNodeConfiguration.getPerimeterType()).thenReturn(PerimeterType.CIRCLE);
    when(tbGpsGeofencingActionNodeConfiguration.getRangeUnit()).thenReturn(RangeUnit.METER);
    when(tbGpsGeofencingActionNodeConfiguration.getRange()).thenReturn(null);
    when(tbGpsGeofencingActionNodeConfiguration.getCenterLongitude()).thenReturn(null);
    when(tbGpsGeofencingActionNodeConfiguration.isFetchPerimeterInfoFromMessageMetadata()).thenReturn(false);
    when(tbGpsGeofencingActionNodeConfiguration.getCenterLatitude()).thenReturn(null);
    when(tbGpsGeofencingActionNodeConfiguration.canEqual(Mockito.<Object>any())).thenReturn(true);

    // Act and Assert
    assertNotEquals(tbGpsGeofencingFilterNodeConfiguration, tbGpsGeofencingActionNodeConfiguration);
  }

  /**
   * Test {@link TbGpsGeofencingFilterNodeConfiguration#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link TbGpsGeofencingFilterNodeConfiguration#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual14() {
    // Arrange
    TbGpsGeofencingFilterNodeConfiguration tbGpsGeofencingFilterNodeConfiguration = new TbGpsGeofencingFilterNodeConfiguration();
    tbGpsGeofencingFilterNodeConfiguration
        .setLatitudeKeyName("org.thingsboard.rule.engine.geo.TbGpsGeofencingFilterNodeConfiguration");
    TbGpsGeofencingActionNodeConfiguration tbGpsGeofencingActionNodeConfiguration = mock(
        TbGpsGeofencingActionNodeConfiguration.class);
    when(tbGpsGeofencingActionNodeConfiguration.getLatitudeKeyName()).thenReturn("Latitude Key Name");
    when(tbGpsGeofencingActionNodeConfiguration.getLongitudeKeyName()).thenReturn("Longitude Key Name");
    when(tbGpsGeofencingActionNodeConfiguration.getPerimeterKeyName()).thenReturn("Perimeter Key Name");
    when(tbGpsGeofencingActionNodeConfiguration.getPolygonsDefinition()).thenReturn("Polygons Definition");
    when(tbGpsGeofencingActionNodeConfiguration.getPerimeterType()).thenReturn(PerimeterType.CIRCLE);
    when(tbGpsGeofencingActionNodeConfiguration.getRangeUnit()).thenReturn(RangeUnit.METER);
    when(tbGpsGeofencingActionNodeConfiguration.getRange()).thenReturn(null);
    when(tbGpsGeofencingActionNodeConfiguration.getCenterLongitude()).thenReturn(null);
    when(tbGpsGeofencingActionNodeConfiguration.isFetchPerimeterInfoFromMessageMetadata()).thenReturn(false);
    when(tbGpsGeofencingActionNodeConfiguration.getCenterLatitude()).thenReturn(null);
    when(tbGpsGeofencingActionNodeConfiguration.canEqual(Mockito.<Object>any())).thenReturn(true);

    // Act and Assert
    assertNotEquals(tbGpsGeofencingFilterNodeConfiguration, tbGpsGeofencingActionNodeConfiguration);
  }

  /**
   * Test {@link TbGpsGeofencingFilterNodeConfiguration#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link TbGpsGeofencingFilterNodeConfiguration#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual15() {
    // Arrange
    TbGpsGeofencingFilterNodeConfiguration tbGpsGeofencingFilterNodeConfiguration = new TbGpsGeofencingFilterNodeConfiguration();
    tbGpsGeofencingFilterNodeConfiguration.setCenterLatitude(10.0d);
    TbGpsGeofencingActionNodeConfiguration tbGpsGeofencingActionNodeConfiguration = mock(
        TbGpsGeofencingActionNodeConfiguration.class);
    when(tbGpsGeofencingActionNodeConfiguration.getLatitudeKeyName()).thenReturn("Latitude Key Name");
    when(tbGpsGeofencingActionNodeConfiguration.getLongitudeKeyName()).thenReturn("Longitude Key Name");
    when(tbGpsGeofencingActionNodeConfiguration.getPerimeterKeyName()).thenReturn("Perimeter Key Name");
    when(tbGpsGeofencingActionNodeConfiguration.getPolygonsDefinition()).thenReturn("Polygons Definition");
    when(tbGpsGeofencingActionNodeConfiguration.getPerimeterType()).thenReturn(PerimeterType.CIRCLE);
    when(tbGpsGeofencingActionNodeConfiguration.getRangeUnit()).thenReturn(RangeUnit.METER);
    when(tbGpsGeofencingActionNodeConfiguration.getRange()).thenReturn(null);
    when(tbGpsGeofencingActionNodeConfiguration.getCenterLongitude()).thenReturn(null);
    when(tbGpsGeofencingActionNodeConfiguration.isFetchPerimeterInfoFromMessageMetadata()).thenReturn(false);
    when(tbGpsGeofencingActionNodeConfiguration.getCenterLatitude()).thenReturn(10.0d);
    when(tbGpsGeofencingActionNodeConfiguration.canEqual(Mockito.<Object>any())).thenReturn(true);

    // Act and Assert
    assertNotEquals(tbGpsGeofencingFilterNodeConfiguration, tbGpsGeofencingActionNodeConfiguration);
  }

  /**
   * Test {@link TbGpsGeofencingFilterNodeConfiguration#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link TbGpsGeofencingFilterNodeConfiguration#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual16() {
    // Arrange
    TbGpsGeofencingFilterNodeConfiguration tbGpsGeofencingFilterNodeConfiguration = new TbGpsGeofencingFilterNodeConfiguration();
    tbGpsGeofencingFilterNodeConfiguration.setCenterLongitude(10.0d);
    TbGpsGeofencingActionNodeConfiguration tbGpsGeofencingActionNodeConfiguration = mock(
        TbGpsGeofencingActionNodeConfiguration.class);
    when(tbGpsGeofencingActionNodeConfiguration.getLatitudeKeyName()).thenReturn("Latitude Key Name");
    when(tbGpsGeofencingActionNodeConfiguration.getLongitudeKeyName()).thenReturn("Longitude Key Name");
    when(tbGpsGeofencingActionNodeConfiguration.getPerimeterKeyName()).thenReturn("Perimeter Key Name");
    when(tbGpsGeofencingActionNodeConfiguration.getPolygonsDefinition()).thenReturn("Polygons Definition");
    when(tbGpsGeofencingActionNodeConfiguration.getPerimeterType()).thenReturn(PerimeterType.CIRCLE);
    when(tbGpsGeofencingActionNodeConfiguration.getRangeUnit()).thenReturn(RangeUnit.METER);
    when(tbGpsGeofencingActionNodeConfiguration.getRange()).thenReturn(null);
    when(tbGpsGeofencingActionNodeConfiguration.getCenterLongitude()).thenReturn(10.0d);
    when(tbGpsGeofencingActionNodeConfiguration.isFetchPerimeterInfoFromMessageMetadata()).thenReturn(false);
    when(tbGpsGeofencingActionNodeConfiguration.getCenterLatitude()).thenReturn(null);
    when(tbGpsGeofencingActionNodeConfiguration.canEqual(Mockito.<Object>any())).thenReturn(true);

    // Act and Assert
    assertNotEquals(tbGpsGeofencingFilterNodeConfiguration, tbGpsGeofencingActionNodeConfiguration);
  }

  /**
   * Test {@link TbGpsGeofencingFilterNodeConfiguration#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link TbGpsGeofencingFilterNodeConfiguration#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual17() {
    // Arrange
    TbGpsGeofencingFilterNodeConfiguration tbGpsGeofencingFilterNodeConfiguration = new TbGpsGeofencingFilterNodeConfiguration();
    tbGpsGeofencingFilterNodeConfiguration.setRange(10.0d);
    TbGpsGeofencingActionNodeConfiguration tbGpsGeofencingActionNodeConfiguration = mock(
        TbGpsGeofencingActionNodeConfiguration.class);
    when(tbGpsGeofencingActionNodeConfiguration.getLatitudeKeyName()).thenReturn("Latitude Key Name");
    when(tbGpsGeofencingActionNodeConfiguration.getLongitudeKeyName()).thenReturn("Longitude Key Name");
    when(tbGpsGeofencingActionNodeConfiguration.getPerimeterKeyName()).thenReturn("Perimeter Key Name");
    when(tbGpsGeofencingActionNodeConfiguration.getPolygonsDefinition()).thenReturn("Polygons Definition");
    when(tbGpsGeofencingActionNodeConfiguration.getPerimeterType()).thenReturn(PerimeterType.CIRCLE);
    when(tbGpsGeofencingActionNodeConfiguration.getRangeUnit()).thenReturn(RangeUnit.METER);
    when(tbGpsGeofencingActionNodeConfiguration.getRange()).thenReturn(10.0d);
    when(tbGpsGeofencingActionNodeConfiguration.getCenterLongitude()).thenReturn(null);
    when(tbGpsGeofencingActionNodeConfiguration.isFetchPerimeterInfoFromMessageMetadata()).thenReturn(false);
    when(tbGpsGeofencingActionNodeConfiguration.getCenterLatitude()).thenReturn(null);
    when(tbGpsGeofencingActionNodeConfiguration.canEqual(Mockito.<Object>any())).thenReturn(true);

    // Act and Assert
    assertNotEquals(tbGpsGeofencingFilterNodeConfiguration, tbGpsGeofencingActionNodeConfiguration);
  }

  /**
   * Test {@link TbGpsGeofencingFilterNodeConfiguration#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link TbGpsGeofencingFilterNodeConfiguration#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual18() {
    // Arrange
    TbGpsGeofencingFilterNodeConfiguration tbGpsGeofencingFilterNodeConfiguration = new TbGpsGeofencingFilterNodeConfiguration();
    tbGpsGeofencingFilterNodeConfiguration.setLongitudeKeyName("Longitude Key Name");
    TbGpsGeofencingActionNodeConfiguration tbGpsGeofencingActionNodeConfiguration = mock(
        TbGpsGeofencingActionNodeConfiguration.class);
    when(tbGpsGeofencingActionNodeConfiguration.getLatitudeKeyName()).thenReturn(null);
    when(tbGpsGeofencingActionNodeConfiguration.getLongitudeKeyName()).thenReturn("Longitude Key Name");
    when(tbGpsGeofencingActionNodeConfiguration.getPerimeterKeyName()).thenReturn("Perimeter Key Name");
    when(tbGpsGeofencingActionNodeConfiguration.getPolygonsDefinition()).thenReturn("Polygons Definition");
    when(tbGpsGeofencingActionNodeConfiguration.getPerimeterType()).thenReturn(PerimeterType.CIRCLE);
    when(tbGpsGeofencingActionNodeConfiguration.getRangeUnit()).thenReturn(RangeUnit.METER);
    when(tbGpsGeofencingActionNodeConfiguration.getRange()).thenReturn(null);
    when(tbGpsGeofencingActionNodeConfiguration.getCenterLongitude()).thenReturn(null);
    when(tbGpsGeofencingActionNodeConfiguration.isFetchPerimeterInfoFromMessageMetadata()).thenReturn(false);
    when(tbGpsGeofencingActionNodeConfiguration.getCenterLatitude()).thenReturn(null);
    when(tbGpsGeofencingActionNodeConfiguration.canEqual(Mockito.<Object>any())).thenReturn(true);

    // Act and Assert
    assertNotEquals(tbGpsGeofencingFilterNodeConfiguration, tbGpsGeofencingActionNodeConfiguration);
  }

  /**
   * Test {@link TbGpsGeofencingFilterNodeConfiguration#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link TbGpsGeofencingFilterNodeConfiguration#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual19() {
    // Arrange
    TbGpsGeofencingFilterNodeConfiguration tbGpsGeofencingFilterNodeConfiguration = new TbGpsGeofencingFilterNodeConfiguration();
    TbGpsGeofencingActionNodeConfiguration tbGpsGeofencingActionNodeConfiguration = mock(
        TbGpsGeofencingActionNodeConfiguration.class);
    when(tbGpsGeofencingActionNodeConfiguration.getLatitudeKeyName()).thenReturn(null);
    when(tbGpsGeofencingActionNodeConfiguration.getLongitudeKeyName()).thenReturn(null);
    when(tbGpsGeofencingActionNodeConfiguration.getPerimeterKeyName()).thenReturn("Perimeter Key Name");
    when(tbGpsGeofencingActionNodeConfiguration.getPolygonsDefinition()).thenReturn("Polygons Definition");
    when(tbGpsGeofencingActionNodeConfiguration.getPerimeterType()).thenReturn(null);
    when(tbGpsGeofencingActionNodeConfiguration.getRangeUnit()).thenReturn(RangeUnit.METER);
    when(tbGpsGeofencingActionNodeConfiguration.getRange()).thenReturn(null);
    when(tbGpsGeofencingActionNodeConfiguration.getCenterLongitude()).thenReturn(null);
    when(tbGpsGeofencingActionNodeConfiguration.isFetchPerimeterInfoFromMessageMetadata()).thenReturn(false);
    when(tbGpsGeofencingActionNodeConfiguration.getCenterLatitude()).thenReturn(null);
    when(tbGpsGeofencingActionNodeConfiguration.canEqual(Mockito.<Object>any())).thenReturn(true);

    // Act and Assert
    assertNotEquals(tbGpsGeofencingFilterNodeConfiguration, tbGpsGeofencingActionNodeConfiguration);
  }

  /**
   * Test {@link TbGpsGeofencingFilterNodeConfiguration#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link TbGpsGeofencingFilterNodeConfiguration#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual20() {
    // Arrange
    TbGpsGeofencingFilterNodeConfiguration tbGpsGeofencingFilterNodeConfiguration = new TbGpsGeofencingFilterNodeConfiguration();
    tbGpsGeofencingFilterNodeConfiguration
        .setLongitudeKeyName("org.thingsboard.rule.engine.geo.TbGpsGeofencingFilterNodeConfiguration");
    TbGpsGeofencingActionNodeConfiguration tbGpsGeofencingActionNodeConfiguration = mock(
        TbGpsGeofencingActionNodeConfiguration.class);
    when(tbGpsGeofencingActionNodeConfiguration.getLatitudeKeyName()).thenReturn(null);
    when(tbGpsGeofencingActionNodeConfiguration.getLongitudeKeyName()).thenReturn("Longitude Key Name");
    when(tbGpsGeofencingActionNodeConfiguration.getPerimeterKeyName()).thenReturn("Perimeter Key Name");
    when(tbGpsGeofencingActionNodeConfiguration.getPolygonsDefinition()).thenReturn("Polygons Definition");
    when(tbGpsGeofencingActionNodeConfiguration.getPerimeterType()).thenReturn(PerimeterType.CIRCLE);
    when(tbGpsGeofencingActionNodeConfiguration.getRangeUnit()).thenReturn(RangeUnit.METER);
    when(tbGpsGeofencingActionNodeConfiguration.getRange()).thenReturn(null);
    when(tbGpsGeofencingActionNodeConfiguration.getCenterLongitude()).thenReturn(null);
    when(tbGpsGeofencingActionNodeConfiguration.isFetchPerimeterInfoFromMessageMetadata()).thenReturn(false);
    when(tbGpsGeofencingActionNodeConfiguration.getCenterLatitude()).thenReturn(null);
    when(tbGpsGeofencingActionNodeConfiguration.canEqual(Mockito.<Object>any())).thenReturn(true);

    // Act and Assert
    assertNotEquals(tbGpsGeofencingFilterNodeConfiguration, tbGpsGeofencingActionNodeConfiguration);
  }

  /**
   * Test {@link TbGpsGeofencingFilterNodeConfiguration#equals(Object)}.
   * <ul>
   *   <li>When other is {@code null}.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link TbGpsGeofencingFilterNodeConfiguration#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is 'null'; then return not equal")
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new TbGpsGeofencingFilterNodeConfiguration(), null);
  }

  /**
   * Test {@link TbGpsGeofencingFilterNodeConfiguration#equals(Object)}.
   * <ul>
   *   <li>When other is wrong type.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link TbGpsGeofencingFilterNodeConfiguration#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is wrong type; then return not equal")
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new TbGpsGeofencingFilterNodeConfiguration(),
        "Different type to TbGpsGeofencingFilterNodeConfiguration");
  }

  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>default or parameterless constructor of
   * {@link TbGpsGeofencingFilterNodeConfiguration}
   *   <li>{@link TbGpsGeofencingFilterNodeConfiguration#setCenterLatitude(Double)}
   *   <li>{@link TbGpsGeofencingFilterNodeConfiguration#setCenterLongitude(Double)}
   *   <li>
   * {@link TbGpsGeofencingFilterNodeConfiguration#setFetchPerimeterInfoFromMessageMetadata(boolean)}
   *   <li>{@link TbGpsGeofencingFilterNodeConfiguration#setLatitudeKeyName(String)}
   *   <li>
   * {@link TbGpsGeofencingFilterNodeConfiguration#setLongitudeKeyName(String)}
   *   <li>
   * {@link TbGpsGeofencingFilterNodeConfiguration#setPerimeterKeyName(String)}
   *   <li>
   * {@link TbGpsGeofencingFilterNodeConfiguration#setPerimeterType(PerimeterType)}
   *   <li>
   * {@link TbGpsGeofencingFilterNodeConfiguration#setPolygonsDefinition(String)}
   *   <li>{@link TbGpsGeofencingFilterNodeConfiguration#setRange(Double)}
   *   <li>{@link TbGpsGeofencingFilterNodeConfiguration#setRangeUnit(RangeUnit)}
   *   <li>{@link TbGpsGeofencingFilterNodeConfiguration#toString()}
   *   <li>{@link TbGpsGeofencingFilterNodeConfiguration#getCenterLatitude()}
   *   <li>{@link TbGpsGeofencingFilterNodeConfiguration#getCenterLongitude()}
   *   <li>{@link TbGpsGeofencingFilterNodeConfiguration#getLatitudeKeyName()}
   *   <li>{@link TbGpsGeofencingFilterNodeConfiguration#getLongitudeKeyName()}
   *   <li>{@link TbGpsGeofencingFilterNodeConfiguration#getPerimeterKeyName()}
   *   <li>{@link TbGpsGeofencingFilterNodeConfiguration#getPerimeterType()}
   *   <li>{@link TbGpsGeofencingFilterNodeConfiguration#getPolygonsDefinition()}
   *   <li>{@link TbGpsGeofencingFilterNodeConfiguration#getRange()}
   *   <li>{@link TbGpsGeofencingFilterNodeConfiguration#getRangeUnit()}
   *   <li>
   * {@link TbGpsGeofencingFilterNodeConfiguration#isFetchPerimeterInfoFromMessageMetadata()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  void testGettersAndSetters() {
    // Arrange and Act
    TbGpsGeofencingFilterNodeConfiguration actualTbGpsGeofencingFilterNodeConfiguration = new TbGpsGeofencingFilterNodeConfiguration();
    actualTbGpsGeofencingFilterNodeConfiguration.setCenterLatitude(10.0d);
    actualTbGpsGeofencingFilterNodeConfiguration.setCenterLongitude(10.0d);
    actualTbGpsGeofencingFilterNodeConfiguration.setFetchPerimeterInfoFromMessageMetadata(true);
    actualTbGpsGeofencingFilterNodeConfiguration.setLatitudeKeyName("Latitude Key Name");
    actualTbGpsGeofencingFilterNodeConfiguration.setLongitudeKeyName("Longitude Key Name");
    actualTbGpsGeofencingFilterNodeConfiguration.setPerimeterKeyName("Perimeter Key Name");
    actualTbGpsGeofencingFilterNodeConfiguration.setPerimeterType(PerimeterType.CIRCLE);
    actualTbGpsGeofencingFilterNodeConfiguration.setPolygonsDefinition("Polygons Definition");
    actualTbGpsGeofencingFilterNodeConfiguration.setRange(10.0d);
    actualTbGpsGeofencingFilterNodeConfiguration.setRangeUnit(RangeUnit.METER);
    String actualToStringResult = actualTbGpsGeofencingFilterNodeConfiguration.toString();
    Double actualCenterLatitude = actualTbGpsGeofencingFilterNodeConfiguration.getCenterLatitude();
    Double actualCenterLongitude = actualTbGpsGeofencingFilterNodeConfiguration.getCenterLongitude();
    String actualLatitudeKeyName = actualTbGpsGeofencingFilterNodeConfiguration.getLatitudeKeyName();
    String actualLongitudeKeyName = actualTbGpsGeofencingFilterNodeConfiguration.getLongitudeKeyName();
    String actualPerimeterKeyName = actualTbGpsGeofencingFilterNodeConfiguration.getPerimeterKeyName();
    PerimeterType actualPerimeterType = actualTbGpsGeofencingFilterNodeConfiguration.getPerimeterType();
    String actualPolygonsDefinition = actualTbGpsGeofencingFilterNodeConfiguration.getPolygonsDefinition();
    Double actualRange = actualTbGpsGeofencingFilterNodeConfiguration.getRange();
    RangeUnit actualRangeUnit = actualTbGpsGeofencingFilterNodeConfiguration.getRangeUnit();
    boolean actualIsFetchPerimeterInfoFromMessageMetadataResult = actualTbGpsGeofencingFilterNodeConfiguration
        .isFetchPerimeterInfoFromMessageMetadata();

    // Assert that nothing has changed
    assertEquals("Latitude Key Name", actualLatitudeKeyName);
    assertEquals("Longitude Key Name", actualLongitudeKeyName);
    assertEquals("Perimeter Key Name", actualPerimeterKeyName);
    assertEquals("Polygons Definition", actualPolygonsDefinition);
    assertEquals("TbGpsGeofencingFilterNodeConfiguration(latitudeKeyName=Latitude Key Name, longitudeKeyName=Longitude"
        + " Key Name, perimeterType=CIRCLE, fetchPerimeterInfoFromMessageMetadata=true, perimeterKeyName=Perimeter"
        + " Key Name, polygonsDefinition=Polygons Definition, centerLatitude=10.0, centerLongitude=10.0, range=10.0,"
        + " rangeUnit=METER)", actualToStringResult);
    assertEquals(10.0d, actualCenterLatitude.doubleValue());
    assertEquals(10.0d, actualCenterLongitude.doubleValue());
    assertEquals(10.0d, actualRange.doubleValue());
    assertEquals(PerimeterType.CIRCLE, actualPerimeterType);
    assertEquals(RangeUnit.METER, actualRangeUnit);
    assertTrue(actualIsFetchPerimeterInfoFromMessageMetadataResult);
  }
}
