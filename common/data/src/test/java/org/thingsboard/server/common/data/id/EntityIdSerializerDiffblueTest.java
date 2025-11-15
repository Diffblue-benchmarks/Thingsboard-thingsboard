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
package org.thingsboard.server.common.data.id;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.anyBoolean;
import static org.mockito.Mockito.anyInt;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonStreamContext;
import com.fasterxml.jackson.core.filter.FilteringGeneratorDelegate;
import com.fasterxml.jackson.core.filter.TokenFilter;
import com.fasterxml.jackson.core.filter.TokenFilterContext;
import com.fasterxml.jackson.core.io.ContentReference;
import com.fasterxml.jackson.core.io.IOContext;
import com.fasterxml.jackson.core.json.UTF8JsonGenerator;
import com.fasterxml.jackson.core.util.BufferRecycler;
import com.fasterxml.jackson.core.util.JsonGeneratorDelegate;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.ser.DefaultSerializerProvider;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.thingsboard.server.common.data.BaseData;

class EntityIdSerializerDiffblueTest {
  /**
   * Method under test: default or parameterless constructor of
   * {@link EntityIdSerializer}
   */
  @Test
  void testNewEntityIdSerializer() {
    // Arrange and Act
    EntityIdSerializer actualEntityIdSerializer = new EntityIdSerializer();

    // Assert
    assertNull(actualEntityIdSerializer.getDelegatee());
    assertFalse(actualEntityIdSerializer.isUnwrappingSerializer());
  }

  /**
   * Method under test:
   * {@link EntityIdSerializer#serialize(EntityId, JsonGenerator, SerializerProvider)}
   */
  @Test
  void testSerialize() throws IOException {
    // Arrange
    EntityIdSerializer entityIdSerializer = new EntityIdSerializer();
    JsonGenerator d = mock(JsonGenerator.class);
    doNothing().when(d).writeEndObject();
    doNothing().when(d).writeFieldName(Mockito.<String>any());
    doNothing().when(d).writeStartObject();
    doNothing().when(d).writeString(Mockito.<String>any());
    JsonGeneratorDelegate gen = new JsonGeneratorDelegate(new JsonGeneratorDelegate(d), true);

    // Act
    entityIdSerializer.serialize(TenantId.SYS_TENANT_ID, gen, new DefaultSerializerProvider.Impl());

    // Assert
    verify(d).writeEndObject();
    verify(d, atLeast(1)).writeFieldName(Mockito.<String>any());
    verify(d).writeStartObject();
    verify(d, atLeast(1)).writeString(Mockito.<String>any());
  }

  /**
   * Method under test:
   * {@link EntityIdSerializer#serialize(EntityId, JsonGenerator, SerializerProvider)}
   */
  @Test
  void testSerialize2() throws IOException {
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
    FilteringGeneratorDelegate d3 = new FilteringGeneratorDelegate(d2, f, TokenFilter.Inclusion.ONLY_INCLUDE_ALL, true);

    JsonGeneratorDelegate gen = new JsonGeneratorDelegate(d3, true);

    // Act
    entityIdSerializer.serialize(TenantId.SYS_TENANT_ID, gen, new DefaultSerializerProvider.Impl());

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
    assertEquals(1, outputContext.getEntryCount());
    assertEquals(2, ((FilteringGeneratorDelegate) delegateResult).getMatchCount());
    assertTrue(outputContext.hasCurrentIndex());
    assertSame(d3, delegateResult);
  }

  /**
   * Method under test:
   * {@link EntityIdSerializer#serialize(EntityId, JsonGenerator, SerializerProvider)}
   */
  @Test
  void testSerialize3() throws IOException {
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
        new FilteringGeneratorDelegate(d2, f, TokenFilter.Inclusion.ONLY_INCLUDE_ALL, true), true);

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
    FilteringGeneratorDelegate d4 = new FilteringGeneratorDelegate(d3, f2, TokenFilter.Inclusion.ONLY_INCLUDE_ALL,
        true);

    JsonGeneratorDelegate gen = new JsonGeneratorDelegate(d4, true);

