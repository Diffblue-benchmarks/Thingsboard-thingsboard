/**
 * Copyright © 2016-2024 The Thingsboard Authors
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.thingsboard.rule.engine.geo;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import com.fasterxml.jackson.databind.node.NullNode;
import com.fasterxml.jackson.databind.node.POJONode;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import java.util.HashMap;
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
import org.thingsboard.server.common.msg.TbMsg;
import org.thingsboard.server.common.msg.TbMsgMetaData;

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
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
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
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
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
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
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
   * Test {@link AbstractGeofencingNode#checkMatches(TbMsg)} with {@code msg}.
   *
   * <ul>
   *   <li>Given {@code 42}.
   *   <li>When {@link TbMsg} {@link TbMsg#getData()} return {@code 42}.
   * </ul>
   *
   * <p>Method under test: {@link AbstractGeofencingNode#checkMatches(TbMsg)}
   */
  @Test
  @DisplayName("Test checkMatches(TbMsg) with 'msg'; given '42'; when TbMsg getData() return '42'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean AbstractGeofencingNode.checkMatches(TbMsg)"})
  void testCheckMatchesWithMsg_given42_whenTbMsgGetDataReturn42() throws TbNodeException {
    // Arrange
    TbGpsGeofencingActionNode tbGpsGeofencingActionNode = new TbGpsGeofencingActionNode();

    TbMsg msg = mock(TbMsg.class);
    when(msg.getData()).thenReturn("42");

    // Act and Assert
    assertThrows(TbNodeException.class, () -> tbGpsGeofencingActionNode.checkMatches(msg));
    verify(msg).getData();
  }

  /**
   * Test {@link AbstractGeofencingNode#checkMatches(TbMsg)} with {@code msg}.
   *
   * <ul>
   *   <li>Given {@code Data}.
   *   <li>When {@link TbMsg} {@link TbMsg#getData()} return {@code Data}.
   * </ul>
   *
   * <p>Method under test: {@link AbstractGeofencingNode#checkMatches(TbMsg)}
   */
  @Test
  @DisplayName(
      "Test checkMatches(TbMsg) with 'msg'; given 'Data'; when TbMsg getData() return 'Data'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean AbstractGeofencingNode.checkMatches(TbMsg)"})
  void testCheckMatchesWithMsg_givenData_whenTbMsgGetDataReturnData() throws TbNodeException {
    // Arrange
    TbGpsGeofencingActionNode tbGpsGeofencingActionNode = new TbGpsGeofencingActionNode();

    TbMsg msg = mock(TbMsg.class);
    when(msg.getData()).thenReturn("Data");

    // Act and Assert
    assertThrows(TbNodeException.class, () -> tbGpsGeofencingActionNode.checkMatches(msg));
    verify(msg).getData();
  }

  /**
   * Test {@link AbstractGeofencingNode#checkMatches(TbMsg)} with {@code msg}.
   *
   * <ul>
   *   <li>Given empty string.
   *   <li>When {@link TbMsg} {@link TbMsg#getData()} return empty string.
   * </ul>
   *
   * <p>Method under test: {@link AbstractGeofencingNode#checkMatches(TbMsg)}
   */
  @Test
  @DisplayName(
      "Test checkMatches(TbMsg) with 'msg'; given empty string; when TbMsg getData() return empty string")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean AbstractGeofencingNode.checkMatches(TbMsg)"})
  void testCheckMatchesWithMsg_givenEmptyString_whenTbMsgGetDataReturnEmptyString()
      throws TbNodeException {
    // Arrange
    TbGpsGeofencingActionNode tbGpsGeofencingActionNode = new TbGpsGeofencingActionNode();

    TbMsg msg = mock(TbMsg.class);
    when(msg.getData()).thenReturn("");

    // Act and Assert
    assertThrows(TbNodeException.class, () -> tbGpsGeofencingActionNode.checkMatches(msg));
    verify(msg).getData();
  }

  /**
   * Test {@link AbstractGeofencingNode#checkMatches(TbMsg)} with {@code msg}.
   *
   * <ul>
   *   <li>Given {@code foo}.
   *   <li>When {@link TbMsg} {@link TbMsg#getData()} return {@code foo}.
   * </ul>
   *
   * <p>Method under test: {@link AbstractGeofencingNode#checkMatches(TbMsg)}
   */
  @Test
  @DisplayName(
      "Test checkMatches(TbMsg) with 'msg'; given 'foo'; when TbMsg getData() return 'foo'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean AbstractGeofencingNode.checkMatches(TbMsg)"})
  void testCheckMatchesWithMsg_givenFoo_whenTbMsgGetDataReturnFoo() throws TbNodeException {
    // Arrange
    TbGpsGeofencingActionNode tbGpsGeofencingActionNode = new TbGpsGeofencingActionNode();

    TbMsg msg = mock(TbMsg.class);
    when(msg.getData()).thenReturn("foo");

    // Act and Assert
    assertThrows(TbNodeException.class, () -> tbGpsGeofencingActionNode.checkMatches(msg));
    verify(msg).getData();
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
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
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
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
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
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
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

  /**
   * Test {@link AbstractGeofencingNode#getValueFromMessageByName(TbMsg, JsonObject, String)}.
   *
   * <ul>
   *   <li>Given {@code 42}.
   *   <li>Then throw {@link TbNodeException}.
   * </ul>
   *
   * <p>Method under test: {@link AbstractGeofencingNode#getValueFromMessageByName(TbMsg,
   * JsonObject, String)}
   */
  @Test
  @DisplayName(
      "Test getValueFromMessageByName(TbMsg, JsonObject, String); given '42'; then throw TbNodeException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Double AbstractGeofencingNode.getValueFromMessageByName(TbMsg, JsonObject, String)"
  })
  void testGetValueFromMessageByName_given42_thenThrowTbNodeException() throws TbNodeException {
    // Arrange
    TbGpsGeofencingActionNode tbGpsGeofencingActionNode = new TbGpsGeofencingActionNode();

    TbMsg msg = mock(TbMsg.class);
    when(msg.getMetaData()).thenReturn(new TbMsgMetaData(new HashMap<>()));

    JsonObject msgDataObj = new JsonObject();
    msgDataObj.add("42", new JsonArray(3));
    msgDataObj.add("Property", new JsonArray(3));

    // Act and Assert
    assertThrows(
        TbNodeException.class,
        () -> tbGpsGeofencingActionNode.getValueFromMessageByName(msg, msgDataObj, "Key Name"));
    verify(msg).getMetaData();
  }

  /**
   * Test {@link AbstractGeofencingNode#getValueFromMessageByName(TbMsg, JsonObject, String)}.
   *
   * <ul>
   *   <li>Given {@code 42}.
   *   <li>When {@code 42}.
   *   <li>Then throw {@link TbNodeException}.
   * </ul>
   *
   * <p>Method under test: {@link AbstractGeofencingNode#getValueFromMessageByName(TbMsg,
   * JsonObject, String)}
   */
  @Test
  @DisplayName(
      "Test getValueFromMessageByName(TbMsg, JsonObject, String); given '42'; when '42'; then throw TbNodeException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Double AbstractGeofencingNode.getValueFromMessageByName(TbMsg, JsonObject, String)"
  })
  void testGetValueFromMessageByName_given42_when42_thenThrowTbNodeException()
      throws TbNodeException {
    // Arrange
    TbGpsGeofencingActionNode tbGpsGeofencingActionNode = new TbGpsGeofencingActionNode();

    TbMsg msg = mock(TbMsg.class);
    when(msg.getMetaData()).thenReturn(new TbMsgMetaData(new HashMap<>()));

    JsonObject msgDataObj = new JsonObject();
    msgDataObj.add("42", new JsonArray(3));
    msgDataObj.add("Property", new JsonArray(3));

    // Act and Assert
    assertThrows(
        TbNodeException.class,
        () -> tbGpsGeofencingActionNode.getValueFromMessageByName(msg, msgDataObj, "42"));
    verify(msg).getMetaData();
  }

  /**
   * Test {@link AbstractGeofencingNode#getValueFromMessageByName(TbMsg, JsonObject, String)}.
   *
   * <ul>
   *   <li>Given {@link HashMap#HashMap()} {@code 42} is {@code 42}.
   *   <li>Then return doubleValue is forty-two.
   * </ul>
   *
   * <p>Method under test: {@link AbstractGeofencingNode#getValueFromMessageByName(TbMsg,
   * JsonObject, String)}
   */
  @Test
  @DisplayName(
      "Test getValueFromMessageByName(TbMsg, JsonObject, String); given HashMap() '42' is '42'; then return doubleValue is forty-two")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Double AbstractGeofencingNode.getValueFromMessageByName(TbMsg, JsonObject, String)"
  })
  void testGetValueFromMessageByName_givenHashMap42Is42_thenReturnDoubleValueIsFortyTwo()
      throws TbNodeException {
    // Arrange
    TbGpsGeofencingActionNode tbGpsGeofencingActionNode = new TbGpsGeofencingActionNode();

    HashMap<String, String> data = new HashMap<>();
    data.put("42", "42");

    TbMsg msg = mock(TbMsg.class);
    when(msg.getMetaData()).thenReturn(new TbMsgMetaData(data));

    JsonObject msgDataObj = new JsonObject();
    msgDataObj.add("42", new JsonArray(3));
    msgDataObj.add("Property", new JsonArray(3));

    // Act
    Double actualValueFromMessageByName =
        tbGpsGeofencingActionNode.getValueFromMessageByName(msg, msgDataObj, "42");

    // Assert
    verify(msg).getMetaData();
    assertEquals(42.0d, actualValueFromMessageByName.doubleValue());
  }

  /**
   * Test {@link AbstractGeofencingNode#getValueFromMessageByName(TbMsg, JsonObject, String)}.
   *
   * <ul>
   *   <li>Given {@code Property}.
   *   <li>Then throw {@link TbNodeException}.
   * </ul>
   *
   * <p>Method under test: {@link AbstractGeofencingNode#getValueFromMessageByName(TbMsg,
   * JsonObject, String)}
   */
  @Test
  @DisplayName(
      "Test getValueFromMessageByName(TbMsg, JsonObject, String); given 'Property'; then throw TbNodeException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Double AbstractGeofencingNode.getValueFromMessageByName(TbMsg, JsonObject, String)"
  })
  void testGetValueFromMessageByName_givenProperty_thenThrowTbNodeException()
      throws TbNodeException {
    // Arrange
    TbGpsGeofencingActionNode tbGpsGeofencingActionNode = new TbGpsGeofencingActionNode();

    TbMsg msg = mock(TbMsg.class);
    when(msg.getMetaData()).thenReturn(new TbMsgMetaData(new HashMap<>()));

    JsonObject msgDataObj = new JsonObject();
    msgDataObj.add("Property", new JsonArray(3));

    // Act and Assert
    assertThrows(
        TbNodeException.class,
        () -> tbGpsGeofencingActionNode.getValueFromMessageByName(msg, msgDataObj, "Key Name"));
    verify(msg).getMetaData();
  }

  /**
   * Test {@link AbstractGeofencingNode#getValueFromMessageByName(TbMsg, JsonObject, String)}.
   *
   * <ul>
   *   <li>When {@link JsonObject} (default constructor).
   *   <li>Then throw {@link TbNodeException}.
   * </ul>
   *
   * <p>Method under test: {@link AbstractGeofencingNode#getValueFromMessageByName(TbMsg,
   * JsonObject, String)}
   */
  @Test
  @DisplayName(
      "Test getValueFromMessageByName(TbMsg, JsonObject, String); when JsonObject (default constructor); then throw TbNodeException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Double AbstractGeofencingNode.getValueFromMessageByName(TbMsg, JsonObject, String)"
  })
  void testGetValueFromMessageByName_whenJsonObject_thenThrowTbNodeException()
      throws TbNodeException {
    // Arrange
    TbGpsGeofencingActionNode tbGpsGeofencingActionNode = new TbGpsGeofencingActionNode();

    TbMsg msg = mock(TbMsg.class);
    when(msg.getMetaData()).thenReturn(new TbMsgMetaData(new HashMap<>()));

    // Act and Assert
    assertThrows(
        TbNodeException.class,
        () ->
            tbGpsGeofencingActionNode.getValueFromMessageByName(msg, new JsonObject(), "Key Name"));
    verify(msg).getMetaData();
  }
}
