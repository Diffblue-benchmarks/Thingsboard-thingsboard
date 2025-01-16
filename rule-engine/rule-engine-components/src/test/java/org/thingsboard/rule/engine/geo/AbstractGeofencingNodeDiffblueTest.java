package org.thingsboard.rule.engine.geo;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import com.fasterxml.jackson.databind.node.NullNode;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.locationtech.jts.geom.GeometryFactory;
import org.locationtech.jts.geom.PrecisionModel;
import org.locationtech.jts.geom.impl.CoordinateArraySequenceFactory;
import org.locationtech.spatial4j.context.jts.DatelineRule;
import org.locationtech.spatial4j.context.jts.JtsSpatialContext;
import org.locationtech.spatial4j.context.jts.ValidationRule;
import org.locationtech.spatial4j.distance.GeodesicSphereDistCalc;
import org.locationtech.spatial4j.io.LegacyShapeReader;
import org.locationtech.spatial4j.io.LegacyShapeWriter;
import org.locationtech.spatial4j.io.PolyshapeReader;
import org.locationtech.spatial4j.io.ShapeReader;
import org.locationtech.spatial4j.io.ShapeWriter;
import org.locationtech.spatial4j.io.SupportedFormats;
import org.locationtech.spatial4j.io.WKTReader;
import org.locationtech.spatial4j.io.jts.JtsBinaryCodec;
import org.locationtech.spatial4j.io.jts.JtsGeoJSONWriter;
import org.locationtech.spatial4j.io.jts.JtsPolyshapeWriter;
import org.locationtech.spatial4j.io.jts.JtsWKTWriter;
import org.locationtech.spatial4j.shape.Point;
import org.locationtech.spatial4j.shape.Rectangle;
import org.locationtech.spatial4j.shape.impl.PointImpl;
import org.locationtech.spatial4j.shape.impl.RectangleImpl;
import org.locationtech.spatial4j.shape.jts.JtsShapeFactory;
import org.thingsboard.rule.engine.api.TbContext;
import org.thingsboard.rule.engine.api.TbNodeConfiguration;
import org.thingsboard.rule.engine.api.TbNodeException;