    // Act
    entityIdSerializer.serialize(TenantId.SYS_TENANT_ID, gen, new DefaultSerializerProvider.Impl());

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
    JsonStreamContext outputContext = gen.getOutputContext();
    assertTrue(outputContext instanceof TokenFilterContext);
    assertEquals(1, outputContext.getEntryCount());
    assertTrue(outputContext.hasCurrentIndex());
    assertSame(d4, gen.delegate());
  }

  /**
   * Method under test:
   * {@link EntityIdSerializer#serialize(EntityId, JsonGenerator, SerializerProvider)}
   */
  @Test
  void testSerialize4() throws IOException {
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
        new FilteringGeneratorDelegate(d2, f, TokenFilter.Inclusion.ONLY_INCLUDE_ALL, true), true);

    TokenFilter tokenFilter3 = mock(TokenFilter.class);
    when(tokenFilter3.includeEmptyObject(anyBoolean())).thenReturn(true);
    doNothing().when(tokenFilter3).filterFinishObject();
    TokenFilter tokenFilter4 = mock(TokenFilter.class);
    when(tokenFilter4.includeString(Mockito.<String>any())).thenReturn(true);
    when(tokenFilter4.filterStartObject()).thenReturn(tokenFilter3);
    TokenFilter f2 = mock(TokenFilter.class);
    when(f2.includeRootValue(anyInt())).thenReturn(tokenFilter4);
    JsonGeneratorDelegate d4 = new JsonGeneratorDelegate(
        new FilteringGeneratorDelegate(d3, f2, TokenFilter.Inclusion.ONLY_INCLUDE_ALL, true), true);

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
    FilteringGeneratorDelegate d5 = new FilteringGeneratorDelegate(d4, f3, TokenFilter.Inclusion.ONLY_INCLUDE_ALL,
        true);

    JsonGeneratorDelegate gen = new JsonGeneratorDelegate(d5, true);

    // Act
    entityIdSerializer.serialize(TenantId.SYS_TENANT_ID, gen, new DefaultSerializerProvider.Impl());

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
    JsonStreamContext outputContext = gen.getOutputContext();
    assertTrue(outputContext instanceof TokenFilterContext);
    assertEquals(1, outputContext.getEntryCount());
    assertTrue(outputContext.hasCurrentIndex());
    assertSame(d5, gen.delegate());
  }

  /**
   * Method under test:
   * {@link EntityIdSerializer#serialize(EntityId, JsonGenerator, SerializerProvider)}
   */
  @Test
  void testSerialize5() throws IOException {
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
        f, TokenFilter.Inclusion.ONLY_INCLUDE_ALL, true), true);

    TokenFilter tokenFilter3 = mock(TokenFilter.class);
    when(tokenFilter3.includeEmptyObject(anyBoolean())).thenReturn(true);
    doNothing().when(tokenFilter3).filterFinishObject();
    TokenFilter tokenFilter4 = mock(TokenFilter.class);
    when(tokenFilter4.includeString(Mockito.<String>any())).thenReturn(true);
    when(tokenFilter4.filterStartObject()).thenReturn(tokenFilter3);
    TokenFilter f2 = mock(TokenFilter.class);
    when(f2.includeRootValue(anyInt())).thenReturn(tokenFilter4);
    JsonGeneratorDelegate d2 = new JsonGeneratorDelegate(
        new FilteringGeneratorDelegate(d, f2, TokenFilter.Inclusion.ONLY_INCLUDE_ALL, true), true);

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
    FilteringGeneratorDelegate d3 = new FilteringGeneratorDelegate(d2, f3, TokenFilter.Inclusion.ONLY_INCLUDE_ALL,
        true);

    JsonGeneratorDelegate gen = new JsonGeneratorDelegate(d3, true);

    // Act
    entityIdSerializer.serialize(TenantId.SYS_TENANT_ID, gen, new DefaultSerializerProvider.Impl());

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
    JsonStreamContext outputContext = gen.getOutputContext();
    assertTrue(outputContext instanceof TokenFilterContext);
    assertEquals(1, outputContext.getEntryCount());
    assertEquals(50, gen.getOutputBuffered());
    assertTrue(outputContext.hasCurrentIndex());
    assertSame(d3, gen.delegate());
  }

  /**
   * Method under test:
   * {@link EntityIdSerializer#serialize(EntityId, JsonGenerator, SerializerProvider)}
   */
  @Test
  void testSerialize6() throws IOException {
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
        new FilteringGeneratorDelegate(d2, f, TokenFilter.Inclusion.ONLY_INCLUDE_ALL, true), true);

    TokenFilter tokenFilter3 = mock(TokenFilter.class);
    when(tokenFilter3.includeString(Mockito.<String>any())).thenReturn(true);
    TokenFilter tokenFilter4 = mock(TokenFilter.class);
    when(tokenFilter4.includeProperty(Mockito.<String>any())).thenReturn(tokenFilter3);
    when(tokenFilter4.includeEmptyObject(anyBoolean())).thenReturn(true);
    doNothing().when(tokenFilter4).filterFinishObject();
    TokenFilter tokenFilter5 = mock(TokenFilter.class);
    when(tokenFilter5.includeString(Mockito.<String>any())).thenReturn(true);
    when(tokenFilter5.filterStartObject()).thenReturn(tokenFilter4);
    TokenFilter f2 = mock(TokenFilter.class);
    when(f2.includeRootValue(anyInt())).thenReturn(tokenFilter5);
    JsonGeneratorDelegate d4 = new JsonGeneratorDelegate(
        new FilteringGeneratorDelegate(d3, f2, TokenFilter.Inclusion.ONLY_INCLUDE_ALL, true), true);

    TokenFilter tokenFilter6 = mock(TokenFilter.class);
    when(tokenFilter6.includeString(Mockito.<String>any())).thenReturn(true);
    TokenFilter tokenFilter7 = mock(TokenFilter.class);
    when(tokenFilter7.includeEmptyObject(anyBoolean())).thenReturn(true);
    when(tokenFilter7.includeProperty(Mockito.<String>any())).thenReturn(tokenFilter6);
    doNothing().when(tokenFilter7).filterFinishObject();
    TokenFilter tokenFilter8 = mock(TokenFilter.class);
    when(tokenFilter8.filterStartObject()).thenReturn(tokenFilter7);
    TokenFilter f3 = mock(TokenFilter.class);
    when(f3.includeRootValue(anyInt())).thenReturn(tokenFilter8);
    FilteringGeneratorDelegate d5 = new FilteringGeneratorDelegate(d4, f3, TokenFilter.Inclusion.INCLUDE_ALL_AND_PATH,
        true);

    JsonGeneratorDelegate gen = new JsonGeneratorDelegate(d5, true);

    // Act
    entityIdSerializer.serialize(TenantId.SYS_TENANT_ID, gen, new DefaultSerializerProvider.Impl());

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
    JsonStreamContext outputContext = gen.getOutputContext();
    assertTrue(outputContext instanceof TokenFilterContext);
    assertEquals(1, outputContext.getEntryCount());
    assertTrue(outputContext.hasCurrentIndex());
    assertSame(d5, gen.delegate());
  }

  /**
   * Method under test:
   * {@link EntityIdSerializer#serialize(EntityId, JsonGenerator, SerializerProvider)}
   */
  @Test
  void testSerialize7() throws IOException {
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

    FilteringGeneratorDelegate d = new FilteringGeneratorDelegate(
        new JsonGeneratorDelegate(new UTF8JsonGenerator(ctxt, 1, BaseData.mapper, new ByteArrayOutputStream(1)), true),
        f, TokenFilter.Inclusion.INCLUDE_ALL_AND_PATH, true);

    JsonGeneratorDelegate gen = new JsonGeneratorDelegate(d, true);

    // Act
    entityIdSerializer.serialize(TenantId.SYS_TENANT_ID, gen, new DefaultSerializerProvider.Impl());

    // Assert
    verify(tokenFilter2).filterFinishObject();
    verify(tokenFilter3).filterStartObject();
    verify(tokenFilter2, atLeast(1)).includeProperty(Mockito.<String>any());
    verify(f).includeRootValue(eq(0));
    verify(tokenFilter, atLeast(1)).includeString(Mockito.<String>any());
    JsonStreamContext outputContext = gen.getOutputContext();
    assertTrue(outputContext instanceof TokenFilterContext);
    assertEquals(1, outputContext.getEntryCount());
    assertEquals(63, gen.getOutputBuffered());
    assertTrue(outputContext.hasCurrentIndex());
    assertSame(d, gen.delegate());
  }
}
