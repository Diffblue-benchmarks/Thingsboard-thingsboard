package org.thingsboard.server.common.data.id;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import com.fasterxml.jackson.core.ObjectCodec;
import com.fasterxml.jackson.core.StreamReadCapability;
import com.fasterxml.jackson.core.filter.FilteringParserDelegate;
import com.fasterxml.jackson.core.util.JacksonFeatureSet;
import com.fasterxml.jackson.core.util.JsonParserDelegate;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.cfg.DeserializerFactoryConfig;
import com.fasterxml.jackson.databind.deser.BeanDeserializerFactory;
import com.fasterxml.jackson.databind.deser.DefaultDeserializationContext;
import com.fasterxml.jackson.databind.deser.DefaultDeserializationContext.Impl;
import com.fasterxml.jackson.databind.json.JsonMapper;
import com.fasterxml.jackson.databind.node.DoubleNode;
import com.fasterxml.jackson.databind.node.JsonNodeFactory;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.fasterxml.jackson.databind.util.AccessPattern;
import java.io.IOException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.thingsboard.server.common.data.BaseData;

class EntityIdDeserializerDiffblueTest {
  /**
   * Test {@link EntityIdDeserializer#deserialize(JsonParser, DeserializationContext)} with {@code
   * jsonParser}, {@code ctx}.
   *
   * <p>Method under test: {@link EntityIdDeserializer#deserialize(JsonParser,
   * DeserializationContext)}
   */
  @Test
  @DisplayName("Test deserialize(JsonParser, DeserializationContext) with 'jsonParser', 'ctx'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "org.thingsboard.server.common.data.id.EntityId EntityIdDeserializer.deserialize(JsonParser, DeserializationContext)"
  })
  void testDeserializeWithJsonParserCtx() throws IOException {
    // Arrange
    EntityIdDeserializer entityIdDeserializer = new EntityIdDeserializer();
    JsonNodeFactory nc = JsonNodeFactory.withExactBigDecimals(true);

    ObjectNode objectNode = new ObjectNode(nc);
    objectNode.put("entityType", DoubleNode.valueOf(10.0d));

    ObjectCodec objectCodec = mock(ObjectCodec.class);
    when(objectCodec.readTree(Mockito.<JsonParser>any())).thenReturn(objectNode);

    FilteringParserDelegate d = mock(FilteringParserDelegate.class);
    when(d.getCodec()).thenReturn(objectCodec);
    JsonParserDelegate jsonParser = new JsonParserDelegate(d);

    // Act and Assert
    assertThrows(
        IOException.class,
        () ->
            entityIdDeserializer.deserialize(
                jsonParser,
                new Impl(new BeanDeserializerFactory(new DeserializerFactoryConfig()))));
    verify(objectCodec).readTree(isA(JsonParser.class));
    verify(d).getCodec();
  }

  /**
   * Test {@link EntityIdDeserializer#deserialize(JsonParser, DeserializationContext)} with {@code
   * jsonParser}, {@code ctx}.
   *
   * <ul>
   *   <li>Given builder findAndAddModules build.
   * </ul>
   *
   * <p>Method under test: {@link EntityIdDeserializer#deserialize(JsonParser,
   * DeserializationContext)}
   */
  @Test
  @DisplayName(
      "Test deserialize(JsonParser, DeserializationContext) with 'jsonParser', 'ctx'; given builder findAndAddModules build")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "org.thingsboard.server.common.data.id.EntityId EntityIdDeserializer.deserialize(JsonParser, DeserializationContext)"
  })
  void testDeserializeWithJsonParserCtx_givenBuilderFindAndAddModulesBuild() throws IOException {
    // Arrange
    EntityIdDeserializer entityIdDeserializer = new EntityIdDeserializer();

    FilteringParserDelegate d = mock(FilteringParserDelegate.class);
    doNothing().when(d).clearCurrentToken();
    JacksonFeatureSet<StreamReadCapability> fromBitmaskResult = JacksonFeatureSet.fromBitmask(1);
    when(d.getReadCapabilities()).thenReturn(fromBitmaskResult);
    when(d.currentTokenId()).thenReturn(1);
    when(d.currentToken()).thenReturn(JsonToken.NOT_AVAILABLE);
    when(d.nextToken()).thenReturn(JsonToken.NOT_AVAILABLE);
    when(d.getCodec()).thenReturn(JsonMapper.builder().findAndAddModules().build());
    JsonParserDelegate jsonParser = new JsonParserDelegate(d);

    // Act and Assert
    assertThrows(
        IOException.class,
        () ->
            entityIdDeserializer.deserialize(
                jsonParser,
                new Impl(new BeanDeserializerFactory(new DeserializerFactoryConfig()))));
    verify(d).clearCurrentToken();
    verify(d, atLeast(1)).currentToken();
    verify(d).currentTokenId();
    verify(d).nextToken();
    verify(d).getCodec();
    verify(d).getReadCapabilities();
  }

  /**
   * Test {@link EntityIdDeserializer#deserialize(JsonParser, DeserializationContext)} with {@code
   * jsonParser}, {@code ctx}.
   *
   * <ul>
   *   <li>Then calls {@link ObjectCodec#readTree(JsonParser)}.
   * </ul>
   *
   * <p>Method under test: {@link EntityIdDeserializer#deserialize(JsonParser,
   * DeserializationContext)}
   */
  @Test
  @DisplayName(
      "Test deserialize(JsonParser, DeserializationContext) with 'jsonParser', 'ctx'; then calls readTree(JsonParser)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "org.thingsboard.server.common.data.id.EntityId EntityIdDeserializer.deserialize(JsonParser, DeserializationContext)"
  })
  void testDeserializeWithJsonParserCtx_thenCallsReadTree() throws IOException {
    // Arrange
    EntityIdDeserializer entityIdDeserializer = new EntityIdDeserializer();

    ObjectCodec objectCodec = mock(ObjectCodec.class);
    JsonNodeFactory nc = JsonNodeFactory.withExactBigDecimals(true);
    when(objectCodec.readTree(Mockito.<JsonParser>any())).thenReturn(new ObjectNode(nc));

    FilteringParserDelegate d = mock(FilteringParserDelegate.class);
    when(d.getCodec()).thenReturn(objectCodec);
    JsonParserDelegate jsonParser = new JsonParserDelegate(d);

    // Act and Assert
    assertThrows(
        IOException.class,
        () ->
            entityIdDeserializer.deserialize(
                jsonParser,
                new Impl(new BeanDeserializerFactory(new DeserializerFactoryConfig()))));
    verify(objectCodec).readTree(isA(JsonParser.class));
    verify(d).getCodec();
  }

  /**
   * Test {@link EntityIdDeserializer#deserialize(JsonParser, DeserializationContext)} with {@code
   * jsonParser}, {@code ctx}.
   *
   * <ul>
   *   <li>When {@link FilteringParserDelegate} {@link FilteringParserDelegate#getCodec()} return
   *       {@link BaseData#mapper}.
   * </ul>
   *
   * <p>Method under test: {@link EntityIdDeserializer#deserialize(JsonParser,
   * DeserializationContext)}
   */
  @Test
  @DisplayName(
      "Test deserialize(JsonParser, DeserializationContext) with 'jsonParser', 'ctx'; when FilteringParserDelegate getCodec() return mapper")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "org.thingsboard.server.common.data.id.EntityId EntityIdDeserializer.deserialize(JsonParser, DeserializationContext)"
  })
  void testDeserializeWithJsonParserCtx_whenFilteringParserDelegateGetCodecReturnMapper()
      throws IOException {
    // Arrange
    EntityIdDeserializer entityIdDeserializer = new EntityIdDeserializer();

    FilteringParserDelegate d = mock(FilteringParserDelegate.class);
    doNothing().when(d).clearCurrentToken();
    JacksonFeatureSet<StreamReadCapability> fromBitmaskResult = JacksonFeatureSet.fromBitmask(1);
    when(d.getReadCapabilities()).thenReturn(fromBitmaskResult);
    when(d.currentTokenId()).thenReturn(1);
    when(d.currentToken()).thenReturn(JsonToken.NOT_AVAILABLE);
    when(d.nextToken()).thenReturn(JsonToken.NOT_AVAILABLE);
    when(d.getCodec()).thenReturn(BaseData.mapper);
    JsonParserDelegate jsonParser = new JsonParserDelegate(d);

    // Act and Assert
    assertThrows(
        IOException.class,
        () ->
            entityIdDeserializer.deserialize(
                jsonParser,
                new Impl(new BeanDeserializerFactory(new DeserializerFactoryConfig()))));
    verify(d).clearCurrentToken();
    verify(d, atLeast(1)).currentToken();
    verify(d).currentTokenId();
    verify(d).nextToken();
    verify(d).getCodec();
    verify(d).getReadCapabilities();
  }

  /**
   * Test new {@link EntityIdDeserializer} (default constructor).
   *
   * <p>Method under test: default or parameterless constructor of {@link EntityIdDeserializer}
   */
  @Test
  @DisplayName("Test new EntityIdDeserializer (default constructor)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void EntityIdDeserializer.<init>()"})
  void testNewEntityIdDeserializer() {
    // Arrange and Act
    EntityIdDeserializer actualEntityIdDeserializer = new EntityIdDeserializer();

    // Assert
    assertNull(actualEntityIdDeserializer.getDelegatee());
    assertNull(actualEntityIdDeserializer.getObjectIdReader());
    assertNull(actualEntityIdDeserializer.getEmptyValue());
    assertNull(actualEntityIdDeserializer.getKnownPropertyNames());
    assertNull(actualEntityIdDeserializer.getNullValue());
    assertEquals(AccessPattern.CONSTANT, actualEntityIdDeserializer.getNullAccessPattern());
    assertEquals(AccessPattern.DYNAMIC, actualEntityIdDeserializer.getEmptyAccessPattern());
    assertFalse(actualEntityIdDeserializer.isCachable());
  }
}
