package org.thingsboard.rule.engine.geo;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import com.diffblue.cover.annotations.MethodsUnderTest;
import com.fasterxml.jackson.databind.node.NullNode;
import com.fasterxml.jackson.databind.node.POJONode;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.locationtech.spatial4j.context.jts.DatelineRule;
import org.locationtech.spatial4j.context.jts.JtsSpatialContext;
import org.locationtech.spatial4j.context.jts.ValidationRule;
import org.locationtech.spatial4j.distance.GeodesicSphereDistCalc;
import org.locationtech.spatial4j.distance.GeodesicSphereDistCalc.Haversine;
import org.locationtech.spatial4j.io.jts.JtsBinaryCodec;
import org.locationtech.spatial4j.shape.impl.RectangleImpl;
import org.thingsboard.rule.engine.api.TbContext;
import org.thingsboard.rule.engine.api.TbNodeConfiguration;
import org.thingsboard.rule.engine.api.TbNodeException;

class AbstractGeofencingNodeDiffblueTest {
  /**
   * Test {@link AbstractGeofencingNode#init(TbContext, TbNodeConfiguration)}.
   *
   * <ul>
   *   <li>When {@link POJONode#POJONode(Object)} with v is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link AbstractGeofencingNode#init(TbContext, TbNodeConfiguration)}
   */
  @Test
  @DisplayName("Test init(TbContext, TbNodeConfiguration); when POJONode(Object) with v is 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void AbstractGeofencingNode.init(TbContext, TbNodeConfiguration)"})
  void testInit_whenPOJONodeWithVIsNull() throws TbNodeException {
    // Arrange
    TbGpsGeofencingActionNode tbGpsGeofencingActionNode = new TbGpsGeofencingActionNode();
    TbContext ctx = mock(TbContext.class);

    // Act
    tbGpsGeofencingActionNode.init(ctx, new TbNodeConfiguration(new POJONode(null)));

    // Assert
    JtsSpatialContext jtsSpatialContext = tbGpsGeofencingActionNode.jtsCtx;
    assertTrue(jtsSpatialContext.getDistCalc() instanceof Haversine);
    assertTrue(jtsSpatialContext.getBinaryCodec() instanceof JtsBinaryCodec);
    assertTrue(jtsSpatialContext.getWorldBounds() instanceof RectangleImpl);
    assertEquals(DatelineRule.width180, jtsSpatialContext.getDatelineRule());
    assertEquals(ValidationRule.error, jtsSpatialContext.getValidationRule());
    assertFalse(jtsSpatialContext.isAllowMultiOverlap());
    assertFalse(jtsSpatialContext.isAutoIndex());
    assertTrue(jtsSpatialContext.isGeo());
    assertTrue(jtsSpatialContext.isNormWrapLongitude());
  }

  /**
   * Test {@link AbstractGeofencingNode#init(TbContext, TbNodeConfiguration)}.
   *
   * <ul>
   *   <li>When {@link TbNodeConfiguration#TbNodeConfiguration(JsonNode)} with data is Instance.
   * </ul>
   *
   * <p>Method under test: {@link AbstractGeofencingNode#init(TbContext, TbNodeConfiguration)}
   */
  @Test
  @DisplayName(
      "Test init(TbContext, TbNodeConfiguration); when TbNodeConfiguration(JsonNode) with data is Instance")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void AbstractGeofencingNode.init(TbContext, TbNodeConfiguration)"})
  void testInit_whenTbNodeConfigurationWithDataIsInstance() throws TbNodeException {
    // Arrange
    TbGpsGeofencingActionNode tbGpsGeofencingActionNode = new TbGpsGeofencingActionNode();
    TbContext ctx = mock(TbContext.class);

    // Act
    tbGpsGeofencingActionNode.init(ctx, new TbNodeConfiguration(NullNode.getInstance()));

    // Assert
    JtsSpatialContext jtsSpatialContext = tbGpsGeofencingActionNode.jtsCtx;
    assertTrue(jtsSpatialContext.getDistCalc() instanceof Haversine);
    assertTrue(jtsSpatialContext.getBinaryCodec() instanceof JtsBinaryCodec);
    assertTrue(jtsSpatialContext.getWorldBounds() instanceof RectangleImpl);
    assertEquals(DatelineRule.width180, jtsSpatialContext.getDatelineRule());
    assertEquals(ValidationRule.error, jtsSpatialContext.getValidationRule());
    assertFalse(jtsSpatialContext.isAllowMultiOverlap());
    assertFalse(jtsSpatialContext.isAutoIndex());
    assertTrue(jtsSpatialContext.isGeo());
    assertTrue(jtsSpatialContext.isNormWrapLongitude());
  }

  /**
   * Test {@link AbstractGeofencingNode#init(TbContext, TbNodeConfiguration)}.
   *
   * <ul>
   *   <li>When {@link TbNodeConfiguration#TbNodeConfiguration(JsonNode)} with data is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link AbstractGeofencingNode#init(TbContext, TbNodeConfiguration)}
   */
  @Test
  @DisplayName(
      "Test init(TbContext, TbNodeConfiguration); when TbNodeConfiguration(JsonNode) with data is 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void AbstractGeofencingNode.init(TbContext, TbNodeConfiguration)"})
  void testInit_whenTbNodeConfigurationWithDataIsNull() throws TbNodeException {
    // Arrange
    TbGpsGeofencingActionNode tbGpsGeofencingActionNode = new TbGpsGeofencingActionNode();
    TbContext ctx = mock(TbContext.class);

    // Act
    tbGpsGeofencingActionNode.init(ctx, new TbNodeConfiguration(null));

    // Assert
    JtsSpatialContext jtsSpatialContext = tbGpsGeofencingActionNode.jtsCtx;
    assertTrue(jtsSpatialContext.getDistCalc() instanceof Haversine);
    assertTrue(jtsSpatialContext.getBinaryCodec() instanceof JtsBinaryCodec);
    assertTrue(jtsSpatialContext.getWorldBounds() instanceof RectangleImpl);
    assertEquals(DatelineRule.width180, jtsSpatialContext.getDatelineRule());
    assertEquals(ValidationRule.error, jtsSpatialContext.getValidationRule());
    assertFalse(jtsSpatialContext.isAllowMultiOverlap());
    assertFalse(jtsSpatialContext.isAutoIndex());
    assertTrue(jtsSpatialContext.isGeo());
    assertTrue(jtsSpatialContext.isNormWrapLongitude());
  }

  /**
   * Test {@link AbstractGeofencingNode#checkMatches(Perimeter, double, double)} with {@code
   * perimeter}, {@code latitude}, {@code longitude}.
   *
   * <ul>
   *   <li>Given {@code 0.5}.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link AbstractGeofencingNode#checkMatches(Perimeter, double, double)}
   */
  @Test
  @DisplayName(
      "Test checkMatches(Perimeter, double, double) with 'perimeter', 'latitude', 'longitude'; given '0.5'; then return 'false'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean AbstractGeofencingNode.checkMatches(Perimeter, double, double)"})
  void testCheckMatchesWithPerimeterLatitudeLongitude_given05_thenReturnFalse()
      throws TbNodeException {
    // Arrange
    TbGpsGeofencingActionNode tbGpsGeofencingActionNode = new TbGpsGeofencingActionNode();

    Perimeter perimeter = new Perimeter();
    perimeter.setCenterLatitude(0.5d);
    perimeter.setCenterLongitude(10.0d);
    perimeter.setPerimeterType(PerimeterType.CIRCLE);
    perimeter.setPolygonsDefinition("Polygons Definition");
    perimeter.setRange(10.0d);
    perimeter.setRangeUnit(RangeUnit.METER);

    // Act and Assert
    assertFalse(tbGpsGeofencingActionNode.checkMatches(perimeter, 10.0d, 10.0d));
  }

  /**
   * Test {@link AbstractGeofencingNode#checkMatches(Perimeter, double, double)} with {@code
   * perimeter}, {@code latitude}, {@code longitude}.
   *
   * <ul>
   *   <li>Given {@link PerimeterType#CIRCLE}.
   * </ul>
   *
   * <p>Method under test: {@link AbstractGeofencingNode#checkMatches(Perimeter, double, double)}
   */
  @Test
  @DisplayName(
      "Test checkMatches(Perimeter, double, double) with 'perimeter', 'latitude', 'longitude'; given CIRCLE")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean AbstractGeofencingNode.checkMatches(Perimeter, double, double)"})
  void testCheckMatchesWithPerimeterLatitudeLongitude_givenCircle() throws TbNodeException {
    // Arrange
    TbGpsGeofencingActionNode tbGpsGeofencingActionNode = new TbGpsGeofencingActionNode();

    Perimeter perimeter = new Perimeter();
    perimeter.setCenterLatitude(10.0d);
    perimeter.setCenterLongitude(10.0d);
    perimeter.setRange(10.0d);
    perimeter.setRangeUnit(RangeUnit.METER);
    perimeter.setPerimeterType(PerimeterType.CIRCLE);
    perimeter.setPolygonsDefinition(null);

    // Act and Assert
    assertTrue(tbGpsGeofencingActionNode.checkMatches(perimeter, 10.0d, 10.0d));
  }

  /**
   * Test {@link AbstractGeofencingNode#checkMatches(Perimeter, double, double)} with {@code
   * perimeter}, {@code latitude}, {@code longitude}.
   *
   * <ul>
   *   <li>Given {@code CIRCLE}.
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link AbstractGeofencingNode#checkMatches(Perimeter, double, double)}
   */
  @Test
  @DisplayName(
      "Test checkMatches(Perimeter, double, double) with 'perimeter', 'latitude', 'longitude'; given 'CIRCLE'; then return 'true'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean AbstractGeofencingNode.checkMatches(Perimeter, double, double)"})
  void testCheckMatchesWithPerimeterLatitudeLongitude_givenCircle_thenReturnTrue()
      throws TbNodeException {
    // Arrange
    TbGpsGeofencingActionNode tbGpsGeofencingActionNode = new TbGpsGeofencingActionNode();

    Perimeter perimeter = new Perimeter();
    perimeter.setCenterLatitude(10.0d);
    perimeter.setCenterLongitude(10.0d);
    perimeter.setPerimeterType(PerimeterType.CIRCLE);
    perimeter.setPolygonsDefinition("Polygons Definition");
    perimeter.setRange(10.0d);
    perimeter.setRangeUnit(RangeUnit.METER);

    // Act and Assert
    assertTrue(tbGpsGeofencingActionNode.checkMatches(perimeter, 10.0d, 10.0d));
  }
}