class AbstractGeofencingNodeDiffblueTest {
  /**
   * Test {@link AbstractGeofencingNode#init(TbContext, TbNodeConfiguration)}.
   * <p>
   * Method under test:
   * {@link AbstractGeofencingNode#init(TbContext, TbNodeConfiguration)}
   */
  @Test
  @DisplayName("Test init(TbContext, TbNodeConfiguration)")
  void testInit() throws TbNodeException {
    // Arrange
    TbGpsGeofencingActionNode tbGpsGeofencingActionNode = new TbGpsGeofencingActionNode();
    TbContext ctx = mock(TbContext.class);

    // Act
    tbGpsGeofencingActionNode.init(ctx, new TbNodeConfiguration(NullNode.getInstance()));

    // Assert
    JtsSpatialContext jtsSpatialContext = tbGpsGeofencingActionNode.jtsCtx;
    GeometryFactory geometryFactory = jtsSpatialContext.getGeometryFactory();
    assertTrue(geometryFactory.getCoordinateSequenceFactory() instanceof CoordinateArraySequenceFactory);
    assertTrue(jtsSpatialContext.getDistCalc() instanceof GeodesicSphereDistCalc.Haversine);
    SupportedFormats formats = jtsSpatialContext.getFormats();
    List<ShapeReader> readers = formats.getReaders();
    assertEquals(3, readers.size());
    ShapeReader getResult = readers.get(2);
    assertTrue(getResult instanceof LegacyShapeReader);
    List<ShapeWriter> writers = formats.getWriters();
    assertEquals(4, writers.size());
    ShapeWriter getResult2 = writers.get(3);
    assertTrue(getResult2 instanceof LegacyShapeWriter);
    ShapeReader getResult3 = readers.get(1);
    assertTrue(getResult3 instanceof PolyshapeReader);
    assertTrue(jtsSpatialContext.getBinaryCodec() instanceof JtsBinaryCodec);
    ShapeWriter geoJsonWriter = formats.getGeoJsonWriter();
    assertTrue(geoJsonWriter instanceof JtsGeoJSONWriter);
    ShapeWriter getResult4 = writers.get(2);
    assertTrue(getResult4 instanceof JtsPolyshapeWriter);
    ShapeWriter wktWriter = formats.getWktWriter();
    assertTrue(wktWriter instanceof JtsWKTWriter);
    Rectangle worldBounds = jtsSpatialContext.getWorldBounds();
    Point center = worldBounds.getCenter();
    assertTrue(center instanceof PointImpl);
    Rectangle boundingBox = center.getBoundingBox();
    Point center2 = boundingBox.getCenter();
    assertTrue(center2 instanceof PointImpl);
    assertTrue(worldBounds instanceof RectangleImpl);
    assertTrue(boundingBox instanceof RectangleImpl);
    PrecisionModel precisionModel = geometryFactory.getPrecisionModel();
    assertEquals("FLOATING", precisionModel.getType().toString());
    assertEquals("GeoJSON", geoJsonWriter.getFormatName());
    assertEquals("LEGACY", getResult.getFormatName());
    assertEquals("LEGACY", getResult2.getFormatName());
    assertEquals("POLY", getResult3.getFormatName());
    assertEquals("POLY", getResult4.getFormatName());
    assertEquals("WKT", wktWriter.getFormatName());
    WKTReader wktShapeParser = jtsSpatialContext.getWktShapeParser();
    assertEquals("WKT", wktShapeParser.getFormatName());
    assertNull(formats.getGeoJsonReader());
    assertEquals(-180.0d, worldBounds.getMinX());
    assertEquals(-90.0d, worldBounds.getMinY());
    assertEquals(0, geometryFactory.getSRID());
    assertEquals(0.0d, precisionModel.getOffsetX());
    assertEquals(0.0d, precisionModel.getOffsetY());
    assertEquals(0.0d, precisionModel.getScale());
    assertEquals(0.0d, center.getLat());
    assertEquals(0.0d, center.getLon());
    assertEquals(0.0d, center.getX());
    assertEquals(0.0d, center.getY());
    assertEquals(0.0d, boundingBox.getHeight());
    assertEquals(0.0d, boundingBox.getMaxX());
    assertEquals(0.0d, boundingBox.getMaxY());
    assertEquals(0.0d, boundingBox.getMinX());
    assertEquals(0.0d, boundingBox.getMinY());
    assertEquals(0.0d, boundingBox.getWidth());
    assertEquals(180.0d, worldBounds.getHeight());
    assertEquals(180.0d, worldBounds.getMaxX());
    assertEquals(360.0d, worldBounds.getWidth());
    assertEquals(90.0d, worldBounds.getMaxY());
    assertEquals(DatelineRule.width180, jtsSpatialContext.getDatelineRule());
    JtsShapeFactory shapeFactory = jtsSpatialContext.getShapeFactory();
    assertEquals(DatelineRule.width180, shapeFactory.getDatelineRule());
    assertEquals(ValidationRule.error, jtsSpatialContext.getValidationRule());
    assertEquals(ValidationRule.error, shapeFactory.getValidationRule());
    assertFalse(jtsSpatialContext.isAllowMultiOverlap());
    assertFalse(jtsSpatialContext.isAutoIndex());
    assertFalse(worldBounds.getCrossesDateLine());
    assertFalse(boundingBox.getCrossesDateLine());
    assertFalse(boundingBox.hasArea());
    assertFalse(center.hasArea());
    assertFalse(worldBounds.isEmpty());
    assertFalse(boundingBox.isEmpty());
    assertFalse(center.isEmpty());
    assertFalse(shapeFactory.isAllowMultiOverlap());
    assertFalse(shapeFactory.isAutoIndex());
    assertTrue(precisionModel.isFloating());
    assertTrue(jtsSpatialContext.isGeo());
    assertTrue(jtsSpatialContext.isNormWrapLongitude());
    assertTrue(worldBounds.hasArea());
    assertTrue(shapeFactory.isNormWrapLongitude());
    assertTrue(shapeFactory.useJtsLineString());
    assertTrue(shapeFactory.useJtsMulti());
    assertTrue(shapeFactory.useJtsPoint());
    assertEquals(Double.NaN, precisionModel.gridSize());
    assertEquals(Short.SIZE, precisionModel.getMaximumSignificantDigits());
    assertEquals(center, center2);
    assertSame(wktShapeParser, readers.get(0));
    assertSame(wktShapeParser, formats.getWktReader());
    assertSame(geometryFactory, shapeFactory.getGeometryFactory());
    JtsSpatialContext jtsSpatialContext2 = tbGpsGeofencingActionNode.jtsCtx;
    assertSame(jtsSpatialContext2, worldBounds.getContext());
    assertSame(jtsSpatialContext2, boundingBox.getContext());
    assertSame(jtsSpatialContext2, center.getContext());
    assertSame(jtsSpatialContext2, shapeFactory.getSpatialContext());
    assertSame(geoJsonWriter, writers.get(0));
    assertSame(wktWriter, writers.get(1));
  }

