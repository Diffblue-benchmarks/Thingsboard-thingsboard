package org.thingsboard.rule.engine.geo;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import com.fasterxml.jackson.databind.node.NullNode;
import com.fasterxml.jackson.databind.node.POJONode;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import java.util.UUID;
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
import org.thingsboard.rule.engine.action.TbContextMinimalFactory;
import org.thingsboard.rule.engine.action.TbTelemetryMsgFactory;
import org.thingsboard.rule.engine.api.TbContext;
import org.thingsboard.rule.engine.api.TbNodeConfiguration;
import org.thingsboard.rule.engine.api.TbNodeException;
import org.thingsboard.server.common.data.id.CustomerId;
import org.thingsboard.server.common.data.id.RuleChainId;
import org.thingsboard.server.common.data.id.RuleNodeId;
import org.thingsboard.server.common.data.msg.TbMsgType;
import org.thingsboard.server.common.msg.TbMsg;
import org.thingsboard.server.common.msg.TbMsg.TbMsgBuilder;
import org.thingsboard.server.common.msg.TbMsgDataType;
import org.thingsboard.server.common.msg.TbMsgMetaData;
import org.thingsboard.server.common.msg.TbMsgProcessingCtx;
import org.thingsboard.server.common.msg.queue.TbMsgCallback;

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
    TbContext ctx = TbContextMinimalFactory.minimalForOnMsg();

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
    TbContext ctx = TbContextMinimalFactory.minimalForOnMsg();

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
    TbContext ctx = TbContextMinimalFactory.minimalForOnMsg();

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
   * <p>Method under test: {@link AbstractGeofencingNode#checkMatches(TbMsg)}
   */
  @Test
  @DisplayName("Test checkMatches(TbMsg) with 'msg'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean AbstractGeofencingNode.checkMatches(TbMsg)"})
  void testCheckMatchesWithMsg() throws TbNodeException {
    // Arrange
    TbGpsGeofencingActionNode tbGpsGeofencingActionNode = new TbGpsGeofencingActionNode();

    TbMsgBuilder callbackResult = TbMsg.builder().callback(TbMsgCallback.EMPTY);

    TbMsgBuilder correlationIdResult =
        callbackResult.correlationId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    TbMsgBuilder ctxResult = correlationIdResult.ctx(new TbMsgProcessingCtx());

    TbMsgBuilder dataTypeResult =
        ctxResult
            .customerId(new CustomerId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")))
            .data("Data")
            .dataType(TbMsgDataType.JSON);

    TbMsgBuilder internalTypeResult =
        dataTypeResult
            .id(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"))
            .internalType(TbMsgType.POST_ATTRIBUTES_REQUEST);

    TbMsgBuilder queueNameResult =
        internalTypeResult
            .metaData(new TbMsgMetaData())
            .originator(null)
            .partition(1)
            .queueName("Queue Name");

    TbMsgBuilder ruleChainIdResult =
        queueNameResult.ruleChainId(
            new RuleChainId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")));

    // Act and Assert
    assertThrows(
        TbNodeException.class,
        () ->
            tbGpsGeofencingActionNode.checkMatches(
                ruleChainIdResult
                    .ruleNodeId(
                        new RuleNodeId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")))
                    .ts(1L)
                    .type("Type")
                    .build()));
  }

  /**
   * Test {@link AbstractGeofencingNode#checkMatches(TbMsg)} with {@code msg}.
   *
   * <p>Method under test: {@link AbstractGeofencingNode#checkMatches(TbMsg)}
   */
  @Test
  @DisplayName("Test checkMatches(TbMsg) with 'msg'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean AbstractGeofencingNode.checkMatches(TbMsg)"})
  void testCheckMatchesWithMsg2() throws TbNodeException {
    // Arrange
    TbGpsGeofencingActionNode tbGpsGeofencingActionNode = new TbGpsGeofencingActionNode();

    TbMsgBuilder callbackResult = TbMsg.builder().callback(TbMsgCallback.EMPTY);

    TbMsgBuilder correlationIdResult =
        callbackResult.correlationId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    TbMsgBuilder ctxResult = correlationIdResult.ctx(new TbMsgProcessingCtx());

    TbMsgBuilder dataTypeResult =
        ctxResult
            .customerId(new CustomerId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")))
            .data("42")
            .dataType(TbMsgDataType.JSON);

    TbMsgBuilder internalTypeResult =
        dataTypeResult
            .id(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"))
            .internalType(TbMsgType.POST_ATTRIBUTES_REQUEST);

    TbMsgBuilder queueNameResult =
        internalTypeResult
            .metaData(new TbMsgMetaData())
            .originator(null)
            .partition(1)
            .queueName("Queue Name");

    TbMsgBuilder ruleChainIdResult =
        queueNameResult.ruleChainId(
            new RuleChainId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")));

    // Act and Assert
    assertThrows(
        TbNodeException.class,
        () ->
            tbGpsGeofencingActionNode.checkMatches(
                ruleChainIdResult
                    .ruleNodeId(
                        new RuleNodeId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")))
                    .ts(1L)
                    .type("Type")
                    .build()));
  }

  /**
   * Test {@link AbstractGeofencingNode#checkMatches(TbMsg)} with {@code msg}.
   *
   * <p>Method under test: {@link AbstractGeofencingNode#checkMatches(TbMsg)}
   */
  @Test
  @DisplayName("Test checkMatches(TbMsg) with 'msg'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean AbstractGeofencingNode.checkMatches(TbMsg)"})
  void testCheckMatchesWithMsg3() throws TbNodeException {
    // Arrange
    TbGpsGeofencingActionNode tbGpsGeofencingActionNode = new TbGpsGeofencingActionNode();

    TbMsgBuilder callbackResult = TbMsg.builder().callback(TbMsgCallback.EMPTY);

    TbMsgBuilder correlationIdResult =
        callbackResult.correlationId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    TbMsgBuilder ctxResult = correlationIdResult.ctx(new TbMsgProcessingCtx());

    TbMsgBuilder dataTypeResult =
        ctxResult
            .customerId(new CustomerId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")))
            .data("")
            .dataType(TbMsgDataType.JSON);

    TbMsgBuilder internalTypeResult =
        dataTypeResult
            .id(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"))
            .internalType(TbMsgType.POST_ATTRIBUTES_REQUEST);

    TbMsgBuilder queueNameResult =
        internalTypeResult
            .metaData(new TbMsgMetaData())
            .originator(null)
            .partition(1)
            .queueName("Queue Name");

    TbMsgBuilder ruleChainIdResult =
        queueNameResult.ruleChainId(
            new RuleChainId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")));

    // Act and Assert
    assertThrows(
        TbNodeException.class,
        () ->
            tbGpsGeofencingActionNode.checkMatches(
                ruleChainIdResult
                    .ruleNodeId(
                        new RuleNodeId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")))
                    .ts(1L)
                    .type("Type")
                    .build()));
  }

  /**
   * Test {@link AbstractGeofencingNode#checkMatches(TbMsg)} with {@code msg}.
   *
   * <p>Method under test: {@link AbstractGeofencingNode#checkMatches(TbMsg)}
   */
  @Test
  @DisplayName("Test checkMatches(TbMsg) with 'msg'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean AbstractGeofencingNode.checkMatches(TbMsg)"})
  void testCheckMatchesWithMsg4() throws TbNodeException {
    // Arrange
    TbGpsGeofencingActionNode tbGpsGeofencingActionNode = new TbGpsGeofencingActionNode();

    TbMsgBuilder callbackResult = TbMsg.builder().callback(mock(TbMsgCallback.class));

    TbMsgBuilder correlationIdResult =
        callbackResult.correlationId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    TbMsgBuilder ctxResult = correlationIdResult.ctx(new TbMsgProcessingCtx());

    TbMsgBuilder dataTypeResult =
        ctxResult
            .customerId(new CustomerId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")))
            .data("")
            .dataType(TbMsgDataType.JSON);

    TbMsgBuilder internalTypeResult =
        dataTypeResult
            .id(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"))
            .internalType(TbMsgType.POST_ATTRIBUTES_REQUEST);

    TbMsgBuilder queueNameResult =
        internalTypeResult
            .metaData(new TbMsgMetaData())
            .originator(null)
            .partition(1)
            .queueName("Queue Name");

    TbMsgBuilder ruleChainIdResult =
        queueNameResult.ruleChainId(
            new RuleChainId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")));

    // Act and Assert
    assertThrows(
        TbNodeException.class,
        () ->
            tbGpsGeofencingActionNode.checkMatches(
                ruleChainIdResult
                    .ruleNodeId(
                        new RuleNodeId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")))
                    .ts(1L)
                    .type("Type")
                    .build()));
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
    perimeter.setPolygonsDefinition("");

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
    "java.lang.Double AbstractGeofencingNode.getValueFromMessageByName(TbMsg, JsonObject, String)"
  })
  void testGetValueFromMessageByName_given42_when42_thenThrowTbNodeException()
      throws TbNodeException {
    // Arrange
    TbGpsGeofencingActionNode tbGpsGeofencingActionNode = new TbGpsGeofencingActionNode();
    TbMsg msg =
        TbTelemetryMsgFactory.telemetryMsg(null, "Key", TbContextMinimalFactory.minimalForOnMsg());

    JsonObject msgDataObj = new JsonObject();
    msgDataObj.add("42", new JsonArray());
    msgDataObj.add("Property", new JsonArray());

    // Act and Assert
    assertThrows(
        TbNodeException.class,
        () -> tbGpsGeofencingActionNode.getValueFromMessageByName(msg, msgDataObj, "42"));
  }

  /**
   * Test {@link AbstractGeofencingNode#getValueFromMessageByName(TbMsg, JsonObject, String)}.
   *
   * <ul>
   *   <li>Given {@code 42}.
   *   <li>When {@link JsonObject} (default constructor) add {@code 42} and {@link
   *       JsonArray#JsonArray()}.
   * </ul>
   *
   * <p>Method under test: {@link AbstractGeofencingNode#getValueFromMessageByName(TbMsg,
   * JsonObject, String)}
   */
  @Test
  @DisplayName(
      "Test getValueFromMessageByName(TbMsg, JsonObject, String); given '42'; when JsonObject (default constructor) add '42' and JsonArray()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "java.lang.Double AbstractGeofencingNode.getValueFromMessageByName(TbMsg, JsonObject, String)"
  })
  void testGetValueFromMessageByName_given42_whenJsonObjectAdd42AndJsonArray()
      throws TbNodeException {
    // Arrange
    TbGpsGeofencingActionNode tbGpsGeofencingActionNode = new TbGpsGeofencingActionNode();
    TbMsg msg =
        TbTelemetryMsgFactory.telemetryMsg(null, "Key", TbContextMinimalFactory.minimalForOnMsg());

    JsonObject msgDataObj = new JsonObject();
    msgDataObj.add("42", new JsonArray());
    msgDataObj.add("Property", new JsonArray());

    // Act and Assert
    assertThrows(
        TbNodeException.class,
        () -> tbGpsGeofencingActionNode.getValueFromMessageByName(msg, msgDataObj, "Key Name"));
  }

  /**
   * Test {@link AbstractGeofencingNode#getValueFromMessageByName(TbMsg, JsonObject, String)}.
   *
   * <ul>
   *   <li>Given {@code Property}.
   * </ul>
   *
   * <p>Method under test: {@link AbstractGeofencingNode#getValueFromMessageByName(TbMsg,
   * JsonObject, String)}
   */
  @Test
  @DisplayName("Test getValueFromMessageByName(TbMsg, JsonObject, String); given 'Property'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "java.lang.Double AbstractGeofencingNode.getValueFromMessageByName(TbMsg, JsonObject, String)"
  })
  void testGetValueFromMessageByName_givenProperty() throws TbNodeException {
    // Arrange
    TbGpsGeofencingActionNode tbGpsGeofencingActionNode = new TbGpsGeofencingActionNode();
    TbMsg msg =
        TbTelemetryMsgFactory.telemetryMsg(null, "Key", TbContextMinimalFactory.minimalForOnMsg());

    JsonObject msgDataObj = new JsonObject();
    msgDataObj.add("Property", new JsonArray());

    // Act and Assert
    assertThrows(
        TbNodeException.class,
        () -> tbGpsGeofencingActionNode.getValueFromMessageByName(msg, msgDataObj, "Key Name"));
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
    "java.lang.Double AbstractGeofencingNode.getValueFromMessageByName(TbMsg, JsonObject, String)"
  })
  void testGetValueFromMessageByName_whenJsonObject_thenThrowTbNodeException()
      throws TbNodeException {
    // Arrange
    TbGpsGeofencingActionNode tbGpsGeofencingActionNode = new TbGpsGeofencingActionNode();
    TbMsg msg =
        TbTelemetryMsgFactory.telemetryMsg(null, "Key", TbContextMinimalFactory.minimalForOnMsg());

    // Act and Assert
    assertThrows(
        TbNodeException.class,
        () ->
            tbGpsGeofencingActionNode.getValueFromMessageByName(msg, new JsonObject(), "Key Name"));
  }
}
