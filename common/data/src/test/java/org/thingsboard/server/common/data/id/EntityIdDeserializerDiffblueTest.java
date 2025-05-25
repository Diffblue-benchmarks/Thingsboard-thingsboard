package org.thingsboard.server.common.data.id;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.MethodsUnderTest;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import com.fasterxml.jackson.core.StreamReadCapability;
import com.fasterxml.jackson.core.util.JacksonFeatureSet;
import com.fasterxml.jackson.core.util.JsonParserDelegate;
import com.fasterxml.jackson.core.util.JsonParserSequence;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.cfg.DeserializerFactoryConfig;
import com.fasterxml.jackson.databind.deser.BeanDeserializerFactory;
import com.fasterxml.jackson.databind.deser.DefaultDeserializationContext;
import com.fasterxml.jackson.databind.deser.DefaultDeserializationContext.Impl;
import com.fasterxml.jackson.databind.util.AccessPattern;
import java.io.IOException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.thingsboard.server.common.data.BaseData;
import org.thingsboard.server.common.data.TenantProfile;

class EntityIdDeserializerDiffblueTest {
  /**
   * Test {@link EntityIdDeserializer#deserialize(JsonParser, DeserializationContext)} with {@code jsonParser}, {@code ctx}.
   * <ul>
   *   <li>Given {@link TenantProfile#mapper}.</li>
   * </ul>
   * <p>
   * Method under test: {@link EntityIdDeserializer#deserialize(JsonParser, DeserializationContext)}
   */
  @Test
  @DisplayName("Test deserialize(JsonParser, DeserializationContext) with 'jsonParser', 'ctx'; given mapper")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "org.thingsboard.server.common.data.id.EntityId EntityIdDeserializer.deserialize(JsonParser, DeserializationContext)"})
  void testDeserializeWithJsonParserCtx_givenMapper() throws IOException {
    // Arrange
    EntityIdDeserializer entityIdDeserializer = new EntityIdDeserializer();
    JsonParserSequence d = mock(JsonParserSequence.class);
    doNothing().when(d).clearCurrentToken();
    JacksonFeatureSet<StreamReadCapability> fromBitmaskResult = JacksonFeatureSet.fromBitmask(1);
    when(d.getReadCapabilities()).thenReturn(fromBitmaskResult);
    when(d.currentTokenId()).thenReturn(1);
    when(d.currentToken()).thenReturn(JsonToken.NOT_AVAILABLE);
    when(d.nextToken()).thenReturn(JsonToken.NOT_AVAILABLE);
    when(d.getCodec()).thenReturn(TenantProfile.mapper);
    JsonParserDelegate jsonParser = new JsonParserDelegate(d);

    // Act and Assert
    assertThrows(IOException.class, () -> entityIdDeserializer.deserialize(jsonParser,
        new Impl(new BeanDeserializerFactory(new DeserializerFactoryConfig()))));
    verify(d).clearCurrentToken();
    verify(d, atLeast(1)).currentToken();
    verify(d).currentTokenId();
    verify(d).getCodec();
    verify(d).getReadCapabilities();
    verify(d).nextToken();
  }

  /**
   * Test {@link EntityIdDeserializer#deserialize(JsonParser, DeserializationContext)} with {@code jsonParser}, {@code ctx}.
   * <ul>
   *   <li>Given one.</li>
   *   <li>Then throw {@link IOException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link EntityIdDeserializer#deserialize(JsonParser, DeserializationContext)}
   */
  @Test
  @DisplayName("Test deserialize(JsonParser, DeserializationContext) with 'jsonParser', 'ctx'; given one; then throw IOException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "org.thingsboard.server.common.data.id.EntityId EntityIdDeserializer.deserialize(JsonParser, DeserializationContext)"})
  void testDeserializeWithJsonParserCtx_givenOne_thenThrowIOException() throws IOException {
    // Arrange
    EntityIdDeserializer entityIdDeserializer = new EntityIdDeserializer();
    JsonParserSequence d = mock(JsonParserSequence.class);
    doNothing().when(d).clearCurrentToken();
    JacksonFeatureSet<StreamReadCapability> fromBitmaskResult = JacksonFeatureSet.fromBitmask(1);
    when(d.getReadCapabilities()).thenReturn(fromBitmaskResult);
    when(d.currentTokenId()).thenReturn(1);
    when(d.currentToken()).thenReturn(JsonToken.NOT_AVAILABLE);
    when(d.nextToken()).thenReturn(JsonToken.NOT_AVAILABLE);
    when(d.getCodec()).thenReturn(BaseData.mapper);
    JsonParserDelegate jsonParser = new JsonParserDelegate(d);

    // Act and Assert
    assertThrows(IOException.class, () -> entityIdDeserializer.deserialize(jsonParser,
        new Impl(new BeanDeserializerFactory(new DeserializerFactoryConfig()))));
    verify(d).clearCurrentToken();
    verify(d, atLeast(1)).currentToken();
    verify(d).currentTokenId();
    verify(d).getCodec();
    verify(d).getReadCapabilities();
    verify(d).nextToken();
  }

  /**
   * Test new {@link EntityIdDeserializer} (default constructor).
   * <p>
   * Method under test: default or parameterless constructor of {@link EntityIdDeserializer}
   */
  @Test
  @DisplayName("Test new EntityIdDeserializer (default constructor)")
  @Tag("MaintainedByDiffblue")
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