  /**
   * Test {@link AbstractGeofencingNode#init(TbContext, TbNodeConfiguration)}.
   * <ul>
   *   <li>When {@link TbNodeConfiguration#TbNodeConfiguration(JsonNode)} with data
   * is {@code null}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link AbstractGeofencingNode#init(TbContext, TbNodeConfiguration)}
   */
  @Test
  @DisplayName("Test init(TbContext, TbNodeConfiguration); when TbNodeConfiguration(JsonNode) with data is 'null'")
  void testInit_whenTbNodeConfigurationWithDataIsNull() throws TbNodeException {
    // Arrange
    TbGpsGeofencingActionNode tbGpsGeofencingActionNode = new TbGpsGeofencingActionNode();
    TbContext ctx = mock(TbContext.class);

    // Act
    tbGpsGeofencingActionNode.init(ctx, new TbNodeConfiguration(null));

    // Assert
    JtsSpatialContext jtsSpatialContext = tbGpsGeofencingActionNode.jtsCtx;
    GeometryFactory geometryFactory = jtsSpatialContext.getGeometryFactory();
    assertTrue(geometryFactory.getCoordinateSequenceFactory() instanceof CoordinateArraySequenceFactory);
    assertTrue(jtsSpatialContext.getDistCalc() instanceof GeodesicSphereDistCalc.Haversine);
    SupportedFormats formats = jtsSpatialContext.getFormats();
    List<ShapeReader> readers = formats.getReaders();
    assertEquals(3, readers.size());
    ShapeReader getResult = readers.get(2);
    assertTrue(getResult instanceof LegacyShapeReader);
    List<ShapeWriter> writers = formats.getWriters();
    assertEquals(4, writers.size());
    ShapeWriter getResult2 = writers.get(3);
    assertTrue(getResult2 instanceof LegacyShapeWriter);
    ShapeReader getResult3 = readers.get(1);
    assertTrue(getResult3 instanceof PolyshapeReader);
    assertTrue(jtsSpatialContext.getBinaryCodec() instanceof JtsBinaryCodec);
    ShapeWriter geoJsonWriter = formats.getGeoJsonWriter();
    assertTrue(geoJsonWriter instanceof JtsGeoJSONWriter);
    ShapeWriter getResult4 = writers.get(2);
    assertTrue(getResult4 instanceof JtsPolyshapeWriter);
    ShapeWriter wktWriter = formats.getWktWriter();
    assertTrue(wktWriter instanceof JtsWKTWriter);
    Rectangle worldBounds = jtsSpatialContext.getWorldBounds();
    Point center = worldBounds.getCenter();
    assertTrue(center instanceof PointImpl);
    Rectangle boundingBox = center.getBoundingBox();
    Point center2 = boundingBox.getCenter();
    assertTrue(center2 instanceof PointImpl);
    assertTrue(worldBounds instanceof RectangleImpl);
    assertTrue(boundingBox instanceof RectangleImpl);
    PrecisionModel precisionModel = geometryFactory.getPrecisionModel();
    assertEquals("FLOATING", precisionModel.getType().toString());
    assertEquals("GeoJSON", geoJsonWriter.getFormatName());
    assertEquals("LEGACY", getResult.getFormatName());
    assertEquals("LEGACY", getResult2.getFormatName());
    assertEquals("POLY", getResult3.getFormatName());
    assertEquals("POLY", getResult4.getFormatName());
    assertEquals("WKT", wktWriter.getFormatName());
    WKTReader wktShapeParser = jtsSpatialContext.getWktShapeParser();
    assertEquals("WKT", wktShapeParser.getFormatName());
    assertNull(formats.getGeoJsonReader());
    assertEquals(-180.0d, worldBounds.getMinX());
    assertEquals(-90.0d, worldBounds.getMinY());
    assertEquals(0, geometryFactory.getSRID());
    assertEquals(0.0d, precisionModel.getOffsetX());
    assertEquals(0.0d, precisionModel.getOffsetY());
    assertEquals(0.0d, precisionModel.getScale());
    assertEquals(0.0d, center.getLat());
    assertEquals(0.0d, center.getLon());
    assertEquals(0.0d, center.getX());
    assertEquals(0.0d, center.getY());
    assertEquals(0.0d, boundingBox.getHeight());
    assertEquals(0.0d, boundingBox.getMaxX());
    assertEquals(0.0d, boundingBox.getMaxY());
    assertEquals(0.0d, boundingBox.getMinX());
    assertEquals(0.0d, boundingBox.getMinY());
    assertEquals(0.0d, boundingBox.getWidth());
    assertEquals(180.0d, worldBounds.getHeight());
    assertEquals(180.0d, worldBounds.getMaxX());
    assertEquals(360.0d, worldBounds.getWidth());
    assertEquals(90.0d, worldBounds.getMaxY());
    assertEquals(DatelineRule.width180, jtsSpatialContext.getDatelineRule());
    JtsShapeFactory shapeFactory = jtsSpatialContext.getShapeFactory();
    assertEquals(DatelineRule.width180, shapeFactory.getDatelineRule());
    assertEquals(ValidationRule.error, jtsSpatialContext.getValidationRule());
    assertEquals(ValidationRule.error, shapeFactory.getValidationRule());
    assertFalse(jtsSpatialContext.isAllowMultiOverlap());
    assertFalse(jtsSpatialContext.isAutoIndex());
    assertFalse(worldBounds.getCrossesDateLine());
    assertFalse(boundingBox.getCrossesDateLine());
    assertFalse(boundingBox.hasArea());
    assertFalse(center.hasArea());
    assertFalse(worldBounds.isEmpty());
    assertFalse(boundingBox.isEmpty());
    assertFalse(center.isEmpty());
    assertFalse(shapeFactory.isAllowMultiOverlap());
    assertFalse(shapeFactory.isAutoIndex());
    assertTrue(precisionModel.isFloating());
    assertTrue(jtsSpatialContext.isGeo());
    assertTrue(jtsSpatialContext.isNormWrapLongitude());
    assertTrue(worldBounds.hasArea());
    assertTrue(shapeFactory.isNormWrapLongitude());
    assertTrue(shapeFactory.useJtsLineString());
    assertTrue(shapeFactory.useJtsMulti());
    assertTrue(shapeFactory.useJtsPoint());
    assertEquals(Double.NaN, precisionModel.gridSize());
    assertEquals(Short.SIZE, precisionModel.getMaximumSignificantDigits());
    assertEquals(center, center2);
    assertSame(wktShapeParser, readers.get(0));
    assertSame(wktShapeParser, formats.getWktReader());
    assertSame(geometryFactory, shapeFactory.getGeometryFactory());
    JtsSpatialContext jtsSpatialContext2 = tbGpsGeofencingActionNode.jtsCtx;
    assertSame(jtsSpatialContext2, worldBounds.getContext());
    assertSame(jtsSpatialContext2, boundingBox.getContext());
    assertSame(jtsSpatialContext2, center.getContext());
    assertSame(jtsSpatialContext2, shapeFactory.getSpatialContext());
    assertSame(geoJsonWriter, writers.get(0));
    assertSame(wktWriter, writers.get(1));
  }

