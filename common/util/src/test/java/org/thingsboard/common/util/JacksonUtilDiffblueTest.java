package org.thingsboard.common.util;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.ArgumentMatchers.isNull;
import static org.mockito.Mockito.anyInt;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.MethodsUnderTest;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationConfig;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectMapper.DefaultTypeResolverBuilder;
import com.fasterxml.jackson.databind.ObjectMapper.DefaultTyping;
import com.fasterxml.jackson.databind.SerializationConfig;
import com.fasterxml.jackson.databind.cfg.CacheProvider;
import com.fasterxml.jackson.databind.deser.DefaultDeserializationContext;
import com.fasterxml.jackson.databind.introspect.VisibilityChecker;
import com.fasterxml.jackson.databind.introspect.VisibilityChecker.Std;
import com.fasterxml.jackson.databind.json.JsonMapper;
import com.fasterxml.jackson.databind.json.JsonMapper.Builder;
import com.fasterxml.jackson.databind.jsontype.DefaultBaseTypeLimitingValidator;
import com.fasterxml.jackson.databind.jsontype.impl.LaissezFaireSubTypeValidator;
import com.fasterxml.jackson.databind.jsontype.impl.StdSubtypeResolver;
import com.fasterxml.jackson.databind.jsontype.impl.StdTypeResolverBuilder;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.BigIntegerNode;
import com.fasterxml.jackson.databind.node.BinaryNode;
import com.fasterxml.jackson.databind.node.BooleanNode;
import com.fasterxml.jackson.databind.node.DoubleNode;
import com.fasterxml.jackson.databind.node.FloatNode;
import com.fasterxml.jackson.databind.node.IntNode;
import com.fasterxml.jackson.databind.node.JsonNodeFactory;
import com.fasterxml.jackson.databind.node.JsonNodeType;
import com.fasterxml.jackson.databind.node.MissingNode;
import com.fasterxml.jackson.databind.node.NullNode;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.fasterxml.jackson.databind.node.POJONode;
import com.fasterxml.jackson.databind.node.TextNode;
import com.fasterxml.jackson.databind.node.TreeTraversingParser;
import com.fasterxml.jackson.databind.ser.BeanSerializerFactory;
import com.fasterxml.jackson.databind.ser.DefaultSerializerProvider;
import com.fasterxml.jackson.databind.ser.DefaultSerializerProvider.Impl;
import com.fasterxml.jackson.databind.type.CollectionLikeType;
import com.fasterxml.jackson.databind.type.CollectionType;
import com.fasterxml.jackson.databind.type.PlaceholderForType;
import com.fasterxml.jackson.databind.type.ResolvedRecursiveType;
import com.fasterxml.jackson.databind.type.TypeBindings;
import com.fasterxml.jackson.databind.util.LRUMap;
import com.fasterxml.jackson.databind.util.RawValue;
import com.fasterxml.jackson.databind.util.StdDateFormat;
import java.io.ByteArrayInputStream;
import java.io.CharArrayReader;
import java.io.DataInputStream;
import java.io.File;
import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PipedWriter;
import java.io.Reader;
import java.io.StringReader;
import java.io.StringWriter;
import java.io.UnsupportedEncodingException;
import java.io.Writer;
import java.math.BigInteger;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.UUID;
import java.util.concurrent.TimeUnit;
import java.util.function.UnaryOperator;
import java.util.regex.Pattern;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.thingsboard.server.common.data.AdminSettings;
import org.thingsboard.server.common.data.ApiUsageState;
import org.thingsboard.server.common.data.BaseData;
import org.thingsboard.server.common.data.BaseDataWithAdditionalInfo;
import org.thingsboard.server.common.data.Customer;
import org.thingsboard.server.common.data.Dashboard;
import org.thingsboard.server.common.data.HomeDashboard;
import org.thingsboard.server.common.data.ImageDescriptor;
import org.thingsboard.server.common.data.TenantProfile;
import org.thingsboard.server.common.data.alarm.Alarm;
import org.thingsboard.server.common.data.alarm.AlarmAssignee;
import org.thingsboard.server.common.data.device.credentials.lwm2m.PSKBootstrapClientCredential;
import org.thingsboard.server.common.data.device.data.CoapDeviceTransportConfiguration;
import org.thingsboard.server.common.data.device.profile.AlarmCondition;
import org.thingsboard.server.common.data.device.profile.AlarmConditionFilter;
import org.thingsboard.server.common.data.device.profile.AlarmConditionFilterKey;
import org.thingsboard.server.common.data.device.profile.AlarmConditionKeyType;
import org.thingsboard.server.common.data.device.profile.AlarmConditionSpec;
import org.thingsboard.server.common.data.device.profile.DurationAlarmConditionSpec;
import org.thingsboard.server.common.data.id.AdminSettingsId;
import org.thingsboard.server.common.data.id.AlarmId;
import org.thingsboard.server.common.data.id.CustomerId;
import org.thingsboard.server.common.data.id.IdBased;
import org.thingsboard.server.common.data.id.TenantId;
import org.thingsboard.server.common.data.id.UUIDBased;
import org.thingsboard.server.common.data.id.UserId;
import org.thingsboard.server.common.data.kv.JsonDataEntry;
import org.thingsboard.server.common.data.kv.KvEntry;
import org.thingsboard.server.common.data.kv.StringDataEntry;
import org.thingsboard.server.common.data.query.DynamicValue;
import org.thingsboard.server.common.data.query.DynamicValueSourceType;
import org.thingsboard.server.common.data.query.EntityKeyValueType;
import org.thingsboard.server.common.data.query.FilterPredicateValue;
import org.thingsboard.server.common.data.query.KeyFilterPredicate;

class JacksonUtilDiffblueTest {
  /**
   * Test {@link JacksonUtil#getObjectMapperWithJavaTimeModule()}.
   * <p>
   * Method under test: {@link JacksonUtil#getObjectMapperWithJavaTimeModule()}
   */
  @Test
  @DisplayName("Test getObjectMapperWithJavaTimeModule()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"ObjectMapper JacksonUtil.getObjectMapperWithJavaTimeModule()"})
  void testGetObjectMapperWithJavaTimeModule() {
    // Arrange and Act
    ObjectMapper actualObjectMapperWithJavaTimeModule = JacksonUtil.getObjectMapperWithJavaTimeModule();

    // Assert
    assertTrue(
        actualObjectMapperWithJavaTimeModule.getDeserializationContext() instanceof DefaultDeserializationContext.Impl);
    assertTrue(actualObjectMapperWithJavaTimeModule.getVisibilityChecker() instanceof Std);
    assertTrue(actualObjectMapperWithJavaTimeModule instanceof JsonMapper);
    assertTrue(
        actualObjectMapperWithJavaTimeModule.getPolymorphicTypeValidator() instanceof LaissezFaireSubTypeValidator);
    assertTrue(actualObjectMapperWithJavaTimeModule.getSubtypeResolver() instanceof StdSubtypeResolver);
    assertTrue(actualObjectMapperWithJavaTimeModule.getSerializerFactory() instanceof BeanSerializerFactory);
    assertTrue(actualObjectMapperWithJavaTimeModule.getSerializerProvider() instanceof Impl);
    assertTrue(actualObjectMapperWithJavaTimeModule.getSerializerProviderInstance() instanceof Impl);
    assertTrue(actualObjectMapperWithJavaTimeModule.getDateFormat() instanceof StdDateFormat);
    assertNull(actualObjectMapperWithJavaTimeModule.getInjectableValues());
    assertNull(actualObjectMapperWithJavaTimeModule.getPropertyNamingStrategy());
    assertEquals(2, actualObjectMapperWithJavaTimeModule.getRegisteredModuleIds().size());
  }

  /**
   * Test {@link JacksonUtil#convertValue(Object, Class)} with {@code fromValue}, {@code toValueType}.
   * <p>
   * Method under test: {@link JacksonUtil#convertValue(Object, Class)}
   */
  @Test
  @DisplayName("Test convertValue(Object, Class) with 'fromValue', 'toValueType'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Object JacksonUtil.convertValue(Object, Class)"})
  void testConvertValueWithFromValueToValueType() {
    // Arrange
    Class<Builder> toValueType = Builder.class;

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> JacksonUtil.convertValue("From Value", toValueType));
  }

  /**
   * Test {@link JacksonUtil#convertValue(Object, TypeReference)} with {@code fromValue}, {@code toValueTypeRef}.
   * <p>
   * Method under test: {@link JacksonUtil#convertValue(Object, TypeReference)}
   */
  @Test
  @DisplayName("Test convertValue(Object, TypeReference) with 'fromValue', 'toValueTypeRef'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Object JacksonUtil.convertValue(Object, TypeReference)"})
  void testConvertValueWithFromValueToValueTypeRef() {
    // Arrange
    CollectionLikeType collectionLikeType = mock(CollectionLikeType.class);
    when(collectionLikeType.isEnumType()).thenReturn(true);
    when(collectionLikeType.getKeyType()).thenReturn(new PlaceholderForType(1));
    when(collectionLikeType.getContentType()).thenReturn(new PlaceholderForType(1));
    when(collectionLikeType.isAbstract()).thenReturn(true);
    when(collectionLikeType.isMapLikeType()).thenReturn(true);
    when(collectionLikeType.isContainerType()).thenReturn(true);
    Class<Object> forNameResult = Object.class;
    Mockito.<Class<?>>when(collectionLikeType.getRawClass()).thenReturn(forNameResult);
    TypeReference<Object> toValueTypeRef = mock(TypeReference.class);
    when(toValueTypeRef.getType()).thenReturn(collectionLikeType);

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> JacksonUtil.convertValue("From Value", toValueTypeRef));
    verify(toValueTypeRef).getType();
    verify(collectionLikeType, atLeast(1)).getKeyType();
    verify(collectionLikeType, atLeast(1)).getRawClass();
    verify(collectionLikeType).isAbstract();
    verify(collectionLikeType).isEnumType();
    verify(collectionLikeType, atLeast(1)).isMapLikeType();
    verify(collectionLikeType, atLeast(1)).getContentType();
    verify(collectionLikeType, atLeast(1)).isContainerType();
  }

  /**
   * Test {@link JacksonUtil#convertValue(Object, TypeReference)} with {@code fromValue}, {@code toValueTypeRef}.
   * <p>
   * Method under test: {@link JacksonUtil#convertValue(Object, TypeReference)}
   */
  @Test
  @DisplayName("Test convertValue(Object, TypeReference) with 'fromValue', 'toValueTypeRef'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Object JacksonUtil.convertValue(Object, TypeReference)"})
  void testConvertValueWithFromValueToValueTypeRef2() {
    // Arrange
    CollectionLikeType collectionLikeType = mock(CollectionLikeType.class);
    when(collectionLikeType.getValueHandler()).thenReturn("Value Handler");
    CollectionLikeType collectionLikeType2 = mock(CollectionLikeType.class);
    when(collectionLikeType2.isEnumType()).thenReturn(true);
    when(collectionLikeType2.getKeyType()).thenReturn(new PlaceholderForType(1));
    when(collectionLikeType2.getContentType()).thenReturn(collectionLikeType);
    when(collectionLikeType2.isAbstract()).thenReturn(true);
    when(collectionLikeType2.isMapLikeType()).thenReturn(true);
    when(collectionLikeType2.isContainerType()).thenReturn(true);
    Class<Object> forNameResult = Object.class;
    Mockito.<Class<?>>when(collectionLikeType2.getRawClass()).thenReturn(forNameResult);
    TypeReference<Object> toValueTypeRef = mock(TypeReference.class);
    when(toValueTypeRef.getType()).thenReturn(collectionLikeType2);

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> JacksonUtil.convertValue("From Value", toValueTypeRef));
    verify(toValueTypeRef).getType();
    verify(collectionLikeType2, atLeast(1)).getKeyType();
    verify(collectionLikeType2, atLeast(1)).getRawClass();
    verify(collectionLikeType, atLeast(1)).getValueHandler();
    verify(collectionLikeType2).isAbstract();
    verify(collectionLikeType2).isEnumType();
    verify(collectionLikeType2, atLeast(1)).isMapLikeType();
    verify(collectionLikeType2, atLeast(1)).getContentType();
    verify(collectionLikeType2, atLeast(1)).isContainerType();
  }

  /**
   * Test {@link JacksonUtil#convertValue(Object, TypeReference)} with {@code fromValue}, {@code toValueTypeRef}.
   * <p>
   * Method under test: {@link JacksonUtil#convertValue(Object, TypeReference)}
   */
  @Test
  @DisplayName("Test convertValue(Object, TypeReference) with 'fromValue', 'toValueTypeRef'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Object JacksonUtil.convertValue(Object, TypeReference)"})
  void testConvertValueWithFromValueToValueTypeRef3() {
    // Arrange
    CollectionLikeType collectionLikeType = mock(CollectionLikeType.class);
    when(collectionLikeType.getValueHandler()).thenReturn("Value Handler");
    CollectionLikeType collectionLikeType2 = mock(CollectionLikeType.class);
    when(collectionLikeType2.isConcrete()).thenReturn(true);
    when(collectionLikeType2.isRecordType()).thenReturn(true);
    when(collectionLikeType2.isArrayType()).thenReturn(true);
    when(collectionLikeType2.isEnumType()).thenReturn(true);
    when(collectionLikeType2.getKeyType()).thenReturn(new PlaceholderForType(1));
    when(collectionLikeType2.getContentType()).thenReturn(collectionLikeType);
    when(collectionLikeType2.isAbstract()).thenReturn(true);
    when(collectionLikeType2.isMapLikeType()).thenReturn(true);
    when(collectionLikeType2.isContainerType()).thenReturn(true);
    Class<Builder> forNameResult = Builder.class;
    Mockito.<Class<?>>when(collectionLikeType2.getRawClass()).thenReturn(forNameResult);
    TypeReference<Object> toValueTypeRef = mock(TypeReference.class);
    when(toValueTypeRef.getType()).thenReturn(collectionLikeType2);

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> JacksonUtil.convertValue("From Value", toValueTypeRef));
    verify(toValueTypeRef).getType();
    verify(collectionLikeType2, atLeast(1)).getKeyType();
    verify(collectionLikeType2, atLeast(1)).getRawClass();
    verify(collectionLikeType, atLeast(1)).getValueHandler();
    verify(collectionLikeType2).isAbstract();
    verify(collectionLikeType2, atLeast(1)).isArrayType();
    verify(collectionLikeType2).isConcrete();
    verify(collectionLikeType2).isEnumType();
    verify(collectionLikeType2, atLeast(1)).isMapLikeType();
    verify(collectionLikeType2, atLeast(1)).isRecordType();
    verify(collectionLikeType2, atLeast(1)).getContentType();
    verify(collectionLikeType2, atLeast(1)).isContainerType();
  }

  /**
   * Test {@link JacksonUtil#convertValue(Object, TypeReference)} with {@code fromValue}, {@code toValueTypeRef}.
   * <p>
   * Method under test: {@link JacksonUtil#convertValue(Object, TypeReference)}
   */
  @Test
  @DisplayName("Test convertValue(Object, TypeReference) with 'fromValue', 'toValueTypeRef'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Object JacksonUtil.convertValue(Object, TypeReference)"})
  void testConvertValueWithFromValueToValueTypeRef4() {
    // Arrange
    CollectionLikeType collectionLikeType = mock(CollectionLikeType.class);
    when(collectionLikeType.getValueHandler()).thenReturn("Value Handler");
    CollectionLikeType collectionLikeType2 = mock(CollectionLikeType.class);
    when(collectionLikeType2.getSuperClass()).thenReturn(new PlaceholderForType(1));
    when(collectionLikeType2.getBindings()).thenReturn(TypeBindings.emptyBindings());
    when(collectionLikeType2.hasRawClass(Mockito.<Class<Object>>any())).thenReturn(true);
    when(collectionLikeType2.isConcrete()).thenReturn(true);
    when(collectionLikeType2.isRecordType()).thenReturn(true);
    when(collectionLikeType2.isArrayType()).thenReturn(false);
    when(collectionLikeType2.isEnumType()).thenReturn(true);
    when(collectionLikeType2.getKeyType()).thenReturn(new PlaceholderForType(1));
    when(collectionLikeType2.getContentType()).thenReturn(collectionLikeType);
    when(collectionLikeType2.isAbstract()).thenReturn(true);
    when(collectionLikeType2.isMapLikeType()).thenReturn(true);
    when(collectionLikeType2.isContainerType()).thenReturn(true);
    Class<Builder> forNameResult = Builder.class;
    Mockito.<Class<?>>when(collectionLikeType2.getRawClass()).thenReturn(forNameResult);
    TypeReference<Object> toValueTypeRef = mock(TypeReference.class);
    when(toValueTypeRef.getType()).thenReturn(collectionLikeType2);

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> JacksonUtil.convertValue("From Value", toValueTypeRef));
    verify(toValueTypeRef).getType();
    verify(collectionLikeType2, atLeast(1)).getKeyType();
    verify(collectionLikeType2, atLeast(1)).getRawClass();
    verify(collectionLikeType, atLeast(1)).getValueHandler();
    verify(collectionLikeType2).hasRawClass(isA(Class.class));
    verify(collectionLikeType2).isAbstract();
    verify(collectionLikeType2, atLeast(1)).isArrayType();
    verify(collectionLikeType2).isConcrete();
    verify(collectionLikeType2, atLeast(1)).isEnumType();
    verify(collectionLikeType2, atLeast(1)).isMapLikeType();
    verify(collectionLikeType2, atLeast(1)).isRecordType();
    verify(collectionLikeType2, atLeast(1)).getContentType();
    verify(collectionLikeType2, atLeast(1)).isContainerType();
    verify(collectionLikeType2).getBindings();
    verify(collectionLikeType2).getSuperClass();
  }

  /**
   * Test {@link JacksonUtil#convertValue(Object, TypeReference)} with {@code fromValue}, {@code toValueTypeRef}.
   * <p>
   * Method under test: {@link JacksonUtil#convertValue(Object, TypeReference)}
   */
  @Test
  @DisplayName("Test convertValue(Object, TypeReference) with 'fromValue', 'toValueTypeRef'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Object JacksonUtil.convertValue(Object, TypeReference)"})
  void testConvertValueWithFromValueToValueTypeRef5() {
    // Arrange
    CollectionLikeType collectionLikeType = mock(CollectionLikeType.class);
    when(collectionLikeType.getValueHandler()).thenReturn("Value Handler");
    CollectionLikeType collectionLikeType2 = mock(CollectionLikeType.class);
    Class<Object> erasedType = Object.class;
    when(collectionLikeType2.getSuperClass())
        .thenReturn(new ResolvedRecursiveType(erasedType, TypeBindings.emptyBindings()));
    when(collectionLikeType2.getBindings()).thenReturn(TypeBindings.emptyBindings());
    when(collectionLikeType2.hasRawClass(Mockito.<Class<Object>>any())).thenReturn(true);
    when(collectionLikeType2.isConcrete()).thenReturn(true);
    when(collectionLikeType2.isRecordType()).thenReturn(true);
    when(collectionLikeType2.isArrayType()).thenReturn(false);
    when(collectionLikeType2.isEnumType()).thenReturn(true);
    when(collectionLikeType2.getKeyType()).thenReturn(new PlaceholderForType(1));
    when(collectionLikeType2.getContentType()).thenReturn(collectionLikeType);
    when(collectionLikeType2.isAbstract()).thenReturn(true);
    when(collectionLikeType2.isMapLikeType()).thenReturn(true);
    when(collectionLikeType2.isContainerType()).thenReturn(true);
    Class<Builder> forNameResult = Builder.class;
    Mockito.<Class<?>>when(collectionLikeType2.getRawClass()).thenReturn(forNameResult);
    TypeReference<Object> toValueTypeRef = mock(TypeReference.class);
    when(toValueTypeRef.getType()).thenReturn(collectionLikeType2);

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> JacksonUtil.convertValue("From Value", toValueTypeRef));
    verify(toValueTypeRef).getType();
    verify(collectionLikeType2, atLeast(1)).getKeyType();
    verify(collectionLikeType2, atLeast(1)).getRawClass();
    verify(collectionLikeType, atLeast(1)).getValueHandler();
    verify(collectionLikeType2).hasRawClass(isA(Class.class));
    verify(collectionLikeType2).isAbstract();
    verify(collectionLikeType2, atLeast(1)).isArrayType();
    verify(collectionLikeType2).isConcrete();
    verify(collectionLikeType2, atLeast(1)).isEnumType();
    verify(collectionLikeType2, atLeast(1)).isMapLikeType();
    verify(collectionLikeType2, atLeast(1)).isRecordType();
    verify(collectionLikeType2, atLeast(1)).getContentType();
    verify(collectionLikeType2, atLeast(1)).isContainerType();
    verify(collectionLikeType2).getBindings();
    verify(collectionLikeType2).getSuperClass();
  }

  /**
   * Test {@link JacksonUtil#convertValue(Object, TypeReference)} with {@code fromValue}, {@code toValueTypeRef}.
   * <p>
   * Method under test: {@link JacksonUtil#convertValue(Object, TypeReference)}
   */
  @Test
  @DisplayName("Test convertValue(Object, TypeReference) with 'fromValue', 'toValueTypeRef'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Object JacksonUtil.convertValue(Object, TypeReference)"})
  void testConvertValueWithFromValueToValueTypeRef6() {
    // Arrange
    CollectionLikeType collectionLikeType = mock(CollectionLikeType.class);
    when(collectionLikeType.getValueHandler()).thenReturn("Value Handler");
    CollectionLikeType collectionLikeType2 = mock(CollectionLikeType.class);
    when(collectionLikeType2.getSuperClass()).thenReturn(new PlaceholderForType(1));
    when(collectionLikeType2.getBindings()).thenReturn(TypeBindings.emptyBindings());
    when(collectionLikeType2.hasRawClass(Mockito.<Class<Object>>any())).thenReturn(true);
    when(collectionLikeType2.isConcrete()).thenReturn(true);
    when(collectionLikeType2.isRecordType()).thenReturn(true);
    when(collectionLikeType2.isArrayType()).thenReturn(false);
    when(collectionLikeType2.isEnumType()).thenReturn(true);
    when(collectionLikeType2.getKeyType()).thenReturn(new PlaceholderForType(1));
    when(collectionLikeType2.getContentType()).thenReturn(collectionLikeType);
    when(collectionLikeType2.isAbstract()).thenReturn(true);
    when(collectionLikeType2.isMapLikeType()).thenReturn(true);
    when(collectionLikeType2.isContainerType()).thenReturn(true);
    Class<JacksonUtil> forNameResult = JacksonUtil.class;
    Mockito.<Class<?>>when(collectionLikeType2.getRawClass()).thenReturn(forNameResult);
    TypeReference<Object> toValueTypeRef = mock(TypeReference.class);
    when(toValueTypeRef.getType()).thenReturn(collectionLikeType2);

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> JacksonUtil.convertValue("From Value", toValueTypeRef));
    verify(toValueTypeRef).getType();
    verify(collectionLikeType2, atLeast(1)).getKeyType();
    verify(collectionLikeType2, atLeast(1)).getRawClass();
    verify(collectionLikeType, atLeast(1)).getValueHandler();
    verify(collectionLikeType2).hasRawClass(isA(Class.class));
    verify(collectionLikeType2).isAbstract();
    verify(collectionLikeType2, atLeast(1)).isArrayType();
    verify(collectionLikeType2).isConcrete();
    verify(collectionLikeType2, atLeast(1)).isEnumType();
    verify(collectionLikeType2, atLeast(1)).isMapLikeType();
    verify(collectionLikeType2, atLeast(1)).isRecordType();
    verify(collectionLikeType2, atLeast(1)).getContentType();
    verify(collectionLikeType2, atLeast(1)).isContainerType();
    verify(collectionLikeType2, atLeast(1)).getBindings();
    verify(collectionLikeType2).getSuperClass();
  }

  /**
   * Test {@link JacksonUtil#convertValue(Object, TypeReference)} with {@code fromValue}, {@code toValueTypeRef}.
   * <ul>
   *   <li>Given {@code String}.</li>
   * </ul>
   * <p>
   * Method under test: {@link JacksonUtil#convertValue(Object, TypeReference)}
   */
  @Test
  @DisplayName("Test convertValue(Object, TypeReference) with 'fromValue', 'toValueTypeRef'; given 'java.lang.String'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Object JacksonUtil.convertValue(Object, TypeReference)"})
  void testConvertValueWithFromValueToValueTypeRef_givenJavaLangString() {
    // Arrange
    CollectionLikeType collectionLikeType = mock(CollectionLikeType.class);
    when(collectionLikeType.getValueHandler()).thenReturn("Value Handler");
    CollectionLikeType collectionLikeType2 = mock(CollectionLikeType.class);
    when(collectionLikeType2.isEnumType()).thenReturn(true);
    when(collectionLikeType2.getKeyType()).thenReturn(new PlaceholderForType(1));
    when(collectionLikeType2.getContentType()).thenReturn(collectionLikeType);
    when(collectionLikeType2.isAbstract()).thenReturn(true);
    when(collectionLikeType2.isMapLikeType()).thenReturn(true);
    when(collectionLikeType2.isContainerType()).thenReturn(true);
    Class<String> forNameResult = String.class;
    Mockito.<Class<?>>when(collectionLikeType2.getRawClass()).thenReturn(forNameResult);
    TypeReference<Object> toValueTypeRef = mock(TypeReference.class);
    when(toValueTypeRef.getType()).thenReturn(collectionLikeType2);

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> JacksonUtil.convertValue("From Value", toValueTypeRef));
    verify(toValueTypeRef).getType();
    verify(collectionLikeType2, atLeast(1)).getKeyType();
    verify(collectionLikeType2, atLeast(1)).getRawClass();
    verify(collectionLikeType, atLeast(1)).getValueHandler();
    verify(collectionLikeType2).isAbstract();
    verify(collectionLikeType2).isEnumType();
    verify(collectionLikeType2, atLeast(1)).isMapLikeType();
    verify(collectionLikeType2, atLeast(1)).getContentType();
    verify(collectionLikeType2, atLeast(1)).isContainerType();
  }

  /**
   * Test {@link JacksonUtil#convertValue(Object, TypeReference)} with {@code fromValue}, {@code toValueTypeRef}.
   * <ul>
   *   <li>Then return {@code From Value}.</li>
   * </ul>
   * <p>
   * Method under test: {@link JacksonUtil#convertValue(Object, TypeReference)}
   */
  @Test
  @DisplayName("Test convertValue(Object, TypeReference) with 'fromValue', 'toValueTypeRef'; then return 'From Value'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Object JacksonUtil.convertValue(Object, TypeReference)"})
  void testConvertValueWithFromValueToValueTypeRef_thenReturnFromValue() {
    // Arrange
    TypeReference<Object> toValueTypeRef = mock(TypeReference.class);
    when(toValueTypeRef.getType()).thenReturn(new PlaceholderForType(1));

    // Act
    Object actualConvertValueResult = JacksonUtil.convertValue("From Value", toValueTypeRef);

    // Assert
    verify(toValueTypeRef).getType();
    assertEquals("From Value", actualConvertValueResult);
  }

  /**
   * Test {@link JacksonUtil#convertValue(Object, TypeReference)} with {@code fromValue}, {@code toValueTypeRef}.
   * <ul>
   *   <li>Then return intValue is forty-two.</li>
   * </ul>
   * <p>
   * Method under test: {@link JacksonUtil#convertValue(Object, TypeReference)}
   */
  @Test
  @DisplayName("Test convertValue(Object, TypeReference) with 'fromValue', 'toValueTypeRef'; then return intValue is forty-two")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Object JacksonUtil.convertValue(Object, TypeReference)"})
  void testConvertValueWithFromValueToValueTypeRef_thenReturnIntValueIsFortyTwo() {
    // Arrange
    TypeReference<Object> toValueTypeRef = mock(TypeReference.class);
    when(toValueTypeRef.getType()).thenReturn(new PlaceholderForType(1));

    // Act
    Object actualConvertValueResult = JacksonUtil.convertValue(42, toValueTypeRef);

    // Assert
    verify(toValueTypeRef).getType();
    assertEquals(42, ((Integer) actualConvertValueResult).intValue());
  }

  /**
   * Test {@link JacksonUtil#convertValue(Object, TypeReference)} with {@code fromValue}, {@code toValueTypeRef}.
   * <ul>
   *   <li>When {@code null}.</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link JacksonUtil#convertValue(Object, TypeReference)}
   */
  @Test
  @DisplayName("Test convertValue(Object, TypeReference) with 'fromValue', 'toValueTypeRef'; when 'null'; then return 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Object JacksonUtil.convertValue(Object, TypeReference)"})
  void testConvertValueWithFromValueToValueTypeRef_whenNull_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull(JacksonUtil.<Object>convertValue(null, mock(TypeReference.class)));
  }

  /**
   * Test {@link JacksonUtil#convertValue(Object, Class)} with {@code fromValue}, {@code toValueType}.
   * <ul>
   *   <li>Then return intValue is forty-two.</li>
   * </ul>
   * <p>
   * Method under test: {@link JacksonUtil#convertValue(Object, Class)}
   */
  @Test
  @DisplayName("Test convertValue(Object, Class) with 'fromValue', 'toValueType'; then return intValue is forty-two")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Object JacksonUtil.convertValue(Object, Class)"})
  void testConvertValueWithFromValueToValueType_thenReturnIntValueIsFortyTwo() {
    // Arrange
    Class<Object> toValueType = Object.class;

    // Act and Assert
    assertEquals(42, ((Integer) JacksonUtil.convertValue(42, toValueType)).intValue());
  }

  /**
   * Test {@link JacksonUtil#convertValue(Object, Class)} with {@code fromValue}, {@code toValueType}.
   * <ul>
   *   <li>Then return {@code Object}.</li>
   * </ul>
   * <p>
   * Method under test: {@link JacksonUtil#convertValue(Object, Class)}
   */
  @Test
  @DisplayName("Test convertValue(Object, Class) with 'fromValue', 'toValueType'; then return 'java.lang.Object'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Object JacksonUtil.convertValue(Object, Class)"})
  void testConvertValueWithFromValueToValueType_thenReturnJavaLangObject() {
    // Arrange
    Class<Object> forNameResult = Object.class;
    Class<Object> toValueType = Object.class;

    // Act and Assert
    assertEquals("java.lang.Object", JacksonUtil.convertValue(forNameResult, toValueType));
  }

  /**
   * Test {@link JacksonUtil#convertValue(Object, Class)} with {@code fromValue}, {@code toValueType}.
   * <ul>
   *   <li>When empty string.</li>
   * </ul>
   * <p>
   * Method under test: {@link JacksonUtil#convertValue(Object, Class)}
   */
  @Test
  @DisplayName("Test convertValue(Object, Class) with 'fromValue', 'toValueType'; when empty string")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Object JacksonUtil.convertValue(Object, Class)"})
  void testConvertValueWithFromValueToValueType_whenEmptyString() {
    // Arrange
    Class<Builder> toValueType = Builder.class;

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> JacksonUtil.convertValue("", toValueType));
  }

  /**
   * Test {@link JacksonUtil#convertValue(Object, Class)} with {@code fromValue}, {@code toValueType}.
   * <ul>
   *   <li>When forty-two.</li>
   * </ul>
   * <p>
   * Method under test: {@link JacksonUtil#convertValue(Object, Class)}
   */
  @Test
  @DisplayName("Test convertValue(Object, Class) with 'fromValue', 'toValueType'; when forty-two")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Object JacksonUtil.convertValue(Object, Class)"})
  void testConvertValueWithFromValueToValueType_whenFortyTwo() {
    // Arrange
    Class<Builder> toValueType = Builder.class;

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> JacksonUtil.convertValue(42, toValueType));
  }

  /**
   * Test {@link JacksonUtil#convertValue(Object, Class)} with {@code fromValue}, {@code toValueType}.
   * <ul>
   *   <li>When {@code From Value}.</li>
   *   <li>Then return {@code From Value}.</li>
   * </ul>
   * <p>
   * Method under test: {@link JacksonUtil#convertValue(Object, Class)}
   */
  @Test
  @DisplayName("Test convertValue(Object, Class) with 'fromValue', 'toValueType'; when 'From Value'; then return 'From Value'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Object JacksonUtil.convertValue(Object, Class)"})
  void testConvertValueWithFromValueToValueType_whenFromValue_thenReturnFromValue() {
    // Arrange
    Class<Object> toValueType = Object.class;

    // Act and Assert
    assertEquals("From Value", JacksonUtil.convertValue("From Value", toValueType));
  }

  /**
   * Test {@link JacksonUtil#convertValue(Object, Class)} with {@code fromValue}, {@code toValueType}.
   * <ul>
   *   <li>When {@code String}.</li>
   *   <li>Then return {@code 42}.</li>
   * </ul>
   * <p>
   * Method under test: {@link JacksonUtil#convertValue(Object, Class)}
   */
  @Test
  @DisplayName("Test convertValue(Object, Class) with 'fromValue', 'toValueType'; when 'java.lang.String'; then return '42'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Object JacksonUtil.convertValue(Object, Class)"})
  void testConvertValueWithFromValueToValueType_whenJavaLangString_thenReturn42() {
    // Arrange
    Class<String> toValueType = String.class;

    // Act and Assert
    assertEquals("42", JacksonUtil.convertValue(42, toValueType));
  }

  /**
   * Test {@link JacksonUtil#convertValue(Object, Class)} with {@code fromValue}, {@code toValueType}.
   * <ul>
   *   <li>When {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link JacksonUtil#convertValue(Object, Class)}
   */
  @Test
  @DisplayName("Test convertValue(Object, Class) with 'fromValue', 'toValueType'; when 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Object JacksonUtil.convertValue(Object, Class)"})
  void testConvertValueWithFromValueToValueType_whenNull() {
    // Arrange, Act and Assert
    assertThrows(IllegalArgumentException.class, () -> JacksonUtil.convertValue("From Value", (Class<Object>) null));
  }

  /**
   * Test {@link JacksonUtil#convertValue(Object, Class)} with {@code fromValue}, {@code toValueType}.
   * <ul>
   *   <li>When {@code null}.</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link JacksonUtil#convertValue(Object, Class)}
   */
  @Test
  @DisplayName("Test convertValue(Object, Class) with 'fromValue', 'toValueType'; when 'null'; then return 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Object JacksonUtil.convertValue(Object, Class)"})
  void testConvertValueWithFromValueToValueType_whenNull_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull(JacksonUtil.convertValue(null, (Class<Object>) null));
  }

  /**
   * Test {@link JacksonUtil#convertValue(Object, Class)} with {@code fromValue}, {@code toValueType}.
   * <ul>
   *   <li>When one.</li>
   *   <li>Then return intValue is one.</li>
   * </ul>
   * <p>
   * Method under test: {@link JacksonUtil#convertValue(Object, Class)}
   */
  @Test
  @DisplayName("Test convertValue(Object, Class) with 'fromValue', 'toValueType'; when one; then return intValue is one")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Object JacksonUtil.convertValue(Object, Class)"})
  void testConvertValueWithFromValueToValueType_whenOne_thenReturnIntValueIsOne() {
    // Arrange
    Class<Object> toValueType = Object.class;

    // Act and Assert
    assertEquals(1, ((Integer) JacksonUtil.convertValue(1, toValueType)).intValue());
  }

  /**
   * Test {@link JacksonUtil#convertValue(Object, Class)} with {@code fromValue}, {@code toValueType}.
   * <ul>
   *   <li>When {@code JacksonUtil}.</li>
   * </ul>
   * <p>
   * Method under test: {@link JacksonUtil#convertValue(Object, Class)}
   */
  @Test
  @DisplayName("Test convertValue(Object, Class) with 'fromValue', 'toValueType'; when 'org.thingsboard.common.util.JacksonUtil'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Object JacksonUtil.convertValue(Object, Class)"})
  void testConvertValueWithFromValueToValueType_whenOrgThingsboardCommonUtilJacksonUtil() {
    // Arrange
    Class<JacksonUtil> toValueType = JacksonUtil.class;

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> JacksonUtil.convertValue("From Value", toValueType));
  }

  /**
   * Test {@link JacksonUtil#fromString(String, Class)} with {@code string}, {@code clazz}.
   * <p>
   * Method under test: {@link JacksonUtil#fromString(String, Class)}
   */
  @Test
  @DisplayName("Test fromString(String, Class) with 'string', 'clazz'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Object JacksonUtil.fromString(String, Class)"})
  void testFromStringWithStringClazz() {
    // Arrange
    Class<Builder> clazz = Builder.class;

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> JacksonUtil.fromString("String", clazz));
  }

  /**
   * Test {@link JacksonUtil#fromString(String, Class)} with {@code string}, {@code clazz}.
   * <p>
   * Method under test: {@link JacksonUtil#fromString(String, Class)}
   */
  @Test
  @DisplayName("Test fromString(String, Class) with 'string', 'clazz'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Object JacksonUtil.fromString(String, Class)"})
  void testFromStringWithStringClazz2() {
    // Arrange
    Class<Builder> clazz = Builder.class;

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> JacksonUtil.fromString("42", clazz));
  }

  /**
   * Test {@link JacksonUtil#fromString(String, Class, boolean)} with {@code string}, {@code clazz}, {@code ignoreUnknownFields}.
   * <p>
   * Method under test: {@link JacksonUtil#fromString(String, Class, boolean)}
   */
  @Test
  @DisplayName("Test fromString(String, Class, boolean) with 'string', 'clazz', 'ignoreUnknownFields'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Object JacksonUtil.fromString(String, Class, boolean)"})
  void testFromStringWithStringClazzIgnoreUnknownFields() {
    // Arrange
    Class<Builder> clazz = Builder.class;

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> JacksonUtil.fromString("42", clazz, true));
  }

  /**
   * Test {@link JacksonUtil#fromString(String, Class, boolean)} with {@code string}, {@code clazz}, {@code ignoreUnknownFields}.
   * <p>
   * Method under test: {@link JacksonUtil#fromString(String, Class, boolean)}
   */
  @Test
  @DisplayName("Test fromString(String, Class, boolean) with 'string', 'clazz', 'ignoreUnknownFields'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Object JacksonUtil.fromString(String, Class, boolean)"})
  void testFromStringWithStringClazzIgnoreUnknownFields2() {
    // Arrange
    Class<JacksonUtil> clazz = JacksonUtil.class;

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> JacksonUtil.fromString("\"", clazz, true));
  }

  /**
   * Test {@link JacksonUtil#fromString(String, Class, boolean)} with {@code string}, {@code clazz}, {@code ignoreUnknownFields}.
   * <p>
   * Method under test: {@link JacksonUtil#fromString(String, Class, boolean)}
   */
  @Test
  @DisplayName("Test fromString(String, Class, boolean) with 'string', 'clazz', 'ignoreUnknownFields'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Object JacksonUtil.fromString(String, Class, boolean)"})
  void testFromStringWithStringClazzIgnoreUnknownFields3() {
    // Arrange
    Class<JacksonUtil> clazz = JacksonUtil.class;

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> JacksonUtil.fromString("42", clazz, true));
  }

  /**
   * Test {@link JacksonUtil#fromString(String, Class, boolean)} with {@code string}, {@code clazz}, {@code ignoreUnknownFields}.
   * <ul>
   *   <li>Then return intValue is forty-two.</li>
   * </ul>
   * <p>
   * Method under test: {@link JacksonUtil#fromString(String, Class, boolean)}
   */
  @Test
  @DisplayName("Test fromString(String, Class, boolean) with 'string', 'clazz', 'ignoreUnknownFields'; then return intValue is forty-two")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Object JacksonUtil.fromString(String, Class, boolean)"})
  void testFromStringWithStringClazzIgnoreUnknownFields_thenReturnIntValueIsFortyTwo() {
    // Arrange
    Class<Object> clazz = Object.class;

    // Act and Assert
    assertEquals(42, ((Integer) JacksonUtil.fromString("42", clazz, true)).intValue());
  }

  /**
   * Test {@link JacksonUtil#fromString(String, Class, boolean)} with {@code string}, {@code clazz}, {@code ignoreUnknownFields}.
   * <ul>
   *   <li>When empty string.</li>
   * </ul>
   * <p>
   * Method under test: {@link JacksonUtil#fromString(String, Class, boolean)}
   */
  @Test
  @DisplayName("Test fromString(String, Class, boolean) with 'string', 'clazz', 'ignoreUnknownFields'; when empty string")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Object JacksonUtil.fromString(String, Class, boolean)"})
  void testFromStringWithStringClazzIgnoreUnknownFields_whenEmptyString() {
    // Arrange
    Class<Object> clazz = Object.class;

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> JacksonUtil.fromString("", clazz, true));
  }

  /**
   * Test {@link JacksonUtil#fromString(String, Class, boolean)} with {@code string}, {@code clazz}, {@code ignoreUnknownFields}.
   * <ul>
   *   <li>When {@code String}.</li>
   *   <li>Then return {@code 42}.</li>
   * </ul>
   * <p>
   * Method under test: {@link JacksonUtil#fromString(String, Class, boolean)}
   */
  @Test
  @DisplayName("Test fromString(String, Class, boolean) with 'string', 'clazz', 'ignoreUnknownFields'; when 'java.lang.String'; then return '42'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Object JacksonUtil.fromString(String, Class, boolean)"})
  void testFromStringWithStringClazzIgnoreUnknownFields_whenJavaLangString_thenReturn42() {
    // Arrange
    Class<String> clazz = String.class;

    // Act and Assert
    assertEquals("42", JacksonUtil.fromString("42", clazz, true));
  }

  /**
   * Test {@link JacksonUtil#fromString(String, Class, boolean)} with {@code string}, {@code clazz}, {@code ignoreUnknownFields}.
   * <ul>
   *   <li>When {@code null}.</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link JacksonUtil#fromString(String, Class, boolean)}
   */
  @Test
  @DisplayName("Test fromString(String, Class, boolean) with 'string', 'clazz', 'ignoreUnknownFields'; when 'null'; then return 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Object JacksonUtil.fromString(String, Class, boolean)"})
  void testFromStringWithStringClazzIgnoreUnknownFields_whenNull_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull(JacksonUtil.fromString(null, null, true));
  }

  /**
   * Test {@link JacksonUtil#fromString(String, Class, boolean)} with {@code string}, {@code clazz}, {@code ignoreUnknownFields}.
   * <ul>
   *   <li>When {@code "}.</li>
   * </ul>
   * <p>
   * Method under test: {@link JacksonUtil#fromString(String, Class, boolean)}
   */
  @Test
  @DisplayName("Test fromString(String, Class, boolean) with 'string', 'clazz', 'ignoreUnknownFields'; when '\"'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Object JacksonUtil.fromString(String, Class, boolean)"})
  void testFromStringWithStringClazzIgnoreUnknownFields_whenQuotationMark() {
    // Arrange
    Class<Object> clazz = Object.class;

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> JacksonUtil.fromString("\"", clazz, true));
  }

  /**
   * Test {@link JacksonUtil#fromString(String, Class, boolean)} with {@code string}, {@code clazz}, {@code ignoreUnknownFields}.
   * <ul>
   *   <li>When {@code "}.</li>
   * </ul>
   * <p>
   * Method under test: {@link JacksonUtil#fromString(String, Class, boolean)}
   */
  @Test
  @DisplayName("Test fromString(String, Class, boolean) with 'string', 'clazz', 'ignoreUnknownFields'; when '\"'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Object JacksonUtil.fromString(String, Class, boolean)"})
  void testFromStringWithStringClazzIgnoreUnknownFields_whenQuotationMark2() {
    // Arrange
    Class<Builder> clazz = Builder.class;

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> JacksonUtil.fromString("\"", clazz, true));
  }

  /**
   * Test {@link JacksonUtil#fromString(String, Class, boolean)} with {@code string}, {@code clazz}, {@code ignoreUnknownFields}.
   * <ul>
   *   <li>When {@code String}.</li>
   * </ul>
   * <p>
   * Method under test: {@link JacksonUtil#fromString(String, Class, boolean)}
   */
  @Test
  @DisplayName("Test fromString(String, Class, boolean) with 'string', 'clazz', 'ignoreUnknownFields'; when 'String'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Object JacksonUtil.fromString(String, Class, boolean)"})
  void testFromStringWithStringClazzIgnoreUnknownFields_whenString() {
    // Arrange
    Class<Object> clazz = Object.class;

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> JacksonUtil.fromString("String", clazz, true));
  }

  /**
   * Test {@link JacksonUtil#fromString(String, Class, boolean)} with {@code string}, {@code clazz}, {@code ignoreUnknownFields}.
   * <ul>
   *   <li>When {@code String}.</li>
   * </ul>
   * <p>
   * Method under test: {@link JacksonUtil#fromString(String, Class, boolean)}
   */
  @Test
  @DisplayName("Test fromString(String, Class, boolean) with 'string', 'clazz', 'ignoreUnknownFields'; when 'String'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Object JacksonUtil.fromString(String, Class, boolean)"})
  void testFromStringWithStringClazzIgnoreUnknownFields_whenString2() {
    // Arrange
    Class<Builder> clazz = Builder.class;

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> JacksonUtil.fromString("String", clazz, true));
  }

  /**
   * Test {@link JacksonUtil#fromString(String, Class)} with {@code string}, {@code clazz}.
   * <ul>
   *   <li>When {@code 42}.</li>
   *   <li>Then return intValue is forty-two.</li>
   * </ul>
   * <p>
   * Method under test: {@link JacksonUtil#fromString(String, Class)}
   */
  @Test
  @DisplayName("Test fromString(String, Class) with 'string', 'clazz'; when '42'; then return intValue is forty-two")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Object JacksonUtil.fromString(String, Class)"})
  void testFromStringWithStringClazz_when42_thenReturnIntValueIsFortyTwo() {
    // Arrange
    Class<Object> clazz = Object.class;

    // Act and Assert
    assertEquals(42, ((Integer) JacksonUtil.fromString("42", clazz)).intValue());
  }

  /**
   * Test {@link JacksonUtil#fromString(String, Class)} with {@code string}, {@code clazz}.
   * <ul>
   *   <li>When empty string.</li>
   *   <li>Then throw {@link IllegalArgumentException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link JacksonUtil#fromString(String, Class)}
   */
  @Test
  @DisplayName("Test fromString(String, Class) with 'string', 'clazz'; when empty string; then throw IllegalArgumentException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Object JacksonUtil.fromString(String, Class)"})
  void testFromStringWithStringClazz_whenEmptyString_thenThrowIllegalArgumentException() {
    // Arrange
    Class<Object> clazz = Object.class;

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> JacksonUtil.fromString("", clazz));
  }

  /**
   * Test {@link JacksonUtil#fromString(String, Class)} with {@code string}, {@code clazz}.
   * <ul>
   *   <li>When {@code String}.</li>
   * </ul>
   * <p>
   * Method under test: {@link JacksonUtil#fromString(String, Class)}
   */
  @Test
  @DisplayName("Test fromString(String, Class) with 'string', 'clazz'; when 'java.lang.String'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Object JacksonUtil.fromString(String, Class)"})
  void testFromStringWithStringClazz_whenJavaLangString() {
    // Arrange
    Class<String> clazz = String.class;

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> JacksonUtil.fromString("String", clazz));
  }

  /**
   * Test {@link JacksonUtil#fromString(String, Class)} with {@code string}, {@code clazz}.
   * <ul>
   *   <li>When {@code String}.</li>
   *   <li>Then return {@code 42}.</li>
   * </ul>
   * <p>
   * Method under test: {@link JacksonUtil#fromString(String, Class)}
   */
  @Test
  @DisplayName("Test fromString(String, Class) with 'string', 'clazz'; when 'java.lang.String'; then return '42'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Object JacksonUtil.fromString(String, Class)"})
  void testFromStringWithStringClazz_whenJavaLangString_thenReturn42() {
    // Arrange
    Class<String> clazz = String.class;

    // Act and Assert
    assertEquals("42", JacksonUtil.fromString("42", clazz));
  }

  /**
   * Test {@link JacksonUtil#fromString(String, Class)} with {@code string}, {@code clazz}.
   * <ul>
   *   <li>When {@code null}.</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link JacksonUtil#fromString(String, Class)}
   */
  @Test
  @DisplayName("Test fromString(String, Class) with 'string', 'clazz'; when 'null'; then return 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Object JacksonUtil.fromString(String, Class)"})
  void testFromStringWithStringClazz_whenNull_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull(JacksonUtil.fromString(null, (Class<Object>) null));
  }

  /**
   * Test {@link JacksonUtil#fromString(String, Class)} with {@code string}, {@code clazz}.
   * <ul>
   *   <li>When {@code JacksonUtil}.</li>
   * </ul>
   * <p>
   * Method under test: {@link JacksonUtil#fromString(String, Class)}
   */
  @Test
  @DisplayName("Test fromString(String, Class) with 'string', 'clazz'; when 'org.thingsboard.common.util.JacksonUtil'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Object JacksonUtil.fromString(String, Class)"})
  void testFromStringWithStringClazz_whenOrgThingsboardCommonUtilJacksonUtil() {
    // Arrange
    Class<JacksonUtil> clazz = JacksonUtil.class;

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> JacksonUtil.fromString("42", clazz));
  }

  /**
   * Test {@link JacksonUtil#fromString(String, Class)} with {@code string}, {@code clazz}.
   * <ul>
   *   <li>When {@code "}.</li>
   * </ul>
   * <p>
   * Method under test: {@link JacksonUtil#fromString(String, Class)}
   */
  @Test
  @DisplayName("Test fromString(String, Class) with 'string', 'clazz'; when '\"'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Object JacksonUtil.fromString(String, Class)"})
  void testFromStringWithStringClazz_whenQuotationMark() {
    // Arrange
    Class<Object> clazz = Object.class;

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> JacksonUtil.fromString("\"", clazz));
  }

  /**
   * Test {@link JacksonUtil#fromString(String, Class)} with {@code string}, {@code clazz}.
   * <ul>
   *   <li>When {@code "}.</li>
   * </ul>
   * <p>
   * Method under test: {@link JacksonUtil#fromString(String, Class)}
   */
  @Test
  @DisplayName("Test fromString(String, Class) with 'string', 'clazz'; when '\"'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Object JacksonUtil.fromString(String, Class)"})
  void testFromStringWithStringClazz_whenQuotationMark2() {
    // Arrange
    Class<Builder> clazz = Builder.class;

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> JacksonUtil.fromString("\"", clazz));
  }

  /**
   * Test {@link JacksonUtil#fromString(String, Class)} with {@code string}, {@code clazz}.
   * <ul>
   *   <li>When {@code String}.</li>
   *   <li>Then throw {@link IllegalArgumentException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link JacksonUtil#fromString(String, Class)}
   */
  @Test
  @DisplayName("Test fromString(String, Class) with 'string', 'clazz'; when 'String'; then throw IllegalArgumentException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Object JacksonUtil.fromString(String, Class)"})
  void testFromStringWithStringClazz_whenString_thenThrowIllegalArgumentException() {
    // Arrange
    Class<Object> clazz = Object.class;

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> JacksonUtil.fromString("String", clazz));
  }

  /**
   * Test {@link JacksonUtil#fromString(String, JavaType)} with {@code string}, {@code javaType}.
   * <p>
   * Method under test: {@link JacksonUtil#fromString(String, JavaType)}
   */
  @Test
  @DisplayName("Test fromString(String, JavaType) with 'string', 'javaType'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Object JacksonUtil.fromString(String, JavaType)"})
  void testFromStringWithStringJavaType() {
    // Arrange
    CollectionLikeType javaType = mock(CollectionLikeType.class);
    when(javaType.isEnumType()).thenReturn(true);
    when(javaType.getKeyType()).thenReturn(new PlaceholderForType(1));
    when(javaType.getContentType()).thenReturn(new PlaceholderForType(1));
    when(javaType.isAbstract()).thenReturn(true);
    when(javaType.isMapLikeType()).thenReturn(true);
    when(javaType.isContainerType()).thenReturn(true);
    Class<Object> forNameResult = Object.class;
    Mockito.<Class<?>>when(javaType.getRawClass()).thenReturn(forNameResult);

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> JacksonUtil.fromString("\"", javaType));
    verify(javaType, atLeast(1)).getKeyType();
    verify(javaType, atLeast(1)).getRawClass();
    verify(javaType).isAbstract();
    verify(javaType).isEnumType();
    verify(javaType, atLeast(1)).isMapLikeType();
    verify(javaType, atLeast(1)).getContentType();
    verify(javaType, atLeast(1)).isContainerType();
  }

  /**
   * Test {@link JacksonUtil#fromString(String, JavaType)} with {@code string}, {@code javaType}.
   * <p>
   * Method under test: {@link JacksonUtil#fromString(String, JavaType)}
   */
  @Test
  @DisplayName("Test fromString(String, JavaType) with 'string', 'javaType'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Object JacksonUtil.fromString(String, JavaType)"})
  void testFromStringWithStringJavaType2() {
    // Arrange
    CollectionLikeType collectionLikeType = mock(CollectionLikeType.class);
    when(collectionLikeType.getValueHandler()).thenReturn("Value Handler");
    CollectionLikeType javaType = mock(CollectionLikeType.class);
    when(javaType.getSuperClass()).thenReturn(new PlaceholderForType(1));
    when(javaType.getBindings()).thenReturn(TypeBindings.emptyBindings());
    when(javaType.hasRawClass(Mockito.<Class<Object>>any())).thenReturn(true);
    when(javaType.isConcrete()).thenReturn(true);
    when(javaType.isRecordType()).thenReturn(true);
    when(javaType.isArrayType()).thenReturn(false);
    when(javaType.isEnumType()).thenReturn(true);
    when(javaType.getKeyType()).thenReturn(new PlaceholderForType(1));
    when(javaType.getContentType()).thenReturn(collectionLikeType);
    when(javaType.isAbstract()).thenReturn(true);
    when(javaType.isMapLikeType()).thenReturn(true);
    when(javaType.isContainerType()).thenReturn(true);
    Class<Builder> forNameResult = Builder.class;
    Mockito.<Class<?>>when(javaType.getRawClass()).thenReturn(forNameResult);

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> JacksonUtil.fromString("\"", javaType));
    verify(javaType, atLeast(1)).getKeyType();
    verify(javaType, atLeast(1)).getRawClass();
    verify(collectionLikeType, atLeast(1)).getValueHandler();
    verify(javaType).hasRawClass(isA(Class.class));
    verify(javaType).isAbstract();
    verify(javaType, atLeast(1)).isArrayType();
    verify(javaType).isConcrete();
    verify(javaType, atLeast(1)).isEnumType();
    verify(javaType, atLeast(1)).isMapLikeType();
    verify(javaType, atLeast(1)).isRecordType();
    verify(javaType, atLeast(1)).getContentType();
    verify(javaType, atLeast(1)).isContainerType();
    verify(javaType).getBindings();
    verify(javaType).getSuperClass();
  }

  /**
   * Test {@link JacksonUtil#fromString(String, JavaType)} with {@code string}, {@code javaType}.
   * <p>
   * Method under test: {@link JacksonUtil#fromString(String, JavaType)}
   */
  @Test
  @DisplayName("Test fromString(String, JavaType) with 'string', 'javaType'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Object JacksonUtil.fromString(String, JavaType)"})
  void testFromStringWithStringJavaType3() {
    // Arrange
    CollectionLikeType collectionLikeType = mock(CollectionLikeType.class);
    when(collectionLikeType.getValueHandler()).thenReturn("Value Handler");
    CollectionLikeType javaType = mock(CollectionLikeType.class);
    Class<Object> erasedType = Object.class;
    when(javaType.getSuperClass()).thenReturn(new ResolvedRecursiveType(erasedType, TypeBindings.emptyBindings()));
    when(javaType.getBindings()).thenReturn(TypeBindings.emptyBindings());
    when(javaType.hasRawClass(Mockito.<Class<Object>>any())).thenReturn(true);
    when(javaType.isConcrete()).thenReturn(true);
    when(javaType.isRecordType()).thenReturn(true);
    when(javaType.isArrayType()).thenReturn(false);
    when(javaType.isEnumType()).thenReturn(true);
    when(javaType.getKeyType()).thenReturn(new PlaceholderForType(1));
    when(javaType.getContentType()).thenReturn(collectionLikeType);
    when(javaType.isAbstract()).thenReturn(true);
    when(javaType.isMapLikeType()).thenReturn(true);
    when(javaType.isContainerType()).thenReturn(true);
    Class<Builder> forNameResult = Builder.class;
    Mockito.<Class<?>>when(javaType.getRawClass()).thenReturn(forNameResult);

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> JacksonUtil.fromString("\"", javaType));
    verify(javaType, atLeast(1)).getKeyType();
    verify(javaType, atLeast(1)).getRawClass();
    verify(collectionLikeType, atLeast(1)).getValueHandler();
    verify(javaType).hasRawClass(isA(Class.class));
    verify(javaType).isAbstract();
    verify(javaType, atLeast(1)).isArrayType();
    verify(javaType).isConcrete();
    verify(javaType, atLeast(1)).isEnumType();
    verify(javaType, atLeast(1)).isMapLikeType();
    verify(javaType, atLeast(1)).isRecordType();
    verify(javaType, atLeast(1)).getContentType();
    verify(javaType, atLeast(1)).isContainerType();
    verify(javaType).getBindings();
    verify(javaType).getSuperClass();
  }

  /**
   * Test {@link JacksonUtil#fromString(String, JavaType)} with {@code string}, {@code javaType}.
   * <ul>
   *   <li>Given {@link Object}.</li>
   * </ul>
   * <p>
   * Method under test: {@link JacksonUtil#fromString(String, JavaType)}
   */
  @Test
  @DisplayName("Test fromString(String, JavaType) with 'string', 'javaType'; given Object")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Object JacksonUtil.fromString(String, JavaType)"})
  void testFromStringWithStringJavaType_givenObject() {
    // Arrange
    CollectionLikeType collectionLikeType = mock(CollectionLikeType.class);
    when(collectionLikeType.getValueHandler()).thenReturn("Value Handler");
    CollectionLikeType javaType = mock(CollectionLikeType.class);
    when(javaType.isEnumType()).thenReturn(true);
    when(javaType.getKeyType()).thenReturn(new PlaceholderForType(1));
    when(javaType.getContentType()).thenReturn(collectionLikeType);
    when(javaType.isAbstract()).thenReturn(true);
    when(javaType.isMapLikeType()).thenReturn(true);
    when(javaType.isContainerType()).thenReturn(true);
    Class<Object> forNameResult = Object.class;
    Mockito.<Class<?>>when(javaType.getRawClass()).thenReturn(forNameResult);

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> JacksonUtil.fromString("\"", javaType));
    verify(javaType, atLeast(1)).getKeyType();
    verify(javaType, atLeast(1)).getRawClass();
    verify(collectionLikeType, atLeast(1)).getValueHandler();
    verify(javaType).isAbstract();
    verify(javaType).isEnumType();
    verify(javaType, atLeast(1)).isMapLikeType();
    verify(javaType, atLeast(1)).getContentType();
    verify(javaType, atLeast(1)).isContainerType();
  }

  /**
   * Test {@link JacksonUtil#fromString(String, JavaType)} with {@code string}, {@code javaType}.
   * <ul>
   *   <li>Given {@link Object}.</li>
   *   <li>When empty string.</li>
   * </ul>
   * <p>
   * Method under test: {@link JacksonUtil#fromString(String, JavaType)}
   */
  @Test
  @DisplayName("Test fromString(String, JavaType) with 'string', 'javaType'; given Object; when empty string")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Object JacksonUtil.fromString(String, JavaType)"})
  void testFromStringWithStringJavaType_givenObject_whenEmptyString() {
    // Arrange
    CollectionLikeType javaType = mock(CollectionLikeType.class);
    Class<Object> forNameResult = Object.class;
    Mockito.<Class<?>>when(javaType.getRawClass()).thenReturn(forNameResult);

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> JacksonUtil.fromString("", javaType));
    verify(javaType).getRawClass();
  }

  /**
   * Test {@link JacksonUtil#fromString(String, JavaType)} with {@code string}, {@code javaType}.
   * <ul>
   *   <li>Given {@code JacksonUtil}.</li>
   * </ul>
   * <p>
   * Method under test: {@link JacksonUtil#fromString(String, JavaType)}
   */
  @Test
  @DisplayName("Test fromString(String, JavaType) with 'string', 'javaType'; given 'org.thingsboard.common.util.JacksonUtil'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Object JacksonUtil.fromString(String, JavaType)"})
  void testFromStringWithStringJavaType_givenOrgThingsboardCommonUtilJacksonUtil() {
    // Arrange
    CollectionLikeType collectionLikeType = mock(CollectionLikeType.class);
    when(collectionLikeType.getValueHandler()).thenReturn("Value Handler");
    CollectionLikeType javaType = mock(CollectionLikeType.class);
    when(javaType.getSuperClass()).thenReturn(new PlaceholderForType(1));
    when(javaType.getBindings()).thenReturn(TypeBindings.emptyBindings());
    when(javaType.hasRawClass(Mockito.<Class<Object>>any())).thenReturn(true);
    when(javaType.isConcrete()).thenReturn(true);
    when(javaType.isRecordType()).thenReturn(true);
    when(javaType.isArrayType()).thenReturn(false);
    when(javaType.isEnumType()).thenReturn(true);
    when(javaType.getKeyType()).thenReturn(new PlaceholderForType(1));
    when(javaType.getContentType()).thenReturn(collectionLikeType);
    when(javaType.isAbstract()).thenReturn(true);
    when(javaType.isMapLikeType()).thenReturn(true);
    when(javaType.isContainerType()).thenReturn(true);
    Class<JacksonUtil> forNameResult = JacksonUtil.class;
    Mockito.<Class<?>>when(javaType.getRawClass()).thenReturn(forNameResult);

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> JacksonUtil.fromString("\"", javaType));
    verify(javaType, atLeast(1)).getKeyType();
    verify(javaType, atLeast(1)).getRawClass();
    verify(collectionLikeType, atLeast(1)).getValueHandler();
    verify(javaType).hasRawClass(isA(Class.class));
    verify(javaType).isAbstract();
    verify(javaType, atLeast(1)).isArrayType();
    verify(javaType).isConcrete();
    verify(javaType, atLeast(1)).isEnumType();
    verify(javaType, atLeast(1)).isMapLikeType();
    verify(javaType, atLeast(1)).isRecordType();
    verify(javaType, atLeast(1)).getContentType();
    verify(javaType, atLeast(1)).isContainerType();
    verify(javaType, atLeast(1)).getBindings();
    verify(javaType).getSuperClass();
  }

  /**
   * Test {@link JacksonUtil#fromString(String, JavaType)} with {@code string}, {@code javaType}.
   * <ul>
   *   <li>When {@code 42}.</li>
   *   <li>Then return intValue is forty-two.</li>
   * </ul>
   * <p>
   * Method under test: {@link JacksonUtil#fromString(String, JavaType)}
   */
  @Test
  @DisplayName("Test fromString(String, JavaType) with 'string', 'javaType'; when '42'; then return intValue is forty-two")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Object JacksonUtil.fromString(String, JavaType)"})
  void testFromStringWithStringJavaType_when42_thenReturnIntValueIsFortyTwo() {
    // Arrange, Act and Assert
    assertEquals(42, ((Integer) JacksonUtil.fromString("42", new PlaceholderForType(1))).intValue());
  }

  /**
   * Test {@link JacksonUtil#fromString(String, JavaType)} with {@code string}, {@code javaType}.
   * <ul>
   *   <li>When {@link CollectionLikeType} {@link JavaType#isArrayType()} return {@code true}.</li>
   * </ul>
   * <p>
   * Method under test: {@link JacksonUtil#fromString(String, JavaType)}
   */
  @Test
  @DisplayName("Test fromString(String, JavaType) with 'string', 'javaType'; when CollectionLikeType isArrayType() return 'true'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Object JacksonUtil.fromString(String, JavaType)"})
  void testFromStringWithStringJavaType_whenCollectionLikeTypeIsArrayTypeReturnTrue() {
    // Arrange
    CollectionLikeType collectionLikeType = mock(CollectionLikeType.class);
    when(collectionLikeType.getValueHandler()).thenReturn("Value Handler");
    CollectionLikeType javaType = mock(CollectionLikeType.class);
    when(javaType.isConcrete()).thenReturn(true);
    when(javaType.isRecordType()).thenReturn(true);
    when(javaType.isArrayType()).thenReturn(true);
    when(javaType.isEnumType()).thenReturn(true);
    when(javaType.getKeyType()).thenReturn(new PlaceholderForType(1));
    when(javaType.getContentType()).thenReturn(collectionLikeType);
    when(javaType.isAbstract()).thenReturn(true);
    when(javaType.isMapLikeType()).thenReturn(true);
    when(javaType.isContainerType()).thenReturn(true);
    Class<Builder> forNameResult = Builder.class;
    Mockito.<Class<?>>when(javaType.getRawClass()).thenReturn(forNameResult);

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> JacksonUtil.fromString("\"", javaType));
    verify(javaType, atLeast(1)).getKeyType();
    verify(javaType, atLeast(1)).getRawClass();
    verify(collectionLikeType, atLeast(1)).getValueHandler();
    verify(javaType).isAbstract();
    verify(javaType, atLeast(1)).isArrayType();
    verify(javaType).isConcrete();
    verify(javaType).isEnumType();
    verify(javaType, atLeast(1)).isMapLikeType();
    verify(javaType, atLeast(1)).isRecordType();
    verify(javaType, atLeast(1)).getContentType();
    verify(javaType, atLeast(1)).isContainerType();
  }

  /**
   * Test {@link JacksonUtil#fromString(String, JavaType)} with {@code string}, {@code javaType}.
   * <ul>
   *   <li>When empty string.</li>
   * </ul>
   * <p>
   * Method under test: {@link JacksonUtil#fromString(String, JavaType)}
   */
  @Test
  @DisplayName("Test fromString(String, JavaType) with 'string', 'javaType'; when empty string")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Object JacksonUtil.fromString(String, JavaType)"})
  void testFromStringWithStringJavaType_whenEmptyString() {
    // Arrange, Act and Assert
    assertThrows(IllegalArgumentException.class, () -> JacksonUtil.fromString("", new PlaceholderForType(1)));
  }

  /**
   * Test {@link JacksonUtil#fromString(String, JavaType)} with {@code string}, {@code javaType}.
   * <ul>
   *   <li>When {@code null}.</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link JacksonUtil#fromString(String, JavaType)}
   */
  @Test
  @DisplayName("Test fromString(String, JavaType) with 'string', 'javaType'; when 'null'; then return 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Object JacksonUtil.fromString(String, JavaType)"})
  void testFromStringWithStringJavaType_whenNull_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull(JacksonUtil.fromString(null, new PlaceholderForType(1)));
  }

  /**
   * Test {@link JacksonUtil#fromString(String, JavaType)} with {@code string}, {@code javaType}.
   * <ul>
   *   <li>When {@link PlaceholderForType#PlaceholderForType(int)} with ordinal is one.</li>
   * </ul>
   * <p>
   * Method under test: {@link JacksonUtil#fromString(String, JavaType)}
   */
  @Test
  @DisplayName("Test fromString(String, JavaType) with 'string', 'javaType'; when PlaceholderForType(int) with ordinal is one")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Object JacksonUtil.fromString(String, JavaType)"})
  void testFromStringWithStringJavaType_whenPlaceholderForTypeWithOrdinalIsOne() {
    // Arrange, Act and Assert
    assertThrows(IllegalArgumentException.class, () -> JacksonUtil.fromString("\"", new PlaceholderForType(1)));
  }

  /**
   * Test {@link JacksonUtil#fromString(String, JavaType)} with {@code string}, {@code javaType}.
   * <ul>
   *   <li>When {@code String}.</li>
   *   <li>Then throw {@link IllegalArgumentException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link JacksonUtil#fromString(String, JavaType)}
   */
  @Test
  @DisplayName("Test fromString(String, JavaType) with 'string', 'javaType'; when 'String'; then throw IllegalArgumentException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Object JacksonUtil.fromString(String, JavaType)"})
  void testFromStringWithStringJavaType_whenString_thenThrowIllegalArgumentException() {
    // Arrange, Act and Assert
    assertThrows(IllegalArgumentException.class, () -> JacksonUtil.fromString("String", new PlaceholderForType(1)));
  }

  /**
   * Test {@link JacksonUtil#fromString(String, TypeReference)} with {@code string}, {@code valueTypeRef}.
   * <p>
   * Method under test: {@link JacksonUtil#fromString(String, TypeReference)}
   */
  @Test
  @DisplayName("Test fromString(String, TypeReference) with 'string', 'valueTypeRef'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Object JacksonUtil.fromString(String, TypeReference)"})
  void testFromStringWithStringValueTypeRef() {
    // Arrange
    CollectionLikeType collectionLikeType = mock(CollectionLikeType.class);
    when(collectionLikeType.isEnumType()).thenReturn(true);
    when(collectionLikeType.getKeyType()).thenReturn(new PlaceholderForType(1));
    when(collectionLikeType.getContentType()).thenReturn(new PlaceholderForType(1));
    when(collectionLikeType.isAbstract()).thenReturn(true);
    when(collectionLikeType.isMapLikeType()).thenReturn(true);
    when(collectionLikeType.isContainerType()).thenReturn(true);
    Class<Object> forNameResult = Object.class;
    Mockito.<Class<?>>when(collectionLikeType.getRawClass()).thenReturn(forNameResult);
    TypeReference<Object> valueTypeRef = mock(TypeReference.class);
    when(valueTypeRef.getType()).thenReturn(collectionLikeType);

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> JacksonUtil.fromString("\"", valueTypeRef));
    verify(valueTypeRef).getType();
    verify(collectionLikeType, atLeast(1)).getKeyType();
    verify(collectionLikeType, atLeast(1)).getRawClass();
    verify(collectionLikeType).isAbstract();
    verify(collectionLikeType).isEnumType();
    verify(collectionLikeType, atLeast(1)).isMapLikeType();
    verify(collectionLikeType, atLeast(1)).getContentType();
    verify(collectionLikeType, atLeast(1)).isContainerType();
  }

  /**
   * Test {@link JacksonUtil#fromString(String, TypeReference)} with {@code string}, {@code valueTypeRef}.
   * <p>
   * Method under test: {@link JacksonUtil#fromString(String, TypeReference)}
   */
  @Test
  @DisplayName("Test fromString(String, TypeReference) with 'string', 'valueTypeRef'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Object JacksonUtil.fromString(String, TypeReference)"})
  void testFromStringWithStringValueTypeRef2() {
    // Arrange
    CollectionLikeType collectionLikeType = mock(CollectionLikeType.class);
    when(collectionLikeType.getValueHandler()).thenReturn("Value Handler");
    CollectionLikeType collectionLikeType2 = mock(CollectionLikeType.class);
    when(collectionLikeType2.isEnumType()).thenReturn(true);
    when(collectionLikeType2.getKeyType()).thenReturn(new PlaceholderForType(1));
    when(collectionLikeType2.getContentType()).thenReturn(collectionLikeType);
    when(collectionLikeType2.isAbstract()).thenReturn(true);
    when(collectionLikeType2.isMapLikeType()).thenReturn(true);
    when(collectionLikeType2.isContainerType()).thenReturn(true);
    Class<Object> forNameResult = Object.class;
    Mockito.<Class<?>>when(collectionLikeType2.getRawClass()).thenReturn(forNameResult);
    TypeReference<Object> valueTypeRef = mock(TypeReference.class);
    when(valueTypeRef.getType()).thenReturn(collectionLikeType2);

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> JacksonUtil.fromString("\"", valueTypeRef));
    verify(valueTypeRef).getType();
    verify(collectionLikeType2, atLeast(1)).getKeyType();
    verify(collectionLikeType2, atLeast(1)).getRawClass();
    verify(collectionLikeType, atLeast(1)).getValueHandler();
    verify(collectionLikeType2).isAbstract();
    verify(collectionLikeType2).isEnumType();
    verify(collectionLikeType2, atLeast(1)).isMapLikeType();
    verify(collectionLikeType2, atLeast(1)).getContentType();
    verify(collectionLikeType2, atLeast(1)).isContainerType();
  }

  /**
   * Test {@link JacksonUtil#fromString(String, TypeReference)} with {@code string}, {@code valueTypeRef}.
   * <p>
   * Method under test: {@link JacksonUtil#fromString(String, TypeReference)}
   */
  @Test
  @DisplayName("Test fromString(String, TypeReference) with 'string', 'valueTypeRef'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Object JacksonUtil.fromString(String, TypeReference)"})
  void testFromStringWithStringValueTypeRef3() {
    // Arrange
    CollectionLikeType collectionLikeType = mock(CollectionLikeType.class);
    when(collectionLikeType.getValueHandler()).thenReturn("Value Handler");
    CollectionLikeType collectionLikeType2 = mock(CollectionLikeType.class);
    when(collectionLikeType2.isConcrete()).thenReturn(true);
    when(collectionLikeType2.isRecordType()).thenReturn(true);
    when(collectionLikeType2.isArrayType()).thenReturn(true);
    when(collectionLikeType2.isEnumType()).thenReturn(true);
    when(collectionLikeType2.getKeyType()).thenReturn(new PlaceholderForType(1));
    when(collectionLikeType2.getContentType()).thenReturn(collectionLikeType);
    when(collectionLikeType2.isAbstract()).thenReturn(true);
    when(collectionLikeType2.isMapLikeType()).thenReturn(true);
    when(collectionLikeType2.isContainerType()).thenReturn(true);
    Class<Builder> forNameResult = Builder.class;
    Mockito.<Class<?>>when(collectionLikeType2.getRawClass()).thenReturn(forNameResult);
    TypeReference<Object> valueTypeRef = mock(TypeReference.class);
    when(valueTypeRef.getType()).thenReturn(collectionLikeType2);

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> JacksonUtil.fromString("\"", valueTypeRef));
    verify(valueTypeRef).getType();
    verify(collectionLikeType2, atLeast(1)).getKeyType();
    verify(collectionLikeType2, atLeast(1)).getRawClass();
    verify(collectionLikeType, atLeast(1)).getValueHandler();
    verify(collectionLikeType2).isAbstract();
    verify(collectionLikeType2, atLeast(1)).isArrayType();
    verify(collectionLikeType2).isConcrete();
    verify(collectionLikeType2).isEnumType();
    verify(collectionLikeType2, atLeast(1)).isMapLikeType();
    verify(collectionLikeType2, atLeast(1)).isRecordType();
    verify(collectionLikeType2, atLeast(1)).getContentType();
    verify(collectionLikeType2, atLeast(1)).isContainerType();
  }

  /**
   * Test {@link JacksonUtil#fromString(String, TypeReference)} with {@code string}, {@code valueTypeRef}.
   * <p>
   * Method under test: {@link JacksonUtil#fromString(String, TypeReference)}
   */
  @Test
  @DisplayName("Test fromString(String, TypeReference) with 'string', 'valueTypeRef'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Object JacksonUtil.fromString(String, TypeReference)"})
  void testFromStringWithStringValueTypeRef4() {
    // Arrange
    CollectionLikeType collectionLikeType = mock(CollectionLikeType.class);
    when(collectionLikeType.getValueHandler()).thenReturn("Value Handler");
    CollectionLikeType collectionLikeType2 = mock(CollectionLikeType.class);
    when(collectionLikeType2.getSuperClass()).thenReturn(new PlaceholderForType(1));
    when(collectionLikeType2.getBindings()).thenReturn(TypeBindings.emptyBindings());
    when(collectionLikeType2.hasRawClass(Mockito.<Class<Object>>any())).thenReturn(true);
    when(collectionLikeType2.isConcrete()).thenReturn(true);
    when(collectionLikeType2.isRecordType()).thenReturn(true);
    when(collectionLikeType2.isArrayType()).thenReturn(false);
    when(collectionLikeType2.isEnumType()).thenReturn(true);
    when(collectionLikeType2.getKeyType()).thenReturn(new PlaceholderForType(1));
    when(collectionLikeType2.getContentType()).thenReturn(collectionLikeType);
    when(collectionLikeType2.isAbstract()).thenReturn(true);
    when(collectionLikeType2.isMapLikeType()).thenReturn(true);
    when(collectionLikeType2.isContainerType()).thenReturn(true);
    Class<Builder> forNameResult = Builder.class;
    Mockito.<Class<?>>when(collectionLikeType2.getRawClass()).thenReturn(forNameResult);
    TypeReference<Object> valueTypeRef = mock(TypeReference.class);
    when(valueTypeRef.getType()).thenReturn(collectionLikeType2);

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> JacksonUtil.fromString("\"", valueTypeRef));
    verify(valueTypeRef).getType();
    verify(collectionLikeType2, atLeast(1)).getKeyType();
    verify(collectionLikeType2, atLeast(1)).getRawClass();
    verify(collectionLikeType, atLeast(1)).getValueHandler();
    verify(collectionLikeType2).hasRawClass(isA(Class.class));
    verify(collectionLikeType2).isAbstract();
    verify(collectionLikeType2, atLeast(1)).isArrayType();
    verify(collectionLikeType2).isConcrete();
    verify(collectionLikeType2, atLeast(1)).isEnumType();
    verify(collectionLikeType2, atLeast(1)).isMapLikeType();
    verify(collectionLikeType2, atLeast(1)).isRecordType();
    verify(collectionLikeType2, atLeast(1)).getContentType();
    verify(collectionLikeType2, atLeast(1)).isContainerType();
    verify(collectionLikeType2).getBindings();
    verify(collectionLikeType2).getSuperClass();
  }

  /**
   * Test {@link JacksonUtil#fromString(String, TypeReference)} with {@code string}, {@code valueTypeRef}.
   * <p>
   * Method under test: {@link JacksonUtil#fromString(String, TypeReference)}
   */
  @Test
  @DisplayName("Test fromString(String, TypeReference) with 'string', 'valueTypeRef'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Object JacksonUtil.fromString(String, TypeReference)"})
  void testFromStringWithStringValueTypeRef5() {
    // Arrange
    CollectionLikeType collectionLikeType = mock(CollectionLikeType.class);
    when(collectionLikeType.getValueHandler()).thenReturn("Value Handler");
    CollectionLikeType collectionLikeType2 = mock(CollectionLikeType.class);
    Class<Object> erasedType = Object.class;
    when(collectionLikeType2.getSuperClass())
        .thenReturn(new ResolvedRecursiveType(erasedType, TypeBindings.emptyBindings()));
    when(collectionLikeType2.getBindings()).thenReturn(TypeBindings.emptyBindings());
    when(collectionLikeType2.hasRawClass(Mockito.<Class<Object>>any())).thenReturn(true);
    when(collectionLikeType2.isConcrete()).thenReturn(true);
    when(collectionLikeType2.isRecordType()).thenReturn(true);
    when(collectionLikeType2.isArrayType()).thenReturn(false);
    when(collectionLikeType2.isEnumType()).thenReturn(true);
    when(collectionLikeType2.getKeyType()).thenReturn(new PlaceholderForType(1));
    when(collectionLikeType2.getContentType()).thenReturn(collectionLikeType);
    when(collectionLikeType2.isAbstract()).thenReturn(true);
    when(collectionLikeType2.isMapLikeType()).thenReturn(true);
    when(collectionLikeType2.isContainerType()).thenReturn(true);
    Class<Builder> forNameResult = Builder.class;
    Mockito.<Class<?>>when(collectionLikeType2.getRawClass()).thenReturn(forNameResult);
    TypeReference<Object> valueTypeRef = mock(TypeReference.class);
    when(valueTypeRef.getType()).thenReturn(collectionLikeType2);

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> JacksonUtil.fromString("\"", valueTypeRef));
    verify(valueTypeRef).getType();
    verify(collectionLikeType2, atLeast(1)).getKeyType();
    verify(collectionLikeType2, atLeast(1)).getRawClass();
    verify(collectionLikeType, atLeast(1)).getValueHandler();
    verify(collectionLikeType2).hasRawClass(isA(Class.class));
    verify(collectionLikeType2).isAbstract();
    verify(collectionLikeType2, atLeast(1)).isArrayType();
    verify(collectionLikeType2).isConcrete();
    verify(collectionLikeType2, atLeast(1)).isEnumType();
    verify(collectionLikeType2, atLeast(1)).isMapLikeType();
    verify(collectionLikeType2, atLeast(1)).isRecordType();
    verify(collectionLikeType2, atLeast(1)).getContentType();
    verify(collectionLikeType2, atLeast(1)).isContainerType();
    verify(collectionLikeType2).getBindings();
    verify(collectionLikeType2).getSuperClass();
  }

  /**
   * Test {@link JacksonUtil#fromString(String, TypeReference)} with {@code string}, {@code valueTypeRef}.
   * <ul>
   *   <li>Given {@link IllegalArgumentException#IllegalArgumentException(String)} with {@code foo}.</li>
   * </ul>
   * <p>
   * Method under test: {@link JacksonUtil#fromString(String, TypeReference)}
   */
  @Test
  @DisplayName("Test fromString(String, TypeReference) with 'string', 'valueTypeRef'; given IllegalArgumentException(String) with 'foo'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Object JacksonUtil.fromString(String, TypeReference)"})
  void testFromStringWithStringValueTypeRef_givenIllegalArgumentExceptionWithFoo() {
    // Arrange
    TypeReference<Object> valueTypeRef = mock(TypeReference.class);
    when(valueTypeRef.getType()).thenThrow(new IllegalArgumentException("foo"));

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> JacksonUtil.fromString("String", valueTypeRef));
    verify(valueTypeRef).getType();
  }

  /**
   * Test {@link JacksonUtil#fromString(String, TypeReference)} with {@code string}, {@code valueTypeRef}.
   * <ul>
   *   <li>Given {@code JacksonUtil}.</li>
   * </ul>
   * <p>
   * Method under test: {@link JacksonUtil#fromString(String, TypeReference)}
   */
  @Test
  @DisplayName("Test fromString(String, TypeReference) with 'string', 'valueTypeRef'; given 'org.thingsboard.common.util.JacksonUtil'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Object JacksonUtil.fromString(String, TypeReference)"})
  void testFromStringWithStringValueTypeRef_givenOrgThingsboardCommonUtilJacksonUtil() {
    // Arrange
    CollectionLikeType collectionLikeType = mock(CollectionLikeType.class);
    when(collectionLikeType.getValueHandler()).thenReturn("Value Handler");
    CollectionLikeType collectionLikeType2 = mock(CollectionLikeType.class);
    when(collectionLikeType2.getSuperClass()).thenReturn(new PlaceholderForType(1));
    when(collectionLikeType2.getBindings()).thenReturn(TypeBindings.emptyBindings());
    when(collectionLikeType2.hasRawClass(Mockito.<Class<Object>>any())).thenReturn(true);
    when(collectionLikeType2.isConcrete()).thenReturn(true);
    when(collectionLikeType2.isRecordType()).thenReturn(true);
    when(collectionLikeType2.isArrayType()).thenReturn(false);
    when(collectionLikeType2.isEnumType()).thenReturn(true);
    when(collectionLikeType2.getKeyType()).thenReturn(new PlaceholderForType(1));
    when(collectionLikeType2.getContentType()).thenReturn(collectionLikeType);
    when(collectionLikeType2.isAbstract()).thenReturn(true);
    when(collectionLikeType2.isMapLikeType()).thenReturn(true);
    when(collectionLikeType2.isContainerType()).thenReturn(true);
    Class<JacksonUtil> forNameResult = JacksonUtil.class;
    Mockito.<Class<?>>when(collectionLikeType2.getRawClass()).thenReturn(forNameResult);
    TypeReference<Object> valueTypeRef = mock(TypeReference.class);
    when(valueTypeRef.getType()).thenReturn(collectionLikeType2);

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> JacksonUtil.fromString("\"", valueTypeRef));
    verify(valueTypeRef).getType();
    verify(collectionLikeType2, atLeast(1)).getKeyType();
    verify(collectionLikeType2, atLeast(1)).getRawClass();
    verify(collectionLikeType, atLeast(1)).getValueHandler();
    verify(collectionLikeType2).hasRawClass(isA(Class.class));
    verify(collectionLikeType2).isAbstract();
    verify(collectionLikeType2, atLeast(1)).isArrayType();
    verify(collectionLikeType2).isConcrete();
    verify(collectionLikeType2, atLeast(1)).isEnumType();
    verify(collectionLikeType2, atLeast(1)).isMapLikeType();
    verify(collectionLikeType2, atLeast(1)).isRecordType();
    verify(collectionLikeType2, atLeast(1)).getContentType();
    verify(collectionLikeType2, atLeast(1)).isContainerType();
    verify(collectionLikeType2, atLeast(1)).getBindings();
    verify(collectionLikeType2).getSuperClass();
  }

  /**
   * Test {@link JacksonUtil#fromString(String, TypeReference)} with {@code string}, {@code valueTypeRef}.
   * <ul>
   *   <li>Given {@link PlaceholderForType#PlaceholderForType(int)} with ordinal is one.</li>
   * </ul>
   * <p>
   * Method under test: {@link JacksonUtil#fromString(String, TypeReference)}
   */
  @Test
  @DisplayName("Test fromString(String, TypeReference) with 'string', 'valueTypeRef'; given PlaceholderForType(int) with ordinal is one")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Object JacksonUtil.fromString(String, TypeReference)"})
  void testFromStringWithStringValueTypeRef_givenPlaceholderForTypeWithOrdinalIsOne() {
    // Arrange
    TypeReference<Object> valueTypeRef = mock(TypeReference.class);
    when(valueTypeRef.getType()).thenReturn(new PlaceholderForType(1));

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> JacksonUtil.fromString("String", valueTypeRef));
    verify(valueTypeRef).getType();
  }

  /**
   * Test {@link JacksonUtil#fromString(String, TypeReference)} with {@code string}, {@code valueTypeRef}.
   * <ul>
   *   <li>Given {@link PlaceholderForType#PlaceholderForType(int)} with ordinal is one.</li>
   * </ul>
   * <p>
   * Method under test: {@link JacksonUtil#fromString(String, TypeReference)}
   */
  @Test
  @DisplayName("Test fromString(String, TypeReference) with 'string', 'valueTypeRef'; given PlaceholderForType(int) with ordinal is one")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Object JacksonUtil.fromString(String, TypeReference)"})
  void testFromStringWithStringValueTypeRef_givenPlaceholderForTypeWithOrdinalIsOne2() {
    // Arrange
    TypeReference<Object> valueTypeRef = mock(TypeReference.class);
    when(valueTypeRef.getType()).thenReturn(new PlaceholderForType(1));

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> JacksonUtil.fromString("\"", valueTypeRef));
    verify(valueTypeRef).getType();
  }

  /**
   * Test {@link JacksonUtil#fromString(String, TypeReference)} with {@code string}, {@code valueTypeRef}.
   * <ul>
   *   <li>When {@code 42}.</li>
   *   <li>Then return intValue is forty-two.</li>
   * </ul>
   * <p>
   * Method under test: {@link JacksonUtil#fromString(String, TypeReference)}
   */
  @Test
  @DisplayName("Test fromString(String, TypeReference) with 'string', 'valueTypeRef'; when '42'; then return intValue is forty-two")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Object JacksonUtil.fromString(String, TypeReference)"})
  void testFromStringWithStringValueTypeRef_when42_thenReturnIntValueIsFortyTwo() {
    // Arrange
    TypeReference<Object> valueTypeRef = mock(TypeReference.class);
    when(valueTypeRef.getType()).thenReturn(new PlaceholderForType(1));

    // Act
    Object actualFromStringResult = JacksonUtil.fromString("42", valueTypeRef);

    // Assert
    verify(valueTypeRef).getType();
    assertEquals(42, ((Integer) actualFromStringResult).intValue());
  }

  /**
   * Test {@link JacksonUtil#fromString(String, TypeReference)} with {@code string}, {@code valueTypeRef}.
   * <ul>
   *   <li>When empty string.</li>
   * </ul>
   * <p>
   * Method under test: {@link JacksonUtil#fromString(String, TypeReference)}
   */
  @Test
  @DisplayName("Test fromString(String, TypeReference) with 'string', 'valueTypeRef'; when empty string")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Object JacksonUtil.fromString(String, TypeReference)"})
  void testFromStringWithStringValueTypeRef_whenEmptyString() {
    // Arrange
    TypeReference<Object> valueTypeRef = mock(TypeReference.class);
    when(valueTypeRef.getType()).thenReturn(new PlaceholderForType(1));

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> JacksonUtil.fromString("", valueTypeRef));
    verify(valueTypeRef).getType();
  }

  /**
   * Test {@link JacksonUtil#fromString(String, TypeReference)} with {@code string}, {@code valueTypeRef}.
   * <ul>
   *   <li>When empty string.</li>
   * </ul>
   * <p>
   * Method under test: {@link JacksonUtil#fromString(String, TypeReference)}
   */
  @Test
  @DisplayName("Test fromString(String, TypeReference) with 'string', 'valueTypeRef'; when empty string")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Object JacksonUtil.fromString(String, TypeReference)"})
  void testFromStringWithStringValueTypeRef_whenEmptyString2() {
    // Arrange
    CollectionLikeType collectionLikeType = mock(CollectionLikeType.class);
    Class<Object> forNameResult = Object.class;
    Mockito.<Class<?>>when(collectionLikeType.getRawClass()).thenReturn(forNameResult);
    TypeReference<Object> valueTypeRef = mock(TypeReference.class);
    when(valueTypeRef.getType()).thenReturn(collectionLikeType);

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> JacksonUtil.fromString("", valueTypeRef));
    verify(valueTypeRef).getType();
    verify(collectionLikeType).getRawClass();
  }

  /**
   * Test {@link JacksonUtil#fromString(String, TypeReference)} with {@code string}, {@code valueTypeRef}.
   * <ul>
   *   <li>When {@code null}.</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link JacksonUtil#fromString(String, TypeReference)}
   */
  @Test
  @DisplayName("Test fromString(String, TypeReference) with 'string', 'valueTypeRef'; when 'null'; then return 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Object JacksonUtil.fromString(String, TypeReference)"})
  void testFromStringWithStringValueTypeRef_whenNull_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull(JacksonUtil.<Object>fromString(null, mock(TypeReference.class)));
  }

  /**
   * Test {@link JacksonUtil#fromBytes(byte[], Class)} with {@code bytes}, {@code clazz}.
   * <ul>
   *   <li>When array of {@code byte} with {@code A} and minus one.</li>
   * </ul>
   * <p>
   * Method under test: {@link JacksonUtil#fromBytes(byte[], Class)}
   */
  @Test
  @DisplayName("Test fromBytes(byte[], Class) with 'bytes', 'clazz'; when array of byte with 'A' and minus one")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Object JacksonUtil.fromBytes(byte[], Class)"})
  void testFromBytesWithBytesClazz_whenArrayOfByteWithAAndMinusOne() {
    // Arrange
    Class<Object> clazz = Object.class;

    // Act and Assert
    assertThrows(IllegalArgumentException.class,
        () -> JacksonUtil.fromBytes(new byte[]{'A', -1, 'A', 'X', 'A', 'X', 'A', 'X'}, clazz));
  }

  /**
   * Test {@link JacksonUtil#fromBytes(byte[], Class)} with {@code bytes}, {@code clazz}.
   * <ul>
   *   <li>When array of {@code byte} with {@link Byte#MAX_VALUE} and {@code X}.</li>
   * </ul>
   * <p>
   * Method under test: {@link JacksonUtil#fromBytes(byte[], Class)}
   */
  @Test
  @DisplayName("Test fromBytes(byte[], Class) with 'bytes', 'clazz'; when array of byte with MAX_VALUE and 'X'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Object JacksonUtil.fromBytes(byte[], Class)"})
  void testFromBytesWithBytesClazz_whenArrayOfByteWithMax_valueAndX() {
    // Arrange
    Class<Object> clazz = Object.class;

    // Act and Assert
    assertThrows(IllegalArgumentException.class,
        () -> JacksonUtil.fromBytes(new byte[]{Byte.MAX_VALUE, 'X', 'A', 'X', 'A', 'X', 'A', 'X'}, clazz));
  }

  /**
   * Test {@link JacksonUtil#fromBytes(byte[], Class)} with {@code bytes}, {@code clazz}.
   * <ul>
   *   <li>When array of {@code byte} with zero and {@code X}.</li>
   * </ul>
   * <p>
   * Method under test: {@link JacksonUtil#fromBytes(byte[], Class)}
   */
  @Test
  @DisplayName("Test fromBytes(byte[], Class) with 'bytes', 'clazz'; when array of byte with zero and 'X'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Object JacksonUtil.fromBytes(byte[], Class)"})
  void testFromBytesWithBytesClazz_whenArrayOfByteWithZeroAndX() {
    // Arrange
    Class<Object> clazz = Object.class;

    // Act and Assert
    assertThrows(IllegalArgumentException.class,
        () -> JacksonUtil.fromBytes(new byte[]{0, 'X', 'A', 'X', 'A', 'X', 'A', 'X'}, clazz));
  }

  /**
   * Test {@link JacksonUtil#fromBytes(byte[], Class)} with {@code bytes}, {@code clazz}.
   * <ul>
   *   <li>When array of {@code byte} with zero and zero.</li>
   * </ul>
   * <p>
   * Method under test: {@link JacksonUtil#fromBytes(byte[], Class)}
   */
  @Test
  @DisplayName("Test fromBytes(byte[], Class) with 'bytes', 'clazz'; when array of byte with zero and zero")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Object JacksonUtil.fromBytes(byte[], Class)"})
  void testFromBytesWithBytesClazz_whenArrayOfByteWithZeroAndZero() {
    // Arrange
    Class<Object> clazz = Object.class;

    // Act and Assert
    assertThrows(IllegalArgumentException.class,
        () -> JacksonUtil.fromBytes(new byte[]{0, 0, 'A', 'X', 'A', 'X', 'A', 'X'}, clazz));
  }

  /**
   * Test {@link JacksonUtil#fromBytes(byte[], Class)} with {@code bytes}, {@code clazz}.
   * <ul>
   *   <li>When array of {@code byte} with zero and zero.</li>
   * </ul>
   * <p>
   * Method under test: {@link JacksonUtil#fromBytes(byte[], Class)}
   */
  @Test
  @DisplayName("Test fromBytes(byte[], Class) with 'bytes', 'clazz'; when array of byte with zero and zero")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Object JacksonUtil.fromBytes(byte[], Class)"})
  void testFromBytesWithBytesClazz_whenArrayOfByteWithZeroAndZero2() {
    // Arrange
    Class<Object> clazz = Object.class;

    // Act and Assert
    assertThrows(IllegalArgumentException.class,
        () -> JacksonUtil.fromBytes(new byte[]{0, 0, 'A', 0, 'A', 'X', 'A', 'X'}, clazz));
  }

  /**
   * Test {@link JacksonUtil#fromBytes(byte[], Class)} with {@code bytes}, {@code clazz}.
   * <ul>
   *   <li>When {@code AXAXAXAX} Bytes is {@code UTF-8}.</li>
   * </ul>
   * <p>
   * Method under test: {@link JacksonUtil#fromBytes(byte[], Class)}
   */
  @Test
  @DisplayName("Test fromBytes(byte[], Class) with 'bytes', 'clazz'; when 'AXAXAXAX' Bytes is 'UTF-8'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Object JacksonUtil.fromBytes(byte[], Class)"})
  void testFromBytesWithBytesClazz_whenAxaxaxaxBytesIsUtf8() throws UnsupportedEncodingException {
    // Arrange
    byte[] bytes = "AXAXAXAX".getBytes("UTF-8");
    Class<Object> clazz = Object.class;

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> JacksonUtil.fromBytes(bytes, clazz));
  }

  /**
   * Test {@link JacksonUtil#fromBytes(byte[], Class)} with {@code bytes}, {@code clazz}.
   * <ul>
   *   <li>When {@code JsonMapper$Builder}.</li>
   * </ul>
   * <p>
   * Method under test: {@link JacksonUtil#fromBytes(byte[], Class)}
   */
  @Test
  @DisplayName("Test fromBytes(byte[], Class) with 'bytes', 'clazz'; when 'com.fasterxml.jackson.databind.json.JsonMapper$Builder'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Object JacksonUtil.fromBytes(byte[], Class)"})
  void testFromBytesWithBytesClazz_whenComFasterxmlJacksonDatabindJsonJsonMapperBuilder()
      throws UnsupportedEncodingException {
    // Arrange
    byte[] bytes = "AXAXAXAX".getBytes("UTF-8");
    Class<Builder> clazz = Builder.class;

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> JacksonUtil.fromBytes(bytes, clazz));
  }

  /**
   * Test {@link JacksonUtil#fromBytes(byte[], Class)} with {@code bytes}, {@code clazz}.
   * <ul>
   *   <li>When empty array of {@code byte}.</li>
   * </ul>
   * <p>
   * Method under test: {@link JacksonUtil#fromBytes(byte[], Class)}
   */
  @Test
  @DisplayName("Test fromBytes(byte[], Class) with 'bytes', 'clazz'; when empty array of byte")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Object JacksonUtil.fromBytes(byte[], Class)"})
  void testFromBytesWithBytesClazz_whenEmptyArrayOfByte() {
    // Arrange
    Class<Object> clazz = Object.class;

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> JacksonUtil.fromBytes(new byte[]{}, clazz));
  }

  /**
   * Test {@link JacksonUtil#fromBytes(byte[], Class)} with {@code bytes}, {@code clazz}.
   * <ul>
   *   <li>When {@code String}.</li>
   *   <li>Then throw {@link IllegalArgumentException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link JacksonUtil#fromBytes(byte[], Class)}
   */
  @Test
  @DisplayName("Test fromBytes(byte[], Class) with 'bytes', 'clazz'; when 'java.lang.String'; then throw IllegalArgumentException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Object JacksonUtil.fromBytes(byte[], Class)"})
  void testFromBytesWithBytesClazz_whenJavaLangString_thenThrowIllegalArgumentException()
      throws UnsupportedEncodingException {
    // Arrange
    byte[] bytes = "AXAXAXAX".getBytes("UTF-8");
    Class<String> clazz = String.class;

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> JacksonUtil.fromBytes(bytes, clazz));
  }

  /**
   * Test {@link JacksonUtil#fromBytes(byte[], Class)} with {@code bytes}, {@code clazz}.
   * <ul>
   *   <li>When {@code null}.</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link JacksonUtil#fromBytes(byte[], Class)}
   */
  @Test
  @DisplayName("Test fromBytes(byte[], Class) with 'bytes', 'clazz'; when 'null'; then return 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Object JacksonUtil.fromBytes(byte[], Class)"})
  void testFromBytesWithBytesClazz_whenNull_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull(JacksonUtil.fromBytes(null, (Class<Object>) null));
  }

  /**
   * Test {@link JacksonUtil#fromBytes(byte[], TypeReference)} with {@code bytes}, {@code valueTypeRef}.
   * <ul>
   *   <li>Given {@link IllegalArgumentException#IllegalArgumentException(String)} with {@code foo}.</li>
   * </ul>
   * <p>
   * Method under test: {@link JacksonUtil#fromBytes(byte[], TypeReference)}
   */
  @Test
  @DisplayName("Test fromBytes(byte[], TypeReference) with 'bytes', 'valueTypeRef'; given IllegalArgumentException(String) with 'foo'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Object JacksonUtil.fromBytes(byte[], TypeReference)"})
  void testFromBytesWithBytesValueTypeRef_givenIllegalArgumentExceptionWithFoo() throws UnsupportedEncodingException {
    // Arrange
    byte[] bytes = "AXAXAXAX".getBytes("UTF-8");
    TypeReference<Object> valueTypeRef = mock(TypeReference.class);
    when(valueTypeRef.getType()).thenThrow(new IllegalArgumentException("foo"));

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> JacksonUtil.fromBytes(bytes, valueTypeRef));
    verify(valueTypeRef).getType();
  }

  /**
   * Test {@link JacksonUtil#fromBytes(byte[], TypeReference)} with {@code bytes}, {@code valueTypeRef}.
   * <ul>
   *   <li>Given {@code Object}.</li>
   *   <li>Then calls {@link JavaType#getRawClass()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link JacksonUtil#fromBytes(byte[], TypeReference)}
   */
  @Test
  @DisplayName("Test fromBytes(byte[], TypeReference) with 'bytes', 'valueTypeRef'; given 'java.lang.Object'; then calls getRawClass()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Object JacksonUtil.fromBytes(byte[], TypeReference)"})
  void testFromBytesWithBytesValueTypeRef_givenJavaLangObject_thenCallsGetRawClass() {
    // Arrange
    CollectionLikeType collectionLikeType = mock(CollectionLikeType.class);
    Class<Object> forNameResult = Object.class;
    Mockito.<Class<?>>when(collectionLikeType.getRawClass()).thenReturn(forNameResult);
    TypeReference<Object> valueTypeRef = mock(TypeReference.class);
    when(valueTypeRef.getType()).thenReturn(collectionLikeType);

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> JacksonUtil.fromBytes(new byte[]{}, valueTypeRef));
    verify(valueTypeRef).getType();
    verify(collectionLikeType).getRawClass();
  }

  /**
   * Test {@link JacksonUtil#fromBytes(byte[], TypeReference)} with {@code bytes}, {@code valueTypeRef}.
   * <ul>
   *   <li>When array of {@code byte} with {@code A} and minus one.</li>
   * </ul>
   * <p>
   * Method under test: {@link JacksonUtil#fromBytes(byte[], TypeReference)}
   */
  @Test
  @DisplayName("Test fromBytes(byte[], TypeReference) with 'bytes', 'valueTypeRef'; when array of byte with 'A' and minus one")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Object JacksonUtil.fromBytes(byte[], TypeReference)"})
  void testFromBytesWithBytesValueTypeRef_whenArrayOfByteWithAAndMinusOne() {
    // Arrange
    TypeReference<Object> valueTypeRef = mock(TypeReference.class);
    when(valueTypeRef.getType()).thenReturn(new PlaceholderForType(1));

    // Act and Assert
    assertThrows(IllegalArgumentException.class,
        () -> JacksonUtil.fromBytes(new byte[]{'A', -1, 'A', 'X', 'A', 'X', 'A', 'X'}, valueTypeRef));
    verify(valueTypeRef).getType();
  }

  /**
   * Test {@link JacksonUtil#fromBytes(byte[], TypeReference)} with {@code bytes}, {@code valueTypeRef}.
   * <ul>
   *   <li>When array of {@code byte} with {@link Byte#MAX_VALUE} and {@code X}.</li>
   * </ul>
   * <p>
   * Method under test: {@link JacksonUtil#fromBytes(byte[], TypeReference)}
   */
  @Test
  @DisplayName("Test fromBytes(byte[], TypeReference) with 'bytes', 'valueTypeRef'; when array of byte with MAX_VALUE and 'X'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Object JacksonUtil.fromBytes(byte[], TypeReference)"})
  void testFromBytesWithBytesValueTypeRef_whenArrayOfByteWithMax_valueAndX() {
    // Arrange
    TypeReference<Object> valueTypeRef = mock(TypeReference.class);
    when(valueTypeRef.getType()).thenReturn(new PlaceholderForType(1));

    // Act and Assert
    assertThrows(IllegalArgumentException.class,
        () -> JacksonUtil.fromBytes(new byte[]{Byte.MAX_VALUE, 'X', 'A', 'X', 'A', 'X', 'A', 'X'}, valueTypeRef));
    verify(valueTypeRef).getType();
  }

  /**
   * Test {@link JacksonUtil#fromBytes(byte[], TypeReference)} with {@code bytes}, {@code valueTypeRef}.
   * <ul>
   *   <li>When array of {@code byte} with zero and {@code X}.</li>
   * </ul>
   * <p>
   * Method under test: {@link JacksonUtil#fromBytes(byte[], TypeReference)}
   */
  @Test
  @DisplayName("Test fromBytes(byte[], TypeReference) with 'bytes', 'valueTypeRef'; when array of byte with zero and 'X'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Object JacksonUtil.fromBytes(byte[], TypeReference)"})
  void testFromBytesWithBytesValueTypeRef_whenArrayOfByteWithZeroAndX() {
    // Arrange
    TypeReference<Object> valueTypeRef = mock(TypeReference.class);
    when(valueTypeRef.getType()).thenReturn(new PlaceholderForType(1));

    // Act and Assert
    assertThrows(IllegalArgumentException.class,
        () -> JacksonUtil.fromBytes(new byte[]{0, 'X', 'A', 'X', 'A', 'X', 'A', 'X'}, valueTypeRef));
    verify(valueTypeRef).getType();
  }

  /**
   * Test {@link JacksonUtil#fromBytes(byte[], TypeReference)} with {@code bytes}, {@code valueTypeRef}.
   * <ul>
   *   <li>When array of {@code byte} with zero and zero.</li>
   * </ul>
   * <p>
   * Method under test: {@link JacksonUtil#fromBytes(byte[], TypeReference)}
   */
  @Test
  @DisplayName("Test fromBytes(byte[], TypeReference) with 'bytes', 'valueTypeRef'; when array of byte with zero and zero")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Object JacksonUtil.fromBytes(byte[], TypeReference)"})
  void testFromBytesWithBytesValueTypeRef_whenArrayOfByteWithZeroAndZero() {
    // Arrange
    TypeReference<Object> valueTypeRef = mock(TypeReference.class);
    when(valueTypeRef.getType()).thenReturn(new PlaceholderForType(1));

    // Act and Assert
    assertThrows(IllegalArgumentException.class,
        () -> JacksonUtil.fromBytes(new byte[]{0, 0, 'A', 'X', 'A', 'X', 'A', 'X'}, valueTypeRef));
    verify(valueTypeRef).getType();
  }

  /**
   * Test {@link JacksonUtil#fromBytes(byte[], TypeReference)} with {@code bytes}, {@code valueTypeRef}.
   * <ul>
   *   <li>When {@code AXAXAXAX} Bytes is {@code UTF-8}.</li>
   * </ul>
   * <p>
   * Method under test: {@link JacksonUtil#fromBytes(byte[], TypeReference)}
   */
  @Test
  @DisplayName("Test fromBytes(byte[], TypeReference) with 'bytes', 'valueTypeRef'; when 'AXAXAXAX' Bytes is 'UTF-8'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Object JacksonUtil.fromBytes(byte[], TypeReference)"})
  void testFromBytesWithBytesValueTypeRef_whenAxaxaxaxBytesIsUtf8() throws UnsupportedEncodingException {
    // Arrange
    byte[] bytes = "AXAXAXAX".getBytes("UTF-8");
    TypeReference<Object> valueTypeRef = mock(TypeReference.class);
    when(valueTypeRef.getType()).thenReturn(new PlaceholderForType(1));

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> JacksonUtil.fromBytes(bytes, valueTypeRef));
    verify(valueTypeRef).getType();
  }

  /**
   * Test {@link JacksonUtil#fromBytes(byte[], TypeReference)} with {@code bytes}, {@code valueTypeRef}.
   * <ul>
   *   <li>When empty array of {@code byte}.</li>
   * </ul>
   * <p>
   * Method under test: {@link JacksonUtil#fromBytes(byte[], TypeReference)}
   */
  @Test
  @DisplayName("Test fromBytes(byte[], TypeReference) with 'bytes', 'valueTypeRef'; when empty array of byte")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Object JacksonUtil.fromBytes(byte[], TypeReference)"})
  void testFromBytesWithBytesValueTypeRef_whenEmptyArrayOfByte() {
    // Arrange
    TypeReference<Object> valueTypeRef = mock(TypeReference.class);
    when(valueTypeRef.getType()).thenReturn(new PlaceholderForType(1));

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> JacksonUtil.fromBytes(new byte[]{}, valueTypeRef));
    verify(valueTypeRef).getType();
  }

  /**
   * Test {@link JacksonUtil#fromBytes(byte[], TypeReference)} with {@code bytes}, {@code valueTypeRef}.
   * <ul>
   *   <li>When {@code null}.</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link JacksonUtil#fromBytes(byte[], TypeReference)}
   */
  @Test
  @DisplayName("Test fromBytes(byte[], TypeReference) with 'bytes', 'valueTypeRef'; when 'null'; then return 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Object JacksonUtil.fromBytes(byte[], TypeReference)"})
  void testFromBytesWithBytesValueTypeRef_whenNull_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull(JacksonUtil.<Object>fromBytes(null, mock(TypeReference.class)));
  }

  /**
   * Test {@link JacksonUtil#fromBytes(byte[])} with {@code bytes}.
   * <ul>
   *   <li>When array of {@code byte} with {@code A} and minus one.</li>
   * </ul>
   * <p>
   * Method under test: {@link JacksonUtil#fromBytes(byte[])}
   */
  @Test
  @DisplayName("Test fromBytes(byte[]) with 'bytes'; when array of byte with 'A' and minus one")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"JsonNode JacksonUtil.fromBytes(byte[])"})
  void testFromBytesWithBytes_whenArrayOfByteWithAAndMinusOne() {
    // Arrange, Act and Assert
    assertThrows(IllegalArgumentException.class,
        () -> JacksonUtil.fromBytes(new byte[]{'A', -1, 'A', 'X', 'A', 'X', 'A', 'X'}));
  }

  /**
   * Test {@link JacksonUtil#fromBytes(byte[])} with {@code bytes}.
   * <ul>
   *   <li>When array of {@code byte} with {@link Byte#MAX_VALUE} and {@code X}.</li>
   * </ul>
   * <p>
   * Method under test: {@link JacksonUtil#fromBytes(byte[])}
   */
  @Test
  @DisplayName("Test fromBytes(byte[]) with 'bytes'; when array of byte with MAX_VALUE and 'X'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"JsonNode JacksonUtil.fromBytes(byte[])"})
  void testFromBytesWithBytes_whenArrayOfByteWithMax_valueAndX() {
    // Arrange, Act and Assert
    assertThrows(IllegalArgumentException.class,
        () -> JacksonUtil.fromBytes(new byte[]{Byte.MAX_VALUE, 'X', 'A', 'X', 'A', 'X', 'A', 'X'}));
  }

  /**
   * Test {@link JacksonUtil#fromBytes(byte[])} with {@code bytes}.
   * <ul>
   *   <li>When array of {@code byte} with zero and {@code X}.</li>
   * </ul>
   * <p>
   * Method under test: {@link JacksonUtil#fromBytes(byte[])}
   */
  @Test
  @DisplayName("Test fromBytes(byte[]) with 'bytes'; when array of byte with zero and 'X'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"JsonNode JacksonUtil.fromBytes(byte[])"})
  void testFromBytesWithBytes_whenArrayOfByteWithZeroAndX() {
    // Arrange, Act and Assert
    assertThrows(IllegalArgumentException.class,
        () -> JacksonUtil.fromBytes(new byte[]{0, 'X', 'A', 'X', 'A', 'X', 'A', 'X'}));
  }

  /**
   * Test {@link JacksonUtil#fromBytes(byte[])} with {@code bytes}.
   * <ul>
   *   <li>When array of {@code byte} with zero and zero.</li>
   * </ul>
   * <p>
   * Method under test: {@link JacksonUtil#fromBytes(byte[])}
   */
  @Test
  @DisplayName("Test fromBytes(byte[]) with 'bytes'; when array of byte with zero and zero")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"JsonNode JacksonUtil.fromBytes(byte[])"})
  void testFromBytesWithBytes_whenArrayOfByteWithZeroAndZero() {
    // Arrange, Act and Assert
    assertThrows(IllegalArgumentException.class,
        () -> JacksonUtil.fromBytes(new byte[]{0, 0, 'A', 'X', 'A', 'X', 'A', 'X'}));
  }

  /**
   * Test {@link JacksonUtil#fromBytes(byte[])} with {@code bytes}.
   * <ul>
   *   <li>When array of {@code byte} with zero and zero.</li>
   * </ul>
   * <p>
   * Method under test: {@link JacksonUtil#fromBytes(byte[])}
   */
  @Test
  @DisplayName("Test fromBytes(byte[]) with 'bytes'; when array of byte with zero and zero")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"JsonNode JacksonUtil.fromBytes(byte[])"})
  void testFromBytesWithBytes_whenArrayOfByteWithZeroAndZero2() {
    // Arrange, Act and Assert
    assertThrows(IllegalArgumentException.class,
        () -> JacksonUtil.fromBytes(new byte[]{0, 0, 0, 'X', 'A', 'X', 'A', 'X'}));
  }

  /**
   * Test {@link JacksonUtil#fromBytes(byte[])} with {@code bytes}.
   * <ul>
   *   <li>When array of {@code byte} with zero and zero.</li>
   * </ul>
   * <p>
   * Method under test: {@link JacksonUtil#fromBytes(byte[])}
   */
  @Test
  @DisplayName("Test fromBytes(byte[]) with 'bytes'; when array of byte with zero and zero")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"JsonNode JacksonUtil.fromBytes(byte[])"})
  void testFromBytesWithBytes_whenArrayOfByteWithZeroAndZero3() {
    // Arrange, Act and Assert
    assertThrows(IllegalArgumentException.class,
        () -> JacksonUtil.fromBytes(new byte[]{0, 0, 'A', 0, 'A', 'X', 'A', 'X'}));
  }

  /**
   * Test {@link JacksonUtil#fromBytes(byte[])} with {@code bytes}.
   * <ul>
   *   <li>When {@code AXAXAXAX} Bytes is {@code UTF-8}.</li>
   *   <li>Then throw {@link IllegalArgumentException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link JacksonUtil#fromBytes(byte[])}
   */
  @Test
  @DisplayName("Test fromBytes(byte[]) with 'bytes'; when 'AXAXAXAX' Bytes is 'UTF-8'; then throw IllegalArgumentException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"JsonNode JacksonUtil.fromBytes(byte[])"})
  void testFromBytesWithBytes_whenAxaxaxaxBytesIsUtf8_thenThrowIllegalArgumentException()
      throws UnsupportedEncodingException {
    // Arrange, Act and Assert
    assertThrows(IllegalArgumentException.class, () -> JacksonUtil.fromBytes("AXAXAXAX".getBytes("UTF-8")));
  }

  /**
   * Test {@link JacksonUtil#fromBytes(byte[])} with {@code bytes}.
   * <ul>
   *   <li>When empty array of {@code byte}.</li>
   *   <li>Then return {@link MissingNode}.</li>
   * </ul>
   * <p>
   * Method under test: {@link JacksonUtil#fromBytes(byte[])}
   */
  @Test
  @DisplayName("Test fromBytes(byte[]) with 'bytes'; when empty array of byte; then return MissingNode")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"JsonNode JacksonUtil.fromBytes(byte[])"})
  void testFromBytesWithBytes_whenEmptyArrayOfByte_thenReturnMissingNode() {
    // Arrange and Act
    JsonNode actualFromBytesResult = JacksonUtil.fromBytes(new byte[]{});

    // Assert
    assertTrue(actualFromBytesResult instanceof MissingNode);
    assertTrue(actualFromBytesResult.traverse() instanceof TreeTraversingParser);
    assertEquals("", actualFromBytesResult.toPrettyString());
    assertEquals(0, actualFromBytesResult.size());
    assertEquals(JsonNodeType.MISSING, actualFromBytesResult.getNodeType());
    assertFalse(actualFromBytesResult.isArray());
    assertFalse(actualFromBytesResult.isBigDecimal());
    assertFalse(actualFromBytesResult.isBigInteger());
    assertFalse(actualFromBytesResult.isBinary());
    assertFalse(actualFromBytesResult.isBoolean());
    assertFalse(actualFromBytesResult.isContainerNode());
    assertFalse(actualFromBytesResult.isDouble());
    assertFalse(actualFromBytesResult.isFloat());
    assertFalse(actualFromBytesResult.isFloatingPointNumber());
    assertFalse(actualFromBytesResult.isInt());
    assertFalse(actualFromBytesResult.isIntegralNumber());
    assertFalse(actualFromBytesResult.isLong());
    assertFalse(actualFromBytesResult.isNull());
    assertFalse(actualFromBytesResult.isNumber());
    assertFalse(actualFromBytesResult.isObject());
    assertFalse(actualFromBytesResult.isPojo());
    assertFalse(actualFromBytesResult.isShort());
    assertFalse(actualFromBytesResult.isTextual());
    assertFalse(actualFromBytesResult.isValueNode());
    assertFalse(actualFromBytesResult.iterator().hasNext());
    assertTrue(actualFromBytesResult.isEmpty());
    assertTrue(actualFromBytesResult.isMissingNode());
  }

  /**
   * Test {@link JacksonUtil#toString(Object)} with {@code Object}.
   * <p>
   * Method under test: {@link JacksonUtil#toString(Object)}
   */
  @Test
  @DisplayName("Test toString(Object) with 'Object'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String JacksonUtil.toString(Object)"})
  void testToStringWithObject() {
    // Arrange, Act and Assert
    assertEquals("\"\\\"\"", JacksonUtil.toString("\""));
  }

  /**
   * Test {@link JacksonUtil#toString(Object)} with {@code Object}.
   * <ul>
   *   <li>When {@code null}.</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link JacksonUtil#toString(Object)}
   */
  @Test
  @DisplayName("Test toString(Object) with 'Object'; when 'null'; then return 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String JacksonUtil.toString(Object)"})
  void testToStringWithObject_whenNull_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull(JacksonUtil.toString(null));
  }

  /**
   * Test {@link JacksonUtil#toString(Object)} with {@code Object}.
   * <ul>
   *   <li>When {@code Value}.</li>
   *   <li>Then return {@code "Value"}.</li>
   * </ul>
   * <p>
   * Method under test: {@link JacksonUtil#toString(Object)}
   */
  @Test
  @DisplayName("Test toString(Object) with 'Object'; when 'Value'; then return '\"Value\"'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String JacksonUtil.toString(Object)"})
  void testToStringWithObject_whenValue_thenReturnValue() {
    // Arrange, Act and Assert
    assertEquals("\"Value\"", JacksonUtil.toString("Value"));
  }

  /**
   * Test {@link JacksonUtil#writeValueAsString(Object)}.
   * <p>
   * Method under test: {@link JacksonUtil#writeValueAsString(Object)}
   */
  @Test
  @DisplayName("Test writeValueAsString(Object)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String JacksonUtil.writeValueAsString(Object)"})
  void testWriteValueAsString() {
    // Arrange, Act and Assert
    assertEquals("{\"id\":null,\"createdTime\":0,\"tenantId\":null,\"key\":null,\"jsonValue\":null}",
        JacksonUtil.writeValueAsString(new AdminSettings()));
  }

  /**
   * Test {@link JacksonUtil#writeValueAsString(Object)}.
   * <p>
   * Method under test: {@link JacksonUtil#writeValueAsString(Object)}
   */
  @Test
  @DisplayName("Test writeValueAsString(Object)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String JacksonUtil.writeValueAsString(Object)"})
  void testWriteValueAsString2() {
    // Arrange
    BaseData<UUIDBased> baseData = mock(BaseData.class);
    when(baseData.getCreatedTime()).thenReturn(1L);
    when(baseData.getId()).thenReturn(new AdminSettingsId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")));

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> JacksonUtil.writeValueAsString(baseData));
    verify(baseData).getCreatedTime();
    verify(baseData).getId();
  }

  /**
   * Test {@link JacksonUtil#writeValueAsString(Object)}.
   * <p>
   * Method under test: {@link JacksonUtil#writeValueAsString(Object)}
   */
  @Test
  @DisplayName("Test writeValueAsString(Object)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String JacksonUtil.writeValueAsString(Object)"})
  void testWriteValueAsString3() {
    // Arrange
    BaseDataWithAdditionalInfo<UUIDBased> baseDataWithAdditionalInfo = mock(BaseDataWithAdditionalInfo.class);
    when(baseDataWithAdditionalInfo.getCreatedTime()).thenReturn(1L);
    when(baseDataWithAdditionalInfo.getId())
        .thenReturn(new AlarmId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")));

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> JacksonUtil.writeValueAsString(baseDataWithAdditionalInfo));
    verify(baseDataWithAdditionalInfo).getCreatedTime();
    verify(baseDataWithAdditionalInfo).getId();
  }

  /**
   * Test {@link JacksonUtil#writeValueAsString(Object)}.
   * <p>
   * Method under test: {@link JacksonUtil#writeValueAsString(Object)}
   */
  @Test
  @DisplayName("Test writeValueAsString(Object)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String JacksonUtil.writeValueAsString(Object)"})
  void testWriteValueAsString4() {
    // Arrange
    BaseDataWithAdditionalInfo<UUIDBased> baseDataWithAdditionalInfo = mock(BaseDataWithAdditionalInfo.class);
    when(baseDataWithAdditionalInfo.getCreatedTime()).thenReturn(1L);
    when(baseDataWithAdditionalInfo.getId())
        .thenReturn(new CustomerId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")));

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> JacksonUtil.writeValueAsString(baseDataWithAdditionalInfo));
    verify(baseDataWithAdditionalInfo).getCreatedTime();
    verify(baseDataWithAdditionalInfo).getId();
  }

  /**
   * Test {@link JacksonUtil#writeValueAsString(Object)}.
   * <p>
   * Method under test: {@link JacksonUtil#writeValueAsString(Object)}
   */
  @Test
  @DisplayName("Test writeValueAsString(Object)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String JacksonUtil.writeValueAsString(Object)"})
  void testWriteValueAsString5() {
    // Arrange, Act and Assert
    assertEquals("\"\\\"\"", JacksonUtil.writeValueAsString("\""));
  }

  /**
   * Test {@link JacksonUtil#writeValueAsString(Object)}.
   * <p>
   * Method under test: {@link JacksonUtil#writeValueAsString(Object)}
   */
  @Test
  @DisplayName("Test writeValueAsString(Object)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String JacksonUtil.writeValueAsString(Object)"})
  void testWriteValueAsString6() {
    // Arrange
    AlarmConditionFilter alarmConditionFilter = new AlarmConditionFilter();
    alarmConditionFilter.setKey(new AlarmConditionFilterKey(AlarmConditionKeyType.ATTRIBUTE, "Key"));
    alarmConditionFilter.setPredicate(mock(KeyFilterPredicate.class));
    alarmConditionFilter.setValue("Value");
    alarmConditionFilter.setValueType(EntityKeyValueType.STRING);

    ArrayList<AlarmConditionFilter> condition = new ArrayList<>();
    condition.add(alarmConditionFilter);

    AlarmCondition alarmCondition = new AlarmCondition();
    alarmCondition.setCondition(condition);
    alarmCondition.setSpec(mock(AlarmConditionSpec.class));

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> JacksonUtil.writeValueAsString(alarmCondition));
  }

  /**
   * Test {@link JacksonUtil#writeValueAsString(Object)}.
   * <p>
   * Method under test: {@link JacksonUtil#writeValueAsString(Object)}
   */
  @Test
  @DisplayName("Test writeValueAsString(Object)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String JacksonUtil.writeValueAsString(Object)"})
  void testWriteValueAsString7() {
    // Arrange
    Dashboard dashboard = new Dashboard();
    dashboard.setTenantId(new TenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")));
    dashboard.setConfiguration(NullNode.getInstance());

    // Act and Assert
    assertEquals(
        "{\"id\":null,\"createdTime\":0,\"tenantId\":{\"entityType\":\"TENANT\",\"id\":\"784f394c-42b6-435a-983c-b7beff2784f9"
            + "\"},\"title\":null,\"image\":null,\"assignedCustomers\":null,\"mobileHide\":false,\"mobileOrder\":null,\"version"
            + "\":null,\"externalId\":null,\"hideDashboardToolbar\":true,\"configuration\":null,\"name\":null}",
        JacksonUtil.writeValueAsString(new HomeDashboard(dashboard, true)));
  }

  /**
   * Test {@link JacksonUtil#writeValueAsString(Object)}.
   * <p>
   * Method under test: {@link JacksonUtil#writeValueAsString(Object)}
   */
  @Test
  @DisplayName("Test writeValueAsString(Object)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String JacksonUtil.writeValueAsString(Object)"})
  void testWriteValueAsString8() {
    // Arrange
    Dashboard dashboard = new Dashboard();
    dashboard.setTenantId(new TenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")));
    dashboard.setConfiguration(MissingNode.getInstance());

    // Act and Assert
    assertEquals(
        "{\"id\":null,\"createdTime\":0,\"tenantId\":{\"entityType\":\"TENANT\",\"id\":\"784f394c-42b6-435a-983c-b7beff2784f9"
            + "\"},\"title\":null,\"image\":null,\"assignedCustomers\":null,\"mobileHide\":false,\"mobileOrder\":null,\"version"
            + "\":null,\"externalId\":null,\"hideDashboardToolbar\":true,\"configuration\":null,\"name\":null}",
        JacksonUtil.writeValueAsString(new HomeDashboard(dashboard, true)));
  }

  /**
   * Test {@link JacksonUtil#writeValueAsString(Object)}.
   * <p>
   * Method under test: {@link JacksonUtil#writeValueAsString(Object)}
   */
  @Test
  @DisplayName("Test writeValueAsString(Object)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String JacksonUtil.writeValueAsString(Object)"})
  void testWriteValueAsString9() {
    // Arrange, Act and Assert
    assertEquals("{\"id\":null,\"firstName\":\"Jane\",\"lastName\":\"Doe\",\"email\":\"jane.doe@example.org\"}",
        JacksonUtil.writeValueAsString(new AlarmAssignee(null, "Jane", "Doe", "jane.doe@example.org")));
  }

  /**
   * Test {@link JacksonUtil#writeValueAsString(Object)}.
   * <p>
   * Method under test: {@link JacksonUtil#writeValueAsString(Object)}
   */
  @Test
  @DisplayName("Test writeValueAsString(Object)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String JacksonUtil.writeValueAsString(Object)"})
  void testWriteValueAsString10() {
    // Arrange, Act and Assert
    assertEquals("{\"id\":null,\"firstName\":\"John\",\"lastName\":\"Doe\",\"email\":\"jane.doe@example.org\"}",
        JacksonUtil.writeValueAsString(new AlarmAssignee(null, "John", "Doe", "jane.doe@example.org")));
  }

  /**
   * Test {@link JacksonUtil#writeValueAsString(Object)}.
   * <p>
   * Method under test: {@link JacksonUtil#writeValueAsString(Object)}
   */
  @Test
  @DisplayName("Test writeValueAsString(Object)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String JacksonUtil.writeValueAsString(Object)"})
  void testWriteValueAsString11() {
    // Arrange, Act and Assert
    assertEquals(
        "{\"id\":{\"entityType\":\"USER\",\"id\":\"784f394c-42b6-435a-983c-b7beff2784f9\"},\"firstName\":\"John\",\"lastName"
            + "\":\"Doe\",\"email\":\"jane.doe@example.org\"}",
        JacksonUtil
            .writeValueAsString(new AlarmAssignee(new UserId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")),
                "John", "Doe", "jane.doe@example.org")));
  }

  /**
   * Test {@link JacksonUtil#writeValueAsString(Object)}.
   * <ul>
   *   <li>Given {@link ArrayList#ArrayList()}.</li>
   *   <li>When {@link AlarmCondition} (default constructor) Condition is {@link ArrayList#ArrayList()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link JacksonUtil#writeValueAsString(Object)}
   */
  @Test
  @DisplayName("Test writeValueAsString(Object); given ArrayList(); when AlarmCondition (default constructor) Condition is ArrayList()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String JacksonUtil.writeValueAsString(Object)"})
  void testWriteValueAsString_givenArrayList_whenAlarmConditionConditionIsArrayList() {
    // Arrange
    AlarmCondition alarmCondition = new AlarmCondition();
    alarmCondition.setCondition(new ArrayList<>());
    alarmCondition.setSpec(mock(AlarmConditionSpec.class));

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> JacksonUtil.writeValueAsString(alarmCondition));
  }

  /**
   * Test {@link JacksonUtil#writeValueAsString(Object)}.
   * <ul>
   *   <li>Given Instance.</li>
   *   <li>When {@link Dashboard#Dashboard()} Configuration is Instance.</li>
   * </ul>
   * <p>
   * Method under test: {@link JacksonUtil#writeValueAsString(Object)}
   */
  @Test
  @DisplayName("Test writeValueAsString(Object); given Instance; when Dashboard() Configuration is Instance")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String JacksonUtil.writeValueAsString(Object)"})
  void testWriteValueAsString_givenInstance_whenDashboardConfigurationIsInstance() {
    // Arrange
    Dashboard dashboard = new Dashboard();
    dashboard.setConfiguration(MissingNode.getInstance());

    // Act and Assert
    assertEquals(
        "{\"id\":null,\"createdTime\":0,\"tenantId\":null,\"title\":null,\"image\":null,\"assignedCustomers\":null,\"mobileHide"
            + "\":false,\"mobileOrder\":null,\"version\":null,\"externalId\":null,\"hideDashboardToolbar\":true,\"configuration"
            + "\":null,\"name\":null}",
        JacksonUtil.writeValueAsString(new HomeDashboard(dashboard, true)));
  }

  /**
   * Test {@link JacksonUtil#writeValueAsString(Object)}.
   * <ul>
   *   <li>Given Instance.</li>
   *   <li>When {@link Dashboard#Dashboard()} Configuration is Instance.</li>
   * </ul>
   * <p>
   * Method under test: {@link JacksonUtil#writeValueAsString(Object)}
   */
  @Test
  @DisplayName("Test writeValueAsString(Object); given Instance; when Dashboard() Configuration is Instance")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String JacksonUtil.writeValueAsString(Object)"})
  void testWriteValueAsString_givenInstance_whenDashboardConfigurationIsInstance2() {
    // Arrange
    Dashboard dashboard = new Dashboard();
    dashboard.setConfiguration(NullNode.getInstance());

    // Act and Assert
    assertEquals(
        "{\"id\":null,\"createdTime\":0,\"tenantId\":null,\"title\":null,\"image\":null,\"assignedCustomers\":null,\"mobileHide"
            + "\":false,\"mobileOrder\":null,\"version\":null,\"externalId\":null,\"hideDashboardToolbar\":true,\"configuration"
            + "\":null,\"name\":null}",
        JacksonUtil.writeValueAsString(new HomeDashboard(dashboard, true)));
  }

  /**
   * Test {@link JacksonUtil#writeValueAsString(Object)}.
   * <ul>
   *   <li>Given {@link RuntimeException#RuntimeException(String)} with empty string.</li>
   * </ul>
   * <p>
   * Method under test: {@link JacksonUtil#writeValueAsString(Object)}
   */
  @Test
  @DisplayName("Test writeValueAsString(Object); given RuntimeException(String) with empty string")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String JacksonUtil.writeValueAsString(Object)"})
  void testWriteValueAsString_givenRuntimeExceptionWithEmptyString() {
    // Arrange
    BaseData<UUIDBased> baseData = mock(BaseData.class);
    when(baseData.getId()).thenThrow(new RuntimeException(""));

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> JacksonUtil.writeValueAsString(baseData));
    verify(baseData).getId();
  }

  /**
   * Test {@link JacksonUtil#writeValueAsString(Object)}.
   * <ul>
   *   <li>When {@code null}.</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link JacksonUtil#writeValueAsString(Object)}
   */
  @Test
  @DisplayName("Test writeValueAsString(Object); when 'null'; then return 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String JacksonUtil.writeValueAsString(Object)"})
  void testWriteValueAsString_whenNull_thenReturnNull() {
    // Arrange, Act and Assert
    assertEquals("null", JacksonUtil.writeValueAsString(null));
  }

  /**
   * Test {@link JacksonUtil#writeValueAsString(Object)}.
   * <ul>
   *   <li>When {@link TenantProfile#TenantProfile()}.</li>
   *   <li>Then return a string.</li>
   * </ul>
   * <p>
   * Method under test: {@link JacksonUtil#writeValueAsString(Object)}
   */
  @Test
  @DisplayName("Test writeValueAsString(Object); when TenantProfile(); then return a string")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String JacksonUtil.writeValueAsString(Object)"})
  void testWriteValueAsString_whenTenantProfile_thenReturnAString() {
    // Arrange, Act and Assert
    assertEquals(
        "{\"id\":null,\"createdTime\":0,\"name\":null,\"description\":null,\"isolatedTbRuleEngine\":false,\"profileData\""
            + ":{\"configuration\":{\"type\":\"DEFAULT\",\"maxDevices\":0,\"maxAssets\":0,\"maxCustomers\":0,\"maxUsers\":0,"
            + "\"maxDashboards\":0,\"maxRuleChains\":0,\"maxResourcesInBytes\":0,\"maxOtaPackagesInBytes\":0,\"maxResourceSize"
            + "\":0,\"transportTenantMsgRateLimit\":null,\"transportTenantTelemetryMsgRateLimit\":null,\"transportTenantT"
            + "elemetryDataPointsRateLimit\":null,\"transportDeviceMsgRateLimit\":null,\"transportDeviceTelemetryMsgRateLimit"
            + "\":null,\"transportDeviceTelemetryDataPointsRateLimit\":null,\"transportGatewayMsgRateLimit\":null,"
            + "\"transportGatewayTelemetryMsgRateLimit\":null,\"transportGatewayTelemetryDataPointsRateLimit\":null,"
            + "\"transportGatewayDeviceMsgRateLimit\":null,\"transportGatewayDeviceTelemetryMsgRateLimit\":null,"
            + "\"transportGatewayDeviceTelemetryDataPointsRateLimit\":null,\"tenantEntityExportRateLimit\":null,"
            + "\"tenantEntityImportRateLimit\":null,\"tenantNotificationRequestsRateLimit\":null,\"tenantNotificationReq"
            + "uestsPerRuleRateLimit\":null,\"maxTransportMessages\":0,\"maxTransportDataPoints\":0,\"maxREExecutions\":0,"
            + "\"maxJSExecutions\":0,\"maxTbelExecutions\":0,\"maxDPStorageDays\":0,\"maxRuleNodeExecutionsPerMessage\":0,"
            + "\"maxEmails\":0,\"smsEnabled\":null,\"maxSms\":0,\"maxCreatedAlarms\":0,\"tenantServerRestLimitsConfiguration"
            + "\":null,\"customerServerRestLimitsConfiguration\":null,\"maxWsSessionsPerTenant\":0,\"maxWsSessionsPerCustomer"
            + "\":0,\"maxWsSessionsPerRegularUser\":0,\"maxWsSessionsPerPublicUser\":0,\"wsMsgQueueLimitPerSession\":0,"
            + "\"maxWsSubscriptionsPerTenant\":0,\"maxWsSubscriptionsPerCustomer\":0,\"maxWsSubscriptionsPerRegularUser\""
            + ":0,\"maxWsSubscriptionsPerPublicUser\":0,\"wsUpdatesPerSessionRateLimit\":null,\"cassandraQueryTenantRate"
            + "LimitsConfiguration\":null,\"edgeEventRateLimits\":null,\"edgeEventRateLimitsPerEdge\":null,\"edgeUplinkMe"
            + "ssagesRateLimits\":null,\"edgeUplinkMessagesRateLimitsPerEdge\":null,\"defaultStorageTtlDays\":0,\"alarmsTtlDays"
            + "\":0,\"rpcTtlDays\":0,\"queueStatsTtlDays\":0,\"ruleEngineExceptionsTtlDays\":0,\"warnThreshold\":0.0},"
            + "\"queueConfiguration\":null},\"default\":false}",
        JacksonUtil.writeValueAsString(new TenantProfile()));
  }

  /**
   * Test {@link JacksonUtil#toPrettyString(Object)}.
   * <p>
   * Method under test: {@link JacksonUtil#toPrettyString(Object)}
   */
  @Test
  @DisplayName("Test toPrettyString(Object)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String JacksonUtil.toPrettyString(Object)"})
  void testToPrettyString() {
    // Arrange, Act and Assert
    assertEquals(
        "{\r\n  \"securityMode\" : \"PSK\",\r\n  \"clientPublicKeyOrId\" : null,\r\n  \"clientSecretKey\" : null\r\n}",
        JacksonUtil.toPrettyString(new PSKBootstrapClientCredential()));
  }

  /**
   * Test {@link JacksonUtil#toPrettyString(Object)}.
   * <p>
   * Method under test: {@link JacksonUtil#toPrettyString(Object)}
   */
  @Test
  @DisplayName("Test toPrettyString(Object)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String JacksonUtil.toPrettyString(Object)"})
  void testToPrettyString2() {
    // Arrange
    DurationAlarmConditionSpec durationAlarmConditionSpec = new DurationAlarmConditionSpec();
    durationAlarmConditionSpec.setPredicate(new FilterPredicateValue<>(42L, 42L,
        new DynamicValue<>(DynamicValueSourceType.CURRENT_TENANT, "Source Attribute")));
    durationAlarmConditionSpec.setUnit(TimeUnit.NANOSECONDS);

    // Act and Assert
    assertEquals(
        "{\r\n" + "  \"type\" : \"DURATION\",\r\n" + "  \"predicate\" : {\r\n" + "    \"defaultValue\" : 42,\r\n"
            + "    \"dynamicValue\" : {\r\n" + "      \"inherit\" : false,\r\n"
            + "      \"sourceAttribute\" : \"Source Attribute\",\r\n" + "      \"sourceType\" : \"CURRENT_TENANT\"\r\n"
            + "    },\r\n" + "    \"userValue\" : 42\r\n" + "  },\r\n" + "  \"unit\" : \"NANOSECONDS\"\r\n" + "}",
        JacksonUtil.toPrettyString(durationAlarmConditionSpec));
  }

  /**
   * Test {@link JacksonUtil#toPrettyString(Object)}.
   * <p>
   * Method under test: {@link JacksonUtil#toPrettyString(Object)}
   */
  @Test
  @DisplayName("Test toPrettyString(Object)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String JacksonUtil.toPrettyString(Object)"})
  void testToPrettyString3() {
    // Arrange
    BaseData<UUIDBased> baseData = mock(BaseData.class);
    when(baseData.getCreatedTime()).thenReturn(1L);
    when(baseData.getId()).thenReturn(new AdminSettingsId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")));

    // Act and Assert
    assertThrows(RuntimeException.class, () -> JacksonUtil.toPrettyString(baseData));
    verify(baseData).getCreatedTime();
    verify(baseData).getId();
  }

  /**
   * Test {@link JacksonUtil#toPrettyString(Object)}.
   * <p>
   * Method under test: {@link JacksonUtil#toPrettyString(Object)}
   */
  @Test
  @DisplayName("Test toPrettyString(Object)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String JacksonUtil.toPrettyString(Object)"})
  void testToPrettyString4() {
    // Arrange
    BaseData<UUIDBased> baseData = mock(BaseData.class);
    when(baseData.getCreatedTime()).thenReturn(1L);
    when(baseData.getId()).thenReturn(new AlarmId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")));

    // Act and Assert
    assertThrows(RuntimeException.class, () -> JacksonUtil.toPrettyString(baseData));
    verify(baseData).getCreatedTime();
    verify(baseData).getId();
  }

  /**
   * Test {@link JacksonUtil#toPrettyString(Object)}.
   * <p>
   * Method under test: {@link JacksonUtil#toPrettyString(Object)}
   */
  @Test
  @DisplayName("Test toPrettyString(Object)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String JacksonUtil.toPrettyString(Object)"})
  void testToPrettyString5() {
    // Arrange
    BaseData<UUIDBased> baseData = mock(BaseData.class);
    when(baseData.getCreatedTime()).thenReturn(1L);
    when(baseData.getId()).thenReturn(new CustomerId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")));

    // Act and Assert
    assertThrows(RuntimeException.class, () -> JacksonUtil.toPrettyString(baseData));
    verify(baseData).getCreatedTime();
    verify(baseData).getId();
  }

  /**
   * Test {@link JacksonUtil#toPrettyString(Object)}.
   * <p>
   * Method under test: {@link JacksonUtil#toPrettyString(Object)}
   */
  @Test
  @DisplayName("Test toPrettyString(Object)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String JacksonUtil.toPrettyString(Object)"})
  void testToPrettyString6() {
    // Arrange
    BaseDataWithAdditionalInfo<UUIDBased> baseDataWithAdditionalInfo = mock(BaseDataWithAdditionalInfo.class);
    when(baseDataWithAdditionalInfo.getAdditionalInfo())
        .thenReturn(new ArrayNode(JsonNodeFactory.withExactBigDecimals(true), 3));
    when(baseDataWithAdditionalInfo.getCreatedTime()).thenReturn(1L);
    when(baseDataWithAdditionalInfo.getId())
        .thenReturn(new AdminSettingsId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")));

    // Act and Assert
    assertThrows(RuntimeException.class, () -> JacksonUtil.toPrettyString(baseDataWithAdditionalInfo));
    verify(baseDataWithAdditionalInfo).getCreatedTime();
    verify(baseDataWithAdditionalInfo).getAdditionalInfo();
    verify(baseDataWithAdditionalInfo).getId();
  }

  /**
   * Test {@link JacksonUtil#toPrettyString(Object)}.
   * <p>
   * Method under test: {@link JacksonUtil#toPrettyString(Object)}
   */
  @Test
  @DisplayName("Test toPrettyString(Object)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String JacksonUtil.toPrettyString(Object)"})
  void testToPrettyString7() throws UnsupportedEncodingException {
    // Arrange
    BaseDataWithAdditionalInfo<UUIDBased> baseDataWithAdditionalInfo = mock(BaseDataWithAdditionalInfo.class);
    when(baseDataWithAdditionalInfo.getAdditionalInfo()).thenReturn(new BinaryNode("AXAXAXAX".getBytes("UTF-8"), 2, 3));
    when(baseDataWithAdditionalInfo.getCreatedTime()).thenReturn(1L);
    when(baseDataWithAdditionalInfo.getId())
        .thenReturn(new AdminSettingsId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")));

    // Act and Assert
    assertThrows(RuntimeException.class, () -> JacksonUtil.toPrettyString(baseDataWithAdditionalInfo));
    verify(baseDataWithAdditionalInfo).getCreatedTime();
    verify(baseDataWithAdditionalInfo).getAdditionalInfo();
    verify(baseDataWithAdditionalInfo).getId();
  }

  /**
   * Test {@link JacksonUtil#toPrettyString(Object)}.
   * <p>
   * Method under test: {@link JacksonUtil#toPrettyString(Object)}
   */
  @Test
  @DisplayName("Test toPrettyString(Object)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String JacksonUtil.toPrettyString(Object)"})
  void testToPrettyString8() {
    // Arrange
    BaseData<UUIDBased> baseData = mock(BaseData.class);
    when(baseData.getCreatedTime()).thenReturn(0L);
    when(baseData.getId()).thenReturn(new AlarmId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")));

    // Act and Assert
    assertThrows(RuntimeException.class, () -> JacksonUtil.toPrettyString(baseData));
    verify(baseData).getCreatedTime();
    verify(baseData).getId();
  }

  /**
   * Test {@link JacksonUtil#toPrettyString(Object)}.
   * <p>
   * Method under test: {@link JacksonUtil#toPrettyString(Object)}
   */
  @Test
  @DisplayName("Test toPrettyString(Object)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String JacksonUtil.toPrettyString(Object)"})
  void testToPrettyString9() {
    // Arrange
    ArrayNode arrayNode = new ArrayNode(JsonNodeFactory.withExactBigDecimals(true));
    arrayNode.addRawValue(new RawValue("foo"));
    arrayNode.add(MissingNode.getInstance());
    BaseDataWithAdditionalInfo<UUIDBased> baseDataWithAdditionalInfo = mock(BaseDataWithAdditionalInfo.class);
    when(baseDataWithAdditionalInfo.getAdditionalInfo()).thenReturn(arrayNode);
    when(baseDataWithAdditionalInfo.getCreatedTime()).thenReturn(1L);
    when(baseDataWithAdditionalInfo.getId())
        .thenReturn(new AdminSettingsId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")));

    // Act and Assert
    assertThrows(RuntimeException.class, () -> JacksonUtil.toPrettyString(baseDataWithAdditionalInfo));
    verify(baseDataWithAdditionalInfo).getCreatedTime();
    verify(baseDataWithAdditionalInfo).getAdditionalInfo();
    verify(baseDataWithAdditionalInfo).getId();
  }

  /**
   * Test {@link JacksonUtil#toPrettyString(Object)}.
   * <p>
   * Method under test: {@link JacksonUtil#toPrettyString(Object)}
   */
  @Test
  @DisplayName("Test toPrettyString(Object)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String JacksonUtil.toPrettyString(Object)"})
  void testToPrettyString10() throws UnsupportedEncodingException {
    // Arrange
    ArrayNode arrayNode = new ArrayNode(JsonNodeFactory.withExactBigDecimals(true));
    arrayNode.add("AXAXAXAX".getBytes("UTF-8"));
    arrayNode.add(MissingNode.getInstance());
    BaseDataWithAdditionalInfo<UUIDBased> baseDataWithAdditionalInfo = mock(BaseDataWithAdditionalInfo.class);
    when(baseDataWithAdditionalInfo.getAdditionalInfo()).thenReturn(arrayNode);
    when(baseDataWithAdditionalInfo.getCreatedTime()).thenReturn(1L);
    when(baseDataWithAdditionalInfo.getId())
        .thenReturn(new AdminSettingsId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")));

    // Act and Assert
    assertThrows(RuntimeException.class, () -> JacksonUtil.toPrettyString(baseDataWithAdditionalInfo));
    verify(baseDataWithAdditionalInfo).getCreatedTime();
    verify(baseDataWithAdditionalInfo).getAdditionalInfo();
    verify(baseDataWithAdditionalInfo).getId();
  }

  /**
   * Test {@link JacksonUtil#toPrettyString(Object)}.
   * <ul>
   *   <li>Given {@code 42}.</li>
   * </ul>
   * <p>
   * Method under test: {@link JacksonUtil#toPrettyString(Object)}
   */
  @Test
  @DisplayName("Test toPrettyString(Object); given '42'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String JacksonUtil.toPrettyString(Object)"})
  void testToPrettyString_given42() {
    // Arrange
    PSKBootstrapClientCredential pskBootstrapClientCredential = new PSKBootstrapClientCredential();
    pskBootstrapClientCredential.setClientPublicKeyOrId("42");
    pskBootstrapClientCredential.setClientSecretKey("EXAMPLEKEYwjalrXUtnFEMI/K7MDENG/bPxRfiCY");

    // Act and Assert
    assertEquals(
        "{\r\n" + "  \"securityMode\" : \"PSK\",\r\n" + "  \"clientPublicKeyOrId\" : \"42\",\r\n"
            + "  \"clientSecretKey\" : \"EXAMPLEKEYwjalrXUtnFEMI/K7MDENG/bPxRfiCY\"\r\n" + "}",
        JacksonUtil.toPrettyString(pskBootstrapClientCredential));
  }

  /**
   * Test {@link JacksonUtil#toPrettyString(Object)}.
   * <ul>
   *   <li>Given {@link ArrayList#ArrayList()}.</li>
   *   <li>When {@link AlarmCondition} (default constructor) Condition is {@link ArrayList#ArrayList()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link JacksonUtil#toPrettyString(Object)}
   */
  @Test
  @DisplayName("Test toPrettyString(Object); given ArrayList(); when AlarmCondition (default constructor) Condition is ArrayList()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String JacksonUtil.toPrettyString(Object)"})
  void testToPrettyString_givenArrayList_whenAlarmConditionConditionIsArrayList() {
    // Arrange
    AlarmCondition alarmCondition = new AlarmCondition();
    alarmCondition.setCondition(new ArrayList<>());
    alarmCondition.setSpec(mock(AlarmConditionSpec.class));

    // Act and Assert
    assertThrows(RuntimeException.class, () -> JacksonUtil.toPrettyString(alarmCondition));
  }

  /**
   * Test {@link JacksonUtil#toPrettyString(Object)}.
   * <ul>
   *   <li>Given {@link ArrayNode#ArrayNode(JsonNodeFactory)} with nf is withExactBigDecimals {@code true}.</li>
   * </ul>
   * <p>
   * Method under test: {@link JacksonUtil#toPrettyString(Object)}
   */
  @Test
  @DisplayName("Test toPrettyString(Object); given ArrayNode(JsonNodeFactory) with nf is withExactBigDecimals 'true'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String JacksonUtil.toPrettyString(Object)"})
  void testToPrettyString_givenArrayNodeWithNfIsWithExactBigDecimalsTrue() {
    // Arrange
    BaseDataWithAdditionalInfo<UUIDBased> baseDataWithAdditionalInfo = mock(BaseDataWithAdditionalInfo.class);
    when(baseDataWithAdditionalInfo.getAdditionalInfo())
        .thenReturn(new ArrayNode(JsonNodeFactory.withExactBigDecimals(true)));
    when(baseDataWithAdditionalInfo.getCreatedTime()).thenReturn(1L);
    when(baseDataWithAdditionalInfo.getId())
        .thenReturn(new AdminSettingsId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")));

    // Act and Assert
    assertThrows(RuntimeException.class, () -> JacksonUtil.toPrettyString(baseDataWithAdditionalInfo));
    verify(baseDataWithAdditionalInfo).getCreatedTime();
    verify(baseDataWithAdditionalInfo).getAdditionalInfo();
    verify(baseDataWithAdditionalInfo).getId();
  }

  /**
   * Test {@link JacksonUtil#toPrettyString(Object)}.
   * <ul>
   *   <li>Given {@link ArrayNode#ArrayNode(JsonNodeFactory)} with nf is withExactBigDecimals {@code true} addArray.</li>
   * </ul>
   * <p>
   * Method under test: {@link JacksonUtil#toPrettyString(Object)}
   */
  @Test
  @DisplayName("Test toPrettyString(Object); given ArrayNode(JsonNodeFactory) with nf is withExactBigDecimals 'true' addArray")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String JacksonUtil.toPrettyString(Object)"})
  void testToPrettyString_givenArrayNodeWithNfIsWithExactBigDecimalsTrueAddArray() {
    // Arrange
    ArrayNode arrayNode = new ArrayNode(JsonNodeFactory.withExactBigDecimals(true));
    arrayNode.addArray();
    arrayNode.add(MissingNode.getInstance());
    BaseDataWithAdditionalInfo<UUIDBased> baseDataWithAdditionalInfo = mock(BaseDataWithAdditionalInfo.class);
    when(baseDataWithAdditionalInfo.getAdditionalInfo()).thenReturn(arrayNode);
    when(baseDataWithAdditionalInfo.getCreatedTime()).thenReturn(1L);
    when(baseDataWithAdditionalInfo.getId())
        .thenReturn(new AdminSettingsId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")));

    // Act and Assert
    assertThrows(RuntimeException.class, () -> JacksonUtil.toPrettyString(baseDataWithAdditionalInfo));
    verify(baseDataWithAdditionalInfo).getCreatedTime();
    verify(baseDataWithAdditionalInfo).getAdditionalInfo();
    verify(baseDataWithAdditionalInfo).getId();
  }

  /**
   * Test {@link JacksonUtil#toPrettyString(Object)}.
   * <ul>
   *   <li>Given {@link ArrayNode#ArrayNode(JsonNodeFactory)} with nf is withExactBigDecimals {@code true} add Instance.</li>
   * </ul>
   * <p>
   * Method under test: {@link JacksonUtil#toPrettyString(Object)}
   */
  @Test
  @DisplayName("Test toPrettyString(Object); given ArrayNode(JsonNodeFactory) with nf is withExactBigDecimals 'true' add Instance")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String JacksonUtil.toPrettyString(Object)"})
  void testToPrettyString_givenArrayNodeWithNfIsWithExactBigDecimalsTrueAddInstance() {
    // Arrange
    ArrayNode arrayNode = new ArrayNode(JsonNodeFactory.withExactBigDecimals(true));
    arrayNode.add(MissingNode.getInstance());
    BaseDataWithAdditionalInfo<UUIDBased> baseDataWithAdditionalInfo = mock(BaseDataWithAdditionalInfo.class);
    when(baseDataWithAdditionalInfo.getAdditionalInfo()).thenReturn(arrayNode);
    when(baseDataWithAdditionalInfo.getCreatedTime()).thenReturn(1L);
    when(baseDataWithAdditionalInfo.getId())
        .thenReturn(new AdminSettingsId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")));

    // Act and Assert
    assertThrows(RuntimeException.class, () -> JacksonUtil.toPrettyString(baseDataWithAdditionalInfo));
    verify(baseDataWithAdditionalInfo).getCreatedTime();
    verify(baseDataWithAdditionalInfo).getAdditionalInfo();
    verify(baseDataWithAdditionalInfo).getId();
  }

  /**
   * Test {@link JacksonUtil#toPrettyString(Object)}.
   * <ul>
   *   <li>Given {@link ArrayNode#ArrayNode(JsonNodeFactory)} with nf is withExactBigDecimals {@code true} addNull.</li>
   * </ul>
   * <p>
   * Method under test: {@link JacksonUtil#toPrettyString(Object)}
   */
  @Test
  @DisplayName("Test toPrettyString(Object); given ArrayNode(JsonNodeFactory) with nf is withExactBigDecimals 'true' addNull")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String JacksonUtil.toPrettyString(Object)"})
  void testToPrettyString_givenArrayNodeWithNfIsWithExactBigDecimalsTrueAddNull() {
    // Arrange
    ArrayNode arrayNode = new ArrayNode(JsonNodeFactory.withExactBigDecimals(true));
    arrayNode.addNull();
    arrayNode.add(MissingNode.getInstance());
    BaseDataWithAdditionalInfo<UUIDBased> baseDataWithAdditionalInfo = mock(BaseDataWithAdditionalInfo.class);
    when(baseDataWithAdditionalInfo.getAdditionalInfo()).thenReturn(arrayNode);
    when(baseDataWithAdditionalInfo.getCreatedTime()).thenReturn(1L);
    when(baseDataWithAdditionalInfo.getId())
        .thenReturn(new AdminSettingsId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")));

    // Act and Assert
    assertThrows(RuntimeException.class, () -> JacksonUtil.toPrettyString(baseDataWithAdditionalInfo));
    verify(baseDataWithAdditionalInfo).getCreatedTime();
    verify(baseDataWithAdditionalInfo).getAdditionalInfo();
    verify(baseDataWithAdditionalInfo).getId();
  }

  /**
   * Test {@link JacksonUtil#toPrettyString(Object)}.
   * <ul>
   *   <li>Given {@link ArrayNode#ArrayNode(JsonNodeFactory)} with nf is withExactBigDecimals {@code true} addObject.</li>
   * </ul>
   * <p>
   * Method under test: {@link JacksonUtil#toPrettyString(Object)}
   */
  @Test
  @DisplayName("Test toPrettyString(Object); given ArrayNode(JsonNodeFactory) with nf is withExactBigDecimals 'true' addObject")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String JacksonUtil.toPrettyString(Object)"})
  void testToPrettyString_givenArrayNodeWithNfIsWithExactBigDecimalsTrueAddObject() {
    // Arrange
    ArrayNode arrayNode = new ArrayNode(JsonNodeFactory.withExactBigDecimals(true));
    arrayNode.addObject();
    arrayNode.add(MissingNode.getInstance());
    BaseDataWithAdditionalInfo<UUIDBased> baseDataWithAdditionalInfo = mock(BaseDataWithAdditionalInfo.class);
    when(baseDataWithAdditionalInfo.getAdditionalInfo()).thenReturn(arrayNode);
    when(baseDataWithAdditionalInfo.getCreatedTime()).thenReturn(1L);
    when(baseDataWithAdditionalInfo.getId())
        .thenReturn(new AdminSettingsId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")));

    // Act and Assert
    assertThrows(RuntimeException.class, () -> JacksonUtil.toPrettyString(baseDataWithAdditionalInfo));
    verify(baseDataWithAdditionalInfo).getCreatedTime();
    verify(baseDataWithAdditionalInfo).getAdditionalInfo();
    verify(baseDataWithAdditionalInfo).getId();
  }

  /**
   * Test {@link JacksonUtil#toPrettyString(Object)}.
   * <ul>
   *   <li>Given {@link ArrayNode#ArrayNode(JsonNodeFactory)} with nf is withExactBigDecimals {@code true} addPOJO {@code Pojo}.</li>
   * </ul>
   * <p>
   * Method under test: {@link JacksonUtil#toPrettyString(Object)}
   */
  @Test
  @DisplayName("Test toPrettyString(Object); given ArrayNode(JsonNodeFactory) with nf is withExactBigDecimals 'true' addPOJO 'Pojo'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String JacksonUtil.toPrettyString(Object)"})
  void testToPrettyString_givenArrayNodeWithNfIsWithExactBigDecimalsTrueAddPOJOPojo() {
    // Arrange
    ArrayNode arrayNode = new ArrayNode(JsonNodeFactory.withExactBigDecimals(true));
    arrayNode.addPOJO("Pojo");
    arrayNode.add(MissingNode.getInstance());
    BaseDataWithAdditionalInfo<UUIDBased> baseDataWithAdditionalInfo = mock(BaseDataWithAdditionalInfo.class);
    when(baseDataWithAdditionalInfo.getAdditionalInfo()).thenReturn(arrayNode);
    when(baseDataWithAdditionalInfo.getCreatedTime()).thenReturn(1L);
    when(baseDataWithAdditionalInfo.getId())
        .thenReturn(new AdminSettingsId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")));

    // Act and Assert
    assertThrows(RuntimeException.class, () -> JacksonUtil.toPrettyString(baseDataWithAdditionalInfo));
    verify(baseDataWithAdditionalInfo).getCreatedTime();
    verify(baseDataWithAdditionalInfo).getAdditionalInfo();
    verify(baseDataWithAdditionalInfo).getId();
  }

  /**
   * Test {@link JacksonUtil#toPrettyString(Object)}.
   * <ul>
   *   <li>Given {@link BinaryNode#BinaryNode(byte[])} with data is {@code AXAXAXAX} Bytes is {@code UTF-8}.</li>
   * </ul>
   * <p>
   * Method under test: {@link JacksonUtil#toPrettyString(Object)}
   */
  @Test
  @DisplayName("Test toPrettyString(Object); given BinaryNode(byte[]) with data is 'AXAXAXAX' Bytes is 'UTF-8'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String JacksonUtil.toPrettyString(Object)"})
  void testToPrettyString_givenBinaryNodeWithDataIsAxaxaxaxBytesIsUtf8() throws UnsupportedEncodingException {
    // Arrange
    BaseDataWithAdditionalInfo<UUIDBased> baseDataWithAdditionalInfo = mock(BaseDataWithAdditionalInfo.class);
    when(baseDataWithAdditionalInfo.getAdditionalInfo()).thenReturn(new BinaryNode("AXAXAXAX".getBytes("UTF-8")));
    when(baseDataWithAdditionalInfo.getCreatedTime()).thenReturn(1L);
    when(baseDataWithAdditionalInfo.getId())
        .thenReturn(new AdminSettingsId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")));

    // Act and Assert
    assertThrows(RuntimeException.class, () -> JacksonUtil.toPrettyString(baseDataWithAdditionalInfo));
    verify(baseDataWithAdditionalInfo).getCreatedTime();
    verify(baseDataWithAdditionalInfo).getAdditionalInfo();
    verify(baseDataWithAdditionalInfo).getId();
  }

  /**
   * Test {@link JacksonUtil#toPrettyString(Object)}.
   * <ul>
   *   <li>Given {@link ImageDescriptor} (default constructor) Etag is {@code Etag}.</li>
   *   <li>When {@link ImageDescriptor} (default constructor) Etag is {@code Etag}.</li>
   * </ul>
   * <p>
   * Method under test: {@link JacksonUtil#toPrettyString(Object)}
   */
  @Test
  @DisplayName("Test toPrettyString(Object); given ImageDescriptor (default constructor) Etag is 'Etag'; when ImageDescriptor (default constructor) Etag is 'Etag'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String JacksonUtil.toPrettyString(Object)"})
  void testToPrettyString_givenImageDescriptorEtagIsEtag_whenImageDescriptorEtagIsEtag() {
    // Arrange
    ImageDescriptor previewDescriptor = new ImageDescriptor();
    previewDescriptor.setEtag("Etag");
    previewDescriptor.setHeight(1);
    previewDescriptor.setMediaType("Media Type");
    previewDescriptor.setPreviewDescriptor(new ImageDescriptor());
    previewDescriptor.setSize(3L);
    previewDescriptor.setWidth(1);

    ImageDescriptor previewDescriptor2 = new ImageDescriptor();
    previewDescriptor2.setEtag("Etag");
    previewDescriptor2.setHeight(1);
    previewDescriptor2.setMediaType("Media Type");
    previewDescriptor2.setPreviewDescriptor(previewDescriptor);
    previewDescriptor2.setSize(3L);
    previewDescriptor2.setWidth(1);

    ImageDescriptor previewDescriptor3 = new ImageDescriptor();
    previewDescriptor3.setEtag("Etag");
    previewDescriptor3.setHeight(1);
    previewDescriptor3.setMediaType("Media Type");
    previewDescriptor3.setPreviewDescriptor(previewDescriptor2);
    previewDescriptor3.setSize(3L);
    previewDescriptor3.setWidth(1);

    ImageDescriptor imageDescriptor = new ImageDescriptor();
    imageDescriptor.setEtag("Etag");
    imageDescriptor.setHeight(1);
    imageDescriptor.setMediaType("Media Type");
    imageDescriptor.setPreviewDescriptor(previewDescriptor3);
    imageDescriptor.setSize(3L);
    imageDescriptor.setWidth(1);

    // Act and Assert
    assertEquals("{\r\n" + "  \"etag\" : \"Etag\",\r\n" + "  \"height\" : 1,\r\n"
        + "  \"mediaType\" : \"Media Type\",\r\n" + "  \"previewDescriptor\" : {\r\n" + "    \"etag\" : \"Etag\",\r\n"
        + "    \"height\" : 1,\r\n" + "    \"mediaType\" : \"Media Type\",\r\n" + "    \"previewDescriptor\" : {\r\n"
        + "      \"etag\" : \"Etag\",\r\n" + "      \"height\" : 1,\r\n" + "      \"mediaType\" : \"Media Type\",\r\n"
        + "      \"previewDescriptor\" : {\r\n" + "        \"etag\" : \"Etag\",\r\n" + "        \"height\" : 1,\r\n"
        + "        \"mediaType\" : \"Media Type\",\r\n" + "        \"previewDescriptor\" : {\r\n"
        + "          \"height\" : 0,\r\n" + "          \"size\" : 0,\r\n" + "          \"width\" : 0\r\n"
        + "        },\r\n" + "        \"size\" : 3,\r\n" + "        \"width\" : 1\r\n" + "      },\r\n"
        + "      \"size\" : 3,\r\n" + "      \"width\" : 1\r\n" + "    },\r\n" + "    \"size\" : 3,\r\n"
        + "    \"width\" : 1\r\n" + "  },\r\n" + "  \"size\" : 3,\r\n" + "  \"width\" : 1\r\n" + "}",
        JacksonUtil.toPrettyString(imageDescriptor));
  }

  /**
   * Test {@link JacksonUtil#toPrettyString(Object)}.
   * <ul>
   *   <li>Given Instance.</li>
   * </ul>
   * <p>
   * Method under test: {@link JacksonUtil#toPrettyString(Object)}
   */
  @Test
  @DisplayName("Test toPrettyString(Object); given Instance")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String JacksonUtil.toPrettyString(Object)"})
  void testToPrettyString_givenInstance() {
    // Arrange
    BaseDataWithAdditionalInfo<UUIDBased> baseDataWithAdditionalInfo = mock(BaseDataWithAdditionalInfo.class);
    when(baseDataWithAdditionalInfo.getAdditionalInfo()).thenReturn(MissingNode.getInstance());
    when(baseDataWithAdditionalInfo.getCreatedTime()).thenReturn(1L);
    when(baseDataWithAdditionalInfo.getId())
        .thenReturn(new AdminSettingsId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")));

    // Act and Assert
    assertThrows(RuntimeException.class, () -> JacksonUtil.toPrettyString(baseDataWithAdditionalInfo));
    verify(baseDataWithAdditionalInfo).getCreatedTime();
    verify(baseDataWithAdditionalInfo).getAdditionalInfo();
    verify(baseDataWithAdditionalInfo).getId();
  }

  /**
   * Test {@link JacksonUtil#toPrettyString(Object)}.
   * <ul>
   *   <li>Given Instance.</li>
   * </ul>
   * <p>
   * Method under test: {@link JacksonUtil#toPrettyString(Object)}
   */
  @Test
  @DisplayName("Test toPrettyString(Object); given Instance")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String JacksonUtil.toPrettyString(Object)"})
  void testToPrettyString_givenInstance2() {
    // Arrange
    BaseDataWithAdditionalInfo<UUIDBased> baseDataWithAdditionalInfo = mock(BaseDataWithAdditionalInfo.class);
    when(baseDataWithAdditionalInfo.getAdditionalInfo()).thenReturn(NullNode.getInstance());
    when(baseDataWithAdditionalInfo.getCreatedTime()).thenReturn(1L);
    when(baseDataWithAdditionalInfo.getId())
        .thenReturn(new AdminSettingsId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")));

    // Act and Assert
    assertThrows(RuntimeException.class, () -> JacksonUtil.toPrettyString(baseDataWithAdditionalInfo));
    verify(baseDataWithAdditionalInfo).getCreatedTime();
    verify(baseDataWithAdditionalInfo).getAdditionalInfo();
    verify(baseDataWithAdditionalInfo).getId();
  }

  /**
   * Test {@link JacksonUtil#toPrettyString(Object)}.
   * <ul>
   *   <li>Given {@link RuntimeException#RuntimeException(String)} with empty string.</li>
   * </ul>
   * <p>
   * Method under test: {@link JacksonUtil#toPrettyString(Object)}
   */
  @Test
  @DisplayName("Test toPrettyString(Object); given RuntimeException(String) with empty string")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String JacksonUtil.toPrettyString(Object)"})
  void testToPrettyString_givenRuntimeExceptionWithEmptyString() {
    // Arrange
    BaseData<UUIDBased> baseData = mock(BaseData.class);
    when(baseData.getCreatedTime()).thenThrow(new RuntimeException(""));

    // Act and Assert
    assertThrows(RuntimeException.class, () -> JacksonUtil.toPrettyString(baseData));
    verify(baseData).getCreatedTime();
  }

  /**
   * Test {@link JacksonUtil#toPrettyString(Object)}.
   * <ul>
   *   <li>Given zero.</li>
   *   <li>When {@link BaseData} {@link BaseData#getCreatedTime()} return zero.</li>
   *   <li>Then calls {@link IdBased#getId()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link JacksonUtil#toPrettyString(Object)}
   */
  @Test
  @DisplayName("Test toPrettyString(Object); given zero; when BaseData getCreatedTime() return zero; then calls getId()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String JacksonUtil.toPrettyString(Object)"})
  void testToPrettyString_givenZero_whenBaseDataGetCreatedTimeReturnZero_thenCallsGetId() {
    // Arrange
    BaseData<UUIDBased> baseData = mock(BaseData.class);
    when(baseData.getCreatedTime()).thenReturn(0L);
    when(baseData.getId()).thenReturn(new AdminSettingsId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")));

    // Act and Assert
    assertThrows(RuntimeException.class, () -> JacksonUtil.toPrettyString(baseData));
    verify(baseData).getCreatedTime();
    verify(baseData).getId();
  }

  /**
   * Test {@link JacksonUtil#toPrettyString(Object)}.
   * <ul>
   *   <li>Then return {@code { "createdTime" : 0, "id" : null, "jsonValue" : null, "key" : null, "tenantId" : null }}.</li>
   * </ul>
   * <p>
   * Method under test: {@link JacksonUtil#toPrettyString(Object)}
   */
  @Test
  @DisplayName("Test toPrettyString(Object); then return '{ \"createdTime\" : 0, \"id\" : null, \"jsonValue\" : null, \"key\" : null, \"tenantId\" : null }'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String JacksonUtil.toPrettyString(Object)"})
  void testToPrettyString_thenReturnCreatedTime0IdNullJsonValueNullKeyNullTenantIdNull() {
    // Arrange, Act and Assert
    assertEquals(
        "{\r\n" + "  \"createdTime\" : 0,\r\n" + "  \"id\" : null,\r\n" + "  \"jsonValue\" : null,\r\n"
            + "  \"key\" : null,\r\n" + "  \"tenantId\" : null\r\n" + "}",
        JacksonUtil.toPrettyString(new AdminSettings()));
  }

  /**
   * Test {@link JacksonUtil#toPrettyString(Object)}.
   * <ul>
   *   <li>When {@link Alarm#Alarm()}.</li>
   *   <li>Then return a string.</li>
   * </ul>
   * <p>
   * Method under test: {@link JacksonUtil#toPrettyString(Object)}
   */
  @Test
  @DisplayName("Test toPrettyString(Object); when Alarm(); then return a string")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String JacksonUtil.toPrettyString(Object)"})
  void testToPrettyString_whenAlarm_thenReturnAString() {
    // Arrange, Act and Assert
    assertEquals(
        "{\r\n" + "  \"ackTs\" : 0,\r\n" + "  \"acknowledged\" : false,\r\n" + "  \"assignTs\" : 0,\r\n"
            + "  \"assigneeId\" : null,\r\n" + "  \"clearTs\" : 0,\r\n" + "  \"cleared\" : false,\r\n"
            + "  \"customerId\" : null,\r\n" + "  \"details\" : null,\r\n" + "  \"endTs\" : 0,\r\n"
            + "  \"originator\" : null,\r\n" + "  \"propagate\" : false,\r\n"
            + "  \"propagateRelationTypes\" : null,\r\n" + "  \"propagateToOwner\" : false,\r\n"
            + "  \"propagateToTenant\" : false,\r\n" + "  \"severity\" : null,\r\n" + "  \"startTs\" : 0,\r\n"
            + "  \"tenantId\" : null,\r\n" + "  \"type\" : null,\r\n" + "  \"createdTime\" : 0,\r\n"
            + "  \"id\" : null,\r\n" + "  \"name\" : null,\r\n" + "  \"status\" : \"ACTIVE_UNACK\"\r\n" + "}",
        JacksonUtil.toPrettyString(new Alarm()));
  }

  /**
   * Test {@link JacksonUtil#toPrettyString(Object)}.
   * <ul>
   *   <li>When {@link ApiUsageState#ApiUsageState()}.</li>
   *   <li>Then return a string.</li>
   * </ul>
   * <p>
   * Method under test: {@link JacksonUtil#toPrettyString(Object)}
   */
  @Test
  @DisplayName("Test toPrettyString(Object); when ApiUsageState(); then return a string")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String JacksonUtil.toPrettyString(Object)"})
  void testToPrettyString_whenApiUsageState_thenReturnAString() {
    // Arrange, Act and Assert
    assertEquals("{\r\n" + "  \"alarmCreationEnabled\" : true,\r\n" + "  \"alarmExecState\" : null,\r\n"
        + "  \"createdTime\" : 0,\r\n" + "  \"dbStorageEnabled\" : true,\r\n" + "  \"dbStorageState\" : null,\r\n"
        + "  \"emailExecState\" : null,\r\n" + "  \"emailSendEnabled\" : true,\r\n" + "  \"entityId\" : null,\r\n"
        + "  \"id\" : null,\r\n" + "  \"jsExecEnabled\" : true,\r\n" + "  \"jsExecState\" : null,\r\n"
        + "  \"reExecEnabled\" : true,\r\n" + "  \"reExecState\" : null,\r\n" + "  \"smsExecState\" : null,\r\n"
        + "  \"smsSendEnabled\" : true,\r\n" + "  \"tbelExecEnabled\" : true,\r\n" + "  \"tbelExecState\" : null,\r\n"
        + "  \"tenantId\" : null,\r\n" + "  \"transportEnabled\" : true,\r\n" + "  \"transportState\" : null\r\n" + "}",
        JacksonUtil.toPrettyString(new ApiUsageState()));
  }

  /**
   * Test {@link JacksonUtil#toPrettyString(Object)}.
   * <ul>
   *   <li>When {@link BaseDataWithAdditionalInfo} {@link BaseData#getCreatedTime()} return zero.</li>
   * </ul>
   * <p>
   * Method under test: {@link JacksonUtil#toPrettyString(Object)}
   */
  @Test
  @DisplayName("Test toPrettyString(Object); when BaseDataWithAdditionalInfo getCreatedTime() return zero")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String JacksonUtil.toPrettyString(Object)"})
  void testToPrettyString_whenBaseDataWithAdditionalInfoGetCreatedTimeReturnZero() {
    // Arrange
    BaseDataWithAdditionalInfo<UUIDBased> baseDataWithAdditionalInfo = mock(BaseDataWithAdditionalInfo.class);
    when(baseDataWithAdditionalInfo.getAdditionalInfo()).thenReturn(MissingNode.getInstance());
    when(baseDataWithAdditionalInfo.getCreatedTime()).thenReturn(0L);
    when(baseDataWithAdditionalInfo.getId())
        .thenReturn(new AdminSettingsId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")));

    // Act and Assert
    assertThrows(RuntimeException.class, () -> JacksonUtil.toPrettyString(baseDataWithAdditionalInfo));
    verify(baseDataWithAdditionalInfo).getCreatedTime();
    verify(baseDataWithAdditionalInfo).getAdditionalInfo();
    verify(baseDataWithAdditionalInfo).getId();
  }

  /**
   * Test {@link JacksonUtil#toPrettyString(Object)}.
   * <ul>
   *   <li>When {@link CoapDeviceTransportConfiguration} (default constructor).</li>
   *   <li>Then return a string.</li>
   * </ul>
   * <p>
   * Method under test: {@link JacksonUtil#toPrettyString(Object)}
   */
  @Test
  @DisplayName("Test toPrettyString(Object); when CoapDeviceTransportConfiguration (default constructor); then return a string")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String JacksonUtil.toPrettyString(Object)"})
  void testToPrettyString_whenCoapDeviceTransportConfiguration_thenReturnAString() {
    // Arrange, Act and Assert
    assertEquals(
        "{\r\n" + "  \"type\" : \"COAP\",\r\n" + "  \"edrxCycle\" : null,\r\n"
            + "  \"pagingTransmissionWindow\" : null,\r\n" + "  \"powerMode\" : null,\r\n"
            + "  \"psmActivityTimer\" : null\r\n" + "}",
        JacksonUtil.toPrettyString(new CoapDeviceTransportConfiguration()));
  }

  /**
   * Test {@link JacksonUtil#toPrettyString(Object)}.
   * <ul>
   *   <li>When {@link Customer#Customer()}.</li>
   *   <li>Then return a string.</li>
   * </ul>
   * <p>
   * Method under test: {@link JacksonUtil#toPrettyString(Object)}
   */
  @Test
  @DisplayName("Test toPrettyString(Object); when Customer(); then return a string")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String JacksonUtil.toPrettyString(Object)"})
  void testToPrettyString_whenCustomer_thenReturnAString() {
    // Arrange, Act and Assert
    assertEquals("{\r\n" + "  \"additionalInfo\" : null,\r\n" + "  \"address\" : null,\r\n"
        + "  \"address2\" : null,\r\n" + "  \"city\" : null,\r\n" + "  \"country\" : null,\r\n"
        + "  \"createdTime\" : 0,\r\n" + "  \"email\" : null,\r\n" + "  \"externalId\" : null,\r\n"
        + "  \"id\" : null,\r\n" + "  \"name\" : null,\r\n" + "  \"phone\" : null,\r\n" + "  \"state\" : null,\r\n"
        + "  \"tenantId\" : null,\r\n" + "  \"title\" : null,\r\n" + "  \"version\" : null,\r\n"
        + "  \"zip\" : null\r\n" + "}", JacksonUtil.toPrettyString(new Customer()));
  }

  /**
   * Test {@link JacksonUtil#toPrettyString(Object)}.
   * <ul>
   *   <li>When {@link Dashboard#Dashboard()}.</li>
   *   <li>Then return a string.</li>
   * </ul>
   * <p>
   * Method under test: {@link JacksonUtil#toPrettyString(Object)}
   */
  @Test
  @DisplayName("Test toPrettyString(Object); when Dashboard(); then return a string")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String JacksonUtil.toPrettyString(Object)"})
  void testToPrettyString_whenDashboard_thenReturnAString() {
    // Arrange, Act and Assert
    assertEquals("{\r\n" + "  \"assignedCustomers\" : null,\r\n" + "  \"configuration\" : null,\r\n"
        + "  \"createdTime\" : 0,\r\n" + "  \"externalId\" : null,\r\n" + "  \"id\" : null,\r\n"
        + "  \"image\" : null,\r\n" + "  \"mobileHide\" : false,\r\n" + "  \"mobileOrder\" : null,\r\n"
        + "  \"name\" : null,\r\n" + "  \"tenantId\" : null,\r\n" + "  \"title\" : null,\r\n"
        + "  \"version\" : null\r\n" + "}", JacksonUtil.toPrettyString(new Dashboard()));
  }

  /**
   * Test {@link JacksonUtil#toPrettyString(Object)}.
   * <ul>
   *   <li>When {@code null}.</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link JacksonUtil#toPrettyString(Object)}
   */
  @Test
  @DisplayName("Test toPrettyString(Object); when 'null'; then return 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String JacksonUtil.toPrettyString(Object)"})
  void testToPrettyString_whenNull_thenReturnNull() {
    // Arrange, Act and Assert
    assertEquals("null", JacksonUtil.toPrettyString(null));
  }

  /**
   * Test {@link JacksonUtil#toPrettyString(Object)}.
   * <ul>
   *   <li>When {@link TenantProfile#TenantProfile()}.</li>
   *   <li>Then return a string.</li>
   * </ul>
   * <p>
   * Method under test: {@link JacksonUtil#toPrettyString(Object)}
   */
  @Test
  @DisplayName("Test toPrettyString(Object); when TenantProfile(); then return a string")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String JacksonUtil.toPrettyString(Object)"})
  void testToPrettyString_whenTenantProfile_thenReturnAString() {
    // Arrange, Act and Assert
    assertEquals(
        "{\r\n" + "  \"createdTime\" : 0,\r\n" + "  \"default\" : false,\r\n" + "  \"description\" : null,\r\n"
            + "  \"id\" : null,\r\n" + "  \"isolatedTbRuleEngine\" : false,\r\n" + "  \"name\" : null,\r\n"
            + "  \"profileData\" : {\r\n" + "    \"configuration\" : {\r\n" + "      \"type\" : \"DEFAULT\",\r\n"
            + "      \"alarmsTtlDays\" : 0,\r\n" + "      \"cassandraQueryTenantRateLimitsConfiguration\" : null,\r\n"
            + "      \"customerServerRestLimitsConfiguration\" : null,\r\n" + "      \"defaultStorageTtlDays\" : 0,\r\n"
            + "      \"edgeEventRateLimits\" : null,\r\n" + "      \"edgeEventRateLimitsPerEdge\" : null,\r\n"
            + "      \"edgeUplinkMessagesRateLimits\" : null,\r\n"
            + "      \"edgeUplinkMessagesRateLimitsPerEdge\" : null,\r\n" + "      \"maxAssets\" : 0,\r\n"
            + "      \"maxCreatedAlarms\" : 0,\r\n" + "      \"maxCustomers\" : 0,\r\n"
            + "      \"maxDPStorageDays\" : 0,\r\n" + "      \"maxDashboards\" : 0,\r\n"
            + "      \"maxDevices\" : 0,\r\n" + "      \"maxEmails\" : 0,\r\n" + "      \"maxJSExecutions\" : 0,\r\n"
            + "      \"maxOtaPackagesInBytes\" : 0,\r\n" + "      \"maxREExecutions\" : 0,\r\n"
            + "      \"maxResourceSize\" : 0,\r\n" + "      \"maxResourcesInBytes\" : 0,\r\n"
            + "      \"maxRuleChains\" : 0,\r\n" + "      \"maxRuleNodeExecutionsPerMessage\" : 0,\r\n"
            + "      \"maxSms\" : 0,\r\n" + "      \"maxTbelExecutions\" : 0,\r\n"
            + "      \"maxTransportDataPoints\" : 0,\r\n" + "      \"maxTransportMessages\" : 0,\r\n"
            + "      \"maxUsers\" : 0,\r\n" + "      \"maxWsSessionsPerCustomer\" : 0,\r\n"
            + "      \"maxWsSessionsPerPublicUser\" : 0,\r\n" + "      \"maxWsSessionsPerRegularUser\" : 0,\r\n"
            + "      \"maxWsSessionsPerTenant\" : 0,\r\n" + "      \"maxWsSubscriptionsPerCustomer\" : 0,\r\n"
            + "      \"maxWsSubscriptionsPerPublicUser\" : 0,\r\n"
            + "      \"maxWsSubscriptionsPerRegularUser\" : 0,\r\n" + "      \"maxWsSubscriptionsPerTenant\" : 0,\r\n"
            + "      \"queueStatsTtlDays\" : 0,\r\n" + "      \"rpcTtlDays\" : 0,\r\n"
            + "      \"ruleEngineExceptionsTtlDays\" : 0,\r\n" + "      \"smsEnabled\" : null,\r\n"
            + "      \"tenantEntityExportRateLimit\" : null,\r\n" + "      \"tenantEntityImportRateLimit\" : null,\r\n"
            + "      \"tenantNotificationRequestsPerRuleRateLimit\" : null,\r\n"
            + "      \"tenantNotificationRequestsRateLimit\" : null,\r\n"
            + "      \"tenantServerRestLimitsConfiguration\" : null,\r\n"
            + "      \"transportDeviceMsgRateLimit\" : null,\r\n"
            + "      \"transportDeviceTelemetryDataPointsRateLimit\" : null,\r\n"
            + "      \"transportDeviceTelemetryMsgRateLimit\" : null,\r\n"
            + "      \"transportGatewayDeviceMsgRateLimit\" : null,\r\n"
            + "      \"transportGatewayDeviceTelemetryDataPointsRateLimit\" : null,\r\n"
            + "      \"transportGatewayDeviceTelemetryMsgRateLimit\" : null,\r\n"
            + "      \"transportGatewayMsgRateLimit\" : null,\r\n"
            + "      \"transportGatewayTelemetryDataPointsRateLimit\" : null,\r\n"
            + "      \"transportGatewayTelemetryMsgRateLimit\" : null,\r\n"
            + "      \"transportTenantMsgRateLimit\" : null,\r\n"
            + "      \"transportTenantTelemetryDataPointsRateLimit\" : null,\r\n"
            + "      \"transportTenantTelemetryMsgRateLimit\" : null,\r\n" + "      \"warnThreshold\" : 0.0,\r\n"
            + "      \"wsMsgQueueLimitPerSession\" : 0,\r\n" + "      \"wsUpdatesPerSessionRateLimit\" : null\r\n"
            + "    },\r\n" + "    \"queueConfiguration\" : null\r\n" + "  }\r\n" + "}",
        JacksonUtil.toPrettyString(new TenantProfile()));
  }

  /**
   * Test {@link JacksonUtil#toPlainText(String)}.
   * <ul>
   *   <li>When {@code Data}.</li>
   *   <li>Then return {@code Data}.</li>
   * </ul>
   * <p>
   * Method under test: {@link JacksonUtil#toPlainText(String)}
   */
  @Test
  @DisplayName("Test toPlainText(String); when 'Data'; then return 'Data'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String JacksonUtil.toPlainText(String)"})
  void testToPlainText_whenData_thenReturnData() {
    // Arrange, Act and Assert
    assertEquals("Data", JacksonUtil.toPlainText("Data"));
  }

  /**
   * Test {@link JacksonUtil#toPlainText(String)}.
   * <ul>
   *   <li>When {@code "Data}.</li>
   *   <li>Then return {@code "Data}.</li>
   * </ul>
   * <p>
   * Method under test: {@link JacksonUtil#toPlainText(String)}
   */
  @Test
  @DisplayName("Test toPlainText(String); when '\"Data'; then return '\"Data'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String JacksonUtil.toPlainText(String)"})
  void testToPlainText_whenData_thenReturnData2() {
    // Arrange, Act and Assert
    assertEquals("\"Data", JacksonUtil.toPlainText("\"Data"));
  }

  /**
   * Test {@link JacksonUtil#toPlainText(String)}.
   * <ul>
   *   <li>When {@code null}.</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link JacksonUtil#toPlainText(String)}
   */
  @Test
  @DisplayName("Test toPlainText(String); when 'null'; then return 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String JacksonUtil.toPlainText(String)"})
  void testToPlainText_whenNull_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull(JacksonUtil.toPlainText(null));
  }

  /**
   * Test {@link JacksonUtil#toPlainText(String)}.
   * <ul>
   *   <li>When {@code ""}.</li>
   *   <li>Then return empty string.</li>
   * </ul>
   * <p>
   * Method under test: {@link JacksonUtil#toPlainText(String)}
   */
  @Test
  @DisplayName("Test toPlainText(String); when '\"\"'; then return empty string")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String JacksonUtil.toPlainText(String)"})
  void testToPlainText_whenQuotationMarkQuotationMark_thenReturnEmptyString() {
    // Arrange, Act and Assert
    assertEquals("", JacksonUtil.toPlainText("\"\""));
  }

  /**
   * Test {@link JacksonUtil#toPlainText(String)}.
   * <ul>
   *   <li>When {@code "}.</li>
   *   <li>Then return {@code "}.</li>
   * </ul>
   * <p>
   * Method under test: {@link JacksonUtil#toPlainText(String)}
   */
  @Test
  @DisplayName("Test toPlainText(String); when '\"'; then return '\"'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String JacksonUtil.toPlainText(String)"})
  void testToPlainText_whenQuotationMark_thenReturnQuotationMark() {
    // Arrange, Act and Assert
    assertEquals("\"", JacksonUtil.toPlainText("\""));
  }

  /**
   * Test {@link JacksonUtil#treeToValue(JsonNode, Class)}.
   * <ul>
   *   <li>Given {@code -0.5}.</li>
   *   <li>When {@link ArrayNode#ArrayNode(JsonNodeFactory)} with nf is withExactBigDecimals {@code true} add {@code -0.5}.</li>
   * </ul>
   * <p>
   * Method under test: {@link JacksonUtil#treeToValue(JsonNode, Class)}
   */
  @Test
  @DisplayName("Test treeToValue(JsonNode, Class); given '-0.5'; when ArrayNode(JsonNodeFactory) with nf is withExactBigDecimals 'true' add '-0.5'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Object JacksonUtil.treeToValue(JsonNode, Class)"})
  void testTreeToValue_given05_whenArrayNodeWithNfIsWithExactBigDecimalsTrueAdd05() {
    // Arrange
    ArrayNode node = new ArrayNode(JsonNodeFactory.withExactBigDecimals(true));
    node.add(-0.5f);
    node.add(MissingNode.getInstance());
    Class<Object> clazz = Object.class;

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> JacksonUtil.treeToValue(node, clazz));
  }

  /**
   * Test {@link JacksonUtil#treeToValue(JsonNode, Class)}.
   * <ul>
   *   <li>Given {@code AXAXAXAX} Bytes is {@code UTF-8}.</li>
   * </ul>
   * <p>
   * Method under test: {@link JacksonUtil#treeToValue(JsonNode, Class)}
   */
  @Test
  @DisplayName("Test treeToValue(JsonNode, Class); given 'AXAXAXAX' Bytes is 'UTF-8'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Object JacksonUtil.treeToValue(JsonNode, Class)"})
  void testTreeToValue_givenAxaxaxaxBytesIsUtf8() throws UnsupportedEncodingException {
    // Arrange
    ArrayNode node = new ArrayNode(JsonNodeFactory.withExactBigDecimals(true));
    node.add("AXAXAXAX".getBytes("UTF-8"));
    node.add(MissingNode.getInstance());
    Class<Object> clazz = Object.class;

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> JacksonUtil.treeToValue(node, clazz));
  }

  /**
   * Test {@link JacksonUtil#treeToValue(JsonNode, Class)}.
   * <ul>
   *   <li>Given empty string.</li>
   * </ul>
   * <p>
   * Method under test: {@link JacksonUtil#treeToValue(JsonNode, Class)}
   */
  @Test
  @DisplayName("Test treeToValue(JsonNode, Class); given empty string")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Object JacksonUtil.treeToValue(JsonNode, Class)"})
  void testTreeToValue_givenEmptyString() {
    // Arrange
    ArrayNode node = new ArrayNode(JsonNodeFactory.withExactBigDecimals(true));
    node.add("");
    node.add(MissingNode.getInstance());
    Class<Object> clazz = Object.class;

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> JacksonUtil.treeToValue(node, clazz));
  }

  /**
   * Test {@link JacksonUtil#treeToValue(JsonNode, Class)}.
   * <ul>
   *   <li>Given forty-two.</li>
   * </ul>
   * <p>
   * Method under test: {@link JacksonUtil#treeToValue(JsonNode, Class)}
   */
  @Test
  @DisplayName("Test treeToValue(JsonNode, Class); given forty-two")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Object JacksonUtil.treeToValue(JsonNode, Class)"})
  void testTreeToValue_givenFortyTwo() {
    // Arrange
    ArrayNode node = new ArrayNode(JsonNodeFactory.withExactBigDecimals(true));
    node.addPOJO(42);
    node.add(MissingNode.getInstance());
    Class<Object> clazz = Object.class;

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> JacksonUtil.treeToValue(node, clazz));
  }

  /**
   * Test {@link JacksonUtil#treeToValue(JsonNode, Class)}.
   * <ul>
   *   <li>Given Instance.</li>
   * </ul>
   * <p>
   * Method under test: {@link JacksonUtil#treeToValue(JsonNode, Class)}
   */
  @Test
  @DisplayName("Test treeToValue(JsonNode, Class); given Instance")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Object JacksonUtil.treeToValue(JsonNode, Class)"})
  void testTreeToValue_givenInstance() {
    // Arrange
    ArrayNode node = new ArrayNode(JsonNodeFactory.withExactBigDecimals(true));
    node.add(MissingNode.getInstance());
    Class<Object> clazz = Object.class;

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> JacksonUtil.treeToValue(node, clazz));
  }

  /**
   * Test {@link JacksonUtil#treeToValue(JsonNode, Class)}.
   * <ul>
   *   <li>Given {@code Pojo}.</li>
   * </ul>
   * <p>
   * Method under test: {@link JacksonUtil#treeToValue(JsonNode, Class)}
   */
  @Test
  @DisplayName("Test treeToValue(JsonNode, Class); given 'Pojo'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Object JacksonUtil.treeToValue(JsonNode, Class)"})
  void testTreeToValue_givenPojo() {
    // Arrange
    ArrayNode node = new ArrayNode(JsonNodeFactory.withExactBigDecimals(true));
    node.addPOJO("Pojo");
    node.add(MissingNode.getInstance());
    Class<Object> clazz = Object.class;

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> JacksonUtil.treeToValue(node, clazz));
  }

  /**
   * Test {@link JacksonUtil#treeToValue(JsonNode, Class)}.
   * <ul>
   *   <li>Given two.</li>
   *   <li>When {@link ArrayNode#ArrayNode(JsonNodeFactory)} with nf is withExactBigDecimals {@code true} addPOJO two.</li>
   * </ul>
   * <p>
   * Method under test: {@link JacksonUtil#treeToValue(JsonNode, Class)}
   */
  @Test
  @DisplayName("Test treeToValue(JsonNode, Class); given two; when ArrayNode(JsonNodeFactory) with nf is withExactBigDecimals 'true' addPOJO two")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Object JacksonUtil.treeToValue(JsonNode, Class)"})
  void testTreeToValue_givenTwo_whenArrayNodeWithNfIsWithExactBigDecimalsTrueAddPOJOTwo() {
    // Arrange
    ArrayNode node = new ArrayNode(JsonNodeFactory.withExactBigDecimals(true));
    node.addPOJO(2);
    node.add(MissingNode.getInstance());
    Class<Object> clazz = Object.class;

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> JacksonUtil.treeToValue(node, clazz));
  }

  /**
   * Test {@link JacksonUtil#treeToValue(JsonNode, Class)}.
   * <ul>
   *   <li>When {@link ArrayNode#ArrayNode(JsonNodeFactory)} with nf is withExactBigDecimals {@code true} addArray.</li>
   * </ul>
   * <p>
   * Method under test: {@link JacksonUtil#treeToValue(JsonNode, Class)}
   */
  @Test
  @DisplayName("Test treeToValue(JsonNode, Class); when ArrayNode(JsonNodeFactory) with nf is withExactBigDecimals 'true' addArray")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Object JacksonUtil.treeToValue(JsonNode, Class)"})
  void testTreeToValue_whenArrayNodeWithNfIsWithExactBigDecimalsTrueAddArray() {
    // Arrange
    ArrayNode node = new ArrayNode(JsonNodeFactory.withExactBigDecimals(true));
    node.addArray();
    node.add(MissingNode.getInstance());
    Class<Object> clazz = Object.class;

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> JacksonUtil.treeToValue(node, clazz));
  }

  /**
   * Test {@link JacksonUtil#treeToValue(JsonNode, Class)}.
   * <ul>
   *   <li>When {@link ArrayNode#ArrayNode(JsonNodeFactory)} with nf is withExactBigDecimals {@code true} addNull.</li>
   * </ul>
   * <p>
   * Method under test: {@link JacksonUtil#treeToValue(JsonNode, Class)}
   */
  @Test
  @DisplayName("Test treeToValue(JsonNode, Class); when ArrayNode(JsonNodeFactory) with nf is withExactBigDecimals 'true' addNull")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Object JacksonUtil.treeToValue(JsonNode, Class)"})
  void testTreeToValue_whenArrayNodeWithNfIsWithExactBigDecimalsTrueAddNull() {
    // Arrange
    ArrayNode node = new ArrayNode(JsonNodeFactory.withExactBigDecimals(true));
    node.addNull();
    node.add(MissingNode.getInstance());
    Class<Object> clazz = Object.class;

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> JacksonUtil.treeToValue(node, clazz));
  }

  /**
   * Test {@link JacksonUtil#treeToValue(JsonNode, Class)}.
   * <ul>
   *   <li>When {@link ArrayNode#ArrayNode(JsonNodeFactory)} with nf is withExactBigDecimals {@code true} addObject.</li>
   * </ul>
   * <p>
   * Method under test: {@link JacksonUtil#treeToValue(JsonNode, Class)}
   */
  @Test
  @DisplayName("Test treeToValue(JsonNode, Class); when ArrayNode(JsonNodeFactory) with nf is withExactBigDecimals 'true' addObject")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Object JacksonUtil.treeToValue(JsonNode, Class)"})
  void testTreeToValue_whenArrayNodeWithNfIsWithExactBigDecimalsTrueAddObject() {
    // Arrange
    ArrayNode node = new ArrayNode(JsonNodeFactory.withExactBigDecimals(true));
    node.addObject();
    node.add(MissingNode.getInstance());
    Class<Object> clazz = Object.class;

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> JacksonUtil.treeToValue(node, clazz));
  }

  /**
   * Test {@link JacksonUtil#treeToValue(JsonNode, Class)}.
   * <ul>
   *   <li>When {@link ArrayNode#ArrayNode(JsonNodeFactory)} with nf is withExactBigDecimals {@code true}.</li>
   *   <li>Then return {@link List}.</li>
   * </ul>
   * <p>
   * Method under test: {@link JacksonUtil#treeToValue(JsonNode, Class)}
   */
  @Test
  @DisplayName("Test treeToValue(JsonNode, Class); when ArrayNode(JsonNodeFactory) with nf is withExactBigDecimals 'true'; then return List")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Object JacksonUtil.treeToValue(JsonNode, Class)"})
  void testTreeToValue_whenArrayNodeWithNfIsWithExactBigDecimalsTrue_thenReturnList() {
    // Arrange
    ArrayNode node = new ArrayNode(JsonNodeFactory.withExactBigDecimals(true));
    Class<Object> clazz = Object.class;

    // Act
    Object actualTreeToValueResult = JacksonUtil.treeToValue(node, clazz);

    // Assert
    assertTrue(actualTreeToValueResult instanceof List);
    assertTrue(((List<Object>) actualTreeToValueResult).isEmpty());
  }

  /**
   * Test {@link JacksonUtil#treeToValue(JsonNode, Class)}.
   * <ul>
   *   <li>When {@link BigIntegerNode#BigIntegerNode(BigInteger)} with v is valueOf one.</li>
   *   <li>Then return {@link BigInteger}.</li>
   * </ul>
   * <p>
   * Method under test: {@link JacksonUtil#treeToValue(JsonNode, Class)}
   */
  @Test
  @DisplayName("Test treeToValue(JsonNode, Class); when BigIntegerNode(BigInteger) with v is valueOf one; then return BigInteger")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Object JacksonUtil.treeToValue(JsonNode, Class)"})
  void testTreeToValue_whenBigIntegerNodeWithVIsValueOfOne_thenReturnBigInteger() {
    // Arrange
    BigIntegerNode node = new BigIntegerNode(BigInteger.valueOf(1L));
    Class<Object> clazz = Object.class;

    // Act
    Object actualTreeToValueResult = JacksonUtil.treeToValue(node, clazz);

    // Assert
    assertTrue(actualTreeToValueResult instanceof BigInteger);
    assertEquals("1", actualTreeToValueResult.toString());
    assertEquals(0, ((BigInteger) actualTreeToValueResult).getLowestSetBit());
    assertEquals(1, ((BigInteger) actualTreeToValueResult).signum());
    assertArrayEquals(new byte[]{1}, ((BigInteger) actualTreeToValueResult).toByteArray());
  }

  /**
   * Test {@link JacksonUtil#treeToValue(JsonNode, Class)}.
   * <ul>
   *   <li>When {@code JsonMapper$Builder}.</li>
   * </ul>
   * <p>
   * Method under test: {@link JacksonUtil#treeToValue(JsonNode, Class)}
   */
  @Test
  @DisplayName("Test treeToValue(JsonNode, Class); when 'com.fasterxml.jackson.databind.json.JsonMapper$Builder'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Object JacksonUtil.treeToValue(JsonNode, Class)"})
  void testTreeToValue_whenComFasterxmlJacksonDatabindJsonJsonMapperBuilder() {
    // Arrange
    MissingNode node = MissingNode.getInstance();
    Class<Builder> clazz = Builder.class;

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> JacksonUtil.treeToValue(node, clazz));
  }

  /**
   * Test {@link JacksonUtil#treeToValue(JsonNode, Class)}.
   * <ul>
   *   <li>When False.</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link JacksonUtil#treeToValue(JsonNode, Class)}
   */
  @Test
  @DisplayName("Test treeToValue(JsonNode, Class); when False; then return 'false'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Object JacksonUtil.treeToValue(JsonNode, Class)"})
  void testTreeToValue_whenFalse_thenReturnFalse() {
    // Arrange
    BooleanNode node = BooleanNode.getFalse();
    Class<Object> clazz = Object.class;

    // Act and Assert
    assertFalse((Boolean) JacksonUtil.treeToValue(node, clazz));
  }

  /**
   * Test {@link JacksonUtil#treeToValue(JsonNode, Class)}.
   * <ul>
   *   <li>When Instance.</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link JacksonUtil#treeToValue(JsonNode, Class)}
   */
  @Test
  @DisplayName("Test treeToValue(JsonNode, Class); when Instance; then return 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Object JacksonUtil.treeToValue(JsonNode, Class)"})
  void testTreeToValue_whenInstance_thenReturnNull() {
    // Arrange
    NullNode node = NullNode.getInstance();
    Class<Object> clazz = Object.class;

    // Act and Assert
    assertNull(JacksonUtil.treeToValue(node, clazz));
  }

  /**
   * Test {@link JacksonUtil#treeToValue(JsonNode, Class)}.
   * <ul>
   *   <li>When Instance.</li>
   *   <li>Then throw {@link IllegalArgumentException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link JacksonUtil#treeToValue(JsonNode, Class)}
   */
  @Test
  @DisplayName("Test treeToValue(JsonNode, Class); when Instance; then throw IllegalArgumentException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Object JacksonUtil.treeToValue(JsonNode, Class)"})
  void testTreeToValue_whenInstance_thenThrowIllegalArgumentException() {
    // Arrange
    MissingNode node = MissingNode.getInstance();
    Class<Object> clazz = Object.class;

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> JacksonUtil.treeToValue(node, clazz));
  }

  /**
   * Test {@link JacksonUtil#treeToValue(JsonNode, Class)}.
   * <ul>
   *   <li>When {@code String}.</li>
   *   <li>Then throw {@link IllegalArgumentException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link JacksonUtil#treeToValue(JsonNode, Class)}
   */
  @Test
  @DisplayName("Test treeToValue(JsonNode, Class); when 'java.lang.String'; then throw IllegalArgumentException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Object JacksonUtil.treeToValue(JsonNode, Class)"})
  void testTreeToValue_whenJavaLangString_thenThrowIllegalArgumentException() {
    // Arrange
    MissingNode node = MissingNode.getInstance();
    Class<String> clazz = String.class;

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> JacksonUtil.treeToValue(node, clazz));
  }

  /**
   * Test {@link JacksonUtil#treeToValue(JsonNode, Class)}.
   * <ul>
   *   <li>When {@code null}.</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link JacksonUtil#treeToValue(JsonNode, Class)}
   */
  @Test
  @DisplayName("Test treeToValue(JsonNode, Class); when 'null'; then return 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Object JacksonUtil.treeToValue(JsonNode, Class)"})
  void testTreeToValue_whenNull_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull(JacksonUtil.treeToValue(null, null));
  }

  /**
   * Test {@link JacksonUtil#treeToValue(JsonNode, Class)}.
   * <ul>
   *   <li>When {@link POJONode#POJONode(Object)} with v is {@code 42}.</li>
   *   <li>Then return {@code 42}.</li>
   * </ul>
   * <p>
   * Method under test: {@link JacksonUtil#treeToValue(JsonNode, Class)}
   */
  @Test
  @DisplayName("Test treeToValue(JsonNode, Class); when POJONode(Object) with v is '42'; then return '42'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Object JacksonUtil.treeToValue(JsonNode, Class)"})
  void testTreeToValue_whenPOJONodeWithVIs42_thenReturn42() {
    // Arrange
    POJONode node = new POJONode("42");
    Class<Object> clazz = Object.class;

    // Act and Assert
    assertEquals("42", JacksonUtil.treeToValue(node, clazz));
  }

  /**
   * Test {@link JacksonUtil#treeToValue(JsonNode, Class)}.
   * <ul>
   *   <li>When {@link POJONode#POJONode(Object)} with v is {@code null}.</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link JacksonUtil#treeToValue(JsonNode, Class)}
   */
  @Test
  @DisplayName("Test treeToValue(JsonNode, Class); when POJONode(Object) with v is 'null'; then return 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Object JacksonUtil.treeToValue(JsonNode, Class)"})
  void testTreeToValue_whenPOJONodeWithVIsNull_thenReturnNull() {
    // Arrange
    POJONode node = new POJONode(null);
    Class<Object> clazz = Object.class;

    // Act and Assert
    assertNull(JacksonUtil.treeToValue(node, clazz));
  }

  /**
   * Test {@link JacksonUtil#treeToValue(JsonNode, Class)}.
   * <ul>
   *   <li>When True.</li>
   *   <li>Then return {@code true}.</li>
   * </ul>
   * <p>
   * Method under test: {@link JacksonUtil#treeToValue(JsonNode, Class)}
   */
  @Test
  @DisplayName("Test treeToValue(JsonNode, Class); when True; then return 'true'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Object JacksonUtil.treeToValue(JsonNode, Class)"})
  void testTreeToValue_whenTrue_thenReturnTrue() {
    // Arrange
    BooleanNode node = BooleanNode.getTrue();
    Class<Object> clazz = Object.class;

    // Act and Assert
    assertTrue((Boolean) JacksonUtil.treeToValue(node, clazz));
  }

  /**
   * Test {@link JacksonUtil#treeToValue(JsonNode, Class)}.
   * <ul>
   *   <li>When valueOf ten.</li>
   *   <li>Then return doubleValue is ten.</li>
   * </ul>
   * <p>
   * Method under test: {@link JacksonUtil#treeToValue(JsonNode, Class)}
   */
  @Test
  @DisplayName("Test treeToValue(JsonNode, Class); when valueOf ten; then return doubleValue is ten")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Object JacksonUtil.treeToValue(JsonNode, Class)"})
  void testTreeToValue_whenValueOfTen_thenReturnDoubleValueIsTen() {
    // Arrange
    DoubleNode node = DoubleNode.valueOf(10.0d);
    Class<Object> clazz = Object.class;

    // Act and Assert
    assertEquals(10.0d, ((Double) JacksonUtil.treeToValue(node, clazz)).doubleValue());
  }

  /**
   * Test {@link JacksonUtil#treeToValue(JsonNode, Class)}.
   * <ul>
   *   <li>When valueOf ten.</li>
   *   <li>Then return floatValue is ten.</li>
   * </ul>
   * <p>
   * Method under test: {@link JacksonUtil#treeToValue(JsonNode, Class)}
   */
  @Test
  @DisplayName("Test treeToValue(JsonNode, Class); when valueOf ten; then return floatValue is ten")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Object JacksonUtil.treeToValue(JsonNode, Class)"})
  void testTreeToValue_whenValueOfTen_thenReturnFloatValueIsTen() {
    // Arrange
    FloatNode node = FloatNode.valueOf(10.0f);
    Class<Object> clazz = Object.class;

    // Act and Assert
    assertEquals(10.0f, ((Float) JacksonUtil.treeToValue(node, clazz)).floatValue());
  }

  /**
   * Test {@link JacksonUtil#toJsonNode(File)} with {@code File}.
   * <ul>
   *   <li>Then throw {@link IllegalArgumentException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link JacksonUtil#toJsonNode(File)}
   */
  @Test
  @DisplayName("Test toJsonNode(File) with 'File'; then throw IllegalArgumentException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"JsonNode JacksonUtil.toJsonNode(File)"})
  void testToJsonNodeWithFile_thenThrowIllegalArgumentException() {
    // Arrange, Act and Assert
    assertThrows(IllegalArgumentException.class,
        () -> JacksonUtil.toJsonNode(Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toFile()));
  }

  /**
   * Test {@link JacksonUtil#toJsonNode(File)} with {@code File}.
   * <ul>
   *   <li>When {@code null}.</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link JacksonUtil#toJsonNode(File)}
   */
  @Test
  @DisplayName("Test toJsonNode(File) with 'File'; when 'null'; then return 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"JsonNode JacksonUtil.toJsonNode(File)"})
  void testToJsonNodeWithFile_whenNull_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull(JacksonUtil.toJsonNode((File) null));
  }

  /**
   * Test {@link JacksonUtil#toJsonNode(InputStream)} with {@code InputStream}.
   * <p>
   * Method under test: {@link JacksonUtil#toJsonNode(InputStream)}
   */
  @Test
  @DisplayName("Test toJsonNode(InputStream) with 'InputStream'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"JsonNode JacksonUtil.toJsonNode(InputStream)"})
  void testToJsonNodeWithInputStream() {
    // Arrange, Act and Assert
    assertThrows(IllegalArgumentException.class,
        () -> JacksonUtil.toJsonNode(new ByteArrayInputStream(new byte[]{0, 'X', 'A', 'X', 'A', 'X', 'A', 'X'})));
  }

  /**
   * Test {@link JacksonUtil#toJsonNode(InputStream)} with {@code InputStream}.
   * <p>
   * Method under test: {@link JacksonUtil#toJsonNode(InputStream)}
   */
  @Test
  @DisplayName("Test toJsonNode(InputStream) with 'InputStream'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"JsonNode JacksonUtil.toJsonNode(InputStream)"})
  void testToJsonNodeWithInputStream2() {
    // Arrange, Act and Assert
    assertThrows(IllegalArgumentException.class, () -> JacksonUtil
        .toJsonNode(new ByteArrayInputStream(new byte[]{Byte.MAX_VALUE, 'X', 'A', 'X', 'A', 'X', 'A', 'X'})));
  }

  /**
   * Test {@link JacksonUtil#toJsonNode(InputStream)} with {@code InputStream}.
   * <p>
   * Method under test: {@link JacksonUtil#toJsonNode(InputStream)}
   */
  @Test
  @DisplayName("Test toJsonNode(InputStream) with 'InputStream'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"JsonNode JacksonUtil.toJsonNode(InputStream)"})
  void testToJsonNodeWithInputStream3() {
    // Arrange, Act and Assert
    assertThrows(IllegalArgumentException.class,
        () -> JacksonUtil.toJsonNode(new ByteArrayInputStream(new byte[]{'A', -1, 'A', 'X', 'A', 'X', 'A', 'X'})));
  }

  /**
   * Test {@link JacksonUtil#toJsonNode(InputStream)} with {@code InputStream}.
   * <ul>
   *   <li>Given one.</li>
   *   <li>Then calls {@link FilterInputStream#close()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link JacksonUtil#toJsonNode(InputStream)}
   */
  @Test
  @DisplayName("Test toJsonNode(InputStream) with 'InputStream'; given one; then calls close()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"JsonNode JacksonUtil.toJsonNode(InputStream)"})
  void testToJsonNodeWithInputStream_givenOne_thenCallsClose() throws IOException {
    // Arrange
    DataInputStream value = mock(DataInputStream.class);
    when(value.read(Mockito.<byte[]>any(), anyInt(), anyInt())).thenReturn(1);
    doNothing().when(value).close();

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> JacksonUtil.toJsonNode(value));
    verify(value, atLeast(1)).read(isA(byte[].class), anyInt(), anyInt());
    verify(value).close();
  }

  /**
   * Test {@link JacksonUtil#toJsonNode(InputStream)} with {@code InputStream}.
   * <ul>
   *   <li>Then return {@link MissingNode}.</li>
   * </ul>
   * <p>
   * Method under test: {@link JacksonUtil#toJsonNode(InputStream)}
   */
  @Test
  @DisplayName("Test toJsonNode(InputStream) with 'InputStream'; then return MissingNode")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"JsonNode JacksonUtil.toJsonNode(InputStream)"})
  void testToJsonNodeWithInputStream_thenReturnMissingNode() {
    // Arrange and Act
    JsonNode actualToJsonNodeResult = JacksonUtil.toJsonNode(new ByteArrayInputStream(new byte[]{}));

    // Assert
    assertTrue(actualToJsonNodeResult instanceof MissingNode);
    assertTrue(actualToJsonNodeResult.traverse() instanceof TreeTraversingParser);
    assertEquals("", actualToJsonNodeResult.toPrettyString());
    assertEquals(0, actualToJsonNodeResult.size());
    assertEquals(JsonNodeType.MISSING, actualToJsonNodeResult.getNodeType());
    assertFalse(actualToJsonNodeResult.isArray());
    assertFalse(actualToJsonNodeResult.isBigDecimal());
    assertFalse(actualToJsonNodeResult.isBigInteger());
    assertFalse(actualToJsonNodeResult.isBinary());
    assertFalse(actualToJsonNodeResult.isBoolean());
    assertFalse(actualToJsonNodeResult.isContainerNode());
    assertFalse(actualToJsonNodeResult.isDouble());
    assertFalse(actualToJsonNodeResult.isFloat());
    assertFalse(actualToJsonNodeResult.isFloatingPointNumber());
    assertFalse(actualToJsonNodeResult.isInt());
    assertFalse(actualToJsonNodeResult.isIntegralNumber());
    assertFalse(actualToJsonNodeResult.isLong());
    assertFalse(actualToJsonNodeResult.isNull());
    assertFalse(actualToJsonNodeResult.isNumber());
    assertFalse(actualToJsonNodeResult.isObject());
    assertFalse(actualToJsonNodeResult.isPojo());
    assertFalse(actualToJsonNodeResult.isShort());
    assertFalse(actualToJsonNodeResult.isTextual());
    assertFalse(actualToJsonNodeResult.isValueNode());
    assertFalse(actualToJsonNodeResult.iterator().hasNext());
    assertTrue(actualToJsonNodeResult.isEmpty());
    assertTrue(actualToJsonNodeResult.isMissingNode());
  }

  /**
   * Test {@link JacksonUtil#toJsonNode(InputStream)} with {@code InputStream}.
   * <ul>
   *   <li>Then throw {@link RuntimeException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link JacksonUtil#toJsonNode(InputStream)}
   */
  @Test
  @DisplayName("Test toJsonNode(InputStream) with 'InputStream'; then throw RuntimeException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"JsonNode JacksonUtil.toJsonNode(InputStream)"})
  void testToJsonNodeWithInputStream_thenThrowRuntimeException() throws IOException {
    // Arrange
    DataInputStream value = mock(DataInputStream.class);
    when(value.read(Mockito.<byte[]>any(), anyInt(), anyInt())).thenThrow(new RuntimeException("foo"));

    // Act and Assert
    assertThrows(RuntimeException.class, () -> JacksonUtil.toJsonNode(value));
    verify(value).read(isA(byte[].class), eq(0), eq(8000));
  }

  /**
   * Test {@link JacksonUtil#toJsonNode(InputStream)} with {@code InputStream}.
   * <ul>
   *   <li>When {@link ByteArrayInputStream#ByteArrayInputStream(byte[])} with {@code AXAXAXAX} Bytes is {@code UTF-8}.</li>
   * </ul>
   * <p>
   * Method under test: {@link JacksonUtil#toJsonNode(InputStream)}
   */
  @Test
  @DisplayName("Test toJsonNode(InputStream) with 'InputStream'; when ByteArrayInputStream(byte[]) with 'AXAXAXAX' Bytes is 'UTF-8'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"JsonNode JacksonUtil.toJsonNode(InputStream)"})
  void testToJsonNodeWithInputStream_whenByteArrayInputStreamWithAxaxaxaxBytesIsUtf8()
      throws UnsupportedEncodingException {
    // Arrange, Act and Assert
    assertThrows(IllegalArgumentException.class,
        () -> JacksonUtil.toJsonNode(new ByteArrayInputStream("AXAXAXAX".getBytes("UTF-8"))));
  }

  /**
   * Test {@link JacksonUtil#toJsonNode(InputStream)} with {@code InputStream}.
   * <ul>
   *   <li>When {@code null}.</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link JacksonUtil#toJsonNode(InputStream)}
   */
  @Test
  @DisplayName("Test toJsonNode(InputStream) with 'InputStream'; when 'null'; then return 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"JsonNode JacksonUtil.toJsonNode(InputStream)"})
  void testToJsonNodeWithInputStream_whenNull_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull(JacksonUtil.toJsonNode((InputStream) null));
  }

  /**
   * Test {@link JacksonUtil#toJsonNode(Path)} with {@code Path}.
   * <ul>
   *   <li>Then throw {@link IllegalArgumentException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link JacksonUtil#toJsonNode(Path)}
   */
  @Test
  @DisplayName("Test toJsonNode(Path) with 'Path'; then throw IllegalArgumentException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"JsonNode JacksonUtil.toJsonNode(Path)"})
  void testToJsonNodeWithPath_thenThrowIllegalArgumentException() {
    // Arrange, Act and Assert
    assertThrows(IllegalArgumentException.class,
        () -> JacksonUtil.toJsonNode(Paths.get(System.getProperty("java.io.tmpdir"), "test.txt")));
  }

  /**
   * Test {@link JacksonUtil#toJsonNode(String, ObjectMapper)} with {@code String}, {@code ObjectMapper}.
   * <p>
   * Method under test: {@link JacksonUtil#toJsonNode(String, ObjectMapper)}
   */
  @Test
  @DisplayName("Test toJsonNode(String, ObjectMapper) with 'String', 'ObjectMapper'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"JsonNode JacksonUtil.toJsonNode(String, ObjectMapper)"})
  void testToJsonNodeWithStringObjectMapper() {
    // Arrange
    CacheProvider cacheProvider = mock(CacheProvider.class);
    when(cacheProvider.forDeserializerCache(Mockito.<DeserializationConfig>any())).thenReturn(new LRUMap<>(1, 0));
    when(cacheProvider.forSerializerCache(Mockito.<SerializationConfig>any())).thenReturn(new LRUMap<>(1, 3));
    when(cacheProvider.forTypeFactory()).thenReturn(new LRUMap<>(1, 3));
    Builder builderResult = JsonMapper.builder();
    builderResult.cacheProvider(cacheProvider);

    // Act
    JsonNode actualToJsonNodeResult = JacksonUtil.toJsonNode("42", builderResult.findAndAddModules().build());

    // Assert
    verify(cacheProvider).forDeserializerCache(isNull());
    verify(cacheProvider).forSerializerCache(isNull());
    verify(cacheProvider).forTypeFactory();
    assertTrue(actualToJsonNodeResult instanceof IntNode);
    assertTrue(actualToJsonNodeResult.traverse() instanceof TreeTraversingParser);
    assertEquals("42", actualToJsonNodeResult.toPrettyString());
    assertEquals(0, actualToJsonNodeResult.size());
    assertEquals(JsonNodeType.NUMBER, actualToJsonNodeResult.getNodeType());
    assertFalse(actualToJsonNodeResult.isArray());
    assertFalse(actualToJsonNodeResult.isBigDecimal());
    assertFalse(actualToJsonNodeResult.isBigInteger());
    assertFalse(actualToJsonNodeResult.isBinary());
    assertFalse(actualToJsonNodeResult.isBoolean());
    assertFalse(actualToJsonNodeResult.isContainerNode());
    assertFalse(actualToJsonNodeResult.isDouble());
    assertFalse(actualToJsonNodeResult.isFloat());
    assertFalse(actualToJsonNodeResult.isFloatingPointNumber());
    assertFalse(actualToJsonNodeResult.isLong());
    assertFalse(actualToJsonNodeResult.isMissingNode());
    assertFalse(actualToJsonNodeResult.isNull());
    assertFalse(actualToJsonNodeResult.isObject());
    assertFalse(actualToJsonNodeResult.isPojo());
    assertFalse(actualToJsonNodeResult.isShort());
    assertFalse(actualToJsonNodeResult.isTextual());
    assertFalse(((IntNode) actualToJsonNodeResult).isNaN());
    assertFalse(actualToJsonNodeResult.iterator().hasNext());
    assertTrue(actualToJsonNodeResult.isEmpty());
    assertTrue(actualToJsonNodeResult.isInt());
    assertTrue(actualToJsonNodeResult.isIntegralNumber());
    assertTrue(actualToJsonNodeResult.isNumber());
    assertTrue(actualToJsonNodeResult.isValueNode());
  }

  /**
   * Test {@link JacksonUtil#toJsonNode(String, ObjectMapper)} with {@code String}, {@code ObjectMapper}.
   * <p>
   * Method under test: {@link JacksonUtil#toJsonNode(String, ObjectMapper)}
   */
  @Test
  @DisplayName("Test toJsonNode(String, ObjectMapper) with 'String', 'ObjectMapper'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"JsonNode JacksonUtil.toJsonNode(String, ObjectMapper)"})
  void testToJsonNodeWithStringObjectMapper2() {
    // Arrange
    CacheProvider cacheProvider = mock(CacheProvider.class);
    when(cacheProvider.forDeserializerCache(Mockito.<DeserializationConfig>any())).thenReturn(new LRUMap<>(1, 3));
    when(cacheProvider.forSerializerCache(Mockito.<SerializationConfig>any())).thenReturn(new LRUMap<>(1, 3));
    when(cacheProvider.forTypeFactory()).thenReturn(new LRUMap<>(1, 3));
    Builder builderResult = JsonMapper.builder();
    builderResult.setDefaultTyping(
        DefaultTypeResolverBuilder.construct(DefaultTyping.JAVA_LANG_OBJECT, new DefaultBaseTypeLimitingValidator()));
    builderResult.cacheProvider(cacheProvider);

    // Act
    JsonNode actualToJsonNodeResult = JacksonUtil.toJsonNode("42", builderResult.findAndAddModules().build());

    // Assert
    verify(cacheProvider).forDeserializerCache(isNull());
    verify(cacheProvider).forSerializerCache(isNull());
    verify(cacheProvider).forTypeFactory();
    assertTrue(actualToJsonNodeResult instanceof IntNode);
    assertTrue(actualToJsonNodeResult.traverse() instanceof TreeTraversingParser);
    assertEquals("42", actualToJsonNodeResult.toPrettyString());
    assertEquals(0, actualToJsonNodeResult.size());
    assertEquals(JsonNodeType.NUMBER, actualToJsonNodeResult.getNodeType());
    assertFalse(actualToJsonNodeResult.isArray());
    assertFalse(actualToJsonNodeResult.isBigDecimal());
    assertFalse(actualToJsonNodeResult.isBigInteger());
    assertFalse(actualToJsonNodeResult.isBinary());
    assertFalse(actualToJsonNodeResult.isBoolean());
    assertFalse(actualToJsonNodeResult.isContainerNode());
    assertFalse(actualToJsonNodeResult.isDouble());
    assertFalse(actualToJsonNodeResult.isFloat());
    assertFalse(actualToJsonNodeResult.isFloatingPointNumber());
    assertFalse(actualToJsonNodeResult.isLong());
    assertFalse(actualToJsonNodeResult.isMissingNode());
    assertFalse(actualToJsonNodeResult.isNull());
    assertFalse(actualToJsonNodeResult.isObject());
    assertFalse(actualToJsonNodeResult.isPojo());
    assertFalse(actualToJsonNodeResult.isShort());
    assertFalse(actualToJsonNodeResult.isTextual());
    assertFalse(((IntNode) actualToJsonNodeResult).isNaN());
    assertFalse(actualToJsonNodeResult.iterator().hasNext());
    assertTrue(actualToJsonNodeResult.isEmpty());
    assertTrue(actualToJsonNodeResult.isInt());
    assertTrue(actualToJsonNodeResult.isIntegralNumber());
    assertTrue(actualToJsonNodeResult.isNumber());
    assertTrue(actualToJsonNodeResult.isValueNode());
  }

  /**
   * Test {@link JacksonUtil#toJsonNode(String, ObjectMapper)} with {@code String}, {@code ObjectMapper}.
   * <p>
   * Method under test: {@link JacksonUtil#toJsonNode(String, ObjectMapper)}
   */
  @Test
  @DisplayName("Test toJsonNode(String, ObjectMapper) with 'String', 'ObjectMapper'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"JsonNode JacksonUtil.toJsonNode(String, ObjectMapper)"})
  void testToJsonNodeWithStringObjectMapper3() {
    // Arrange
    CacheProvider cacheProvider = mock(CacheProvider.class);
    when(cacheProvider.forDeserializerCache(Mockito.<DeserializationConfig>any())).thenReturn(new LRUMap<>(1, 3));
    when(cacheProvider.forSerializerCache(Mockito.<SerializationConfig>any())).thenReturn(new LRUMap<>(1, 3));
    when(cacheProvider.forTypeFactory()).thenReturn(new LRUMap<>(1, 3));
    Builder builderResult = JsonMapper.builder();
    builderResult.setDefaultTyping(DefaultTypeResolverBuilder.construct(DefaultTyping.OBJECT_AND_NON_CONCRETE,
        new DefaultBaseTypeLimitingValidator()));
    builderResult.cacheProvider(cacheProvider);

    // Act
    JsonNode actualToJsonNodeResult = JacksonUtil.toJsonNode("42", builderResult.findAndAddModules().build());

    // Assert
    verify(cacheProvider).forDeserializerCache(isNull());
    verify(cacheProvider).forSerializerCache(isNull());
    verify(cacheProvider).forTypeFactory();
    assertTrue(actualToJsonNodeResult instanceof IntNode);
    assertTrue(actualToJsonNodeResult.traverse() instanceof TreeTraversingParser);
    assertEquals("42", actualToJsonNodeResult.toPrettyString());
    assertEquals(0, actualToJsonNodeResult.size());
    assertEquals(JsonNodeType.NUMBER, actualToJsonNodeResult.getNodeType());
    assertFalse(actualToJsonNodeResult.isArray());
    assertFalse(actualToJsonNodeResult.isBigDecimal());
    assertFalse(actualToJsonNodeResult.isBigInteger());
    assertFalse(actualToJsonNodeResult.isBinary());
    assertFalse(actualToJsonNodeResult.isBoolean());
    assertFalse(actualToJsonNodeResult.isContainerNode());
    assertFalse(actualToJsonNodeResult.isDouble());
    assertFalse(actualToJsonNodeResult.isFloat());
    assertFalse(actualToJsonNodeResult.isFloatingPointNumber());
    assertFalse(actualToJsonNodeResult.isLong());
    assertFalse(actualToJsonNodeResult.isMissingNode());
    assertFalse(actualToJsonNodeResult.isNull());
    assertFalse(actualToJsonNodeResult.isObject());
    assertFalse(actualToJsonNodeResult.isPojo());
    assertFalse(actualToJsonNodeResult.isShort());
    assertFalse(actualToJsonNodeResult.isTextual());
    assertFalse(((IntNode) actualToJsonNodeResult).isNaN());
    assertFalse(actualToJsonNodeResult.iterator().hasNext());
    assertTrue(actualToJsonNodeResult.isEmpty());
    assertTrue(actualToJsonNodeResult.isInt());
    assertTrue(actualToJsonNodeResult.isIntegralNumber());
    assertTrue(actualToJsonNodeResult.isNumber());
    assertTrue(actualToJsonNodeResult.isValueNode());
  }

  /**
   * Test {@link JacksonUtil#toJsonNode(String, ObjectMapper)} with {@code String}, {@code ObjectMapper}.
   * <p>
   * Method under test: {@link JacksonUtil#toJsonNode(String, ObjectMapper)}
   */
  @Test
  @DisplayName("Test toJsonNode(String, ObjectMapper) with 'String', 'ObjectMapper'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"JsonNode JacksonUtil.toJsonNode(String, ObjectMapper)"})
  void testToJsonNodeWithStringObjectMapper4() {
    // Arrange
    CacheProvider cacheProvider = mock(CacheProvider.class);
    when(cacheProvider.forDeserializerCache(Mockito.<DeserializationConfig>any())).thenReturn(new LRUMap<>(1, 3));
    when(cacheProvider.forSerializerCache(Mockito.<SerializationConfig>any())).thenReturn(new LRUMap<>(1, 3));
    when(cacheProvider.forTypeFactory()).thenReturn(new LRUMap<>(1, 3));
    Builder builderResult = JsonMapper.builder();
    builderResult.setDefaultTyping(DefaultTypeResolverBuilder.construct(DefaultTyping.NON_CONCRETE_AND_ARRAYS,
        new DefaultBaseTypeLimitingValidator()));
    builderResult.cacheProvider(cacheProvider);

    // Act
    JsonNode actualToJsonNodeResult = JacksonUtil.toJsonNode("42", builderResult.findAndAddModules().build());

    // Assert
    verify(cacheProvider).forDeserializerCache(isNull());
    verify(cacheProvider).forSerializerCache(isNull());
    verify(cacheProvider).forTypeFactory();
    assertTrue(actualToJsonNodeResult instanceof IntNode);
    assertTrue(actualToJsonNodeResult.traverse() instanceof TreeTraversingParser);
    assertEquals("42", actualToJsonNodeResult.toPrettyString());
    assertEquals(0, actualToJsonNodeResult.size());
    assertEquals(JsonNodeType.NUMBER, actualToJsonNodeResult.getNodeType());
    assertFalse(actualToJsonNodeResult.isArray());
    assertFalse(actualToJsonNodeResult.isBigDecimal());
    assertFalse(actualToJsonNodeResult.isBigInteger());
    assertFalse(actualToJsonNodeResult.isBinary());
    assertFalse(actualToJsonNodeResult.isBoolean());
    assertFalse(actualToJsonNodeResult.isContainerNode());
    assertFalse(actualToJsonNodeResult.isDouble());
    assertFalse(actualToJsonNodeResult.isFloat());
    assertFalse(actualToJsonNodeResult.isFloatingPointNumber());
    assertFalse(actualToJsonNodeResult.isLong());
    assertFalse(actualToJsonNodeResult.isMissingNode());
    assertFalse(actualToJsonNodeResult.isNull());
    assertFalse(actualToJsonNodeResult.isObject());
    assertFalse(actualToJsonNodeResult.isPojo());
    assertFalse(actualToJsonNodeResult.isShort());
    assertFalse(actualToJsonNodeResult.isTextual());
    assertFalse(((IntNode) actualToJsonNodeResult).isNaN());
    assertFalse(actualToJsonNodeResult.iterator().hasNext());
    assertTrue(actualToJsonNodeResult.isEmpty());
    assertTrue(actualToJsonNodeResult.isInt());
    assertTrue(actualToJsonNodeResult.isIntegralNumber());
    assertTrue(actualToJsonNodeResult.isNumber());
    assertTrue(actualToJsonNodeResult.isValueNode());
  }

  /**
   * Test {@link JacksonUtil#toJsonNode(String, ObjectMapper)} with {@code String}, {@code ObjectMapper}.
   * <p>
   * Method under test: {@link JacksonUtil#toJsonNode(String, ObjectMapper)}
   */
  @Test
  @DisplayName("Test toJsonNode(String, ObjectMapper) with 'String', 'ObjectMapper'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"JsonNode JacksonUtil.toJsonNode(String, ObjectMapper)"})
  void testToJsonNodeWithStringObjectMapper5() {
    // Arrange
    CacheProvider cacheProvider = mock(CacheProvider.class);
    when(cacheProvider.forDeserializerCache(Mockito.<DeserializationConfig>any())).thenReturn(new LRUMap<>(1, 3));
    when(cacheProvider.forSerializerCache(Mockito.<SerializationConfig>any())).thenReturn(new LRUMap<>(1, 3));
    when(cacheProvider.forTypeFactory()).thenReturn(new LRUMap<>(1, 3));
    Builder builderResult = JsonMapper.builder();
    builderResult.setDefaultTyping(
        DefaultTypeResolverBuilder.construct(DefaultTyping.NON_FINAL, new DefaultBaseTypeLimitingValidator()));
    builderResult.cacheProvider(cacheProvider);

    // Act
    JsonNode actualToJsonNodeResult = JacksonUtil.toJsonNode("42", builderResult.findAndAddModules().build());

    // Assert
    verify(cacheProvider).forDeserializerCache(isNull());
    verify(cacheProvider).forSerializerCache(isNull());
    verify(cacheProvider).forTypeFactory();
    assertTrue(actualToJsonNodeResult instanceof IntNode);
    assertTrue(actualToJsonNodeResult.traverse() instanceof TreeTraversingParser);
    assertEquals("42", actualToJsonNodeResult.toPrettyString());
    assertEquals(0, actualToJsonNodeResult.size());
    assertEquals(JsonNodeType.NUMBER, actualToJsonNodeResult.getNodeType());
    assertFalse(actualToJsonNodeResult.isArray());
    assertFalse(actualToJsonNodeResult.isBigDecimal());
    assertFalse(actualToJsonNodeResult.isBigInteger());
    assertFalse(actualToJsonNodeResult.isBinary());
    assertFalse(actualToJsonNodeResult.isBoolean());
    assertFalse(actualToJsonNodeResult.isContainerNode());
    assertFalse(actualToJsonNodeResult.isDouble());
    assertFalse(actualToJsonNodeResult.isFloat());
    assertFalse(actualToJsonNodeResult.isFloatingPointNumber());
    assertFalse(actualToJsonNodeResult.isLong());
    assertFalse(actualToJsonNodeResult.isMissingNode());
    assertFalse(actualToJsonNodeResult.isNull());
    assertFalse(actualToJsonNodeResult.isObject());
    assertFalse(actualToJsonNodeResult.isPojo());
    assertFalse(actualToJsonNodeResult.isShort());
    assertFalse(actualToJsonNodeResult.isTextual());
    assertFalse(((IntNode) actualToJsonNodeResult).isNaN());
    assertFalse(actualToJsonNodeResult.iterator().hasNext());
    assertTrue(actualToJsonNodeResult.isEmpty());
    assertTrue(actualToJsonNodeResult.isInt());
    assertTrue(actualToJsonNodeResult.isIntegralNumber());
    assertTrue(actualToJsonNodeResult.isNumber());
    assertTrue(actualToJsonNodeResult.isValueNode());
  }

  /**
   * Test {@link JacksonUtil#toJsonNode(String, ObjectMapper)} with {@code String}, {@code ObjectMapper}.
   * <p>
   * Method under test: {@link JacksonUtil#toJsonNode(String, ObjectMapper)}
   */
  @Test
  @DisplayName("Test toJsonNode(String, ObjectMapper) with 'String', 'ObjectMapper'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"JsonNode JacksonUtil.toJsonNode(String, ObjectMapper)"})
  void testToJsonNodeWithStringObjectMapper6() {
    // Arrange
    CacheProvider cacheProvider = mock(CacheProvider.class);
    when(cacheProvider.forDeserializerCache(Mockito.<DeserializationConfig>any())).thenReturn(new LRUMap<>(1, 3));
    when(cacheProvider.forSerializerCache(Mockito.<SerializationConfig>any())).thenReturn(new LRUMap<>(1, 3));
    when(cacheProvider.forTypeFactory()).thenReturn(new LRUMap<>(1, 3));
    Builder builderResult = JsonMapper.builder();
    builderResult.setDefaultTyping(DefaultTypeResolverBuilder.construct(DefaultTyping.NON_FINAL_AND_ENUMS,
        new DefaultBaseTypeLimitingValidator()));
    builderResult.cacheProvider(cacheProvider);

    // Act
    JsonNode actualToJsonNodeResult = JacksonUtil.toJsonNode("42", builderResult.findAndAddModules().build());

    // Assert
    verify(cacheProvider).forDeserializerCache(isNull());
    verify(cacheProvider).forSerializerCache(isNull());
    verify(cacheProvider).forTypeFactory();
    assertTrue(actualToJsonNodeResult instanceof IntNode);
    assertTrue(actualToJsonNodeResult.traverse() instanceof TreeTraversingParser);
    assertEquals("42", actualToJsonNodeResult.toPrettyString());
    assertEquals(0, actualToJsonNodeResult.size());
    assertEquals(JsonNodeType.NUMBER, actualToJsonNodeResult.getNodeType());
    assertFalse(actualToJsonNodeResult.isArray());
    assertFalse(actualToJsonNodeResult.isBigDecimal());
    assertFalse(actualToJsonNodeResult.isBigInteger());
    assertFalse(actualToJsonNodeResult.isBinary());
    assertFalse(actualToJsonNodeResult.isBoolean());
    assertFalse(actualToJsonNodeResult.isContainerNode());
    assertFalse(actualToJsonNodeResult.isDouble());
    assertFalse(actualToJsonNodeResult.isFloat());
    assertFalse(actualToJsonNodeResult.isFloatingPointNumber());
    assertFalse(actualToJsonNodeResult.isLong());
    assertFalse(actualToJsonNodeResult.isMissingNode());
    assertFalse(actualToJsonNodeResult.isNull());
    assertFalse(actualToJsonNodeResult.isObject());
    assertFalse(actualToJsonNodeResult.isPojo());
    assertFalse(actualToJsonNodeResult.isShort());
    assertFalse(actualToJsonNodeResult.isTextual());
    assertFalse(((IntNode) actualToJsonNodeResult).isNaN());
    assertFalse(actualToJsonNodeResult.iterator().hasNext());
    assertTrue(actualToJsonNodeResult.isEmpty());
    assertTrue(actualToJsonNodeResult.isInt());
    assertTrue(actualToJsonNodeResult.isIntegralNumber());
    assertTrue(actualToJsonNodeResult.isNumber());
    assertTrue(actualToJsonNodeResult.isValueNode());
  }

  /**
   * Test {@link JacksonUtil#toJsonNode(String, ObjectMapper)} with {@code String}, {@code ObjectMapper}.
   * <ul>
   *   <li>Given {@link StdTypeResolverBuilder#StdTypeResolverBuilder()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link JacksonUtil#toJsonNode(String, ObjectMapper)}
   */
  @Test
  @DisplayName("Test toJsonNode(String, ObjectMapper) with 'String', 'ObjectMapper'; given StdTypeResolverBuilder()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"JsonNode JacksonUtil.toJsonNode(String, ObjectMapper)"})
  void testToJsonNodeWithStringObjectMapper_givenStdTypeResolverBuilder() {
    // Arrange
    CacheProvider cacheProvider = mock(CacheProvider.class);
    when(cacheProvider.forDeserializerCache(Mockito.<DeserializationConfig>any())).thenReturn(new LRUMap<>(1, 3));
    when(cacheProvider.forSerializerCache(Mockito.<SerializationConfig>any())).thenReturn(new LRUMap<>(1, 3));
    when(cacheProvider.forTypeFactory()).thenReturn(new LRUMap<>(1, 3));
    Builder builderResult = JsonMapper.builder();
    builderResult.setDefaultTyping(new StdTypeResolverBuilder());
    builderResult.cacheProvider(cacheProvider);

    // Act and Assert
    assertThrows(IllegalArgumentException.class,
        () -> JacksonUtil.toJsonNode("42", builderResult.findAndAddModules().build()));
    verify(cacheProvider).forDeserializerCache(isNull());
    verify(cacheProvider).forSerializerCache(isNull());
    verify(cacheProvider).forTypeFactory();
  }

  /**
   * Test {@link JacksonUtil#toJsonNode(String, ObjectMapper)} with {@code String}, {@code ObjectMapper}.
   * <ul>
   *   <li>Then return {@link IntNode}.</li>
   * </ul>
   * <p>
   * Method under test: {@link JacksonUtil#toJsonNode(String, ObjectMapper)}
   */
  @Test
  @DisplayName("Test toJsonNode(String, ObjectMapper) with 'String', 'ObjectMapper'; then return IntNode")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"JsonNode JacksonUtil.toJsonNode(String, ObjectMapper)"})
  void testToJsonNodeWithStringObjectMapper_thenReturnIntNode() {
    // Arrange and Act
    JsonNode actualToJsonNodeResult = JacksonUtil.toJsonNode("42", JsonMapper.builder().findAndAddModules().build());

    // Assert
    assertTrue(actualToJsonNodeResult instanceof IntNode);
    assertTrue(actualToJsonNodeResult.traverse() instanceof TreeTraversingParser);
    assertEquals("42", actualToJsonNodeResult.toPrettyString());
    assertEquals(0, actualToJsonNodeResult.size());
    assertEquals(JsonNodeType.NUMBER, actualToJsonNodeResult.getNodeType());
    assertFalse(actualToJsonNodeResult.isArray());
    assertFalse(actualToJsonNodeResult.isBigDecimal());
    assertFalse(actualToJsonNodeResult.isBigInteger());
    assertFalse(actualToJsonNodeResult.isBinary());
    assertFalse(actualToJsonNodeResult.isBoolean());
    assertFalse(actualToJsonNodeResult.isContainerNode());
    assertFalse(actualToJsonNodeResult.isDouble());
    assertFalse(actualToJsonNodeResult.isFloat());
    assertFalse(actualToJsonNodeResult.isFloatingPointNumber());
    assertFalse(actualToJsonNodeResult.isLong());
    assertFalse(actualToJsonNodeResult.isMissingNode());
    assertFalse(actualToJsonNodeResult.isNull());
    assertFalse(actualToJsonNodeResult.isObject());
    assertFalse(actualToJsonNodeResult.isPojo());
    assertFalse(actualToJsonNodeResult.isShort());
    assertFalse(actualToJsonNodeResult.isTextual());
    assertFalse(((IntNode) actualToJsonNodeResult).isNaN());
    assertFalse(actualToJsonNodeResult.iterator().hasNext());
    assertTrue(actualToJsonNodeResult.isEmpty());
    assertTrue(actualToJsonNodeResult.isInt());
    assertTrue(actualToJsonNodeResult.isIntegralNumber());
    assertTrue(actualToJsonNodeResult.isNumber());
    assertTrue(actualToJsonNodeResult.isValueNode());
  }

  /**
   * Test {@link JacksonUtil#toJsonNode(String, ObjectMapper)} with {@code String}, {@code ObjectMapper}.
   * <ul>
   *   <li>When empty string.</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link JacksonUtil#toJsonNode(String, ObjectMapper)}
   */
  @Test
  @DisplayName("Test toJsonNode(String, ObjectMapper) with 'String', 'ObjectMapper'; when empty string; then return 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"JsonNode JacksonUtil.toJsonNode(String, ObjectMapper)"})
  void testToJsonNodeWithStringObjectMapper_whenEmptyString_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull(JacksonUtil.toJsonNode("", JacksonUtil.IGNORE_UNKNOWN_PROPERTIES_JSON_MAPPER));
  }

  /**
   * Test {@link JacksonUtil#toJsonNode(String, ObjectMapper)} with {@code String}, {@code ObjectMapper}.
   * <ul>
   *   <li>When {@link JacksonUtil#IGNORE_UNKNOWN_PROPERTIES_JSON_MAPPER}.</li>
   * </ul>
   * <p>
   * Method under test: {@link JacksonUtil#toJsonNode(String, ObjectMapper)}
   */
  @Test
  @DisplayName("Test toJsonNode(String, ObjectMapper) with 'String', 'ObjectMapper'; when IGNORE_UNKNOWN_PROPERTIES_JSON_MAPPER")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"JsonNode JacksonUtil.toJsonNode(String, ObjectMapper)"})
  void testToJsonNodeWithStringObjectMapper_whenIgnore_unknown_properties_json_mapper() {
    // Arrange and Act
    JsonNode actualToJsonNodeResult = JacksonUtil.toJsonNode("42", JacksonUtil.IGNORE_UNKNOWN_PROPERTIES_JSON_MAPPER);

    // Assert
    assertTrue(actualToJsonNodeResult instanceof IntNode);
    assertTrue(actualToJsonNodeResult.traverse() instanceof TreeTraversingParser);
    assertEquals("42", actualToJsonNodeResult.toPrettyString());
    assertEquals(0, actualToJsonNodeResult.size());
    assertEquals(JsonNodeType.NUMBER, actualToJsonNodeResult.getNodeType());
    assertFalse(actualToJsonNodeResult.isArray());
    assertFalse(actualToJsonNodeResult.isBigDecimal());
    assertFalse(actualToJsonNodeResult.isBigInteger());
    assertFalse(actualToJsonNodeResult.isBinary());
    assertFalse(actualToJsonNodeResult.isBoolean());
    assertFalse(actualToJsonNodeResult.isContainerNode());
    assertFalse(actualToJsonNodeResult.isDouble());
    assertFalse(actualToJsonNodeResult.isFloat());
    assertFalse(actualToJsonNodeResult.isFloatingPointNumber());
    assertFalse(actualToJsonNodeResult.isLong());
    assertFalse(actualToJsonNodeResult.isMissingNode());
    assertFalse(actualToJsonNodeResult.isNull());
    assertFalse(actualToJsonNodeResult.isObject());
    assertFalse(actualToJsonNodeResult.isPojo());
    assertFalse(actualToJsonNodeResult.isShort());
    assertFalse(actualToJsonNodeResult.isTextual());
    assertFalse(((IntNode) actualToJsonNodeResult).isNaN());
    assertFalse(actualToJsonNodeResult.iterator().hasNext());
    assertTrue(actualToJsonNodeResult.isEmpty());
    assertTrue(actualToJsonNodeResult.isInt());
    assertTrue(actualToJsonNodeResult.isIntegralNumber());
    assertTrue(actualToJsonNodeResult.isNumber());
    assertTrue(actualToJsonNodeResult.isValueNode());
  }

  /**
   * Test {@link JacksonUtil#toJsonNode(String, ObjectMapper)} with {@code String}, {@code ObjectMapper}.
   * <ul>
   *   <li>When {@code null}.</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link JacksonUtil#toJsonNode(String, ObjectMapper)}
   */
  @Test
  @DisplayName("Test toJsonNode(String, ObjectMapper) with 'String', 'ObjectMapper'; when 'null'; then return 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"JsonNode JacksonUtil.toJsonNode(String, ObjectMapper)"})
  void testToJsonNodeWithStringObjectMapper_whenNull_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull(JacksonUtil.toJsonNode(null, JacksonUtil.IGNORE_UNKNOWN_PROPERTIES_JSON_MAPPER));
  }

  /**
   * Test {@link JacksonUtil#toJsonNode(String, ObjectMapper)} with {@code String}, {@code ObjectMapper}.
   * <ul>
   *   <li>When {@link ObjectMapper#ObjectMapper()}.</li>
   *   <li>Then return {@link IntNode}.</li>
   * </ul>
   * <p>
   * Method under test: {@link JacksonUtil#toJsonNode(String, ObjectMapper)}
   */
  @Test
  @DisplayName("Test toJsonNode(String, ObjectMapper) with 'String', 'ObjectMapper'; when ObjectMapper(); then return IntNode")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"JsonNode JacksonUtil.toJsonNode(String, ObjectMapper)"})
  void testToJsonNodeWithStringObjectMapper_whenObjectMapper_thenReturnIntNode() {
    // Arrange and Act
    JsonNode actualToJsonNodeResult = JacksonUtil.toJsonNode("42", new ObjectMapper());

    // Assert
    assertTrue(actualToJsonNodeResult instanceof IntNode);
    assertTrue(actualToJsonNodeResult.traverse() instanceof TreeTraversingParser);
    assertEquals("42", actualToJsonNodeResult.toPrettyString());
    assertEquals(0, actualToJsonNodeResult.size());
    assertEquals(JsonNodeType.NUMBER, actualToJsonNodeResult.getNodeType());
    assertFalse(actualToJsonNodeResult.isArray());
    assertFalse(actualToJsonNodeResult.isBigDecimal());
    assertFalse(actualToJsonNodeResult.isBigInteger());
    assertFalse(actualToJsonNodeResult.isBinary());
    assertFalse(actualToJsonNodeResult.isBoolean());
    assertFalse(actualToJsonNodeResult.isContainerNode());
    assertFalse(actualToJsonNodeResult.isDouble());
    assertFalse(actualToJsonNodeResult.isFloat());
    assertFalse(actualToJsonNodeResult.isFloatingPointNumber());
    assertFalse(actualToJsonNodeResult.isLong());
    assertFalse(actualToJsonNodeResult.isMissingNode());
    assertFalse(actualToJsonNodeResult.isNull());
    assertFalse(actualToJsonNodeResult.isObject());
    assertFalse(actualToJsonNodeResult.isPojo());
    assertFalse(actualToJsonNodeResult.isShort());
    assertFalse(actualToJsonNodeResult.isTextual());
    assertFalse(((IntNode) actualToJsonNodeResult).isNaN());
    assertFalse(actualToJsonNodeResult.iterator().hasNext());
    assertTrue(actualToJsonNodeResult.isEmpty());
    assertTrue(actualToJsonNodeResult.isInt());
    assertTrue(actualToJsonNodeResult.isIntegralNumber());
    assertTrue(actualToJsonNodeResult.isNumber());
    assertTrue(actualToJsonNodeResult.isValueNode());
  }

  /**
   * Test {@link JacksonUtil#toJsonNode(String, ObjectMapper)} with {@code String}, {@code ObjectMapper}.
   * <ul>
   *   <li>When {@code "}.</li>
   * </ul>
   * <p>
   * Method under test: {@link JacksonUtil#toJsonNode(String, ObjectMapper)}
   */
  @Test
  @DisplayName("Test toJsonNode(String, ObjectMapper) with 'String', 'ObjectMapper'; when '\"'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"JsonNode JacksonUtil.toJsonNode(String, ObjectMapper)"})
  void testToJsonNodeWithStringObjectMapper_whenQuotationMark() {
    // Arrange, Act and Assert
    assertThrows(IllegalArgumentException.class,
        () -> JacksonUtil.toJsonNode("\"", JacksonUtil.IGNORE_UNKNOWN_PROPERTIES_JSON_MAPPER));
  }

  /**
   * Test {@link JacksonUtil#toJsonNode(String, ObjectMapper)} with {@code String}, {@code ObjectMapper}.
   * <ul>
   *   <li>When {@code Value}.</li>
   *   <li>Then throw {@link IllegalArgumentException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link JacksonUtil#toJsonNode(String, ObjectMapper)}
   */
  @Test
  @DisplayName("Test toJsonNode(String, ObjectMapper) with 'String', 'ObjectMapper'; when 'Value'; then throw IllegalArgumentException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"JsonNode JacksonUtil.toJsonNode(String, ObjectMapper)"})
  void testToJsonNodeWithStringObjectMapper_whenValue_thenThrowIllegalArgumentException() {
    // Arrange, Act and Assert
    assertThrows(IllegalArgumentException.class,
        () -> JacksonUtil.toJsonNode("Value", JacksonUtil.IGNORE_UNKNOWN_PROPERTIES_JSON_MAPPER));
  }

  /**
   * Test {@link JacksonUtil#toJsonNode(String)} with {@code String}.
   * <ul>
   *   <li>Then return toPrettyString is {@code ""}.</li>
   * </ul>
   * <p>
   * Method under test: {@link JacksonUtil#toJsonNode(String)}
   */
  @Test
  @DisplayName("Test toJsonNode(String) with 'String'; then return toPrettyString is '\"\"'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"JsonNode JacksonUtil.toJsonNode(String)"})
  void testToJsonNodeWithString_thenReturnToPrettyStringIsQuotationMarkQuotationMark() {
    // Arrange and Act
    JsonNode actualToJsonNodeResult = JacksonUtil.toJsonNode("\"\"");

    // Assert
    assertTrue(actualToJsonNodeResult instanceof TextNode);
    assertTrue(actualToJsonNodeResult.traverse() instanceof TreeTraversingParser);
    assertEquals("\"\"", actualToJsonNodeResult.toPrettyString());
    assertEquals(JsonNodeType.STRING, actualToJsonNodeResult.getNodeType());
    assertFalse(actualToJsonNodeResult.isInt());
    assertFalse(actualToJsonNodeResult.isIntegralNumber());
    assertFalse(actualToJsonNodeResult.isNumber());
    assertTrue(actualToJsonNodeResult.isTextual());
  }

  /**
   * Test {@link JacksonUtil#toJsonNode(String)} with {@code String}.
   * <ul>
   *   <li>When {@code 42Value}.</li>
   *   <li>Then throw {@link IllegalArgumentException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link JacksonUtil#toJsonNode(String)}
   */
  @Test
  @DisplayName("Test toJsonNode(String) with 'String'; when '42Value'; then throw IllegalArgumentException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"JsonNode JacksonUtil.toJsonNode(String)"})
  void testToJsonNodeWithString_when42Value_thenThrowIllegalArgumentException() {
    // Arrange, Act and Assert
    assertThrows(IllegalArgumentException.class, () -> JacksonUtil.toJsonNode("42Value"));
  }

  /**
   * Test {@link JacksonUtil#toJsonNode(String)} with {@code String}.
   * <ul>
   *   <li>When {@code 42}.</li>
   *   <li>Then return {@link IntNode}.</li>
   * </ul>
   * <p>
   * Method under test: {@link JacksonUtil#toJsonNode(String)}
   */
  @Test
  @DisplayName("Test toJsonNode(String) with 'String'; when '42'; then return IntNode")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"JsonNode JacksonUtil.toJsonNode(String)"})
  void testToJsonNodeWithString_when42_thenReturnIntNode() {
    // Arrange and Act
    JsonNode actualToJsonNodeResult = JacksonUtil.toJsonNode("42");

    // Assert
    assertTrue(actualToJsonNodeResult instanceof IntNode);
    assertTrue(actualToJsonNodeResult.traverse() instanceof TreeTraversingParser);
    assertEquals("42", actualToJsonNodeResult.toPrettyString());
    assertEquals(JsonNodeType.NUMBER, actualToJsonNodeResult.getNodeType());
    assertFalse(actualToJsonNodeResult.isTextual());
    assertFalse(((IntNode) actualToJsonNodeResult).isNaN());
    assertTrue(actualToJsonNodeResult.isInt());
    assertTrue(actualToJsonNodeResult.isIntegralNumber());
    assertTrue(actualToJsonNodeResult.isNumber());
  }

  /**
   * Test {@link JacksonUtil#toJsonNode(String)} with {@code String}.
   * <ul>
   *   <li>When {@code "42"}.</li>
   *   <li>Then return toPrettyString is {@code "42"}.</li>
   * </ul>
   * <p>
   * Method under test: {@link JacksonUtil#toJsonNode(String)}
   */
  @Test
  @DisplayName("Test toJsonNode(String) with 'String'; when '\"42\"'; then return toPrettyString is '\"42\"'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"JsonNode JacksonUtil.toJsonNode(String)"})
  void testToJsonNodeWithString_when42_thenReturnToPrettyStringIs42() {
    // Arrange and Act
    JsonNode actualToJsonNodeResult = JacksonUtil.toJsonNode("\"42\"");

    // Assert
    assertTrue(actualToJsonNodeResult instanceof TextNode);
    assertTrue(actualToJsonNodeResult.traverse() instanceof TreeTraversingParser);
    assertEquals("\"42\"", actualToJsonNodeResult.toPrettyString());
    assertEquals(JsonNodeType.STRING, actualToJsonNodeResult.getNodeType());
    assertFalse(actualToJsonNodeResult.isInt());
    assertFalse(actualToJsonNodeResult.isIntegralNumber());
    assertFalse(actualToJsonNodeResult.isNumber());
    assertTrue(actualToJsonNodeResult.isTextual());
  }

  /**
   * Test {@link JacksonUtil#toJsonNode(String)} with {@code String}.
   * <ul>
   *   <li>When empty string.</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link JacksonUtil#toJsonNode(String)}
   */
  @Test
  @DisplayName("Test toJsonNode(String) with 'String'; when empty string; then return 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"JsonNode JacksonUtil.toJsonNode(String)"})
  void testToJsonNodeWithString_whenEmptyString_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull(JacksonUtil.toJsonNode(""));
  }

  /**
   * Test {@link JacksonUtil#toJsonNode(String)} with {@code String}.
   * <ul>
   *   <li>When {@code null}.</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link JacksonUtil#toJsonNode(String)}
   */
  @Test
  @DisplayName("Test toJsonNode(String) with 'String'; when 'null'; then return 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"JsonNode JacksonUtil.toJsonNode(String)"})
  void testToJsonNodeWithString_whenNull_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull(JacksonUtil.toJsonNode((String) null));
  }

  /**
   * Test {@link JacksonUtil#toJsonNode(String)} with {@code String}.
   * <ul>
   *   <li>When {@code "}.</li>
   *   <li>Then throw {@link IllegalArgumentException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link JacksonUtil#toJsonNode(String)}
   */
  @Test
  @DisplayName("Test toJsonNode(String) with 'String'; when '\"'; then throw IllegalArgumentException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"JsonNode JacksonUtil.toJsonNode(String)"})
  void testToJsonNodeWithString_whenQuotationMark_thenThrowIllegalArgumentException() {
    // Arrange, Act and Assert
    assertThrows(IllegalArgumentException.class, () -> JacksonUtil.toJsonNode("\""));
  }

  /**
   * Test {@link JacksonUtil#toJsonNode(String)} with {@code String}.
   * <ul>
   *   <li>When {@code Value}.</li>
   *   <li>Then throw {@link IllegalArgumentException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link JacksonUtil#toJsonNode(String)}
   */
  @Test
  @DisplayName("Test toJsonNode(String) with 'String'; when 'Value'; then throw IllegalArgumentException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"JsonNode JacksonUtil.toJsonNode(String)"})
  void testToJsonNodeWithString_whenValue_thenThrowIllegalArgumentException() {
    // Arrange, Act and Assert
    assertThrows(IllegalArgumentException.class, () -> JacksonUtil.toJsonNode("Value"));
  }

  /**
   * Test {@link JacksonUtil#readValue(File, Class)} with {@code File}, {@code Class}.
   * <ul>
   *   <li>Then throw {@link IllegalArgumentException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link JacksonUtil#readValue(File, Class)}
   */
  @Test
  @DisplayName("Test readValue(File, Class) with 'File', 'Class'; then throw IllegalArgumentException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Object JacksonUtil.readValue(File, Class)"})
  void testReadValueWithFileClass_thenThrowIllegalArgumentException() {
    // Arrange
    File file = Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toFile();
    Class<Object> clazz = Object.class;

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> JacksonUtil.readValue(file, clazz));
  }

  /**
   * Test {@link JacksonUtil#readValue(File, TypeReference)} with {@code File}, {@code TypeReference}.
   * <p>
   * Method under test: {@link JacksonUtil#readValue(File, TypeReference)}
   */
  @Test
  @DisplayName("Test readValue(File, TypeReference) with 'File', 'TypeReference'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Object JacksonUtil.readValue(File, TypeReference)"})
  void testReadValueWithFileTypeReference() {
    // Arrange, Act and Assert
    assertThrows(IllegalArgumentException.class,
        () -> JacksonUtil.<Object>readValue(Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toFile(),
            mock(TypeReference.class)));
  }

  /**
   * Test {@link JacksonUtil#readValue(String, CollectionType)} with {@code String}, {@code CollectionType}.
   * <ul>
   *   <li>When empty string.</li>
   * </ul>
   * <p>
   * Method under test: {@link JacksonUtil#readValue(String, CollectionType)}
   */
  @Test
  @DisplayName("Test readValue(String, CollectionType) with 'String', 'CollectionType'; when empty string")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Object JacksonUtil.readValue(String, CollectionType)"})
  void testReadValueWithStringCollectionType_whenEmptyString() {
    // Arrange, Act and Assert
    assertThrows(IllegalArgumentException.class, () -> JacksonUtil.readValue("", null));
  }

  /**
   * Test {@link JacksonUtil#readValue(String, CollectionType)} with {@code String}, {@code CollectionType}.
   * <ul>
   *   <li>When {@code File}.</li>
   *   <li>Then throw {@link IllegalArgumentException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link JacksonUtil#readValue(String, CollectionType)}
   */
  @Test
  @DisplayName("Test readValue(String, CollectionType) with 'String', 'CollectionType'; when 'File'; then throw IllegalArgumentException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Object JacksonUtil.readValue(String, CollectionType)"})
  void testReadValueWithStringCollectionType_whenFile_thenThrowIllegalArgumentException() {
    // Arrange, Act and Assert
    assertThrows(IllegalArgumentException.class, () -> JacksonUtil.readValue("File", null));
  }

  /**
   * Test {@link JacksonUtil#newObjectNode()}.
   * <p>
   * Method under test: {@link JacksonUtil#newObjectNode()}
   */
  @Test
  @DisplayName("Test newObjectNode()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"ObjectNode JacksonUtil.newObjectNode()"})
  void testNewObjectNode() {
    // Arrange and Act
    ObjectNode actualNewObjectNodeResult = JacksonUtil.newObjectNode();

    // Assert
    assertTrue(actualNewObjectNodeResult.traverse() instanceof TreeTraversingParser);
    assertEquals("{ }", actualNewObjectNodeResult.toPrettyString());
    assertEquals(0, actualNewObjectNodeResult.size());
    assertEquals(JsonNodeType.OBJECT, actualNewObjectNodeResult.getNodeType());
    assertFalse(actualNewObjectNodeResult.isArray());
    assertFalse(actualNewObjectNodeResult.isBigDecimal());
    assertFalse(actualNewObjectNodeResult.isBigInteger());
    assertFalse(actualNewObjectNodeResult.isBinary());
    assertFalse(actualNewObjectNodeResult.isBoolean());
    assertFalse(actualNewObjectNodeResult.isDouble());
    assertFalse(actualNewObjectNodeResult.isFloat());
    assertFalse(actualNewObjectNodeResult.isFloatingPointNumber());
    assertFalse(actualNewObjectNodeResult.isInt());
    assertFalse(actualNewObjectNodeResult.isIntegralNumber());
    assertFalse(actualNewObjectNodeResult.isLong());
    assertFalse(actualNewObjectNodeResult.isMissingNode());
    assertFalse(actualNewObjectNodeResult.isNull());
    assertFalse(actualNewObjectNodeResult.isNumber());
    assertFalse(actualNewObjectNodeResult.isPojo());
    assertFalse(actualNewObjectNodeResult.isShort());
    assertFalse(actualNewObjectNodeResult.isTextual());
    assertFalse(actualNewObjectNodeResult.isValueNode());
    assertFalse(actualNewObjectNodeResult.iterator().hasNext());
    assertTrue(actualNewObjectNodeResult.isContainerNode());
    assertTrue(actualNewObjectNodeResult.isEmpty());
    assertTrue(actualNewObjectNodeResult.isObject());
  }

  /**
   * Test {@link JacksonUtil#newObjectNode(ObjectMapper)} with {@code ObjectMapper}.
   * <ul>
   *   <li>Then traverse return {@link TreeTraversingParser}.</li>
   * </ul>
   * <p>
   * Method under test: {@link JacksonUtil#newObjectNode(ObjectMapper)}
   */
  @Test
  @DisplayName("Test newObjectNode(ObjectMapper) with 'ObjectMapper'; then traverse return TreeTraversingParser")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"ObjectNode JacksonUtil.newObjectNode(ObjectMapper)"})
  void testNewObjectNodeWithObjectMapper_thenTraverseReturnTreeTraversingParser() {
    // Arrange and Act
    ObjectNode actualNewObjectNodeResult = JacksonUtil.newObjectNode(JacksonUtil.IGNORE_UNKNOWN_PROPERTIES_JSON_MAPPER);

    // Assert
    assertTrue(actualNewObjectNodeResult.traverse() instanceof TreeTraversingParser);
    assertEquals("{ }", actualNewObjectNodeResult.toPrettyString());
    assertEquals(0, actualNewObjectNodeResult.size());
    assertEquals(JsonNodeType.OBJECT, actualNewObjectNodeResult.getNodeType());
    assertFalse(actualNewObjectNodeResult.isArray());
    assertFalse(actualNewObjectNodeResult.isBigDecimal());
    assertFalse(actualNewObjectNodeResult.isBigInteger());
    assertFalse(actualNewObjectNodeResult.isBinary());
    assertFalse(actualNewObjectNodeResult.isBoolean());
    assertFalse(actualNewObjectNodeResult.isDouble());
    assertFalse(actualNewObjectNodeResult.isFloat());
    assertFalse(actualNewObjectNodeResult.isFloatingPointNumber());
    assertFalse(actualNewObjectNodeResult.isInt());
    assertFalse(actualNewObjectNodeResult.isIntegralNumber());
    assertFalse(actualNewObjectNodeResult.isLong());
    assertFalse(actualNewObjectNodeResult.isMissingNode());
    assertFalse(actualNewObjectNodeResult.isNull());
    assertFalse(actualNewObjectNodeResult.isNumber());
    assertFalse(actualNewObjectNodeResult.isPojo());
    assertFalse(actualNewObjectNodeResult.isShort());
    assertFalse(actualNewObjectNodeResult.isTextual());
    assertFalse(actualNewObjectNodeResult.isValueNode());
    assertFalse(actualNewObjectNodeResult.iterator().hasNext());
    assertTrue(actualNewObjectNodeResult.isContainerNode());
    assertTrue(actualNewObjectNodeResult.isEmpty());
    assertTrue(actualNewObjectNodeResult.isObject());
  }

  /**
   * Test {@link JacksonUtil#newArrayNode()}.
   * <p>
   * Method under test: {@link JacksonUtil#newArrayNode()}
   */
  @Test
  @DisplayName("Test newArrayNode()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"ArrayNode JacksonUtil.newArrayNode()"})
  void testNewArrayNode() {
    // Arrange and Act
    ArrayNode actualNewArrayNodeResult = JacksonUtil.newArrayNode();

    // Assert
    assertTrue(actualNewArrayNodeResult.traverse() instanceof TreeTraversingParser);
    assertEquals("[ ]", actualNewArrayNodeResult.toPrettyString());
    assertEquals(0, actualNewArrayNodeResult.size());
    assertEquals(JsonNodeType.ARRAY, actualNewArrayNodeResult.getNodeType());
    assertFalse(actualNewArrayNodeResult.isBigDecimal());
    assertFalse(actualNewArrayNodeResult.isBigInteger());
    assertFalse(actualNewArrayNodeResult.isBinary());
    assertFalse(actualNewArrayNodeResult.isBoolean());
    assertFalse(actualNewArrayNodeResult.isDouble());
    assertFalse(actualNewArrayNodeResult.isFloat());
    assertFalse(actualNewArrayNodeResult.isFloatingPointNumber());
    assertFalse(actualNewArrayNodeResult.isInt());
    assertFalse(actualNewArrayNodeResult.isIntegralNumber());
    assertFalse(actualNewArrayNodeResult.isLong());
    assertFalse(actualNewArrayNodeResult.isMissingNode());
    assertFalse(actualNewArrayNodeResult.isNull());
    assertFalse(actualNewArrayNodeResult.isNumber());
    assertFalse(actualNewArrayNodeResult.isObject());
    assertFalse(actualNewArrayNodeResult.isPojo());
    assertFalse(actualNewArrayNodeResult.isShort());
    assertFalse(actualNewArrayNodeResult.isTextual());
    assertFalse(actualNewArrayNodeResult.isValueNode());
    assertFalse(actualNewArrayNodeResult.iterator().hasNext());
    assertFalse(actualNewArrayNodeResult.elements().hasNext());
    assertTrue(actualNewArrayNodeResult.isContainerNode());
    assertTrue(actualNewArrayNodeResult.isArray());
    assertTrue(actualNewArrayNodeResult.isEmpty());
  }

  /**
   * Test {@link JacksonUtil#newArrayNode(ObjectMapper)} with {@code ObjectMapper}.
   * <ul>
   *   <li>Then traverse return {@link TreeTraversingParser}.</li>
   * </ul>
   * <p>
   * Method under test: {@link JacksonUtil#newArrayNode(ObjectMapper)}
   */
  @Test
  @DisplayName("Test newArrayNode(ObjectMapper) with 'ObjectMapper'; then traverse return TreeTraversingParser")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"ArrayNode JacksonUtil.newArrayNode(ObjectMapper)"})
  void testNewArrayNodeWithObjectMapper_thenTraverseReturnTreeTraversingParser() {
    // Arrange and Act
    ArrayNode actualNewArrayNodeResult = JacksonUtil.newArrayNode(JacksonUtil.IGNORE_UNKNOWN_PROPERTIES_JSON_MAPPER);

    // Assert
    assertTrue(actualNewArrayNodeResult.traverse() instanceof TreeTraversingParser);
    assertEquals("[ ]", actualNewArrayNodeResult.toPrettyString());
    assertEquals(0, actualNewArrayNodeResult.size());
    assertEquals(JsonNodeType.ARRAY, actualNewArrayNodeResult.getNodeType());
    assertFalse(actualNewArrayNodeResult.isBigDecimal());
    assertFalse(actualNewArrayNodeResult.isBigInteger());
    assertFalse(actualNewArrayNodeResult.isBinary());
    assertFalse(actualNewArrayNodeResult.isBoolean());
    assertFalse(actualNewArrayNodeResult.isDouble());
    assertFalse(actualNewArrayNodeResult.isFloat());
    assertFalse(actualNewArrayNodeResult.isFloatingPointNumber());
    assertFalse(actualNewArrayNodeResult.isInt());
    assertFalse(actualNewArrayNodeResult.isIntegralNumber());
    assertFalse(actualNewArrayNodeResult.isLong());
    assertFalse(actualNewArrayNodeResult.isMissingNode());
    assertFalse(actualNewArrayNodeResult.isNull());
    assertFalse(actualNewArrayNodeResult.isNumber());
    assertFalse(actualNewArrayNodeResult.isObject());
    assertFalse(actualNewArrayNodeResult.isPojo());
    assertFalse(actualNewArrayNodeResult.isShort());
    assertFalse(actualNewArrayNodeResult.isTextual());
    assertFalse(actualNewArrayNodeResult.isValueNode());
    assertFalse(actualNewArrayNodeResult.iterator().hasNext());
    assertFalse(actualNewArrayNodeResult.elements().hasNext());
    assertTrue(actualNewArrayNodeResult.isContainerNode());
    assertTrue(actualNewArrayNodeResult.isArray());
    assertTrue(actualNewArrayNodeResult.isEmpty());
  }

  /**
   * Test {@link JacksonUtil#clone(Object)} with {@code Object}.
   * <ul>
   *   <li>When {@code 42}.</li>
   *   <li>Then return {@code 42}.</li>
   * </ul>
   * <p>
   * Method under test: {@link JacksonUtil#clone(Object)}
   */
  @Test
  @DisplayName("Test clone(Object) with 'Object'; when '42'; then return '42'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Object JacksonUtil.clone(Object)"})
  void testCloneWithObject_when42_thenReturn42() {
    // Arrange, Act and Assert
    assertEquals("42", JacksonUtil.clone("42"));
  }

  /**
   * Test {@link JacksonUtil#clone(Object)} with {@code Object}.
   * <ul>
   *   <li>When forty-two.</li>
   *   <li>Then return intValue is forty-two.</li>
   * </ul>
   * <p>
   * Method under test: {@link JacksonUtil#clone(Object)}
   */
  @Test
  @DisplayName("Test clone(Object) with 'Object'; when forty-two; then return intValue is forty-two")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Object JacksonUtil.clone(Object)"})
  void testCloneWithObject_whenFortyTwo_thenReturnIntValueIsFortyTwo() {
    // Arrange, Act and Assert
    assertEquals(42, ((Integer) JacksonUtil.<Object>clone(42)).intValue());
  }

  /**
   * Test {@link JacksonUtil#clone(Object)} with {@code Object}.
   * <ul>
   *   <li>When one.</li>
   *   <li>Then return intValue is one.</li>
   * </ul>
   * <p>
   * Method under test: {@link JacksonUtil#clone(Object)}
   */
  @Test
  @DisplayName("Test clone(Object) with 'Object'; when one; then return intValue is one")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Object JacksonUtil.clone(Object)"})
  void testCloneWithObject_whenOne_thenReturnIntValueIsOne() {
    // Arrange, Act and Assert
    assertEquals(1, ((Integer) JacksonUtil.<Object>clone(1)).intValue());
  }

  /**
   * Test {@link JacksonUtil#clone(Object)} with {@code Object}.
   * <ul>
   *   <li>When {@code "}.</li>
   *   <li>Then return {@code "}.</li>
   * </ul>
   * <p>
   * Method under test: {@link JacksonUtil#clone(Object)}
   */
  @Test
  @DisplayName("Test clone(Object) with 'Object'; when '\"'; then return '\"'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Object JacksonUtil.clone(Object)"})
  void testCloneWithObject_whenQuotationMark_thenReturnQuotationMark() {
    // Arrange, Act and Assert
    assertEquals("\"", JacksonUtil.clone("\""));
  }

  /**
   * Test {@link JacksonUtil#clone(Object)} with {@code Object}.
   * <ul>
   *   <li>When {@code Value}.</li>
   *   <li>Then return {@code Value}.</li>
   * </ul>
   * <p>
   * Method under test: {@link JacksonUtil#clone(Object)}
   */
  @Test
  @DisplayName("Test clone(Object) with 'Object'; when 'Value'; then return 'Value'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Object JacksonUtil.clone(Object)"})
  void testCloneWithObject_whenValue_thenReturnValue() {
    // Arrange, Act and Assert
    assertEquals("Value", JacksonUtil.clone("Value"));
  }

  /**
   * Test {@link JacksonUtil#valueToTree(Object)}.
   * <ul>
   *   <li>Then return toPrettyString is {@code ""}.</li>
   * </ul>
   * <p>
   * Method under test: {@link JacksonUtil#valueToTree(Object)}
   */
  @Test
  @DisplayName("Test valueToTree(Object); then return toPrettyString is '\"\"'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"JsonNode JacksonUtil.valueToTree(Object)"})
  void testValueToTree_thenReturnToPrettyStringIsQuotationMarkQuotationMark() {
    // Arrange and Act
    JsonNode actualValueToTreeResult = JacksonUtil.valueToTree("");

    // Assert
    assertTrue(actualValueToTreeResult instanceof TextNode);
    assertTrue(actualValueToTreeResult.traverse() instanceof TreeTraversingParser);
    assertEquals("\"\"", actualValueToTreeResult.toPrettyString());
    assertEquals(JsonNodeType.STRING, actualValueToTreeResult.getNodeType());
    assertTrue(actualValueToTreeResult.isTextual());
  }

  /**
   * Test {@link JacksonUtil#valueToTree(Object)}.
   * <ul>
   *   <li>When forty-two.</li>
   *   <li>Then return toPrettyString is {@code 42}.</li>
   * </ul>
   * <p>
   * Method under test: {@link JacksonUtil#valueToTree(Object)}
   */
  @Test
  @DisplayName("Test valueToTree(Object); when forty-two; then return toPrettyString is '42'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"JsonNode JacksonUtil.valueToTree(Object)"})
  void testValueToTree_whenFortyTwo_thenReturnToPrettyStringIs42() {
    // Arrange and Act
    JsonNode actualValueToTreeResult = JacksonUtil.<Object>valueToTree(42);

    // Assert
    assertTrue(actualValueToTreeResult instanceof IntNode);
    assertTrue(actualValueToTreeResult.traverse() instanceof TreeTraversingParser);
    assertEquals("42", actualValueToTreeResult.toPrettyString());
    assertEquals(JsonNodeType.NUMBER, actualValueToTreeResult.getNodeType());
    assertFalse(((IntNode) actualValueToTreeResult).isNaN());
    assertTrue(actualValueToTreeResult.isInt());
    assertTrue(actualValueToTreeResult.isIntegralNumber());
    assertTrue(actualValueToTreeResult.isNumber());
  }

  /**
   * Test {@link JacksonUtil#valueToTree(Object)}.
   * <ul>
   *   <li>When {@code null}.</li>
   *   <li>Then return {@link NullNode}.</li>
   * </ul>
   * <p>
   * Method under test: {@link JacksonUtil#valueToTree(Object)}
   */
  @Test
  @DisplayName("Test valueToTree(Object); when 'null'; then return NullNode")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"JsonNode JacksonUtil.valueToTree(Object)"})
  void testValueToTree_whenNull_thenReturnNullNode() {
    // Arrange and Act
    JsonNode actualValueToTreeResult = JacksonUtil.valueToTree(null);

    // Assert
    assertTrue(actualValueToTreeResult instanceof NullNode);
    assertTrue(actualValueToTreeResult.traverse() instanceof TreeTraversingParser);
    assertEquals("null", actualValueToTreeResult.toPrettyString());
    assertEquals(JsonNodeType.NULL, actualValueToTreeResult.getNodeType());
    assertTrue(actualValueToTreeResult.isNull());
  }

  /**
   * Test {@link JacksonUtil#valueToTree(Object)}.
   * <ul>
   *   <li>When one.</li>
   *   <li>Then return toPrettyString is {@code 1}.</li>
   * </ul>
   * <p>
   * Method under test: {@link JacksonUtil#valueToTree(Object)}
   */
  @Test
  @DisplayName("Test valueToTree(Object); when one; then return toPrettyString is '1'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"JsonNode JacksonUtil.valueToTree(Object)"})
  void testValueToTree_whenOne_thenReturnToPrettyStringIs1() {
    // Arrange and Act
    JsonNode actualValueToTreeResult = JacksonUtil.<Object>valueToTree(1);

    // Assert
    assertTrue(actualValueToTreeResult instanceof IntNode);
    assertTrue(actualValueToTreeResult.traverse() instanceof TreeTraversingParser);
    assertEquals("1", actualValueToTreeResult.toPrettyString());
    assertEquals(JsonNodeType.NUMBER, actualValueToTreeResult.getNodeType());
    assertFalse(((IntNode) actualValueToTreeResult).isNaN());
    assertTrue(actualValueToTreeResult.isInt());
    assertTrue(actualValueToTreeResult.isIntegralNumber());
    assertTrue(actualValueToTreeResult.isNumber());
  }

  /**
   * Test {@link JacksonUtil#valueToTree(Object)}.
   * <ul>
   *   <li>When {@code Value}.</li>
   *   <li>Then return toPrettyString is {@code "Value"}.</li>
   * </ul>
   * <p>
   * Method under test: {@link JacksonUtil#valueToTree(Object)}
   */
  @Test
  @DisplayName("Test valueToTree(Object); when 'Value'; then return toPrettyString is '\"Value\"'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"JsonNode JacksonUtil.valueToTree(Object)"})
  void testValueToTree_whenValue_thenReturnToPrettyStringIsValue() {
    // Arrange and Act
    JsonNode actualValueToTreeResult = JacksonUtil.valueToTree("Value");

    // Assert
    assertTrue(actualValueToTreeResult instanceof TextNode);
    assertTrue(actualValueToTreeResult.traverse() instanceof TreeTraversingParser);
    assertEquals("\"Value\"", actualValueToTreeResult.toPrettyString());
    assertEquals(JsonNodeType.STRING, actualValueToTreeResult.getNodeType());
    assertTrue(actualValueToTreeResult.isTextual());
  }

  /**
   * Test {@link JacksonUtil#writeValueAsBytes(Object)}.
   * <p>
   * Method under test: {@link JacksonUtil#writeValueAsBytes(Object)}
   */
  @Test
  @DisplayName("Test writeValueAsBytes(Object)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"byte[] JacksonUtil.writeValueAsBytes(Object)"})
  void testWriteValueAsBytes() {
    // Arrange
    BaseDataWithAdditionalInfo<UUIDBased> baseDataWithAdditionalInfo = mock(BaseDataWithAdditionalInfo.class);
    when(baseDataWithAdditionalInfo.getCreatedTime()).thenReturn(1L);
    when(baseDataWithAdditionalInfo.getId())
        .thenReturn(new AlarmId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")));

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> JacksonUtil.writeValueAsBytes(baseDataWithAdditionalInfo));
    verify(baseDataWithAdditionalInfo).getCreatedTime();
    verify(baseDataWithAdditionalInfo).getId();
  }

  /**
   * Test {@link JacksonUtil#writeValueAsBytes(Object)}.
   * <p>
   * Method under test: {@link JacksonUtil#writeValueAsBytes(Object)}
   */
  @Test
  @DisplayName("Test writeValueAsBytes(Object)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"byte[] JacksonUtil.writeValueAsBytes(Object)"})
  void testWriteValueAsBytes2() {
    // Arrange
    BaseDataWithAdditionalInfo<UUIDBased> baseDataWithAdditionalInfo = mock(BaseDataWithAdditionalInfo.class);
    when(baseDataWithAdditionalInfo.getCreatedTime()).thenReturn(1L);
    when(baseDataWithAdditionalInfo.getId())
        .thenReturn(new CustomerId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")));

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> JacksonUtil.writeValueAsBytes(baseDataWithAdditionalInfo));
    verify(baseDataWithAdditionalInfo).getCreatedTime();
    verify(baseDataWithAdditionalInfo).getId();
  }

  /**
   * Test {@link JacksonUtil#writeValueAsBytes(Object)}.
   * <p>
   * Method under test: {@link JacksonUtil#writeValueAsBytes(Object)}
   */
  @Test
  @DisplayName("Test writeValueAsBytes(Object)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"byte[] JacksonUtil.writeValueAsBytes(Object)"})
  void testWriteValueAsBytes3() {
    // Arrange
    Dashboard dashboard = new Dashboard(new Dashboard());
    dashboard.setConfiguration(NullNode.getInstance());

    // Act
    byte[] actualWriteValueAsBytesResult = JacksonUtil.writeValueAsBytes(new HomeDashboard(dashboard, true));

    // Assert
    assertEquals(226, actualWriteValueAsBytesResult.length);
    assertEquals(',', actualWriteValueAsBytesResult[213]);
    assertEquals(':', actualWriteValueAsBytesResult[208]);
    assertEquals(':', actualWriteValueAsBytesResult[220]);
    assertEquals('"', actualWriteValueAsBytesResult[207]);
    assertEquals('"', actualWriteValueAsBytesResult[214]);
    assertEquals('a', actualWriteValueAsBytesResult[202]);
    assertEquals('a', actualWriteValueAsBytesResult[216]);
    assertEquals('e', actualWriteValueAsBytesResult[218]);
    assertEquals('i', actualWriteValueAsBytesResult[204]);
    assertEquals('l', actualWriteValueAsBytesResult[211]);
    assertEquals('l', actualWriteValueAsBytesResult[223]);
    assertEquals('m', actualWriteValueAsBytesResult[217]);
    assertEquals('n', actualWriteValueAsBytesResult[206]);
    assertEquals('n', actualWriteValueAsBytesResult[215]);
    assertEquals('n', actualWriteValueAsBytesResult[221]);
    assertEquals('o', actualWriteValueAsBytesResult[205]);
    assertEquals('r', actualWriteValueAsBytesResult[201]);
    assertEquals('t', actualWriteValueAsBytesResult[203]);
    assertEquals('u', actualWriteValueAsBytesResult[210]);
    assertEquals('u', actualWriteValueAsBytesResult[222]);
    assertEquals('}', actualWriteValueAsBytesResult[225]);
  }

  /**
   * Test {@link JacksonUtil#writeValueAsBytes(Object)}.
   * <ul>
   *   <li>Given {@code 42}.</li>
   *   <li>Then return array length is one hundred ten.</li>
   * </ul>
   * <p>
   * Method under test: {@link JacksonUtil#writeValueAsBytes(Object)}
   */
  @Test
  @DisplayName("Test writeValueAsBytes(Object); given '42'; then return array length is one hundred ten")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"byte[] JacksonUtil.writeValueAsBytes(Object)"})
  void testWriteValueAsBytes_given42_thenReturnArrayLengthIsOneHundredTen() {
    // Arrange
    PSKBootstrapClientCredential pskBootstrapClientCredential = new PSKBootstrapClientCredential();
    pskBootstrapClientCredential.setClientPublicKeyOrId("42");
    pskBootstrapClientCredential.setClientSecretKey("EXAMPLEKEYwjalrXUtnFEMI/K7MDENG/bPxRfiCY");

    // Act
    byte[] actualWriteValueAsBytesResult = JacksonUtil.writeValueAsBytes(pskBootstrapClientCredential);

    // Assert
    assertEquals(110, actualWriteValueAsBytesResult.length);
    assertEquals('/', actualWriteValueAsBytesResult[91]);
    assertEquals('/', actualWriteValueAsBytesResult[99]);
    assertEquals('7', actualWriteValueAsBytesResult[93]);
    assertEquals('C', actualWriteValueAsBytesResult[106]);
    assertEquals('D', actualWriteValueAsBytesResult[95]);
    assertEquals('E', actualWriteValueAsBytesResult[88]);
    assertEquals('E', actualWriteValueAsBytesResult[96]);
    assertEquals('F', actualWriteValueAsBytesResult[87]);
    assertEquals('G', actualWriteValueAsBytesResult[98]);
    assertEquals('I', actualWriteValueAsBytesResult[90]);
    assertEquals('K', actualWriteValueAsBytesResult[92]);
    assertEquals('M', actualWriteValueAsBytesResult[89]);
    assertEquals('M', actualWriteValueAsBytesResult[94]);
    assertEquals('N', actualWriteValueAsBytesResult[97]);
    assertEquals('P', actualWriteValueAsBytesResult[101]);
    assertEquals('R', actualWriteValueAsBytesResult[103]);
    assertEquals('Y', actualWriteValueAsBytesResult[107]);
    assertEquals('"', actualWriteValueAsBytesResult[108]);
    assertEquals('b', actualWriteValueAsBytesResult[100]);
    assertEquals('f', actualWriteValueAsBytesResult[104]);
    assertEquals('i', actualWriteValueAsBytesResult[105]);
    assertEquals('n', actualWriteValueAsBytesResult[86]);
    assertEquals('t', actualWriteValueAsBytesResult[85]);
    assertEquals('x', actualWriteValueAsBytesResult[102]);
    assertEquals('}', actualWriteValueAsBytesResult[109]);
  }

  /**
   * Test {@link JacksonUtil#writeValueAsBytes(Object)}.
   * <ul>
   *   <li>Given {@link AlarmConditionFilter} (default constructor) Value is forty-two.</li>
   * </ul>
   * <p>
   * Method under test: {@link JacksonUtil#writeValueAsBytes(Object)}
   */
  @Test
  @DisplayName("Test writeValueAsBytes(Object); given AlarmConditionFilter (default constructor) Value is forty-two")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"byte[] JacksonUtil.writeValueAsBytes(Object)"})
  void testWriteValueAsBytes_givenAlarmConditionFilterValueIsFortyTwo() {
    // Arrange
    AlarmConditionFilter alarmConditionFilter = new AlarmConditionFilter();
    alarmConditionFilter.setKey(new AlarmConditionFilterKey(AlarmConditionKeyType.ATTRIBUTE, "Key"));
    alarmConditionFilter.setPredicate(mock(KeyFilterPredicate.class));
    alarmConditionFilter.setValue(42);
    alarmConditionFilter.setValueType(EntityKeyValueType.STRING);

    ArrayList<AlarmConditionFilter> condition = new ArrayList<>();
    condition.add(alarmConditionFilter);

    AlarmCondition alarmCondition = new AlarmCondition();
    alarmCondition.setCondition(condition);
    alarmCondition.setSpec(mock(AlarmConditionSpec.class));

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> JacksonUtil.writeValueAsBytes(alarmCondition));
  }

  /**
   * Test {@link JacksonUtil#writeValueAsBytes(Object)}.
   * <ul>
   *   <li>Given {@link AlarmConditionFilter} (default constructor) Value is {@code Value}.</li>
   * </ul>
   * <p>
   * Method under test: {@link JacksonUtil#writeValueAsBytes(Object)}
   */
  @Test
  @DisplayName("Test writeValueAsBytes(Object); given AlarmConditionFilter (default constructor) Value is 'Value'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"byte[] JacksonUtil.writeValueAsBytes(Object)"})
  void testWriteValueAsBytes_givenAlarmConditionFilterValueIsValue() {
    // Arrange
    AlarmConditionFilter alarmConditionFilter = new AlarmConditionFilter();
    alarmConditionFilter.setKey(new AlarmConditionFilterKey(AlarmConditionKeyType.ATTRIBUTE, "Key"));
    alarmConditionFilter.setPredicate(mock(KeyFilterPredicate.class));
    alarmConditionFilter.setValue("Value");
    alarmConditionFilter.setValueType(EntityKeyValueType.STRING);

    ArrayList<AlarmConditionFilter> condition = new ArrayList<>();
    condition.add(alarmConditionFilter);

    AlarmCondition alarmCondition = new AlarmCondition();
    alarmCondition.setCondition(condition);
    alarmCondition.setSpec(mock(AlarmConditionSpec.class));

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> JacksonUtil.writeValueAsBytes(alarmCondition));
  }

  /**
   * Test {@link JacksonUtil#writeValueAsBytes(Object)}.
   * <ul>
   *   <li>Given {@link ArrayList#ArrayList()}.</li>
   *   <li>When {@link AlarmCondition} (default constructor) Condition is {@link ArrayList#ArrayList()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link JacksonUtil#writeValueAsBytes(Object)}
   */
  @Test
  @DisplayName("Test writeValueAsBytes(Object); given ArrayList(); when AlarmCondition (default constructor) Condition is ArrayList()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"byte[] JacksonUtil.writeValueAsBytes(Object)"})
  void testWriteValueAsBytes_givenArrayList_whenAlarmConditionConditionIsArrayList() {
    // Arrange
    AlarmCondition alarmCondition = new AlarmCondition();
    alarmCondition.setCondition(new ArrayList<>());
    alarmCondition.setSpec(mock(AlarmConditionSpec.class));

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> JacksonUtil.writeValueAsBytes(alarmCondition));
  }

  /**
   * Test {@link JacksonUtil#writeValueAsBytes(Object)}.
   * <ul>
   *   <li>Given {@link HashSet#HashSet()}.</li>
   *   <li>Then return array length is two hundred twenty-four.</li>
   * </ul>
   * <p>
   * Method under test: {@link JacksonUtil#writeValueAsBytes(Object)}
   */
  @Test
  @DisplayName("Test writeValueAsBytes(Object); given HashSet(); then return array length is two hundred twenty-four")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"byte[] JacksonUtil.writeValueAsBytes(Object)"})
  void testWriteValueAsBytes_givenHashSet_thenReturnArrayLengthIsTwoHundredTwentyFour() {
    // Arrange
    Dashboard dashboard = new Dashboard();
    dashboard.setAssignedCustomers(new HashSet<>());
    dashboard.setConfiguration(NullNode.getInstance());

    // Act
    byte[] actualWriteValueAsBytesResult = JacksonUtil.writeValueAsBytes(new HomeDashboard(dashboard, true));

    // Assert
    assertEquals(224, actualWriteValueAsBytesResult.length);
    assertEquals(',', actualWriteValueAsBytesResult[211]);
    assertEquals(':', actualWriteValueAsBytesResult[206]);
    assertEquals(':', actualWriteValueAsBytesResult[218]);
    assertEquals('"', actualWriteValueAsBytesResult[205]);
    assertEquals('"', actualWriteValueAsBytesResult[217]);
    assertEquals('a', actualWriteValueAsBytesResult[200]);
    assertEquals('a', actualWriteValueAsBytesResult[214]);
    assertEquals('e', actualWriteValueAsBytesResult[216]);
    assertEquals('i', actualWriteValueAsBytesResult[202]);
    assertEquals('l', actualWriteValueAsBytesResult[209]);
    assertEquals('l', actualWriteValueAsBytesResult[210]);
    assertEquals('l', actualWriteValueAsBytesResult[221]);
    assertEquals('l', actualWriteValueAsBytesResult[222]);
    assertEquals('m', actualWriteValueAsBytesResult[215]);
    assertEquals('n', actualWriteValueAsBytesResult[204]);
    assertEquals('n', actualWriteValueAsBytesResult[213]);
    assertEquals('n', actualWriteValueAsBytesResult[219]);
    assertEquals('o', actualWriteValueAsBytesResult[203]);
    assertEquals('r', actualWriteValueAsBytesResult[199]);
    assertEquals('t', actualWriteValueAsBytesResult[201]);
    assertEquals('u', actualWriteValueAsBytesResult[208]);
    assertEquals('u', actualWriteValueAsBytesResult[220]);
    assertEquals('}', actualWriteValueAsBytesResult[223]);
  }

  /**
   * Test {@link JacksonUtil#writeValueAsBytes(Object)}.
   * <ul>
   *   <li>Given {@link RuntimeException#RuntimeException(String)} with empty string.</li>
   * </ul>
   * <p>
   * Method under test: {@link JacksonUtil#writeValueAsBytes(Object)}
   */
  @Test
  @DisplayName("Test writeValueAsBytes(Object); given RuntimeException(String) with empty string")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"byte[] JacksonUtil.writeValueAsBytes(Object)"})
  void testWriteValueAsBytes_givenRuntimeExceptionWithEmptyString() {
    // Arrange
    BaseData<UUIDBased> baseData = mock(BaseData.class);
    when(baseData.getId()).thenThrow(new RuntimeException(""));

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> JacksonUtil.writeValueAsBytes(baseData));
    verify(baseData).getId();
  }

  /**
   * Test {@link JacksonUtil#writeValueAsBytes(Object)}.
   * <ul>
   *   <li>Given zero.</li>
   *   <li>When {@link BaseData} {@link BaseData#getCreatedTime()} return zero.</li>
   * </ul>
   * <p>
   * Method under test: {@link JacksonUtil#writeValueAsBytes(Object)}
   */
  @Test
  @DisplayName("Test writeValueAsBytes(Object); given zero; when BaseData getCreatedTime() return zero")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"byte[] JacksonUtil.writeValueAsBytes(Object)"})
  void testWriteValueAsBytes_givenZero_whenBaseDataGetCreatedTimeReturnZero() {
    // Arrange
    BaseData<UUIDBased> baseData = mock(BaseData.class);
    when(baseData.getCreatedTime()).thenReturn(0L);
    when(baseData.getId()).thenReturn(new AdminSettingsId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")));

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> JacksonUtil.writeValueAsBytes(baseData));
    verify(baseData).getCreatedTime();
    verify(baseData).getId();
  }

  /**
   * Test {@link JacksonUtil#writeValueAsBytes(Object)}.
   * <ul>
   *   <li>Then return array length is one hundred eighty-seven.</li>
   * </ul>
   * <p>
   * Method under test: {@link JacksonUtil#writeValueAsBytes(Object)}
   */
  @Test
  @DisplayName("Test writeValueAsBytes(Object); then return array length is one hundred eighty-seven")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"byte[] JacksonUtil.writeValueAsBytes(Object)"})
  void testWriteValueAsBytes_thenReturnArrayLengthIsOneHundredEightySeven() {
    // Arrange
    DurationAlarmConditionSpec durationAlarmConditionSpec = new DurationAlarmConditionSpec();
    durationAlarmConditionSpec.setPredicate(new FilterPredicateValue<>(42L, 42L,
        new DynamicValue<>(DynamicValueSourceType.CURRENT_TENANT, "Source Attribute")));
    durationAlarmConditionSpec.setUnit(TimeUnit.NANOSECONDS);

    // Act
    byte[] actualWriteValueAsBytesResult = JacksonUtil.writeValueAsBytes(durationAlarmConditionSpec);

    // Assert
    assertEquals(187, actualWriteValueAsBytesResult.length);
    assertEquals(',', actualWriteValueAsBytesResult[168]);
    assertEquals(',', actualWriteValueAsBytesResult[18]);
    assertEquals(':', actualWriteValueAsBytesResult[178]);
    assertEquals('A', actualWriteValueAsBytesResult[12]);
    assertEquals('D', actualWriteValueAsBytesResult[9]);
    assertEquals('I', actualWriteValueAsBytesResult[14]);
    assertEquals('N', actualWriteValueAsBytesResult[Short.SIZE]);
    assertEquals('O', actualWriteValueAsBytesResult[15]);
    assertEquals('R', actualWriteValueAsBytesResult[11]);
    assertEquals('T', actualWriteValueAsBytesResult[13]);
    assertEquals('U', actualWriteValueAsBytesResult[10]);
    assertEquals('"', actualWriteValueAsBytesResult[167]);
    assertEquals('"', actualWriteValueAsBytesResult[169]);
    assertEquals('"', actualWriteValueAsBytesResult[177]);
    assertEquals('"', actualWriteValueAsBytesResult[19]);
    assertEquals('a', actualWriteValueAsBytesResult[180]);
    assertEquals('b', actualWriteValueAsBytesResult[163]);
    assertEquals('e', actualWriteValueAsBytesResult[166]);
    assertEquals('e', actualWriteValueAsBytesResult[173]);
    assertEquals('e', actualWriteValueAsBytesResult[183]);
    assertEquals('f', actualWriteValueAsBytesResult[179]);
    assertEquals('h', actualWriteValueAsBytesResult[172]);
    assertEquals('i', actualWriteValueAsBytesResult[162]);
    assertEquals('i', actualWriteValueAsBytesResult[170]);
    assertEquals('i', actualWriteValueAsBytesResult[175]);
    assertEquals('i', actualWriteValueAsBytesResult[22]);
    assertEquals('l', actualWriteValueAsBytesResult[181]);
    assertEquals('n', actualWriteValueAsBytesResult[171]);
    assertEquals('n', actualWriteValueAsBytesResult[21]);
    assertEquals('r', actualWriteValueAsBytesResult[174]);
    assertEquals('s', actualWriteValueAsBytesResult[182]);
    assertEquals('t', actualWriteValueAsBytesResult[165]);
    assertEquals('t', actualWriteValueAsBytesResult[176]);
    assertEquals('t', actualWriteValueAsBytesResult[23]);
    assertEquals('u', actualWriteValueAsBytesResult[164]);
    assertEquals('u', actualWriteValueAsBytesResult[20]);
    assertEquals('}', actualWriteValueAsBytesResult[184]);
    assertEquals('}', actualWriteValueAsBytesResult[185]);
    assertEquals('}', actualWriteValueAsBytesResult[186]);
  }

  /**
   * Test {@link JacksonUtil#writeValueAsBytes(Object)}.
   * <ul>
   *   <li>Then return array length is one hundred five.</li>
   * </ul>
   * <p>
   * Method under test: {@link JacksonUtil#writeValueAsBytes(Object)}
   */
  @Test
  @DisplayName("Test writeValueAsBytes(Object); then return array length is one hundred five")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"byte[] JacksonUtil.writeValueAsBytes(Object)"})
  void testWriteValueAsBytes_thenReturnArrayLengthIsOneHundredFive() {
    // Arrange and Act
    byte[] actualWriteValueAsBytesResult = JacksonUtil.writeValueAsBytes(new CoapDeviceTransportConfiguration());

    // Assert
    assertEquals(105, actualWriteValueAsBytesResult.length);
    assertEquals(',', actualWriteValueAsBytesResult[14]);
    assertEquals(':', actualWriteValueAsBytesResult[99]);
    assertEquals('A', actualWriteValueAsBytesResult[11]);
    assertEquals('C', actualWriteValueAsBytesResult[9]);
    assertEquals('M', actualWriteValueAsBytesResult[21]);
    assertEquals('O', actualWriteValueAsBytesResult[10]);
    assertEquals('P', actualWriteValueAsBytesResult[12]);
    assertEquals('T', actualWriteValueAsBytesResult[80]);
    assertEquals('W', actualWriteValueAsBytesResult[92]);
    assertEquals('"', actualWriteValueAsBytesResult[15]);
    assertEquals('"', actualWriteValueAsBytesResult[98]);
    assertEquals('a', actualWriteValueAsBytesResult[82]);
    assertEquals('d', actualWriteValueAsBytesResult[23]);
    assertEquals('d', actualWriteValueAsBytesResult[95]);
    assertEquals('e', actualWriteValueAsBytesResult[19]);
    assertEquals('i', actualWriteValueAsBytesResult[86]);
    assertEquals('i', actualWriteValueAsBytesResult[89]);
    assertEquals('i', actualWriteValueAsBytesResult[93]);
    assertEquals('l', actualWriteValueAsBytesResult[102]);
    assertEquals('l', actualWriteValueAsBytesResult[103]);
    assertEquals('m', actualWriteValueAsBytesResult[85]);
    assertEquals('n', actualWriteValueAsBytesResult[100]);
    assertEquals('n', actualWriteValueAsBytesResult[83]);
    assertEquals('n', actualWriteValueAsBytesResult[91]);
    assertEquals('n', actualWriteValueAsBytesResult[94]);
    assertEquals('o', actualWriteValueAsBytesResult[17]);
    assertEquals('o', actualWriteValueAsBytesResult[90]);
    assertEquals('o', actualWriteValueAsBytesResult[96]);
    assertEquals('p', actualWriteValueAsBytesResult[Short.SIZE]);
    assertEquals('r', actualWriteValueAsBytesResult[20]);
    assertEquals('r', actualWriteValueAsBytesResult[81]);
    assertEquals('s', actualWriteValueAsBytesResult[84]);
    assertEquals('s', actualWriteValueAsBytesResult[87]);
    assertEquals('s', actualWriteValueAsBytesResult[88]);
    assertEquals('u', actualWriteValueAsBytesResult[101]);
    assertEquals('w', actualWriteValueAsBytesResult[18]);
    assertEquals('w', actualWriteValueAsBytesResult[97]);
    assertEquals('}', actualWriteValueAsBytesResult[104]);
  }

  /**
   * Test {@link JacksonUtil#writeValueAsBytes(Object)}.
   * <ul>
   *   <li>Then return array length is seventy-two.</li>
   * </ul>
   * <p>
   * Method under test: {@link JacksonUtil#writeValueAsBytes(Object)}
   */
  @Test
  @DisplayName("Test writeValueAsBytes(Object); then return array length is seventy-two")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"byte[] JacksonUtil.writeValueAsBytes(Object)"})
  void testWriteValueAsBytes_thenReturnArrayLengthIsSeventyTwo() {
    // Arrange and Act
    byte[] actualWriteValueAsBytesResult = JacksonUtil.writeValueAsBytes(new PSKBootstrapClientCredential());

    // Assert
    assertEquals(72, actualWriteValueAsBytesResult.length);
    assertEquals(',', actualWriteValueAsBytesResult[48]);
    assertEquals(':', actualWriteValueAsBytesResult[66]);
    assertEquals('K', actualWriteValueAsBytesResult[62]);
    assertEquals('S', actualWriteValueAsBytesResult[56]);
    assertEquals('"', actualWriteValueAsBytesResult[49]);
    assertEquals('"', actualWriteValueAsBytesResult[65]);
    assertEquals('c', actualWriteValueAsBytesResult[50]);
    assertEquals('c', actualWriteValueAsBytesResult[58]);
    assertEquals('e', actualWriteValueAsBytesResult[53]);
    assertEquals('e', actualWriteValueAsBytesResult[57]);
    assertEquals('e', actualWriteValueAsBytesResult[60]);
    assertEquals('i', actualWriteValueAsBytesResult[52]);
    assertEquals('l', actualWriteValueAsBytesResult[47]);
    assertEquals('l', actualWriteValueAsBytesResult[70]);
    assertEquals('n', actualWriteValueAsBytesResult[54]);
    assertEquals('n', actualWriteValueAsBytesResult[67]);
    assertEquals('r', actualWriteValueAsBytesResult[59]);
    assertEquals('t', actualWriteValueAsBytesResult[55]);
    assertEquals('t', actualWriteValueAsBytesResult[61]);
    assertEquals('u', actualWriteValueAsBytesResult[68]);
    assertEquals('y', actualWriteValueAsBytesResult[Double.SIZE]);
    assertEquals('}', actualWriteValueAsBytesResult[71]);
  }

  /**
   * Test {@link JacksonUtil#writeValueAsBytes(Object)}.
   * <ul>
   *   <li>Then return array length is three hundred ninety-five.</li>
   * </ul>
   * <p>
   * Method under test: {@link JacksonUtil#writeValueAsBytes(Object)}
   */
  @Test
  @DisplayName("Test writeValueAsBytes(Object); then return array length is three hundred ninety-five")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"byte[] JacksonUtil.writeValueAsBytes(Object)"})
  void testWriteValueAsBytes_thenReturnArrayLengthIsThreeHundredNinetyFive() {
    // Arrange
    ImageDescriptor previewDescriptor = new ImageDescriptor();
    previewDescriptor.setEtag("Etag");
    previewDescriptor.setHeight(1);
    previewDescriptor.setMediaType("Media Type");
    previewDescriptor.setPreviewDescriptor(new ImageDescriptor());
    previewDescriptor.setSize(3L);
    previewDescriptor.setWidth(1);

    ImageDescriptor previewDescriptor2 = new ImageDescriptor();
    previewDescriptor2.setEtag("Etag");
    previewDescriptor2.setHeight(1);
    previewDescriptor2.setMediaType("Media Type");
    previewDescriptor2.setPreviewDescriptor(previewDescriptor);
    previewDescriptor2.setSize(3L);
    previewDescriptor2.setWidth(1);

    ImageDescriptor previewDescriptor3 = new ImageDescriptor();
    previewDescriptor3.setEtag("Etag");
    previewDescriptor3.setHeight(1);
    previewDescriptor3.setMediaType("Media Type");
    previewDescriptor3.setPreviewDescriptor(previewDescriptor2);
    previewDescriptor3.setSize(3L);
    previewDescriptor3.setWidth(1);

    ImageDescriptor imageDescriptor = new ImageDescriptor();
    imageDescriptor.setEtag("Etag");
    imageDescriptor.setHeight(1);
    imageDescriptor.setMediaType("Media Type");
    imageDescriptor.setPreviewDescriptor(previewDescriptor3);
    imageDescriptor.setSize(3L);
    imageDescriptor.setWidth(1);

    // Act
    byte[] actualWriteValueAsBytesResult = JacksonUtil.writeValueAsBytes(imageDescriptor);

    // Assert
    assertEquals(395, actualWriteValueAsBytesResult.length);
    assertEquals(' ', actualWriteValueAsBytesResult[19]);
    assertEquals(',', actualWriteValueAsBytesResult[370]);
    assertEquals(',', actualWriteValueAsBytesResult[381]);
    assertEquals('0', actualWriteValueAsBytesResult[380]);
    assertEquals('0', actualWriteValueAsBytesResult[389]);
    assertEquals(':', actualWriteValueAsBytesResult[12]);
    assertEquals(':', actualWriteValueAsBytesResult[379]);
    assertEquals(':', actualWriteValueAsBytesResult[388]);
    assertEquals('M', actualWriteValueAsBytesResult[14]);
    assertEquals('T', actualWriteValueAsBytesResult[20]);
    assertEquals('T', actualWriteValueAsBytesResult[7]);
    assertEquals('"', actualWriteValueAsBytesResult[371]);
    assertEquals('"', actualWriteValueAsBytesResult[378]);
    assertEquals('"', actualWriteValueAsBytesResult[382]);
    assertEquals('"', actualWriteValueAsBytesResult[387]);
    assertEquals('a', actualWriteValueAsBytesResult[18]);
    assertEquals('a', actualWriteValueAsBytesResult[6]);
    assertEquals('d', actualWriteValueAsBytesResult[4]);
    assertEquals('d', actualWriteValueAsBytesResult[Short.SIZE]);
    assertEquals('e', actualWriteValueAsBytesResult[10]);
    assertEquals('e', actualWriteValueAsBytesResult[15]);
    assertEquals('e', actualWriteValueAsBytesResult[23]);
    assertEquals('e', actualWriteValueAsBytesResult[373]);
    assertEquals('e', actualWriteValueAsBytesResult[386]);
    assertEquals('g', actualWriteValueAsBytesResult[375]);
    assertEquals('h', actualWriteValueAsBytesResult[372]);
    assertEquals('h', actualWriteValueAsBytesResult[376]);
    assertEquals('i', actualWriteValueAsBytesResult[17]);
    assertEquals('i', actualWriteValueAsBytesResult[374]);
    assertEquals('i', actualWriteValueAsBytesResult[384]);
    assertEquals('i', actualWriteValueAsBytesResult[5]);
    assertEquals('m', actualWriteValueAsBytesResult[2]);
    assertEquals('p', actualWriteValueAsBytesResult[22]);
    assertEquals('p', actualWriteValueAsBytesResult[9]);
    assertEquals('s', actualWriteValueAsBytesResult[383]);
    assertEquals('t', actualWriteValueAsBytesResult[377]);
    assertEquals('y', actualWriteValueAsBytesResult[21]);
    assertEquals('y', actualWriteValueAsBytesResult[8]);
    assertEquals('z', actualWriteValueAsBytesResult[385]);
    assertEquals('}', actualWriteValueAsBytesResult[390]);
    assertEquals('}', actualWriteValueAsBytesResult[391]);
    assertEquals('}', actualWriteValueAsBytesResult[392]);
    assertEquals('}', actualWriteValueAsBytesResult[393]);
    assertEquals('}', actualWriteValueAsBytesResult[394]);
  }

  /**
   * Test {@link JacksonUtil#writeValueAsBytes(Object)}.
   * <ul>
   *   <li>Then return array length is two hundred twenty-seven.</li>
   * </ul>
   * <p>
   * Method under test: {@link JacksonUtil#writeValueAsBytes(Object)}
   */
  @Test
  @DisplayName("Test writeValueAsBytes(Object); then return array length is two hundred twenty-seven")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"byte[] JacksonUtil.writeValueAsBytes(Object)"})
  void testWriteValueAsBytes_thenReturnArrayLengthIsTwoHundredTwentySeven() {
    // Arrange
    Dashboard dashboard = new Dashboard();
    dashboard.setConfiguration(MissingNode.getInstance());

    // Act
    byte[] actualWriteValueAsBytesResult = JacksonUtil.writeValueAsBytes(new HomeDashboard(dashboard, false));

    // Assert
    assertEquals(227, actualWriteValueAsBytesResult.length);
    assertEquals(',', actualWriteValueAsBytesResult[214]);
    assertEquals(':', actualWriteValueAsBytesResult[209]);
    assertEquals(':', actualWriteValueAsBytesResult[221]);
    assertEquals('"', actualWriteValueAsBytesResult[208]);
    assertEquals('"', actualWriteValueAsBytesResult[215]);
    assertEquals('"', actualWriteValueAsBytesResult[220]);
    assertEquals('a', actualWriteValueAsBytesResult[203]);
    assertEquals('a', actualWriteValueAsBytesResult[217]);
    assertEquals('e', actualWriteValueAsBytesResult[219]);
    assertEquals('i', actualWriteValueAsBytesResult[205]);
    assertEquals('l', actualWriteValueAsBytesResult[213]);
    assertEquals('l', actualWriteValueAsBytesResult[225]);
    assertEquals('m', actualWriteValueAsBytesResult[218]);
    assertEquals('n', actualWriteValueAsBytesResult[210]);
    assertEquals('n', actualWriteValueAsBytesResult[216]);
    assertEquals('n', actualWriteValueAsBytesResult[222]);
    assertEquals('o', actualWriteValueAsBytesResult[206]);
    assertEquals('r', actualWriteValueAsBytesResult[202]);
    assertEquals('t', actualWriteValueAsBytesResult[204]);
    assertEquals('u', actualWriteValueAsBytesResult[211]);
    assertEquals('u', actualWriteValueAsBytesResult[223]);
    assertEquals('}', actualWriteValueAsBytesResult[226]);
  }

  /**
   * Test {@link JacksonUtil#writeValueAsBytes(Object)}.
   * <ul>
   *   <li>Then return array length is two hundred twenty-six.</li>
   * </ul>
   * <p>
   * Method under test: {@link JacksonUtil#writeValueAsBytes(Object)}
   */
  @Test
  @DisplayName("Test writeValueAsBytes(Object); then return array length is two hundred twenty-six")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"byte[] JacksonUtil.writeValueAsBytes(Object)"})
  void testWriteValueAsBytes_thenReturnArrayLengthIsTwoHundredTwentySix() {
    // Arrange
    Dashboard dashboard = new Dashboard();
    dashboard.setConfiguration(MissingNode.getInstance());

    // Act
    byte[] actualWriteValueAsBytesResult = JacksonUtil.writeValueAsBytes(new HomeDashboard(dashboard, true));

    // Assert
    assertEquals(226, actualWriteValueAsBytesResult.length);
    assertEquals(',', actualWriteValueAsBytesResult[213]);
    assertEquals(':', actualWriteValueAsBytesResult[208]);
    assertEquals(':', actualWriteValueAsBytesResult[220]);
    assertEquals('"', actualWriteValueAsBytesResult[207]);
    assertEquals('"', actualWriteValueAsBytesResult[214]);
    assertEquals('a', actualWriteValueAsBytesResult[202]);
    assertEquals('a', actualWriteValueAsBytesResult[216]);
    assertEquals('e', actualWriteValueAsBytesResult[218]);
    assertEquals('i', actualWriteValueAsBytesResult[204]);
    assertEquals('l', actualWriteValueAsBytesResult[211]);
    assertEquals('l', actualWriteValueAsBytesResult[223]);
    assertEquals('m', actualWriteValueAsBytesResult[217]);
    assertEquals('n', actualWriteValueAsBytesResult[206]);
    assertEquals('n', actualWriteValueAsBytesResult[215]);
    assertEquals('n', actualWriteValueAsBytesResult[221]);
    assertEquals('o', actualWriteValueAsBytesResult[205]);
    assertEquals('r', actualWriteValueAsBytesResult[201]);
    assertEquals('t', actualWriteValueAsBytesResult[203]);
    assertEquals('u', actualWriteValueAsBytesResult[210]);
    assertEquals('u', actualWriteValueAsBytesResult[222]);
    assertEquals('}', actualWriteValueAsBytesResult[225]);
  }

  /**
   * Test {@link JacksonUtil#writeValueAsBytes(Object)}.
   * <ul>
   *   <li>Then return array length is two hundred twenty-six.</li>
   * </ul>
   * <p>
   * Method under test: {@link JacksonUtil#writeValueAsBytes(Object)}
   */
  @Test
  @DisplayName("Test writeValueAsBytes(Object); then return array length is two hundred twenty-six")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"byte[] JacksonUtil.writeValueAsBytes(Object)"})
  void testWriteValueAsBytes_thenReturnArrayLengthIsTwoHundredTwentySix2() {
    // Arrange
    Dashboard dashboard = new Dashboard();
    dashboard.setConfiguration(NullNode.getInstance());

    // Act
    byte[] actualWriteValueAsBytesResult = JacksonUtil.writeValueAsBytes(new HomeDashboard(dashboard, true));

    // Assert
    assertEquals(226, actualWriteValueAsBytesResult.length);
    assertEquals(',', actualWriteValueAsBytesResult[213]);
    assertEquals(':', actualWriteValueAsBytesResult[208]);
    assertEquals(':', actualWriteValueAsBytesResult[220]);
    assertEquals('"', actualWriteValueAsBytesResult[207]);
    assertEquals('"', actualWriteValueAsBytesResult[214]);
    assertEquals('a', actualWriteValueAsBytesResult[202]);
    assertEquals('a', actualWriteValueAsBytesResult[216]);
    assertEquals('e', actualWriteValueAsBytesResult[218]);
    assertEquals('i', actualWriteValueAsBytesResult[204]);
    assertEquals('l', actualWriteValueAsBytesResult[211]);
    assertEquals('l', actualWriteValueAsBytesResult[223]);
    assertEquals('m', actualWriteValueAsBytesResult[217]);
    assertEquals('n', actualWriteValueAsBytesResult[206]);
    assertEquals('n', actualWriteValueAsBytesResult[215]);
    assertEquals('n', actualWriteValueAsBytesResult[221]);
    assertEquals('o', actualWriteValueAsBytesResult[205]);
    assertEquals('r', actualWriteValueAsBytesResult[201]);
    assertEquals('t', actualWriteValueAsBytesResult[203]);
    assertEquals('u', actualWriteValueAsBytesResult[210]);
    assertEquals('u', actualWriteValueAsBytesResult[222]);
    assertEquals('}', actualWriteValueAsBytesResult[225]);
  }

  /**
   * Test {@link JacksonUtil#writeValueAsBytes(Object)}.
   * <ul>
   *   <li>When {@link AdminSettings#AdminSettings()}.</li>
   *   <li>Then return array length is seventy-one.</li>
   * </ul>
   * <p>
   * Method under test: {@link JacksonUtil#writeValueAsBytes(Object)}
   */
  @Test
  @DisplayName("Test writeValueAsBytes(Object); when AdminSettings(); then return array length is seventy-one")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"byte[] JacksonUtil.writeValueAsBytes(Object)"})
  void testWriteValueAsBytes_whenAdminSettings_thenReturnArrayLengthIsSeventyOne() {
    // Arrange and Act
    byte[] actualWriteValueAsBytesResult = JacksonUtil.writeValueAsBytes(new AdminSettings());

    // Assert
    assertEquals(71, actualWriteValueAsBytesResult.length);
    assertEquals(',', actualWriteValueAsBytesResult[53]);
    assertEquals(':', actualWriteValueAsBytesResult[48]);
    assertEquals(':', actualWriteValueAsBytesResult[65]);
    assertEquals('V', actualWriteValueAsBytesResult[59]);
    assertEquals('"', actualWriteValueAsBytesResult[47]);
    assertEquals('"', actualWriteValueAsBytesResult[54]);
    assertEquals('"', actualWriteValueAsBytesResult[Double.SIZE]);
    assertEquals('a', actualWriteValueAsBytesResult[60]);
    assertEquals('j', actualWriteValueAsBytesResult[55]);
    assertEquals('l', actualWriteValueAsBytesResult[52]);
    assertEquals('l', actualWriteValueAsBytesResult[61]);
    assertEquals('l', actualWriteValueAsBytesResult[68]);
    assertEquals('n', actualWriteValueAsBytesResult[49]);
    assertEquals('n', actualWriteValueAsBytesResult[58]);
    assertEquals('n', actualWriteValueAsBytesResult[66]);
    assertEquals('o', actualWriteValueAsBytesResult[57]);
    assertEquals('s', actualWriteValueAsBytesResult[56]);
    assertEquals('u', actualWriteValueAsBytesResult[50]);
    assertEquals('u', actualWriteValueAsBytesResult[62]);
    assertEquals('u', actualWriteValueAsBytesResult[67]);
    assertEquals('y', actualWriteValueAsBytesResult[46]);
    assertEquals('}', actualWriteValueAsBytesResult[70]);
  }

  /**
   * Test {@link JacksonUtil#writeValueAsBytes(Object)}.
   * <ul>
   *   <li>When {@link BaseData} {@link BaseData#getCreatedTime()} return one.</li>
   * </ul>
   * <p>
   * Method under test: {@link JacksonUtil#writeValueAsBytes(Object)}
   */
  @Test
  @DisplayName("Test writeValueAsBytes(Object); when BaseData getCreatedTime() return one")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"byte[] JacksonUtil.writeValueAsBytes(Object)"})
  void testWriteValueAsBytes_whenBaseDataGetCreatedTimeReturnOne() {
    // Arrange
    BaseData<UUIDBased> baseData = mock(BaseData.class);
    when(baseData.getCreatedTime()).thenReturn(1L);
    when(baseData.getId()).thenReturn(new AdminSettingsId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")));

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> JacksonUtil.writeValueAsBytes(baseData));
    verify(baseData).getCreatedTime();
    verify(baseData).getId();
  }

  /**
   * Test {@link JacksonUtil#writeValueAsBytes(Object)}.
   * <ul>
   *   <li>When {@link BaseDataWithAdditionalInfo} {@link BaseData#getCreatedTime()} return zero.</li>
   * </ul>
   * <p>
   * Method under test: {@link JacksonUtil#writeValueAsBytes(Object)}
   */
  @Test
  @DisplayName("Test writeValueAsBytes(Object); when BaseDataWithAdditionalInfo getCreatedTime() return zero")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"byte[] JacksonUtil.writeValueAsBytes(Object)"})
  void testWriteValueAsBytes_whenBaseDataWithAdditionalInfoGetCreatedTimeReturnZero() {
    // Arrange
    BaseDataWithAdditionalInfo<UUIDBased> baseDataWithAdditionalInfo = mock(BaseDataWithAdditionalInfo.class);
    when(baseDataWithAdditionalInfo.getCreatedTime()).thenReturn(0L);
    when(baseDataWithAdditionalInfo.getId())
        .thenReturn(new AlarmId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")));

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> JacksonUtil.writeValueAsBytes(baseDataWithAdditionalInfo));
    verify(baseDataWithAdditionalInfo).getCreatedTime();
    verify(baseDataWithAdditionalInfo).getId();
  }

  /**
   * Test {@link JacksonUtil#writeValueAsBytes(Object)}.
   * <ul>
   *   <li>When {@link Dashboard#Dashboard()}.</li>
   *   <li>Then return array length is one hundred ninety-eight.</li>
   * </ul>
   * <p>
   * Method under test: {@link JacksonUtil#writeValueAsBytes(Object)}
   */
  @Test
  @DisplayName("Test writeValueAsBytes(Object); when Dashboard(); then return array length is one hundred ninety-eight")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"byte[] JacksonUtil.writeValueAsBytes(Object)"})
  void testWriteValueAsBytes_whenDashboard_thenReturnArrayLengthIsOneHundredNinetyEight() {
    // Arrange and Act
    byte[] actualWriteValueAsBytesResult = JacksonUtil.writeValueAsBytes(new Dashboard());

    // Assert
    assertEquals(198, actualWriteValueAsBytesResult.length);
    assertEquals(',', actualWriteValueAsBytesResult[185]);
    assertEquals(':', actualWriteValueAsBytesResult[180]);
    assertEquals(':', actualWriteValueAsBytesResult[192]);
    assertEquals('"', actualWriteValueAsBytesResult[179]);
    assertEquals('"', actualWriteValueAsBytesResult[186]);
    assertEquals('"', actualWriteValueAsBytesResult[191]);
    assertEquals('a', actualWriteValueAsBytesResult[174]);
    assertEquals('a', actualWriteValueAsBytesResult[188]);
    assertEquals('e', actualWriteValueAsBytesResult[190]);
    assertEquals('i', actualWriteValueAsBytesResult[176]);
    assertEquals('l', actualWriteValueAsBytesResult[183]);
    assertEquals('l', actualWriteValueAsBytesResult[184]);
    assertEquals('l', actualWriteValueAsBytesResult[195]);
    assertEquals('l', actualWriteValueAsBytesResult[196]);
    assertEquals('m', actualWriteValueAsBytesResult[189]);
    assertEquals('n', actualWriteValueAsBytesResult[178]);
    assertEquals('n', actualWriteValueAsBytesResult[181]);
    assertEquals('n', actualWriteValueAsBytesResult[187]);
    assertEquals('n', actualWriteValueAsBytesResult[193]);
    assertEquals('o', actualWriteValueAsBytesResult[177]);
    assertEquals('r', actualWriteValueAsBytesResult[173]);
    assertEquals('t', actualWriteValueAsBytesResult[175]);
    assertEquals('u', actualWriteValueAsBytesResult[182]);
    assertEquals('u', actualWriteValueAsBytesResult[194]);
    assertEquals('}', actualWriteValueAsBytesResult[197]);
  }

  /**
   * Test {@link JacksonUtil#writeValueAsBytes(Object)}.
   * <ul>
   *   <li>When {@code null}.</li>
   *   <li>Then return {@code null} Bytes is {@code UTF-8}.</li>
   * </ul>
   * <p>
   * Method under test: {@link JacksonUtil#writeValueAsBytes(Object)}
   */
  @Test
  @DisplayName("Test writeValueAsBytes(Object); when 'null'; then return 'null' Bytes is 'UTF-8'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"byte[] JacksonUtil.writeValueAsBytes(Object)"})
  void testWriteValueAsBytes_whenNull_thenReturnNullBytesIsUtf8() throws UnsupportedEncodingException {
    // Arrange and Act
    byte[] actualWriteValueAsBytesResult = JacksonUtil.writeValueAsBytes(null);

    // Assert
    assertArrayEquals("null".getBytes("UTF-8"), actualWriteValueAsBytesResult);
  }

  /**
   * Test {@link JacksonUtil#writeValueAsBytes(Object)}.
   * <ul>
   *   <li>When {@link TenantProfile#TenantProfile()}.</li>
   *   <li>Then return array length is {@code 2023}.</li>
   * </ul>
   * <p>
   * Method under test: {@link JacksonUtil#writeValueAsBytes(Object)}
   */
  @Test
  @DisplayName("Test writeValueAsBytes(Object); when TenantProfile(); then return array length is '2023'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"byte[] JacksonUtil.writeValueAsBytes(Object)"})
  void testWriteValueAsBytes_whenTenantProfile_thenReturnArrayLengthIs2023() {
    // Arrange and Act
    byte[] actualWriteValueAsBytesResult = JacksonUtil.writeValueAsBytes(new TenantProfile());

    // Assert
    assertEquals(2023, actualWriteValueAsBytesResult.length);
    assertEquals(',', actualWriteValueAsBytesResult[2006]);
    assertEquals(':', actualWriteValueAsBytesResult[2000]);
    assertEquals(':', actualWriteValueAsBytesResult[2016]);
    assertEquals('"', actualWriteValueAsBytesResult[1999]);
    assertEquals('"', actualWriteValueAsBytesResult[2007]);
    assertEquals('"', actualWriteValueAsBytesResult[2015]);
    assertEquals('a', actualWriteValueAsBytesResult[2011]);
    assertEquals('a', actualWriteValueAsBytesResult[2018]);
    assertEquals('d', actualWriteValueAsBytesResult[2008]);
    assertEquals('e', actualWriteValueAsBytesResult[2009]);
    assertEquals('e', actualWriteValueAsBytesResult[2021]);
    assertEquals('f', actualWriteValueAsBytesResult[2010]);
    assertEquals('f', actualWriteValueAsBytesResult[2017]);
    assertEquals('l', actualWriteValueAsBytesResult[2003]);
    assertEquals('l', actualWriteValueAsBytesResult[2004]);
    assertEquals('l', actualWriteValueAsBytesResult[2013]);
    assertEquals('l', actualWriteValueAsBytesResult[2019]);
    assertEquals('n', actualWriteValueAsBytesResult[1998]);
    assertEquals('n', actualWriteValueAsBytesResult[2001]);
    assertEquals('s', actualWriteValueAsBytesResult[2020]);
    assertEquals('t', actualWriteValueAsBytesResult[2014]);
    assertEquals('u', actualWriteValueAsBytesResult[2002]);
    assertEquals('u', actualWriteValueAsBytesResult[2012]);
    assertEquals('}', actualWriteValueAsBytesResult[2005]);
    assertEquals('}', actualWriteValueAsBytesResult[2022]);
  }

  /**
   * Test {@link JacksonUtil#getSafely(JsonNode, String[])}.
   * <ul>
   *   <li>When {@link ArrayNode#ArrayNode(JsonNodeFactory)} with nf is withExactBigDecimals {@code true}.</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link JacksonUtil#getSafely(JsonNode, String[])}
   */
  @Test
  @DisplayName("Test getSafely(JsonNode, String[]); when ArrayNode(JsonNodeFactory) with nf is withExactBigDecimals 'true'; then return 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"JsonNode JacksonUtil.getSafely(JsonNode, String[])"})
  void testGetSafely_whenArrayNodeWithNfIsWithExactBigDecimalsTrue_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull(JacksonUtil.getSafely(new ArrayNode(JsonNodeFactory.withExactBigDecimals(true)), "Path"));
  }

  /**
   * Test {@link JacksonUtil#getSafely(JsonNode, String[])}.
   * <ul>
   *   <li>When Instance.</li>
   *   <li>Then return {@link MissingNode}.</li>
   * </ul>
   * <p>
   * Method under test: {@link JacksonUtil#getSafely(JsonNode, String[])}
   */
  @Test
  @DisplayName("Test getSafely(JsonNode, String[]); when Instance; then return MissingNode")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"JsonNode JacksonUtil.getSafely(JsonNode, String[])"})
  void testGetSafely_whenInstance_thenReturnMissingNode() {
    // Arrange and Act
    JsonNode actualSafely = JacksonUtil.getSafely(MissingNode.getInstance());

    // Assert
    assertTrue(actualSafely instanceof MissingNode);
    assertTrue(actualSafely.traverse() instanceof TreeTraversingParser);
    assertEquals("", actualSafely.toPrettyString());
    assertEquals(0, actualSafely.size());
    assertEquals(JsonNodeType.MISSING, actualSafely.getNodeType());
    assertFalse(actualSafely.isArray());
    assertFalse(actualSafely.isBigDecimal());
    assertFalse(actualSafely.isBigInteger());
    assertFalse(actualSafely.isBinary());
    assertFalse(actualSafely.isBoolean());
    assertFalse(actualSafely.isContainerNode());
    assertFalse(actualSafely.isDouble());
    assertFalse(actualSafely.isFloat());
    assertFalse(actualSafely.isFloatingPointNumber());
    assertFalse(actualSafely.isInt());
    assertFalse(actualSafely.isIntegralNumber());
    assertFalse(actualSafely.isLong());
    assertFalse(actualSafely.isNull());
    assertFalse(actualSafely.isNumber());
    assertFalse(actualSafely.isObject());
    assertFalse(actualSafely.isPojo());
    assertFalse(actualSafely.isShort());
    assertFalse(actualSafely.isTextual());
    assertFalse(actualSafely.isValueNode());
    assertFalse(actualSafely.iterator().hasNext());
    assertTrue(actualSafely.isEmpty());
    assertTrue(actualSafely.isMissingNode());
  }

  /**
   * Test {@link JacksonUtil#getSafely(JsonNode, String[])}.
   * <ul>
   *   <li>When Instance.</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link JacksonUtil#getSafely(JsonNode, String[])}
   */
  @Test
  @DisplayName("Test getSafely(JsonNode, String[]); when Instance; then return 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"JsonNode JacksonUtil.getSafely(JsonNode, String[])"})
  void testGetSafely_whenInstance_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull(JacksonUtil.getSafely(MissingNode.getInstance(), "Path"));
  }

  /**
   * Test {@link JacksonUtil#getSafely(JsonNode, String[])}.
   * <ul>
   *   <li>When {@code null}.</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link JacksonUtil#getSafely(JsonNode, String[])}
   */
  @Test
  @DisplayName("Test getSafely(JsonNode, String[]); when 'null'; then return 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"JsonNode JacksonUtil.getSafely(JsonNode, String[])"})
  void testGetSafely_whenNull_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull(JacksonUtil.getSafely(null, "Path"));
  }

  /**
   * Test {@link JacksonUtil#asObject(JsonNode)}.
   * <ul>
   *   <li>When Instance.</li>
   * </ul>
   * <p>
   * Method under test: {@link JacksonUtil#asObject(JsonNode)}
   */
  @Test
  @DisplayName("Test asObject(JsonNode); when Instance")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"ObjectNode JacksonUtil.asObject(JsonNode)"})
  void testAsObject_whenInstance() {
    // Arrange and Act
    ObjectNode actualAsObjectResult = JacksonUtil.asObject(MissingNode.getInstance());

    // Assert
    assertTrue(actualAsObjectResult.traverse() instanceof TreeTraversingParser);
    assertEquals("{ }", actualAsObjectResult.toPrettyString());
    assertEquals(0, actualAsObjectResult.size());
    assertEquals(JsonNodeType.OBJECT, actualAsObjectResult.getNodeType());
    assertFalse(actualAsObjectResult.isArray());
    assertFalse(actualAsObjectResult.isBigDecimal());
    assertFalse(actualAsObjectResult.isBigInteger());
    assertFalse(actualAsObjectResult.isBinary());
    assertFalse(actualAsObjectResult.isBoolean());
    assertFalse(actualAsObjectResult.isDouble());
    assertFalse(actualAsObjectResult.isFloat());
    assertFalse(actualAsObjectResult.isFloatingPointNumber());
    assertFalse(actualAsObjectResult.isInt());
    assertFalse(actualAsObjectResult.isIntegralNumber());
    assertFalse(actualAsObjectResult.isLong());
    assertFalse(actualAsObjectResult.isMissingNode());
    assertFalse(actualAsObjectResult.isNull());
    assertFalse(actualAsObjectResult.isNumber());
    assertFalse(actualAsObjectResult.isPojo());
    assertFalse(actualAsObjectResult.isShort());
    assertFalse(actualAsObjectResult.isTextual());
    assertFalse(actualAsObjectResult.isValueNode());
    assertFalse(actualAsObjectResult.iterator().hasNext());
    assertTrue(actualAsObjectResult.isContainerNode());
    assertTrue(actualAsObjectResult.isEmpty());
    assertTrue(actualAsObjectResult.isObject());
  }

  /**
   * Test {@link JacksonUtil#asObject(JsonNode)}.
   * <ul>
   *   <li>When {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link JacksonUtil#asObject(JsonNode)}
   */
  @Test
  @DisplayName("Test asObject(JsonNode); when 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"ObjectNode JacksonUtil.asObject(JsonNode)"})
  void testAsObject_whenNull() {
    // Arrange and Act
    ObjectNode actualAsObjectResult = JacksonUtil.asObject(null);

    // Assert
    assertTrue(actualAsObjectResult.traverse() instanceof TreeTraversingParser);
    assertEquals("{ }", actualAsObjectResult.toPrettyString());
    assertEquals(0, actualAsObjectResult.size());
    assertEquals(JsonNodeType.OBJECT, actualAsObjectResult.getNodeType());
    assertFalse(actualAsObjectResult.isArray());
    assertFalse(actualAsObjectResult.isBigDecimal());
    assertFalse(actualAsObjectResult.isBigInteger());
    assertFalse(actualAsObjectResult.isBinary());
    assertFalse(actualAsObjectResult.isBoolean());
    assertFalse(actualAsObjectResult.isDouble());
    assertFalse(actualAsObjectResult.isFloat());
    assertFalse(actualAsObjectResult.isFloatingPointNumber());
    assertFalse(actualAsObjectResult.isInt());
    assertFalse(actualAsObjectResult.isIntegralNumber());
    assertFalse(actualAsObjectResult.isLong());
    assertFalse(actualAsObjectResult.isMissingNode());
    assertFalse(actualAsObjectResult.isNull());
    assertFalse(actualAsObjectResult.isNumber());
    assertFalse(actualAsObjectResult.isPojo());
    assertFalse(actualAsObjectResult.isShort());
    assertFalse(actualAsObjectResult.isTextual());
    assertFalse(actualAsObjectResult.isValueNode());
    assertFalse(actualAsObjectResult.iterator().hasNext());
    assertTrue(actualAsObjectResult.isContainerNode());
    assertTrue(actualAsObjectResult.isEmpty());
    assertTrue(actualAsObjectResult.isObject());
  }

  /**
   * Test {@link JacksonUtil#replaceUuidsRecursively(JsonNode, Set, Pattern, UnaryOperator, boolean)}.
   * <p>
   * Method under test: {@link JacksonUtil#replaceUuidsRecursively(JsonNode, Set, Pattern, UnaryOperator, boolean)}
   */
  @Test
  @DisplayName("Test replaceUuidsRecursively(JsonNode, Set, Pattern, UnaryOperator, boolean)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void JacksonUtil.replaceUuidsRecursively(JsonNode, Set, Pattern, UnaryOperator, boolean)"})
  void testReplaceUuidsRecursively() {
    // Arrange
    ArrayNode node = new ArrayNode(JsonNodeFactory.withExactBigDecimals(true));

    // Act
    JacksonUtil.replaceUuidsRecursively(node, new HashSet<>(), RegexUtils.UUID_PATTERN, mock(UnaryOperator.class),
        true);

    // Assert that nothing has changed
    assertEquals("[ ]", node.toPrettyString());
  }

  /**
   * Test {@link JacksonUtil#replaceUuidsRecursively(JsonNode, Set, Pattern, UnaryOperator, boolean)}.
   * <p>
   * Method under test: {@link JacksonUtil#replaceUuidsRecursively(JsonNode, Set, Pattern, UnaryOperator, boolean)}
   */
  @Test
  @DisplayName("Test replaceUuidsRecursively(JsonNode, Set, Pattern, UnaryOperator, boolean)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void JacksonUtil.replaceUuidsRecursively(JsonNode, Set, Pattern, UnaryOperator, boolean)"})
  void testReplaceUuidsRecursively2() {
    // Arrange
    ArrayNode node = new ArrayNode(JsonNodeFactory.withExactBigDecimals(true));
    node.add(MissingNode.getInstance());

    // Act
    JacksonUtil.replaceUuidsRecursively(node, new HashSet<>(), RegexUtils.UUID_PATTERN, mock(UnaryOperator.class),
        true);

    // Assert that nothing has changed
    assertEquals("[ null ]", node.toPrettyString());
  }

  /**
   * Test {@link JacksonUtil#toFlatMap(JsonNode)} with {@code node}.
   * <ul>
   *   <li>When {@link ArrayNode#ArrayNode(JsonNodeFactory)} with nf is withExactBigDecimals {@code true}.</li>
   * </ul>
   * <p>
   * Method under test: {@link JacksonUtil#toFlatMap(JsonNode)}
   */
  @Test
  @DisplayName("Test toFlatMap(JsonNode) with 'node'; when ArrayNode(JsonNodeFactory) with nf is withExactBigDecimals 'true'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Map JacksonUtil.toFlatMap(JsonNode)"})
  void testToFlatMapWithNode_whenArrayNodeWithNfIsWithExactBigDecimalsTrue() {
    // Arrange and Act
    Map<String, String> actualToFlatMapResult = JacksonUtil
        .toFlatMap(new ArrayNode(JsonNodeFactory.withExactBigDecimals(true)));

    // Assert
    assertTrue(actualToFlatMapResult.isEmpty());
  }

  /**
   * Test {@link JacksonUtil#toFlatMap(JsonNode)} with {@code node}.
   * <ul>
   *   <li>When {@link BigIntegerNode#BigIntegerNode(BigInteger)} with v is valueOf one.</li>
   *   <li>Then return size is one.</li>
   * </ul>
   * <p>
   * Method under test: {@link JacksonUtil#toFlatMap(JsonNode)}
   */
  @Test
  @DisplayName("Test toFlatMap(JsonNode) with 'node'; when BigIntegerNode(BigInteger) with v is valueOf one; then return size is one")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Map JacksonUtil.toFlatMap(JsonNode)"})
  void testToFlatMapWithNode_whenBigIntegerNodeWithVIsValueOfOne_thenReturnSizeIsOne() {
    // Arrange and Act
    Map<String, String> actualToFlatMapResult = JacksonUtil.toFlatMap(new BigIntegerNode(BigInteger.valueOf(1L)));

    // Assert
    assertEquals(1, actualToFlatMapResult.size());
    assertEquals("1", actualToFlatMapResult.get(""));
  }

  /**
   * Test {@link JacksonUtil#toFlatMap(JsonNode)} with {@code node}.
   * <ul>
   *   <li>When Instance.</li>
   *   <li>Then return Empty.</li>
   * </ul>
   * <p>
   * Method under test: {@link JacksonUtil#toFlatMap(JsonNode)}
   */
  @Test
  @DisplayName("Test toFlatMap(JsonNode) with 'node'; when Instance; then return Empty")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Map JacksonUtil.toFlatMap(JsonNode)"})
  void testToFlatMapWithNode_whenInstance_thenReturnEmpty() {
    // Arrange and Act
    Map<String, String> actualToFlatMapResult = JacksonUtil.toFlatMap(MissingNode.getInstance());

    // Assert
    assertTrue(actualToFlatMapResult.isEmpty());
  }

  /**
   * Test {@link JacksonUtil#fromReader(Reader, Class)}.
   * <ul>
   *   <li>When {@link CharArrayReader#CharArrayReader(char[], int, int)} with A null A toCharArray and one and one.</li>
   * </ul>
   * <p>
   * Method under test: {@link JacksonUtil#fromReader(Reader, Class)}
   */
  @Test
  @DisplayName("Test fromReader(Reader, Class); when CharArrayReader(char[], int, int) with A null A toCharArray and one and one")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Object JacksonUtil.fromReader(Reader, Class)"})
  void testFromReader_whenCharArrayReaderWithANullAToCharArrayAndOneAndOne() {
    // Arrange
    CharArrayReader reader = new CharArrayReader("A\u0000A\u0000".toCharArray(), 1, 1);

    Class<Object> clazz = Object.class;

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> JacksonUtil.fromReader(reader, clazz));
  }

  /**
   * Test {@link JacksonUtil#fromReader(Reader, Class)}.
   * <ul>
   *   <li>When {@code JsonMapper$Builder}.</li>
   * </ul>
   * <p>
   * Method under test: {@link JacksonUtil#fromReader(Reader, Class)}
   */
  @Test
  @DisplayName("Test fromReader(Reader, Class); when 'com.fasterxml.jackson.databind.json.JsonMapper$Builder'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Object JacksonUtil.fromReader(Reader, Class)"})
  void testFromReader_whenComFasterxmlJacksonDatabindJsonJsonMapperBuilder() {
    // Arrange
    StringReader reader = new StringReader("foo");
    Class<Builder> clazz = Builder.class;

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> JacksonUtil.fromReader(reader, clazz));
  }

  /**
   * Test {@link JacksonUtil#fromReader(Reader, Class)}.
   * <ul>
   *   <li>When {@code JsonMapper$Builder}.</li>
   * </ul>
   * <p>
   * Method under test: {@link JacksonUtil#fromReader(Reader, Class)}
   */
  @Test
  @DisplayName("Test fromReader(Reader, Class); when 'com.fasterxml.jackson.databind.json.JsonMapper$Builder'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Object JacksonUtil.fromReader(Reader, Class)"})
  void testFromReader_whenComFasterxmlJacksonDatabindJsonJsonMapperBuilder2() {
    // Arrange
    StringReader reader = new StringReader("42");
    Class<Builder> clazz = Builder.class;

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> JacksonUtil.fromReader(reader, clazz));
  }

  /**
   * Test {@link JacksonUtil#fromReader(Reader, Class)}.
   * <ul>
   *   <li>When {@code String}.</li>
   *   <li>Then return {@code 42}.</li>
   * </ul>
   * <p>
   * Method under test: {@link JacksonUtil#fromReader(Reader, Class)}
   */
  @Test
  @DisplayName("Test fromReader(Reader, Class); when 'java.lang.String'; then return '42'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Object JacksonUtil.fromReader(Reader, Class)"})
  void testFromReader_whenJavaLangString_thenReturn42() {
    // Arrange
    StringReader reader = new StringReader("42");
    Class<String> clazz = String.class;

    // Act and Assert
    assertEquals("42", JacksonUtil.fromReader(reader, clazz));
  }

  /**
   * Test {@link JacksonUtil#fromReader(Reader, Class)}.
   * <ul>
   *   <li>When {@code String}.</li>
   *   <li>Then throw {@link IllegalArgumentException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link JacksonUtil#fromReader(Reader, Class)}
   */
  @Test
  @DisplayName("Test fromReader(Reader, Class); when 'java.lang.String'; then throw IllegalArgumentException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Object JacksonUtil.fromReader(Reader, Class)"})
  void testFromReader_whenJavaLangString_thenThrowIllegalArgumentException() {
    // Arrange
    StringReader reader = new StringReader("foo");
    Class<String> clazz = String.class;

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> JacksonUtil.fromReader(reader, clazz));
  }

  /**
   * Test {@link JacksonUtil#fromReader(Reader, Class)}.
   * <ul>
   *   <li>When {@code null}.</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link JacksonUtil#fromReader(Reader, Class)}
   */
  @Test
  @DisplayName("Test fromReader(Reader, Class); when 'null'; then return 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Object JacksonUtil.fromReader(Reader, Class)"})
  void testFromReader_whenNull_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull(JacksonUtil.fromReader(null, null));
  }

  /**
   * Test {@link JacksonUtil#fromReader(Reader, Class)}.
   * <ul>
   *   <li>When {@code JacksonUtil}.</li>
   * </ul>
   * <p>
   * Method under test: {@link JacksonUtil#fromReader(Reader, Class)}
   */
  @Test
  @DisplayName("Test fromReader(Reader, Class); when 'org.thingsboard.common.util.JacksonUtil'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Object JacksonUtil.fromReader(Reader, Class)"})
  void testFromReader_whenOrgThingsboardCommonUtilJacksonUtil() {
    // Arrange
    StringReader reader = new StringReader("42");
    Class<JacksonUtil> clazz = JacksonUtil.class;

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> JacksonUtil.fromReader(reader, clazz));
  }

  /**
   * Test {@link JacksonUtil#fromReader(Reader, Class)}.
   * <ul>
   *   <li>When {@link StringReader#StringReader(String)} with {@code 42}.</li>
   *   <li>Then return intValue is forty-two.</li>
   * </ul>
   * <p>
   * Method under test: {@link JacksonUtil#fromReader(Reader, Class)}
   */
  @Test
  @DisplayName("Test fromReader(Reader, Class); when StringReader(String) with '42'; then return intValue is forty-two")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Object JacksonUtil.fromReader(Reader, Class)"})
  void testFromReader_whenStringReaderWith42_thenReturnIntValueIsFortyTwo() {
    // Arrange
    StringReader reader = new StringReader("42");
    Class<Object> clazz = Object.class;

    // Act and Assert
    assertEquals(42, ((Integer) JacksonUtil.fromReader(reader, clazz)).intValue());
  }

  /**
   * Test {@link JacksonUtil#fromReader(Reader, Class)}.
   * <ul>
   *   <li>When {@link StringReader#StringReader(String)} with empty string.</li>
   *   <li>Then throw {@link IllegalArgumentException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link JacksonUtil#fromReader(Reader, Class)}
   */
  @Test
  @DisplayName("Test fromReader(Reader, Class); when StringReader(String) with empty string; then throw IllegalArgumentException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Object JacksonUtil.fromReader(Reader, Class)"})
  void testFromReader_whenStringReaderWithEmptyString_thenThrowIllegalArgumentException() {
    // Arrange
    StringReader reader = new StringReader("");
    Class<Object> clazz = Object.class;

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> JacksonUtil.fromReader(reader, clazz));
  }

  /**
   * Test {@link JacksonUtil#fromReader(Reader, Class)}.
   * <ul>
   *   <li>When {@link StringReader#StringReader(String)} with {@code foo}.</li>
   *   <li>Then throw {@link IllegalArgumentException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link JacksonUtil#fromReader(Reader, Class)}
   */
  @Test
  @DisplayName("Test fromReader(Reader, Class); when StringReader(String) with 'foo'; then throw IllegalArgumentException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Object JacksonUtil.fromReader(Reader, Class)"})
  void testFromReader_whenStringReaderWithFoo_thenThrowIllegalArgumentException() {
    // Arrange
    StringReader reader = new StringReader("foo");
    Class<Object> clazz = Object.class;

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> JacksonUtil.fromReader(reader, clazz));
  }

  /**
   * Test {@link JacksonUtil#fromReader(Reader, Class)}.
   * <ul>
   *   <li>When {@link StringReader#StringReader(String)} with {@code Invalid request payload}.</li>
   * </ul>
   * <p>
   * Method under test: {@link JacksonUtil#fromReader(Reader, Class)}
   */
  @Test
  @DisplayName("Test fromReader(Reader, Class); when StringReader(String) with 'Invalid request payload'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Object JacksonUtil.fromReader(Reader, Class)"})
  void testFromReader_whenStringReaderWithInvalidRequestPayload() {
    // Arrange
    StringReader reader = new StringReader("Invalid request payload");
    Class<Object> clazz = Object.class;

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> JacksonUtil.fromReader(reader, clazz));
  }

  /**
   * Test {@link JacksonUtil#writeValue(Writer, Object)}.
   * <ul>
   *   <li>When {@link PipedWriter#PipedWriter()}.</li>
   *   <li>Then throw {@link IllegalArgumentException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link JacksonUtil#writeValue(Writer, Object)}
   */
  @Test
  @DisplayName("Test writeValue(Writer, Object); when PipedWriter(); then throw IllegalArgumentException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void JacksonUtil.writeValue(Writer, Object)"})
  void testWriteValue_whenPipedWriter_thenThrowIllegalArgumentException() {
    // Arrange, Act and Assert
    assertThrows(IllegalArgumentException.class, () -> JacksonUtil.writeValue(new PipedWriter(), "Value"));
  }

  /**
   * Test {@link JacksonUtil#writeValue(Writer, Object)}.
   * <ul>
   *   <li>When {@link StringWriter#StringWriter()}.</li>
   *   <li>Then {@link StringWriter#StringWriter()} toString is {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link JacksonUtil#writeValue(Writer, Object)}
   */
  @Test
  @DisplayName("Test writeValue(Writer, Object); when StringWriter(); then StringWriter() toString is 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void JacksonUtil.writeValue(Writer, Object)"})
  void testWriteValue_whenStringWriter_thenStringWriterToStringIsNull() {
    // Arrange
    StringWriter writer = new StringWriter();

    // Act
    JacksonUtil.writeValue(writer, null);

    // Assert
    assertEquals("null", writer.toString());
  }

  /**
   * Test {@link JacksonUtil#writeValue(Writer, Object)}.
   * <ul>
   *   <li>When {@link StringWriter#StringWriter()}.</li>
   *   <li>Then {@link StringWriter#StringWriter()} toString is {@code "Value"}.</li>
   * </ul>
   * <p>
   * Method under test: {@link JacksonUtil#writeValue(Writer, Object)}
   */
  @Test
  @DisplayName("Test writeValue(Writer, Object); when StringWriter(); then StringWriter() toString is '\"Value\"'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void JacksonUtil.writeValue(Writer, Object)"})
  void testWriteValue_whenStringWriter_thenStringWriterToStringIsValue() {
    // Arrange
    StringWriter writer = new StringWriter();

    // Act
    JacksonUtil.writeValue(writer, "Value");

    // Assert
    assertEquals("\"Value\"", writer.toString());
  }

  /**
   * Test {@link JacksonUtil#addKvEntry(ObjectNode, KvEntry)} with {@code entityNode}, {@code kvEntry}.
   * <p>
   * Method under test: {@link JacksonUtil#addKvEntry(ObjectNode, KvEntry)}
   */
  @Test
  @DisplayName("Test addKvEntry(ObjectNode, KvEntry) with 'entityNode', 'kvEntry'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void JacksonUtil.addKvEntry(ObjectNode, KvEntry)"})
  void testAddKvEntryWithEntityNodeKvEntry() {
    // Arrange
    ObjectNode entityNode = new ObjectNode(JsonNodeFactory.withExactBigDecimals(true));

    // Act
    JacksonUtil.addKvEntry(entityNode, new JsonDataEntry("Key", "42"));

    // Assert
    Iterator<JsonNode> iteratorResult = entityNode.iterator();
    JsonNode nextResult = iteratorResult.next();
    assertTrue(nextResult instanceof IntNode);
    assertEquals("42", nextResult.toPrettyString());
    assertEquals("{\r\n  \"Key\" : 42\r\n}", entityNode.toPrettyString());
    assertEquals(JsonNodeType.NUMBER, nextResult.getNodeType());
    assertFalse(((IntNode) nextResult).isNaN());
    assertFalse(iteratorResult.hasNext());
    assertTrue(nextResult.isInt());
    assertTrue(nextResult.isIntegralNumber());
    assertTrue(nextResult.isNumber());
  }

  /**
   * Test {@link JacksonUtil#addKvEntry(ObjectNode, KvEntry)} with {@code entityNode}, {@code kvEntry}.
   * <p>
   * Method under test: {@link JacksonUtil#addKvEntry(ObjectNode, KvEntry)}
   */
  @Test
  @DisplayName("Test addKvEntry(ObjectNode, KvEntry) with 'entityNode', 'kvEntry'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void JacksonUtil.addKvEntry(ObjectNode, KvEntry)"})
  void testAddKvEntryWithEntityNodeKvEntry2() {
    // Arrange
    ObjectNode entityNode = new ObjectNode(JsonNodeFactory.withExactBigDecimals(false));

    // Act
    JacksonUtil.addKvEntry(entityNode, new JsonDataEntry("Key", "42"));

    // Assert
    Iterator<JsonNode> iteratorResult = entityNode.iterator();
    JsonNode nextResult = iteratorResult.next();
    assertTrue(nextResult instanceof IntNode);
    assertTrue(nextResult.traverse() instanceof TreeTraversingParser);
    assertFalse(iteratorResult.hasNext());
  }

  /**
   * Test {@link JacksonUtil#addKvEntry(ObjectNode, KvEntry)} with {@code entityNode}, {@code kvEntry}.
   * <p>
   * Method under test: {@link JacksonUtil#addKvEntry(ObjectNode, KvEntry)}
   */
  @Test
  @DisplayName("Test addKvEntry(ObjectNode, KvEntry) with 'entityNode', 'kvEntry'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void JacksonUtil.addKvEntry(ObjectNode, KvEntry)"})
  void testAddKvEntryWithEntityNodeKvEntry3() {
    // Arrange
    ObjectNode entityNode = new ObjectNode(JsonNodeFactory.withExactBigDecimals(true));

    // Act
    JacksonUtil.addKvEntry(entityNode, new JsonDataEntry("Key", null));

    // Assert that nothing has changed
    assertEquals("{ }", entityNode.toPrettyString());
    assertFalse(entityNode.iterator().hasNext());
  }

  /**
   * Test {@link JacksonUtil#addKvEntry(ObjectNode, KvEntry)} with {@code entityNode}, {@code kvEntry}.
   * <p>
   * Method under test: {@link JacksonUtil#addKvEntry(ObjectNode, KvEntry)}
   */
  @Test
  @DisplayName("Test addKvEntry(ObjectNode, KvEntry) with 'entityNode', 'kvEntry'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void JacksonUtil.addKvEntry(ObjectNode, KvEntry)"})
  void testAddKvEntryWithEntityNodeKvEntry4() {
    // Arrange
    ObjectNode entityNode = new ObjectNode(JsonNodeFactory.withExactBigDecimals(true));

    // Act
    JacksonUtil.addKvEntry(entityNode, new JsonDataEntry("Key", ""));

    // Assert
    Iterator<JsonNode> iteratorResult = entityNode.iterator();
    JsonNode nextResult = iteratorResult.next();
    assertTrue(nextResult instanceof NullNode);
    assertEquals("null", nextResult.toPrettyString());
    assertEquals("{\r\n  \"Key\" : null\r\n}", entityNode.toPrettyString());
    assertEquals(JsonNodeType.NULL, nextResult.getNodeType());
    assertFalse(iteratorResult.hasNext());
    assertTrue(nextResult.isNull());
  }

  /**
   * Test {@link JacksonUtil#addKvEntry(ObjectNode, KvEntry)} with {@code entityNode}, {@code kvEntry}.
   * <p>
   * Method under test: {@link JacksonUtil#addKvEntry(ObjectNode, KvEntry)}
   */
  @Test
  @DisplayName("Test addKvEntry(ObjectNode, KvEntry) with 'entityNode', 'kvEntry'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void JacksonUtil.addKvEntry(ObjectNode, KvEntry)"})
  void testAddKvEntryWithEntityNodeKvEntry5() {
    // Arrange
    ObjectNode entityNode = new ObjectNode(JsonNodeFactory.withExactBigDecimals(true));

    // Act
    JacksonUtil.addKvEntry(entityNode, new StringDataEntry("Key", "42"));

    // Assert
    Iterator<JsonNode> iteratorResult = entityNode.iterator();
    JsonNode nextResult = iteratorResult.next();
    assertTrue(nextResult instanceof TextNode);
    assertEquals("\"42\"", nextResult.toPrettyString());
    assertEquals("{\r\n  \"Key\" : \"42\"\r\n}", entityNode.toPrettyString());
    assertEquals(JsonNodeType.STRING, nextResult.getNodeType());
    assertFalse(iteratorResult.hasNext());
    assertTrue(nextResult.isTextual());
  }

  /**
   * Test {@link JacksonUtil#addKvEntry(ObjectNode, KvEntry, String)} with {@code entityNode}, {@code kvEntry}, {@code key}.
   * <p>
   * Method under test: {@link JacksonUtil#addKvEntry(ObjectNode, KvEntry, String)}
   */
  @Test
  @DisplayName("Test addKvEntry(ObjectNode, KvEntry, String) with 'entityNode', 'kvEntry', 'key'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void JacksonUtil.addKvEntry(ObjectNode, KvEntry, String)"})
  void testAddKvEntryWithEntityNodeKvEntryKey() {
    // Arrange
    ObjectNode entityNode = new ObjectNode(JsonNodeFactory.withExactBigDecimals(true));

    // Act
    JacksonUtil.addKvEntry(entityNode, new JsonDataEntry("Key", "42"), "Key");

    // Assert
    Iterator<JsonNode> iteratorResult = entityNode.iterator();
    JsonNode nextResult = iteratorResult.next();
    assertTrue(nextResult instanceof IntNode);
    assertEquals("42", nextResult.toPrettyString());
    assertEquals("{\r\n  \"Key\" : 42\r\n}", entityNode.toPrettyString());
    assertEquals(JsonNodeType.NUMBER, nextResult.getNodeType());
    assertFalse(((IntNode) nextResult).isNaN());
    assertFalse(iteratorResult.hasNext());
    assertTrue(nextResult.isInt());
    assertTrue(nextResult.isIntegralNumber());
    assertTrue(nextResult.isNumber());
  }

  /**
   * Test {@link JacksonUtil#addKvEntry(ObjectNode, KvEntry, String)} with {@code entityNode}, {@code kvEntry}, {@code key}.
   * <p>
   * Method under test: {@link JacksonUtil#addKvEntry(ObjectNode, KvEntry, String)}
   */
  @Test
  @DisplayName("Test addKvEntry(ObjectNode, KvEntry, String) with 'entityNode', 'kvEntry', 'key'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void JacksonUtil.addKvEntry(ObjectNode, KvEntry, String)"})
  void testAddKvEntryWithEntityNodeKvEntryKey2() {
    // Arrange
    ObjectNode entityNode = new ObjectNode(JsonNodeFactory.withExactBigDecimals(true));

    // Act
    JacksonUtil.addKvEntry(entityNode, new JsonDataEntry("Key", null), "Key");

    // Assert that nothing has changed
    assertEquals("{ }", entityNode.toPrettyString());
    assertFalse(entityNode.iterator().hasNext());
  }

  /**
   * Test {@link JacksonUtil#addKvEntry(ObjectNode, KvEntry, String)} with {@code entityNode}, {@code kvEntry}, {@code key}.
   * <p>
   * Method under test: {@link JacksonUtil#addKvEntry(ObjectNode, KvEntry, String)}
   */
  @Test
  @DisplayName("Test addKvEntry(ObjectNode, KvEntry, String) with 'entityNode', 'kvEntry', 'key'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void JacksonUtil.addKvEntry(ObjectNode, KvEntry, String)"})
  void testAddKvEntryWithEntityNodeKvEntryKey3() {
    // Arrange
    ObjectNode entityNode = new ObjectNode(JsonNodeFactory.withExactBigDecimals(true));

    // Act
    JacksonUtil.addKvEntry(entityNode, new JsonDataEntry("Key", ""), "Key");

    // Assert
    Iterator<JsonNode> iteratorResult = entityNode.iterator();
    JsonNode nextResult = iteratorResult.next();
    assertTrue(nextResult instanceof NullNode);
    assertEquals("null", nextResult.toPrettyString());
    assertEquals("{\r\n  \"Key\" : null\r\n}", entityNode.toPrettyString());
    assertEquals(JsonNodeType.NULL, nextResult.getNodeType());
    assertFalse(iteratorResult.hasNext());
    assertTrue(nextResult.isNull());
  }

  /**
   * Test {@link JacksonUtil#addKvEntry(ObjectNode, KvEntry, String)} with {@code entityNode}, {@code kvEntry}, {@code key}.
   * <p>
   * Method under test: {@link JacksonUtil#addKvEntry(ObjectNode, KvEntry, String)}
   */
  @Test
  @DisplayName("Test addKvEntry(ObjectNode, KvEntry, String) with 'entityNode', 'kvEntry', 'key'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void JacksonUtil.addKvEntry(ObjectNode, KvEntry, String)"})
  void testAddKvEntryWithEntityNodeKvEntryKey4() {
    // Arrange
    ObjectNode entityNode = new ObjectNode(JsonNodeFactory.withExactBigDecimals(true));

    // Act
    JacksonUtil.addKvEntry(entityNode, new StringDataEntry("Key", "42"), "Key");

    // Assert
    Iterator<JsonNode> iteratorResult = entityNode.iterator();
    JsonNode nextResult = iteratorResult.next();
    assertTrue(nextResult instanceof TextNode);
    assertEquals("\"42\"", nextResult.toPrettyString());
    assertEquals("{\r\n  \"Key\" : \"42\"\r\n}", entityNode.toPrettyString());
    assertEquals(JsonNodeType.STRING, nextResult.getNodeType());
    assertFalse(iteratorResult.hasNext());
    assertTrue(nextResult.isTextual());
  }

  /**
   * Test {@link JacksonUtil#addKvEntry(ObjectNode, KvEntry, String, ObjectMapper)} with {@code entityNode}, {@code kvEntry}, {@code key}, {@code mapper}.
   * <p>
   * Method under test: {@link JacksonUtil#addKvEntry(ObjectNode, KvEntry, String, ObjectMapper)}
   */
  @Test
  @DisplayName("Test addKvEntry(ObjectNode, KvEntry, String, ObjectMapper) with 'entityNode', 'kvEntry', 'key', 'mapper'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void JacksonUtil.addKvEntry(ObjectNode, KvEntry, String, ObjectMapper)"})
  void testAddKvEntryWithEntityNodeKvEntryKeyMapper() {
    // Arrange
    ObjectNode entityNode = new ObjectNode(JsonNodeFactory.withExactBigDecimals(true));

    // Act
    JacksonUtil.addKvEntry(entityNode, new JsonDataEntry("Key", "42"), "Key",
        JacksonUtil.IGNORE_UNKNOWN_PROPERTIES_JSON_MAPPER);

    // Assert
    Iterator<JsonNode> iteratorResult = entityNode.iterator();
    JsonNode nextResult = iteratorResult.next();
    assertTrue(nextResult instanceof IntNode);
    assertEquals("42", nextResult.toPrettyString());
    assertEquals("{\r\n  \"Key\" : 42\r\n}", entityNode.toPrettyString());
    assertEquals(JsonNodeType.NUMBER, nextResult.getNodeType());
    assertFalse(((IntNode) nextResult).isNaN());
    assertFalse(iteratorResult.hasNext());
    assertTrue(nextResult.isInt());
    assertTrue(nextResult.isIntegralNumber());
    assertTrue(nextResult.isNumber());
  }

  /**
   * Test {@link JacksonUtil#addKvEntry(ObjectNode, KvEntry, String, ObjectMapper)} with {@code entityNode}, {@code kvEntry}, {@code key}, {@code mapper}.
   * <p>
   * Method under test: {@link JacksonUtil#addKvEntry(ObjectNode, KvEntry, String, ObjectMapper)}
   */
  @Test
  @DisplayName("Test addKvEntry(ObjectNode, KvEntry, String, ObjectMapper) with 'entityNode', 'kvEntry', 'key', 'mapper'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void JacksonUtil.addKvEntry(ObjectNode, KvEntry, String, ObjectMapper)"})
  void testAddKvEntryWithEntityNodeKvEntryKeyMapper2() {
    // Arrange
    ObjectNode entityNode = new ObjectNode(JsonNodeFactory.withExactBigDecimals(false));

    // Act
    JacksonUtil.addKvEntry(entityNode, new JsonDataEntry("Key", "42"), "Key",
        JacksonUtil.IGNORE_UNKNOWN_PROPERTIES_JSON_MAPPER);

    // Assert
    Iterator<JsonNode> iteratorResult = entityNode.iterator();
    JsonNode nextResult = iteratorResult.next();
    assertTrue(nextResult instanceof IntNode);
    assertTrue(nextResult.traverse() instanceof TreeTraversingParser);
    assertFalse(iteratorResult.hasNext());
  }

  /**
   * Test {@link JacksonUtil#addKvEntry(ObjectNode, KvEntry, String, ObjectMapper)} with {@code entityNode}, {@code kvEntry}, {@code key}, {@code mapper}.
   * <p>
   * Method under test: {@link JacksonUtil#addKvEntry(ObjectNode, KvEntry, String, ObjectMapper)}
   */
  @Test
  @DisplayName("Test addKvEntry(ObjectNode, KvEntry, String, ObjectMapper) with 'entityNode', 'kvEntry', 'key', 'mapper'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void JacksonUtil.addKvEntry(ObjectNode, KvEntry, String, ObjectMapper)"})
  void testAddKvEntryWithEntityNodeKvEntryKeyMapper3() {
    // Arrange
    ObjectNode entityNode = new ObjectNode(JsonNodeFactory.withExactBigDecimals(true));

    // Act
    JacksonUtil.addKvEntry(entityNode, new JsonDataEntry("Key", null), "Key",
        JacksonUtil.IGNORE_UNKNOWN_PROPERTIES_JSON_MAPPER);

    // Assert that nothing has changed
    assertEquals("{ }", entityNode.toPrettyString());
    assertFalse(entityNode.iterator().hasNext());
  }

  /**
   * Test {@link JacksonUtil#addKvEntry(ObjectNode, KvEntry, String, ObjectMapper)} with {@code entityNode}, {@code kvEntry}, {@code key}, {@code mapper}.
   * <p>
   * Method under test: {@link JacksonUtil#addKvEntry(ObjectNode, KvEntry, String, ObjectMapper)}
   */
  @Test
  @DisplayName("Test addKvEntry(ObjectNode, KvEntry, String, ObjectMapper) with 'entityNode', 'kvEntry', 'key', 'mapper'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void JacksonUtil.addKvEntry(ObjectNode, KvEntry, String, ObjectMapper)"})
  void testAddKvEntryWithEntityNodeKvEntryKeyMapper4() {
    // Arrange
    ObjectNode entityNode = new ObjectNode(JsonNodeFactory.withExactBigDecimals(true));

    // Act
    JacksonUtil.addKvEntry(entityNode, new JsonDataEntry("Key", ""), "Key",
        JacksonUtil.IGNORE_UNKNOWN_PROPERTIES_JSON_MAPPER);

    // Assert
    Iterator<JsonNode> iteratorResult = entityNode.iterator();
    JsonNode nextResult = iteratorResult.next();
    assertTrue(nextResult instanceof NullNode);
    assertEquals("null", nextResult.toPrettyString());
    assertEquals("{\r\n  \"Key\" : null\r\n}", entityNode.toPrettyString());
    assertEquals(JsonNodeType.NULL, nextResult.getNodeType());
    assertFalse(iteratorResult.hasNext());
    assertTrue(nextResult.isNull());
  }

  /**
   * Test {@link JacksonUtil#addKvEntry(ObjectNode, KvEntry, String, ObjectMapper)} with {@code entityNode}, {@code kvEntry}, {@code key}, {@code mapper}.
   * <p>
   * Method under test: {@link JacksonUtil#addKvEntry(ObjectNode, KvEntry, String, ObjectMapper)}
   */
  @Test
  @DisplayName("Test addKvEntry(ObjectNode, KvEntry, String, ObjectMapper) with 'entityNode', 'kvEntry', 'key', 'mapper'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void JacksonUtil.addKvEntry(ObjectNode, KvEntry, String, ObjectMapper)"})
  void testAddKvEntryWithEntityNodeKvEntryKeyMapper5() {
    // Arrange
    ObjectNode entityNode = new ObjectNode(JsonNodeFactory.withExactBigDecimals(true));

    // Act
    JacksonUtil.addKvEntry(entityNode, new StringDataEntry("Key", "42"), "Key",
        JacksonUtil.IGNORE_UNKNOWN_PROPERTIES_JSON_MAPPER);

    // Assert
    Iterator<JsonNode> iteratorResult = entityNode.iterator();
    JsonNode nextResult = iteratorResult.next();
    assertTrue(nextResult instanceof TextNode);
    assertEquals("\"42\"", nextResult.toPrettyString());
    assertEquals("{\r\n  \"Key\" : \"42\"\r\n}", entityNode.toPrettyString());
    assertEquals(JsonNodeType.STRING, nextResult.getNodeType());
    assertFalse(iteratorResult.hasNext());
    assertTrue(nextResult.isTextual());
  }

  /**
   * Test {@link JacksonUtil#addKvEntry(ObjectNode, KvEntry, String, ObjectMapper)} with {@code entityNode}, {@code kvEntry}, {@code key}, {@code mapper}.
   * <ul>
   *   <li>Then throw {@link IllegalArgumentException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link JacksonUtil#addKvEntry(ObjectNode, KvEntry, String, ObjectMapper)}
   */
  @Test
  @DisplayName("Test addKvEntry(ObjectNode, KvEntry, String, ObjectMapper) with 'entityNode', 'kvEntry', 'key', 'mapper'; then throw IllegalArgumentException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void JacksonUtil.addKvEntry(ObjectNode, KvEntry, String, ObjectMapper)"})
  void testAddKvEntryWithEntityNodeKvEntryKeyMapper_thenThrowIllegalArgumentException() {
    // Arrange
    ObjectNode entityNode = new ObjectNode(JsonNodeFactory.withExactBigDecimals(true));

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> JacksonUtil.addKvEntry(entityNode,
        new JsonDataEntry("Key", "Value"), "Key", JacksonUtil.IGNORE_UNKNOWN_PROPERTIES_JSON_MAPPER));
  }

  /**
   * Test {@link JacksonUtil#addKvEntry(ObjectNode, KvEntry, String, ObjectMapper)} with {@code entityNode}, {@code kvEntry}, {@code key}, {@code mapper}.
   * <ul>
   *   <li>When {@link ObjectMapper#ObjectMapper()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link JacksonUtil#addKvEntry(ObjectNode, KvEntry, String, ObjectMapper)}
   */
  @Test
  @DisplayName("Test addKvEntry(ObjectNode, KvEntry, String, ObjectMapper) with 'entityNode', 'kvEntry', 'key', 'mapper'; when ObjectMapper()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void JacksonUtil.addKvEntry(ObjectNode, KvEntry, String, ObjectMapper)"})
  void testAddKvEntryWithEntityNodeKvEntryKeyMapper_whenObjectMapper() {
    // Arrange
    ObjectNode entityNode = new ObjectNode(JsonNodeFactory.withExactBigDecimals(true));
    JsonDataEntry kvEntry = new JsonDataEntry("Key", "42");

    // Act
    JacksonUtil.addKvEntry(entityNode, kvEntry, "Key", new ObjectMapper());

    // Assert
    Iterator<JsonNode> iteratorResult = entityNode.iterator();
    JsonNode nextResult = iteratorResult.next();
    assertTrue(nextResult instanceof IntNode);
    assertEquals("42", nextResult.toPrettyString());
    assertEquals("{\r\n  \"Key\" : 42\r\n}", entityNode.toPrettyString());
    assertEquals(JsonNodeType.NUMBER, nextResult.getNodeType());
    assertFalse(((IntNode) nextResult).isNaN());
    assertFalse(iteratorResult.hasNext());
    assertTrue(nextResult.isInt());
    assertTrue(nextResult.isIntegralNumber());
    assertTrue(nextResult.isNumber());
  }

  /**
   * Test {@link JacksonUtil#addKvEntry(ObjectNode, KvEntry, String)} with {@code entityNode}, {@code kvEntry}, {@code key}.
   * <ul>
   *   <li>Then throw {@link IllegalArgumentException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link JacksonUtil#addKvEntry(ObjectNode, KvEntry, String)}
   */
  @Test
  @DisplayName("Test addKvEntry(ObjectNode, KvEntry, String) with 'entityNode', 'kvEntry', 'key'; then throw IllegalArgumentException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void JacksonUtil.addKvEntry(ObjectNode, KvEntry, String)"})
  void testAddKvEntryWithEntityNodeKvEntryKey_thenThrowIllegalArgumentException() {
    // Arrange
    ObjectNode entityNode = new ObjectNode(JsonNodeFactory.withExactBigDecimals(true));

    // Act and Assert
    assertThrows(IllegalArgumentException.class,
        () -> JacksonUtil.addKvEntry(entityNode, new JsonDataEntry("Key", "Value"), "Key"));
  }

  /**
   * Test {@link JacksonUtil#addKvEntry(ObjectNode, KvEntry)} with {@code entityNode}, {@code kvEntry}.
   * <ul>
   *   <li>Then throw {@link IllegalArgumentException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link JacksonUtil#addKvEntry(ObjectNode, KvEntry)}
   */
  @Test
  @DisplayName("Test addKvEntry(ObjectNode, KvEntry) with 'entityNode', 'kvEntry'; then throw IllegalArgumentException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void JacksonUtil.addKvEntry(ObjectNode, KvEntry)"})
  void testAddKvEntryWithEntityNodeKvEntry_thenThrowIllegalArgumentException() {
    // Arrange
    ObjectNode entityNode = new ObjectNode(JsonNodeFactory.withExactBigDecimals(true));

    // Act and Assert
    assertThrows(IllegalArgumentException.class,
        () -> JacksonUtil.addKvEntry(entityNode, new JsonDataEntry("Key", "Value")));
  }
}
