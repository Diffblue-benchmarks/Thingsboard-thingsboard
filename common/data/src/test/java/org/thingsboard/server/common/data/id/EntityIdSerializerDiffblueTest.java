package org.thingsboard.server.common.data.id;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.anyBoolean;
import static org.mockito.Mockito.anyInt;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.MethodsUnderTest;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonStreamContext;
import com.fasterxml.jackson.core.filter.FilteringGeneratorDelegate;
import com.fasterxml.jackson.core.filter.TokenFilter;
import com.fasterxml.jackson.core.filter.TokenFilter.Inclusion;
import com.fasterxml.jackson.core.filter.TokenFilterContext;
import com.fasterxml.jackson.core.io.ContentReference;
import com.fasterxml.jackson.core.io.IOContext;
import com.fasterxml.jackson.core.json.UTF8JsonGenerator;
import com.fasterxml.jackson.core.util.BufferRecycler;
import com.fasterxml.jackson.core.util.JsonGeneratorDelegate;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.ser.DefaultSerializerProvider;
import com.fasterxml.jackson.databind.ser.DefaultSerializerProvider.Impl;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.thingsboard.server.common.data.BaseData;

class EntityIdSerializerDiffblueTest {
  /**
   * Test {@link EntityIdSerializer#serialize(EntityId, JsonGenerator, SerializerProvider)} with {@code EntityId}, {@code JsonGenerator}, {@code SerializerProvider}.
   * <p>
   * Method under test: {@link EntityIdSerializer#serialize(EntityId, JsonGenerator, SerializerProvider)}
   */
  @Test
  @DisplayName("Test serialize(EntityId, JsonGenerator, SerializerProvider) with 'EntityId', 'JsonGenerator', 'SerializerProvider'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void EntityIdSerializer.serialize(EntityId, JsonGenerator, SerializerProvider)"})
  void testSerializeWithEntityIdJsonGeneratorSerializerProvider() throws IOException {
    // Arrange
    EntityIdSerializer entityIdSerializer = new EntityIdSerializer();
    JsonGenerator d = mock(JsonGenerator.class);
    doNothing().when(d).writeEndObject();
    doNothing().when(d).writeFieldName(Mockito.<String>any());
    doNothing().when(d).writeStartObject();
    doNothing().when(d).writeString(Mockito.<String>any());
    JsonGeneratorDelegate gen = new JsonGeneratorDelegate(new JsonGeneratorDelegate(d), true);

    // Act
    entityIdSerializer.serialize(TenantId.SYS_TENANT_ID, gen, new Impl());

    // Assert that nothing has changed
    verify(d).writeEndObject();
    verify(d, atLeast(1)).writeFieldName(Mockito.<String>any());
    verify(d).writeStartObject();
    verify(d, atLeast(1)).writeString(Mockito.<String>any());
    JsonGenerator delegateResult = gen.delegate();
    assertTrue(delegateResult instanceof JsonGeneratorDelegate);
    assertEquals(0, delegateResult.getOutputBuffered());
    assertEquals(0, gen.getOutputBuffered());
  }

  /**
   * Test {@link EntityIdSerializer#serialize(EntityId, JsonGenerator, SerializerProvider)} with {@code EntityId}, {@code JsonGenerator}, {@code SerializerProvider}.
   * <p>
   * Method under test: {@link EntityIdSerializer#serialize(EntityId, JsonGenerator, SerializerProvider)}
   */
  @Test
  @DisplayName("Test serialize(EntityId, JsonGenerator, SerializerProvider) with 'EntityId', 'JsonGenerator', 'SerializerProvider'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void EntityIdSerializer.serialize(EntityId, JsonGenerator, SerializerProvider)"})
  void testSerializeWithEntityIdJsonGeneratorSerializerProvider2() throws IOException {
    // Arrange
    EntityIdSerializer entityIdSerializer = new EntityIdSerializer();
    JsonGenerator d = mock(JsonGenerator.class);
    doNothing().when(d).writeString(Mockito.<String>any());
    doNothing().when(d).writeEndObject();
    doNothing().when(d).writeStartObject();
    JsonGeneratorDelegate d2 = new JsonGeneratorDelegate(new JsonGeneratorDelegate(d), true);

    TokenFilter tokenFilter = mock(TokenFilter.class);
    when(tokenFilter.includeString(Mockito.<String>any())).thenReturn(true);
    TokenFilter tokenFilter2 = mock(TokenFilter.class);
    when(tokenFilter2.includeEmptyObject(anyBoolean())).thenReturn(true);
    when(tokenFilter2.includeProperty(Mockito.<String>any())).thenReturn(tokenFilter);
    doNothing().when(tokenFilter2).filterFinishObject();
    TokenFilter tokenFilter3 = mock(TokenFilter.class);
    when(tokenFilter3.filterStartObject()).thenReturn(tokenFilter2);
    TokenFilter f = mock(TokenFilter.class);
    when(f.includeRootValue(anyInt())).thenReturn(tokenFilter3);
    JsonGeneratorDelegate gen = new JsonGeneratorDelegate(
        new FilteringGeneratorDelegate(d2, f, Inclusion.ONLY_INCLUDE_ALL, true), true);

    // Act
    entityIdSerializer.serialize(TenantId.SYS_TENANT_ID, gen, new Impl());

    // Assert
    verify(d).writeEndObject();
    verify(d).writeStartObject();
    verify(d, atLeast(1)).writeString(Mockito.<String>any());
    verify(tokenFilter2).filterFinishObject();
    verify(tokenFilter3).filterStartObject();
    verify(tokenFilter2).includeEmptyObject(eq(true));
    verify(tokenFilter2, atLeast(1)).includeProperty(Mockito.<String>any());
    verify(f).includeRootValue(eq(0));
    verify(tokenFilter, atLeast(1)).includeString(Mockito.<String>any());
    JsonGenerator delegateResult = gen.delegate();
    assertTrue(delegateResult instanceof FilteringGeneratorDelegate);
    JsonStreamContext outputContext = gen.getOutputContext();
    assertTrue(outputContext instanceof TokenFilterContext);
    JsonGenerator delegateResult2 = ((FilteringGeneratorDelegate) delegateResult).delegate();
    assertTrue(delegateResult2 instanceof JsonGeneratorDelegate);
    assertEquals(0, delegateResult.getOutputBuffered());
    assertEquals(0, delegateResult2.getOutputBuffered());
    assertEquals(0, gen.getOutputBuffered());
    assertEquals(1, outputContext.getEntryCount());
    assertEquals(2, ((FilteringGeneratorDelegate) delegateResult).getMatchCount());
    assertTrue(outputContext.hasCurrentIndex());
  }

  /**
   * Test {@link EntityIdSerializer#serialize(EntityId, JsonGenerator, SerializerProvider)} with {@code EntityId}, {@code JsonGenerator}, {@code SerializerProvider}.
   * <p>
   * Method under test: {@link EntityIdSerializer#serialize(EntityId, JsonGenerator, SerializerProvider)}
   */
  @Test
  @DisplayName("Test serialize(EntityId, JsonGenerator, SerializerProvider) with 'EntityId', 'JsonGenerator', 'SerializerProvider'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void EntityIdSerializer.serialize(EntityId, JsonGenerator, SerializerProvider)"})
  void testSerializeWithEntityIdJsonGeneratorSerializerProvider3() throws IOException {
    // Arrange
    EntityIdSerializer entityIdSerializer = new EntityIdSerializer();
    JsonGenerator d = mock(JsonGenerator.class);
    doNothing().when(d).writeEndObject();
    doNothing().when(d).writeStartObject();
    doNothing().when(d).writeString(Mockito.<String>any());
    JsonGeneratorDelegate d2 = new JsonGeneratorDelegate(new JsonGeneratorDelegate(d), true);

    TokenFilter tokenFilter = mock(TokenFilter.class);
    when(tokenFilter.includeEmptyObject(anyBoolean())).thenReturn(true);
    doNothing().when(tokenFilter).filterFinishObject();
    TokenFilter tokenFilter2 = mock(TokenFilter.class);
    when(tokenFilter2.includeString(Mockito.<String>any())).thenReturn(true);
    when(tokenFilter2.filterStartObject()).thenReturn(tokenFilter);
    TokenFilter f = mock(TokenFilter.class);
    when(f.includeRootValue(anyInt())).thenReturn(tokenFilter2);
    JsonGeneratorDelegate d3 = new JsonGeneratorDelegate(
        new FilteringGeneratorDelegate(d2, f, Inclusion.ONLY_INCLUDE_ALL, true), true);

    TokenFilter tokenFilter3 = mock(TokenFilter.class);
    when(tokenFilter3.includeString(Mockito.<String>any())).thenReturn(true);
    TokenFilter tokenFilter4 = mock(TokenFilter.class);
    when(tokenFilter4.includeEmptyObject(anyBoolean())).thenReturn(true);
    when(tokenFilter4.includeProperty(Mockito.<String>any())).thenReturn(tokenFilter3);
    doNothing().when(tokenFilter4).filterFinishObject();
    TokenFilter tokenFilter5 = mock(TokenFilter.class);
    when(tokenFilter5.filterStartObject()).thenReturn(tokenFilter4);
    TokenFilter f2 = mock(TokenFilter.class);
    when(f2.includeRootValue(anyInt())).thenReturn(tokenFilter5);
    JsonGeneratorDelegate gen = new JsonGeneratorDelegate(
        new FilteringGeneratorDelegate(d3, f2, Inclusion.ONLY_INCLUDE_ALL, true), true);

    // Act
    entityIdSerializer.serialize(TenantId.SYS_TENANT_ID, gen, new Impl());

    // Assert
    verify(d).writeEndObject();
    verify(d).writeStartObject();
    verify(d, atLeast(1)).writeString(Mockito.<String>any());
    verify(tokenFilter).filterFinishObject();
    verify(tokenFilter4).filterFinishObject();
    verify(tokenFilter2).filterStartObject();
    verify(tokenFilter5).filterStartObject();
    verify(tokenFilter).includeEmptyObject(eq(false));
    verify(tokenFilter4).includeEmptyObject(eq(true));
    verify(tokenFilter4, atLeast(1)).includeProperty(Mockito.<String>any());
    verify(f, atLeast(1)).includeRootValue(anyInt());
    verify(f2).includeRootValue(eq(0));
    verify(tokenFilter2, atLeast(1)).includeString(Mockito.<String>any());
    verify(tokenFilter3, atLeast(1)).includeString(Mockito.<String>any());
    JsonGenerator delegateResult = gen.delegate();
    assertTrue(delegateResult instanceof FilteringGeneratorDelegate);
    JsonGenerator delegateResult2 = ((FilteringGeneratorDelegate) delegateResult).delegate();
    JsonGenerator delegateResult3 = ((JsonGeneratorDelegate) delegateResult2).delegate();
    assertTrue(delegateResult3 instanceof FilteringGeneratorDelegate);
    JsonStreamContext outputContext = delegateResult2.getOutputContext();
    assertTrue(outputContext instanceof TokenFilterContext);
    assertTrue(delegateResult2 instanceof JsonGeneratorDelegate);
    assertEquals(2, outputContext.getCurrentIndex());
    assertEquals(2, ((FilteringGeneratorDelegate) delegateResult3).getMatchCount());
    assertEquals(3, outputContext.getEntryCount());
    assertTrue(outputContext.hasCurrentIndex());
  }

  /**
   * Test {@link EntityIdSerializer#serialize(EntityId, JsonGenerator, SerializerProvider)} with {@code EntityId}, {@code JsonGenerator}, {@code SerializerProvider}.
   * <p>
   * Method under test: {@link EntityIdSerializer#serialize(EntityId, JsonGenerator, SerializerProvider)}
   */
  @Test
  @DisplayName("Test serialize(EntityId, JsonGenerator, SerializerProvider) with 'EntityId', 'JsonGenerator', 'SerializerProvider'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void EntityIdSerializer.serialize(EntityId, JsonGenerator, SerializerProvider)"})
  void testSerializeWithEntityIdJsonGeneratorSerializerProvider4() throws IOException {
    // Arrange
    EntityIdSerializer entityIdSerializer = new EntityIdSerializer();
    JsonGenerator d = mock(JsonGenerator.class);
    doNothing().when(d).writeEndObject();
    doNothing().when(d).writeStartObject();
    doNothing().when(d).writeString(Mockito.<String>any());
    JsonGeneratorDelegate d2 = new JsonGeneratorDelegate(new JsonGeneratorDelegate(d), true);

    TokenFilter tokenFilter = mock(TokenFilter.class);
    when(tokenFilter.includeEmptyObject(anyBoolean())).thenReturn(true);
    doNothing().when(tokenFilter).filterFinishObject();
    TokenFilter tokenFilter2 = mock(TokenFilter.class);
    when(tokenFilter2.includeString(Mockito.<String>any())).thenReturn(true);
    when(tokenFilter2.filterStartObject()).thenReturn(tokenFilter);
    TokenFilter f = mock(TokenFilter.class);
    when(f.includeRootValue(anyInt())).thenReturn(tokenFilter2);
    JsonGeneratorDelegate d3 = new JsonGeneratorDelegate(
        new FilteringGeneratorDelegate(d2, f, Inclusion.ONLY_INCLUDE_ALL, true), true);

    TokenFilter tokenFilter3 = mock(TokenFilter.class);
    when(tokenFilter3.includeEmptyObject(anyBoolean())).thenReturn(true);
    doNothing().when(tokenFilter3).filterFinishObject();
    TokenFilter tokenFilter4 = mock(TokenFilter.class);
    when(tokenFilter4.includeString(Mockito.<String>any())).thenReturn(true);
    when(tokenFilter4.filterStartObject()).thenReturn(tokenFilter3);
    TokenFilter f2 = mock(TokenFilter.class);
    when(f2.includeRootValue(anyInt())).thenReturn(tokenFilter4);
    JsonGeneratorDelegate d4 = new JsonGeneratorDelegate(
        new FilteringGeneratorDelegate(d3, f2, Inclusion.ONLY_INCLUDE_ALL, true), true);

    TokenFilter tokenFilter5 = mock(TokenFilter.class);
    when(tokenFilter5.includeString(Mockito.<String>any())).thenReturn(true);
    TokenFilter tokenFilter6 = mock(TokenFilter.class);
    when(tokenFilter6.includeEmptyObject(anyBoolean())).thenReturn(true);
    when(tokenFilter6.includeProperty(Mockito.<String>any())).thenReturn(tokenFilter5);
    doNothing().when(tokenFilter6).filterFinishObject();
    TokenFilter tokenFilter7 = mock(TokenFilter.class);
    when(tokenFilter7.filterStartObject()).thenReturn(tokenFilter6);
    TokenFilter f3 = mock(TokenFilter.class);
    when(f3.includeRootValue(anyInt())).thenReturn(tokenFilter7);
    JsonGeneratorDelegate gen = new JsonGeneratorDelegate(
        new FilteringGeneratorDelegate(d4, f3, Inclusion.ONLY_INCLUDE_ALL, true), true);

    // Act
    entityIdSerializer.serialize(TenantId.SYS_TENANT_ID, gen, new Impl());

    // Assert
    verify(d).writeEndObject();
    verify(d).writeStartObject();
    verify(d, atLeast(1)).writeString(Mockito.<String>any());
    verify(tokenFilter).filterFinishObject();
    verify(tokenFilter3).filterFinishObject();
    verify(tokenFilter6).filterFinishObject();
    verify(tokenFilter2).filterStartObject();
    verify(tokenFilter4).filterStartObject();
    verify(tokenFilter7).filterStartObject();
    verify(tokenFilter).includeEmptyObject(eq(false));
    verify(tokenFilter3).includeEmptyObject(eq(false));
    verify(tokenFilter6).includeEmptyObject(eq(true));
    verify(tokenFilter6, atLeast(1)).includeProperty(Mockito.<String>any());
    verify(f, atLeast(1)).includeRootValue(anyInt());
    verify(f2, atLeast(1)).includeRootValue(anyInt());
    verify(f3).includeRootValue(eq(0));
    verify(tokenFilter2, atLeast(1)).includeString(Mockito.<String>any());
    verify(tokenFilter4, atLeast(1)).includeString(Mockito.<String>any());
    verify(tokenFilter5, atLeast(1)).includeString(Mockito.<String>any());
    JsonGenerator delegateResult = gen.delegate();
    assertTrue(delegateResult instanceof FilteringGeneratorDelegate);
    JsonGenerator delegateResult2 = ((FilteringGeneratorDelegate) delegateResult).delegate();
    JsonGenerator delegateResult3 = ((JsonGeneratorDelegate) delegateResult2).delegate();
    assertTrue(delegateResult3 instanceof FilteringGeneratorDelegate);
    JsonGenerator delegateResult4 = ((FilteringGeneratorDelegate) delegateResult3).delegate();
    JsonGenerator delegateResult5 = ((JsonGeneratorDelegate) delegateResult4).delegate();
    assertTrue(delegateResult5 instanceof FilteringGeneratorDelegate);
    JsonStreamContext outputContext = delegateResult2.getOutputContext();
    assertTrue(outputContext instanceof TokenFilterContext);
    JsonStreamContext outputContext2 = delegateResult4.getOutputContext();
    assertTrue(outputContext2 instanceof TokenFilterContext);
    assertTrue(delegateResult2 instanceof JsonGeneratorDelegate);
    assertTrue(delegateResult4 instanceof JsonGeneratorDelegate);
    assertEquals(2, outputContext.getCurrentIndex());
    assertEquals(2, outputContext2.getCurrentIndex());
    assertEquals(2, ((FilteringGeneratorDelegate) delegateResult5).getMatchCount());
    assertEquals(3, outputContext.getEntryCount());
    assertEquals(3, outputContext2.getEntryCount());
    assertTrue(outputContext2.hasCurrentIndex());
  }

  /**
   * Test {@link EntityIdSerializer#serialize(EntityId, JsonGenerator, SerializerProvider)} with {@code EntityId}, {@code JsonGenerator}, {@code SerializerProvider}.
   * <p>
   * Method under test: {@link EntityIdSerializer#serialize(EntityId, JsonGenerator, SerializerProvider)}
   */
  @Test
  @DisplayName("Test serialize(EntityId, JsonGenerator, SerializerProvider) with 'EntityId', 'JsonGenerator', 'SerializerProvider'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void EntityIdSerializer.serialize(EntityId, JsonGenerator, SerializerProvider)"})
  void testSerializeWithEntityIdJsonGeneratorSerializerProvider5() throws IOException {
    // Arrange
    EntityIdSerializer entityIdSerializer = new EntityIdSerializer();
    TokenFilter tokenFilter = mock(TokenFilter.class);
    when(tokenFilter.includeEmptyObject(anyBoolean())).thenReturn(true);
    doNothing().when(tokenFilter).filterFinishObject();
    TokenFilter tokenFilter2 = mock(TokenFilter.class);
    when(tokenFilter2.includeString(Mockito.<String>any())).thenReturn(true);
    when(tokenFilter2.filterStartObject()).thenReturn(tokenFilter);
    TokenFilter f = mock(TokenFilter.class);
    when(f.includeRootValue(anyInt())).thenReturn(tokenFilter2);
    BufferRecycler br = new BufferRecycler();
    IOContext ctxt = new IOContext(br, ContentReference.redacted(), true);

    JsonGeneratorDelegate d = new JsonGeneratorDelegate(new FilteringGeneratorDelegate(
        new JsonGeneratorDelegate(new UTF8JsonGenerator(ctxt, 1, BaseData.mapper, new ByteArrayOutputStream(1)), true),
        f, Inclusion.ONLY_INCLUDE_ALL, true), true);

    TokenFilter tokenFilter3 = mock(TokenFilter.class);
    when(tokenFilter3.includeEmptyObject(anyBoolean())).thenReturn(true);
    doNothing().when(tokenFilter3).filterFinishObject();
    TokenFilter tokenFilter4 = mock(TokenFilter.class);
    when(tokenFilter4.includeString(Mockito.<String>any())).thenReturn(true);
    when(tokenFilter4.filterStartObject()).thenReturn(tokenFilter3);
    TokenFilter f2 = mock(TokenFilter.class);
    when(f2.includeRootValue(anyInt())).thenReturn(tokenFilter4);
    JsonGeneratorDelegate d2 = new JsonGeneratorDelegate(
        new FilteringGeneratorDelegate(d, f2, Inclusion.ONLY_INCLUDE_ALL, true), true);

    TokenFilter tokenFilter5 = mock(TokenFilter.class);
    when(tokenFilter5.includeString(Mockito.<String>any())).thenReturn(true);
    TokenFilter tokenFilter6 = mock(TokenFilter.class);
    when(tokenFilter6.includeEmptyObject(anyBoolean())).thenReturn(true);
    when(tokenFilter6.includeProperty(Mockito.<String>any())).thenReturn(tokenFilter5);
    doNothing().when(tokenFilter6).filterFinishObject();
    TokenFilter tokenFilter7 = mock(TokenFilter.class);
    when(tokenFilter7.filterStartObject()).thenReturn(tokenFilter6);
    TokenFilter f3 = mock(TokenFilter.class);
    when(f3.includeRootValue(anyInt())).thenReturn(tokenFilter7);
    JsonGeneratorDelegate gen = new JsonGeneratorDelegate(
        new FilteringGeneratorDelegate(d2, f3, Inclusion.ONLY_INCLUDE_ALL, true), true);

    // Act
    entityIdSerializer.serialize(TenantId.SYS_TENANT_ID, gen, new Impl());

    // Assert
    verify(tokenFilter).filterFinishObject();
    verify(tokenFilter3).filterFinishObject();
    verify(tokenFilter6).filterFinishObject();
    verify(tokenFilter2).filterStartObject();
    verify(tokenFilter4).filterStartObject();
    verify(tokenFilter7).filterStartObject();
    verify(tokenFilter).includeEmptyObject(eq(false));
    verify(tokenFilter3).includeEmptyObject(eq(false));
    verify(tokenFilter6).includeEmptyObject(eq(true));
    verify(tokenFilter6, atLeast(1)).includeProperty(Mockito.<String>any());
    verify(f, atLeast(1)).includeRootValue(anyInt());
    verify(f2, atLeast(1)).includeRootValue(anyInt());
    verify(f3).includeRootValue(eq(0));
    verify(tokenFilter2, atLeast(1)).includeString(Mockito.<String>any());
    verify(tokenFilter4, atLeast(1)).includeString(Mockito.<String>any());
    verify(tokenFilter5, atLeast(1)).includeString(Mockito.<String>any());
    JsonGenerator delegateResult = gen.delegate();
    assertTrue(delegateResult instanceof FilteringGeneratorDelegate);
    JsonGenerator delegateResult2 = ((FilteringGeneratorDelegate) delegateResult).delegate();
    JsonGenerator delegateResult3 = ((JsonGeneratorDelegate) delegateResult2).delegate();
    assertTrue(delegateResult3 instanceof FilteringGeneratorDelegate);
    JsonGenerator delegateResult4 = ((FilteringGeneratorDelegate) delegateResult3).delegate();
    JsonGenerator delegateResult5 = ((JsonGeneratorDelegate) delegateResult4).delegate();
    assertTrue(delegateResult5 instanceof FilteringGeneratorDelegate);
    assertTrue(delegateResult2 instanceof JsonGeneratorDelegate);
    assertTrue(delegateResult4 instanceof JsonGeneratorDelegate);
    assertEquals(50, delegateResult.getOutputBuffered());
    assertEquals(50, delegateResult2.getOutputBuffered());
    assertEquals(50, delegateResult4.getOutputBuffered());
    assertEquals(50, delegateResult3.getOutputBuffered());
    assertEquals(50, delegateResult5.getOutputBuffered());
    assertEquals(50, gen.getOutputBuffered());
  }

  /**
   * Test {@link EntityIdSerializer#serialize(EntityId, JsonGenerator, SerializerProvider)} with {@code EntityId}, {@code JsonGenerator}, {@code SerializerProvider}.
   * <p>
   * Method under test: {@link EntityIdSerializer#serialize(EntityId, JsonGenerator, SerializerProvider)}
   */
  @Test
  @DisplayName("Test serialize(EntityId, JsonGenerator, SerializerProvider) with 'EntityId', 'JsonGenerator', 'SerializerProvider'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void EntityIdSerializer.serialize(EntityId, JsonGenerator, SerializerProvider)"})
  void testSerializeWithEntityIdJsonGeneratorSerializerProvider6() throws IOException {
    // Arrange
    EntityIdSerializer entityIdSerializer = new EntityIdSerializer();
    JsonGenerator d = mock(JsonGenerator.class);
    doNothing().when(d).writeEndObject();
    doNothing().when(d).writeStartObject();
    doNothing().when(d).writeString(Mockito.<String>any());
    JsonGeneratorDelegate d2 = new JsonGeneratorDelegate(new JsonGeneratorDelegate(d), true);

    TokenFilter tokenFilter = mock(TokenFilter.class);
    when(tokenFilter.includeEmptyObject(anyBoolean())).thenReturn(true);
    doNothing().when(tokenFilter).filterFinishObject();
    TokenFilter tokenFilter2 = mock(TokenFilter.class);
    when(tokenFilter2.includeString(Mockito.<String>any())).thenReturn(true);
    when(tokenFilter2.filterStartObject()).thenReturn(tokenFilter);
    TokenFilter f = mock(TokenFilter.class);
    when(f.includeRootValue(anyInt())).thenReturn(tokenFilter2);
    JsonGeneratorDelegate d3 = new JsonGeneratorDelegate(
        new FilteringGeneratorDelegate(d2, f, Inclusion.ONLY_INCLUDE_ALL, true), true);

    TokenFilter tokenFilter3 = mock(TokenFilter.class);
    when(tokenFilter3.includeString(Mockito.<String>any())).thenReturn(true);
    TokenFilter tokenFilter4 = mock(TokenFilter.class);
    when(tokenFilter4.includeProperty(Mockito.<String>any())).thenReturn(tokenFilter3);
    when(tokenFilter4.includeEmptyObject(anyBoolean())).thenReturn(true);
    doNothing().when(tokenFilter4).filterFinishObject();
    TokenFilter tokenFilter5 = mock(TokenFilter.class);
    when(tokenFilter5.filterStartObject()).thenReturn(tokenFilter4);
    TokenFilter f2 = mock(TokenFilter.class);
    when(f2.includeRootValue(anyInt())).thenReturn(tokenFilter5);
    JsonGeneratorDelegate d4 = new JsonGeneratorDelegate(
        new FilteringGeneratorDelegate(d3, f2, Inclusion.ONLY_INCLUDE_ALL, true), true);

    TokenFilter tokenFilter6 = mock(TokenFilter.class);
    when(tokenFilter6.includeString(Mockito.<String>any())).thenReturn(true);
    TokenFilter tokenFilter7 = mock(TokenFilter.class);
    when(tokenFilter7.includeProperty(Mockito.<String>any())).thenReturn(tokenFilter6);
    doNothing().when(tokenFilter7).filterFinishObject();
    TokenFilter tokenFilter8 = mock(TokenFilter.class);
    when(tokenFilter8.filterStartObject()).thenReturn(tokenFilter7);
    TokenFilter f3 = mock(TokenFilter.class);
    when(f3.includeRootValue(anyInt())).thenReturn(tokenFilter8);
    JsonGeneratorDelegate gen = new JsonGeneratorDelegate(
        new FilteringGeneratorDelegate(d4, f3, Inclusion.INCLUDE_ALL_AND_PATH, true), true);

    // Act
    entityIdSerializer.serialize(TenantId.SYS_TENANT_ID, gen, new Impl());

    // Assert
    verify(d).writeEndObject();
    verify(d).writeStartObject();
    verify(d, atLeast(1)).writeString(Mockito.<String>any());
    verify(tokenFilter).filterFinishObject();
    verify(tokenFilter4).filterFinishObject();
    verify(tokenFilter7).filterFinishObject();
    verify(tokenFilter2).filterStartObject();
    verify(tokenFilter5).filterStartObject();
    verify(tokenFilter8).filterStartObject();
    verify(tokenFilter).includeEmptyObject(eq(false));
    verify(tokenFilter4).includeEmptyObject(eq(true));
    verify(tokenFilter4, atLeast(1)).includeProperty(Mockito.<String>any());
    verify(tokenFilter7, atLeast(1)).includeProperty(Mockito.<String>any());
    verify(f, atLeast(1)).includeRootValue(anyInt());
    verify(f2).includeRootValue(eq(0));
    verify(f3).includeRootValue(eq(0));
    verify(tokenFilter2, atLeast(1)).includeString(Mockito.<String>any());
    verify(tokenFilter3, atLeast(1)).includeString(Mockito.<String>any());
    verify(tokenFilter6, atLeast(1)).includeString(Mockito.<String>any());
    JsonGenerator delegateResult = gen.delegate();
    assertTrue(delegateResult instanceof FilteringGeneratorDelegate);
    JsonGenerator delegateResult2 = ((FilteringGeneratorDelegate) delegateResult).delegate();
    JsonGenerator delegateResult3 = ((JsonGeneratorDelegate) delegateResult2).delegate();
    assertTrue(delegateResult3 instanceof FilteringGeneratorDelegate);
    JsonGenerator delegateResult4 = ((FilteringGeneratorDelegate) delegateResult3).delegate();
    JsonGenerator delegateResult5 = ((JsonGeneratorDelegate) delegateResult4).delegate();
    assertTrue(delegateResult5 instanceof FilteringGeneratorDelegate);
    JsonStreamContext outputContext = delegateResult2.getOutputContext();
    assertTrue(outputContext instanceof TokenFilterContext);
    JsonStreamContext outputContext2 = delegateResult4.getOutputContext();
    assertTrue(outputContext2 instanceof TokenFilterContext);
    assertTrue(delegateResult2 instanceof JsonGeneratorDelegate);
    assertTrue(delegateResult4 instanceof JsonGeneratorDelegate);
    assertEquals(1, outputContext.getEntryCount());
    assertEquals(2, outputContext2.getCurrentIndex());
    assertEquals(2, ((FilteringGeneratorDelegate) delegateResult5).getMatchCount());
    assertEquals(3, outputContext2.getEntryCount());
    assertTrue(outputContext2.hasCurrentIndex());
  }

  /**
   * Test {@link EntityIdSerializer#serialize(EntityId, JsonGenerator, SerializerProvider)} with {@code EntityId}, {@code JsonGenerator}, {@code SerializerProvider}.
   * <p>
   * Method under test: {@link EntityIdSerializer#serialize(EntityId, JsonGenerator, SerializerProvider)}
   */
  @Test
  @DisplayName("Test serialize(EntityId, JsonGenerator, SerializerProvider) with 'EntityId', 'JsonGenerator', 'SerializerProvider'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void EntityIdSerializer.serialize(EntityId, JsonGenerator, SerializerProvider)"})
  void testSerializeWithEntityIdJsonGeneratorSerializerProvider7() throws IOException {
    // Arrange
    EntityIdSerializer entityIdSerializer = new EntityIdSerializer();
    TokenFilter tokenFilter = mock(TokenFilter.class);
    when(tokenFilter.includeString(Mockito.<String>any())).thenReturn(true);
    TokenFilter tokenFilter2 = mock(TokenFilter.class);
    when(tokenFilter2.includeProperty(Mockito.<String>any())).thenReturn(tokenFilter);
    doNothing().when(tokenFilter2).filterFinishObject();
    TokenFilter tokenFilter3 = mock(TokenFilter.class);
    when(tokenFilter3.filterStartObject()).thenReturn(tokenFilter2);
    TokenFilter f = mock(TokenFilter.class);
    when(f.includeRootValue(anyInt())).thenReturn(tokenFilter3);
    BufferRecycler br = new BufferRecycler();
    IOContext ctxt = new IOContext(br, ContentReference.redacted(), true);

    JsonGeneratorDelegate gen = new JsonGeneratorDelegate(new FilteringGeneratorDelegate(
        new JsonGeneratorDelegate(new UTF8JsonGenerator(ctxt, 1, BaseData.mapper, new ByteArrayOutputStream(1)), true),
        f, Inclusion.INCLUDE_ALL_AND_PATH, true), true);

    // Act
    entityIdSerializer.serialize(TenantId.SYS_TENANT_ID, gen, new Impl());

    // Assert
    verify(tokenFilter2).filterFinishObject();
    verify(tokenFilter3).filterStartObject();
    verify(tokenFilter2, atLeast(1)).includeProperty(Mockito.<String>any());
    verify(f).includeRootValue(eq(0));
    verify(tokenFilter, atLeast(1)).includeString(Mockito.<String>any());
    JsonGenerator delegateResult = gen.delegate();
    assertTrue(delegateResult instanceof FilteringGeneratorDelegate);
    JsonGenerator delegateResult2 = ((FilteringGeneratorDelegate) delegateResult).delegate();
    JsonGenerator delegateResult3 = ((JsonGeneratorDelegate) delegateResult2).delegate();
    assertTrue(delegateResult3 instanceof UTF8JsonGenerator);
    assertTrue(delegateResult2 instanceof JsonGeneratorDelegate);
    assertEquals(63, delegateResult.getOutputBuffered());
    assertEquals(63, delegateResult2.getOutputBuffered());
    assertEquals(63, delegateResult3.getOutputBuffered());
    assertEquals(63, gen.getOutputBuffered());
  }

  /**
   * Test new {@link EntityIdSerializer} (default constructor).
   * <p>
   * Method under test: default or parameterless constructor of {@link EntityIdSerializer}
   */
  @Test
  @DisplayName("Test new EntityIdSerializer (default constructor)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void EntityIdSerializer.<init>()"})
  void testNewEntityIdSerializer() {
    // Arrange and Act
    EntityIdSerializer actualEntityIdSerializer = new EntityIdSerializer();

    // Assert
    assertNull(actualEntityIdSerializer.getDelegatee());
    assertFalse(actualEntityIdSerializer.isUnwrappingSerializer());
  }
}