  /**
   * Test {@link AbstractGeofencingNode#checkMatches(Perimeter, double, double)}
   * with {@code perimeter}, {@code latitude}, {@code longitude}.
   * <ul>
   *   <li>Given {@code 0.5}.</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link AbstractGeofencingNode#checkMatches(Perimeter, double, double)}
   */
  @Test
  @DisplayName("Test checkMatches(Perimeter, double, double) with 'perimeter', 'latitude', 'longitude'; given '0.5'; then return 'false'")
  void testCheckMatchesWithPerimeterLatitudeLongitude_given05_thenReturnFalse() throws TbNodeException {
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
   * Test {@link AbstractGeofencingNode#checkMatches(Perimeter, double, double)}
   * with {@code perimeter}, {@code latitude}, {@code longitude}.
   * <ul>
   *   <li>Given {@link PerimeterType#CIRCLE}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link AbstractGeofencingNode#checkMatches(Perimeter, double, double)}
   */
  @Test
  @DisplayName("Test checkMatches(Perimeter, double, double) with 'perimeter', 'latitude', 'longitude'; given CIRCLE")
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
   * Test {@link AbstractGeofencingNode#checkMatches(Perimeter, double, double)}
   * with {@code perimeter}, {@code latitude}, {@code longitude}.
   * <ul>
   *   <li>Given {@code CIRCLE}.</li>
   *   <li>Then return {@code true}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link AbstractGeofencingNode#checkMatches(Perimeter, double, double)}
   */
  @Test
  @DisplayName("Test checkMatches(Perimeter, double, double) with 'perimeter', 'latitude', 'longitude'; given 'CIRCLE'; then return 'true'")
  void testCheckMatchesWithPerimeterLatitudeLongitude_givenCircle_thenReturnTrue() throws TbNodeException {
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
