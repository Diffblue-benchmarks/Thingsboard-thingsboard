package org.thingsboard.common.util;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.anyInt;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import com.fasterxml.jackson.core.io.ContentReference;
import com.fasterxml.jackson.core.io.IOContext;
import com.fasterxml.jackson.core.io.SegmentedStringWriter;
import com.fasterxml.jackson.core.io.UTF8Writer;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.core.util.BufferRecycler;
import com.fasterxml.jackson.core.util.JsonRecyclerPools;
import com.fasterxml.jackson.core.util.JsonRecyclerPools.BoundedPool;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.deser.DefaultDeserializationContext;
import com.fasterxml.jackson.databind.introspect.VisibilityChecker;
import com.fasterxml.jackson.databind.introspect.VisibilityChecker.Std;
import com.fasterxml.jackson.databind.json.JsonMapper;
import com.fasterxml.jackson.databind.json.JsonMapper.Builder;
import com.fasterxml.jackson.databind.jsontype.impl.LaissezFaireSubTypeValidator;
import com.fasterxml.jackson.databind.jsontype.impl.StdSubtypeResolver;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.BigIntegerNode;
import com.fasterxml.jackson.databind.node.BinaryNode;
import com.fasterxml.jackson.databind.node.BooleanNode;
import com.fasterxml.jackson.databind.node.DecimalNode;
import com.fasterxml.jackson.databind.node.DoubleNode;
import com.fasterxml.jackson.databind.node.FloatNode;
import com.fasterxml.jackson.databind.node.IntNode;
import com.fasterxml.jackson.databind.node.JsonNodeFactory;
import com.fasterxml.jackson.databind.node.JsonNodeType;
import com.fasterxml.jackson.databind.node.LongNode;
import com.fasterxml.jackson.databind.node.MissingNode;
import com.fasterxml.jackson.databind.node.NullNode;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.fasterxml.jackson.databind.node.POJONode;
import com.fasterxml.jackson.databind.node.TextNode;
import com.fasterxml.jackson.databind.node.TreeTraversingParser;
import com.fasterxml.jackson.databind.ser.BeanSerializerFactory;
import com.fasterxml.jackson.databind.ser.DefaultSerializerProvider;
import com.fasterxml.jackson.databind.ser.DefaultSerializerProvider.Impl;
import com.fasterxml.jackson.databind.type.ArrayType;
import com.fasterxml.jackson.databind.type.CollectionType;
import com.fasterxml.jackson.databind.type.PlaceholderForType;
import com.fasterxml.jackson.databind.type.ResolvedRecursiveType;
import com.fasterxml.jackson.databind.type.TypeBindings;
import com.fasterxml.jackson.databind.util.StdDateFormat;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.DataInputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.PipedWriter;
import java.io.Reader;
import java.io.StringReader;
import java.io.StringWriter;
import java.io.UnsupportedEncodingException;
import java.io.Writer;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.nio.file.FileSystems;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.UUID;
import java.util.concurrent.TimeUnit;
import java.util.function.UnaryOperator;
import java.util.regex.Pattern;
import org.apache.groovy.nio.runtime.WritablePath;
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
import org.thingsboard.server.common.data.DeviceProfile;
import org.thingsboard.server.common.data.DeviceProfileInfo;
import org.thingsboard.server.common.data.EntityInfo;
import org.thingsboard.server.common.data.EntityView;
import org.thingsboard.server.common.data.HomeDashboard;
import org.thingsboard.server.common.data.ImageDescriptor;
import org.thingsboard.server.common.data.OtaPackage;
import org.thingsboard.server.common.data.ShortCustomerInfo;
import org.thingsboard.server.common.data.TbResource;
import org.thingsboard.server.common.data.TenantProfile;
import org.thingsboard.server.common.data.alarm.Alarm;
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
import org.thingsboard.server.common.data.id.DeviceId;
import org.thingsboard.server.common.data.id.UUIDBased;
import org.thingsboard.server.common.data.kv.BooleanDataEntry;
import org.thingsboard.server.common.data.kv.DoubleDataEntry;
import org.thingsboard.server.common.data.kv.JsonDataEntry;
import org.thingsboard.server.common.data.kv.KvEntry;
import org.thingsboard.server.common.data.kv.LongDataEntry;
import org.thingsboard.server.common.data.kv.StringDataEntry;
import org.thingsboard.server.common.data.query.BooleanFilterPredicate;
import org.thingsboard.server.common.data.query.BooleanFilterPredicate.BooleanOperation;
import org.thingsboard.server.common.data.query.ComplexFilterPredicate;
import org.thingsboard.server.common.data.query.ComplexFilterPredicate.ComplexOperation;
import org.thingsboard.server.common.data.query.DynamicValue;
import org.thingsboard.server.common.data.query.DynamicValueSourceType;
import org.thingsboard.server.common.data.query.EntityKeyValueType;
import org.thingsboard.server.common.data.query.FilterPredicateValue;
import org.thingsboard.server.common.data.query.KeyFilterPredicate;
import org.thingsboard.server.common.data.query.NumericFilterPredicate;
import org.thingsboard.server.common.data.query.NumericFilterPredicate.NumericOperation;

class JacksonUtilDiffblueTest {
  /**
   * Test {@link JacksonUtil#getObjectMapperWithJavaTimeModule()}.
   *
   * <p>Method under test: {@link JacksonUtil#getObjectMapperWithJavaTimeModule()}
   */
  @Test
  @DisplayName("Test getObjectMapperWithJavaTimeModule()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ObjectMapper JacksonUtil.getObjectMapperWithJavaTimeModule()"})
  void testGetObjectMapperWithJavaTimeModule() {
    // Arrange and Act
    ObjectMapper actualObjectMapperWithJavaTimeModule =
        JacksonUtil.getObjectMapperWithJavaTimeModule();

    // Assert
    assertTrue(
        actualObjectMapperWithJavaTimeModule.getDeserializationContext()
            instanceof DefaultDeserializationContext.Impl);
    assertTrue(actualObjectMapperWithJavaTimeModule.getVisibilityChecker() instanceof Std);
    assertTrue(actualObjectMapperWithJavaTimeModule instanceof JsonMapper);
    assertTrue(
        actualObjectMapperWithJavaTimeModule.getPolymorphicTypeValidator()
            instanceof LaissezFaireSubTypeValidator);
    assertTrue(
        actualObjectMapperWithJavaTimeModule.getSubtypeResolver() instanceof StdSubtypeResolver);
    assertTrue(
        actualObjectMapperWithJavaTimeModule.getSerializerFactory()
            instanceof BeanSerializerFactory);
    assertTrue(actualObjectMapperWithJavaTimeModule.getSerializerProvider() instanceof Impl);
    assertTrue(
        actualObjectMapperWithJavaTimeModule.getSerializerProviderInstance() instanceof Impl);
    assertTrue(actualObjectMapperWithJavaTimeModule.getDateFormat() instanceof StdDateFormat);
    assertNull(actualObjectMapperWithJavaTimeModule.getInjectableValues());
    assertNull(actualObjectMapperWithJavaTimeModule.getPropertyNamingStrategy());
    assertEquals(2, actualObjectMapperWithJavaTimeModule.getRegisteredModuleIds().size());
  }

  /**
   * Test {@link JacksonUtil#convertValue(Object, Class)} with {@code fromValue}, {@code
   * toValueType}.
   *
   * <p>Method under test: {@link JacksonUtil#convertValue(Object, Class)}
   */
  @Test
  @DisplayName("Test convertValue(Object, Class) with 'fromValue', 'toValueType'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Object JacksonUtil.convertValue(Object, Class)"})
  void testConvertValueWithFromValueToValueType() {
    // Arrange
    Class<Builder> toValueType = Builder.class;

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class, () -> JacksonUtil.convertValue("From Value", toValueType));
  }

  /**
   * Test {@link JacksonUtil#convertValue(Object, TypeReference)} with {@code fromValue}, {@code
   * toValueTypeRef}.
   *
   * <p>Method under test: {@link JacksonUtil#convertValue(Object, TypeReference)}
   */
  @Test
  @DisplayName("Test convertValue(Object, TypeReference) with 'fromValue', 'toValueTypeRef'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Object JacksonUtil.convertValue(Object, TypeReference)"})
  void testConvertValueWithFromValueToValueTypeRef() {
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
   * Test {@link JacksonUtil#convertValue(Object, TypeReference)} with {@code fromValue}, {@code
   * toValueTypeRef}.
   *
   * <p>Method under test: {@link JacksonUtil#convertValue(Object, TypeReference)}
   */
  @Test
  @DisplayName("Test convertValue(Object, TypeReference) with 'fromValue', 'toValueTypeRef'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Object JacksonUtil.convertValue(Object, TypeReference)"})
  void testConvertValueWithFromValueToValueTypeRef2() {
    // Arrange
    ArrayType arrayType = mock(ArrayType.class);
    when(arrayType.isContainerType()).thenThrow(new IllegalArgumentException());

    TypeReference<Object> toValueTypeRef = mock(TypeReference.class);
    when(toValueTypeRef.getType()).thenReturn(arrayType);

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () -> JacksonUtil.convertValue("From Value", toValueTypeRef));
    verify(toValueTypeRef).getType();
    verify(arrayType).isContainerType();
  }

  /**
   * Test {@link JacksonUtil#convertValue(Object, TypeReference)} with {@code fromValue}, {@code
   * toValueTypeRef}.
   *
   * <p>Method under test: {@link JacksonUtil#convertValue(Object, TypeReference)}
   */
  @Test
  @DisplayName("Test convertValue(Object, TypeReference) with 'fromValue', 'toValueTypeRef'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Object JacksonUtil.convertValue(Object, TypeReference)"})
  void testConvertValueWithFromValueToValueTypeRef3() {
    // Arrange
    ArrayType arrayType = mock(ArrayType.class);
    when(arrayType.isEnumType()).thenReturn(true);
    when(arrayType.getKeyType()).thenReturn(new PlaceholderForType(1));
    when(arrayType.getContentType()).thenReturn(new PlaceholderForType(1));
    when(arrayType.isMapLikeType()).thenReturn(true);
    when(arrayType.isAbstract()).thenReturn(true);
    when(arrayType.isContainerType()).thenReturn(true);
    Class<Object> forNameResult = Object.class;
    Mockito.<Class<?>>when(arrayType.getRawClass()).thenReturn(forNameResult);

    TypeReference<Object> toValueTypeRef = mock(TypeReference.class);
    when(toValueTypeRef.getType()).thenReturn(arrayType);

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () -> JacksonUtil.convertValue("From Value", toValueTypeRef));
    verify(toValueTypeRef).getType();
    verify(arrayType, atLeast(1)).getKeyType();
    verify(arrayType, atLeast(1)).getRawClass();
    verify(arrayType).isEnumType();
    verify(arrayType, atLeast(1)).isMapLikeType();
    verify(arrayType, atLeast(1)).getContentType();
    verify(arrayType).isAbstract();
    verify(arrayType, atLeast(1)).isContainerType();
  }

  /**
   * Test {@link JacksonUtil#convertValue(Object, TypeReference)} with {@code fromValue}, {@code
   * toValueTypeRef}.
   *
   * <p>Method under test: {@link JacksonUtil#convertValue(Object, TypeReference)}
   */
  @Test
  @DisplayName("Test convertValue(Object, TypeReference) with 'fromValue', 'toValueTypeRef'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Object JacksonUtil.convertValue(Object, TypeReference)"})
  void testConvertValueWithFromValueToValueTypeRef4() {
    // Arrange
    ArrayType arrayType = mock(ArrayType.class);
    when(arrayType.getValueHandler()).thenReturn("Value Handler");

    ArrayType arrayType2 = mock(ArrayType.class);
    when(arrayType2.isEnumType()).thenReturn(true);
    when(arrayType2.getKeyType()).thenReturn(new PlaceholderForType(1));
    when(arrayType2.getContentType()).thenReturn(arrayType);
    when(arrayType2.isMapLikeType()).thenReturn(true);
    when(arrayType2.isAbstract()).thenReturn(true);
    when(arrayType2.isContainerType()).thenReturn(true);
    Class<Object> forNameResult = Object.class;
    Mockito.<Class<?>>when(arrayType2.getRawClass()).thenReturn(forNameResult);

    TypeReference<Object> toValueTypeRef = mock(TypeReference.class);
    when(toValueTypeRef.getType()).thenReturn(arrayType2);

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () -> JacksonUtil.convertValue("From Value", toValueTypeRef));
    verify(toValueTypeRef).getType();
    verify(arrayType2, atLeast(1)).getKeyType();
    verify(arrayType2, atLeast(1)).getRawClass();
    verify(arrayType, atLeast(1)).getValueHandler();
    verify(arrayType2).isEnumType();
    verify(arrayType2, atLeast(1)).isMapLikeType();
    verify(arrayType2, atLeast(1)).getContentType();
    verify(arrayType2).isAbstract();
    verify(arrayType2, atLeast(1)).isContainerType();
  }

  /**
   * Test {@link JacksonUtil#convertValue(Object, TypeReference)} with {@code fromValue}, {@code
   * toValueTypeRef}.
   *
   * <p>Method under test: {@link JacksonUtil#convertValue(Object, TypeReference)}
   */
  @Test
  @DisplayName("Test convertValue(Object, TypeReference) with 'fromValue', 'toValueTypeRef'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Object JacksonUtil.convertValue(Object, TypeReference)"})
  void testConvertValueWithFromValueToValueTypeRef5() {
    // Arrange
    ArrayType arrayType = mock(ArrayType.class);
    when(arrayType.getValueHandler()).thenReturn("Value Handler");

    ArrayType arrayType2 = mock(ArrayType.class);
    when(arrayType2.isEnumType()).thenReturn(true);
    when(arrayType2.getKeyType()).thenReturn(new PlaceholderForType(1));
    when(arrayType2.getContentType()).thenReturn(arrayType);
    when(arrayType2.isMapLikeType()).thenReturn(true);
    when(arrayType2.isAbstract()).thenReturn(true);
    when(arrayType2.isContainerType()).thenReturn(false);
    Class<Object> forNameResult = Object.class;
    Mockito.<Class<?>>when(arrayType2.getRawClass()).thenReturn(forNameResult);

    TypeReference<Object> toValueTypeRef = mock(TypeReference.class);
    when(toValueTypeRef.getType()).thenReturn(arrayType2);

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () -> JacksonUtil.convertValue("From Value", toValueTypeRef));
    verify(toValueTypeRef).getType();
    verify(arrayType2, atLeast(1)).getKeyType();
    verify(arrayType2, atLeast(1)).getRawClass();
    verify(arrayType).getValueHandler();
    verify(arrayType2).isEnumType();
    verify(arrayType2, atLeast(1)).isMapLikeType();
    verify(arrayType2, atLeast(1)).getContentType();
    verify(arrayType2).isAbstract();
    verify(arrayType2, atLeast(1)).isContainerType();
  }

  /**
   * Test {@link JacksonUtil#convertValue(Object, TypeReference)} with {@code fromValue}, {@code
   * toValueTypeRef}.
   *
   * <p>Method under test: {@link JacksonUtil#convertValue(Object, TypeReference)}
   */
  @Test
  @DisplayName("Test convertValue(Object, TypeReference) with 'fromValue', 'toValueTypeRef'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Object JacksonUtil.convertValue(Object, TypeReference)"})
  void testConvertValueWithFromValueToValueTypeRef6() {
    // Arrange
    ArrayType arrayType = mock(ArrayType.class);
    when(arrayType.getValueHandler()).thenReturn("Value Handler");

    ArrayType arrayType2 = mock(ArrayType.class);
    when(arrayType2.isRecordType()).thenThrow(new IllegalArgumentException());
    when(arrayType2.isArrayType()).thenReturn(true);
    when(arrayType2.getContentType()).thenReturn(arrayType);
    when(arrayType2.isAbstract()).thenReturn(true);
    when(arrayType2.isContainerType()).thenReturn(true);
    Class<Builder> forNameResult = Builder.class;
    Mockito.<Class<?>>when(arrayType2.getRawClass()).thenReturn(forNameResult);

    TypeReference<Object> toValueTypeRef = mock(TypeReference.class);
    when(toValueTypeRef.getType()).thenReturn(arrayType2);

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () -> JacksonUtil.convertValue("From Value", toValueTypeRef));
    verify(toValueTypeRef).getType();
    verify(arrayType2, atLeast(1)).getRawClass();
    verify(arrayType, atLeast(1)).getValueHandler();
    verify(arrayType2).isRecordType();
    verify(arrayType2, atLeast(1)).getContentType();
    verify(arrayType2).isAbstract();
    verify(arrayType2, atLeast(1)).isArrayType();
    verify(arrayType2, atLeast(1)).isContainerType();
  }

  /**
   * Test {@link JacksonUtil#convertValue(Object, TypeReference)} with {@code fromValue}, {@code
   * toValueTypeRef}.
   *
   * <p>Method under test: {@link JacksonUtil#convertValue(Object, TypeReference)}
   */
  @Test
  @DisplayName("Test convertValue(Object, TypeReference) with 'fromValue', 'toValueTypeRef'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Object JacksonUtil.convertValue(Object, TypeReference)"})
  void testConvertValueWithFromValueToValueTypeRef7() {
    // Arrange
    ArrayType arrayType = mock(ArrayType.class);
    when(arrayType.getValueHandler()).thenReturn("Value Handler");

    ArrayType arrayType2 = mock(ArrayType.class);
    when(arrayType2.getSuperClass()).thenReturn(new PlaceholderForType(1));
    when(arrayType2.getBindings()).thenReturn(TypeBindings.emptyBindings());
    when(arrayType2.hasRawClass(Mockito.<Class<?>>any())).thenReturn(true);
    when(arrayType2.isConcrete()).thenReturn(true);
    when(arrayType2.isRecordType()).thenReturn(true);
    when(arrayType2.isArrayType()).thenReturn(false);
    when(arrayType2.isEnumType()).thenReturn(true);
    when(arrayType2.getKeyType()).thenReturn(new PlaceholderForType(1));
    when(arrayType2.getContentType()).thenReturn(arrayType);
    when(arrayType2.isMapLikeType()).thenReturn(true);
    when(arrayType2.isAbstract()).thenReturn(true);
    when(arrayType2.isContainerType()).thenReturn(true);
    Class<Builder> forNameResult = Builder.class;
    Mockito.<Class<?>>when(arrayType2.getRawClass()).thenReturn(forNameResult);

    TypeReference<Object> toValueTypeRef = mock(TypeReference.class);
    when(toValueTypeRef.getType()).thenReturn(arrayType2);

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () -> JacksonUtil.convertValue("From Value", toValueTypeRef));
    verify(toValueTypeRef).getType();
    verify(arrayType2, atLeast(1)).getKeyType();
    verify(arrayType2, atLeast(1)).getRawClass();
    verify(arrayType, atLeast(1)).getValueHandler();
    verify(arrayType2).hasRawClass(isA(Class.class));
    verify(arrayType2, atLeast(1)).isEnumType();
    verify(arrayType2, atLeast(1)).isMapLikeType();
    verify(arrayType2, atLeast(1)).isRecordType();
    verify(arrayType2, atLeast(1)).getContentType();
    verify(arrayType2).isAbstract();
    verify(arrayType2, atLeast(1)).isArrayType();
    verify(arrayType2).isConcrete();
    verify(arrayType2, atLeast(1)).isContainerType();
    verify(arrayType2).getBindings();
    verify(arrayType2).getSuperClass();
  }

  /**
   * Test {@link JacksonUtil#convertValue(Object, TypeReference)} with {@code fromValue}, {@code
   * toValueTypeRef}.
   *
   * <p>Method under test: {@link JacksonUtil#convertValue(Object, TypeReference)}
   */
  @Test
  @DisplayName("Test convertValue(Object, TypeReference) with 'fromValue', 'toValueTypeRef'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Object JacksonUtil.convertValue(Object, TypeReference)"})
  void testConvertValueWithFromValueToValueTypeRef8() {
    // Arrange
    ArrayType arrayType = mock(ArrayType.class);
    when(arrayType.getValueHandler()).thenReturn("Value Handler");

    ArrayType arrayType2 = mock(ArrayType.class);
    Class<Object> erasedType = Object.class;
    when(arrayType2.getSuperClass())
        .thenReturn(new ResolvedRecursiveType(erasedType, TypeBindings.emptyBindings()));
    when(arrayType2.getBindings()).thenReturn(TypeBindings.emptyBindings());
    when(arrayType2.hasRawClass(Mockito.<Class<?>>any())).thenReturn(true);
    when(arrayType2.isConcrete()).thenReturn(true);
    when(arrayType2.isRecordType()).thenReturn(true);
    when(arrayType2.isArrayType()).thenReturn(false);
    when(arrayType2.isEnumType()).thenReturn(true);
    when(arrayType2.getKeyType()).thenReturn(new PlaceholderForType(1));
    when(arrayType2.getContentType()).thenReturn(arrayType);
    when(arrayType2.isMapLikeType()).thenReturn(true);
    when(arrayType2.isAbstract()).thenReturn(true);
    when(arrayType2.isContainerType()).thenReturn(true);
    Class<Builder> forNameResult = Builder.class;
    Mockito.<Class<?>>when(arrayType2.getRawClass()).thenReturn(forNameResult);

    TypeReference<Object> toValueTypeRef = mock(TypeReference.class);
    when(toValueTypeRef.getType()).thenReturn(arrayType2);

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () -> JacksonUtil.convertValue("From Value", toValueTypeRef));
    verify(toValueTypeRef).getType();
    verify(arrayType2, atLeast(1)).getKeyType();
    verify(arrayType2, atLeast(1)).getRawClass();
    verify(arrayType, atLeast(1)).getValueHandler();
    verify(arrayType2).hasRawClass(isA(Class.class));
    verify(arrayType2, atLeast(1)).isEnumType();
    verify(arrayType2, atLeast(1)).isMapLikeType();
    verify(arrayType2, atLeast(1)).isRecordType();
    verify(arrayType2, atLeast(1)).getContentType();
    verify(arrayType2).isAbstract();
    verify(arrayType2, atLeast(1)).isArrayType();
    verify(arrayType2).isConcrete();
    verify(arrayType2, atLeast(1)).isContainerType();
    verify(arrayType2).getBindings();
    verify(arrayType2).getSuperClass();
  }

  /**
   * Test {@link JacksonUtil#convertValue(Object, TypeReference)} with {@code fromValue}, {@code
   * toValueTypeRef}.
   *
   * <ul>
   *   <li>Given {@link ArrayType} {@link ArrayType#isArrayType()} return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link JacksonUtil#convertValue(Object, TypeReference)}
   */
  @Test
  @DisplayName(
      "Test convertValue(Object, TypeReference) with 'fromValue', 'toValueTypeRef'; given ArrayType isArrayType() return 'true'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Object JacksonUtil.convertValue(Object, TypeReference)"})
  void testConvertValueWithFromValueToValueTypeRef_givenArrayTypeIsArrayTypeReturnTrue() {
    // Arrange
    ArrayType arrayType = mock(ArrayType.class);
    when(arrayType.getValueHandler()).thenReturn("Value Handler");

    ArrayType arrayType2 = mock(ArrayType.class);
    when(arrayType2.isConcrete()).thenReturn(true);
    when(arrayType2.isRecordType()).thenReturn(true);
    when(arrayType2.isArrayType()).thenReturn(true);
    when(arrayType2.isEnumType()).thenReturn(true);
    when(arrayType2.getKeyType()).thenReturn(new PlaceholderForType(1));
    when(arrayType2.getContentType()).thenReturn(arrayType);
    when(arrayType2.isMapLikeType()).thenReturn(true);
    when(arrayType2.isAbstract()).thenReturn(true);
    when(arrayType2.isContainerType()).thenReturn(true);
    Class<Builder> forNameResult = Builder.class;
    Mockito.<Class<?>>when(arrayType2.getRawClass()).thenReturn(forNameResult);

    TypeReference<Object> toValueTypeRef = mock(TypeReference.class);
    when(toValueTypeRef.getType()).thenReturn(arrayType2);

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () -> JacksonUtil.convertValue("From Value", toValueTypeRef));
    verify(toValueTypeRef).getType();
    verify(arrayType2, atLeast(1)).getKeyType();
    verify(arrayType2, atLeast(1)).getRawClass();
    verify(arrayType, atLeast(1)).getValueHandler();
    verify(arrayType2).isEnumType();
    verify(arrayType2, atLeast(1)).isMapLikeType();
    verify(arrayType2, atLeast(1)).isRecordType();
    verify(arrayType2, atLeast(1)).getContentType();
    verify(arrayType2).isAbstract();
    verify(arrayType2, atLeast(1)).isArrayType();
    verify(arrayType2).isConcrete();
    verify(arrayType2, atLeast(1)).isContainerType();
  }

  /**
   * Test {@link JacksonUtil#convertValue(Object, TypeReference)} with {@code fromValue}, {@code
   * toValueTypeRef}.
   *
   * <ul>
   *   <li>Given {@link IllegalArgumentException#IllegalArgumentException()}.
   * </ul>
   *
   * <p>Method under test: {@link JacksonUtil#convertValue(Object, TypeReference)}
   */
  @Test
  @DisplayName(
      "Test convertValue(Object, TypeReference) with 'fromValue', 'toValueTypeRef'; given IllegalArgumentException()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Object JacksonUtil.convertValue(Object, TypeReference)"})
  void testConvertValueWithFromValueToValueTypeRef_givenIllegalArgumentException() {
    // Arrange
    TypeReference<Object> toValueTypeRef = mock(TypeReference.class);
    when(toValueTypeRef.getType()).thenThrow(new IllegalArgumentException());

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () -> JacksonUtil.convertValue("From Value", toValueTypeRef));
    verify(toValueTypeRef).getType();
  }

  /**
   * Test {@link JacksonUtil#convertValue(Object, TypeReference)} with {@code fromValue}, {@code
   * toValueTypeRef}.
   *
   * <ul>
   *   <li>Given {@link Object}.
   * </ul>
   *
   * <p>Method under test: {@link JacksonUtil#convertValue(Object, TypeReference)}
   */
  @Test
  @DisplayName(
      "Test convertValue(Object, TypeReference) with 'fromValue', 'toValueTypeRef'; given Object")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Object JacksonUtil.convertValue(Object, TypeReference)"})
  void testConvertValueWithFromValueToValueTypeRef_givenObject() {
    // Arrange
    TypeReference<Object> toValueTypeRef = mock(TypeReference.class);
    Class<Object> forNameResult = Object.class;
    when(toValueTypeRef.getType()).thenReturn(forNameResult);

    // Act
    Object actualConvertValueResult = JacksonUtil.convertValue("From Value", toValueTypeRef);

    // Assert
    verify(toValueTypeRef).getType();
    assertEquals("From Value", actualConvertValueResult);
  }

  /**
   * Test {@link JacksonUtil#convertValue(Object, TypeReference)} with {@code fromValue}, {@code
   * toValueTypeRef}.
   *
   * <ul>
   *   <li>When forty-two.
   * </ul>
   *
   * <p>Method under test: {@link JacksonUtil#convertValue(Object, TypeReference)}
   */
  @Test
  @DisplayName(
      "Test convertValue(Object, TypeReference) with 'fromValue', 'toValueTypeRef'; when forty-two")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Object JacksonUtil.convertValue(Object, TypeReference)"})
  void testConvertValueWithFromValueToValueTypeRef_whenFortyTwo() {
    // Arrange
    ArrayType arrayType = mock(ArrayType.class);
    when(arrayType.getValueHandler()).thenReturn("Value Handler");

    ArrayType arrayType2 = mock(ArrayType.class);
    when(arrayType2.isEnumType()).thenReturn(true);
    when(arrayType2.getKeyType()).thenReturn(new PlaceholderForType(1));
    when(arrayType2.getContentType()).thenReturn(arrayType);
    when(arrayType2.isMapLikeType()).thenReturn(true);
    when(arrayType2.isAbstract()).thenReturn(true);
    when(arrayType2.isContainerType()).thenReturn(true);
    Class<Object> forNameResult = Object.class;
    Mockito.<Class<?>>when(arrayType2.getRawClass()).thenReturn(forNameResult);

    TypeReference<Object> toValueTypeRef = mock(TypeReference.class);
    when(toValueTypeRef.getType()).thenReturn(arrayType2);

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class, () -> JacksonUtil.convertValue(42, toValueTypeRef));
    verify(toValueTypeRef).getType();
    verify(arrayType2, atLeast(1)).getKeyType();
    verify(arrayType2, atLeast(1)).getRawClass();
    verify(arrayType, atLeast(1)).getValueHandler();
    verify(arrayType2).isEnumType();
    verify(arrayType2, atLeast(1)).isMapLikeType();
    verify(arrayType2, atLeast(1)).getContentType();
    verify(arrayType2).isAbstract();
    verify(arrayType2, atLeast(1)).isContainerType();
  }

  /**
   * Test {@link JacksonUtil#convertValue(Object, TypeReference)} with {@code fromValue}, {@code
   * toValueTypeRef}.
   *
   * <ul>
   *   <li>When {@code null}.
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link JacksonUtil#convertValue(Object, TypeReference)}
   */
  @Test
  @DisplayName(
      "Test convertValue(Object, TypeReference) with 'fromValue', 'toValueTypeRef'; when 'null'; then return 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Object JacksonUtil.convertValue(Object, TypeReference)"})
  void testConvertValueWithFromValueToValueTypeRef_whenNull_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull(JacksonUtil.convertValue(null, mock(TypeReference.class)));
  }

  /**
   * Test {@link JacksonUtil#convertValue(Object, Class)} with {@code fromValue}, {@code
   * toValueType}.
   *
   * <ul>
   *   <li>Then return intValue is forty-two.
   * </ul>
   *
   * <p>Method under test: {@link JacksonUtil#convertValue(Object, Class)}
   */
  @Test
  @DisplayName(
      "Test convertValue(Object, Class) with 'fromValue', 'toValueType'; then return intValue is forty-two")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Object JacksonUtil.convertValue(Object, Class)"})
  void testConvertValueWithFromValueToValueType_thenReturnIntValueIsFortyTwo() {
    // Arrange
    Class<Object> toValueType = Object.class;

    // Act
    Object actualConvertValueResult = JacksonUtil.convertValue(42, toValueType);

    // Assert
    assertEquals(42, ((Integer) actualConvertValueResult).intValue());
  }

  /**
   * Test {@link JacksonUtil#convertValue(Object, Class)} with {@code fromValue}, {@code
   * toValueType}.
   *
   * <ul>
   *   <li>Then return {@code Object}.
   * </ul>
   *
   * <p>Method under test: {@link JacksonUtil#convertValue(Object, Class)}
   */
  @Test
  @DisplayName(
      "Test convertValue(Object, Class) with 'fromValue', 'toValueType'; then return 'java.lang.Object'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Object JacksonUtil.convertValue(Object, Class)"})
  void testConvertValueWithFromValueToValueType_thenReturnJavaLangObject() {
    // Arrange
    Class<Object> forNameResult = Object.class;
    Class<Object> toValueType = Object.class;

    // Act and Assert
    assertEquals("java.lang.Object", JacksonUtil.convertValue(forNameResult, toValueType));
  }

  /**
   * Test {@link JacksonUtil#convertValue(Object, Class)} with {@code fromValue}, {@code
   * toValueType}.
   *
   * <ul>
   *   <li>When empty string.
   * </ul>
   *
   * <p>Method under test: {@link JacksonUtil#convertValue(Object, Class)}
   */
  @Test
  @DisplayName(
      "Test convertValue(Object, Class) with 'fromValue', 'toValueType'; when empty string")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Object JacksonUtil.convertValue(Object, Class)"})
  void testConvertValueWithFromValueToValueType_whenEmptyString() {
    // Arrange
    Class<Builder> toValueType = Builder.class;

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> JacksonUtil.convertValue("", toValueType));
  }

  /**
   * Test {@link JacksonUtil#convertValue(Object, Class)} with {@code fromValue}, {@code
   * toValueType}.
   *
   * <ul>
   *   <li>When forty-two.
   * </ul>
   *
   * <p>Method under test: {@link JacksonUtil#convertValue(Object, Class)}
   */
  @Test
  @DisplayName("Test convertValue(Object, Class) with 'fromValue', 'toValueType'; when forty-two")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Object JacksonUtil.convertValue(Object, Class)"})
  void testConvertValueWithFromValueToValueType_whenFortyTwo() {
    // Arrange
    Class<Builder> toValueType = Builder.class;

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> JacksonUtil.convertValue(42, toValueType));
  }

  /**
   * Test {@link JacksonUtil#convertValue(Object, Class)} with {@code fromValue}, {@code
   * toValueType}.
   *
   * <ul>
   *   <li>When {@code From Value}.
   *   <li>Then return {@code From Value}.
   * </ul>
   *
   * <p>Method under test: {@link JacksonUtil#convertValue(Object, Class)}
   */
  @Test
  @DisplayName(
      "Test convertValue(Object, Class) with 'fromValue', 'toValueType'; when 'From Value'; then return 'From Value'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Object JacksonUtil.convertValue(Object, Class)"})
  void testConvertValueWithFromValueToValueType_whenFromValue_thenReturnFromValue() {
    // Arrange
    Class<Object> toValueType = Object.class;

    // Act and Assert
    assertEquals("From Value", JacksonUtil.convertValue("From Value", toValueType));
  }

  /**
   * Test {@link JacksonUtil#convertValue(Object, Class)} with {@code fromValue}, {@code
   * toValueType}.
   *
   * <ul>
   *   <li>When {@code String}.
   *   <li>Then return {@code 42}.
   * </ul>
   *
   * <p>Method under test: {@link JacksonUtil#convertValue(Object, Class)}
   */
  @Test
  @DisplayName(
      "Test convertValue(Object, Class) with 'fromValue', 'toValueType'; when 'java.lang.String'; then return '42'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Object JacksonUtil.convertValue(Object, Class)"})
  void testConvertValueWithFromValueToValueType_whenJavaLangString_thenReturn42() {
    // Arrange
    Class<String> toValueType = String.class;

    // Act and Assert
    assertEquals("42", JacksonUtil.convertValue(42, toValueType));
  }

  /**
   * Test {@link JacksonUtil#convertValue(Object, Class)} with {@code fromValue}, {@code
   * toValueType}.
   *
   * <ul>
   *   <li>When {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link JacksonUtil#convertValue(Object, Class)}
   */
  @Test
  @DisplayName("Test convertValue(Object, Class) with 'fromValue', 'toValueType'; when 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Object JacksonUtil.convertValue(Object, Class)"})
  void testConvertValueWithFromValueToValueType_whenNull() {
    // Arrange, Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () -> JacksonUtil.convertValue("From Value", (Class<Object>) null));
  }

  /**
   * Test {@link JacksonUtil#convertValue(Object, Class)} with {@code fromValue}, {@code
   * toValueType}.
   *
   * <ul>
   *   <li>When {@code null}.
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link JacksonUtil#convertValue(Object, Class)}
   */
  @Test
  @DisplayName(
      "Test convertValue(Object, Class) with 'fromValue', 'toValueType'; when 'null'; then return 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Object JacksonUtil.convertValue(Object, Class)"})
  void testConvertValueWithFromValueToValueType_whenNull_thenReturnNull() {
    // Arrange
    Class<Object> toValueType = Object.class;

    // Act and Assert
    assertNull(JacksonUtil.convertValue(null, toValueType));
  }

  /**
   * Test {@link JacksonUtil#convertValue(Object, Class)} with {@code fromValue}, {@code
   * toValueType}.
   *
   * <ul>
   *   <li>When one.
   *   <li>Then return intValue is one.
   * </ul>
   *
   * <p>Method under test: {@link JacksonUtil#convertValue(Object, Class)}
   */
  @Test
  @DisplayName(
      "Test convertValue(Object, Class) with 'fromValue', 'toValueType'; when one; then return intValue is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Object JacksonUtil.convertValue(Object, Class)"})
  void testConvertValueWithFromValueToValueType_whenOne_thenReturnIntValueIsOne() {
    // Arrange
    Class<Object> toValueType = Object.class;

    // Act
    Object actualConvertValueResult = JacksonUtil.convertValue(1, toValueType);

    // Assert
    assertEquals(1, ((Integer) actualConvertValueResult).intValue());
  }

  /**
   * Test {@link JacksonUtil#convertValue(Object, Class)} with {@code fromValue}, {@code
   * toValueType}.
   *
   * <ul>
   *   <li>When {@code JacksonUtil}.
   * </ul>
   *
   * <p>Method under test: {@link JacksonUtil#convertValue(Object, Class)}
   */
  @Test
  @DisplayName(
      "Test convertValue(Object, Class) with 'fromValue', 'toValueType'; when 'org.thingsboard.common.util.JacksonUtil'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Object JacksonUtil.convertValue(Object, Class)"})
  void testConvertValueWithFromValueToValueType_whenOrgThingsboardCommonUtilJacksonUtil() {
    // Arrange
    Class<JacksonUtil> toValueType = JacksonUtil.class;

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class, () -> JacksonUtil.convertValue("From Value", toValueType));
  }

  /**
   * Test {@link JacksonUtil#fromString(String, Class)} with {@code string}, {@code clazz}.
   *
   * <p>Method under test: {@link JacksonUtil#fromString(String, Class)}
   */
  @Test
  @DisplayName("Test fromString(String, Class) with 'string', 'clazz'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Object JacksonUtil.fromString(String, Class)"})
  void testFromStringWithStringClazz() {
    // Arrange
    Class<Builder> clazz = Builder.class;

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> JacksonUtil.fromString("String", clazz));
  }

  /**
   * Test {@link JacksonUtil#fromString(String, Class)} with {@code string}, {@code clazz}.
   *
   * <p>Method under test: {@link JacksonUtil#fromString(String, Class)}
   */
  @Test
  @DisplayName("Test fromString(String, Class) with 'string', 'clazz'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Object JacksonUtil.fromString(String, Class)"})
  void testFromStringWithStringClazz2() {
    // Arrange
    Class<Builder> clazz = Builder.class;

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> JacksonUtil.fromString("42", clazz));
  }

  /**
   * Test {@link JacksonUtil#fromString(String, Class, boolean)} with {@code string}, {@code clazz},
   * {@code ignoreUnknownFields}.
   *
   * <p>Method under test: {@link JacksonUtil#fromString(String, Class, boolean)}
   */
  @Test
  @DisplayName(
      "Test fromString(String, Class, boolean) with 'string', 'clazz', 'ignoreUnknownFields'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Object JacksonUtil.fromString(String, Class, boolean)"})
  void testFromStringWithStringClazzIgnoreUnknownFields() {
    // Arrange
    Class<Builder> clazz = Builder.class;

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> JacksonUtil.fromString("42", clazz, true));
  }

  /**
   * Test {@link JacksonUtil#fromString(String, Class, boolean)} with {@code string}, {@code clazz},
   * {@code ignoreUnknownFields}.
   *
   * <p>Method under test: {@link JacksonUtil#fromString(String, Class, boolean)}
   */
  @Test
  @DisplayName(
      "Test fromString(String, Class, boolean) with 'string', 'clazz', 'ignoreUnknownFields'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Object JacksonUtil.fromString(String, Class, boolean)"})
  void testFromStringWithStringClazzIgnoreUnknownFields2() {
    // Arrange
    Class<JacksonUtil> clazz = JacksonUtil.class;

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> JacksonUtil.fromString("\"", clazz, true));
  }

  /**
   * Test {@link JacksonUtil#fromString(String, Class, boolean)} with {@code string}, {@code clazz},
   * {@code ignoreUnknownFields}.
   *
   * <p>Method under test: {@link JacksonUtil#fromString(String, Class, boolean)}
   */
  @Test
  @DisplayName(
      "Test fromString(String, Class, boolean) with 'string', 'clazz', 'ignoreUnknownFields'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Object JacksonUtil.fromString(String, Class, boolean)"})
  void testFromStringWithStringClazzIgnoreUnknownFields3() {
    // Arrange
    Class<JacksonUtil> clazz = JacksonUtil.class;

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> JacksonUtil.fromString("42", clazz, true));
  }

  /**
   * Test {@link JacksonUtil#fromString(String, Class, boolean)} with {@code string}, {@code clazz},
   * {@code ignoreUnknownFields}.
   *
   * <ul>
   *   <li>Then return intValue is forty-two.
   * </ul>
   *
   * <p>Method under test: {@link JacksonUtil#fromString(String, Class, boolean)}
   */
  @Test
  @DisplayName(
      "Test fromString(String, Class, boolean) with 'string', 'clazz', 'ignoreUnknownFields'; then return intValue is forty-two")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Object JacksonUtil.fromString(String, Class, boolean)"})
  void testFromStringWithStringClazzIgnoreUnknownFields_thenReturnIntValueIsFortyTwo() {
    // Arrange
    Class<Object> clazz = Object.class;

    // Act
    Object actualFromStringResult = JacksonUtil.fromString("42", clazz, true);

    // Assert
    assertEquals(42, ((Integer) actualFromStringResult).intValue());
  }

  /**
   * Test {@link JacksonUtil#fromString(String, Class, boolean)} with {@code string}, {@code clazz},
   * {@code ignoreUnknownFields}.
   *
   * <ul>
   *   <li>When empty string.
   * </ul>
   *
   * <p>Method under test: {@link JacksonUtil#fromString(String, Class, boolean)}
   */
  @Test
  @DisplayName(
      "Test fromString(String, Class, boolean) with 'string', 'clazz', 'ignoreUnknownFields'; when empty string")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Object JacksonUtil.fromString(String, Class, boolean)"})
  void testFromStringWithStringClazzIgnoreUnknownFields_whenEmptyString() {
    // Arrange
    Class<Object> clazz = Object.class;

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> JacksonUtil.fromString("", clazz, true));
  }

  /**
   * Test {@link JacksonUtil#fromString(String, Class, boolean)} with {@code string}, {@code clazz},
   * {@code ignoreUnknownFields}.
   *
   * <ul>
   *   <li>When {@code String}.
   *   <li>Then return {@code 42}.
   * </ul>
   *
   * <p>Method under test: {@link JacksonUtil#fromString(String, Class, boolean)}
   */
  @Test
  @DisplayName(
      "Test fromString(String, Class, boolean) with 'string', 'clazz', 'ignoreUnknownFields'; when 'java.lang.String'; then return '42'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Object JacksonUtil.fromString(String, Class, boolean)"})
  void testFromStringWithStringClazzIgnoreUnknownFields_whenJavaLangString_thenReturn42() {
    // Arrange
    Class<String> clazz = String.class;

    // Act
    Object actualFromStringResult = JacksonUtil.fromString("42", clazz, true);

    // Assert
    assertEquals("42", actualFromStringResult);
  }

  /**
   * Test {@link JacksonUtil#fromString(String, Class, boolean)} with {@code string}, {@code clazz},
   * {@code ignoreUnknownFields}.
   *
   * <ul>
   *   <li>When {@code null}.
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link JacksonUtil#fromString(String, Class, boolean)}
   */
  @Test
  @DisplayName(
      "Test fromString(String, Class, boolean) with 'string', 'clazz', 'ignoreUnknownFields'; when 'null'; then return 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Object JacksonUtil.fromString(String, Class, boolean)"})
  void testFromStringWithStringClazzIgnoreUnknownFields_whenNull_thenReturnNull() {
    // Arrange
    Class<Object> clazz = Object.class;

    // Act
    Object actualFromStringResult = JacksonUtil.fromString(null, clazz, true);

    // Assert
    assertNull(actualFromStringResult);
  }

  /**
   * Test {@link JacksonUtil#fromString(String, Class, boolean)} with {@code string}, {@code clazz},
   * {@code ignoreUnknownFields}.
   *
   * <ul>
   *   <li>When {@code "}.
   * </ul>
   *
   * <p>Method under test: {@link JacksonUtil#fromString(String, Class, boolean)}
   */
  @Test
  @DisplayName(
      "Test fromString(String, Class, boolean) with 'string', 'clazz', 'ignoreUnknownFields'; when '\"'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Object JacksonUtil.fromString(String, Class, boolean)"})
  void testFromStringWithStringClazzIgnoreUnknownFields_whenQuotationMark() {
    // Arrange
    Class<Object> clazz = Object.class;

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> JacksonUtil.fromString("\"", clazz, true));
  }

  /**
   * Test {@link JacksonUtil#fromString(String, Class, boolean)} with {@code string}, {@code clazz},
   * {@code ignoreUnknownFields}.
   *
   * <ul>
   *   <li>When {@code "}.
   * </ul>
   *
   * <p>Method under test: {@link JacksonUtil#fromString(String, Class, boolean)}
   */
  @Test
  @DisplayName(
      "Test fromString(String, Class, boolean) with 'string', 'clazz', 'ignoreUnknownFields'; when '\"'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Object JacksonUtil.fromString(String, Class, boolean)"})
  void testFromStringWithStringClazzIgnoreUnknownFields_whenQuotationMark2() {
    // Arrange
    Class<Builder> clazz = Builder.class;

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> JacksonUtil.fromString("\"", clazz, true));
  }

  /**
   * Test {@link JacksonUtil#fromString(String, Class, boolean)} with {@code string}, {@code clazz},
   * {@code ignoreUnknownFields}.
   *
   * <ul>
   *   <li>When {@code String}.
   * </ul>
   *
   * <p>Method under test: {@link JacksonUtil#fromString(String, Class, boolean)}
   */
  @Test
  @DisplayName(
      "Test fromString(String, Class, boolean) with 'string', 'clazz', 'ignoreUnknownFields'; when 'String'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Object JacksonUtil.fromString(String, Class, boolean)"})
  void testFromStringWithStringClazzIgnoreUnknownFields_whenString() {
    // Arrange
    Class<Object> clazz = Object.class;

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class, () -> JacksonUtil.fromString("String", clazz, true));
  }

  /**
   * Test {@link JacksonUtil#fromString(String, Class, boolean)} with {@code string}, {@code clazz},
   * {@code ignoreUnknownFields}.
   *
   * <ul>
   *   <li>When {@code String}.
   * </ul>
   *
   * <p>Method under test: {@link JacksonUtil#fromString(String, Class, boolean)}
   */
  @Test
  @DisplayName(
      "Test fromString(String, Class, boolean) with 'string', 'clazz', 'ignoreUnknownFields'; when 'String'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Object JacksonUtil.fromString(String, Class, boolean)"})
  void testFromStringWithStringClazzIgnoreUnknownFields_whenString2() {
    // Arrange
    Class<Builder> clazz = Builder.class;

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class, () -> JacksonUtil.fromString("String", clazz, true));
  }

  /**
   * Test {@link JacksonUtil#fromString(String, Class)} with {@code string}, {@code clazz}.
   *
   * <ul>
   *   <li>When {@code 42}.
   *   <li>Then return intValue is forty-two.
   * </ul>
   *
   * <p>Method under test: {@link JacksonUtil#fromString(String, Class)}
   */
  @Test
  @DisplayName(
      "Test fromString(String, Class) with 'string', 'clazz'; when '42'; then return intValue is forty-two")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Object JacksonUtil.fromString(String, Class)"})
  void testFromStringWithStringClazz_when42_thenReturnIntValueIsFortyTwo() {
    // Arrange
    Class<Object> clazz = Object.class;

    // Act and Assert
    assertEquals(42, ((Integer) JacksonUtil.fromString("42", clazz)).intValue());
  }

  /**
   * Test {@link JacksonUtil#fromString(String, Class)} with {@code string}, {@code clazz}.
   *
   * <ul>
   *   <li>When empty string.
   *   <li>Then throw {@link IllegalArgumentException}.
   * </ul>
   *
   * <p>Method under test: {@link JacksonUtil#fromString(String, Class)}
   */
  @Test
  @DisplayName(
      "Test fromString(String, Class) with 'string', 'clazz'; when empty string; then throw IllegalArgumentException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Object JacksonUtil.fromString(String, Class)"})
  void testFromStringWithStringClazz_whenEmptyString_thenThrowIllegalArgumentException() {
    // Arrange
    Class<Object> clazz = Object.class;

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> JacksonUtil.fromString("", clazz));
  }

  /**
   * Test {@link JacksonUtil#fromString(String, Class)} with {@code string}, {@code clazz}.
   *
   * <ul>
   *   <li>When {@code String}.
   * </ul>
   *
   * <p>Method under test: {@link JacksonUtil#fromString(String, Class)}
   */
  @Test
  @DisplayName("Test fromString(String, Class) with 'string', 'clazz'; when 'java.lang.String'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Object JacksonUtil.fromString(String, Class)"})
  void testFromStringWithStringClazz_whenJavaLangString() {
    // Arrange
    Class<String> clazz = String.class;

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> JacksonUtil.fromString("String", clazz));
  }

  /**
   * Test {@link JacksonUtil#fromString(String, Class)} with {@code string}, {@code clazz}.
   *
   * <ul>
   *   <li>When {@code String}.
   *   <li>Then return {@code 42}.
   * </ul>
   *
   * <p>Method under test: {@link JacksonUtil#fromString(String, Class)}
   */
  @Test
  @DisplayName(
      "Test fromString(String, Class) with 'string', 'clazz'; when 'java.lang.String'; then return '42'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Object JacksonUtil.fromString(String, Class)"})
  void testFromStringWithStringClazz_whenJavaLangString_thenReturn42() {
    // Arrange
    Class<String> clazz = String.class;

    // Act and Assert
    assertEquals("42", JacksonUtil.fromString("42", clazz));
  }

  /**
   * Test {@link JacksonUtil#fromString(String, Class)} with {@code string}, {@code clazz}.
   *
   * <ul>
   *   <li>When {@code null}.
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link JacksonUtil#fromString(String, Class)}
   */
  @Test
  @DisplayName(
      "Test fromString(String, Class) with 'string', 'clazz'; when 'null'; then return 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Object JacksonUtil.fromString(String, Class)"})
  void testFromStringWithStringClazz_whenNull_thenReturnNull() {
    // Arrange
    Class<Object> clazz = Object.class;

    // Act and Assert
    assertNull(JacksonUtil.fromString(null, clazz));
  }

  /**
   * Test {@link JacksonUtil#fromString(String, Class)} with {@code string}, {@code clazz}.
   *
   * <ul>
   *   <li>When {@code JacksonUtil}.
   * </ul>
   *
   * <p>Method under test: {@link JacksonUtil#fromString(String, Class)}
   */
  @Test
  @DisplayName(
      "Test fromString(String, Class) with 'string', 'clazz'; when 'org.thingsboard.common.util.JacksonUtil'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Object JacksonUtil.fromString(String, Class)"})
  void testFromStringWithStringClazz_whenOrgThingsboardCommonUtilJacksonUtil() {
    // Arrange
    Class<JacksonUtil> clazz = JacksonUtil.class;

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> JacksonUtil.fromString("42", clazz));
  }

  /**
   * Test {@link JacksonUtil#fromString(String, Class)} with {@code string}, {@code clazz}.
   *
   * <ul>
   *   <li>When {@code "}.
   * </ul>
   *
   * <p>Method under test: {@link JacksonUtil#fromString(String, Class)}
   */
  @Test
  @DisplayName("Test fromString(String, Class) with 'string', 'clazz'; when '\"'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Object JacksonUtil.fromString(String, Class)"})
  void testFromStringWithStringClazz_whenQuotationMark() {
    // Arrange
    Class<Object> clazz = Object.class;

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> JacksonUtil.fromString("\"", clazz));
  }

  /**
   * Test {@link JacksonUtil#fromString(String, Class)} with {@code string}, {@code clazz}.
   *
   * <ul>
   *   <li>When {@code "}.
   * </ul>
   *
   * <p>Method under test: {@link JacksonUtil#fromString(String, Class)}
   */
  @Test
  @DisplayName("Test fromString(String, Class) with 'string', 'clazz'; when '\"'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Object JacksonUtil.fromString(String, Class)"})
  void testFromStringWithStringClazz_whenQuotationMark2() {
    // Arrange
    Class<Builder> clazz = Builder.class;

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> JacksonUtil.fromString("\"", clazz));
  }

  /**
   * Test {@link JacksonUtil#fromString(String, Class)} with {@code string}, {@code clazz}.
   *
   * <ul>
   *   <li>When {@code String}.
   *   <li>Then throw {@link IllegalArgumentException}.
   * </ul>
   *
   * <p>Method under test: {@link JacksonUtil#fromString(String, Class)}
   */
  @Test
  @DisplayName(
      "Test fromString(String, Class) with 'string', 'clazz'; when 'String'; then throw IllegalArgumentException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Object JacksonUtil.fromString(String, Class)"})
  void testFromStringWithStringClazz_whenString_thenThrowIllegalArgumentException() {
    // Arrange
    Class<Object> clazz = Object.class;

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> JacksonUtil.fromString("String", clazz));
  }

  /**
   * Test {@link JacksonUtil#fromString(String, JavaType)} with {@code string}, {@code javaType}.
   *
   * <p>Method under test: {@link JacksonUtil#fromString(String, JavaType)}
   */
  @Test
  @DisplayName("Test fromString(String, JavaType) with 'string', 'javaType'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Object JacksonUtil.fromString(String, JavaType)"})
  void testFromStringWithStringJavaType() {
    // Arrange
    ArrayType javaType = mock(ArrayType.class);
    when(javaType.isContainerType()).thenThrow(new IllegalArgumentException());

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> JacksonUtil.fromString("\"", javaType));
    verify(javaType).isContainerType();
  }

  /**
   * Test {@link JacksonUtil#fromString(String, JavaType)} with {@code string}, {@code javaType}.
   *
   * <p>Method under test: {@link JacksonUtil#fromString(String, JavaType)}
   */
  @Test
  @DisplayName("Test fromString(String, JavaType) with 'string', 'javaType'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Object JacksonUtil.fromString(String, JavaType)"})
  void testFromStringWithStringJavaType2() {
    // Arrange
    ArrayType javaType = mock(ArrayType.class);
    when(javaType.isEnumType()).thenReturn(true);
    when(javaType.getKeyType()).thenReturn(new PlaceholderForType(1));
    when(javaType.getContentType()).thenReturn(new PlaceholderForType(1));
    when(javaType.isMapLikeType()).thenReturn(true);
    when(javaType.isAbstract()).thenReturn(true);
    when(javaType.isContainerType()).thenReturn(true);
    Class<Object> forNameResult = Object.class;
    Mockito.<Class<?>>when(javaType.getRawClass()).thenReturn(forNameResult);

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> JacksonUtil.fromString("\"", javaType));
    verify(javaType, atLeast(1)).getKeyType();
    verify(javaType, atLeast(1)).getRawClass();
    verify(javaType).isEnumType();
    verify(javaType, atLeast(1)).isMapLikeType();
    verify(javaType, atLeast(1)).getContentType();
    verify(javaType).isAbstract();
    verify(javaType, atLeast(1)).isContainerType();
  }

  /**
   * Test {@link JacksonUtil#fromString(String, JavaType)} with {@code string}, {@code javaType}.
   *
   * <p>Method under test: {@link JacksonUtil#fromString(String, JavaType)}
   */
  @Test
  @DisplayName("Test fromString(String, JavaType) with 'string', 'javaType'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Object JacksonUtil.fromString(String, JavaType)"})
  void testFromStringWithStringJavaType3() {
    // Arrange
    ArrayType arrayType = mock(ArrayType.class);
    when(arrayType.getValueHandler()).thenReturn("Value Handler");

    ArrayType javaType = mock(ArrayType.class);
    when(javaType.isRecordType()).thenThrow(new IllegalArgumentException());
    when(javaType.isArrayType()).thenReturn(true);
    when(javaType.getContentType()).thenReturn(arrayType);
    when(javaType.isAbstract()).thenReturn(true);
    when(javaType.isContainerType()).thenReturn(true);
    Class<Builder> forNameResult = Builder.class;
    Mockito.<Class<?>>when(javaType.getRawClass()).thenReturn(forNameResult);

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> JacksonUtil.fromString("\"", javaType));
    verify(javaType, atLeast(1)).getRawClass();
    verify(arrayType, atLeast(1)).getValueHandler();
    verify(javaType).isRecordType();
    verify(javaType, atLeast(1)).getContentType();
    verify(javaType).isAbstract();
    verify(javaType, atLeast(1)).isArrayType();
    verify(javaType, atLeast(1)).isContainerType();
  }

  /**
   * Test {@link JacksonUtil#fromString(String, JavaType)} with {@code string}, {@code javaType}.
   *
   * <p>Method under test: {@link JacksonUtil#fromString(String, JavaType)}
   */
  @Test
  @DisplayName("Test fromString(String, JavaType) with 'string', 'javaType'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Object JacksonUtil.fromString(String, JavaType)"})
  void testFromStringWithStringJavaType4() {
    // Arrange
    ArrayType arrayType = mock(ArrayType.class);
    when(arrayType.getValueHandler()).thenReturn("Value Handler");

    ArrayType javaType = mock(ArrayType.class);
    when(javaType.getSuperClass()).thenReturn(new PlaceholderForType(1));
    when(javaType.getBindings()).thenReturn(TypeBindings.emptyBindings());
    when(javaType.hasRawClass(Mockito.<Class<?>>any())).thenReturn(true);
    when(javaType.isConcrete()).thenReturn(true);
    when(javaType.isRecordType()).thenReturn(true);
    when(javaType.isArrayType()).thenReturn(false);
    when(javaType.isEnumType()).thenReturn(true);
    when(javaType.getKeyType()).thenReturn(new PlaceholderForType(1));
    when(javaType.getContentType()).thenReturn(arrayType);
    when(javaType.isMapLikeType()).thenReturn(true);
    when(javaType.isAbstract()).thenReturn(true);
    when(javaType.isContainerType()).thenReturn(true);
    Class<Builder> forNameResult = Builder.class;
    Mockito.<Class<?>>when(javaType.getRawClass()).thenReturn(forNameResult);

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> JacksonUtil.fromString("\"", javaType));
    verify(javaType, atLeast(1)).getKeyType();
    verify(javaType, atLeast(1)).getRawClass();
    verify(arrayType, atLeast(1)).getValueHandler();
    verify(javaType).hasRawClass(isA(Class.class));
    verify(javaType, atLeast(1)).isEnumType();
    verify(javaType, atLeast(1)).isMapLikeType();
    verify(javaType, atLeast(1)).isRecordType();
    verify(javaType, atLeast(1)).getContentType();
    verify(javaType).isAbstract();
    verify(javaType, atLeast(1)).isArrayType();
    verify(javaType).isConcrete();
    verify(javaType, atLeast(1)).isContainerType();
    verify(javaType).getBindings();
    verify(javaType).getSuperClass();
  }

  /**
   * Test {@link JacksonUtil#fromString(String, JavaType)} with {@code string}, {@code javaType}.
   *
   * <p>Method under test: {@link JacksonUtil#fromString(String, JavaType)}
   */
  @Test
  @DisplayName("Test fromString(String, JavaType) with 'string', 'javaType'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Object JacksonUtil.fromString(String, JavaType)"})
  void testFromStringWithStringJavaType5() {
    // Arrange
    ArrayType arrayType = mock(ArrayType.class);
    when(arrayType.getValueHandler()).thenReturn("Value Handler");

    ArrayType javaType = mock(ArrayType.class);
    Class<Object> erasedType = Object.class;
    when(javaType.getSuperClass())
        .thenReturn(new ResolvedRecursiveType(erasedType, TypeBindings.emptyBindings()));
    when(javaType.getBindings()).thenReturn(TypeBindings.emptyBindings());
    when(javaType.hasRawClass(Mockito.<Class<?>>any())).thenReturn(true);
    when(javaType.isConcrete()).thenReturn(true);
    when(javaType.isRecordType()).thenReturn(true);
    when(javaType.isArrayType()).thenReturn(false);
    when(javaType.isEnumType()).thenReturn(true);
    when(javaType.getKeyType()).thenReturn(new PlaceholderForType(1));
    when(javaType.getContentType()).thenReturn(arrayType);
    when(javaType.isMapLikeType()).thenReturn(true);
    when(javaType.isAbstract()).thenReturn(true);
    when(javaType.isContainerType()).thenReturn(true);
    Class<Builder> forNameResult = Builder.class;
    Mockito.<Class<?>>when(javaType.getRawClass()).thenReturn(forNameResult);

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> JacksonUtil.fromString("\"", javaType));
    verify(javaType, atLeast(1)).getKeyType();
    verify(javaType, atLeast(1)).getRawClass();
    verify(arrayType, atLeast(1)).getValueHandler();
    verify(javaType).hasRawClass(isA(Class.class));
    verify(javaType, atLeast(1)).isEnumType();
    verify(javaType, atLeast(1)).isMapLikeType();
    verify(javaType, atLeast(1)).isRecordType();
    verify(javaType, atLeast(1)).getContentType();
    verify(javaType).isAbstract();
    verify(javaType, atLeast(1)).isArrayType();
    verify(javaType).isConcrete();
    verify(javaType, atLeast(1)).isContainerType();
    verify(javaType).getBindings();
    verify(javaType).getSuperClass();
  }

  /**
   * Test {@link JacksonUtil#fromString(String, JavaType)} with {@code string}, {@code javaType}.
   *
   * <ul>
   *   <li>Given {@link Object}.
   * </ul>
   *
   * <p>Method under test: {@link JacksonUtil#fromString(String, JavaType)}
   */
  @Test
  @DisplayName("Test fromString(String, JavaType) with 'string', 'javaType'; given Object")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Object JacksonUtil.fromString(String, JavaType)"})
  void testFromStringWithStringJavaType_givenObject() {
    // Arrange
    ArrayType arrayType = mock(ArrayType.class);
    when(arrayType.getValueHandler()).thenReturn("Value Handler");

    ArrayType javaType = mock(ArrayType.class);
    when(javaType.isEnumType()).thenReturn(true);
    when(javaType.getKeyType()).thenReturn(new PlaceholderForType(1));
    when(javaType.getContentType()).thenReturn(arrayType);
    when(javaType.isMapLikeType()).thenReturn(true);
    when(javaType.isAbstract()).thenReturn(true);
    when(javaType.isContainerType()).thenReturn(true);
    Class<Object> forNameResult = Object.class;
    Mockito.<Class<?>>when(javaType.getRawClass()).thenReturn(forNameResult);

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> JacksonUtil.fromString("\"", javaType));
    verify(javaType, atLeast(1)).getKeyType();
    verify(javaType, atLeast(1)).getRawClass();
    verify(arrayType, atLeast(1)).getValueHandler();
    verify(javaType).isEnumType();
    verify(javaType, atLeast(1)).isMapLikeType();
    verify(javaType, atLeast(1)).getContentType();
    verify(javaType).isAbstract();
    verify(javaType, atLeast(1)).isContainerType();
  }

  /**
   * Test {@link JacksonUtil#fromString(String, JavaType)} with {@code string}, {@code javaType}.
   *
   * <ul>
   *   <li>Given {@link Object}.
   *   <li>When empty string.
   * </ul>
   *
   * <p>Method under test: {@link JacksonUtil#fromString(String, JavaType)}
   */
  @Test
  @DisplayName(
      "Test fromString(String, JavaType) with 'string', 'javaType'; given Object; when empty string")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Object JacksonUtil.fromString(String, JavaType)"})
  void testFromStringWithStringJavaType_givenObject_whenEmptyString() {
    // Arrange
    ArrayType javaType = mock(ArrayType.class);
    Class<Object> forNameResult = Object.class;
    Mockito.<Class<?>>when(javaType.getRawClass()).thenReturn(forNameResult);

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> JacksonUtil.fromString("", javaType));
    verify(javaType).getRawClass();
  }

  /**
   * Test {@link JacksonUtil#fromString(String, JavaType)} with {@code string}, {@code javaType}.
   *
   * <ul>
   *   <li>When {@code 42}.
   *   <li>Then return intValue is forty-two.
   * </ul>
   *
   * <p>Method under test: {@link JacksonUtil#fromString(String, JavaType)}
   */
  @Test
  @DisplayName(
      "Test fromString(String, JavaType) with 'string', 'javaType'; when '42'; then return intValue is forty-two")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Object JacksonUtil.fromString(String, JavaType)"})
  void testFromStringWithStringJavaType_when42_thenReturnIntValueIsFortyTwo() {
    // Arrange, Act and Assert
    assertEquals(
        42, ((Integer) JacksonUtil.fromString("42", new PlaceholderForType(1))).intValue());
  }

  /**
   * Test {@link JacksonUtil#fromString(String, JavaType)} with {@code string}, {@code javaType}.
   *
   * <ul>
   *   <li>When {@link ArrayType} {@link ArrayType#isArrayType()} return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link JacksonUtil#fromString(String, JavaType)}
   */
  @Test
  @DisplayName(
      "Test fromString(String, JavaType) with 'string', 'javaType'; when ArrayType isArrayType() return 'true'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Object JacksonUtil.fromString(String, JavaType)"})
  void testFromStringWithStringJavaType_whenArrayTypeIsArrayTypeReturnTrue() {
    // Arrange
    ArrayType arrayType = mock(ArrayType.class);
    when(arrayType.getValueHandler()).thenReturn("Value Handler");

    ArrayType javaType = mock(ArrayType.class);
    when(javaType.isConcrete()).thenReturn(true);
    when(javaType.isRecordType()).thenReturn(true);
    when(javaType.isArrayType()).thenReturn(true);
    when(javaType.isEnumType()).thenReturn(true);
    when(javaType.getKeyType()).thenReturn(new PlaceholderForType(1));
    when(javaType.getContentType()).thenReturn(arrayType);
    when(javaType.isMapLikeType()).thenReturn(true);
    when(javaType.isAbstract()).thenReturn(true);
    when(javaType.isContainerType()).thenReturn(true);
    Class<Builder> forNameResult = Builder.class;
    Mockito.<Class<?>>when(javaType.getRawClass()).thenReturn(forNameResult);

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> JacksonUtil.fromString("\"", javaType));
    verify(javaType, atLeast(1)).getKeyType();
    verify(javaType, atLeast(1)).getRawClass();
    verify(arrayType, atLeast(1)).getValueHandler();
    verify(javaType).isEnumType();
    verify(javaType, atLeast(1)).isMapLikeType();
    verify(javaType, atLeast(1)).isRecordType();
    verify(javaType, atLeast(1)).getContentType();
    verify(javaType).isAbstract();
    verify(javaType, atLeast(1)).isArrayType();
    verify(javaType).isConcrete();
    verify(javaType, atLeast(1)).isContainerType();
  }

  /**
   * Test {@link JacksonUtil#fromString(String, JavaType)} with {@code string}, {@code javaType}.
   *
   * <ul>
   *   <li>When {@link ArrayType} {@link ArrayType#isContainerType()} return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link JacksonUtil#fromString(String, JavaType)}
   */
  @Test
  @DisplayName(
      "Test fromString(String, JavaType) with 'string', 'javaType'; when ArrayType isContainerType() return 'false'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Object JacksonUtil.fromString(String, JavaType)"})
  void testFromStringWithStringJavaType_whenArrayTypeIsContainerTypeReturnFalse() {
    // Arrange
    ArrayType arrayType = mock(ArrayType.class);
    when(arrayType.getValueHandler()).thenReturn("Value Handler");

    ArrayType javaType = mock(ArrayType.class);
    when(javaType.isEnumType()).thenReturn(true);
    when(javaType.getKeyType()).thenReturn(new PlaceholderForType(1));
    when(javaType.getContentType()).thenReturn(arrayType);
    when(javaType.isMapLikeType()).thenReturn(true);
    when(javaType.isAbstract()).thenReturn(true);
    when(javaType.isContainerType()).thenReturn(false);
    Class<Object> forNameResult = Object.class;
    Mockito.<Class<?>>when(javaType.getRawClass()).thenReturn(forNameResult);

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> JacksonUtil.fromString("\"", javaType));
    verify(javaType, atLeast(1)).getKeyType();
    verify(javaType, atLeast(1)).getRawClass();
    verify(arrayType).getValueHandler();
    verify(javaType).isEnumType();
    verify(javaType, atLeast(1)).isMapLikeType();
    verify(javaType, atLeast(1)).getContentType();
    verify(javaType).isAbstract();
    verify(javaType, atLeast(1)).isContainerType();
  }

  /**
   * Test {@link JacksonUtil#fromString(String, JavaType)} with {@code string}, {@code javaType}.
   *
   * <ul>
   *   <li>When empty string.
   * </ul>
   *
   * <p>Method under test: {@link JacksonUtil#fromString(String, JavaType)}
   */
  @Test
  @DisplayName("Test fromString(String, JavaType) with 'string', 'javaType'; when empty string")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Object JacksonUtil.fromString(String, JavaType)"})
  void testFromStringWithStringJavaType_whenEmptyString() {
    // Arrange, Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () -> JacksonUtil.fromString("", new PlaceholderForType(1)));
  }

  /**
   * Test {@link JacksonUtil#fromString(String, JavaType)} with {@code string}, {@code javaType}.
   *
   * <ul>
   *   <li>When {@code null}.
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link JacksonUtil#fromString(String, JavaType)}
   */
  @Test
  @DisplayName(
      "Test fromString(String, JavaType) with 'string', 'javaType'; when 'null'; then return 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Object JacksonUtil.fromString(String, JavaType)"})
  void testFromStringWithStringJavaType_whenNull_thenReturnNull() {
    // Arrange and Act
    Object actualFromStringResult = JacksonUtil.fromString(null, new PlaceholderForType(1));

    // Assert
    assertNull(actualFromStringResult);
  }

  /**
   * Test {@link JacksonUtil#fromString(String, JavaType)} with {@code string}, {@code javaType}.
   *
   * <ul>
   *   <li>When {@link PlaceholderForType#PlaceholderForType(int)} with ordinal is one.
   * </ul>
   *
   * <p>Method under test: {@link JacksonUtil#fromString(String, JavaType)}
   */
  @Test
  @DisplayName(
      "Test fromString(String, JavaType) with 'string', 'javaType'; when PlaceholderForType(int) with ordinal is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Object JacksonUtil.fromString(String, JavaType)"})
  void testFromStringWithStringJavaType_whenPlaceholderForTypeWithOrdinalIsOne() {
    // Arrange, Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () -> JacksonUtil.fromString("\"", new PlaceholderForType(1)));
  }

  /**
   * Test {@link JacksonUtil#fromString(String, JavaType)} with {@code string}, {@code javaType}.
   *
   * <ul>
   *   <li>When {@code String}.
   *   <li>Then throw {@link IllegalArgumentException}.
   * </ul>
   *
   * <p>Method under test: {@link JacksonUtil#fromString(String, JavaType)}
   */
  @Test
  @DisplayName(
      "Test fromString(String, JavaType) with 'string', 'javaType'; when 'String'; then throw IllegalArgumentException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Object JacksonUtil.fromString(String, JavaType)"})
  void testFromStringWithStringJavaType_whenString_thenThrowIllegalArgumentException() {
    // Arrange, Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () -> JacksonUtil.fromString("String", new PlaceholderForType(1)));
  }

  /**
   * Test {@link JacksonUtil#fromString(String, TypeReference)} with {@code string}, {@code
   * valueTypeRef}.
   *
   * <p>Method under test: {@link JacksonUtil#fromString(String, TypeReference)}
   */
  @Test
  @DisplayName("Test fromString(String, TypeReference) with 'string', 'valueTypeRef'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Object JacksonUtil.fromString(String, TypeReference)"})
  void testFromStringWithStringValueTypeRef() {
    // Arrange
    ArrayType arrayType = mock(ArrayType.class);
    when(arrayType.isContainerType()).thenThrow(new IllegalArgumentException());

    TypeReference<Object> valueTypeRef = mock(TypeReference.class);
    when(valueTypeRef.getType()).thenReturn(arrayType);

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> JacksonUtil.fromString("\"", valueTypeRef));
    verify(valueTypeRef).getType();
    verify(arrayType).isContainerType();
  }

  /**
   * Test {@link JacksonUtil#fromString(String, TypeReference)} with {@code string}, {@code
   * valueTypeRef}.
   *
   * <p>Method under test: {@link JacksonUtil#fromString(String, TypeReference)}
   */
  @Test
  @DisplayName("Test fromString(String, TypeReference) with 'string', 'valueTypeRef'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Object JacksonUtil.fromString(String, TypeReference)"})
  void testFromStringWithStringValueTypeRef2() {
    // Arrange
    ArrayType arrayType = mock(ArrayType.class);
    when(arrayType.isEnumType()).thenReturn(true);
    when(arrayType.getKeyType()).thenReturn(new PlaceholderForType(1));
    when(arrayType.getContentType()).thenReturn(new PlaceholderForType(1));
    when(arrayType.isMapLikeType()).thenReturn(true);
    when(arrayType.isAbstract()).thenReturn(true);
    when(arrayType.isContainerType()).thenReturn(true);
    Class<Object> forNameResult = Object.class;
    Mockito.<Class<?>>when(arrayType.getRawClass()).thenReturn(forNameResult);

    TypeReference<Object> valueTypeRef = mock(TypeReference.class);
    when(valueTypeRef.getType()).thenReturn(arrayType);

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> JacksonUtil.fromString("\"", valueTypeRef));
    verify(valueTypeRef).getType();
    verify(arrayType, atLeast(1)).getKeyType();
    verify(arrayType, atLeast(1)).getRawClass();
    verify(arrayType).isEnumType();
    verify(arrayType, atLeast(1)).isMapLikeType();
    verify(arrayType, atLeast(1)).getContentType();
    verify(arrayType).isAbstract();
    verify(arrayType, atLeast(1)).isContainerType();
  }

  /**
   * Test {@link JacksonUtil#fromString(String, TypeReference)} with {@code string}, {@code
   * valueTypeRef}.
   *
   * <p>Method under test: {@link JacksonUtil#fromString(String, TypeReference)}
   */
  @Test
  @DisplayName("Test fromString(String, TypeReference) with 'string', 'valueTypeRef'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Object JacksonUtil.fromString(String, TypeReference)"})
  void testFromStringWithStringValueTypeRef3() {
    // Arrange
    ArrayType arrayType = mock(ArrayType.class);
    when(arrayType.getValueHandler()).thenReturn("Value Handler");

    ArrayType arrayType2 = mock(ArrayType.class);
    when(arrayType2.isRecordType()).thenThrow(new IllegalArgumentException());
    when(arrayType2.isArrayType()).thenReturn(true);
    when(arrayType2.getContentType()).thenReturn(arrayType);
    when(arrayType2.isAbstract()).thenReturn(true);
    when(arrayType2.isContainerType()).thenReturn(true);
    Class<Builder> forNameResult = Builder.class;
    Mockito.<Class<?>>when(arrayType2.getRawClass()).thenReturn(forNameResult);

    TypeReference<Object> valueTypeRef = mock(TypeReference.class);
    when(valueTypeRef.getType()).thenReturn(arrayType2);

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> JacksonUtil.fromString("\"", valueTypeRef));
    verify(valueTypeRef).getType();
    verify(arrayType2, atLeast(1)).getRawClass();
    verify(arrayType, atLeast(1)).getValueHandler();
    verify(arrayType2).isRecordType();
    verify(arrayType2, atLeast(1)).getContentType();
    verify(arrayType2).isAbstract();
    verify(arrayType2, atLeast(1)).isArrayType();
    verify(arrayType2, atLeast(1)).isContainerType();
  }

  /**
   * Test {@link JacksonUtil#fromString(String, TypeReference)} with {@code string}, {@code
   * valueTypeRef}.
   *
   * <p>Method under test: {@link JacksonUtil#fromString(String, TypeReference)}
   */
  @Test
  @DisplayName("Test fromString(String, TypeReference) with 'string', 'valueTypeRef'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Object JacksonUtil.fromString(String, TypeReference)"})
  void testFromStringWithStringValueTypeRef4() {
    // Arrange
    ArrayType arrayType = mock(ArrayType.class);
    when(arrayType.getValueHandler()).thenReturn("Value Handler");

    ArrayType arrayType2 = mock(ArrayType.class);
    when(arrayType2.getSuperClass()).thenReturn(new PlaceholderForType(1));
    when(arrayType2.getBindings()).thenReturn(TypeBindings.emptyBindings());
    when(arrayType2.hasRawClass(Mockito.<Class<?>>any())).thenReturn(true);
    when(arrayType2.isConcrete()).thenReturn(true);
    when(arrayType2.isRecordType()).thenReturn(true);
    when(arrayType2.isArrayType()).thenReturn(false);
    when(arrayType2.isEnumType()).thenReturn(true);
    when(arrayType2.getKeyType()).thenReturn(new PlaceholderForType(1));
    when(arrayType2.getContentType()).thenReturn(arrayType);
    when(arrayType2.isMapLikeType()).thenReturn(true);
    when(arrayType2.isAbstract()).thenReturn(true);
    when(arrayType2.isContainerType()).thenReturn(true);
    Class<Builder> forNameResult = Builder.class;
    Mockito.<Class<?>>when(arrayType2.getRawClass()).thenReturn(forNameResult);

    TypeReference<Object> valueTypeRef = mock(TypeReference.class);
    when(valueTypeRef.getType()).thenReturn(arrayType2);

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> JacksonUtil.fromString("\"", valueTypeRef));
    verify(valueTypeRef).getType();
    verify(arrayType2, atLeast(1)).getKeyType();
    verify(arrayType2, atLeast(1)).getRawClass();
    verify(arrayType, atLeast(1)).getValueHandler();
    verify(arrayType2).hasRawClass(isA(Class.class));
    verify(arrayType2, atLeast(1)).isEnumType();
    verify(arrayType2, atLeast(1)).isMapLikeType();
    verify(arrayType2, atLeast(1)).isRecordType();
    verify(arrayType2, atLeast(1)).getContentType();
    verify(arrayType2).isAbstract();
    verify(arrayType2, atLeast(1)).isArrayType();
    verify(arrayType2).isConcrete();
    verify(arrayType2, atLeast(1)).isContainerType();
    verify(arrayType2).getBindings();
    verify(arrayType2).getSuperClass();
  }

  /**
   * Test {@link JacksonUtil#fromString(String, TypeReference)} with {@code string}, {@code
   * valueTypeRef}.
   *
   * <p>Method under test: {@link JacksonUtil#fromString(String, TypeReference)}
   */
  @Test
  @DisplayName("Test fromString(String, TypeReference) with 'string', 'valueTypeRef'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Object JacksonUtil.fromString(String, TypeReference)"})
  void testFromStringWithStringValueTypeRef5() {
    // Arrange
    ArrayType arrayType = mock(ArrayType.class);
    when(arrayType.getValueHandler()).thenReturn("Value Handler");

    ArrayType arrayType2 = mock(ArrayType.class);
    Class<Object> erasedType = Object.class;
    when(arrayType2.getSuperClass())
        .thenReturn(new ResolvedRecursiveType(erasedType, TypeBindings.emptyBindings()));
    when(arrayType2.getBindings()).thenReturn(TypeBindings.emptyBindings());
    when(arrayType2.hasRawClass(Mockito.<Class<?>>any())).thenReturn(true);
    when(arrayType2.isConcrete()).thenReturn(true);
    when(arrayType2.isRecordType()).thenReturn(true);
    when(arrayType2.isArrayType()).thenReturn(false);
    when(arrayType2.isEnumType()).thenReturn(true);
    when(arrayType2.getKeyType()).thenReturn(new PlaceholderForType(1));
    when(arrayType2.getContentType()).thenReturn(arrayType);
    when(arrayType2.isMapLikeType()).thenReturn(true);
    when(arrayType2.isAbstract()).thenReturn(true);
    when(arrayType2.isContainerType()).thenReturn(true);
    Class<Builder> forNameResult = Builder.class;
    Mockito.<Class<?>>when(arrayType2.getRawClass()).thenReturn(forNameResult);

    TypeReference<Object> valueTypeRef = mock(TypeReference.class);
    when(valueTypeRef.getType()).thenReturn(arrayType2);

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> JacksonUtil.fromString("\"", valueTypeRef));
    verify(valueTypeRef).getType();
    verify(arrayType2, atLeast(1)).getKeyType();
    verify(arrayType2, atLeast(1)).getRawClass();
    verify(arrayType, atLeast(1)).getValueHandler();
    verify(arrayType2).hasRawClass(isA(Class.class));
    verify(arrayType2, atLeast(1)).isEnumType();
    verify(arrayType2, atLeast(1)).isMapLikeType();
    verify(arrayType2, atLeast(1)).isRecordType();
    verify(arrayType2, atLeast(1)).getContentType();
    verify(arrayType2).isAbstract();
    verify(arrayType2, atLeast(1)).isArrayType();
    verify(arrayType2).isConcrete();
    verify(arrayType2, atLeast(1)).isContainerType();
    verify(arrayType2).getBindings();
    verify(arrayType2).getSuperClass();
  }

  /**
   * Test {@link JacksonUtil#fromString(String, TypeReference)} with {@code string}, {@code
   * valueTypeRef}.
   *
   * <ul>
   *   <li>Given {@link ArrayType} {@link ArrayType#getRawClass()} return {@link Object}.
   * </ul>
   *
   * <p>Method under test: {@link JacksonUtil#fromString(String, TypeReference)}
   */
  @Test
  @DisplayName(
      "Test fromString(String, TypeReference) with 'string', 'valueTypeRef'; given ArrayType getRawClass() return Object")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Object JacksonUtil.fromString(String, TypeReference)"})
  void testFromStringWithStringValueTypeRef_givenArrayTypeGetRawClassReturnObject() {
    // Arrange
    ArrayType arrayType = mock(ArrayType.class);
    when(arrayType.getValueHandler()).thenReturn("Value Handler");

    ArrayType arrayType2 = mock(ArrayType.class);
    when(arrayType2.isEnumType()).thenReturn(true);
    when(arrayType2.getKeyType()).thenReturn(new PlaceholderForType(1));
    when(arrayType2.getContentType()).thenReturn(arrayType);
    when(arrayType2.isMapLikeType()).thenReturn(true);
    when(arrayType2.isAbstract()).thenReturn(true);
    when(arrayType2.isContainerType()).thenReturn(true);
    Class<Object> forNameResult = Object.class;
    Mockito.<Class<?>>when(arrayType2.getRawClass()).thenReturn(forNameResult);

    TypeReference<Object> valueTypeRef = mock(TypeReference.class);
    when(valueTypeRef.getType()).thenReturn(arrayType2);

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> JacksonUtil.fromString("\"", valueTypeRef));
    verify(valueTypeRef).getType();
    verify(arrayType2, atLeast(1)).getKeyType();
    verify(arrayType2, atLeast(1)).getRawClass();
    verify(arrayType, atLeast(1)).getValueHandler();
    verify(arrayType2).isEnumType();
    verify(arrayType2, atLeast(1)).isMapLikeType();
    verify(arrayType2, atLeast(1)).getContentType();
    verify(arrayType2).isAbstract();
    verify(arrayType2, atLeast(1)).isContainerType();
  }

  /**
   * Test {@link JacksonUtil#fromString(String, TypeReference)} with {@code string}, {@code
   * valueTypeRef}.
   *
   * <ul>
   *   <li>Given {@link ArrayType} {@link ArrayType#isArrayType()} return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link JacksonUtil#fromString(String, TypeReference)}
   */
  @Test
  @DisplayName(
      "Test fromString(String, TypeReference) with 'string', 'valueTypeRef'; given ArrayType isArrayType() return 'true'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Object JacksonUtil.fromString(String, TypeReference)"})
  void testFromStringWithStringValueTypeRef_givenArrayTypeIsArrayTypeReturnTrue() {
    // Arrange
    ArrayType arrayType = mock(ArrayType.class);
    when(arrayType.getValueHandler()).thenReturn("Value Handler");

    ArrayType arrayType2 = mock(ArrayType.class);
    when(arrayType2.isConcrete()).thenReturn(true);
    when(arrayType2.isRecordType()).thenReturn(true);
    when(arrayType2.isArrayType()).thenReturn(true);
    when(arrayType2.isEnumType()).thenReturn(true);
    when(arrayType2.getKeyType()).thenReturn(new PlaceholderForType(1));
    when(arrayType2.getContentType()).thenReturn(arrayType);
    when(arrayType2.isMapLikeType()).thenReturn(true);
    when(arrayType2.isAbstract()).thenReturn(true);
    when(arrayType2.isContainerType()).thenReturn(true);
    Class<Builder> forNameResult = Builder.class;
    Mockito.<Class<?>>when(arrayType2.getRawClass()).thenReturn(forNameResult);

    TypeReference<Object> valueTypeRef = mock(TypeReference.class);
    when(valueTypeRef.getType()).thenReturn(arrayType2);

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> JacksonUtil.fromString("\"", valueTypeRef));
    verify(valueTypeRef).getType();
    verify(arrayType2, atLeast(1)).getKeyType();
    verify(arrayType2, atLeast(1)).getRawClass();
    verify(arrayType, atLeast(1)).getValueHandler();
    verify(arrayType2).isEnumType();
    verify(arrayType2, atLeast(1)).isMapLikeType();
    verify(arrayType2, atLeast(1)).isRecordType();
    verify(arrayType2, atLeast(1)).getContentType();
    verify(arrayType2).isAbstract();
    verify(arrayType2, atLeast(1)).isArrayType();
    verify(arrayType2).isConcrete();
    verify(arrayType2, atLeast(1)).isContainerType();
  }

  /**
   * Test {@link JacksonUtil#fromString(String, TypeReference)} with {@code string}, {@code
   * valueTypeRef}.
   *
   * <ul>
   *   <li>Given {@link ArrayType} {@link ArrayType#isContainerType()} return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link JacksonUtil#fromString(String, TypeReference)}
   */
  @Test
  @DisplayName(
      "Test fromString(String, TypeReference) with 'string', 'valueTypeRef'; given ArrayType isContainerType() return 'false'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Object JacksonUtil.fromString(String, TypeReference)"})
  void testFromStringWithStringValueTypeRef_givenArrayTypeIsContainerTypeReturnFalse() {
    // Arrange
    ArrayType arrayType = mock(ArrayType.class);
    when(arrayType.getValueHandler()).thenReturn("Value Handler");

    ArrayType arrayType2 = mock(ArrayType.class);
    when(arrayType2.isEnumType()).thenReturn(true);
    when(arrayType2.getKeyType()).thenReturn(new PlaceholderForType(1));
    when(arrayType2.getContentType()).thenReturn(arrayType);
    when(arrayType2.isMapLikeType()).thenReturn(true);
    when(arrayType2.isAbstract()).thenReturn(true);
    when(arrayType2.isContainerType()).thenReturn(false);
    Class<Object> forNameResult = Object.class;
    Mockito.<Class<?>>when(arrayType2.getRawClass()).thenReturn(forNameResult);

    TypeReference<Object> valueTypeRef = mock(TypeReference.class);
    when(valueTypeRef.getType()).thenReturn(arrayType2);

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> JacksonUtil.fromString("\"", valueTypeRef));
    verify(valueTypeRef).getType();
    verify(arrayType2, atLeast(1)).getKeyType();
    verify(arrayType2, atLeast(1)).getRawClass();
    verify(arrayType).getValueHandler();
    verify(arrayType2).isEnumType();
    verify(arrayType2, atLeast(1)).isMapLikeType();
    verify(arrayType2, atLeast(1)).getContentType();
    verify(arrayType2).isAbstract();
    verify(arrayType2, atLeast(1)).isContainerType();
  }

  /**
   * Test {@link JacksonUtil#fromString(String, TypeReference)} with {@code string}, {@code
   * valueTypeRef}.
   *
   * <ul>
   *   <li>Given {@link IllegalArgumentException#IllegalArgumentException()}.
   * </ul>
   *
   * <p>Method under test: {@link JacksonUtil#fromString(String, TypeReference)}
   */
  @Test
  @DisplayName(
      "Test fromString(String, TypeReference) with 'string', 'valueTypeRef'; given IllegalArgumentException()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Object JacksonUtil.fromString(String, TypeReference)"})
  void testFromStringWithStringValueTypeRef_givenIllegalArgumentException() {
    // Arrange
    TypeReference<Object> valueTypeRef = mock(TypeReference.class);
    when(valueTypeRef.getType()).thenThrow(new IllegalArgumentException());

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class, () -> JacksonUtil.fromString("String", valueTypeRef));
    verify(valueTypeRef).getType();
  }

  /**
   * Test {@link JacksonUtil#fromString(String, TypeReference)} with {@code string}, {@code
   * valueTypeRef}.
   *
   * <ul>
   *   <li>Given {@link PlaceholderForType#PlaceholderForType(int)} with ordinal is one.
   * </ul>
   *
   * <p>Method under test: {@link JacksonUtil#fromString(String, TypeReference)}
   */
  @Test
  @DisplayName(
      "Test fromString(String, TypeReference) with 'string', 'valueTypeRef'; given PlaceholderForType(int) with ordinal is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Object JacksonUtil.fromString(String, TypeReference)"})
  void testFromStringWithStringValueTypeRef_givenPlaceholderForTypeWithOrdinalIsOne() {
    // Arrange
    TypeReference<Object> valueTypeRef = mock(TypeReference.class);
    when(valueTypeRef.getType()).thenReturn(new PlaceholderForType(1));

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class, () -> JacksonUtil.fromString("String", valueTypeRef));
    verify(valueTypeRef).getType();
  }

  /**
   * Test {@link JacksonUtil#fromString(String, TypeReference)} with {@code string}, {@code
   * valueTypeRef}.
   *
   * <ul>
   *   <li>Given {@link PlaceholderForType#PlaceholderForType(int)} with ordinal is one.
   * </ul>
   *
   * <p>Method under test: {@link JacksonUtil#fromString(String, TypeReference)}
   */
  @Test
  @DisplayName(
      "Test fromString(String, TypeReference) with 'string', 'valueTypeRef'; given PlaceholderForType(int) with ordinal is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
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
   * Test {@link JacksonUtil#fromString(String, TypeReference)} with {@code string}, {@code
   * valueTypeRef}.
   *
   * <ul>
   *   <li>When {@code 42}.
   *   <li>Then return intValue is forty-two.
   * </ul>
   *
   * <p>Method under test: {@link JacksonUtil#fromString(String, TypeReference)}
   */
  @Test
  @DisplayName(
      "Test fromString(String, TypeReference) with 'string', 'valueTypeRef'; when '42'; then return intValue is forty-two")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
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
   * Test {@link JacksonUtil#fromString(String, TypeReference)} with {@code string}, {@code
   * valueTypeRef}.
   *
   * <ul>
   *   <li>When empty string.
   * </ul>
   *
   * <p>Method under test: {@link JacksonUtil#fromString(String, TypeReference)}
   */
  @Test
  @DisplayName(
      "Test fromString(String, TypeReference) with 'string', 'valueTypeRef'; when empty string")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
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
   * Test {@link JacksonUtil#fromString(String, TypeReference)} with {@code string}, {@code
   * valueTypeRef}.
   *
   * <ul>
   *   <li>When empty string.
   * </ul>
   *
   * <p>Method under test: {@link JacksonUtil#fromString(String, TypeReference)}
   */
  @Test
  @DisplayName(
      "Test fromString(String, TypeReference) with 'string', 'valueTypeRef'; when empty string")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Object JacksonUtil.fromString(String, TypeReference)"})
  void testFromStringWithStringValueTypeRef_whenEmptyString2() {
    // Arrange
    ArrayType arrayType = mock(ArrayType.class);
    Class<Object> forNameResult = Object.class;
    Mockito.<Class<?>>when(arrayType.getRawClass()).thenReturn(forNameResult);

    TypeReference<Object> valueTypeRef = mock(TypeReference.class);
    when(valueTypeRef.getType()).thenReturn(arrayType);

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> JacksonUtil.fromString("", valueTypeRef));
    verify(valueTypeRef).getType();
    verify(arrayType).getRawClass();
  }

  /**
   * Test {@link JacksonUtil#fromString(String, TypeReference)} with {@code string}, {@code
   * valueTypeRef}.
   *
   * <ul>
   *   <li>When {@code null}.
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link JacksonUtil#fromString(String, TypeReference)}
   */
  @Test
  @DisplayName(
      "Test fromString(String, TypeReference) with 'string', 'valueTypeRef'; when 'null'; then return 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Object JacksonUtil.fromString(String, TypeReference)"})
  void testFromStringWithStringValueTypeRef_whenNull_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull(JacksonUtil.fromString(null, mock(TypeReference.class)));
  }

  /**
   * Test {@link JacksonUtil#fromBytes(byte[], Class)} with {@code bytes}, {@code clazz}.
   *
   * <ul>
   *   <li>When array of {@code byte} with {@code A} and minus one.
   * </ul>
   *
   * <p>Method under test: {@link JacksonUtil#fromBytes(byte[], Class)}
   */
  @Test
  @DisplayName(
      "Test fromBytes(byte[], Class) with 'bytes', 'clazz'; when array of byte with 'A' and minus one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Object JacksonUtil.fromBytes(byte[], Class)"})
  void testFromBytesWithBytesClazz_whenArrayOfByteWithAAndMinusOne() {
    // Arrange
    Class<Object> clazz = Object.class;

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () -> JacksonUtil.fromBytes(new byte[] {'A', -1, 'A', 'X', 'A', 'X', 'A', 'X'}, clazz));
  }

  /**
   * Test {@link JacksonUtil#fromBytes(byte[], Class)} with {@code bytes}, {@code clazz}.
   *
   * <ul>
   *   <li>When array of {@code byte} with {@code A} and zero.
   * </ul>
   *
   * <p>Method under test: {@link JacksonUtil#fromBytes(byte[], Class)}
   */
  @Test
  @DisplayName(
      "Test fromBytes(byte[], Class) with 'bytes', 'clazz'; when array of byte with 'A' and zero")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Object JacksonUtil.fromBytes(byte[], Class)"})
  void testFromBytesWithBytesClazz_whenArrayOfByteWithAAndZero() {
    // Arrange
    Class<Object> clazz = Object.class;

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () -> JacksonUtil.fromBytes(new byte[] {'A', 0, 'A', 'X', 'A', 'X', 'A', 'X'}, clazz));
  }

  /**
   * Test {@link JacksonUtil#fromBytes(byte[], Class)} with {@code bytes}, {@code clazz}.
   *
   * <ul>
   *   <li>When array of {@code byte} with {@link Byte#MAX_VALUE} and {@code X}.
   * </ul>
   *
   * <p>Method under test: {@link JacksonUtil#fromBytes(byte[], Class)}
   */
  @Test
  @DisplayName(
      "Test fromBytes(byte[], Class) with 'bytes', 'clazz'; when array of byte with MAX_VALUE and 'X'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Object JacksonUtil.fromBytes(byte[], Class)"})
  void testFromBytesWithBytesClazz_whenArrayOfByteWithMax_valueAndX() {
    // Arrange
    Class<Object> clazz = Object.class;

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () ->
            JacksonUtil.fromBytes(
                new byte[] {Byte.MAX_VALUE, 'X', 'A', 'X', 'A', 'X', 'A', 'X'}, clazz));
  }

  /**
   * Test {@link JacksonUtil#fromBytes(byte[], Class)} with {@code bytes}, {@code clazz}.
   *
   * <ul>
   *   <li>When array of {@code byte} with zero and {@code X}.
   * </ul>
   *
   * <p>Method under test: {@link JacksonUtil#fromBytes(byte[], Class)}
   */
  @Test
  @DisplayName(
      "Test fromBytes(byte[], Class) with 'bytes', 'clazz'; when array of byte with zero and 'X'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Object JacksonUtil.fromBytes(byte[], Class)"})
  void testFromBytesWithBytesClazz_whenArrayOfByteWithZeroAndX() {
    // Arrange
    Class<Object> clazz = Object.class;

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () -> JacksonUtil.fromBytes(new byte[] {0, 'X', 'A', 'X', 'A', 'X', 'A', 'X'}, clazz));
  }

  /**
   * Test {@link JacksonUtil#fromBytes(byte[], Class)} with {@code bytes}, {@code clazz}.
   *
   * <ul>
   *   <li>When array of {@code byte} with zero and zero.
   * </ul>
   *
   * <p>Method under test: {@link JacksonUtil#fromBytes(byte[], Class)}
   */
  @Test
  @DisplayName(
      "Test fromBytes(byte[], Class) with 'bytes', 'clazz'; when array of byte with zero and zero")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Object JacksonUtil.fromBytes(byte[], Class)"})
  void testFromBytesWithBytesClazz_whenArrayOfByteWithZeroAndZero() {
    // Arrange
    Class<Object> clazz = Object.class;

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () -> JacksonUtil.fromBytes(new byte[] {0, 0, 'A', 'X', 'A', 'X', 'A', 'X'}, clazz));
  }

  /**
   * Test {@link JacksonUtil#fromBytes(byte[], Class)} with {@code bytes}, {@code clazz}.
   *
   * <ul>
   *   <li>When array of {@code byte} with zero and zero.
   * </ul>
   *
   * <p>Method under test: {@link JacksonUtil#fromBytes(byte[], Class)}
   */
  @Test
  @DisplayName(
      "Test fromBytes(byte[], Class) with 'bytes', 'clazz'; when array of byte with zero and zero")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Object JacksonUtil.fromBytes(byte[], Class)"})
  void testFromBytesWithBytesClazz_whenArrayOfByteWithZeroAndZero2() {
    // Arrange
    Class<Object> clazz = Object.class;

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () -> JacksonUtil.fromBytes(new byte[] {0, 0, 'A', 0, 'A', 'X', 'A', 'X'}, clazz));
  }

  /**
   * Test {@link JacksonUtil#fromBytes(byte[], Class)} with {@code bytes}, {@code clazz}.
   *
   * <ul>
   *   <li>When {@code AXAXAXAX} Bytes is {@code UTF-8}.
   * </ul>
   *
   * <p>Method under test: {@link JacksonUtil#fromBytes(byte[], Class)}
   */
  @Test
  @DisplayName(
      "Test fromBytes(byte[], Class) with 'bytes', 'clazz'; when 'AXAXAXAX' Bytes is 'UTF-8'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
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
   *
   * <ul>
   *   <li>When {@code JsonMapper$Builder}.
   * </ul>
   *
   * <p>Method under test: {@link JacksonUtil#fromBytes(byte[], Class)}
   */
  @Test
  @DisplayName(
      "Test fromBytes(byte[], Class) with 'bytes', 'clazz'; when 'com.fasterxml.jackson.databind.json.JsonMapper$Builder'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
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
   *
   * <ul>
   *   <li>When empty array of {@code byte}.
   * </ul>
   *
   * <p>Method under test: {@link JacksonUtil#fromBytes(byte[], Class)}
   */
  @Test
  @DisplayName("Test fromBytes(byte[], Class) with 'bytes', 'clazz'; when empty array of byte")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Object JacksonUtil.fromBytes(byte[], Class)"})
  void testFromBytesWithBytesClazz_whenEmptyArrayOfByte() {
    // Arrange
    Class<Object> clazz = Object.class;

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> JacksonUtil.fromBytes(new byte[] {}, clazz));
  }

  /**
   * Test {@link JacksonUtil#fromBytes(byte[], Class)} with {@code bytes}, {@code clazz}.
   *
   * <ul>
   *   <li>When {@code String}.
   *   <li>Then throw {@link IllegalArgumentException}.
   * </ul>
   *
   * <p>Method under test: {@link JacksonUtil#fromBytes(byte[], Class)}
   */
  @Test
  @DisplayName(
      "Test fromBytes(byte[], Class) with 'bytes', 'clazz'; when 'java.lang.String'; then throw IllegalArgumentException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
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
   *
   * <ul>
   *   <li>When {@code null}.
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link JacksonUtil#fromBytes(byte[], Class)}
   */
  @Test
  @DisplayName(
      "Test fromBytes(byte[], Class) with 'bytes', 'clazz'; when 'null'; then return 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Object JacksonUtil.fromBytes(byte[], Class)"})
  void testFromBytesWithBytesClazz_whenNull_thenReturnNull() {
    // Arrange
    Class<Object> clazz = Object.class;

    // Act and Assert
    assertNull(JacksonUtil.fromBytes(null, clazz));
  }

  /**
   * Test {@link JacksonUtil#fromBytes(byte[], TypeReference)} with {@code bytes}, {@code
   * valueTypeRef}.
   *
   * <p>Method under test: {@link JacksonUtil#fromBytes(byte[], TypeReference)}
   */
  @Test
  @DisplayName("Test fromBytes(byte[], TypeReference) with 'bytes', 'valueTypeRef'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Object JacksonUtil.fromBytes(byte[], TypeReference)"})
  void testFromBytesWithBytesValueTypeRef() {
    // Arrange
    ArrayType arrayType = mock(ArrayType.class);
    Mockito.<Class<?>>when(arrayType.getRawClass()).thenThrow(new IllegalArgumentException());

    TypeReference<Object> valueTypeRef = mock(TypeReference.class);
    when(valueTypeRef.getType()).thenReturn(arrayType);

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class, () -> JacksonUtil.fromBytes(new byte[] {}, valueTypeRef));
    verify(valueTypeRef).getType();
    verify(arrayType).getRawClass();
  }

  /**
   * Test {@link JacksonUtil#fromBytes(byte[], TypeReference)} with {@code bytes}, {@code
   * valueTypeRef}.
   *
   * <ul>
   *   <li>Given {@link IllegalArgumentException#IllegalArgumentException()}.
   * </ul>
   *
   * <p>Method under test: {@link JacksonUtil#fromBytes(byte[], TypeReference)}
   */
  @Test
  @DisplayName(
      "Test fromBytes(byte[], TypeReference) with 'bytes', 'valueTypeRef'; given IllegalArgumentException()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Object JacksonUtil.fromBytes(byte[], TypeReference)"})
  void testFromBytesWithBytesValueTypeRef_givenIllegalArgumentException()
      throws UnsupportedEncodingException {
    // Arrange
    byte[] bytes = "AXAXAXAX".getBytes("UTF-8");

    TypeReference<Object> valueTypeRef = mock(TypeReference.class);
    when(valueTypeRef.getType()).thenThrow(new IllegalArgumentException());

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> JacksonUtil.fromBytes(bytes, valueTypeRef));
    verify(valueTypeRef).getType();
  }

  /**
   * Test {@link JacksonUtil#fromBytes(byte[], TypeReference)} with {@code bytes}, {@code
   * valueTypeRef}.
   *
   * <ul>
   *   <li>Given {@code Object}.
   *   <li>Then calls {@link ArrayType#getRawClass()}.
   * </ul>
   *
   * <p>Method under test: {@link JacksonUtil#fromBytes(byte[], TypeReference)}
   */
  @Test
  @DisplayName(
      "Test fromBytes(byte[], TypeReference) with 'bytes', 'valueTypeRef'; given 'java.lang.Object'; then calls getRawClass()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Object JacksonUtil.fromBytes(byte[], TypeReference)"})
  void testFromBytesWithBytesValueTypeRef_givenJavaLangObject_thenCallsGetRawClass() {
    // Arrange
    ArrayType arrayType = mock(ArrayType.class);
    Class<Object> forNameResult = Object.class;
    Mockito.<Class<?>>when(arrayType.getRawClass()).thenReturn(forNameResult);

    TypeReference<Object> valueTypeRef = mock(TypeReference.class);
    when(valueTypeRef.getType()).thenReturn(arrayType);

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class, () -> JacksonUtil.fromBytes(new byte[] {}, valueTypeRef));
    verify(valueTypeRef).getType();
    verify(arrayType).getRawClass();
  }

  /**
   * Test {@link JacksonUtil#fromBytes(byte[], TypeReference)} with {@code bytes}, {@code
   * valueTypeRef}.
   *
   * <ul>
   *   <li>When array of {@code byte} with {@code A} and minus one.
   * </ul>
   *
   * <p>Method under test: {@link JacksonUtil#fromBytes(byte[], TypeReference)}
   */
  @Test
  @DisplayName(
      "Test fromBytes(byte[], TypeReference) with 'bytes', 'valueTypeRef'; when array of byte with 'A' and minus one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Object JacksonUtil.fromBytes(byte[], TypeReference)"})
  void testFromBytesWithBytesValueTypeRef_whenArrayOfByteWithAAndMinusOne() {
    // Arrange
    TypeReference<Object> valueTypeRef = mock(TypeReference.class);
    when(valueTypeRef.getType()).thenReturn(new PlaceholderForType(1));

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () ->
            JacksonUtil.fromBytes(
                new byte[] {'A', -1, 'A', 'X', 'A', 'X', 'A', 'X'}, valueTypeRef));
    verify(valueTypeRef).getType();
  }

  /**
   * Test {@link JacksonUtil#fromBytes(byte[], TypeReference)} with {@code bytes}, {@code
   * valueTypeRef}.
   *
   * <ul>
   *   <li>When array of {@code byte} with {@code A} and zero.
   * </ul>
   *
   * <p>Method under test: {@link JacksonUtil#fromBytes(byte[], TypeReference)}
   */
  @Test
  @DisplayName(
      "Test fromBytes(byte[], TypeReference) with 'bytes', 'valueTypeRef'; when array of byte with 'A' and zero")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Object JacksonUtil.fromBytes(byte[], TypeReference)"})
  void testFromBytesWithBytesValueTypeRef_whenArrayOfByteWithAAndZero() {
    // Arrange
    TypeReference<Object> valueTypeRef = mock(TypeReference.class);
    when(valueTypeRef.getType()).thenThrow(new IllegalArgumentException());

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () ->
            JacksonUtil.fromBytes(new byte[] {'A', 0, 'A', 'X', 'A', 'X', 'A', 'X'}, valueTypeRef));
    verify(valueTypeRef).getType();
  }

  /**
   * Test {@link JacksonUtil#fromBytes(byte[], TypeReference)} with {@code bytes}, {@code
   * valueTypeRef}.
   *
   * <ul>
   *   <li>When array of {@code byte} with {@link Byte#MAX_VALUE} and {@code X}.
   * </ul>
   *
   * <p>Method under test: {@link JacksonUtil#fromBytes(byte[], TypeReference)}
   */
  @Test
  @DisplayName(
      "Test fromBytes(byte[], TypeReference) with 'bytes', 'valueTypeRef'; when array of byte with MAX_VALUE and 'X'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Object JacksonUtil.fromBytes(byte[], TypeReference)"})
  void testFromBytesWithBytesValueTypeRef_whenArrayOfByteWithMax_valueAndX() {
    // Arrange
    TypeReference<Object> valueTypeRef = mock(TypeReference.class);
    when(valueTypeRef.getType()).thenReturn(new PlaceholderForType(1));

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () ->
            JacksonUtil.fromBytes(
                new byte[] {Byte.MAX_VALUE, 'X', 'A', 'X', 'A', 'X', 'A', 'X'}, valueTypeRef));
    verify(valueTypeRef).getType();
  }

  /**
   * Test {@link JacksonUtil#fromBytes(byte[], TypeReference)} with {@code bytes}, {@code
   * valueTypeRef}.
   *
   * <ul>
   *   <li>When array of {@code byte} with zero and {@code X}.
   * </ul>
   *
   * <p>Method under test: {@link JacksonUtil#fromBytes(byte[], TypeReference)}
   */
  @Test
  @DisplayName(
      "Test fromBytes(byte[], TypeReference) with 'bytes', 'valueTypeRef'; when array of byte with zero and 'X'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Object JacksonUtil.fromBytes(byte[], TypeReference)"})
  void testFromBytesWithBytesValueTypeRef_whenArrayOfByteWithZeroAndX() {
    // Arrange
    TypeReference<Object> valueTypeRef = mock(TypeReference.class);
    when(valueTypeRef.getType()).thenReturn(new PlaceholderForType(1));

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () ->
            JacksonUtil.fromBytes(new byte[] {0, 'X', 'A', 'X', 'A', 'X', 'A', 'X'}, valueTypeRef));
    verify(valueTypeRef).getType();
  }

  /**
   * Test {@link JacksonUtil#fromBytes(byte[], TypeReference)} with {@code bytes}, {@code
   * valueTypeRef}.
   *
   * <ul>
   *   <li>When {@code AXAXAXAX} Bytes is {@code UTF-8}.
   * </ul>
   *
   * <p>Method under test: {@link JacksonUtil#fromBytes(byte[], TypeReference)}
   */
  @Test
  @DisplayName(
      "Test fromBytes(byte[], TypeReference) with 'bytes', 'valueTypeRef'; when 'AXAXAXAX' Bytes is 'UTF-8'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Object JacksonUtil.fromBytes(byte[], TypeReference)"})
  void testFromBytesWithBytesValueTypeRef_whenAxaxaxaxBytesIsUtf8()
      throws UnsupportedEncodingException {
    // Arrange
    byte[] bytes = "AXAXAXAX".getBytes("UTF-8");

    TypeReference<Object> valueTypeRef = mock(TypeReference.class);
    when(valueTypeRef.getType()).thenReturn(new PlaceholderForType(1));

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> JacksonUtil.fromBytes(bytes, valueTypeRef));
    verify(valueTypeRef).getType();
  }

  /**
   * Test {@link JacksonUtil#fromBytes(byte[], TypeReference)} with {@code bytes}, {@code
   * valueTypeRef}.
   *
   * <ul>
   *   <li>When empty array of {@code byte}.
   * </ul>
   *
   * <p>Method under test: {@link JacksonUtil#fromBytes(byte[], TypeReference)}
   */
  @Test
  @DisplayName(
      "Test fromBytes(byte[], TypeReference) with 'bytes', 'valueTypeRef'; when empty array of byte")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Object JacksonUtil.fromBytes(byte[], TypeReference)"})
  void testFromBytesWithBytesValueTypeRef_whenEmptyArrayOfByte() {
    // Arrange
    TypeReference<Object> valueTypeRef = mock(TypeReference.class);
    when(valueTypeRef.getType()).thenReturn(new PlaceholderForType(1));

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class, () -> JacksonUtil.fromBytes(new byte[] {}, valueTypeRef));
    verify(valueTypeRef).getType();
  }

  /**
   * Test {@link JacksonUtil#fromBytes(byte[], TypeReference)} with {@code bytes}, {@code
   * valueTypeRef}.
   *
   * <ul>
   *   <li>When {@code null}.
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link JacksonUtil#fromBytes(byte[], TypeReference)}
   */
  @Test
  @DisplayName(
      "Test fromBytes(byte[], TypeReference) with 'bytes', 'valueTypeRef'; when 'null'; then return 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Object JacksonUtil.fromBytes(byte[], TypeReference)"})
  void testFromBytesWithBytesValueTypeRef_whenNull_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull(JacksonUtil.fromBytes(null, mock(TypeReference.class)));
  }

  /**
   * Test {@link JacksonUtil#fromBytes(byte[])} with {@code bytes}.
   *
   * <ul>
   *   <li>When array of {@code byte} with {@code A} and minus one.
   * </ul>
   *
   * <p>Method under test: {@link JacksonUtil#fromBytes(byte[])}
   */
  @Test
  @DisplayName("Test fromBytes(byte[]) with 'bytes'; when array of byte with 'A' and minus one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"JsonNode JacksonUtil.fromBytes(byte[])"})
  void testFromBytesWithBytes_whenArrayOfByteWithAAndMinusOne() {
    // Arrange, Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () -> JacksonUtil.fromBytes(new byte[] {'A', -1, 'A', 'X', 'A', 'X', 'A', 'X'}));
  }

  /**
   * Test {@link JacksonUtil#fromBytes(byte[])} with {@code bytes}.
   *
   * <ul>
   *   <li>When array of {@code byte} with {@link Byte#MAX_VALUE} and {@code X}.
   * </ul>
   *
   * <p>Method under test: {@link JacksonUtil#fromBytes(byte[])}
   */
  @Test
  @DisplayName("Test fromBytes(byte[]) with 'bytes'; when array of byte with MAX_VALUE and 'X'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"JsonNode JacksonUtil.fromBytes(byte[])"})
  void testFromBytesWithBytes_whenArrayOfByteWithMax_valueAndX() {
    // Arrange, Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () ->
            JacksonUtil.fromBytes(new byte[] {Byte.MAX_VALUE, 'X', 'A', 'X', 'A', 'X', 'A', 'X'}));
  }

  /**
   * Test {@link JacksonUtil#fromBytes(byte[])} with {@code bytes}.
   *
   * <ul>
   *   <li>When array of {@code byte} with zero and {@code X}.
   * </ul>
   *
   * <p>Method under test: {@link JacksonUtil#fromBytes(byte[])}
   */
  @Test
  @DisplayName("Test fromBytes(byte[]) with 'bytes'; when array of byte with zero and 'X'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"JsonNode JacksonUtil.fromBytes(byte[])"})
  void testFromBytesWithBytes_whenArrayOfByteWithZeroAndX() {
    // Arrange, Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () -> JacksonUtil.fromBytes(new byte[] {0, 'X', 'A', 'X', 'A', 'X', 'A', 'X'}));
  }

  /**
   * Test {@link JacksonUtil#fromBytes(byte[])} with {@code bytes}.
   *
   * <ul>
   *   <li>When array of {@code byte} with zero and zero.
   * </ul>
   *
   * <p>Method under test: {@link JacksonUtil#fromBytes(byte[])}
   */
  @Test
  @DisplayName("Test fromBytes(byte[]) with 'bytes'; when array of byte with zero and zero")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"JsonNode JacksonUtil.fromBytes(byte[])"})
  void testFromBytesWithBytes_whenArrayOfByteWithZeroAndZero() {
    // Arrange, Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () -> JacksonUtil.fromBytes(new byte[] {0, 0, 'A', 'X', 'A', 'X', 'A', 'X'}));
  }

  /**
   * Test {@link JacksonUtil#fromBytes(byte[])} with {@code bytes}.
   *
   * <ul>
   *   <li>When array of {@code byte} with zero and zero.
   * </ul>
   *
   * <p>Method under test: {@link JacksonUtil#fromBytes(byte[])}
   */
  @Test
  @DisplayName("Test fromBytes(byte[]) with 'bytes'; when array of byte with zero and zero")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"JsonNode JacksonUtil.fromBytes(byte[])"})
  void testFromBytesWithBytes_whenArrayOfByteWithZeroAndZero2() {
    // Arrange, Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () -> JacksonUtil.fromBytes(new byte[] {0, 0, 0, 'X', 'A', 'X', 'A', 'X'}));
  }

  /**
   * Test {@link JacksonUtil#fromBytes(byte[])} with {@code bytes}.
   *
   * <ul>
   *   <li>When array of {@code byte} with zero and zero.
   * </ul>
   *
   * <p>Method under test: {@link JacksonUtil#fromBytes(byte[])}
   */
  @Test
  @DisplayName("Test fromBytes(byte[]) with 'bytes'; when array of byte with zero and zero")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"JsonNode JacksonUtil.fromBytes(byte[])"})
  void testFromBytesWithBytes_whenArrayOfByteWithZeroAndZero3() {
    // Arrange, Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () -> JacksonUtil.fromBytes(new byte[] {0, 0, 'A', 0, 'A', 'X', 'A', 'X'}));
  }

  /**
   * Test {@link JacksonUtil#fromBytes(byte[])} with {@code bytes}.
   *
   * <ul>
   *   <li>When {@code AXAXAXAX} Bytes is {@code UTF-8}.
   *   <li>Then throw {@link IllegalArgumentException}.
   * </ul>
   *
   * <p>Method under test: {@link JacksonUtil#fromBytes(byte[])}
   */
  @Test
  @DisplayName(
      "Test fromBytes(byte[]) with 'bytes'; when 'AXAXAXAX' Bytes is 'UTF-8'; then throw IllegalArgumentException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"JsonNode JacksonUtil.fromBytes(byte[])"})
  void testFromBytesWithBytes_whenAxaxaxaxBytesIsUtf8_thenThrowIllegalArgumentException()
      throws UnsupportedEncodingException {
    // Arrange, Act and Assert
    assertThrows(
        IllegalArgumentException.class, () -> JacksonUtil.fromBytes("AXAXAXAX".getBytes("UTF-8")));
  }

  /**
   * Test {@link JacksonUtil#fromBytes(byte[])} with {@code bytes}.
   *
   * <ul>
   *   <li>When empty array of {@code byte}.
   *   <li>Then return {@link MissingNode}.
   * </ul>
   *
   * <p>Method under test: {@link JacksonUtil#fromBytes(byte[])}
   */
  @Test
  @DisplayName(
      "Test fromBytes(byte[]) with 'bytes'; when empty array of byte; then return MissingNode")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"JsonNode JacksonUtil.fromBytes(byte[])"})
  void testFromBytesWithBytes_whenEmptyArrayOfByte_thenReturnMissingNode() {
    // Arrange and Act
    JsonNode actualFromBytesResult = JacksonUtil.fromBytes(new byte[] {});

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
   *
   * <p>Method under test: {@link JacksonUtil#toString(Object)}
   */
  @Test
  @DisplayName("Test toString(Object) with 'Object'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String JacksonUtil.toString(Object)"})
  void testToStringWithObject() {
    // Arrange, Act and Assert
    assertEquals("\"\\\"\"", JacksonUtil.toString("\""));
  }

  /**
   * Test {@link JacksonUtil#toString(Object)} with {@code Object}.
   *
   * <ul>
   *   <li>When {@code 42}.
   *   <li>Then return {@code "42"}.
   * </ul>
   *
   * <p>Method under test: {@link JacksonUtil#toString(Object)}
   */
  @Test
  @DisplayName("Test toString(Object) with 'Object'; when '42'; then return '\"42\"'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String JacksonUtil.toString(Object)"})
  void testToStringWithObject_when42_thenReturn42() {
    // Arrange, Act and Assert
    assertEquals("\"42\"", JacksonUtil.toString("42"));
  }

  /**
   * Test {@link JacksonUtil#toString(Object)} with {@code Object}.
   *
   * <ul>
   *   <li>When forty-two.
   *   <li>Then return {@code 42}.
   * </ul>
   *
   * <p>Method under test: {@link JacksonUtil#toString(Object)}
   */
  @Test
  @DisplayName("Test toString(Object) with 'Object'; when forty-two; then return '42'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String JacksonUtil.toString(Object)"})
  void testToStringWithObject_whenFortyTwo_thenReturn42() {
    // Arrange, Act and Assert
    assertEquals("42", JacksonUtil.toString(42));
  }

  /**
   * Test {@link JacksonUtil#toString(Object)} with {@code Object}.
   *
   * <ul>
   *   <li>When {@code null}.
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link JacksonUtil#toString(Object)}
   */
  @Test
  @DisplayName("Test toString(Object) with 'Object'; when 'null'; then return 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String JacksonUtil.toString(Object)"})
  void testToStringWithObject_whenNull_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull(JacksonUtil.toString(null));
  }

  /**
   * Test {@link JacksonUtil#writeValueAsString(Object)}.
   *
   * <p>Method under test: {@link JacksonUtil#writeValueAsString(Object)}
   */
  @Test
  @DisplayName("Test writeValueAsString(Object)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String JacksonUtil.writeValueAsString(Object)"})
  void testWriteValueAsString() {
    // Arrange, Act and Assert
    assertEquals(
        "{\"id\":null,\"createdTime\":0,\"tenantId\":null,\"key\":null,\"jsonValue\":null}",
        JacksonUtil.writeValueAsString(new AdminSettings()));
  }

  /**
   * Test {@link JacksonUtil#writeValueAsString(Object)}.
   *
   * <p>Method under test: {@link JacksonUtil#writeValueAsString(Object)}
   */
  @Test
  @DisplayName("Test writeValueAsString(Object)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String JacksonUtil.writeValueAsString(Object)"})
  void testWriteValueAsString2() {
    // Arrange
    BaseDataWithAdditionalInfo<UUIDBased> baseDataWithAdditionalInfo =
        mock(BaseDataWithAdditionalInfo.class);
    when(baseDataWithAdditionalInfo.getCreatedTime()).thenReturn(1L);
    when(baseDataWithAdditionalInfo.getId())
        .thenReturn(new AlarmId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")));

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () -> JacksonUtil.writeValueAsString(baseDataWithAdditionalInfo));
    verify(baseDataWithAdditionalInfo).getCreatedTime();
    verify(baseDataWithAdditionalInfo).getId();
  }

  /**
   * Test {@link JacksonUtil#writeValueAsString(Object)}.
   *
   * <p>Method under test: {@link JacksonUtil#writeValueAsString(Object)}
   */
  @Test
  @DisplayName("Test writeValueAsString(Object)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String JacksonUtil.writeValueAsString(Object)"})
  void testWriteValueAsString3() {
    // Arrange
    BaseDataWithAdditionalInfo<UUIDBased> baseDataWithAdditionalInfo =
        mock(BaseDataWithAdditionalInfo.class);
    when(baseDataWithAdditionalInfo.getCreatedTime()).thenReturn(1L);
    when(baseDataWithAdditionalInfo.getId())
        .thenReturn(new CustomerId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")));

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () -> JacksonUtil.writeValueAsString(baseDataWithAdditionalInfo));
    verify(baseDataWithAdditionalInfo).getCreatedTime();
    verify(baseDataWithAdditionalInfo).getId();
  }

  /**
   * Test {@link JacksonUtil#writeValueAsString(Object)}.
   *
   * <p>Method under test: {@link JacksonUtil#writeValueAsString(Object)}
   */
  @Test
  @DisplayName("Test writeValueAsString(Object)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String JacksonUtil.writeValueAsString(Object)"})
  void testWriteValueAsString4() {
    // Arrange
    AlarmConditionFilter alarmConditionFilter = new AlarmConditionFilter();
    alarmConditionFilter.setKey(
        new AlarmConditionFilterKey(AlarmConditionKeyType.ATTRIBUTE, "Key"));
    alarmConditionFilter.setPredicate(mock(KeyFilterPredicate.class));
    alarmConditionFilter.setValue("Value");
    alarmConditionFilter.setValueType(EntityKeyValueType.STRING);

    ArrayList<AlarmConditionFilter> condition = new ArrayList<>();
    condition.add(alarmConditionFilter);

    AlarmCondition alarmCondition = new AlarmCondition();
    alarmCondition.setCondition(condition);
    alarmCondition.setSpec(mock(AlarmConditionSpec.class));

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class, () -> JacksonUtil.writeValueAsString(alarmCondition));
  }

  /**
   * Test {@link JacksonUtil#writeValueAsString(Object)}.
   *
   * <p>Method under test: {@link JacksonUtil#writeValueAsString(Object)}
   */
  @Test
  @DisplayName("Test writeValueAsString(Object)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String JacksonUtil.writeValueAsString(Object)"})
  void testWriteValueAsString5() {
    // Arrange, Act and Assert
    assertEquals("\"\\\"\"", JacksonUtil.writeValueAsString("\""));
  }

  /**
   * Test {@link JacksonUtil#writeValueAsString(Object)}.
   *
   * <p>Method under test: {@link JacksonUtil#writeValueAsString(Object)}
   */
  @Test
  @DisplayName("Test writeValueAsString(Object)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String JacksonUtil.writeValueAsString(Object)"})
  void testWriteValueAsString6() {
    // Arrange
    AlarmId id = new AlarmId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    // Act and Assert
    assertEquals(
        "{\"id\":{\"entityType\":\"ALARM\",\"id\":\"784f394c-42b6-435a-983c-b7beff2784f9\"},\"name\":\"42\"}",
        JacksonUtil.writeValueAsString(new EntityInfo(id, "42")));
  }

  /**
   * Test {@link JacksonUtil#writeValueAsString(Object)}.
   *
   * <p>Method under test: {@link JacksonUtil#writeValueAsString(Object)}
   */
  @Test
  @DisplayName("Test writeValueAsString(Object)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String JacksonUtil.writeValueAsString(Object)"})
  void testWriteValueAsString7() {
    // Arrange
    DeviceId id = new DeviceId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    // Act and Assert
    assertEquals(
        "{\"id\":{\"entityType\":\"DEVICE\",\"id\":\"784f394c-42b6-435a-983c-b7beff2784f9\"},\"name\":\"42\"}",
        JacksonUtil.writeValueAsString(new EntityInfo(id, "42")));
  }

  /**
   * Test {@link JacksonUtil#writeValueAsString(Object)}.
   *
   * <p>Method under test: {@link JacksonUtil#writeValueAsString(Object)}
   */
  @Test
  @DisplayName("Test writeValueAsString(Object)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String JacksonUtil.writeValueAsString(Object)"})
  void testWriteValueAsString8() {
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
   *
   * <p>Method under test: {@link JacksonUtil#writeValueAsString(Object)}
   */
  @Test
  @DisplayName("Test writeValueAsString(Object)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String JacksonUtil.writeValueAsString(Object)"})
  void testWriteValueAsString9() {
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
   *
   * <p>Method under test: {@link JacksonUtil#writeValueAsString(Object)}
   */
  @Test
  @DisplayName("Test writeValueAsString(Object)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String JacksonUtil.writeValueAsString(Object)"})
  void testWriteValueAsString10() {
    // Arrange
    Dashboard dashboard = new Dashboard();
    dashboard.setConfiguration(MissingNode.getInstance());

    // Act and Assert
    assertEquals(
        "{\"id\":null,\"createdTime\":0,\"tenantId\":null,\"title\":null,\"image\":null,\"assignedCustomers\":null,\"mobileHide"
            + "\":false,\"mobileOrder\":null,\"version\":null,\"externalId\":null,\"hideDashboardToolbar\":false,\"configuration"
            + "\":null,\"name\":null}",
        JacksonUtil.writeValueAsString(new HomeDashboard(dashboard, false)));
  }

  /**
   * Test {@link JacksonUtil#writeValueAsString(Object)}.
   *
   * <p>Method under test: {@link JacksonUtil#writeValueAsString(Object)}
   */
  @Test
  @DisplayName("Test writeValueAsString(Object)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String JacksonUtil.writeValueAsString(Object)"})
  void testWriteValueAsString11() {
    // Arrange
    Dashboard dashboard = new Dashboard();
    dashboard.setConfiguration(NullNode.getInstance());

    // Act and Assert
    assertEquals(
        "{\"id\":null,\"createdTime\":0,\"tenantId\":null,\"title\":null,\"image\":null,\"assignedCustomers\":null,\"mobileHide"
            + "\":false,\"mobileOrder\":null,\"version\":null,\"externalId\":null,\"hideDashboardToolbar\":false,\"configuration"
            + "\":null,\"name\":null}",
        JacksonUtil.writeValueAsString(new HomeDashboard(dashboard, false)));
  }

  /**
   * Test {@link JacksonUtil#writeValueAsString(Object)}.
   *
   * <p>Method under test: {@link JacksonUtil#writeValueAsString(Object)}
   */
  @Test
  @DisplayName("Test writeValueAsString(Object)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String JacksonUtil.writeValueAsString(Object)"})
  void testWriteValueAsString12() {
    // Arrange
    HashSet<ShortCustomerInfo> assignedCustomers = new HashSet<>();
    CustomerId customerId = new CustomerId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    ShortCustomerInfo shortCustomerInfo = new ShortCustomerInfo(customerId, "Dr", true);
    assignedCustomers.add(shortCustomerInfo);

    Dashboard dashboard = new Dashboard();
    dashboard.setAssignedCustomers(assignedCustomers);
    dashboard.setConfiguration(MissingNode.getInstance());

    // Act and Assert
    assertEquals(
        "{\"id\":null,\"createdTime\":0,\"tenantId\":null,\"title\":null,\"image\":null,\"assignedCustomers\":[{\"customerId"
            + "\":{\"entityType\":\"CUSTOMER\",\"id\":\"784f394c-42b6-435a-983c-b7beff2784f9\"},\"title\":\"Dr\",\"public\":true}]"
            + ",\"mobileHide\":false,\"mobileOrder\":null,\"version\":null,\"externalId\":null,\"hideDashboardToolbar\":true,"
            + "\"configuration\":null,\"name\":null}",
        JacksonUtil.writeValueAsString(new HomeDashboard(dashboard, true)));
  }

  /**
   * Test {@link JacksonUtil#writeValueAsString(Object)}.
   *
   * <ul>
   *   <li>Given {@link ArrayList#ArrayList()}.
   *   <li>When {@link AlarmCondition} (default constructor) Condition is {@link
   *       ArrayList#ArrayList()}.
   * </ul>
   *
   * <p>Method under test: {@link JacksonUtil#writeValueAsString(Object)}
   */
  @Test
  @DisplayName(
      "Test writeValueAsString(Object); given ArrayList(); when AlarmCondition (default constructor) Condition is ArrayList()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String JacksonUtil.writeValueAsString(Object)"})
  void testWriteValueAsString_givenArrayList_whenAlarmConditionConditionIsArrayList() {
    // Arrange
    AlarmCondition alarmCondition = new AlarmCondition();
    alarmCondition.setCondition(new ArrayList<>());
    alarmCondition.setSpec(mock(AlarmConditionSpec.class));

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class, () -> JacksonUtil.writeValueAsString(alarmCondition));
  }

  /**
   * Test {@link JacksonUtil#writeValueAsString(Object)}.
   *
   * <ul>
   *   <li>Given {@link HashSet#HashSet()}.
   *   <li>When {@link Dashboard#Dashboard()} AssignedCustomers is {@link HashSet#HashSet()}.
   * </ul>
   *
   * <p>Method under test: {@link JacksonUtil#writeValueAsString(Object)}
   */
  @Test
  @DisplayName(
      "Test writeValueAsString(Object); given HashSet(); when Dashboard() AssignedCustomers is HashSet()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String JacksonUtil.writeValueAsString(Object)"})
  void testWriteValueAsString_givenHashSet_whenDashboardAssignedCustomersIsHashSet() {
    // Arrange
    Dashboard dashboard = new Dashboard();
    dashboard.setAssignedCustomers(new HashSet<>());
    dashboard.setConfiguration(MissingNode.getInstance());

    // Act and Assert
    assertEquals(
        "{\"id\":null,\"createdTime\":0,\"tenantId\":null,\"title\":null,\"image\":null,\"assignedCustomers\":[],\"mobileHide"
            + "\":false,\"mobileOrder\":null,\"version\":null,\"externalId\":null,\"hideDashboardToolbar\":true,\"configuration"
            + "\":null,\"name\":null}",
        JacksonUtil.writeValueAsString(new HomeDashboard(dashboard, true)));
  }

  /**
   * Test {@link JacksonUtil#writeValueAsString(Object)}.
   *
   * <ul>
   *   <li>Given {@link IllegalArgumentException#IllegalArgumentException()}.
   * </ul>
   *
   * <p>Method under test: {@link JacksonUtil#writeValueAsString(Object)}
   */
  @Test
  @DisplayName("Test writeValueAsString(Object); given IllegalArgumentException()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String JacksonUtil.writeValueAsString(Object)"})
  void testWriteValueAsString_givenIllegalArgumentException() {
    // Arrange
    BaseData<UUIDBased> baseData = mock(BaseData.class);
    when(baseData.getId()).thenThrow(new IllegalArgumentException());

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> JacksonUtil.writeValueAsString(baseData));
    verify(baseData).getId();
  }

  /**
   * Test {@link JacksonUtil#writeValueAsString(Object)}.
   *
   * <ul>
   *   <li>Given valueOf ten.
   *   <li>When {@link Dashboard#Dashboard()} Configuration is valueOf ten.
   * </ul>
   *
   * <p>Method under test: {@link JacksonUtil#writeValueAsString(Object)}
   */
  @Test
  @DisplayName(
      "Test writeValueAsString(Object); given valueOf ten; when Dashboard() Configuration is valueOf ten")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String JacksonUtil.writeValueAsString(Object)"})
  void testWriteValueAsString_givenValueOfTen_whenDashboardConfigurationIsValueOfTen() {
    // Arrange
    Dashboard dashboard = new Dashboard();
    dashboard.setConfiguration(DoubleNode.valueOf(10.0d));

    // Act and Assert
    assertEquals(
        "{\"id\":null,\"createdTime\":0,\"tenantId\":null,\"title\":null,\"image\":null,\"assignedCustomers\":null,\"mobileHide"
            + "\":false,\"mobileOrder\":null,\"version\":null,\"externalId\":null,\"hideDashboardToolbar\":true,\"configuration"
            + "\":10.0,\"name\":null}",
        JacksonUtil.writeValueAsString(new HomeDashboard(dashboard, true)));
  }

  /**
   * Test {@link JacksonUtil#writeValueAsString(Object)}.
   *
   * <ul>
   *   <li>Then calls {@link BaseData#getCreatedTime()}.
   * </ul>
   *
   * <p>Method under test: {@link JacksonUtil#writeValueAsString(Object)}
   */
  @Test
  @DisplayName("Test writeValueAsString(Object); then calls getCreatedTime()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String JacksonUtil.writeValueAsString(Object)"})
  void testWriteValueAsString_thenCallsGetCreatedTime() {
    // Arrange
    BaseData<UUIDBased> baseData = mock(BaseData.class);
    when(baseData.getCreatedTime()).thenReturn(1L);
    when(baseData.getId())
        .thenReturn(new AdminSettingsId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")));

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> JacksonUtil.writeValueAsString(baseData));
    verify(baseData).getCreatedTime();
    verify(baseData).getId();
  }

  /**
   * Test {@link JacksonUtil#writeValueAsString(Object)}.
   *
   * <ul>
   *   <li>Then return {@code {"id":null,"name":"42"}}.
   * </ul>
   *
   * <p>Method under test: {@link JacksonUtil#writeValueAsString(Object)}
   */
  @Test
  @DisplayName("Test writeValueAsString(Object); then return '{\"id\":null,\"name\":\"42\"}'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String JacksonUtil.writeValueAsString(Object)"})
  void testWriteValueAsString_thenReturnIdNullName42() {
    // Arrange, Act and Assert
    assertEquals(
        "{\"id\":null,\"name\":\"42\"}",
        JacksonUtil.writeValueAsString(new EntityInfo(null, "42")));
  }

  /**
   * Test {@link JacksonUtil#writeValueAsString(Object)}.
   *
   * <ul>
   *   <li>Then return {@code {"id":null,"name":"Name"}}.
   * </ul>
   *
   * <p>Method under test: {@link JacksonUtil#writeValueAsString(Object)}
   */
  @Test
  @DisplayName("Test writeValueAsString(Object); then return '{\"id\":null,\"name\":\"Name\"}'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String JacksonUtil.writeValueAsString(Object)"})
  void testWriteValueAsString_thenReturnIdNullNameName() {
    // Arrange, Act and Assert
    assertEquals(
        "{\"id\":null,\"name\":\"Name\"}",
        JacksonUtil.writeValueAsString(new EntityInfo(null, "Name")));
  }

  /**
   * Test {@link JacksonUtil#writeValueAsString(Object)}.
   *
   * <ul>
   *   <li>When {@link Alarm#Alarm()}.
   *   <li>Then return a string.
   * </ul>
   *
   * <p>Method under test: {@link JacksonUtil#writeValueAsString(Object)}
   */
  @Test
  @DisplayName("Test writeValueAsString(Object); when Alarm(); then return a string")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String JacksonUtil.writeValueAsString(Object)"})
  void testWriteValueAsString_whenAlarm_thenReturnAString() {
    // Arrange, Act and Assert
    assertEquals(
        "{\"tenantId\":null,\"customerId\":null,\"type\":null,\"originator\":null,\"severity\":null,\"acknowledged\":false"
            + ",\"cleared\":false,\"assigneeId\":null,\"startTs\":0,\"endTs\":0,\"ackTs\":0,\"clearTs\":0,\"assignTs\":0,\"details"
            + "\":null,\"propagate\":false,\"propagateToOwner\":false,\"propagateToTenant\":false,\"propagateRelationTypes\""
            + ":null,\"id\":null,\"createdTime\":0,\"name\":null,\"status\":\"ACTIVE_UNACK\"}",
        JacksonUtil.writeValueAsString(new Alarm()));
  }

  /**
   * Test {@link JacksonUtil#writeValueAsString(Object)}.
   *
   * <ul>
   *   <li>When {@code null}.
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link JacksonUtil#writeValueAsString(Object)}
   */
  @Test
  @DisplayName("Test writeValueAsString(Object); when 'null'; then return 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String JacksonUtil.writeValueAsString(Object)"})
  void testWriteValueAsString_whenNull_thenReturnNull() {
    // Arrange, Act and Assert
    assertEquals("null", JacksonUtil.writeValueAsString(null));
  }

  /**
   * Test {@link JacksonUtil#writeValueAsString(Object)}.
   *
   * <ul>
   *   <li>When {@link TenantProfile#TenantProfile()}.
   *   <li>Then return a string.
   * </ul>
   *
   * <p>Method under test: {@link JacksonUtil#writeValueAsString(Object)}
   */
  @Test
  @DisplayName("Test writeValueAsString(Object); when TenantProfile(); then return a string")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
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
   *
   * <p>Method under test: {@link JacksonUtil#toPrettyString(Object)}
   */
  @Test
  @DisplayName("Test toPrettyString(Object)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String JacksonUtil.toPrettyString(Object)"})
  void testToPrettyString() {
    // Arrange, Act and Assert
    assertEquals(
        "{\r\n  \"securityMode\" : \"PSK\",\r\n  \"clientPublicKeyOrId\" : null,\r\n  \"clientSecretKey\" : null\r\n}",
        JacksonUtil.toPrettyString(new PSKBootstrapClientCredential()));
  }

  /**
   * Test {@link JacksonUtil#toPrettyString(Object)}.
   *
   * <p>Method under test: {@link JacksonUtil#toPrettyString(Object)}
   */
  @Test
  @DisplayName("Test toPrettyString(Object)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String JacksonUtil.toPrettyString(Object)"})
  void testToPrettyString2() {
    // Arrange
    DurationAlarmConditionSpec durationAlarmConditionSpec = new DurationAlarmConditionSpec();
    durationAlarmConditionSpec.setPredicate(
        new FilterPredicateValue<>(
            42L,
            42L,
            new DynamicValue<>(DynamicValueSourceType.CURRENT_TENANT, "Source Attribute")));
    durationAlarmConditionSpec.setUnit(TimeUnit.NANOSECONDS);

    // Act and Assert
    assertEquals(
        "{\r\n"
            + "  \"type\" : \"DURATION\",\r\n"
            + "  \"predicate\" : {\r\n"
            + "    \"defaultValue\" : 42,\r\n"
            + "    \"dynamicValue\" : {\r\n"
            + "      \"inherit\" : false,\r\n"
            + "      \"sourceAttribute\" : \"Source Attribute\",\r\n"
            + "      \"sourceType\" : \"CURRENT_TENANT\"\r\n"
            + "    },\r\n"
            + "    \"userValue\" : 42\r\n"
            + "  },\r\n"
            + "  \"unit\" : \"NANOSECONDS\"\r\n"
            + "}",
        JacksonUtil.toPrettyString(durationAlarmConditionSpec));
  }

  /**
   * Test {@link JacksonUtil#toPrettyString(Object)}.
   *
   * <p>Method under test: {@link JacksonUtil#toPrettyString(Object)}
   */
  @Test
  @DisplayName("Test toPrettyString(Object)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String JacksonUtil.toPrettyString(Object)"})
  void testToPrettyString3() {
    // Arrange
    BaseData<UUIDBased> baseData = mock(BaseData.class);
    when(baseData.getCreatedTime()).thenReturn(1L);
    when(baseData.getId())
        .thenReturn(new AdminSettingsId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")));

    // Act and Assert
    assertThrows(RuntimeException.class, () -> JacksonUtil.toPrettyString(baseData));
    verify(baseData).getCreatedTime();
    verify(baseData).getId();
  }

  /**
   * Test {@link JacksonUtil#toPrettyString(Object)}.
   *
   * <p>Method under test: {@link JacksonUtil#toPrettyString(Object)}
   */
  @Test
  @DisplayName("Test toPrettyString(Object)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String JacksonUtil.toPrettyString(Object)"})
  void testToPrettyString4() {
    // Arrange
    BaseData<UUIDBased> baseData = mock(BaseData.class);
    when(baseData.getCreatedTime()).thenReturn(1L);
    when(baseData.getId())
        .thenReturn(new AlarmId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")));

    // Act and Assert
    assertThrows(RuntimeException.class, () -> JacksonUtil.toPrettyString(baseData));
    verify(baseData).getCreatedTime();
    verify(baseData).getId();
  }

  /**
   * Test {@link JacksonUtil#toPrettyString(Object)}.
   *
   * <p>Method under test: {@link JacksonUtil#toPrettyString(Object)}
   */
  @Test
  @DisplayName("Test toPrettyString(Object)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String JacksonUtil.toPrettyString(Object)"})
  void testToPrettyString5() {
    // Arrange
    BaseData<UUIDBased> baseData = mock(BaseData.class);
    when(baseData.getCreatedTime()).thenReturn(1L);
    when(baseData.getId())
        .thenReturn(new CustomerId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")));

    // Act and Assert
    assertThrows(RuntimeException.class, () -> JacksonUtil.toPrettyString(baseData));
    verify(baseData).getCreatedTime();
    verify(baseData).getId();
  }

  /**
   * Test {@link JacksonUtil#toPrettyString(Object)}.
   *
   * <p>Method under test: {@link JacksonUtil#toPrettyString(Object)}
   */
  @Test
  @DisplayName("Test toPrettyString(Object)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String JacksonUtil.toPrettyString(Object)"})
  void testToPrettyString6() {
    // Arrange
    BaseDataWithAdditionalInfo<UUIDBased> baseDataWithAdditionalInfo =
        mock(BaseDataWithAdditionalInfo.class);
    JsonNodeFactory nf = JsonNodeFactory.withExactBigDecimals(true);
    when(baseDataWithAdditionalInfo.getAdditionalInfo()).thenReturn(new ArrayNode(nf, 3));
    when(baseDataWithAdditionalInfo.getCreatedTime()).thenReturn(1L);
    when(baseDataWithAdditionalInfo.getId())
        .thenReturn(new AdminSettingsId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")));

    // Act and Assert
    assertThrows(
        RuntimeException.class, () -> JacksonUtil.toPrettyString(baseDataWithAdditionalInfo));
    verify(baseDataWithAdditionalInfo).getCreatedTime();
    verify(baseDataWithAdditionalInfo).getAdditionalInfo();
    verify(baseDataWithAdditionalInfo).getId();
  }

  /**
   * Test {@link JacksonUtil#toPrettyString(Object)}.
   *
   * <p>Method under test: {@link JacksonUtil#toPrettyString(Object)}
   */
  @Test
  @DisplayName("Test toPrettyString(Object)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String JacksonUtil.toPrettyString(Object)"})
  void testToPrettyString7() throws UnsupportedEncodingException {
    // Arrange
    BaseDataWithAdditionalInfo<UUIDBased> baseDataWithAdditionalInfo =
        mock(BaseDataWithAdditionalInfo.class);
    when(baseDataWithAdditionalInfo.getAdditionalInfo())
        .thenReturn(new BinaryNode("AXAXAXAX".getBytes("UTF-8"), 2, 3));
    when(baseDataWithAdditionalInfo.getCreatedTime()).thenReturn(1L);
    when(baseDataWithAdditionalInfo.getId())
        .thenReturn(new AdminSettingsId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")));

    // Act and Assert
    assertThrows(
        RuntimeException.class, () -> JacksonUtil.toPrettyString(baseDataWithAdditionalInfo));
    verify(baseDataWithAdditionalInfo).getCreatedTime();
    verify(baseDataWithAdditionalInfo).getAdditionalInfo();
    verify(baseDataWithAdditionalInfo).getId();
  }

  /**
   * Test {@link JacksonUtil#toPrettyString(Object)}.
   *
   * <p>Method under test: {@link JacksonUtil#toPrettyString(Object)}
   */
  @Test
  @DisplayName("Test toPrettyString(Object)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String JacksonUtil.toPrettyString(Object)"})
  void testToPrettyString8() throws UnsupportedEncodingException {
    // Arrange
    JsonNodeFactory nf = JsonNodeFactory.withExactBigDecimals(true);

    ArrayNode arrayNode = new ArrayNode(nf);
    arrayNode.add("AXAXAXAX".getBytes("UTF-8"));
    arrayNode.add(DoubleNode.valueOf(10.0d));

    BaseDataWithAdditionalInfo<UUIDBased> baseDataWithAdditionalInfo =
        mock(BaseDataWithAdditionalInfo.class);
    when(baseDataWithAdditionalInfo.getAdditionalInfo()).thenReturn(arrayNode);
    when(baseDataWithAdditionalInfo.getCreatedTime()).thenReturn(1L);
    when(baseDataWithAdditionalInfo.getId())
        .thenReturn(new AdminSettingsId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")));

    // Act and Assert
    assertThrows(
        RuntimeException.class, () -> JacksonUtil.toPrettyString(baseDataWithAdditionalInfo));
    verify(baseDataWithAdditionalInfo).getCreatedTime();
    verify(baseDataWithAdditionalInfo).getAdditionalInfo();
    verify(baseDataWithAdditionalInfo).getId();
  }

  /**
   * Test {@link JacksonUtil#toPrettyString(Object)}.
   *
   * <p>Method under test: {@link JacksonUtil#toPrettyString(Object)}
   */
  @Test
  @DisplayName("Test toPrettyString(Object)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String JacksonUtil.toPrettyString(Object)"})
  void testToPrettyString9() {
    // Arrange
    BaseDataWithAdditionalInfo<UUIDBased> baseDataWithAdditionalInfo =
        mock(BaseDataWithAdditionalInfo.class);
    when(baseDataWithAdditionalInfo.getAdditionalInfo()).thenReturn(MissingNode.getInstance());
    when(baseDataWithAdditionalInfo.getCreatedTime()).thenReturn(1L);
    when(baseDataWithAdditionalInfo.getId()).thenReturn(new AdminSettingsId(UUID.randomUUID()));

    // Act and Assert
    assertThrows(
        RuntimeException.class, () -> JacksonUtil.toPrettyString(baseDataWithAdditionalInfo));
    verify(baseDataWithAdditionalInfo).getCreatedTime();
    verify(baseDataWithAdditionalInfo).getAdditionalInfo();
    verify(baseDataWithAdditionalInfo).getId();
  }

  /**
   * Test {@link JacksonUtil#toPrettyString(Object)}.
   *
   * <ul>
   *   <li>Given {@code 42}.
   * </ul>
   *
   * <p>Method under test: {@link JacksonUtil#toPrettyString(Object)}
   */
  @Test
  @DisplayName("Test toPrettyString(Object); given '42'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String JacksonUtil.toPrettyString(Object)"})
  void testToPrettyString_given42() {
    // Arrange
    PSKBootstrapClientCredential pskBootstrapClientCredential = new PSKBootstrapClientCredential();
    pskBootstrapClientCredential.setClientPublicKeyOrId("42");
    pskBootstrapClientCredential.setClientSecretKey("EXAMPLEKEYwjalrXUtnFEMI/K7MDENG/bPxRfiCY");

    // Act and Assert
    assertEquals(
        "{\r\n"
            + "  \"securityMode\" : \"PSK\",\r\n"
            + "  \"clientPublicKeyOrId\" : \"42\",\r\n"
            + "  \"clientSecretKey\" : \"EXAMPLEKEYwjalrXUtnFEMI/K7MDENG/bPxRfiCY\"\r\n"
            + "}",
        JacksonUtil.toPrettyString(pskBootstrapClientCredential));
  }

  /**
   * Test {@link JacksonUtil#toPrettyString(Object)}.
   *
   * <ul>
   *   <li>Given {@link AlarmId#AlarmId(UUID)} with id is randomUUID.
   * </ul>
   *
   * <p>Method under test: {@link JacksonUtil#toPrettyString(Object)}
   */
  @Test
  @DisplayName("Test toPrettyString(Object); given AlarmId(UUID) with id is randomUUID")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String JacksonUtil.toPrettyString(Object)"})
  void testToPrettyString_givenAlarmIdWithIdIsRandomUUID() {
    // Arrange
    BaseData<UUIDBased> baseData = mock(BaseData.class);
    when(baseData.getCreatedTime()).thenReturn(1L);
    when(baseData.getId()).thenReturn(new AlarmId(UUID.randomUUID()));

    // Act and Assert
    assertThrows(RuntimeException.class, () -> JacksonUtil.toPrettyString(baseData));
    verify(baseData).getCreatedTime();
    verify(baseData).getId();
  }

  /**
   * Test {@link JacksonUtil#toPrettyString(Object)}.
   *
   * <ul>
   *   <li>Given {@link ArrayList#ArrayList()}.
   *   <li>When {@link AlarmCondition} (default constructor) Condition is {@link
   *       ArrayList#ArrayList()}.
   * </ul>
   *
   * <p>Method under test: {@link JacksonUtil#toPrettyString(Object)}
   */
  @Test
  @DisplayName(
      "Test toPrettyString(Object); given ArrayList(); when AlarmCondition (default constructor) Condition is ArrayList()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
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
   *
   * <ul>
   *   <li>Given {@link ArrayNode#ArrayNode(JsonNodeFactory)} with nf is withExactBigDecimals {@code
   *       true}.
   * </ul>
   *
   * <p>Method under test: {@link JacksonUtil#toPrettyString(Object)}
   */
  @Test
  @DisplayName(
      "Test toPrettyString(Object); given ArrayNode(JsonNodeFactory) with nf is withExactBigDecimals 'true'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String JacksonUtil.toPrettyString(Object)"})
  void testToPrettyString_givenArrayNodeWithNfIsWithExactBigDecimalsTrue() {
    // Arrange
    BaseDataWithAdditionalInfo<UUIDBased> baseDataWithAdditionalInfo =
        mock(BaseDataWithAdditionalInfo.class);
    JsonNodeFactory nf = JsonNodeFactory.withExactBigDecimals(true);
    when(baseDataWithAdditionalInfo.getAdditionalInfo()).thenReturn(new ArrayNode(nf));
    when(baseDataWithAdditionalInfo.getCreatedTime()).thenReturn(1L);
    when(baseDataWithAdditionalInfo.getId())
        .thenReturn(new AdminSettingsId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")));

    // Act and Assert
    assertThrows(
        RuntimeException.class, () -> JacksonUtil.toPrettyString(baseDataWithAdditionalInfo));
    verify(baseDataWithAdditionalInfo).getCreatedTime();
    verify(baseDataWithAdditionalInfo).getAdditionalInfo();
    verify(baseDataWithAdditionalInfo).getId();
  }

  /**
   * Test {@link JacksonUtil#toPrettyString(Object)}.
   *
   * <ul>
   *   <li>Given {@link ArrayNode#ArrayNode(JsonNodeFactory)} with nf is withExactBigDecimals {@code
   *       true} addArray.
   * </ul>
   *
   * <p>Method under test: {@link JacksonUtil#toPrettyString(Object)}
   */
  @Test
  @DisplayName(
      "Test toPrettyString(Object); given ArrayNode(JsonNodeFactory) with nf is withExactBigDecimals 'true' addArray")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String JacksonUtil.toPrettyString(Object)"})
  void testToPrettyString_givenArrayNodeWithNfIsWithExactBigDecimalsTrueAddArray() {
    // Arrange
    JsonNodeFactory nf = JsonNodeFactory.withExactBigDecimals(true);

    ArrayNode arrayNode = new ArrayNode(nf);
    arrayNode.addArray();
    arrayNode.add(DoubleNode.valueOf(10.0d));

    BaseDataWithAdditionalInfo<UUIDBased> baseDataWithAdditionalInfo =
        mock(BaseDataWithAdditionalInfo.class);
    when(baseDataWithAdditionalInfo.getAdditionalInfo()).thenReturn(arrayNode);
    when(baseDataWithAdditionalInfo.getCreatedTime()).thenReturn(1L);
    when(baseDataWithAdditionalInfo.getId())
        .thenReturn(new AdminSettingsId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")));

    // Act and Assert
    assertThrows(
        RuntimeException.class, () -> JacksonUtil.toPrettyString(baseDataWithAdditionalInfo));
    verify(baseDataWithAdditionalInfo).getCreatedTime();
    verify(baseDataWithAdditionalInfo).getAdditionalInfo();
    verify(baseDataWithAdditionalInfo).getId();
  }

  /**
   * Test {@link JacksonUtil#toPrettyString(Object)}.
   *
   * <ul>
   *   <li>Given {@link ArrayNode#ArrayNode(JsonNodeFactory)} with nf is withExactBigDecimals {@code
   *       true} add Instance.
   * </ul>
   *
   * <p>Method under test: {@link JacksonUtil#toPrettyString(Object)}
   */
  @Test
  @DisplayName(
      "Test toPrettyString(Object); given ArrayNode(JsonNodeFactory) with nf is withExactBigDecimals 'true' add Instance")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String JacksonUtil.toPrettyString(Object)"})
  void testToPrettyString_givenArrayNodeWithNfIsWithExactBigDecimalsTrueAddInstance() {
    // Arrange
    JsonNodeFactory nf = JsonNodeFactory.withExactBigDecimals(true);

    ArrayNode arrayNode = new ArrayNode(nf);
    arrayNode.add(MissingNode.getInstance());

    BaseDataWithAdditionalInfo<UUIDBased> baseDataWithAdditionalInfo =
        mock(BaseDataWithAdditionalInfo.class);
    when(baseDataWithAdditionalInfo.getAdditionalInfo()).thenReturn(arrayNode);
    when(baseDataWithAdditionalInfo.getCreatedTime()).thenReturn(1L);
    when(baseDataWithAdditionalInfo.getId())
        .thenReturn(new AdminSettingsId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")));

    // Act and Assert
    assertThrows(
        RuntimeException.class, () -> JacksonUtil.toPrettyString(baseDataWithAdditionalInfo));
    verify(baseDataWithAdditionalInfo).getCreatedTime();
    verify(baseDataWithAdditionalInfo).getAdditionalInfo();
    verify(baseDataWithAdditionalInfo).getId();
  }

  /**
   * Test {@link JacksonUtil#toPrettyString(Object)}.
   *
   * <ul>
   *   <li>Given {@link ArrayNode#ArrayNode(JsonNodeFactory)} with nf is withExactBigDecimals {@code
   *       true} addNull.
   * </ul>
   *
   * <p>Method under test: {@link JacksonUtil#toPrettyString(Object)}
   */
  @Test
  @DisplayName(
      "Test toPrettyString(Object); given ArrayNode(JsonNodeFactory) with nf is withExactBigDecimals 'true' addNull")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String JacksonUtil.toPrettyString(Object)"})
  void testToPrettyString_givenArrayNodeWithNfIsWithExactBigDecimalsTrueAddNull() {
    // Arrange
    JsonNodeFactory nf = JsonNodeFactory.withExactBigDecimals(true);

    ArrayNode arrayNode = new ArrayNode(nf);
    arrayNode.addNull();
    arrayNode.add(DoubleNode.valueOf(10.0d));

    BaseDataWithAdditionalInfo<UUIDBased> baseDataWithAdditionalInfo =
        mock(BaseDataWithAdditionalInfo.class);
    when(baseDataWithAdditionalInfo.getAdditionalInfo()).thenReturn(arrayNode);
    when(baseDataWithAdditionalInfo.getCreatedTime()).thenReturn(1L);
    when(baseDataWithAdditionalInfo.getId())
        .thenReturn(new AdminSettingsId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")));

    // Act and Assert
    assertThrows(
        RuntimeException.class, () -> JacksonUtil.toPrettyString(baseDataWithAdditionalInfo));
    verify(baseDataWithAdditionalInfo).getCreatedTime();
    verify(baseDataWithAdditionalInfo).getAdditionalInfo();
    verify(baseDataWithAdditionalInfo).getId();
  }

  /**
   * Test {@link JacksonUtil#toPrettyString(Object)}.
   *
   * <ul>
   *   <li>Given {@link ArrayNode#ArrayNode(JsonNodeFactory)} with nf is withExactBigDecimals {@code
   *       true} addObject.
   * </ul>
   *
   * <p>Method under test: {@link JacksonUtil#toPrettyString(Object)}
   */
  @Test
  @DisplayName(
      "Test toPrettyString(Object); given ArrayNode(JsonNodeFactory) with nf is withExactBigDecimals 'true' addObject")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String JacksonUtil.toPrettyString(Object)"})
  void testToPrettyString_givenArrayNodeWithNfIsWithExactBigDecimalsTrueAddObject() {
    // Arrange
    JsonNodeFactory nf = JsonNodeFactory.withExactBigDecimals(true);

    ArrayNode arrayNode = new ArrayNode(nf);
    arrayNode.addObject();
    arrayNode.add(DoubleNode.valueOf(10.0d));

    BaseDataWithAdditionalInfo<UUIDBased> baseDataWithAdditionalInfo =
        mock(BaseDataWithAdditionalInfo.class);
    when(baseDataWithAdditionalInfo.getAdditionalInfo()).thenReturn(arrayNode);
    when(baseDataWithAdditionalInfo.getCreatedTime()).thenReturn(1L);
    when(baseDataWithAdditionalInfo.getId())
        .thenReturn(new AdminSettingsId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")));

    // Act and Assert
    assertThrows(
        RuntimeException.class, () -> JacksonUtil.toPrettyString(baseDataWithAdditionalInfo));
    verify(baseDataWithAdditionalInfo).getCreatedTime();
    verify(baseDataWithAdditionalInfo).getAdditionalInfo();
    verify(baseDataWithAdditionalInfo).getId();
  }

  /**
   * Test {@link JacksonUtil#toPrettyString(Object)}.
   *
   * <ul>
   *   <li>Given {@link ArrayNode#ArrayNode(JsonNodeFactory)} with nf is withExactBigDecimals {@code
   *       true} addPOJO {@code Pojo}.
   * </ul>
   *
   * <p>Method under test: {@link JacksonUtil#toPrettyString(Object)}
   */
  @Test
  @DisplayName(
      "Test toPrettyString(Object); given ArrayNode(JsonNodeFactory) with nf is withExactBigDecimals 'true' addPOJO 'Pojo'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String JacksonUtil.toPrettyString(Object)"})
  void testToPrettyString_givenArrayNodeWithNfIsWithExactBigDecimalsTrueAddPOJOPojo() {
    // Arrange
    JsonNodeFactory nf = JsonNodeFactory.withExactBigDecimals(true);

    ArrayNode arrayNode = new ArrayNode(nf);
    arrayNode.addPOJO("Pojo");
    arrayNode.add(DoubleNode.valueOf(10.0d));

    BaseDataWithAdditionalInfo<UUIDBased> baseDataWithAdditionalInfo =
        mock(BaseDataWithAdditionalInfo.class);
    when(baseDataWithAdditionalInfo.getAdditionalInfo()).thenReturn(arrayNode);
    when(baseDataWithAdditionalInfo.getCreatedTime()).thenReturn(1L);
    when(baseDataWithAdditionalInfo.getId())
        .thenReturn(new AdminSettingsId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")));

    // Act and Assert
    assertThrows(
        RuntimeException.class, () -> JacksonUtil.toPrettyString(baseDataWithAdditionalInfo));
    verify(baseDataWithAdditionalInfo).getCreatedTime();
    verify(baseDataWithAdditionalInfo).getAdditionalInfo();
    verify(baseDataWithAdditionalInfo).getId();
  }

  /**
   * Test {@link JacksonUtil#toPrettyString(Object)}.
   *
   * <ul>
   *   <li>Given {@link ArrayNode#ArrayNode(JsonNodeFactory)} with nf is withExactBigDecimals {@code
   *       true} add valueOf ten.
   * </ul>
   *
   * <p>Method under test: {@link JacksonUtil#toPrettyString(Object)}
   */
  @Test
  @DisplayName(
      "Test toPrettyString(Object); given ArrayNode(JsonNodeFactory) with nf is withExactBigDecimals 'true' add valueOf ten")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String JacksonUtil.toPrettyString(Object)"})
  void testToPrettyString_givenArrayNodeWithNfIsWithExactBigDecimalsTrueAddValueOfTen() {
    // Arrange
    JsonNodeFactory nf = JsonNodeFactory.withExactBigDecimals(true);

    ArrayNode arrayNode = new ArrayNode(nf);
    arrayNode.add(DoubleNode.valueOf(10.0d));

    BaseDataWithAdditionalInfo<UUIDBased> baseDataWithAdditionalInfo =
        mock(BaseDataWithAdditionalInfo.class);
    when(baseDataWithAdditionalInfo.getAdditionalInfo()).thenReturn(arrayNode);
    when(baseDataWithAdditionalInfo.getCreatedTime()).thenReturn(1L);
    when(baseDataWithAdditionalInfo.getId())
        .thenReturn(new AdminSettingsId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")));

    // Act and Assert
    assertThrows(
        RuntimeException.class, () -> JacksonUtil.toPrettyString(baseDataWithAdditionalInfo));
    verify(baseDataWithAdditionalInfo).getCreatedTime();
    verify(baseDataWithAdditionalInfo).getAdditionalInfo();
    verify(baseDataWithAdditionalInfo).getId();
  }

  /**
   * Test {@link JacksonUtil#toPrettyString(Object)}.
   *
   * <ul>
   *   <li>Given {@link BinaryNode#BinaryNode(byte[])} with data is {@code AXAXAXAX} Bytes is {@code
   *       UTF-8}.
   * </ul>
   *
   * <p>Method under test: {@link JacksonUtil#toPrettyString(Object)}
   */
  @Test
  @DisplayName(
      "Test toPrettyString(Object); given BinaryNode(byte[]) with data is 'AXAXAXAX' Bytes is 'UTF-8'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String JacksonUtil.toPrettyString(Object)"})
  void testToPrettyString_givenBinaryNodeWithDataIsAxaxaxaxBytesIsUtf8()
      throws UnsupportedEncodingException {
    // Arrange
    BaseDataWithAdditionalInfo<UUIDBased> baseDataWithAdditionalInfo =
        mock(BaseDataWithAdditionalInfo.class);
    when(baseDataWithAdditionalInfo.getAdditionalInfo())
        .thenReturn(new BinaryNode("AXAXAXAX".getBytes("UTF-8")));
    when(baseDataWithAdditionalInfo.getCreatedTime()).thenReturn(1L);
    when(baseDataWithAdditionalInfo.getId())
        .thenReturn(new AdminSettingsId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")));

    // Act and Assert
    assertThrows(
        RuntimeException.class, () -> JacksonUtil.toPrettyString(baseDataWithAdditionalInfo));
    verify(baseDataWithAdditionalInfo).getCreatedTime();
    verify(baseDataWithAdditionalInfo).getAdditionalInfo();
    verify(baseDataWithAdditionalInfo).getId();
  }

  /**
   * Test {@link JacksonUtil#toPrettyString(Object)}.
   *
   * <ul>
   *   <li>Given {@link IllegalArgumentException#IllegalArgumentException()}.
   * </ul>
   *
   * <p>Method under test: {@link JacksonUtil#toPrettyString(Object)}
   */
  @Test
  @DisplayName("Test toPrettyString(Object); given IllegalArgumentException()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String JacksonUtil.toPrettyString(Object)"})
  void testToPrettyString_givenIllegalArgumentException() {
    // Arrange
    BaseData<UUIDBased> baseData = mock(BaseData.class);
    when(baseData.getCreatedTime()).thenThrow(new IllegalArgumentException());

    // Act and Assert
    assertThrows(RuntimeException.class, () -> JacksonUtil.toPrettyString(baseData));
    verify(baseData).getCreatedTime();
  }

  /**
   * Test {@link JacksonUtil#toPrettyString(Object)}.
   *
   * <ul>
   *   <li>Given {@link ImageDescriptor} (default constructor) Etag is {@code Etag}.
   *   <li>When {@link ImageDescriptor} (default constructor) Etag is {@code Etag}.
   * </ul>
   *
   * <p>Method under test: {@link JacksonUtil#toPrettyString(Object)}
   */
  @Test
  @DisplayName(
      "Test toPrettyString(Object); given ImageDescriptor (default constructor) Etag is 'Etag'; when ImageDescriptor (default constructor) Etag is 'Etag'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String JacksonUtil.toPrettyString(Object)"})
  void testToPrettyString_givenImageDescriptorEtagIsEtag_whenImageDescriptorEtagIsEtag() {
    // Arrange
    ImageDescriptor previewDescriptor = new ImageDescriptor();
    previewDescriptor.setEtag("Etag");
    previewDescriptor.setHeight(1);
    previewDescriptor.setMediaType("text/plain");
    previewDescriptor.setPreviewDescriptor(new ImageDescriptor());
    previewDescriptor.setSize(3L);
    previewDescriptor.setWidth(1);

    ImageDescriptor previewDescriptor2 = new ImageDescriptor();
    previewDescriptor2.setEtag("Etag");
    previewDescriptor2.setHeight(1);
    previewDescriptor2.setMediaType("text/plain");
    previewDescriptor2.setPreviewDescriptor(previewDescriptor);
    previewDescriptor2.setSize(3L);
    previewDescriptor2.setWidth(1);

    ImageDescriptor previewDescriptor3 = new ImageDescriptor();
    previewDescriptor3.setEtag("Etag");
    previewDescriptor3.setHeight(1);
    previewDescriptor3.setMediaType("text/plain");
    previewDescriptor3.setPreviewDescriptor(previewDescriptor2);
    previewDescriptor3.setSize(3L);
    previewDescriptor3.setWidth(1);

    ImageDescriptor imageDescriptor = new ImageDescriptor();
    imageDescriptor.setEtag("Etag");
    imageDescriptor.setHeight(1);
    imageDescriptor.setMediaType("text/plain");
    imageDescriptor.setPreviewDescriptor(previewDescriptor3);
    imageDescriptor.setSize(3L);
    imageDescriptor.setWidth(1);

    // Act and Assert
    assertEquals(
        "{\r\n"
            + "  \"etag\" : \"Etag\",\r\n"
            + "  \"height\" : 1,\r\n"
            + "  \"mediaType\" : \"text/plain\",\r\n"
            + "  \"previewDescriptor\" : {\r\n"
            + "    \"etag\" : \"Etag\",\r\n"
            + "    \"height\" : 1,\r\n"
            + "    \"mediaType\" : \"text/plain\",\r\n"
            + "    \"previewDescriptor\" : {\r\n"
            + "      \"etag\" : \"Etag\",\r\n"
            + "      \"height\" : 1,\r\n"
            + "      \"mediaType\" : \"text/plain\",\r\n"
            + "      \"previewDescriptor\" : {\r\n"
            + "        \"etag\" : \"Etag\",\r\n"
            + "        \"height\" : 1,\r\n"
            + "        \"mediaType\" : \"text/plain\",\r\n"
            + "        \"previewDescriptor\" : {\r\n"
            + "          \"height\" : 0,\r\n"
            + "          \"size\" : 0,\r\n"
            + "          \"width\" : 0\r\n"
            + "        },\r\n"
            + "        \"size\" : 3,\r\n"
            + "        \"width\" : 1\r\n"
            + "      },\r\n"
            + "      \"size\" : 3,\r\n"
            + "      \"width\" : 1\r\n"
            + "    },\r\n"
            + "    \"size\" : 3,\r\n"
            + "    \"width\" : 1\r\n"
            + "  },\r\n"
            + "  \"size\" : 3,\r\n"
            + "  \"width\" : 1\r\n"
            + "}",
        JacksonUtil.toPrettyString(imageDescriptor));
  }

  /**
   * Test {@link JacksonUtil#toPrettyString(Object)}.
   *
   * <ul>
   *   <li>Given Instance.
   * </ul>
   *
   * <p>Method under test: {@link JacksonUtil#toPrettyString(Object)}
   */
  @Test
  @DisplayName("Test toPrettyString(Object); given Instance")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String JacksonUtil.toPrettyString(Object)"})
  void testToPrettyString_givenInstance() {
    // Arrange
    BaseDataWithAdditionalInfo<UUIDBased> baseDataWithAdditionalInfo =
        mock(BaseDataWithAdditionalInfo.class);
    when(baseDataWithAdditionalInfo.getAdditionalInfo()).thenReturn(MissingNode.getInstance());
    when(baseDataWithAdditionalInfo.getCreatedTime()).thenReturn(1L);
    when(baseDataWithAdditionalInfo.getId())
        .thenReturn(new AdminSettingsId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")));

    // Act and Assert
    assertThrows(
        RuntimeException.class, () -> JacksonUtil.toPrettyString(baseDataWithAdditionalInfo));
    verify(baseDataWithAdditionalInfo).getCreatedTime();
    verify(baseDataWithAdditionalInfo).getAdditionalInfo();
    verify(baseDataWithAdditionalInfo).getId();
  }

  /**
   * Test {@link JacksonUtil#toPrettyString(Object)}.
   *
   * <ul>
   *   <li>Given Instance.
   * </ul>
   *
   * <p>Method under test: {@link JacksonUtil#toPrettyString(Object)}
   */
  @Test
  @DisplayName("Test toPrettyString(Object); given Instance")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String JacksonUtil.toPrettyString(Object)"})
  void testToPrettyString_givenInstance2() {
    // Arrange
    BaseDataWithAdditionalInfo<UUIDBased> baseDataWithAdditionalInfo =
        mock(BaseDataWithAdditionalInfo.class);
    when(baseDataWithAdditionalInfo.getAdditionalInfo()).thenReturn(NullNode.getInstance());
    when(baseDataWithAdditionalInfo.getCreatedTime()).thenReturn(1L);
    when(baseDataWithAdditionalInfo.getId())
        .thenReturn(new AdminSettingsId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")));

    // Act and Assert
    assertThrows(
        RuntimeException.class, () -> JacksonUtil.toPrettyString(baseDataWithAdditionalInfo));
    verify(baseDataWithAdditionalInfo).getCreatedTime();
    verify(baseDataWithAdditionalInfo).getAdditionalInfo();
    verify(baseDataWithAdditionalInfo).getId();
  }

  /**
   * Test {@link JacksonUtil#toPrettyString(Object)}.
   *
   * <ul>
   *   <li>Then return {@code { "createdTime" : 0, "id" : null, "jsonValue" : null, "key" : null,
   *       "tenantId" : null }}.
   * </ul>
   *
   * <p>Method under test: {@link JacksonUtil#toPrettyString(Object)}
   */
  @Test
  @DisplayName(
      "Test toPrettyString(Object); then return '{ \"createdTime\" : 0, \"id\" : null, \"jsonValue\" : null, \"key\" : null, \"tenantId\" : null }'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String JacksonUtil.toPrettyString(Object)"})
  void testToPrettyString_thenReturnCreatedTime0IdNullJsonValueNullKeyNullTenantIdNull() {
    // Arrange, Act and Assert
    assertEquals(
        "{\r\n"
            + "  \"createdTime\" : 0,\r\n"
            + "  \"id\" : null,\r\n"
            + "  \"jsonValue\" : null,\r\n"
            + "  \"key\" : null,\r\n"
            + "  \"tenantId\" : null\r\n"
            + "}",
        JacksonUtil.toPrettyString(new AdminSettings()));
  }

  /**
   * Test {@link JacksonUtil#toPrettyString(Object)}.
   *
   * <ul>
   *   <li>When {@link Alarm#Alarm()}.
   *   <li>Then return a string.
   * </ul>
   *
   * <p>Method under test: {@link JacksonUtil#toPrettyString(Object)}
   */
  @Test
  @DisplayName("Test toPrettyString(Object); when Alarm(); then return a string")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String JacksonUtil.toPrettyString(Object)"})
  void testToPrettyString_whenAlarm_thenReturnAString() {
    // Arrange, Act and Assert
    assertEquals(
        "{\r\n"
            + "  \"ackTs\" : 0,\r\n"
            + "  \"acknowledged\" : false,\r\n"
            + "  \"assignTs\" : 0,\r\n"
            + "  \"assigneeId\" : null,\r\n"
            + "  \"clearTs\" : 0,\r\n"
            + "  \"cleared\" : false,\r\n"
            + "  \"customerId\" : null,\r\n"
            + "  \"details\" : null,\r\n"
            + "  \"endTs\" : 0,\r\n"
            + "  \"originator\" : null,\r\n"
            + "  \"propagate\" : false,\r\n"
            + "  \"propagateRelationTypes\" : null,\r\n"
            + "  \"propagateToOwner\" : false,\r\n"
            + "  \"propagateToTenant\" : false,\r\n"
            + "  \"severity\" : null,\r\n"
            + "  \"startTs\" : 0,\r\n"
            + "  \"tenantId\" : null,\r\n"
            + "  \"type\" : null,\r\n"
            + "  \"createdTime\" : 0,\r\n"
            + "  \"id\" : null,\r\n"
            + "  \"name\" : null,\r\n"
            + "  \"status\" : \"ACTIVE_UNACK\"\r\n"
            + "}",
        JacksonUtil.toPrettyString(new Alarm()));
  }

  /**
   * Test {@link JacksonUtil#toPrettyString(Object)}.
   *
   * <ul>
   *   <li>When {@link ApiUsageState#ApiUsageState()}.
   *   <li>Then return a string.
   * </ul>
   *
   * <p>Method under test: {@link JacksonUtil#toPrettyString(Object)}
   */
  @Test
  @DisplayName("Test toPrettyString(Object); when ApiUsageState(); then return a string")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String JacksonUtil.toPrettyString(Object)"})
  void testToPrettyString_whenApiUsageState_thenReturnAString() {
    // Arrange, Act and Assert
    assertEquals(
        "{\r\n"
            + "  \"alarmCreationEnabled\" : true,\r\n"
            + "  \"alarmExecState\" : null,\r\n"
            + "  \"createdTime\" : 0,\r\n"
            + "  \"dbStorageEnabled\" : true,\r\n"
            + "  \"dbStorageState\" : null,\r\n"
            + "  \"emailExecState\" : null,\r\n"
            + "  \"emailSendEnabled\" : true,\r\n"
            + "  \"entityId\" : null,\r\n"
            + "  \"id\" : null,\r\n"
            + "  \"jsExecEnabled\" : true,\r\n"
            + "  \"jsExecState\" : null,\r\n"
            + "  \"reExecEnabled\" : true,\r\n"
            + "  \"reExecState\" : null,\r\n"
            + "  \"smsExecState\" : null,\r\n"
            + "  \"smsSendEnabled\" : true,\r\n"
            + "  \"tbelExecEnabled\" : true,\r\n"
            + "  \"tbelExecState\" : null,\r\n"
            + "  \"tenantId\" : null,\r\n"
            + "  \"transportEnabled\" : true,\r\n"
            + "  \"transportState\" : null\r\n"
            + "}",
        JacksonUtil.toPrettyString(new ApiUsageState()));
  }

  /**
   * Test {@link JacksonUtil#toPrettyString(Object)}.
   *
   * <ul>
   *   <li>When {@link BaseData} {@link BaseData#getId()} return {@link
   *       AdminSettingsId#AdminSettingsId(UUID)} with id is randomUUID.
   * </ul>
   *
   * <p>Method under test: {@link JacksonUtil#toPrettyString(Object)}
   */
  @Test
  @DisplayName(
      "Test toPrettyString(Object); when BaseData getId() return AdminSettingsId(UUID) with id is randomUUID")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String JacksonUtil.toPrettyString(Object)"})
  void testToPrettyString_whenBaseDataGetIdReturnAdminSettingsIdWithIdIsRandomUUID() {
    // Arrange
    BaseData<UUIDBased> baseData = mock(BaseData.class);
    when(baseData.getCreatedTime()).thenReturn(1L);
    when(baseData.getId()).thenReturn(new AdminSettingsId(UUID.randomUUID()));

    // Act and Assert
    assertThrows(RuntimeException.class, () -> JacksonUtil.toPrettyString(baseData));
    verify(baseData).getCreatedTime();
    verify(baseData).getId();
  }

  /**
   * Test {@link JacksonUtil#toPrettyString(Object)}.
   *
   * <ul>
   *   <li>When {@link CoapDeviceTransportConfiguration} (default constructor).
   *   <li>Then return a string.
   * </ul>
   *
   * <p>Method under test: {@link JacksonUtil#toPrettyString(Object)}
   */
  @Test
  @DisplayName(
      "Test toPrettyString(Object); when CoapDeviceTransportConfiguration (default constructor); then return a string")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String JacksonUtil.toPrettyString(Object)"})
  void testToPrettyString_whenCoapDeviceTransportConfiguration_thenReturnAString() {
    // Arrange, Act and Assert
    assertEquals(
        "{\r\n"
            + "  \"type\" : \"COAP\",\r\n"
            + "  \"edrxCycle\" : null,\r\n"
            + "  \"pagingTransmissionWindow\" : null,\r\n"
            + "  \"powerMode\" : null,\r\n"
            + "  \"psmActivityTimer\" : null\r\n"
            + "}",
        JacksonUtil.toPrettyString(new CoapDeviceTransportConfiguration()));
  }

  /**
   * Test {@link JacksonUtil#toPrettyString(Object)}.
   *
   * <ul>
   *   <li>When {@link Customer#Customer()}.
   *   <li>Then return a string.
   * </ul>
   *
   * <p>Method under test: {@link JacksonUtil#toPrettyString(Object)}
   */
  @Test
  @DisplayName("Test toPrettyString(Object); when Customer(); then return a string")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String JacksonUtil.toPrettyString(Object)"})
  void testToPrettyString_whenCustomer_thenReturnAString() {
    // Arrange, Act and Assert
    assertEquals(
        "{\r\n"
            + "  \"additionalInfo\" : null,\r\n"
            + "  \"address\" : null,\r\n"
            + "  \"address2\" : null,\r\n"
            + "  \"city\" : null,\r\n"
            + "  \"country\" : null,\r\n"
            + "  \"createdTime\" : 0,\r\n"
            + "  \"email\" : null,\r\n"
            + "  \"externalId\" : null,\r\n"
            + "  \"id\" : null,\r\n"
            + "  \"name\" : null,\r\n"
            + "  \"phone\" : null,\r\n"
            + "  \"state\" : null,\r\n"
            + "  \"tenantId\" : null,\r\n"
            + "  \"title\" : null,\r\n"
            + "  \"version\" : null,\r\n"
            + "  \"zip\" : null\r\n"
            + "}",
        JacksonUtil.toPrettyString(new Customer()));
  }

  /**
   * Test {@link JacksonUtil#toPrettyString(Object)}.
   *
   * <ul>
   *   <li>When {@link Dashboard#Dashboard()}.
   *   <li>Then return a string.
   * </ul>
   *
   * <p>Method under test: {@link JacksonUtil#toPrettyString(Object)}
   */
  @Test
  @DisplayName("Test toPrettyString(Object); when Dashboard(); then return a string")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String JacksonUtil.toPrettyString(Object)"})
  void testToPrettyString_whenDashboard_thenReturnAString() {
    // Arrange, Act and Assert
    assertEquals(
        "{\r\n"
            + "  \"assignedCustomers\" : null,\r\n"
            + "  \"configuration\" : null,\r\n"
            + "  \"createdTime\" : 0,\r\n"
            + "  \"externalId\" : null,\r\n"
            + "  \"id\" : null,\r\n"
            + "  \"image\" : null,\r\n"
            + "  \"mobileHide\" : false,\r\n"
            + "  \"mobileOrder\" : null,\r\n"
            + "  \"name\" : null,\r\n"
            + "  \"tenantId\" : null,\r\n"
            + "  \"title\" : null,\r\n"
            + "  \"version\" : null\r\n"
            + "}",
        JacksonUtil.toPrettyString(new Dashboard()));
  }

  /**
   * Test {@link JacksonUtil#toPrettyString(Object)}.
   *
   * <ul>
   *   <li>When {@link DeviceProfileInfo#DeviceProfileInfo(DeviceProfile)} with profile is {@link
   *       DeviceProfile#DeviceProfile()}.
   * </ul>
   *
   * <p>Method under test: {@link JacksonUtil#toPrettyString(Object)}
   */
  @Test
  @DisplayName(
      "Test toPrettyString(Object); when DeviceProfileInfo(DeviceProfile) with profile is DeviceProfile()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String JacksonUtil.toPrettyString(Object)"})
  void testToPrettyString_whenDeviceProfileInfoWithProfileIsDeviceProfile() {
    // Arrange, Act and Assert
    assertEquals(
        "{\r\n"
            + "  \"defaultDashboardId\" : null,\r\n"
            + "  \"id\" : null,\r\n"
            + "  \"image\" : null,\r\n"
            + "  \"name\" : null,\r\n"
            + "  \"tenantId\" : null,\r\n"
            + "  \"transportType\" : null,\r\n"
            + "  \"type\" : null\r\n"
            + "}",
        JacksonUtil.toPrettyString(new DeviceProfileInfo(new DeviceProfile())));
  }

  /**
   * Test {@link JacksonUtil#toPrettyString(Object)}.
   *
   * <ul>
   *   <li>When {@link DeviceProfile#DeviceProfile()}.
   *   <li>Then return a string.
   * </ul>
   *
   * <p>Method under test: {@link JacksonUtil#toPrettyString(Object)}
   */
  @Test
  @DisplayName("Test toPrettyString(Object); when DeviceProfile(); then return a string")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String JacksonUtil.toPrettyString(Object)"})
  void testToPrettyString_whenDeviceProfile_thenReturnAString() {
    // Arrange, Act and Assert
    assertEquals(
        "{\r\n"
            + "  \"createdTime\" : 0,\r\n"
            + "  \"default\" : false,\r\n"
            + "  \"defaultDashboardId\" : null,\r\n"
            + "  \"defaultEdgeRuleChainId\" : null,\r\n"
            + "  \"defaultQueueName\" : null,\r\n"
            + "  \"defaultRuleChainId\" : null,\r\n"
            + "  \"description\" : null,\r\n"
            + "  \"externalId\" : null,\r\n"
            + "  \"firmwareId\" : null,\r\n"
            + "  \"id\" : null,\r\n"
            + "  \"image\" : null,\r\n"
            + "  \"name\" : null,\r\n"
            + "  \"profileData\" : null,\r\n"
            + "  \"provisionDeviceKey\" : null,\r\n"
            + "  \"provisionType\" : null,\r\n"
            + "  \"softwareId\" : null,\r\n"
            + "  \"tenantId\" : null,\r\n"
            + "  \"transportType\" : null,\r\n"
            + "  \"type\" : null,\r\n"
            + "  \"version\" : null\r\n"
            + "}",
        JacksonUtil.toPrettyString(new DeviceProfile()));
  }

  /**
   * Test {@link JacksonUtil#toPrettyString(Object)}.
   *
   * <ul>
   *   <li>When {@link EntityView#EntityView()}.
   *   <li>Then return a string.
   * </ul>
   *
   * <p>Method under test: {@link JacksonUtil#toPrettyString(Object)}
   */
  @Test
  @DisplayName("Test toPrettyString(Object); when EntityView(); then return a string")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String JacksonUtil.toPrettyString(Object)"})
  void testToPrettyString_whenEntityView_thenReturnAString() {
    // Arrange, Act and Assert
    assertEquals(
        "{\r\n"
            + "  \"customerId\" : null,\r\n"
            + "  \"endTimeMs\" : 0,\r\n"
            + "  \"entityId\" : null,\r\n"
            + "  \"externalId\" : null,\r\n"
            + "  \"keys\" : null,\r\n"
            + "  \"name\" : null,\r\n"
            + "  \"startTimeMs\" : 0,\r\n"
            + "  \"tenantId\" : null,\r\n"
            + "  \"type\" : null,\r\n"
            + "  \"version\" : null,\r\n"
            + "  \"additionalInfo\" : null,\r\n"
            + "  \"createdTime\" : 0,\r\n"
            + "  \"id\" : null\r\n"
            + "}",
        JacksonUtil.toPrettyString(new EntityView()));
  }

  /**
   * Test {@link JacksonUtil#toPrettyString(Object)}.
   *
   * <ul>
   *   <li>When {@code null}.
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link JacksonUtil#toPrettyString(Object)}
   */
  @Test
  @DisplayName("Test toPrettyString(Object); when 'null'; then return 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String JacksonUtil.toPrettyString(Object)"})
  void testToPrettyString_whenNull_thenReturnNull() {
    // Arrange, Act and Assert
    assertEquals("null", JacksonUtil.toPrettyString(null));
  }

  /**
   * Test {@link JacksonUtil#toPrettyString(Object)}.
   *
   * <ul>
   *   <li>When {@link OtaPackage#OtaPackage()}.
   *   <li>Then return a string.
   * </ul>
   *
   * <p>Method under test: {@link JacksonUtil#toPrettyString(Object)}
   */
  @Test
  @DisplayName("Test toPrettyString(Object); when OtaPackage(); then return a string")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String JacksonUtil.toPrettyString(Object)"})
  void testToPrettyString_whenOtaPackage_thenReturnAString() {
    // Arrange, Act and Assert
    assertEquals(
        "{\r\n"
            + "  \"additionalInfo\" : null,\r\n"
            + "  \"checksum\" : null,\r\n"
            + "  \"checksumAlgorithm\" : null,\r\n"
            + "  \"contentType\" : null,\r\n"
            + "  \"createdTime\" : 0,\r\n"
            + "  \"data\" : null,\r\n"
            + "  \"dataSize\" : null,\r\n"
            + "  \"deviceProfileId\" : null,\r\n"
            + "  \"fileName\" : null,\r\n"
            + "  \"hasData\" : false,\r\n"
            + "  \"id\" : null,\r\n"
            + "  \"tag\" : null,\r\n"
            + "  \"tenantId\" : null,\r\n"
            + "  \"title\" : null,\r\n"
            + "  \"type\" : null,\r\n"
            + "  \"url\" : null,\r\n"
            + "  \"version\" : null\r\n"
            + "}",
        JacksonUtil.toPrettyString(new OtaPackage()));
  }

  /**
   * Test {@link JacksonUtil#toPrettyString(Object)}.
   *
   * <ul>
   *   <li>When {@link TbResource#TbResource()}.
   *   <li>Then return a string.
   * </ul>
   *
   * <p>Method under test: {@link JacksonUtil#toPrettyString(Object)}
   */
  @Test
  @DisplayName("Test toPrettyString(Object); when TbResource(); then return a string")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String JacksonUtil.toPrettyString(Object)"})
  void testToPrettyString_whenTbResource_thenReturnAString() {
    // Arrange, Act and Assert
    assertEquals(
        "{\r\n"
            + "  \"createdTime\" : 0,\r\n"
            + "  \"data\" : null,\r\n"
            + "  \"descriptor\" : null,\r\n"
            + "  \"etag\" : null,\r\n"
            + "  \"externalId\" : null,\r\n"
            + "  \"fileName\" : null,\r\n"
            + "  \"id\" : null,\r\n"
            + "  \"link\" : null,\r\n"
            + "  \"name\" : null,\r\n"
            + "  \"preview\" : null,\r\n"
            + "  \"public\" : false,\r\n"
            + "  \"publicLink\" : null,\r\n"
            + "  \"publicResourceKey\" : null,\r\n"
            + "  \"resourceKey\" : null,\r\n"
            + "  \"resourceSubType\" : null,\r\n"
            + "  \"resourceType\" : null,\r\n"
            + "  \"tenantId\" : null,\r\n"
            + "  \"title\" : null\r\n"
            + "}",
        JacksonUtil.toPrettyString(new TbResource()));
  }

  /**
   * Test {@link JacksonUtil#toPrettyString(Object)}.
   *
   * <ul>
   *   <li>When {@link TenantProfile#TenantProfile()}.
   *   <li>Then return a string.
   * </ul>
   *
   * <p>Method under test: {@link JacksonUtil#toPrettyString(Object)}
   */
  @Test
  @DisplayName("Test toPrettyString(Object); when TenantProfile(); then return a string")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String JacksonUtil.toPrettyString(Object)"})
  void testToPrettyString_whenTenantProfile_thenReturnAString() {
    // Arrange, Act and Assert
    assertEquals(
        "{\r\n"
            + "  \"createdTime\" : 0,\r\n"
            + "  \"default\" : false,\r\n"
            + "  \"description\" : null,\r\n"
            + "  \"id\" : null,\r\n"
            + "  \"isolatedTbRuleEngine\" : false,\r\n"
            + "  \"name\" : null,\r\n"
            + "  \"profileData\" : {\r\n"
            + "    \"configuration\" : {\r\n"
            + "      \"type\" : \"DEFAULT\",\r\n"
            + "      \"alarmsTtlDays\" : 0,\r\n"
            + "      \"cassandraQueryTenantRateLimitsConfiguration\" : null,\r\n"
            + "      \"customerServerRestLimitsConfiguration\" : null,\r\n"
            + "      \"defaultStorageTtlDays\" : 0,\r\n"
            + "      \"edgeEventRateLimits\" : null,\r\n"
            + "      \"edgeEventRateLimitsPerEdge\" : null,\r\n"
            + "      \"edgeUplinkMessagesRateLimits\" : null,\r\n"
            + "      \"edgeUplinkMessagesRateLimitsPerEdge\" : null,\r\n"
            + "      \"maxAssets\" : 0,\r\n"
            + "      \"maxCreatedAlarms\" : 0,\r\n"
            + "      \"maxCustomers\" : 0,\r\n"
            + "      \"maxDPStorageDays\" : 0,\r\n"
            + "      \"maxDashboards\" : 0,\r\n"
            + "      \"maxDevices\" : 0,\r\n"
            + "      \"maxEmails\" : 0,\r\n"
            + "      \"maxJSExecutions\" : 0,\r\n"
            + "      \"maxOtaPackagesInBytes\" : 0,\r\n"
            + "      \"maxREExecutions\" : 0,\r\n"
            + "      \"maxResourceSize\" : 0,\r\n"
            + "      \"maxResourcesInBytes\" : 0,\r\n"
            + "      \"maxRuleChains\" : 0,\r\n"
            + "      \"maxRuleNodeExecutionsPerMessage\" : 0,\r\n"
            + "      \"maxSms\" : 0,\r\n"
            + "      \"maxTbelExecutions\" : 0,\r\n"
            + "      \"maxTransportDataPoints\" : 0,\r\n"
            + "      \"maxTransportMessages\" : 0,\r\n"
            + "      \"maxUsers\" : 0,\r\n"
            + "      \"maxWsSessionsPerCustomer\" : 0,\r\n"
            + "      \"maxWsSessionsPerPublicUser\" : 0,\r\n"
            + "      \"maxWsSessionsPerRegularUser\" : 0,\r\n"
            + "      \"maxWsSessionsPerTenant\" : 0,\r\n"
            + "      \"maxWsSubscriptionsPerCustomer\" : 0,\r\n"
            + "      \"maxWsSubscriptionsPerPublicUser\" : 0,\r\n"
            + "      \"maxWsSubscriptionsPerRegularUser\" : 0,\r\n"
            + "      \"maxWsSubscriptionsPerTenant\" : 0,\r\n"
            + "      \"queueStatsTtlDays\" : 0,\r\n"
            + "      \"rpcTtlDays\" : 0,\r\n"
            + "      \"ruleEngineExceptionsTtlDays\" : 0,\r\n"
            + "      \"smsEnabled\" : null,\r\n"
            + "      \"tenantEntityExportRateLimit\" : null,\r\n"
            + "      \"tenantEntityImportRateLimit\" : null,\r\n"
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
            + "      \"transportTenantTelemetryMsgRateLimit\" : null,\r\n"
            + "      \"warnThreshold\" : 0.0,\r\n"
            + "      \"wsMsgQueueLimitPerSession\" : 0,\r\n"
            + "      \"wsUpdatesPerSessionRateLimit\" : null\r\n"
            + "    },\r\n"
            + "    \"queueConfiguration\" : null\r\n"
            + "  }\r\n"
            + "}",
        JacksonUtil.toPrettyString(new TenantProfile()));
  }

  /**
   * Test {@link JacksonUtil#toPlainText(String)}.
   *
   * <ul>
   *   <li>When {@code Data}.
   *   <li>Then return {@code Data}.
   * </ul>
   *
   * <p>Method under test: {@link JacksonUtil#toPlainText(String)}
   */
  @Test
  @DisplayName("Test toPlainText(String); when 'Data'; then return 'Data'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String JacksonUtil.toPlainText(String)"})
  void testToPlainText_whenData_thenReturnData() {
    // Arrange, Act and Assert
    assertEquals("Data", JacksonUtil.toPlainText("Data"));
  }

  /**
   * Test {@link JacksonUtil#toPlainText(String)}.
   *
   * <ul>
   *   <li>When {@code "Data}.
   *   <li>Then return {@code "Data}.
   * </ul>
   *
   * <p>Method under test: {@link JacksonUtil#toPlainText(String)}
   */
  @Test
  @DisplayName("Test toPlainText(String); when '\"Data'; then return '\"Data'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String JacksonUtil.toPlainText(String)"})
  void testToPlainText_whenData_thenReturnData2() {
    // Arrange, Act and Assert
    assertEquals("\"Data", JacksonUtil.toPlainText("\"Data"));
  }

  /**
   * Test {@link JacksonUtil#toPlainText(String)}.
   *
   * <ul>
   *   <li>When {@code null}.
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link JacksonUtil#toPlainText(String)}
   */
  @Test
  @DisplayName("Test toPlainText(String); when 'null'; then return 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String JacksonUtil.toPlainText(String)"})
  void testToPlainText_whenNull_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull(JacksonUtil.toPlainText(null));
  }

  /**
   * Test {@link JacksonUtil#toPlainText(String)}.
   *
   * <ul>
   *   <li>When {@code """}.
   * </ul>
   *
   * <p>Method under test: {@link JacksonUtil#toPlainText(String)}
   */
  @Test
  @DisplayName("Test toPlainText(String); when '\"\"\"'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String JacksonUtil.toPlainText(String)"})
  void testToPlainText_whenQuotationMarkQuotationMarkQuotationMark() {
    // Arrange, Act and Assert
    assertEquals("", JacksonUtil.toPlainText("\"\"\""));
  }

  /**
   * Test {@link JacksonUtil#toPlainText(String)}.
   *
   * <ul>
   *   <li>When {@code ""}.
   *   <li>Then return empty string.
   * </ul>
   *
   * <p>Method under test: {@link JacksonUtil#toPlainText(String)}
   */
  @Test
  @DisplayName("Test toPlainText(String); when '\"\"'; then return empty string")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String JacksonUtil.toPlainText(String)"})
  void testToPlainText_whenQuotationMarkQuotationMark_thenReturnEmptyString() {
    // Arrange, Act and Assert
    assertEquals("", JacksonUtil.toPlainText("\"\""));
  }

  /**
   * Test {@link JacksonUtil#toPlainText(String)}.
   *
   * <ul>
   *   <li>When {@code "}.
   *   <li>Then return {@code "}.
   * </ul>
   *
   * <p>Method under test: {@link JacksonUtil#toPlainText(String)}
   */
  @Test
  @DisplayName("Test toPlainText(String); when '\"'; then return '\"'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String JacksonUtil.toPlainText(String)"})
  void testToPlainText_whenQuotationMark_thenReturnQuotationMark() {
    // Arrange, Act and Assert
    assertEquals("\"", JacksonUtil.toPlainText("\""));
  }

  /**
   * Test {@link JacksonUtil#treeToValue(JsonNode, Class)}.
   *
   * <ul>
   *   <li>Given empty string.
   * </ul>
   *
   * <p>Method under test: {@link JacksonUtil#treeToValue(JsonNode, Class)}
   */
  @Test
  @DisplayName("Test treeToValue(JsonNode, Class); given empty string")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Object JacksonUtil.treeToValue(JsonNode, Class)"})
  void testTreeToValue_givenEmptyString() {
    // Arrange
    JsonNodeFactory nf = JsonNodeFactory.withExactBigDecimals(true);

    ArrayNode node = new ArrayNode(nf);
    node.add("");
    node.add(MissingNode.getInstance());
    Class<Object> clazz = Object.class;

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> JacksonUtil.treeToValue(node, clazz));
  }

  /**
   * Test {@link JacksonUtil#treeToValue(JsonNode, Class)}.
   *
   * <ul>
   *   <li>Given empty string.
   *   <li>Then return first is empty string.
   * </ul>
   *
   * <p>Method under test: {@link JacksonUtil#treeToValue(JsonNode, Class)}
   */
  @Test
  @DisplayName(
      "Test treeToValue(JsonNode, Class); given empty string; then return first is empty string")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Object JacksonUtil.treeToValue(JsonNode, Class)"})
  void testTreeToValue_givenEmptyString_thenReturnFirstIsEmptyString() {
    // Arrange
    JsonNodeFactory nf = JsonNodeFactory.withExactBigDecimals(true);

    ArrayNode node = new ArrayNode(nf);
    node.add("");
    node.add(DoubleNode.valueOf(10.0d));
    Class<Object> clazz = Object.class;

    // Act
    Object actualTreeToValueResult = JacksonUtil.treeToValue(node, clazz);

    // Assert
    assertTrue(actualTreeToValueResult instanceof List);
    assertEquals(2, ((List<Object>) actualTreeToValueResult).size());
    assertEquals("", ((List<Object>) actualTreeToValueResult).get(0));
    assertEquals(10.0d, ((Double) ((List<Object>) actualTreeToValueResult).get(1)).doubleValue());
  }

  /**
   * Test {@link JacksonUtil#treeToValue(JsonNode, Class)}.
   *
   * <ul>
   *   <li>Given Instance.
   * </ul>
   *
   * <p>Method under test: {@link JacksonUtil#treeToValue(JsonNode, Class)}
   */
  @Test
  @DisplayName("Test treeToValue(JsonNode, Class); given Instance")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Object JacksonUtil.treeToValue(JsonNode, Class)"})
  void testTreeToValue_givenInstance() {
    // Arrange
    JsonNodeFactory nf = JsonNodeFactory.withExactBigDecimals(true);

    ArrayNode node = new ArrayNode(nf);
    node.add(MissingNode.getInstance());
    Class<Object> clazz = Object.class;

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> JacksonUtil.treeToValue(node, clazz));
  }

  /**
   * Test {@link JacksonUtil#treeToValue(JsonNode, Class)}.
   *
   * <ul>
   *   <li>Given {@code Pojo}.
   * </ul>
   *
   * <p>Method under test: {@link JacksonUtil#treeToValue(JsonNode, Class)}
   */
  @Test
  @DisplayName("Test treeToValue(JsonNode, Class); given 'Pojo'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Object JacksonUtil.treeToValue(JsonNode, Class)"})
  void testTreeToValue_givenPojo() {
    // Arrange
    JsonNodeFactory nf = JsonNodeFactory.withExactBigDecimals(true);

    ArrayNode node = new ArrayNode(nf);
    node.addPOJO("Pojo");
    node.add(MissingNode.getInstance());
    Class<Object> clazz = Object.class;

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> JacksonUtil.treeToValue(node, clazz));
  }

  /**
   * Test {@link JacksonUtil#treeToValue(JsonNode, Class)}.
   *
   * <ul>
   *   <li>Given {@code Pojo}.
   *   <li>Then return first is {@code Pojo}.
   * </ul>
   *
   * <p>Method under test: {@link JacksonUtil#treeToValue(JsonNode, Class)}
   */
  @Test
  @DisplayName("Test treeToValue(JsonNode, Class); given 'Pojo'; then return first is 'Pojo'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Object JacksonUtil.treeToValue(JsonNode, Class)"})
  void testTreeToValue_givenPojo_thenReturnFirstIsPojo() {
    // Arrange
    JsonNodeFactory nf = JsonNodeFactory.withExactBigDecimals(true);

    ArrayNode node = new ArrayNode(nf);
    node.addPOJO("Pojo");
    node.add(DoubleNode.valueOf(10.0d));
    Class<Object> clazz = Object.class;

    // Act
    Object actualTreeToValueResult = JacksonUtil.treeToValue(node, clazz);

    // Assert
    assertTrue(actualTreeToValueResult instanceof List);
    assertEquals(2, ((List<Object>) actualTreeToValueResult).size());
    assertEquals("Pojo", ((List<Object>) actualTreeToValueResult).get(0));
    assertEquals(10.0d, ((Double) ((List<Object>) actualTreeToValueResult).get(1)).doubleValue());
  }

  /**
   * Test {@link JacksonUtil#treeToValue(JsonNode, Class)}.
   *
   * <ul>
   *   <li>Given valueOf ten.
   *   <li>Then return size is one.
   * </ul>
   *
   * <p>Method under test: {@link JacksonUtil#treeToValue(JsonNode, Class)}
   */
  @Test
  @DisplayName("Test treeToValue(JsonNode, Class); given valueOf ten; then return size is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Object JacksonUtil.treeToValue(JsonNode, Class)"})
  void testTreeToValue_givenValueOfTen_thenReturnSizeIsOne() {
    // Arrange
    JsonNodeFactory nf = JsonNodeFactory.withExactBigDecimals(true);

    ArrayNode node = new ArrayNode(nf);
    node.add(DoubleNode.valueOf(10.0d));
    Class<Object> clazz = Object.class;

    // Act
    Object actualTreeToValueResult = JacksonUtil.treeToValue(node, clazz);

    // Assert
    assertTrue(actualTreeToValueResult instanceof List);
    assertEquals(1, ((List<Double>) actualTreeToValueResult).size());
    assertEquals(10.0d, ((List<Double>) actualTreeToValueResult).get(0).doubleValue());
  }

  /**
   * Test {@link JacksonUtil#treeToValue(JsonNode, Class)}.
   *
   * <ul>
   *   <li>Then first return {@link Map}.
   * </ul>
   *
   * <p>Method under test: {@link JacksonUtil#treeToValue(JsonNode, Class)}
   */
  @Test
  @DisplayName("Test treeToValue(JsonNode, Class); then first return Map")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Object JacksonUtil.treeToValue(JsonNode, Class)"})
  void testTreeToValue_thenFirstReturnMap() {
    // Arrange
    JsonNodeFactory nf = JsonNodeFactory.withExactBigDecimals(true);

    ArrayNode node = new ArrayNode(nf);
    node.addObject();
    node.add(DoubleNode.valueOf(10.0d));
    Class<Object> clazz = Object.class;

    // Act
    Object actualTreeToValueResult = JacksonUtil.treeToValue(node, clazz);

    // Assert
    assertTrue(actualTreeToValueResult instanceof List);
    assertEquals(2, ((List<Object>) actualTreeToValueResult).size());
    Object getResult = ((List<Object>) actualTreeToValueResult).get(0);
    assertTrue(getResult instanceof Map);
    assertEquals(10.0d, ((Double) ((List<Object>) actualTreeToValueResult).get(1)).doubleValue());
    assertTrue(((Map<Object, Object>) getResult).isEmpty());
  }

  /**
   * Test {@link JacksonUtil#treeToValue(JsonNode, Class)}.
   *
   * <ul>
   *   <li>When {@link ArrayNode#ArrayNode(JsonNodeFactory)} with nf is withExactBigDecimals {@code
   *       true} addObject.
   * </ul>
   *
   * <p>Method under test: {@link JacksonUtil#treeToValue(JsonNode, Class)}
   */
  @Test
  @DisplayName(
      "Test treeToValue(JsonNode, Class); when ArrayNode(JsonNodeFactory) with nf is withExactBigDecimals 'true' addObject")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Object JacksonUtil.treeToValue(JsonNode, Class)"})
  void testTreeToValue_whenArrayNodeWithNfIsWithExactBigDecimalsTrueAddObject() {
    // Arrange
    JsonNodeFactory nf = JsonNodeFactory.withExactBigDecimals(true);

    ArrayNode node = new ArrayNode(nf);
    node.addObject();
    node.add(MissingNode.getInstance());
    Class<Object> clazz = Object.class;

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> JacksonUtil.treeToValue(node, clazz));
  }

  /**
   * Test {@link JacksonUtil#treeToValue(JsonNode, Class)}.
   *
   * <ul>
   *   <li>When {@link ArrayNode#ArrayNode(JsonNodeFactory)} with nf is withExactBigDecimals {@code
   *       true}.
   *   <li>Then return Empty.
   * </ul>
   *
   * <p>Method under test: {@link JacksonUtil#treeToValue(JsonNode, Class)}
   */
  @Test
  @DisplayName(
      "Test treeToValue(JsonNode, Class); when ArrayNode(JsonNodeFactory) with nf is withExactBigDecimals 'true'; then return Empty")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Object JacksonUtil.treeToValue(JsonNode, Class)"})
  void testTreeToValue_whenArrayNodeWithNfIsWithExactBigDecimalsTrue_thenReturnEmpty() {
    // Arrange
    JsonNodeFactory nf = JsonNodeFactory.withExactBigDecimals(true);
    ArrayNode node = new ArrayNode(nf);
    Class<Object> clazz = Object.class;

    // Act
    Object actualTreeToValueResult = JacksonUtil.treeToValue(node, clazz);

    // Assert
    assertTrue(actualTreeToValueResult instanceof List);
    assertTrue(((List<Object>) actualTreeToValueResult).isEmpty());
  }

  /**
   * Test {@link JacksonUtil#treeToValue(JsonNode, Class)}.
   *
   * <ul>
   *   <li>When {@link BigDecimal#BigDecimal(String)} with {@code 2.3}.
   *   <li>Then does not throw.
   * </ul>
   *
   * <p>Method under test: {@link JacksonUtil#treeToValue(JsonNode, Class)}
   */
  @Test
  @DisplayName(
      "Test treeToValue(JsonNode, Class); when BigDecimal(String) with '2.3'; then does not throw")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Object JacksonUtil.treeToValue(JsonNode, Class)"})
  void testTreeToValue_whenBigDecimalWith23_thenDoesNotThrow() {
    // Arrange
    DecimalNode node = new DecimalNode(new BigDecimal("2.3"));
    Class<Object> clazz = Object.class;

    // Act
    assertDoesNotThrow(() -> JacksonUtil.treeToValue(node, clazz));
  }

  /**
   * Test {@link JacksonUtil#treeToValue(JsonNode, Class)}.
   *
   * <ul>
   *   <li>When {@link BigIntegerNode#BigIntegerNode(BigInteger)} with v is valueOf forty-two.
   *   <li>Then return {@link BigInteger}.
   * </ul>
   *
   * <p>Method under test: {@link JacksonUtil#treeToValue(JsonNode, Class)}
   */
  @Test
  @DisplayName(
      "Test treeToValue(JsonNode, Class); when BigIntegerNode(BigInteger) with v is valueOf forty-two; then return BigInteger")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Object JacksonUtil.treeToValue(JsonNode, Class)"})
  void testTreeToValue_whenBigIntegerNodeWithVIsValueOfFortyTwo_thenReturnBigInteger() {
    // Arrange
    BigInteger v = BigInteger.valueOf(42L);
    BigIntegerNode node = new BigIntegerNode(v);
    Class<Object> clazz = Object.class;

    // Act
    Object actualTreeToValueResult = JacksonUtil.treeToValue(node, clazz);

    // Assert
    assertTrue(actualTreeToValueResult instanceof BigInteger);
    assertEquals("42", actualTreeToValueResult.toString());
    BigInteger sqrtResult = ((BigInteger) actualTreeToValueResult).sqrt();
    assertEquals("6", sqrtResult.toString());
    assertEquals(1, sqrtResult.getLowestSetBit());
    assertEquals(1, ((BigInteger) actualTreeToValueResult).getLowestSetBit());
    assertEquals(1, sqrtResult.signum());
    assertEquals(1, ((BigInteger) actualTreeToValueResult).signum());
    BigInteger expectedSqrtResult = ((BigInteger) actualTreeToValueResult).TWO;
    assertEquals(expectedSqrtResult, sqrtResult.sqrt());
  }

  /**
   * Test {@link JacksonUtil#treeToValue(JsonNode, Class)}.
   *
   * <ul>
   *   <li>When False.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link JacksonUtil#treeToValue(JsonNode, Class)}
   */
  @Test
  @DisplayName("Test treeToValue(JsonNode, Class); when False; then return 'false'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
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
   *
   * <ul>
   *   <li>When Instance.
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link JacksonUtil#treeToValue(JsonNode, Class)}
   */
  @Test
  @DisplayName("Test treeToValue(JsonNode, Class); when Instance; then return 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
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
   *
   * <ul>
   *   <li>When Instance.
   *   <li>Then throw {@link IllegalArgumentException}.
   * </ul>
   *
   * <p>Method under test: {@link JacksonUtil#treeToValue(JsonNode, Class)}
   */
  @Test
  @DisplayName(
      "Test treeToValue(JsonNode, Class); when Instance; then throw IllegalArgumentException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
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
   *
   * <ul>
   *   <li>When {@code null}.
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link JacksonUtil#treeToValue(JsonNode, Class)}
   */
  @Test
  @DisplayName("Test treeToValue(JsonNode, Class); when 'null'; then return 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Object JacksonUtil.treeToValue(JsonNode, Class)"})
  void testTreeToValue_whenNull_thenReturnNull() {
    // Arrange
    Class<Object> clazz = Object.class;

    // Act and Assert
    assertNull(JacksonUtil.treeToValue(null, clazz));
  }

  /**
   * Test {@link JacksonUtil#treeToValue(JsonNode, Class)}.
   *
   * <ul>
   *   <li>When {@link POJONode#POJONode(Object)} with v is {@code 42}.
   *   <li>Then return {@code 42}.
   * </ul>
   *
   * <p>Method under test: {@link JacksonUtil#treeToValue(JsonNode, Class)}
   */
  @Test
  @DisplayName(
      "Test treeToValue(JsonNode, Class); when POJONode(Object) with v is '42'; then return '42'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
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
   *
   * <ul>
   *   <li>When {@link POJONode#POJONode(Object)} with v is {@code null}.
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link JacksonUtil#treeToValue(JsonNode, Class)}
   */
  @Test
  @DisplayName(
      "Test treeToValue(JsonNode, Class); when POJONode(Object) with v is 'null'; then return 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
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
   *
   * <ul>
   *   <li>When True.
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link JacksonUtil#treeToValue(JsonNode, Class)}
   */
  @Test
  @DisplayName("Test treeToValue(JsonNode, Class); when True; then return 'true'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
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
   *
   * <ul>
   *   <li>When valueOf ten.
   *   <li>Then return doubleValue is ten.
   * </ul>
   *
   * <p>Method under test: {@link JacksonUtil#treeToValue(JsonNode, Class)}
   */
  @Test
  @DisplayName(
      "Test treeToValue(JsonNode, Class); when valueOf ten; then return doubleValue is ten")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
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
   *
   * <ul>
   *   <li>When valueOf ten.
   *   <li>Then return floatValue is ten.
   * </ul>
   *
   * <p>Method under test: {@link JacksonUtil#treeToValue(JsonNode, Class)}
   */
  @Test
  @DisplayName("Test treeToValue(JsonNode, Class); when valueOf ten; then return floatValue is ten")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
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
   *
   * <ul>
   *   <li>Then throw {@link IllegalArgumentException}.
   * </ul>
   *
   * <p>Method under test: {@link JacksonUtil#toJsonNode(File)}
   */
  @Test
  @DisplayName("Test toJsonNode(File) with 'File'; then throw IllegalArgumentException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"JsonNode JacksonUtil.toJsonNode(File)"})
  void testToJsonNodeWithFile_thenThrowIllegalArgumentException() {
    // Arrange, Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () ->
            JacksonUtil.toJsonNode(
                Paths.get(System.getProperty("java.io.tmpdir"), "foo").toFile()));
  }

  /**
   * Test {@link JacksonUtil#toJsonNode(File)} with {@code File}.
   *
   * <ul>
   *   <li>When {@code null}.
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link JacksonUtil#toJsonNode(File)}
   */
  @Test
  @DisplayName("Test toJsonNode(File) with 'File'; when 'null'; then return 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"JsonNode JacksonUtil.toJsonNode(File)"})
  void testToJsonNodeWithFile_whenNull_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull(JacksonUtil.toJsonNode((File) null));
  }

  /**
   * Test {@link JacksonUtil#toJsonNode(InputStream)} with {@code InputStream}.
   *
   * <p>Method under test: {@link JacksonUtil#toJsonNode(InputStream)}
   */
  @Test
  @DisplayName("Test toJsonNode(InputStream) with 'InputStream'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"JsonNode JacksonUtil.toJsonNode(InputStream)"})
  void testToJsonNodeWithInputStream() {
    // Arrange
    ByteArrayInputStream value =
        new ByteArrayInputStream(new byte[] {0, 'X', 'A', 'X', 'A', 'X', 'A', 'X'});

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> JacksonUtil.toJsonNode(value));
  }

  /**
   * Test {@link JacksonUtil#toJsonNode(InputStream)} with {@code InputStream}.
   *
   * <p>Method under test: {@link JacksonUtil#toJsonNode(InputStream)}
   */
  @Test
  @DisplayName("Test toJsonNode(InputStream) with 'InputStream'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"JsonNode JacksonUtil.toJsonNode(InputStream)"})
  void testToJsonNodeWithInputStream2() {
    // Arrange
    ByteArrayInputStream value =
        new ByteArrayInputStream(new byte[] {Byte.MAX_VALUE, 'X', 'A', 'X', 'A', 'X', 'A', 'X'});

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> JacksonUtil.toJsonNode(value));
  }

  /**
   * Test {@link JacksonUtil#toJsonNode(InputStream)} with {@code InputStream}.
   *
   * <p>Method under test: {@link JacksonUtil#toJsonNode(InputStream)}
   */
  @Test
  @DisplayName("Test toJsonNode(InputStream) with 'InputStream'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"JsonNode JacksonUtil.toJsonNode(InputStream)"})
  void testToJsonNodeWithInputStream3() {
    // Arrange
    ByteArrayInputStream value =
        new ByteArrayInputStream(new byte[] {'A', 0, 'A', 'X', 'A', 'X', 'A', 'X'});

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> JacksonUtil.toJsonNode(value));
  }

  /**
   * Test {@link JacksonUtil#toJsonNode(InputStream)} with {@code InputStream}.
   *
   * <p>Method under test: {@link JacksonUtil#toJsonNode(InputStream)}
   */
  @Test
  @DisplayName("Test toJsonNode(InputStream) with 'InputStream'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"JsonNode JacksonUtil.toJsonNode(InputStream)"})
  void testToJsonNodeWithInputStream4() {
    // Arrange
    ByteArrayInputStream value =
        new ByteArrayInputStream(new byte[] {'A', -1, 'A', 'X', 'A', 'X', 'A', 'X'});

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> JacksonUtil.toJsonNode(value));
  }

  /**
   * Test {@link JacksonUtil#toJsonNode(InputStream)} with {@code InputStream}.
   *
   * <ul>
   *   <li>Given {@link IllegalArgumentException#IllegalArgumentException()}.
   *   <li>Then calls {@link DataInputStream#read(byte[], int, int)}.
   * </ul>
   *
   * <p>Method under test: {@link JacksonUtil#toJsonNode(InputStream)}
   */
  @Test
  @DisplayName(
      "Test toJsonNode(InputStream) with 'InputStream'; given IllegalArgumentException(); then calls read(byte[], int, int)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"JsonNode JacksonUtil.toJsonNode(InputStream)"})
  void testToJsonNodeWithInputStream_givenIllegalArgumentException_thenCallsRead()
      throws IOException {
    // Arrange
    DataInputStream value = mock(DataInputStream.class);
    when(value.read(Mockito.<byte[]>any(), anyInt(), anyInt()))
        .thenThrow(new IllegalArgumentException());

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> JacksonUtil.toJsonNode(value));
    verify(value).read(isA(byte[].class), eq(0), eq(8000));
  }

  /**
   * Test {@link JacksonUtil#toJsonNode(InputStream)} with {@code InputStream}.
   *
   * <ul>
   *   <li>Given one.
   *   <li>Then calls {@link ObjectInputStream#close()}.
   * </ul>
   *
   * <p>Method under test: {@link JacksonUtil#toJsonNode(InputStream)}
   */
  @Test
  @DisplayName("Test toJsonNode(InputStream) with 'InputStream'; given one; then calls close()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"JsonNode JacksonUtil.toJsonNode(InputStream)"})
  void testToJsonNodeWithInputStream_givenOne_thenCallsClose() throws IOException {
    // Arrange
    ObjectInputStream value = mock(ObjectInputStream.class);
    when(value.read(Mockito.<byte[]>any(), anyInt(), anyInt())).thenReturn(1);
    doNothing().when(value).close();

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> JacksonUtil.toJsonNode(value));
    verify(value).close();
    verify(value, atLeast(1)).read(isA(byte[].class), anyInt(), anyInt());
  }

  /**
   * Test {@link JacksonUtil#toJsonNode(InputStream)} with {@code InputStream}.
   *
   * <ul>
   *   <li>Then return {@link MissingNode}.
   * </ul>
   *
   * <p>Method under test: {@link JacksonUtil#toJsonNode(InputStream)}
   */
  @Test
  @DisplayName("Test toJsonNode(InputStream) with 'InputStream'; then return MissingNode")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"JsonNode JacksonUtil.toJsonNode(InputStream)"})
  void testToJsonNodeWithInputStream_thenReturnMissingNode() {
    // Arrange
    ByteArrayInputStream value = new ByteArrayInputStream(new byte[] {});

    // Act
    JsonNode actualToJsonNodeResult = JacksonUtil.toJsonNode(value);

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
   *
   * <ul>
   *   <li>When {@link ByteArrayInputStream#ByteArrayInputStream(byte[])} with {@code AXAXAXAX}
   *       Bytes is {@code UTF-8}.
   * </ul>
   *
   * <p>Method under test: {@link JacksonUtil#toJsonNode(InputStream)}
   */
  @Test
  @DisplayName(
      "Test toJsonNode(InputStream) with 'InputStream'; when ByteArrayInputStream(byte[]) with 'AXAXAXAX' Bytes is 'UTF-8'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"JsonNode JacksonUtil.toJsonNode(InputStream)"})
  void testToJsonNodeWithInputStream_whenByteArrayInputStreamWithAxaxaxaxBytesIsUtf8()
      throws UnsupportedEncodingException {
    // Arrange, Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () -> JacksonUtil.toJsonNode(new ByteArrayInputStream("AXAXAXAX".getBytes("UTF-8"))));
  }

  /**
   * Test {@link JacksonUtil#toJsonNode(InputStream)} with {@code InputStream}.
   *
   * <ul>
   *   <li>When {@link ByteArrayInputStream#ByteArrayInputStream(byte[])} with {@code XXAXAXAX}
   *       Bytes is {@code UTF-8}.
   * </ul>
   *
   * <p>Method under test: {@link JacksonUtil#toJsonNode(InputStream)}
   */
  @Test
  @DisplayName(
      "Test toJsonNode(InputStream) with 'InputStream'; when ByteArrayInputStream(byte[]) with 'XXAXAXAX' Bytes is 'UTF-8'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"JsonNode JacksonUtil.toJsonNode(InputStream)"})
  void testToJsonNodeWithInputStream_whenByteArrayInputStreamWithXxaxaxaxBytesIsUtf8()
      throws UnsupportedEncodingException {
    // Arrange, Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () -> JacksonUtil.toJsonNode(new ByteArrayInputStream("XXAXAXAX".getBytes("UTF-8"))));
  }

  /**
   * Test {@link JacksonUtil#toJsonNode(InputStream)} with {@code InputStream}.
   *
   * <ul>
   *   <li>When {@code null}.
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link JacksonUtil#toJsonNode(InputStream)}
   */
  @Test
  @DisplayName("Test toJsonNode(InputStream) with 'InputStream'; when 'null'; then return 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"JsonNode JacksonUtil.toJsonNode(InputStream)"})
  void testToJsonNodeWithInputStream_whenNull_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull(JacksonUtil.toJsonNode((InputStream) null));
  }

  /**
   * Test {@link JacksonUtil#toJsonNode(String, ObjectMapper)} with {@code String}, {@code
   * ObjectMapper}.
   *
   * <ul>
   *   <li>When builder findAndAddModules build.
   * </ul>
   *
   * <p>Method under test: {@link JacksonUtil#toJsonNode(String, ObjectMapper)}
   */
  @Test
  @DisplayName(
      "Test toJsonNode(String, ObjectMapper) with 'String', 'ObjectMapper'; when builder findAndAddModules build")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"JsonNode JacksonUtil.toJsonNode(String, ObjectMapper)"})
  void testToJsonNodeWithStringObjectMapper_whenBuilderFindAndAddModulesBuild() {
    // Arrange
    JsonMapper mapper = JsonMapper.builder().findAndAddModules().build();

    // Act
    JsonNode actualToJsonNodeResult = JacksonUtil.toJsonNode("42", mapper);

    // Assert
    assertTrue(actualToJsonNodeResult instanceof IntNode);
    assertTrue(actualToJsonNodeResult.traverse() instanceof TreeTraversingParser);
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
   * Test {@link JacksonUtil#toJsonNode(String, ObjectMapper)} with {@code String}, {@code
   * ObjectMapper}.
   *
   * <ul>
   *   <li>When {@link JacksonUtil#IGNORE_UNKNOWN_PROPERTIES_JSON_MAPPER}.
   * </ul>
   *
   * <p>Method under test: {@link JacksonUtil#toJsonNode(String, ObjectMapper)}
   */
  @Test
  @DisplayName(
      "Test toJsonNode(String, ObjectMapper) with 'String', 'ObjectMapper'; when IGNORE_UNKNOWN_PROPERTIES_JSON_MAPPER")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"JsonNode JacksonUtil.toJsonNode(String, ObjectMapper)"})
  void testToJsonNodeWithStringObjectMapper_whenIgnore_unknown_properties_json_mapper() {
    // Arrange and Act
    JsonNode actualToJsonNodeResult =
        JacksonUtil.toJsonNode("42", JacksonUtil.IGNORE_UNKNOWN_PROPERTIES_JSON_MAPPER);

    // Assert
    assertTrue(actualToJsonNodeResult instanceof IntNode);
    assertTrue(actualToJsonNodeResult.traverse() instanceof TreeTraversingParser);
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
   * Test {@link JacksonUtil#toJsonNode(String, ObjectMapper)} with {@code String}, {@code
   * ObjectMapper}.
   *
   * <ul>
   *   <li>When {@link ObjectMapper#ObjectMapper()}.
   *   <li>Then return {@link IntNode}.
   * </ul>
   *
   * <p>Method under test: {@link JacksonUtil#toJsonNode(String, ObjectMapper)}
   */
  @Test
  @DisplayName(
      "Test toJsonNode(String, ObjectMapper) with 'String', 'ObjectMapper'; when ObjectMapper(); then return IntNode")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"JsonNode JacksonUtil.toJsonNode(String, ObjectMapper)"})
  void testToJsonNodeWithStringObjectMapper_whenObjectMapper_thenReturnIntNode() {
    // Arrange and Act
    JsonNode actualToJsonNodeResult = JacksonUtil.toJsonNode("42", new ObjectMapper());

    // Assert
    assertTrue(actualToJsonNodeResult instanceof IntNode);
    assertTrue(actualToJsonNodeResult.traverse() instanceof TreeTraversingParser);
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
   * Test {@link JacksonUtil#toJsonNode(String, ObjectMapper)} with {@code String}, {@code
   * ObjectMapper}.
   *
   * <ul>
   *   <li>When {@link JacksonUtil#OBJECT_MAPPER}.
   *   <li>Then return {@link IntNode}.
   * </ul>
   *
   * <p>Method under test: {@link JacksonUtil#toJsonNode(String, ObjectMapper)}
   */
  @Test
  @DisplayName(
      "Test toJsonNode(String, ObjectMapper) with 'String', 'ObjectMapper'; when OBJECT_MAPPER; then return IntNode")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"JsonNode JacksonUtil.toJsonNode(String, ObjectMapper)"})
  void testToJsonNodeWithStringObjectMapper_whenObject_mapper_thenReturnIntNode() {
    // Arrange and Act
    JsonNode actualToJsonNodeResult = JacksonUtil.toJsonNode("42", JacksonUtil.OBJECT_MAPPER);

    // Assert
    assertTrue(actualToJsonNodeResult instanceof IntNode);
    assertTrue(actualToJsonNodeResult.traverse() instanceof TreeTraversingParser);
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
   * Test {@link JacksonUtil#toJsonNode(String)} with {@code String}.
   *
   * <ul>
   *   <li>When {@code 42Value}.
   *   <li>Then throw {@link IllegalArgumentException}.
   * </ul>
   *
   * <p>Method under test: {@link JacksonUtil#toJsonNode(String)}
   */
  @Test
  @DisplayName(
      "Test toJsonNode(String) with 'String'; when '42Value'; then throw IllegalArgumentException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"JsonNode JacksonUtil.toJsonNode(String)"})
  void testToJsonNodeWithString_when42Value_thenThrowIllegalArgumentException() {
    // Arrange, Act and Assert
    assertThrows(IllegalArgumentException.class, () -> JacksonUtil.toJsonNode("42Value"));
  }

  /**
   * Test {@link JacksonUtil#toJsonNode(String)} with {@code String}.
   *
   * <ul>
   *   <li>When {@code 42}.
   *   <li>Then return {@link IntNode}.
   * </ul>
   *
   * <p>Method under test: {@link JacksonUtil#toJsonNode(String)}
   */
  @Test
  @DisplayName("Test toJsonNode(String) with 'String'; when '42'; then return IntNode")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"JsonNode JacksonUtil.toJsonNode(String)"})
  void testToJsonNodeWithString_when42_thenReturnIntNode() {
    // Arrange and Act
    JsonNode actualToJsonNodeResult = JacksonUtil.toJsonNode("42");

    // Assert
    assertTrue(actualToJsonNodeResult instanceof IntNode);
    assertTrue(actualToJsonNodeResult.traverse() instanceof TreeTraversingParser);
    assertEquals(JsonNodeType.NUMBER, actualToJsonNodeResult.getNodeType());
    assertFalse(actualToJsonNodeResult.isTextual());
    assertFalse(((IntNode) actualToJsonNodeResult).isNaN());
    assertTrue(actualToJsonNodeResult.isInt());
    assertTrue(actualToJsonNodeResult.isIntegralNumber());
    assertTrue(actualToJsonNodeResult.isNumber());
  }

  /**
   * Test {@link JacksonUtil#toJsonNode(String)} with {@code String}.
   *
   * <ul>
   *   <li>When {@code "42"}.
   *   <li>Then return {@link TextNode}.
   * </ul>
   *
   * <p>Method under test: {@link JacksonUtil#toJsonNode(String)}
   */
  @Test
  @DisplayName("Test toJsonNode(String) with 'String'; when '\"42\"'; then return TextNode")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"JsonNode JacksonUtil.toJsonNode(String)"})
  void testToJsonNodeWithString_when42_thenReturnTextNode() {
    // Arrange and Act
    JsonNode actualToJsonNodeResult = JacksonUtil.toJsonNode("\"42\"");

    // Assert
    assertTrue(actualToJsonNodeResult instanceof TextNode);
    assertTrue(actualToJsonNodeResult.traverse() instanceof TreeTraversingParser);
    assertEquals(JsonNodeType.STRING, actualToJsonNodeResult.getNodeType());
    assertFalse(actualToJsonNodeResult.isInt());
    assertFalse(actualToJsonNodeResult.isIntegralNumber());
    assertFalse(actualToJsonNodeResult.isNumber());
    assertTrue(actualToJsonNodeResult.isTextual());
  }

  /**
   * Test {@link JacksonUtil#toJsonNode(String)} with {@code String}.
   *
   * <ul>
   *   <li>When empty string.
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link JacksonUtil#toJsonNode(String)}
   */
  @Test
  @DisplayName("Test toJsonNode(String) with 'String'; when empty string; then return 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"JsonNode JacksonUtil.toJsonNode(String)"})
  void testToJsonNodeWithString_whenEmptyString_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull(JacksonUtil.toJsonNode(""));
  }

  /**
   * Test {@link JacksonUtil#toJsonNode(String)} with {@code String}.
   *
   * <ul>
   *   <li>When {@code null}.
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link JacksonUtil#toJsonNode(String)}
   */
  @Test
  @DisplayName("Test toJsonNode(String) with 'String'; when 'null'; then return 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"JsonNode JacksonUtil.toJsonNode(String)"})
  void testToJsonNodeWithString_whenNull_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull(JacksonUtil.toJsonNode((String) null));
  }

  /**
   * Test {@link JacksonUtil#toJsonNode(String)} with {@code String}.
   *
   * <ul>
   *   <li>When {@code ""}.
   *   <li>Then return {@link TextNode}.
   * </ul>
   *
   * <p>Method under test: {@link JacksonUtil#toJsonNode(String)}
   */
  @Test
  @DisplayName("Test toJsonNode(String) with 'String'; when '\"\"'; then return TextNode")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"JsonNode JacksonUtil.toJsonNode(String)"})
  void testToJsonNodeWithString_whenQuotationMarkQuotationMark_thenReturnTextNode() {
    // Arrange and Act
    JsonNode actualToJsonNodeResult = JacksonUtil.toJsonNode("\"\"");

    // Assert
    assertTrue(actualToJsonNodeResult instanceof TextNode);
    assertTrue(actualToJsonNodeResult.traverse() instanceof TreeTraversingParser);
    assertEquals(JsonNodeType.STRING, actualToJsonNodeResult.getNodeType());
    assertFalse(actualToJsonNodeResult.isInt());
    assertFalse(actualToJsonNodeResult.isIntegralNumber());
    assertFalse(actualToJsonNodeResult.isNumber());
    assertTrue(actualToJsonNodeResult.isTextual());
  }

  /**
   * Test {@link JacksonUtil#toJsonNode(String)} with {@code String}.
   *
   * <ul>
   *   <li>When {@code "}.
   *   <li>Then throw {@link IllegalArgumentException}.
   * </ul>
   *
   * <p>Method under test: {@link JacksonUtil#toJsonNode(String)}
   */
  @Test
  @DisplayName(
      "Test toJsonNode(String) with 'String'; when '\"'; then throw IllegalArgumentException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"JsonNode JacksonUtil.toJsonNode(String)"})
  void testToJsonNodeWithString_whenQuotationMark_thenThrowIllegalArgumentException() {
    // Arrange, Act and Assert
    assertThrows(IllegalArgumentException.class, () -> JacksonUtil.toJsonNode("\""));
  }

  /**
   * Test {@link JacksonUtil#toJsonNode(String)} with {@code String}.
   *
   * <ul>
   *   <li>When {@code Value}.
   *   <li>Then throw {@link IllegalArgumentException}.
   * </ul>
   *
   * <p>Method under test: {@link JacksonUtil#toJsonNode(String)}
   */
  @Test
  @DisplayName(
      "Test toJsonNode(String) with 'String'; when 'Value'; then throw IllegalArgumentException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"JsonNode JacksonUtil.toJsonNode(String)"})
  void testToJsonNodeWithString_whenValue_thenThrowIllegalArgumentException() {
    // Arrange, Act and Assert
    assertThrows(IllegalArgumentException.class, () -> JacksonUtil.toJsonNode("Value"));
  }

  /**
   * Test {@link JacksonUtil#readValue(File, Class)} with {@code File}, {@code Class}.
   *
   * <ul>
   *   <li>Given Property is {@code java.io.tmpdir}.
   * </ul>
   *
   * <p>Method under test: {@link JacksonUtil#readValue(File, Class)}
   */
  @Test
  @DisplayName(
      "Test readValue(File, Class) with 'File', 'Class'; given Property is 'java.io.tmpdir'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Object JacksonUtil.readValue(File, Class)"})
  void testReadValueWithFileClass_givenPropertyIsJavaIoTmpdir() {
    // Arrange
    System.getProperty("java.io.tmpdir");
    Path delegate = Paths.get(System.getProperty("java.io.tmpdir"), "test.txt");
    File file = new WritablePath(delegate, "UTF-8").toFile();
    Class<Object> clazz = Object.class;

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> JacksonUtil.readValue(file, clazz));
  }

  /**
   * Test {@link JacksonUtil#readValue(File, Class)} with {@code File}, {@code Class}.
   *
   * <ul>
   *   <li>When {@code JsonMapper$Builder}.
   * </ul>
   *
   * <p>Method under test: {@link JacksonUtil#readValue(File, Class)}
   */
  @Test
  @DisplayName(
      "Test readValue(File, Class) with 'File', 'Class'; when 'com.fasterxml.jackson.databind.json.JsonMapper$Builder'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Object JacksonUtil.readValue(File, Class)"})
  void testReadValueWithFileClass_whenComFasterxmlJacksonDatabindJsonJsonMapperBuilder() {
    // Arrange
    File file = Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toFile();
    Class<Builder> clazz = Builder.class;

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> JacksonUtil.readValue(file, clazz));
  }

  /**
   * Test {@link JacksonUtil#readValue(File, Class)} with {@code File}, {@code Class}.
   *
   * <ul>
   *   <li>When {@code Object}.
   *   <li>Then throw {@link IllegalArgumentException}.
   * </ul>
   *
   * <p>Method under test: {@link JacksonUtil#readValue(File, Class)}
   */
  @Test
  @DisplayName(
      "Test readValue(File, Class) with 'File', 'Class'; when 'java.lang.Object'; then throw IllegalArgumentException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Object JacksonUtil.readValue(File, Class)"})
  void testReadValueWithFileClass_whenJavaLangObject_thenThrowIllegalArgumentException() {
    // Arrange
    File file = Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toFile();
    Class<Object> clazz = Object.class;

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> JacksonUtil.readValue(file, clazz));
  }

  /**
   * Test {@link JacksonUtil#readValue(File, Class)} with {@code File}, {@code Class}.
   *
   * <ul>
   *   <li>When {@code String}.
   *   <li>Then throw {@link IllegalArgumentException}.
   * </ul>
   *
   * <p>Method under test: {@link JacksonUtil#readValue(File, Class)}
   */
  @Test
  @DisplayName(
      "Test readValue(File, Class) with 'File', 'Class'; when 'java.lang.String'; then throw IllegalArgumentException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Object JacksonUtil.readValue(File, Class)"})
  void testReadValueWithFileClass_whenJavaLangString_thenThrowIllegalArgumentException() {
    // Arrange
    File file = Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toFile();
    Class<String> clazz = String.class;

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> JacksonUtil.readValue(file, clazz));
  }

  /**
   * Test {@link JacksonUtil#readValue(File, Class)} with {@code File}, {@code Class}.
   *
   * <ul>
   *   <li>When Property is {@code java.io.tmpdir} is {@code foo} toFile.
   * </ul>
   *
   * <p>Method under test: {@link JacksonUtil#readValue(File, Class)}
   */
  @Test
  @DisplayName(
      "Test readValue(File, Class) with 'File', 'Class'; when Property is 'java.io.tmpdir' is 'foo' toFile")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Object JacksonUtil.readValue(File, Class)"})
  void testReadValueWithFileClass_whenPropertyIsJavaIoTmpdirIsFooToFile() {
    // Arrange
    File file = Paths.get(System.getProperty("java.io.tmpdir"), "foo").toFile();
    Class<Object> clazz = Object.class;

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> JacksonUtil.readValue(file, clazz));
  }

  /**
   * Test {@link JacksonUtil#readValue(File, TypeReference)} with {@code File}, {@code
   * TypeReference}.
   *
   * <ul>
   *   <li>When Property is {@code java.io.tmpdir} is {@code foo} toFile.
   * </ul>
   *
   * <p>Method under test: {@link JacksonUtil#readValue(File, TypeReference)}
   */
  @Test
  @DisplayName(
      "Test readValue(File, TypeReference) with 'File', 'TypeReference'; when Property is 'java.io.tmpdir' is 'foo' toFile")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Object JacksonUtil.readValue(File, TypeReference)"})
  void testReadValueWithFileTypeReference_whenPropertyIsJavaIoTmpdirIsFooToFile() {
    // Arrange, Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () ->
            JacksonUtil.readValue(
                Paths.get(System.getProperty("java.io.tmpdir"), "foo").toFile(),
                mock(TypeReference.class)));
  }

  /**
   * Test {@link JacksonUtil#readValue(String, CollectionType)} with {@code String}, {@code
   * CollectionType}.
   *
   * <p>Method under test: {@link JacksonUtil#readValue(String, CollectionType)}
   */
  @Test
  @DisplayName("Test readValue(String, CollectionType) with 'String', 'CollectionType'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Object JacksonUtil.readValue(String, CollectionType)"})
  void testReadValueWithStringCollectionType() {
    // Arrange
    CollectionType clazz = mock(CollectionType.class);
    when(clazz.isContainerType()).thenThrow(new IllegalArgumentException());

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> JacksonUtil.readValue("\"", clazz));
    verify(clazz).isContainerType();
  }

  /**
   * Test {@link JacksonUtil#readValue(String, CollectionType)} with {@code String}, {@code
   * CollectionType}.
   *
   * <p>Method under test: {@link JacksonUtil#readValue(String, CollectionType)}
   */
  @Test
  @DisplayName("Test readValue(String, CollectionType) with 'String', 'CollectionType'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Object JacksonUtil.readValue(String, CollectionType)"})
  void testReadValueWithStringCollectionType2() {
    // Arrange
    CollectionType clazz = mock(CollectionType.class);
    when(clazz.isEnumType()).thenReturn(true);
    when(clazz.getKeyType()).thenReturn(new PlaceholderForType(1));
    when(clazz.getContentType()).thenReturn(new PlaceholderForType(1));
    when(clazz.isAbstract()).thenReturn(true);
    when(clazz.isMapLikeType()).thenReturn(true);
    when(clazz.isContainerType()).thenReturn(true);
    Class<Object> forNameResult = Object.class;
    Mockito.<Class<?>>when(clazz.getRawClass()).thenReturn(forNameResult);

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> JacksonUtil.readValue("\"", clazz));
    verify(clazz, atLeast(1)).getKeyType();
    verify(clazz, atLeast(1)).getRawClass();
    verify(clazz).isAbstract();
    verify(clazz).isEnumType();
    verify(clazz, atLeast(1)).isMapLikeType();
    verify(clazz, atLeast(1)).getContentType();
    verify(clazz, atLeast(1)).isContainerType();
  }

  /**
   * Test {@link JacksonUtil#readValue(String, CollectionType)} with {@code String}, {@code
   * CollectionType}.
   *
   * <p>Method under test: {@link JacksonUtil#readValue(String, CollectionType)}
   */
  @Test
  @DisplayName("Test readValue(String, CollectionType) with 'String', 'CollectionType'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Object JacksonUtil.readValue(String, CollectionType)"})
  void testReadValueWithStringCollectionType3() {
    // Arrange
    ArrayType arrayType = mock(ArrayType.class);
    when(arrayType.getValueHandler()).thenReturn("Value Handler");

    CollectionType clazz = mock(CollectionType.class);
    when(clazz.isEnumType()).thenReturn(true);
    when(clazz.getKeyType()).thenReturn(new PlaceholderForType(1));
    when(clazz.getContentType()).thenReturn(arrayType);
    when(clazz.isAbstract()).thenReturn(true);
    when(clazz.isMapLikeType()).thenReturn(true);
    when(clazz.isContainerType()).thenReturn(false);
    Class<Object> forNameResult = Object.class;
    Mockito.<Class<?>>when(clazz.getRawClass()).thenReturn(forNameResult);

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> JacksonUtil.readValue("\"", clazz));
    verify(clazz, atLeast(1)).getKeyType();
    verify(clazz, atLeast(1)).getRawClass();
    verify(arrayType).getValueHandler();
    verify(clazz).isAbstract();
    verify(clazz).isEnumType();
    verify(clazz, atLeast(1)).isMapLikeType();
    verify(clazz, atLeast(1)).getContentType();
    verify(clazz, atLeast(1)).isContainerType();
  }

  /**
   * Test {@link JacksonUtil#readValue(String, CollectionType)} with {@code String}, {@code
   * CollectionType}.
   *
   * <p>Method under test: {@link JacksonUtil#readValue(String, CollectionType)}
   */
  @Test
  @DisplayName("Test readValue(String, CollectionType) with 'String', 'CollectionType'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Object JacksonUtil.readValue(String, CollectionType)"})
  void testReadValueWithStringCollectionType4() {
    // Arrange
    ArrayType arrayType = mock(ArrayType.class);
    when(arrayType.getValueHandler()).thenReturn("Value Handler");

    CollectionType clazz = mock(CollectionType.class);
    when(clazz.isRecordType()).thenThrow(new IllegalArgumentException());
    when(clazz.isArrayType()).thenReturn(true);
    when(clazz.getContentType()).thenReturn(arrayType);
    when(clazz.isAbstract()).thenReturn(true);
    when(clazz.isContainerType()).thenReturn(true);
    Class<Builder> forNameResult = Builder.class;
    Mockito.<Class<?>>when(clazz.getRawClass()).thenReturn(forNameResult);

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> JacksonUtil.readValue("\"", clazz));
    verify(clazz, atLeast(1)).getRawClass();
    verify(arrayType, atLeast(1)).getValueHandler();
    verify(clazz).isAbstract();
    verify(clazz, atLeast(1)).isArrayType();
    verify(clazz).isRecordType();
    verify(clazz, atLeast(1)).getContentType();
    verify(clazz, atLeast(1)).isContainerType();
  }

  /**
   * Test {@link JacksonUtil#readValue(String, CollectionType)} with {@code String}, {@code
   * CollectionType}.
   *
   * <p>Method under test: {@link JacksonUtil#readValue(String, CollectionType)}
   */
  @Test
  @DisplayName("Test readValue(String, CollectionType) with 'String', 'CollectionType'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Object JacksonUtil.readValue(String, CollectionType)"})
  void testReadValueWithStringCollectionType5() {
    // Arrange
    ArrayType arrayType = mock(ArrayType.class);
    when(arrayType.getValueHandler()).thenReturn("Value Handler");

    CollectionType clazz = mock(CollectionType.class);
    when(clazz.getSuperClass()).thenReturn(new PlaceholderForType(1));
    when(clazz.getBindings()).thenReturn(TypeBindings.emptyBindings());
    when(clazz.hasRawClass(Mockito.<Class<?>>any())).thenReturn(true);
    when(clazz.isConcrete()).thenReturn(true);
    when(clazz.isRecordType()).thenReturn(true);
    when(clazz.isArrayType()).thenReturn(false);
    when(clazz.isEnumType()).thenReturn(true);
    when(clazz.getKeyType()).thenReturn(new PlaceholderForType(1));
    when(clazz.getContentType()).thenReturn(arrayType);
    when(clazz.isAbstract()).thenReturn(true);
    when(clazz.isMapLikeType()).thenReturn(true);
    when(clazz.isContainerType()).thenReturn(true);
    Class<Builder> forNameResult = Builder.class;
    Mockito.<Class<?>>when(clazz.getRawClass()).thenReturn(forNameResult);

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> JacksonUtil.readValue("\"", clazz));
    verify(clazz, atLeast(1)).getKeyType();
    verify(clazz, atLeast(1)).getRawClass();
    verify(arrayType, atLeast(1)).getValueHandler();
    verify(clazz).hasRawClass(isA(Class.class));
    verify(clazz).isAbstract();
    verify(clazz, atLeast(1)).isArrayType();
    verify(clazz).isConcrete();
    verify(clazz, atLeast(1)).isEnumType();
    verify(clazz, atLeast(1)).isMapLikeType();
    verify(clazz, atLeast(1)).isRecordType();
    verify(clazz, atLeast(1)).getContentType();
    verify(clazz, atLeast(1)).isContainerType();
    verify(clazz).getBindings();
    verify(clazz).getSuperClass();
  }

  /**
   * Test {@link JacksonUtil#readValue(String, CollectionType)} with {@code String}, {@code
   * CollectionType}.
   *
   * <p>Method under test: {@link JacksonUtil#readValue(String, CollectionType)}
   */
  @Test
  @DisplayName("Test readValue(String, CollectionType) with 'String', 'CollectionType'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Object JacksonUtil.readValue(String, CollectionType)"})
  void testReadValueWithStringCollectionType6() {
    // Arrange
    ArrayType arrayType = mock(ArrayType.class);
    when(arrayType.getValueHandler()).thenReturn("Value Handler");

    CollectionType clazz = mock(CollectionType.class);
    Class<Object> erasedType = Object.class;
    when(clazz.getSuperClass())
        .thenReturn(new ResolvedRecursiveType(erasedType, TypeBindings.emptyBindings()));
    when(clazz.getBindings()).thenReturn(TypeBindings.emptyBindings());
    when(clazz.hasRawClass(Mockito.<Class<?>>any())).thenReturn(true);
    when(clazz.isConcrete()).thenReturn(true);
    when(clazz.isRecordType()).thenReturn(true);
    when(clazz.isArrayType()).thenReturn(false);
    when(clazz.isEnumType()).thenReturn(true);
    when(clazz.getKeyType()).thenReturn(new PlaceholderForType(1));
    when(clazz.getContentType()).thenReturn(arrayType);
    when(clazz.isAbstract()).thenReturn(true);
    when(clazz.isMapLikeType()).thenReturn(true);
    when(clazz.isContainerType()).thenReturn(true);
    Class<Builder> forNameResult = Builder.class;
    Mockito.<Class<?>>when(clazz.getRawClass()).thenReturn(forNameResult);

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> JacksonUtil.readValue("\"", clazz));
    verify(clazz, atLeast(1)).getKeyType();
    verify(clazz, atLeast(1)).getRawClass();
    verify(arrayType, atLeast(1)).getValueHandler();
    verify(clazz).hasRawClass(isA(Class.class));
    verify(clazz).isAbstract();
    verify(clazz, atLeast(1)).isArrayType();
    verify(clazz).isConcrete();
    verify(clazz, atLeast(1)).isEnumType();
    verify(clazz, atLeast(1)).isMapLikeType();
    verify(clazz, atLeast(1)).isRecordType();
    verify(clazz, atLeast(1)).getContentType();
    verify(clazz, atLeast(1)).isContainerType();
    verify(clazz).getBindings();
    verify(clazz).getSuperClass();
  }

  /**
   * Test {@link JacksonUtil#readValue(String, CollectionType)} with {@code String}, {@code
   * CollectionType}.
   *
   * <ul>
   *   <li>Given {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link JacksonUtil#readValue(String, CollectionType)}
   */
  @Test
  @DisplayName(
      "Test readValue(String, CollectionType) with 'String', 'CollectionType'; given 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Object JacksonUtil.readValue(String, CollectionType)"})
  void testReadValueWithStringCollectionType_givenNull() {
    // Arrange
    CollectionType clazz = mock(CollectionType.class);
    when(clazz.isEnumType()).thenReturn(true);
    when(clazz.getKeyType()).thenReturn(new PlaceholderForType(1));
    when(clazz.getContentType()).thenReturn(null);
    when(clazz.isAbstract()).thenReturn(true);
    when(clazz.isMapLikeType()).thenReturn(true);
    when(clazz.isContainerType()).thenReturn(true);
    Class<Object> forNameResult = Object.class;
    Mockito.<Class<?>>when(clazz.getRawClass()).thenReturn(forNameResult);

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> JacksonUtil.readValue("\"", clazz));
    verify(clazz, atLeast(1)).getKeyType();
    verify(clazz, atLeast(1)).getRawClass();
    verify(clazz).isAbstract();
    verify(clazz).isEnumType();
    verify(clazz, atLeast(1)).isMapLikeType();
    verify(clazz, atLeast(1)).getContentType();
    verify(clazz, atLeast(1)).isContainerType();
  }

  /**
   * Test {@link JacksonUtil#readValue(String, CollectionType)} with {@code String}, {@code
   * CollectionType}.
   *
   * <ul>
   *   <li>Given {@link Object}.
   * </ul>
   *
   * <p>Method under test: {@link JacksonUtil#readValue(String, CollectionType)}
   */
  @Test
  @DisplayName(
      "Test readValue(String, CollectionType) with 'String', 'CollectionType'; given Object")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Object JacksonUtil.readValue(String, CollectionType)"})
  void testReadValueWithStringCollectionType_givenObject() {
    // Arrange
    ArrayType arrayType = mock(ArrayType.class);
    when(arrayType.getValueHandler()).thenReturn("Value Handler");

    CollectionType clazz = mock(CollectionType.class);
    when(clazz.isEnumType()).thenReturn(true);
    when(clazz.getKeyType()).thenReturn(new PlaceholderForType(1));
    when(clazz.getContentType()).thenReturn(arrayType);
    when(clazz.isAbstract()).thenReturn(true);
    when(clazz.isMapLikeType()).thenReturn(true);
    when(clazz.isContainerType()).thenReturn(true);
    Class<Object> forNameResult = Object.class;
    Mockito.<Class<?>>when(clazz.getRawClass()).thenReturn(forNameResult);

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> JacksonUtil.readValue("\"", clazz));
    verify(clazz, atLeast(1)).getKeyType();
    verify(clazz, atLeast(1)).getRawClass();
    verify(arrayType, atLeast(1)).getValueHandler();
    verify(clazz).isAbstract();
    verify(clazz).isEnumType();
    verify(clazz, atLeast(1)).isMapLikeType();
    verify(clazz, atLeast(1)).getContentType();
    verify(clazz, atLeast(1)).isContainerType();
  }

  /**
   * Test {@link JacksonUtil#readValue(String, CollectionType)} with {@code String}, {@code
   * CollectionType}.
   *
   * <ul>
   *   <li>Given {@link Object}.
   *   <li>When {@code 42}.
   *   <li>Then calls {@link CollectionType#getKeyType()}.
   * </ul>
   *
   * <p>Method under test: {@link JacksonUtil#readValue(String, CollectionType)}
   */
  @Test
  @DisplayName(
      "Test readValue(String, CollectionType) with 'String', 'CollectionType'; given Object; when '42'; then calls getKeyType()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Object JacksonUtil.readValue(String, CollectionType)"})
  void testReadValueWithStringCollectionType_givenObject_when42_thenCallsGetKeyType() {
    // Arrange
    ArrayType arrayType = mock(ArrayType.class);
    when(arrayType.getValueHandler()).thenReturn("Value Handler");

    CollectionType clazz = mock(CollectionType.class);
    when(clazz.isEnumType()).thenReturn(true);
    when(clazz.getKeyType()).thenReturn(new PlaceholderForType(1));
    when(clazz.getContentType()).thenReturn(arrayType);
    when(clazz.isAbstract()).thenReturn(true);
    when(clazz.isMapLikeType()).thenReturn(true);
    when(clazz.isContainerType()).thenReturn(true);
    Class<Object> forNameResult = Object.class;
    Mockito.<Class<?>>when(clazz.getRawClass()).thenReturn(forNameResult);

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> JacksonUtil.readValue("42", clazz));
    verify(clazz, atLeast(1)).getKeyType();
    verify(clazz, atLeast(1)).getRawClass();
    verify(arrayType, atLeast(1)).getValueHandler();
    verify(clazz).isAbstract();
    verify(clazz).isEnumType();
    verify(clazz, atLeast(1)).isMapLikeType();
    verify(clazz, atLeast(1)).getContentType();
    verify(clazz, atLeast(1)).isContainerType();
  }

  /**
   * Test {@link JacksonUtil#readValue(String, CollectionType)} with {@code String}, {@code
   * CollectionType}.
   *
   * <ul>
   *   <li>Given {@link Object}.
   *   <li>When empty string.
   * </ul>
   *
   * <p>Method under test: {@link JacksonUtil#readValue(String, CollectionType)}
   */
  @Test
  @DisplayName(
      "Test readValue(String, CollectionType) with 'String', 'CollectionType'; given Object; when empty string")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Object JacksonUtil.readValue(String, CollectionType)"})
  void testReadValueWithStringCollectionType_givenObject_whenEmptyString() {
    // Arrange
    CollectionType clazz = mock(CollectionType.class);
    Class<Object> forNameResult = Object.class;
    Mockito.<Class<?>>when(clazz.getRawClass()).thenReturn(forNameResult);

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> JacksonUtil.readValue("", clazz));
    verify(clazz).getRawClass();
  }

  /**
   * Test {@link JacksonUtil#readValue(String, CollectionType)} with {@code String}, {@code
   * CollectionType}.
   *
   * <ul>
   *   <li>When {@link CollectionType} {@link CollectionType#isArrayType()} return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link JacksonUtil#readValue(String, CollectionType)}
   */
  @Test
  @DisplayName(
      "Test readValue(String, CollectionType) with 'String', 'CollectionType'; when CollectionType isArrayType() return 'true'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Object JacksonUtil.readValue(String, CollectionType)"})
  void testReadValueWithStringCollectionType_whenCollectionTypeIsArrayTypeReturnTrue() {
    // Arrange
    ArrayType arrayType = mock(ArrayType.class);
    when(arrayType.getValueHandler()).thenReturn("Value Handler");

    CollectionType clazz = mock(CollectionType.class);
    when(clazz.isConcrete()).thenReturn(true);
    when(clazz.isRecordType()).thenReturn(true);
    when(clazz.isArrayType()).thenReturn(true);
    when(clazz.isEnumType()).thenReturn(true);
    when(clazz.getKeyType()).thenReturn(new PlaceholderForType(1));
    when(clazz.getContentType()).thenReturn(arrayType);
    when(clazz.isAbstract()).thenReturn(true);
    when(clazz.isMapLikeType()).thenReturn(true);
    when(clazz.isContainerType()).thenReturn(true);
    Class<Builder> forNameResult = Builder.class;
    Mockito.<Class<?>>when(clazz.getRawClass()).thenReturn(forNameResult);

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> JacksonUtil.readValue("\"", clazz));
    verify(clazz, atLeast(1)).getKeyType();
    verify(clazz, atLeast(1)).getRawClass();
    verify(arrayType, atLeast(1)).getValueHandler();
    verify(clazz).isAbstract();
    verify(clazz, atLeast(1)).isArrayType();
    verify(clazz).isConcrete();
    verify(clazz).isEnumType();
    verify(clazz, atLeast(1)).isMapLikeType();
    verify(clazz, atLeast(1)).isRecordType();
    verify(clazz, atLeast(1)).getContentType();
    verify(clazz, atLeast(1)).isContainerType();
  }

  /**
   * Test {@link JacksonUtil#readValue(String, CollectionType)} with {@code String}, {@code
   * CollectionType}.
   *
   * <ul>
   *   <li>When {@link CollectionType} {@link CollectionType#isMapLikeType()} return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link JacksonUtil#readValue(String, CollectionType)}
   */
  @Test
  @DisplayName(
      "Test readValue(String, CollectionType) with 'String', 'CollectionType'; when CollectionType isMapLikeType() return 'false'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Object JacksonUtil.readValue(String, CollectionType)"})
  void testReadValueWithStringCollectionType_whenCollectionTypeIsMapLikeTypeReturnFalse() {
    // Arrange
    ArrayType arrayType = mock(ArrayType.class);
    when(arrayType.getValueHandler()).thenReturn("Value Handler");

    CollectionType clazz = mock(CollectionType.class);
    when(clazz.isEnumType()).thenReturn(true);
    when(clazz.getContentType()).thenReturn(arrayType);
    when(clazz.isAbstract()).thenReturn(true);
    when(clazz.isMapLikeType()).thenReturn(false);
    when(clazz.isContainerType()).thenReturn(true);
    Class<Object> forNameResult = Object.class;
    Mockito.<Class<?>>when(clazz.getRawClass()).thenReturn(forNameResult);

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> JacksonUtil.readValue("\"", clazz));
    verify(clazz, atLeast(1)).getRawClass();
    verify(arrayType, atLeast(1)).getValueHandler();
    verify(clazz).isAbstract();
    verify(clazz).isEnumType();
    verify(clazz, atLeast(1)).isMapLikeType();
    verify(clazz, atLeast(1)).getContentType();
    verify(clazz, atLeast(1)).isContainerType();
  }

  /**
   * Test {@link JacksonUtil#readValue(String, CollectionType)} with {@code String}, {@code
   * CollectionType}.
   *
   * <ul>
   *   <li>When {@code File}.
   * </ul>
   *
   * <p>Method under test: {@link JacksonUtil#readValue(String, CollectionType)}
   */
  @Test
  @DisplayName(
      "Test readValue(String, CollectionType) with 'String', 'CollectionType'; when 'File'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Object JacksonUtil.readValue(String, CollectionType)"})
  void testReadValueWithStringCollectionType_whenFile() {
    // Arrange, Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () -> JacksonUtil.readValue("File", mock(CollectionType.class)));
  }

  /**
   * Test {@link JacksonUtil#newObjectNode()}.
   *
   * <p>Method under test: {@link JacksonUtil#newObjectNode()}
   */
  @Test
  @DisplayName("Test newObjectNode()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ObjectNode JacksonUtil.newObjectNode()"})
  void testNewObjectNode() {
    // Arrange and Act
    ObjectNode actualNewObjectNodeResult = JacksonUtil.newObjectNode();

    // Assert
    assertTrue(actualNewObjectNodeResult.traverse() instanceof TreeTraversingParser);
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
   *
   * <ul>
   *   <li>Then traverse return {@link TreeTraversingParser}.
   * </ul>
   *
   * <p>Method under test: {@link JacksonUtil#newObjectNode(ObjectMapper)}
   */
  @Test
  @DisplayName(
      "Test newObjectNode(ObjectMapper) with 'ObjectMapper'; then traverse return TreeTraversingParser")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ObjectNode JacksonUtil.newObjectNode(ObjectMapper)"})
  void testNewObjectNodeWithObjectMapper_thenTraverseReturnTreeTraversingParser() {
    // Arrange and Act
    ObjectNode actualNewObjectNodeResult =
        JacksonUtil.newObjectNode(JacksonUtil.IGNORE_UNKNOWN_PROPERTIES_JSON_MAPPER);

    // Assert
    assertTrue(actualNewObjectNodeResult.traverse() instanceof TreeTraversingParser);
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
   *
   * <p>Method under test: {@link JacksonUtil#newArrayNode()}
   */
  @Test
  @DisplayName("Test newArrayNode()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ArrayNode JacksonUtil.newArrayNode()"})
  void testNewArrayNode() {
    // Arrange and Act
    ArrayNode actualNewArrayNodeResult = JacksonUtil.newArrayNode();

    // Assert
    assertTrue(actualNewArrayNodeResult.traverse() instanceof TreeTraversingParser);
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
   *
   * <ul>
   *   <li>Then traverse return {@link TreeTraversingParser}.
   * </ul>
   *
   * <p>Method under test: {@link JacksonUtil#newArrayNode(ObjectMapper)}
   */
  @Test
  @DisplayName(
      "Test newArrayNode(ObjectMapper) with 'ObjectMapper'; then traverse return TreeTraversingParser")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ArrayNode JacksonUtil.newArrayNode(ObjectMapper)"})
  void testNewArrayNodeWithObjectMapper_thenTraverseReturnTreeTraversingParser() {
    // Arrange and Act
    ArrayNode actualNewArrayNodeResult =
        JacksonUtil.newArrayNode(JacksonUtil.IGNORE_UNKNOWN_PROPERTIES_JSON_MAPPER);

    // Assert
    assertTrue(actualNewArrayNodeResult.traverse() instanceof TreeTraversingParser);
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
   *
   * <ul>
   *   <li>When {@code 42}.
   *   <li>Then return {@code 42}.
   * </ul>
   *
   * <p>Method under test: {@link JacksonUtil#clone(Object)}
   */
  @Test
  @DisplayName("Test clone(Object) with 'Object'; when '42'; then return '42'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Object JacksonUtil.clone(Object)"})
  void testCloneWithObject_when42_thenReturn42() {
    // Arrange, Act and Assert
    assertEquals("42", JacksonUtil.clone("42"));
  }

  /**
   * Test {@link JacksonUtil#clone(Object)} with {@code Object}.
   *
   * <ul>
   *   <li>When forty-two.
   *   <li>Then return intValue is forty-two.
   * </ul>
   *
   * <p>Method under test: {@link JacksonUtil#clone(Object)}
   */
  @Test
  @DisplayName(
      "Test clone(Object) with 'Object'; when forty-two; then return intValue is forty-two")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Object JacksonUtil.clone(Object)"})
  void testCloneWithObject_whenFortyTwo_thenReturnIntValueIsFortyTwo() {
    // Arrange and Act
    Object actualCloneResult = JacksonUtil.clone(42);

    // Assert
    assertEquals(42, ((Integer) actualCloneResult).intValue());
  }

  /**
   * Test {@link JacksonUtil#clone(Object)} with {@code Object}.
   *
   * <ul>
   *   <li>When one.
   *   <li>Then return intValue is one.
   * </ul>
   *
   * <p>Method under test: {@link JacksonUtil#clone(Object)}
   */
  @Test
  @DisplayName("Test clone(Object) with 'Object'; when one; then return intValue is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Object JacksonUtil.clone(Object)"})
  void testCloneWithObject_whenOne_thenReturnIntValueIsOne() {
    // Arrange and Act
    Object actualCloneResult = JacksonUtil.clone(1);

    // Assert
    assertEquals(1, ((Integer) actualCloneResult).intValue());
  }

  /**
   * Test {@link JacksonUtil#clone(Object)} with {@code Object}.
   *
   * <ul>
   *   <li>When {@code "}.
   *   <li>Then return {@code "}.
   * </ul>
   *
   * <p>Method under test: {@link JacksonUtil#clone(Object)}
   */
  @Test
  @DisplayName("Test clone(Object) with 'Object'; when '\"'; then return '\"'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Object JacksonUtil.clone(Object)"})
  void testCloneWithObject_whenQuotationMark_thenReturnQuotationMark() {
    // Arrange, Act and Assert
    assertEquals("\"", JacksonUtil.clone("\""));
  }

  /**
   * Test {@link JacksonUtil#clone(Object)} with {@code Object}.
   *
   * <ul>
   *   <li>When {@code Value}.
   *   <li>Then return {@code Value}.
   * </ul>
   *
   * <p>Method under test: {@link JacksonUtil#clone(Object)}
   */
  @Test
  @DisplayName("Test clone(Object) with 'Object'; when 'Value'; then return 'Value'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Object JacksonUtil.clone(Object)"})
  void testCloneWithObject_whenValue_thenReturnValue() {
    // Arrange, Act and Assert
    assertEquals("Value", JacksonUtil.clone("Value"));
  }

  /**
   * Test {@link JacksonUtil#valueToTree(Object)}.
   *
   * <ul>
   *   <li>When empty string.
   *   <li>Then return {@link TextNode}.
   * </ul>
   *
   * <p>Method under test: {@link JacksonUtil#valueToTree(Object)}
   */
  @Test
  @DisplayName("Test valueToTree(Object); when empty string; then return TextNode")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"JsonNode JacksonUtil.valueToTree(Object)"})
  void testValueToTree_whenEmptyString_thenReturnTextNode() {
    // Arrange and Act
    JsonNode actualValueToTreeResult = JacksonUtil.valueToTree("");

    // Assert
    assertTrue(actualValueToTreeResult instanceof TextNode);
    assertTrue(actualValueToTreeResult.traverse() instanceof TreeTraversingParser);
    assertEquals(JsonNodeType.STRING, actualValueToTreeResult.getNodeType());
    assertTrue(actualValueToTreeResult.isTextual());
  }

  /**
   * Test {@link JacksonUtil#valueToTree(Object)}.
   *
   * <ul>
   *   <li>When forty-two.
   *   <li>Then return {@link IntNode}.
   * </ul>
   *
   * <p>Method under test: {@link JacksonUtil#valueToTree(Object)}
   */
  @Test
  @DisplayName("Test valueToTree(Object); when forty-two; then return IntNode")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"JsonNode JacksonUtil.valueToTree(Object)"})
  void testValueToTree_whenFortyTwo_thenReturnIntNode() {
    // Arrange and Act
    JsonNode actualValueToTreeResult = JacksonUtil.valueToTree(42);

    // Assert
    assertTrue(actualValueToTreeResult instanceof IntNode);
    assertTrue(actualValueToTreeResult.traverse() instanceof TreeTraversingParser);
    assertEquals(JsonNodeType.NUMBER, actualValueToTreeResult.getNodeType());
    assertFalse(((IntNode) actualValueToTreeResult).isNaN());
    assertTrue(actualValueToTreeResult.isInt());
    assertTrue(actualValueToTreeResult.isIntegralNumber());
    assertTrue(actualValueToTreeResult.isNumber());
  }

  /**
   * Test {@link JacksonUtil#valueToTree(Object)}.
   *
   * <ul>
   *   <li>When {@code null}.
   *   <li>Then return {@link NullNode}.
   * </ul>
   *
   * <p>Method under test: {@link JacksonUtil#valueToTree(Object)}
   */
  @Test
  @DisplayName("Test valueToTree(Object); when 'null'; then return NullNode")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"JsonNode JacksonUtil.valueToTree(Object)"})
  void testValueToTree_whenNull_thenReturnNullNode() {
    // Arrange and Act
    JsonNode actualValueToTreeResult = JacksonUtil.valueToTree(null);

    // Assert
    assertTrue(actualValueToTreeResult instanceof NullNode);
    assertTrue(actualValueToTreeResult.traverse() instanceof TreeTraversingParser);
    assertEquals(JsonNodeType.NULL, actualValueToTreeResult.getNodeType());
    assertTrue(actualValueToTreeResult.isNull());
  }

  /**
   * Test {@link JacksonUtil#valueToTree(Object)}.
   *
   * <ul>
   *   <li>When one.
   *   <li>Then return {@link IntNode}.
   * </ul>
   *
   * <p>Method under test: {@link JacksonUtil#valueToTree(Object)}
   */
  @Test
  @DisplayName("Test valueToTree(Object); when one; then return IntNode")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"JsonNode JacksonUtil.valueToTree(Object)"})
  void testValueToTree_whenOne_thenReturnIntNode() {
    // Arrange and Act
    JsonNode actualValueToTreeResult = JacksonUtil.valueToTree(1);

    // Assert
    assertTrue(actualValueToTreeResult instanceof IntNode);
    assertTrue(actualValueToTreeResult.traverse() instanceof TreeTraversingParser);
    assertEquals(JsonNodeType.NUMBER, actualValueToTreeResult.getNodeType());
    assertFalse(((IntNode) actualValueToTreeResult).isNaN());
    assertTrue(actualValueToTreeResult.isInt());
    assertTrue(actualValueToTreeResult.isIntegralNumber());
    assertTrue(actualValueToTreeResult.isNumber());
  }

  /**
   * Test {@link JacksonUtil#valueToTree(Object)}.
   *
   * <ul>
   *   <li>When {@code Value}.
   *   <li>Then return {@link TextNode}.
   * </ul>
   *
   * <p>Method under test: {@link JacksonUtil#valueToTree(Object)}
   */
  @Test
  @DisplayName("Test valueToTree(Object); when 'Value'; then return TextNode")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"JsonNode JacksonUtil.valueToTree(Object)"})
  void testValueToTree_whenValue_thenReturnTextNode() {
    // Arrange and Act
    JsonNode actualValueToTreeResult = JacksonUtil.valueToTree("Value");

    // Assert
    assertTrue(actualValueToTreeResult instanceof TextNode);
    assertTrue(actualValueToTreeResult.traverse() instanceof TreeTraversingParser);
    assertEquals(JsonNodeType.STRING, actualValueToTreeResult.getNodeType());
    assertTrue(actualValueToTreeResult.isTextual());
  }

  /**
   * Test {@link JacksonUtil#writeValueAsBytes(Object)}.
   *
   * <p>Method under test: {@link JacksonUtil#writeValueAsBytes(Object)}
   */
  @Test
  @DisplayName("Test writeValueAsBytes(Object)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"byte[] JacksonUtil.writeValueAsBytes(Object)"})
  void testWriteValueAsBytes() {
    // Arrange
    BaseData<UUIDBased> baseData = mock(BaseData.class);
    when(baseData.getCreatedTime()).thenReturn(1L);
    when(baseData.getId())
        .thenReturn(new AdminSettingsId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")));

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> JacksonUtil.writeValueAsBytes(baseData));
    verify(baseData).getCreatedTime();
    verify(baseData).getId();
  }

  /**
   * Test {@link JacksonUtil#writeValueAsBytes(Object)}.
   *
   * <p>Method under test: {@link JacksonUtil#writeValueAsBytes(Object)}
   */
  @Test
  @DisplayName("Test writeValueAsBytes(Object)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"byte[] JacksonUtil.writeValueAsBytes(Object)"})
  void testWriteValueAsBytes2() {
    // Arrange
    BaseDataWithAdditionalInfo<UUIDBased> baseDataWithAdditionalInfo =
        mock(BaseDataWithAdditionalInfo.class);
    when(baseDataWithAdditionalInfo.getCreatedTime()).thenReturn(1L);
    when(baseDataWithAdditionalInfo.getId())
        .thenReturn(new AlarmId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")));

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () -> JacksonUtil.writeValueAsBytes(baseDataWithAdditionalInfo));
    verify(baseDataWithAdditionalInfo).getCreatedTime();
    verify(baseDataWithAdditionalInfo).getId();
  }

  /**
   * Test {@link JacksonUtil#writeValueAsBytes(Object)}.
   *
   * <p>Method under test: {@link JacksonUtil#writeValueAsBytes(Object)}
   */
  @Test
  @DisplayName("Test writeValueAsBytes(Object)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"byte[] JacksonUtil.writeValueAsBytes(Object)"})
  void testWriteValueAsBytes3() {
    // Arrange
    BaseDataWithAdditionalInfo<UUIDBased> baseDataWithAdditionalInfo =
        mock(BaseDataWithAdditionalInfo.class);
    when(baseDataWithAdditionalInfo.getCreatedTime()).thenReturn(1L);
    when(baseDataWithAdditionalInfo.getId())
        .thenReturn(new CustomerId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")));

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () -> JacksonUtil.writeValueAsBytes(baseDataWithAdditionalInfo));
    verify(baseDataWithAdditionalInfo).getCreatedTime();
    verify(baseDataWithAdditionalInfo).getId();
  }

  /**
   * Test {@link JacksonUtil#writeValueAsBytes(Object)}.
   *
   * <ul>
   *   <li>Given {@code 42}.
   *   <li>Then return array length is one hundred ten.
   * </ul>
   *
   * <p>Method under test: {@link JacksonUtil#writeValueAsBytes(Object)}
   */
  @Test
  @DisplayName(
      "Test writeValueAsBytes(Object); given '42'; then return array length is one hundred ten")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"byte[] JacksonUtil.writeValueAsBytes(Object)"})
  void testWriteValueAsBytes_given42_thenReturnArrayLengthIsOneHundredTen() {
    // Arrange
    PSKBootstrapClientCredential pskBootstrapClientCredential = new PSKBootstrapClientCredential();
    pskBootstrapClientCredential.setClientPublicKeyOrId("42");
    pskBootstrapClientCredential.setClientSecretKey("EXAMPLEKEYwjalrXUtnFEMI/K7MDENG/bPxRfiCY");

    // Act
    byte[] actualWriteValueAsBytesResult =
        JacksonUtil.writeValueAsBytes(pskBootstrapClientCredential);

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
   *
   * <ul>
   *   <li>Given {@link AdminSettingsId#AdminSettingsId(UUID)} with id is randomUUID.
   * </ul>
   *
   * <p>Method under test: {@link JacksonUtil#writeValueAsBytes(Object)}
   */
  @Test
  @DisplayName("Test writeValueAsBytes(Object); given AdminSettingsId(UUID) with id is randomUUID")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"byte[] JacksonUtil.writeValueAsBytes(Object)"})
  void testWriteValueAsBytes_givenAdminSettingsIdWithIdIsRandomUUID() {
    // Arrange
    BaseData<UUIDBased> baseData = mock(BaseData.class);
    when(baseData.getCreatedTime()).thenReturn(1L);
    when(baseData.getId()).thenReturn(new AdminSettingsId(UUID.randomUUID()));

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> JacksonUtil.writeValueAsBytes(baseData));
    verify(baseData).getCreatedTime();
    verify(baseData).getId();
  }

  /**
   * Test {@link JacksonUtil#writeValueAsBytes(Object)}.
   *
   * <ul>
   *   <li>Given {@link AlarmConditionFilter} (default constructor) Value is forty-two.
   * </ul>
   *
   * <p>Method under test: {@link JacksonUtil#writeValueAsBytes(Object)}
   */
  @Test
  @DisplayName(
      "Test writeValueAsBytes(Object); given AlarmConditionFilter (default constructor) Value is forty-two")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"byte[] JacksonUtil.writeValueAsBytes(Object)"})
  void testWriteValueAsBytes_givenAlarmConditionFilterValueIsFortyTwo() {
    // Arrange
    AlarmConditionFilter alarmConditionFilter = new AlarmConditionFilter();
    alarmConditionFilter.setKey(
        new AlarmConditionFilterKey(AlarmConditionKeyType.ATTRIBUTE, "Key"));
    alarmConditionFilter.setPredicate(mock(KeyFilterPredicate.class));
    alarmConditionFilter.setValue(42);
    alarmConditionFilter.setValueType(EntityKeyValueType.STRING);

    ArrayList<AlarmConditionFilter> condition = new ArrayList<>();
    condition.add(alarmConditionFilter);

    AlarmCondition alarmCondition = new AlarmCondition();
    alarmCondition.setCondition(condition);
    alarmCondition.setSpec(mock(AlarmConditionSpec.class));

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class, () -> JacksonUtil.writeValueAsBytes(alarmCondition));
  }

  /**
   * Test {@link JacksonUtil#writeValueAsBytes(Object)}.
   *
   * <ul>
   *   <li>Given {@link AlarmConditionFilter} (default constructor) Value is {@code Value}.
   * </ul>
   *
   * <p>Method under test: {@link JacksonUtil#writeValueAsBytes(Object)}
   */
  @Test
  @DisplayName(
      "Test writeValueAsBytes(Object); given AlarmConditionFilter (default constructor) Value is 'Value'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"byte[] JacksonUtil.writeValueAsBytes(Object)"})
  void testWriteValueAsBytes_givenAlarmConditionFilterValueIsValue() {
    // Arrange
    AlarmConditionFilter alarmConditionFilter = new AlarmConditionFilter();
    alarmConditionFilter.setKey(
        new AlarmConditionFilterKey(AlarmConditionKeyType.ATTRIBUTE, "Key"));
    alarmConditionFilter.setPredicate(mock(KeyFilterPredicate.class));
    alarmConditionFilter.setValue("Value");
    alarmConditionFilter.setValueType(EntityKeyValueType.STRING);

    ArrayList<AlarmConditionFilter> condition = new ArrayList<>();
    condition.add(alarmConditionFilter);

    AlarmCondition alarmCondition = new AlarmCondition();
    alarmCondition.setCondition(condition);
    alarmCondition.setSpec(mock(AlarmConditionSpec.class));

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class, () -> JacksonUtil.writeValueAsBytes(alarmCondition));
  }

  /**
   * Test {@link JacksonUtil#writeValueAsBytes(Object)}.
   *
   * <ul>
   *   <li>Given {@link AlarmId#AlarmId(UUID)} with id is randomUUID.
   * </ul>
   *
   * <p>Method under test: {@link JacksonUtil#writeValueAsBytes(Object)}
   */
  @Test
  @DisplayName("Test writeValueAsBytes(Object); given AlarmId(UUID) with id is randomUUID")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"byte[] JacksonUtil.writeValueAsBytes(Object)"})
  void testWriteValueAsBytes_givenAlarmIdWithIdIsRandomUUID() {
    // Arrange
    BaseDataWithAdditionalInfo<UUIDBased> baseDataWithAdditionalInfo =
        mock(BaseDataWithAdditionalInfo.class);
    when(baseDataWithAdditionalInfo.getCreatedTime()).thenReturn(1L);
    when(baseDataWithAdditionalInfo.getId()).thenReturn(new AlarmId(UUID.randomUUID()));

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () -> JacksonUtil.writeValueAsBytes(baseDataWithAdditionalInfo));
    verify(baseDataWithAdditionalInfo).getCreatedTime();
    verify(baseDataWithAdditionalInfo).getId();
  }

  /**
   * Test {@link JacksonUtil#writeValueAsBytes(Object)}.
   *
   * <ul>
   *   <li>Given {@link ArrayList#ArrayList()} add {@link KeyFilterPredicate}.
   * </ul>
   *
   * <p>Method under test: {@link JacksonUtil#writeValueAsBytes(Object)}
   */
  @Test
  @DisplayName("Test writeValueAsBytes(Object); given ArrayList() add KeyFilterPredicate")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"byte[] JacksonUtil.writeValueAsBytes(Object)"})
  void testWriteValueAsBytes_givenArrayListAddKeyFilterPredicate() {
    // Arrange
    AlarmConditionFilter alarmConditionFilter = new AlarmConditionFilter();
    alarmConditionFilter.setKey(
        new AlarmConditionFilterKey(AlarmConditionKeyType.ATTRIBUTE, "Key"));
    alarmConditionFilter.setPredicate(mock(KeyFilterPredicate.class));
    alarmConditionFilter.setValue("Value");
    alarmConditionFilter.setValueType(EntityKeyValueType.STRING);

    ArrayList<KeyFilterPredicate> predicates = new ArrayList<>();
    predicates.add(mock(KeyFilterPredicate.class));

    ComplexFilterPredicate predicate = new ComplexFilterPredicate();
    predicate.setOperation(ComplexOperation.AND);
    predicate.setPredicates(predicates);

    AlarmConditionFilter alarmConditionFilter2 = new AlarmConditionFilter();
    alarmConditionFilter2.setKey(
        new AlarmConditionFilterKey(AlarmConditionKeyType.ATTRIBUTE, "Key"));
    alarmConditionFilter2.setPredicate(predicate);
    alarmConditionFilter2.setValue("Value");
    alarmConditionFilter2.setValueType(EntityKeyValueType.NUMERIC);

    ArrayList<AlarmConditionFilter> condition = new ArrayList<>();
    condition.add(alarmConditionFilter2);
    condition.add(alarmConditionFilter);

    AlarmCondition alarmCondition = new AlarmCondition();
    alarmCondition.setCondition(condition);
    alarmCondition.setSpec(mock(AlarmConditionSpec.class));

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class, () -> JacksonUtil.writeValueAsBytes(alarmCondition));
  }

  /**
   * Test {@link JacksonUtil#writeValueAsBytes(Object)}.
   *
   * <ul>
   *   <li>Given {@link ArrayList#ArrayList()}.
   *   <li>When {@link AlarmCondition} (default constructor) Condition is {@link
   *       ArrayList#ArrayList()}.
   * </ul>
   *
   * <p>Method under test: {@link JacksonUtil#writeValueAsBytes(Object)}
   */
  @Test
  @DisplayName(
      "Test writeValueAsBytes(Object); given ArrayList(); when AlarmCondition (default constructor) Condition is ArrayList()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"byte[] JacksonUtil.writeValueAsBytes(Object)"})
  void testWriteValueAsBytes_givenArrayList_whenAlarmConditionConditionIsArrayList() {
    // Arrange
    AlarmCondition alarmCondition = new AlarmCondition();
    alarmCondition.setCondition(new ArrayList<>());
    alarmCondition.setSpec(mock(AlarmConditionSpec.class));

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class, () -> JacksonUtil.writeValueAsBytes(alarmCondition));
  }

  /**
   * Test {@link JacksonUtil#writeValueAsBytes(Object)}.
   *
   * <ul>
   *   <li>Given {@link BooleanFilterPredicate} (default constructor) Operation is {@code EQUAL}.
   * </ul>
   *
   * <p>Method under test: {@link JacksonUtil#writeValueAsBytes(Object)}
   */
  @Test
  @DisplayName(
      "Test writeValueAsBytes(Object); given BooleanFilterPredicate (default constructor) Operation is 'EQUAL'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"byte[] JacksonUtil.writeValueAsBytes(Object)"})
  void testWriteValueAsBytes_givenBooleanFilterPredicateOperationIsEqual() {
    // Arrange
    AlarmConditionFilter alarmConditionFilter = new AlarmConditionFilter();
    alarmConditionFilter.setKey(
        new AlarmConditionFilterKey(AlarmConditionKeyType.ATTRIBUTE, "Key"));
    alarmConditionFilter.setPredicate(mock(KeyFilterPredicate.class));
    alarmConditionFilter.setValue("Value");
    alarmConditionFilter.setValueType(EntityKeyValueType.STRING);

    BooleanFilterPredicate predicate = new BooleanFilterPredicate();
    predicate.setOperation(BooleanOperation.EQUAL);
    FilterPredicateValue<Boolean> value = FilterPredicateValue.fromBoolean(true);
    predicate.setValue(value);

    AlarmConditionFilter alarmConditionFilter2 = new AlarmConditionFilter();
    alarmConditionFilter2.setKey(
        new AlarmConditionFilterKey(AlarmConditionKeyType.ATTRIBUTE, "Key"));
    alarmConditionFilter2.setPredicate(predicate);
    alarmConditionFilter2.setValue("Value");
    alarmConditionFilter2.setValueType(EntityKeyValueType.NUMERIC);

    ArrayList<AlarmConditionFilter> condition = new ArrayList<>();
    condition.add(alarmConditionFilter2);
    condition.add(alarmConditionFilter);

    AlarmCondition alarmCondition = new AlarmCondition();
    alarmCondition.setCondition(condition);
    alarmCondition.setSpec(mock(AlarmConditionSpec.class));

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class, () -> JacksonUtil.writeValueAsBytes(alarmCondition));
  }

  /**
   * Test {@link JacksonUtil#writeValueAsBytes(Object)}.
   *
   * <ul>
   *   <li>Given {@link ComplexFilterPredicate} (default constructor) Operation is {@code AND}.
   * </ul>
   *
   * <p>Method under test: {@link JacksonUtil#writeValueAsBytes(Object)}
   */
  @Test
  @DisplayName(
      "Test writeValueAsBytes(Object); given ComplexFilterPredicate (default constructor) Operation is 'AND'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"byte[] JacksonUtil.writeValueAsBytes(Object)"})
  void testWriteValueAsBytes_givenComplexFilterPredicateOperationIsAnd() {
    // Arrange
    AlarmConditionFilter alarmConditionFilter = new AlarmConditionFilter();
    alarmConditionFilter.setKey(
        new AlarmConditionFilterKey(AlarmConditionKeyType.ATTRIBUTE, "Key"));
    alarmConditionFilter.setPredicate(mock(KeyFilterPredicate.class));
    alarmConditionFilter.setValue("Value");
    alarmConditionFilter.setValueType(EntityKeyValueType.STRING);

    ComplexFilterPredicate predicate = new ComplexFilterPredicate();
    predicate.setOperation(ComplexOperation.AND);
    predicate.setPredicates(new ArrayList<>());

    AlarmConditionFilter alarmConditionFilter2 = new AlarmConditionFilter();
    alarmConditionFilter2.setKey(
        new AlarmConditionFilterKey(AlarmConditionKeyType.ATTRIBUTE, "Key"));
    alarmConditionFilter2.setPredicate(predicate);
    alarmConditionFilter2.setValue("Value");
    alarmConditionFilter2.setValueType(EntityKeyValueType.NUMERIC);

    ArrayList<AlarmConditionFilter> condition = new ArrayList<>();
    condition.add(alarmConditionFilter2);
    condition.add(alarmConditionFilter);

    AlarmCondition alarmCondition = new AlarmCondition();
    alarmCondition.setCondition(condition);
    alarmCondition.setSpec(mock(AlarmConditionSpec.class));

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class, () -> JacksonUtil.writeValueAsBytes(alarmCondition));
  }

  /**
   * Test {@link JacksonUtil#writeValueAsBytes(Object)}.
   *
   * <ul>
   *   <li>Given {@link IllegalArgumentException#IllegalArgumentException()}.
   * </ul>
   *
   * <p>Method under test: {@link JacksonUtil#writeValueAsBytes(Object)}
   */
  @Test
  @DisplayName("Test writeValueAsBytes(Object); given IllegalArgumentException()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"byte[] JacksonUtil.writeValueAsBytes(Object)"})
  void testWriteValueAsBytes_givenIllegalArgumentException() {
    // Arrange
    BaseData<UUIDBased> baseData = mock(BaseData.class);
    when(baseData.getId()).thenThrow(new IllegalArgumentException());

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> JacksonUtil.writeValueAsBytes(baseData));
    verify(baseData).getId();
  }

  /**
   * Test {@link JacksonUtil#writeValueAsBytes(Object)}.
   *
   * <ul>
   *   <li>Given {@link NumericFilterPredicate} (default constructor) Operation is {@code EQUAL}.
   * </ul>
   *
   * <p>Method under test: {@link JacksonUtil#writeValueAsBytes(Object)}
   */
  @Test
  @DisplayName(
      "Test writeValueAsBytes(Object); given NumericFilterPredicate (default constructor) Operation is 'EQUAL'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"byte[] JacksonUtil.writeValueAsBytes(Object)"})
  void testWriteValueAsBytes_givenNumericFilterPredicateOperationIsEqual() {
    // Arrange
    AlarmConditionFilter alarmConditionFilter = new AlarmConditionFilter();
    alarmConditionFilter.setKey(
        new AlarmConditionFilterKey(AlarmConditionKeyType.ATTRIBUTE, "Key"));
    alarmConditionFilter.setPredicate(mock(KeyFilterPredicate.class));
    alarmConditionFilter.setValue("Value");
    alarmConditionFilter.setValueType(EntityKeyValueType.STRING);

    NumericFilterPredicate predicate = new NumericFilterPredicate();
    predicate.setOperation(NumericOperation.EQUAL);
    FilterPredicateValue<Double> value = FilterPredicateValue.fromDouble(10.0d);
    predicate.setValue(value);

    AlarmConditionFilter alarmConditionFilter2 = new AlarmConditionFilter();
    alarmConditionFilter2.setKey(
        new AlarmConditionFilterKey(AlarmConditionKeyType.ATTRIBUTE, "Key"));
    alarmConditionFilter2.setPredicate(predicate);
    alarmConditionFilter2.setValue("Value");
    alarmConditionFilter2.setValueType(EntityKeyValueType.NUMERIC);

    ArrayList<AlarmConditionFilter> condition = new ArrayList<>();
    condition.add(alarmConditionFilter2);
    condition.add(alarmConditionFilter);

    AlarmCondition alarmCondition = new AlarmCondition();
    alarmCondition.setCondition(condition);
    alarmCondition.setSpec(mock(AlarmConditionSpec.class));

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class, () -> JacksonUtil.writeValueAsBytes(alarmCondition));
  }

  /**
   * Test {@link JacksonUtil#writeValueAsBytes(Object)}.
   *
   * <ul>
   *   <li>Then return array length is one hundred eighty-seven.
   * </ul>
   *
   * <p>Method under test: {@link JacksonUtil#writeValueAsBytes(Object)}
   */
  @Test
  @DisplayName(
      "Test writeValueAsBytes(Object); then return array length is one hundred eighty-seven")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"byte[] JacksonUtil.writeValueAsBytes(Object)"})
  void testWriteValueAsBytes_thenReturnArrayLengthIsOneHundredEightySeven() {
    // Arrange
    DurationAlarmConditionSpec durationAlarmConditionSpec = new DurationAlarmConditionSpec();
    durationAlarmConditionSpec.setPredicate(
        new FilterPredicateValue<>(
            42L,
            42L,
            new DynamicValue<>(DynamicValueSourceType.CURRENT_TENANT, "Source Attribute")));
    durationAlarmConditionSpec.setUnit(TimeUnit.NANOSECONDS);

    // Act
    byte[] actualWriteValueAsBytesResult =
        JacksonUtil.writeValueAsBytes(durationAlarmConditionSpec);

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
    assertEquals('l', actualWriteValueAsBytesResult[181]);
    assertEquals('n', actualWriteValueAsBytesResult[171]);
    assertEquals('n', actualWriteValueAsBytesResult[21]);
    assertEquals('r', actualWriteValueAsBytesResult[174]);
    assertEquals('s', actualWriteValueAsBytesResult[182]);
    assertEquals('t', actualWriteValueAsBytesResult[165]);
    assertEquals('t', actualWriteValueAsBytesResult[176]);
    assertEquals('u', actualWriteValueAsBytesResult[164]);
    assertEquals('u', actualWriteValueAsBytesResult[20]);
    assertEquals('}', actualWriteValueAsBytesResult[184]);
    assertEquals('}', actualWriteValueAsBytesResult[186]);
  }

  /**
   * Test {@link JacksonUtil#writeValueAsBytes(Object)}.
   *
   * <ul>
   *   <li>Then return array length is one hundred eleven.
   * </ul>
   *
   * <p>Method under test: {@link JacksonUtil#writeValueAsBytes(Object)}
   */
  @Test
  @DisplayName("Test writeValueAsBytes(Object); then return array length is one hundred eleven")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"byte[] JacksonUtil.writeValueAsBytes(Object)"})
  void testWriteValueAsBytes_thenReturnArrayLengthIsOneHundredEleven() {
    // Arrange and Act
    byte[] actualWriteValueAsBytesResult =
        JacksonUtil.writeValueAsBytes(new DeviceProfileInfo(new DeviceProfile()));

    // Assert
    assertEquals(111, actualWriteValueAsBytesResult.length);
    assertEquals(',', actualWriteValueAsBytesResult[89]);
    assertEquals(':', actualWriteValueAsBytesResult[105]);
    assertEquals(':', actualWriteValueAsBytesResult[21]);
    assertEquals('I', actualWriteValueAsBytesResult[18]);
    assertEquals('T', actualWriteValueAsBytesResult[100]);
    assertEquals('"', actualWriteValueAsBytesResult[104]);
    assertEquals('"', actualWriteValueAsBytesResult[90]);
    assertEquals('a', actualWriteValueAsBytesResult[93]);
    assertEquals('d', actualWriteValueAsBytesResult[19]);
    assertEquals('e', actualWriteValueAsBytesResult[103]);
    assertEquals('l', actualWriteValueAsBytesResult[108]);
    assertEquals('l', actualWriteValueAsBytesResult[109]);
    assertEquals('l', actualWriteValueAsBytesResult[87]);
    assertEquals('l', actualWriteValueAsBytesResult[88]);
    assertEquals('n', actualWriteValueAsBytesResult[106]);
    assertEquals('n', actualWriteValueAsBytesResult[14]);
    assertEquals('n', actualWriteValueAsBytesResult[Short.SIZE]);
    assertEquals('o', actualWriteValueAsBytesResult[97]);
    assertEquals('p', actualWriteValueAsBytesResult[102]);
    assertEquals('p', actualWriteValueAsBytesResult[96]);
    assertEquals('r', actualWriteValueAsBytesResult[92]);
    assertEquals('r', actualWriteValueAsBytesResult[98]);
    assertEquals('s', actualWriteValueAsBytesResult[95]);
    assertEquals('t', actualWriteValueAsBytesResult[12]);
    assertEquals('t', actualWriteValueAsBytesResult[91]);
    assertEquals('t', actualWriteValueAsBytesResult[99]);
    assertEquals('u', actualWriteValueAsBytesResult[107]);
    assertEquals('u', actualWriteValueAsBytesResult[23]);
    assertEquals('u', actualWriteValueAsBytesResult[86]);
    assertEquals('y', actualWriteValueAsBytesResult[101]);
    assertEquals('}', actualWriteValueAsBytesResult[110]);
  }

  /**
   * Test {@link JacksonUtil#writeValueAsBytes(Object)}.
   *
   * <ul>
   *   <li>Then return array length is one hundred five.
   * </ul>
   *
   * <p>Method under test: {@link JacksonUtil#writeValueAsBytes(Object)}
   */
  @Test
  @DisplayName("Test writeValueAsBytes(Object); then return array length is one hundred five")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"byte[] JacksonUtil.writeValueAsBytes(Object)"})
  void testWriteValueAsBytes_thenReturnArrayLengthIsOneHundredFive() {
    // Arrange and Act
    byte[] actualWriteValueAsBytesResult =
        JacksonUtil.writeValueAsBytes(new CoapDeviceTransportConfiguration());

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
    assertEquals('i', actualWriteValueAsBytesResult[86]);
    assertEquals('i', actualWriteValueAsBytesResult[89]);
    assertEquals('i', actualWriteValueAsBytesResult[93]);
    assertEquals('l', actualWriteValueAsBytesResult[102]);
    assertEquals('l', actualWriteValueAsBytesResult[103]);
    assertEquals('m', actualWriteValueAsBytesResult[85]);
    assertEquals('n', actualWriteValueAsBytesResult[100]);
    assertEquals('n', actualWriteValueAsBytesResult[83]);
    assertEquals('n', actualWriteValueAsBytesResult[91]);
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
   *
   * <ul>
   *   <li>Then return array length is seventy-two.
   * </ul>
   *
   * <p>Method under test: {@link JacksonUtil#writeValueAsBytes(Object)}
   */
  @Test
  @DisplayName("Test writeValueAsBytes(Object); then return array length is seventy-two")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"byte[] JacksonUtil.writeValueAsBytes(Object)"})
  void testWriteValueAsBytes_thenReturnArrayLengthIsSeventyTwo() {
    // Arrange and Act
    byte[] actualWriteValueAsBytesResult =
        JacksonUtil.writeValueAsBytes(new PSKBootstrapClientCredential());

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
   *
   * <ul>
   *   <li>Then return array length is three hundred ninety-five.
   * </ul>
   *
   * <p>Method under test: {@link JacksonUtil#writeValueAsBytes(Object)}
   */
  @Test
  @DisplayName(
      "Test writeValueAsBytes(Object); then return array length is three hundred ninety-five")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"byte[] JacksonUtil.writeValueAsBytes(Object)"})
  void testWriteValueAsBytes_thenReturnArrayLengthIsThreeHundredNinetyFive() {
    // Arrange
    ImageDescriptor previewDescriptor = new ImageDescriptor();
    previewDescriptor.setEtag("Etag");
    previewDescriptor.setHeight(1);
    previewDescriptor.setMediaType("text/plain");
    previewDescriptor.setPreviewDescriptor(new ImageDescriptor());
    previewDescriptor.setSize(3L);
    previewDescriptor.setWidth(1);

    ImageDescriptor previewDescriptor2 = new ImageDescriptor();
    previewDescriptor2.setEtag("Etag");
    previewDescriptor2.setHeight(1);
    previewDescriptor2.setMediaType("text/plain");
    previewDescriptor2.setPreviewDescriptor(previewDescriptor);
    previewDescriptor2.setSize(3L);
    previewDescriptor2.setWidth(1);

    ImageDescriptor previewDescriptor3 = new ImageDescriptor();
    previewDescriptor3.setEtag("Etag");
    previewDescriptor3.setHeight(1);
    previewDescriptor3.setMediaType("text/plain");
    previewDescriptor3.setPreviewDescriptor(previewDescriptor2);
    previewDescriptor3.setSize(3L);
    previewDescriptor3.setWidth(1);

    ImageDescriptor imageDescriptor = new ImageDescriptor();
    imageDescriptor.setEtag("Etag");
    imageDescriptor.setHeight(1);
    imageDescriptor.setMediaType("text/plain");
    imageDescriptor.setPreviewDescriptor(previewDescriptor3);
    imageDescriptor.setSize(3L);
    imageDescriptor.setWidth(1);

    // Act
    byte[] actualWriteValueAsBytesResult = JacksonUtil.writeValueAsBytes(imageDescriptor);

    // Assert
    assertEquals(395, actualWriteValueAsBytesResult.length);
    assertEquals(',', actualWriteValueAsBytesResult[370]);
    assertEquals(',', actualWriteValueAsBytesResult[381]);
    assertEquals('/', actualWriteValueAsBytesResult[18]);
    assertEquals('0', actualWriteValueAsBytesResult[380]);
    assertEquals('0', actualWriteValueAsBytesResult[389]);
    assertEquals(':', actualWriteValueAsBytesResult[12]);
    assertEquals(':', actualWriteValueAsBytesResult[379]);
    assertEquals(':', actualWriteValueAsBytesResult[388]);
    assertEquals('T', actualWriteValueAsBytesResult[7]);
    assertEquals('"', actualWriteValueAsBytesResult[371]);
    assertEquals('"', actualWriteValueAsBytesResult[378]);
    assertEquals('"', actualWriteValueAsBytesResult[382]);
    assertEquals('"', actualWriteValueAsBytesResult[387]);
    assertEquals('a', actualWriteValueAsBytesResult[6]);
    assertEquals('d', actualWriteValueAsBytesResult[4]);
    assertEquals('e', actualWriteValueAsBytesResult[10]);
    assertEquals('e', actualWriteValueAsBytesResult[15]);
    assertEquals('e', actualWriteValueAsBytesResult[373]);
    assertEquals('e', actualWriteValueAsBytesResult[386]);
    assertEquals('g', actualWriteValueAsBytesResult[375]);
    assertEquals('h', actualWriteValueAsBytesResult[372]);
    assertEquals('h', actualWriteValueAsBytesResult[376]);
    assertEquals('i', actualWriteValueAsBytesResult[374]);
    assertEquals('i', actualWriteValueAsBytesResult[384]);
    assertEquals('l', actualWriteValueAsBytesResult[20]);
    assertEquals('m', actualWriteValueAsBytesResult[2]);
    assertEquals('n', actualWriteValueAsBytesResult[23]);
    assertEquals('p', actualWriteValueAsBytesResult[19]);
    assertEquals('p', actualWriteValueAsBytesResult[9]);
    assertEquals('s', actualWriteValueAsBytesResult[383]);
    assertEquals('t', actualWriteValueAsBytesResult[14]);
    assertEquals('t', actualWriteValueAsBytesResult[377]);
    assertEquals('x', actualWriteValueAsBytesResult[Short.SIZE]);
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
   *
   * <ul>
   *   <li>Then return one hundred eighty-sixth element is {@code ,}.
   * </ul>
   *
   * <p>Method under test: {@link JacksonUtil#writeValueAsBytes(Object)}
   */
  @Test
  @DisplayName(
      "Test writeValueAsBytes(Object); then return one hundred eighty-sixth element is ','")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"byte[] JacksonUtil.writeValueAsBytes(Object)"})
  void testWriteValueAsBytes_thenReturnOneHundredEightySixthElementIsComma() {
    // Arrange and Act
    byte[] actualWriteValueAsBytesResult = JacksonUtil.writeValueAsBytes(new Dashboard());

    // Assert
    assertEquals(198, actualWriteValueAsBytesResult.length);
    assertEquals(',', actualWriteValueAsBytesResult[185]);
    assertEquals('"', actualWriteValueAsBytesResult[186]);
    assertEquals('a', actualWriteValueAsBytesResult[174]);
    assertEquals('a', actualWriteValueAsBytesResult[188]);
    assertEquals('e', actualWriteValueAsBytesResult[190]);
    assertEquals('i', actualWriteValueAsBytesResult[176]);
    assertEquals('m', actualWriteValueAsBytesResult[189]);
    assertEquals('n', actualWriteValueAsBytesResult[178]);
    assertEquals('n', actualWriteValueAsBytesResult[187]);
    assertEquals('o', actualWriteValueAsBytesResult[177]);
    assertEquals('r', actualWriteValueAsBytesResult[173]);
    assertEquals('t', actualWriteValueAsBytesResult[175]);
  }

  /**
   * Test {@link JacksonUtil#writeValueAsBytes(Object)}.
   *
   * <ul>
   *   <li>Then return one hundred seventy-sixth element is {@code ,}.
   * </ul>
   *
   * <p>Method under test: {@link JacksonUtil#writeValueAsBytes(Object)}
   */
  @Test
  @DisplayName(
      "Test writeValueAsBytes(Object); then return one hundred seventy-sixth element is ','")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"byte[] JacksonUtil.writeValueAsBytes(Object)"})
  void testWriteValueAsBytes_thenReturnOneHundredSeventySixthElementIsComma() {
    // Arrange and Act
    byte[] actualWriteValueAsBytesResult = JacksonUtil.writeValueAsBytes(new EntityView());

    // Assert
    assertEquals(198, actualWriteValueAsBytesResult.length);
    assertEquals(',', actualWriteValueAsBytesResult[175]);
    assertEquals('0', actualWriteValueAsBytesResult[174]);
    assertEquals(':', actualWriteValueAsBytesResult[173]);
    assertEquals('I', actualWriteValueAsBytesResult[187]);
    assertEquals('I', actualWriteValueAsBytesResult[24]);
    assertEquals('"', actualWriteValueAsBytesResult[176]);
    assertEquals('a', actualWriteValueAsBytesResult[177]);
    assertEquals('a', actualWriteValueAsBytesResult[185]);
    assertEquals('d', actualWriteValueAsBytesResult[178]);
    assertEquals('d', actualWriteValueAsBytesResult[179]);
    assertEquals('e', actualWriteValueAsBytesResult[2]);
    assertEquals('f', actualWriteValueAsBytesResult[189]);
    assertEquals('i', actualWriteValueAsBytesResult[180]);
    assertEquals('i', actualWriteValueAsBytesResult[182]);
    assertEquals('l', actualWriteValueAsBytesResult[186]);
    assertEquals('n', actualWriteValueAsBytesResult[184]);
    assertEquals('n', actualWriteValueAsBytesResult[188]);
    assertEquals('n', actualWriteValueAsBytesResult[20]);
    assertEquals('n', actualWriteValueAsBytesResult[3]);
    assertEquals('o', actualWriteValueAsBytesResult[183]);
    assertEquals('o', actualWriteValueAsBytesResult[190]);
    assertEquals('t', actualWriteValueAsBytesResult[18]);
    assertEquals('t', actualWriteValueAsBytesResult[181]);
    assertEquals('t', actualWriteValueAsBytesResult[4]);
    assertEquals('t', actualWriteValueAsBytesResult[6]);
    assertEquals('y', actualWriteValueAsBytesResult[7]);
  }

  /**
   * Test {@link JacksonUtil#writeValueAsBytes(Object)}.
   *
   * <ul>
   *   <li>When {@link AdminSettings#AdminSettings()}.
   *   <li>Then return array length is seventy-one.
   * </ul>
   *
   * <p>Method under test: {@link JacksonUtil#writeValueAsBytes(Object)}
   */
  @Test
  @DisplayName(
      "Test writeValueAsBytes(Object); when AdminSettings(); then return array length is seventy-one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
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
   *
   * <ul>
   *   <li>When {@link Alarm#Alarm()}.
   *   <li>Then return array length is three hundred sixty-nine.
   * </ul>
   *
   * <p>Method under test: {@link JacksonUtil#writeValueAsBytes(Object)}
   */
  @Test
  @DisplayName(
      "Test writeValueAsBytes(Object); when Alarm(); then return array length is three hundred sixty-nine")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"byte[] JacksonUtil.writeValueAsBytes(Object)"})
  void testWriteValueAsBytes_whenAlarm_thenReturnArrayLengthIsThreeHundredSixtyNine() {
    // Arrange and Act
    byte[] actualWriteValueAsBytesResult = JacksonUtil.writeValueAsBytes(new Alarm());

    // Assert
    assertEquals(369, actualWriteValueAsBytesResult.length);
    assertEquals(',', actualWriteValueAsBytesResult[344]);
    assertEquals(':', actualWriteValueAsBytesResult[353]);
    assertEquals('A', actualWriteValueAsBytesResult[355]);
    assertEquals('A', actualWriteValueAsBytesResult[364]);
    assertEquals('C', actualWriteValueAsBytesResult[356]);
    assertEquals('C', actualWriteValueAsBytesResult[365]);
    assertEquals('E', actualWriteValueAsBytesResult[360]);
    assertEquals('I', actualWriteValueAsBytesResult[358]);
    assertEquals('K', actualWriteValueAsBytesResult[366]);
    assertEquals('N', actualWriteValueAsBytesResult[363]);
    assertEquals('T', actualWriteValueAsBytesResult[357]);
    assertEquals('U', actualWriteValueAsBytesResult[362]);
    assertEquals('V', actualWriteValueAsBytesResult[359]);
    assertEquals('"', actualWriteValueAsBytesResult[345]);
    assertEquals('"', actualWriteValueAsBytesResult[352]);
    assertEquals('"', actualWriteValueAsBytesResult[354]);
    assertEquals('"', actualWriteValueAsBytesResult[367]);
    assertEquals('_', actualWriteValueAsBytesResult[361]);
    assertEquals('a', actualWriteValueAsBytesResult[348]);
    assertEquals('a', actualWriteValueAsBytesResult[5]);
    assertEquals('c', actualWriteValueAsBytesResult[18]);
    assertEquals('m', actualWriteValueAsBytesResult[23]);
    assertEquals('n', actualWriteValueAsBytesResult[4]);
    assertEquals('s', actualWriteValueAsBytesResult[20]);
    assertEquals('s', actualWriteValueAsBytesResult[346]);
    assertEquals('s', actualWriteValueAsBytesResult[351]);
    assertEquals('t', actualWriteValueAsBytesResult[21]);
    assertEquals('t', actualWriteValueAsBytesResult[347]);
    assertEquals('t', actualWriteValueAsBytesResult[349]);
    assertEquals('t', actualWriteValueAsBytesResult[7]);
    assertEquals('u', actualWriteValueAsBytesResult[19]);
    assertEquals('u', actualWriteValueAsBytesResult[350]);
    assertEquals('}', actualWriteValueAsBytesResult[368]);
  }

  /**
   * Test {@link JacksonUtil#writeValueAsBytes(Object)}.
   *
   * <ul>
   *   <li>When {@code null}.
   *   <li>Then return {@code null} Bytes is {@code UTF-8}.
   * </ul>
   *
   * <p>Method under test: {@link JacksonUtil#writeValueAsBytes(Object)}
   */
  @Test
  @DisplayName("Test writeValueAsBytes(Object); when 'null'; then return 'null' Bytes is 'UTF-8'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"byte[] JacksonUtil.writeValueAsBytes(Object)"})
  void testWriteValueAsBytes_whenNull_thenReturnNullBytesIsUtf8()
      throws UnsupportedEncodingException {
    // Arrange, Act and Assert
    assertArrayEquals("null".getBytes("UTF-8"), JacksonUtil.writeValueAsBytes(null));
  }

  /**
   * Test {@link JacksonUtil#writeValueAsBytes(Object)}.
   *
   * <ul>
   *   <li>When {@link TenantProfile#TenantProfile()}.
   *   <li>Then return array length is {@code 2023}.
   * </ul>
   *
   * <p>Method under test: {@link JacksonUtil#writeValueAsBytes(Object)}
   */
  @Test
  @DisplayName(
      "Test writeValueAsBytes(Object); when TenantProfile(); then return array length is '2023'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
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
   *
   * <ul>
   *   <li>When {@link ArrayNode#ArrayNode(JsonNodeFactory)} with nf is withExactBigDecimals {@code
   *       true}.
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link JacksonUtil#getSafely(JsonNode, String[])}
   */
  @Test
  @DisplayName(
      "Test getSafely(JsonNode, String[]); when ArrayNode(JsonNodeFactory) with nf is withExactBigDecimals 'true'; then return 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"JsonNode JacksonUtil.getSafely(JsonNode, String[])"})
  void testGetSafely_whenArrayNodeWithNfIsWithExactBigDecimalsTrue_thenReturnNull() {
    // Arrange
    JsonNodeFactory nf = JsonNodeFactory.withExactBigDecimals(true);

    // Act and Assert
    assertNull(JacksonUtil.getSafely(new ArrayNode(nf), "Path"));
  }

  /**
   * Test {@link JacksonUtil#getSafely(JsonNode, String[])}.
   *
   * <ul>
   *   <li>When {@code null}.
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link JacksonUtil#getSafely(JsonNode, String[])}
   */
  @Test
  @DisplayName("Test getSafely(JsonNode, String[]); when 'null'; then return 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"JsonNode JacksonUtil.getSafely(JsonNode, String[])"})
  void testGetSafely_whenNull_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull(JacksonUtil.getSafely(null, "Path"));
  }

  /**
   * Test {@link JacksonUtil#getSafely(JsonNode, String[])}.
   *
   * <ul>
   *   <li>When valueOf ten.
   *   <li>Then return {@link DoubleNode}.
   * </ul>
   *
   * <p>Method under test: {@link JacksonUtil#getSafely(JsonNode, String[])}
   */
  @Test
  @DisplayName("Test getSafely(JsonNode, String[]); when valueOf ten; then return DoubleNode")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"JsonNode JacksonUtil.getSafely(JsonNode, String[])"})
  void testGetSafely_whenValueOfTen_thenReturnDoubleNode() {
    // Arrange and Act
    JsonNode actualSafely = JacksonUtil.getSafely(DoubleNode.valueOf(10.0d));

    // Assert
    assertTrue(actualSafely instanceof DoubleNode);
    assertTrue(actualSafely.traverse() instanceof TreeTraversingParser);
    assertEquals(0, actualSafely.size());
    assertEquals(JsonNodeType.NUMBER, actualSafely.getNodeType());
    assertFalse(actualSafely.isArray());
    assertFalse(actualSafely.isBigDecimal());
    assertFalse(actualSafely.isBigInteger());
    assertFalse(actualSafely.isBinary());
    assertFalse(actualSafely.isBoolean());
    assertFalse(actualSafely.isContainerNode());
    assertFalse(actualSafely.isFloat());
    assertFalse(actualSafely.isInt());
    assertFalse(actualSafely.isIntegralNumber());
    assertFalse(actualSafely.isLong());
    assertFalse(actualSafely.isMissingNode());
    assertFalse(actualSafely.isNull());
    assertFalse(actualSafely.isObject());
    assertFalse(actualSafely.isPojo());
    assertFalse(actualSafely.isShort());
    assertFalse(actualSafely.isTextual());
    assertFalse(((DoubleNode) actualSafely).isNaN());
    assertFalse(actualSafely.iterator().hasNext());
    assertTrue(actualSafely.isDouble());
    assertTrue(actualSafely.isEmpty());
    assertTrue(actualSafely.isFloatingPointNumber());
    assertTrue(actualSafely.isNumber());
    assertTrue(actualSafely.isValueNode());
  }

  /**
   * Test {@link JacksonUtil#getSafely(JsonNode, String[])}.
   *
   * <ul>
   *   <li>When valueOf ten.
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link JacksonUtil#getSafely(JsonNode, String[])}
   */
  @Test
  @DisplayName("Test getSafely(JsonNode, String[]); when valueOf ten; then return 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"JsonNode JacksonUtil.getSafely(JsonNode, String[])"})
  void testGetSafely_whenValueOfTen_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull(JacksonUtil.getSafely(DoubleNode.valueOf(10.0d), "Path"));
  }

  /**
   * Test {@link JacksonUtil#asObject(JsonNode)}.
   *
   * <ul>
   *   <li>When {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link JacksonUtil#asObject(JsonNode)}
   */
  @Test
  @DisplayName("Test asObject(JsonNode); when 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ObjectNode JacksonUtil.asObject(JsonNode)"})
  void testAsObject_whenNull() {
    // Arrange and Act
    ObjectNode actualAsObjectResult = JacksonUtil.asObject(null);

    // Assert
    assertTrue(actualAsObjectResult.traverse() instanceof TreeTraversingParser);
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
   *
   * <ul>
   *   <li>When {@link ObjectNode#ObjectNode(JsonNodeFactory)} with nc is withExactBigDecimals
   *       {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link JacksonUtil#asObject(JsonNode)}
   */
  @Test
  @DisplayName(
      "Test asObject(JsonNode); when ObjectNode(JsonNodeFactory) with nc is withExactBigDecimals 'true'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ObjectNode JacksonUtil.asObject(JsonNode)"})
  void testAsObject_whenObjectNodeWithNcIsWithExactBigDecimalsTrue() {
    // Arrange
    JsonNodeFactory nc = JsonNodeFactory.withExactBigDecimals(true);

    // Act
    ObjectNode actualAsObjectResult = JacksonUtil.asObject(new ObjectNode(nc));

    // Assert
    assertTrue(actualAsObjectResult.traverse() instanceof TreeTraversingParser);
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
   *
   * <ul>
   *   <li>When valueOf ten.
   * </ul>
   *
   * <p>Method under test: {@link JacksonUtil#asObject(JsonNode)}
   */
  @Test
  @DisplayName("Test asObject(JsonNode); when valueOf ten")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ObjectNode JacksonUtil.asObject(JsonNode)"})
  void testAsObject_whenValueOfTen() {
    // Arrange and Act
    ObjectNode actualAsObjectResult = JacksonUtil.asObject(DoubleNode.valueOf(10.0d));

    // Assert
    assertTrue(actualAsObjectResult.traverse() instanceof TreeTraversingParser);
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
   * Test {@link JacksonUtil#replaceUuidsRecursively(JsonNode, Set, Pattern, UnaryOperator,
   * boolean)}.
   *
   * <p>Method under test: {@link JacksonUtil#replaceUuidsRecursively(JsonNode, Set, Pattern,
   * UnaryOperator, boolean)}
   */
  @Test
  @DisplayName("Test replaceUuidsRecursively(JsonNode, Set, Pattern, UnaryOperator, boolean)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void JacksonUtil.replaceUuidsRecursively(JsonNode, Set, Pattern, UnaryOperator, boolean)"
  })
  void testReplaceUuidsRecursively() {
    // Arrange
    JsonNodeFactory nf = JsonNodeFactory.withExactBigDecimals(true);

    ArrayNode node = new ArrayNode(nf);
    node.addArray();
    node.add(DoubleNode.valueOf(10.0d));

    // Act and Assert
    assertDoesNotThrow(
        () ->
            JacksonUtil.replaceUuidsRecursively(
                node, new HashSet<>(), RegexUtils.UUID_PATTERN, mock(UnaryOperator.class), true));
  }

  /**
   * Test {@link JacksonUtil#replaceUuidsRecursively(JsonNode, Set, Pattern, UnaryOperator,
   * boolean)}.
   *
   * <p>Method under test: {@link JacksonUtil#replaceUuidsRecursively(JsonNode, Set, Pattern,
   * UnaryOperator, boolean)}
   */
  @Test
  @DisplayName("Test replaceUuidsRecursively(JsonNode, Set, Pattern, UnaryOperator, boolean)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void JacksonUtil.replaceUuidsRecursively(JsonNode, Set, Pattern, UnaryOperator, boolean)"
  })
  void testReplaceUuidsRecursively2() {
    // Arrange
    JsonNodeFactory nf = JsonNodeFactory.withExactBigDecimals(true);

    ArrayNode node = new ArrayNode(nf);
    node.addObject();
    node.add(DoubleNode.valueOf(10.0d));

    // Act and Assert
    assertDoesNotThrow(
        () ->
            JacksonUtil.replaceUuidsRecursively(
                node, new HashSet<>(), RegexUtils.UUID_PATTERN, mock(UnaryOperator.class), true));
  }

  /**
   * Test {@link JacksonUtil#replaceUuidsRecursively(JsonNode, Set, Pattern, UnaryOperator,
   * boolean)}.
   *
   * <p>Method under test: {@link JacksonUtil#replaceUuidsRecursively(JsonNode, Set, Pattern,
   * UnaryOperator, boolean)}
   */
  @Test
  @DisplayName("Test replaceUuidsRecursively(JsonNode, Set, Pattern, UnaryOperator, boolean)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void JacksonUtil.replaceUuidsRecursively(JsonNode, Set, Pattern, UnaryOperator, boolean)"
  })
  void testReplaceUuidsRecursively3() {
    // Arrange
    JsonNodeFactory nf = JsonNodeFactory.withExactBigDecimals(true);

    ArrayNode node = new ArrayNode(nf);
    node.add("99999999-9999-9999-9999-99999999999999999999-9999-9999-9999-999999999999");
    node.add(DoubleNode.valueOf(10.0d));
    HashSet<String> skippedRootFields = new HashSet<>();

    UnaryOperator<UUID> replacer = mock(UnaryOperator.class);
    when(replacer.apply(Mockito.<UUID>any()))
        .thenReturn(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    // Act
    JacksonUtil.replaceUuidsRecursively(
        node, skippedRootFields, RegexUtils.UUID_PATTERN, replacer, true);

    // Assert
    verify(replacer, atLeast(1)).apply(isA(UUID.class));
  }

  /**
   * Test {@link JacksonUtil#replaceUuidsRecursively(JsonNode, Set, Pattern, UnaryOperator,
   * boolean)}.
   *
   * <ul>
   *   <li>Given {@code 784f394c-42b6-435a-983c-b7beff2784f9}.
   * </ul>
   *
   * <p>Method under test: {@link JacksonUtil#replaceUuidsRecursively(JsonNode, Set, Pattern,
   * UnaryOperator, boolean)}
   */
  @Test
  @DisplayName(
      "Test replaceUuidsRecursively(JsonNode, Set, Pattern, UnaryOperator, boolean); given '784f394c-42b6-435a-983c-b7beff2784f9'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void JacksonUtil.replaceUuidsRecursively(JsonNode, Set, Pattern, UnaryOperator, boolean)"
  })
  void testReplaceUuidsRecursively_given784f394c42b6435a983cB7beff2784f9() {
    // Arrange
    JsonNodeFactory nf = JsonNodeFactory.withExactBigDecimals(true);

    ArrayNode node = new ArrayNode(nf);
    node.add("99999999-9999-9999-9999-999999999999");
    node.add(DoubleNode.valueOf(10.0d));

    HashSet<String> skippedRootFields = new HashSet<>();
    skippedRootFields.add("784f394c-42b6-435a-983c-b7beff2784f9");
    skippedRootFields.add("99999999-9999-9999-9999-999999999999");

    UnaryOperator<UUID> replacer = mock(UnaryOperator.class);
    when(replacer.apply(Mockito.<UUID>any()))
        .thenReturn(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    // Act
    JacksonUtil.replaceUuidsRecursively(
        node, skippedRootFields, RegexUtils.UUID_PATTERN, replacer, true);

    // Assert
    verify(replacer).apply(isA(UUID.class));
  }

  /**
   * Test {@link JacksonUtil#replaceUuidsRecursively(JsonNode, Set, Pattern, UnaryOperator,
   * boolean)}.
   *
   * <ul>
   *   <li>Given {@code 99999999-9999-9999-9999-999999999999}.
   * </ul>
   *
   * <p>Method under test: {@link JacksonUtil#replaceUuidsRecursively(JsonNode, Set, Pattern,
   * UnaryOperator, boolean)}
   */
  @Test
  @DisplayName(
      "Test replaceUuidsRecursively(JsonNode, Set, Pattern, UnaryOperator, boolean); given '99999999-9999-9999-9999-999999999999'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void JacksonUtil.replaceUuidsRecursively(JsonNode, Set, Pattern, UnaryOperator, boolean)"
  })
  void testReplaceUuidsRecursively_given99999999999999999999999999999999() {
    // Arrange
    JsonNodeFactory nf = JsonNodeFactory.withExactBigDecimals(true);

    ArrayNode node = new ArrayNode(nf);
    node.add("99999999-9999-9999-9999-999999999999");
    node.add(DoubleNode.valueOf(10.0d));
    HashSet<String> skippedRootFields = new HashSet<>();

    UnaryOperator<UUID> replacer = mock(UnaryOperator.class);
    when(replacer.apply(Mockito.<UUID>any()))
        .thenReturn(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    // Act
    JacksonUtil.replaceUuidsRecursively(
        node, skippedRootFields, RegexUtils.UUID_PATTERN, replacer, true);

    // Assert
    verify(replacer).apply(isA(UUID.class));
  }

  /**
   * Test {@link JacksonUtil#replaceUuidsRecursively(JsonNode, Set, Pattern, UnaryOperator,
   * boolean)}.
   *
   * <ul>
   *   <li>Given empty string.
   * </ul>
   *
   * <p>Method under test: {@link JacksonUtil#replaceUuidsRecursively(JsonNode, Set, Pattern,
   * UnaryOperator, boolean)}
   */
  @Test
  @DisplayName(
      "Test replaceUuidsRecursively(JsonNode, Set, Pattern, UnaryOperator, boolean); given empty string")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void JacksonUtil.replaceUuidsRecursively(JsonNode, Set, Pattern, UnaryOperator, boolean)"
  })
  void testReplaceUuidsRecursively_givenEmptyString() {
    // Arrange
    JsonNodeFactory nf = JsonNodeFactory.withExactBigDecimals(true);

    ArrayNode node = new ArrayNode(nf);
    node.add("");
    node.add(DoubleNode.valueOf(10.0d));

    // Act and Assert
    assertDoesNotThrow(
        () ->
            JacksonUtil.replaceUuidsRecursively(
                node, new HashSet<>(), RegexUtils.UUID_PATTERN, mock(UnaryOperator.class), true));
  }

  /**
   * Test {@link JacksonUtil#replaceUuidsRecursively(JsonNode, Set, Pattern, UnaryOperator,
   * boolean)}.
   *
   * <ul>
   *   <li>Given Instance.
   * </ul>
   *
   * <p>Method under test: {@link JacksonUtil#replaceUuidsRecursively(JsonNode, Set, Pattern,
   * UnaryOperator, boolean)}
   */
  @Test
  @DisplayName(
      "Test replaceUuidsRecursively(JsonNode, Set, Pattern, UnaryOperator, boolean); given Instance")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void JacksonUtil.replaceUuidsRecursively(JsonNode, Set, Pattern, UnaryOperator, boolean)"
  })
  void testReplaceUuidsRecursively_givenInstance() {
    // Arrange
    JsonNodeFactory nf = JsonNodeFactory.withExactBigDecimals(true);

    ArrayNode node = new ArrayNode(nf);
    node.add("99999999-9999-9999-9999-999999999999");
    node.add(MissingNode.getInstance());
    HashSet<String> skippedRootFields = new HashSet<>();

    UnaryOperator<UUID> replacer = mock(UnaryOperator.class);
    when(replacer.apply(Mockito.<UUID>any()))
        .thenReturn(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    // Act
    JacksonUtil.replaceUuidsRecursively(
        node, skippedRootFields, RegexUtils.UUID_PATTERN, replacer, true);

    // Assert
    verify(replacer).apply(isA(UUID.class));
  }

  /**
   * Test {@link JacksonUtil#replaceUuidsRecursively(JsonNode, Set, Pattern, UnaryOperator,
   * boolean)}.
   *
   * <ul>
   *   <li>Given valueOf ten.
   *   <li>When {@link UnaryOperator}.
   *   <li>Then does not throw.
   * </ul>
   *
   * <p>Method under test: {@link JacksonUtil#replaceUuidsRecursively(JsonNode, Set, Pattern,
   * UnaryOperator, boolean)}
   */
  @Test
  @DisplayName(
      "Test replaceUuidsRecursively(JsonNode, Set, Pattern, UnaryOperator, boolean); given valueOf ten; when UnaryOperator; then does not throw")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void JacksonUtil.replaceUuidsRecursively(JsonNode, Set, Pattern, UnaryOperator, boolean)"
  })
  void testReplaceUuidsRecursively_givenValueOfTen_whenUnaryOperator_thenDoesNotThrow() {
    // Arrange
    JsonNodeFactory nf = JsonNodeFactory.withExactBigDecimals(true);

    ArrayNode node = new ArrayNode(nf);
    node.add(DoubleNode.valueOf(10.0d));

    // Act and Assert
    assertDoesNotThrow(
        () ->
            JacksonUtil.replaceUuidsRecursively(
                node, new HashSet<>(), RegexUtils.UUID_PATTERN, mock(UnaryOperator.class), true));
  }

  /**
   * Test {@link JacksonUtil#replaceUuidsRecursively(JsonNode, Set, Pattern, UnaryOperator,
   * boolean)}.
   *
   * <ul>
   *   <li>Then throw {@link IllegalArgumentException}.
   * </ul>
   *
   * <p>Method under test: {@link JacksonUtil#replaceUuidsRecursively(JsonNode, Set, Pattern,
   * UnaryOperator, boolean)}
   */
  @Test
  @DisplayName(
      "Test replaceUuidsRecursively(JsonNode, Set, Pattern, UnaryOperator, boolean); then throw IllegalArgumentException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void JacksonUtil.replaceUuidsRecursively(JsonNode, Set, Pattern, UnaryOperator, boolean)"
  })
  void testReplaceUuidsRecursively_thenThrowIllegalArgumentException() {
    // Arrange
    JsonNodeFactory nf = JsonNodeFactory.withExactBigDecimals(true);

    ArrayNode node = new ArrayNode(nf);
    node.add("99999999-9999-9999-9999-999999999999");
    node.add(DoubleNode.valueOf(10.0d));
    HashSet<String> skippedRootFields = new HashSet<>();

    UnaryOperator<UUID> replacer = mock(UnaryOperator.class);
    when(replacer.apply(Mockito.<UUID>any())).thenThrow(new IllegalArgumentException());

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () ->
            JacksonUtil.replaceUuidsRecursively(
                node, skippedRootFields, RegexUtils.UUID_PATTERN, replacer, true));
    verify(replacer).apply(isA(UUID.class));
  }

  /**
   * Test {@link JacksonUtil#replaceUuidsRecursively(JsonNode, Set, Pattern, UnaryOperator,
   * boolean)}.
   *
   * <ul>
   *   <li>When {@link ArrayNode#ArrayNode(JsonNodeFactory)} with nf is withExactBigDecimals {@code
   *       true}.
   * </ul>
   *
   * <p>Method under test: {@link JacksonUtil#replaceUuidsRecursively(JsonNode, Set, Pattern,
   * UnaryOperator, boolean)}
   */
  @Test
  @DisplayName(
      "Test replaceUuidsRecursively(JsonNode, Set, Pattern, UnaryOperator, boolean); when ArrayNode(JsonNodeFactory) with nf is withExactBigDecimals 'true'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void JacksonUtil.replaceUuidsRecursively(JsonNode, Set, Pattern, UnaryOperator, boolean)"
  })
  void testReplaceUuidsRecursively_whenArrayNodeWithNfIsWithExactBigDecimalsTrue() {
    // Arrange
    JsonNodeFactory nf = JsonNodeFactory.withExactBigDecimals(true);
    ArrayNode node = new ArrayNode(nf);

    // Act and Assert
    assertDoesNotThrow(
        () ->
            JacksonUtil.replaceUuidsRecursively(
                node, new HashSet<>(), RegexUtils.UUID_PATTERN, mock(UnaryOperator.class), true));
  }

  /**
   * Test {@link JacksonUtil#replaceUuidsRecursively(JsonNode, Set, Pattern, UnaryOperator,
   * boolean)}.
   *
   * <ul>
   *   <li>When {@link HashSet#HashSet()} add {@code 99999999-9999-9999-9999-999999999999}.
   * </ul>
   *
   * <p>Method under test: {@link JacksonUtil#replaceUuidsRecursively(JsonNode, Set, Pattern,
   * UnaryOperator, boolean)}
   */
  @Test
  @DisplayName(
      "Test replaceUuidsRecursively(JsonNode, Set, Pattern, UnaryOperator, boolean); when HashSet() add '99999999-9999-9999-9999-999999999999'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void JacksonUtil.replaceUuidsRecursively(JsonNode, Set, Pattern, UnaryOperator, boolean)"
  })
  void testReplaceUuidsRecursively_whenHashSetAdd99999999999999999999999999999999() {
    // Arrange
    JsonNodeFactory nf = JsonNodeFactory.withExactBigDecimals(true);

    ArrayNode node = new ArrayNode(nf);
    node.add("99999999-9999-9999-9999-999999999999");
    node.add(DoubleNode.valueOf(10.0d));

    HashSet<String> skippedRootFields = new HashSet<>();
    skippedRootFields.add("99999999-9999-9999-9999-999999999999");

    UnaryOperator<UUID> replacer = mock(UnaryOperator.class);
    when(replacer.apply(Mockito.<UUID>any()))
        .thenReturn(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    // Act
    JacksonUtil.replaceUuidsRecursively(
        node, skippedRootFields, RegexUtils.UUID_PATTERN, replacer, true);

    // Assert
    verify(replacer).apply(isA(UUID.class));
  }

  /**
   * Test {@link JacksonUtil#replaceUuidsRecursively(JsonNode, Set, Pattern, UnaryOperator,
   * boolean)}.
   *
   * <ul>
   *   <li>When {@code null}.
   *   <li>Then does not throw.
   * </ul>
   *
   * <p>Method under test: {@link JacksonUtil#replaceUuidsRecursively(JsonNode, Set, Pattern,
   * UnaryOperator, boolean)}
   */
  @Test
  @DisplayName(
      "Test replaceUuidsRecursively(JsonNode, Set, Pattern, UnaryOperator, boolean); when 'null'; then does not throw")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void JacksonUtil.replaceUuidsRecursively(JsonNode, Set, Pattern, UnaryOperator, boolean)"
  })
  void testReplaceUuidsRecursively_whenNull_thenDoesNotThrow() {
    // Arrange, Act and Assert
    assertDoesNotThrow(
        () ->
            JacksonUtil.replaceUuidsRecursively(
                null, new HashSet<>(), RegexUtils.UUID_PATTERN, mock(UnaryOperator.class), true));
  }

  /**
   * Test {@link JacksonUtil#replaceUuidsRecursively(JsonNode, Set, Pattern, UnaryOperator,
   * boolean)}.
   *
   * <ul>
   *   <li>When valueOf ten.
   *   <li>Then does not throw.
   * </ul>
   *
   * <p>Method under test: {@link JacksonUtil#replaceUuidsRecursively(JsonNode, Set, Pattern,
   * UnaryOperator, boolean)}
   */
  @Test
  @DisplayName(
      "Test replaceUuidsRecursively(JsonNode, Set, Pattern, UnaryOperator, boolean); when valueOf ten; then does not throw")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void JacksonUtil.replaceUuidsRecursively(JsonNode, Set, Pattern, UnaryOperator, boolean)"
  })
  void testReplaceUuidsRecursively_whenValueOfTen_thenDoesNotThrow() {
    // Arrange
    DoubleNode node = DoubleNode.valueOf(10.0d);

    // Act and Assert
    assertDoesNotThrow(
        () ->
            JacksonUtil.replaceUuidsRecursively(
                node, new HashSet<>(), RegexUtils.UUID_PATTERN, mock(UnaryOperator.class), true));
  }

  /**
   * Test {@link JacksonUtil#toFlatMap(JsonNode)} with {@code node}.
   *
   * <ul>
   *   <li>When {@code A}.
   *   <li>Then return empty string is {@code QQFBAUEBQQE=}.
   * </ul>
   *
   * <p>Method under test: {@link JacksonUtil#toFlatMap(JsonNode)}
   */
  @Test
  @DisplayName(
      "Test toFlatMap(JsonNode) with 'node'; when 'A'; then return empty string is 'QQFBAUEBQQE='")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Map JacksonUtil.toFlatMap(JsonNode)"})
  void testToFlatMapWithNode_whenA_thenReturnEmptyStringIsQqfbauebqqe() {
    // Arrange
    BinaryNode node = new BinaryNode(new byte[] {'A', 1, 'A', 1, 'A', 1, 'A', 1});

    // Act
    Map<String, String> actualToFlatMapResult = JacksonUtil.toFlatMap(node);

    // Assert
    assertEquals(1, actualToFlatMapResult.size());
    assertEquals("QQFBAUEBQQE=", actualToFlatMapResult.get(""));
  }

  /**
   * Test {@link JacksonUtil#toFlatMap(JsonNode)} with {@code node}.
   *
   * <ul>
   *   <li>When {@link ArrayNode#ArrayNode(JsonNodeFactory)} with nf is withExactBigDecimals {@code
   *       true}.
   * </ul>
   *
   * <p>Method under test: {@link JacksonUtil#toFlatMap(JsonNode)}
   */
  @Test
  @DisplayName(
      "Test toFlatMap(JsonNode) with 'node'; when ArrayNode(JsonNodeFactory) with nf is withExactBigDecimals 'true'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Map JacksonUtil.toFlatMap(JsonNode)"})
  void testToFlatMapWithNode_whenArrayNodeWithNfIsWithExactBigDecimalsTrue() {
    // Arrange
    JsonNodeFactory nf = JsonNodeFactory.withExactBigDecimals(true);

    // Act
    Map<String, String> actualToFlatMapResult = JacksonUtil.toFlatMap(new ArrayNode(nf));

    // Assert
    assertTrue(actualToFlatMapResult.isEmpty());
  }

  /**
   * Test {@link JacksonUtil#toFlatMap(JsonNode)} with {@code node}.
   *
   * <ul>
   *   <li>When Instance.
   *   <li>Then return Empty.
   * </ul>
   *
   * <p>Method under test: {@link JacksonUtil#toFlatMap(JsonNode)}
   */
  @Test
  @DisplayName("Test toFlatMap(JsonNode) with 'node'; when Instance; then return Empty")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Map JacksonUtil.toFlatMap(JsonNode)"})
  void testToFlatMapWithNode_whenInstance_thenReturnEmpty() {
    // Arrange and Act
    Map<String, String> actualToFlatMapResult = JacksonUtil.toFlatMap(MissingNode.getInstance());

    // Assert
    assertTrue(actualToFlatMapResult.isEmpty());
  }

  /**
   * Test {@link JacksonUtil#toFlatMap(JsonNode)} with {@code node}.
   *
   * <ul>
   *   <li>When valueOf ten.
   *   <li>Then return empty string is {@code 10.0}.
   * </ul>
   *
   * <p>Method under test: {@link JacksonUtil#toFlatMap(JsonNode)}
   */
  @Test
  @DisplayName(
      "Test toFlatMap(JsonNode) with 'node'; when valueOf ten; then return empty string is '10.0'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Map JacksonUtil.toFlatMap(JsonNode)"})
  void testToFlatMapWithNode_whenValueOfTen_thenReturnEmptyStringIs100() {
    // Arrange and Act
    Map<String, String> actualToFlatMapResult = JacksonUtil.toFlatMap(DoubleNode.valueOf(10.0d));

    // Assert
    assertEquals(1, actualToFlatMapResult.size());
    assertEquals("10.0", actualToFlatMapResult.get(""));
  }

  /**
   * Test {@link JacksonUtil#fromReader(Reader, Class)}.
   *
   * <ul>
   *   <li>When {@code JsonMapper$Builder}.
   * </ul>
   *
   * <p>Method under test: {@link JacksonUtil#fromReader(Reader, Class)}
   */
  @Test
  @DisplayName(
      "Test fromReader(Reader, Class); when 'com.fasterxml.jackson.databind.json.JsonMapper$Builder'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
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
   *
   * <ul>
   *   <li>When {@code JsonMapper$Builder}.
   * </ul>
   *
   * <p>Method under test: {@link JacksonUtil#fromReader(Reader, Class)}
   */
  @Test
  @DisplayName(
      "Test fromReader(Reader, Class); when 'com.fasterxml.jackson.databind.json.JsonMapper$Builder'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
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
   *
   * <ul>
   *   <li>When {@code String}.
   *   <li>Then return {@code 42}.
   * </ul>
   *
   * <p>Method under test: {@link JacksonUtil#fromReader(Reader, Class)}
   */
  @Test
  @DisplayName("Test fromReader(Reader, Class); when 'java.lang.String'; then return '42'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
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
   *
   * <ul>
   *   <li>When {@code String}.
   *   <li>Then throw {@link IllegalArgumentException}.
   * </ul>
   *
   * <p>Method under test: {@link JacksonUtil#fromReader(Reader, Class)}
   */
  @Test
  @DisplayName(
      "Test fromReader(Reader, Class); when 'java.lang.String'; then throw IllegalArgumentException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
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
   *
   * <ul>
   *   <li>When {@code null}.
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link JacksonUtil#fromReader(Reader, Class)}
   */
  @Test
  @DisplayName("Test fromReader(Reader, Class); when 'null'; then return 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Object JacksonUtil.fromReader(Reader, Class)"})
  void testFromReader_whenNull_thenReturnNull() {
    // Arrange
    Class<Object> clazz = Object.class;

    // Act and Assert
    assertNull(JacksonUtil.fromReader(null, clazz));
  }

  /**
   * Test {@link JacksonUtil#fromReader(Reader, Class)}.
   *
   * <ul>
   *   <li>When {@code JacksonUtil}.
   * </ul>
   *
   * <p>Method under test: {@link JacksonUtil#fromReader(Reader, Class)}
   */
  @Test
  @DisplayName("Test fromReader(Reader, Class); when 'org.thingsboard.common.util.JacksonUtil'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
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
   *
   * <ul>
   *   <li>When {@link StringReader#StringReader(String)} with {@code 42}.
   *   <li>Then return intValue is forty-two.
   * </ul>
   *
   * <p>Method under test: {@link JacksonUtil#fromReader(Reader, Class)}
   */
  @Test
  @DisplayName(
      "Test fromReader(Reader, Class); when StringReader(String) with '42'; then return intValue is forty-two")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
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
   *
   * <ul>
   *   <li>When {@link StringReader#StringReader(String)} with empty string.
   *   <li>Then throw {@link IllegalArgumentException}.
   * </ul>
   *
   * <p>Method under test: {@link JacksonUtil#fromReader(Reader, Class)}
   */
  @Test
  @DisplayName(
      "Test fromReader(Reader, Class); when StringReader(String) with empty string; then throw IllegalArgumentException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
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
   *
   * <ul>
   *   <li>When {@link StringReader#StringReader(String)} with {@code foo}.
   *   <li>Then throw {@link IllegalArgumentException}.
   * </ul>
   *
   * <p>Method under test: {@link JacksonUtil#fromReader(Reader, Class)}
   */
  @Test
  @DisplayName(
      "Test fromReader(Reader, Class); when StringReader(String) with 'foo'; then throw IllegalArgumentException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
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
   *
   * <ul>
   *   <li>When {@link StringReader#StringReader(String)} with {@code Invalid request payload}.
   * </ul>
   *
   * <p>Method under test: {@link JacksonUtil#fromReader(Reader, Class)}
   */
  @Test
  @DisplayName(
      "Test fromReader(Reader, Class); when StringReader(String) with 'Invalid request payload'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Object JacksonUtil.fromReader(Reader, Class)"})
  void testFromReader_whenStringReaderWithInvalidRequestPayload() {
    // Arrange
    StringReader reader = new StringReader("Invalid request payload");
    Class<Object> clazz = Object.class;

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> JacksonUtil.fromReader(reader, clazz));
  }

  /**
   * Test {@link JacksonUtil#fromReader(Reader, Class)}.
   *
   * <ul>
   *   <li>When {@link StringReader#StringReader(String)} with {@code Invalid request payload}.
   * </ul>
   *
   * <p>Method under test: {@link JacksonUtil#fromReader(Reader, Class)}
   */
  @Test
  @DisplayName(
      "Test fromReader(Reader, Class); when StringReader(String) with 'Invalid request payload'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Object JacksonUtil.fromReader(Reader, Class)"})
  void testFromReader_whenStringReaderWithInvalidRequestPayload2() {
    // Arrange
    StringReader reader = new StringReader("Invalid request payload");
    Class<Builder> clazz = Builder.class;

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> JacksonUtil.fromReader(reader, clazz));
  }

  /**
   * Test {@link JacksonUtil#writeValue(Writer, Object)}.
   *
   * <p>Method under test: {@link JacksonUtil#writeValue(Writer, Object)}
   */
  @Test
  @DisplayName("Test writeValue(Writer, Object)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void JacksonUtil.writeValue(Writer, Object)"})
  void testWriteValue() throws IOException {
    // Arrange
    SegmentedStringWriter writer = new SegmentedStringWriter(new BufferRecycler());

    // Act
    JacksonUtil.writeValue(writer, "\"");

    // Assert
    assertEquals("\"\\\"\"", writer.getAndClear());
  }

  /**
   * Test {@link JacksonUtil#writeValue(Writer, Object)}.
   *
   * <ul>
   *   <li>Given construct three.
   *   <li>When {@link BufferRecycler#BufferRecycler()} withPool construct three.
   * </ul>
   *
   * <p>Method under test: {@link JacksonUtil#writeValue(Writer, Object)}
   */
  @Test
  @DisplayName(
      "Test writeValue(Writer, Object); given construct three; when BufferRecycler() withPool construct three")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void JacksonUtil.writeValue(Writer, Object)"})
  void testWriteValue_givenConstructThree_whenBufferRecyclerWithPoolConstructThree() {
    // Arrange
    BufferRecycler br = new BufferRecycler();
    br.withPool(BoundedPool.construct(3));
    IOContext ctxt = new IOContext(br, ContentReference.redacted(), true);
    UTF8Writer writer = new UTF8Writer(ctxt, new ByteArrayOutputStream());

    // Act and Assert
    assertDoesNotThrow(() -> JacksonUtil.writeValue(writer, "Value"));
  }

  /**
   * Test {@link JacksonUtil#writeValue(Writer, Object)}.
   *
   * <ul>
   *   <li>Given one.
   * </ul>
   *
   * <p>Method under test: {@link JacksonUtil#writeValue(Writer, Object)}
   */
  @Test
  @DisplayName("Test writeValue(Writer, Object); given one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void JacksonUtil.writeValue(Writer, Object)"})
  void testWriteValue_givenOne() throws IOException {
    // Arrange
    BufferRecycler br = new BufferRecycler();
    br.releaseCharBuffer(1, "A\u0000A\u0000".toCharArray());
    SegmentedStringWriter writer = new SegmentedStringWriter(br);

    // Act
    JacksonUtil.writeValue(writer, "Value");

    // Assert
    assertEquals("\"Value\"", writer.getAndClear());
  }

  /**
   * Test {@link JacksonUtil#writeValue(Writer, Object)}.
   *
   * <ul>
   *   <li>Then does not throw.
   * </ul>
   *
   * <p>Method under test: {@link JacksonUtil#writeValue(Writer, Object)}
   */
  @Test
  @DisplayName("Test writeValue(Writer, Object); then does not throw")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void JacksonUtil.writeValue(Writer, Object)"})
  void testWriteValue_thenDoesNotThrow() {
    // Arrange
    BufferRecycler br = new BufferRecycler();
    IOContext ctxt = new IOContext(br, ContentReference.redacted(), true);
    UTF8Writer writer = new UTF8Writer(ctxt, new ByteArrayOutputStream());

    // Act and Assert
    assertDoesNotThrow(() -> JacksonUtil.writeValue(writer, "Value"));
  }

  /**
   * Test {@link JacksonUtil#writeValue(Writer, Object)}.
   *
   * <ul>
   *   <li>Then {@link SegmentedStringWriter#SegmentedStringWriter(BufferRecycler)} with br is
   *       {@link BufferRecycler#BufferRecycler()} AndClear is {@code "Value"}.
   * </ul>
   *
   * <p>Method under test: {@link JacksonUtil#writeValue(Writer, Object)}
   */
  @Test
  @DisplayName(
      "Test writeValue(Writer, Object); then SegmentedStringWriter(BufferRecycler) with br is BufferRecycler() AndClear is '\"Value\"'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void JacksonUtil.writeValue(Writer, Object)"})
  void testWriteValue_thenSegmentedStringWriterWithBrIsBufferRecyclerAndClearIsValue()
      throws IOException {
    // Arrange
    SegmentedStringWriter writer = new SegmentedStringWriter(new BufferRecycler());

    // Act
    JacksonUtil.writeValue(writer, "Value");

    // Assert
    assertEquals("\"Value\"", writer.getAndClear());
  }

  /**
   * Test {@link JacksonUtil#writeValue(Writer, Object)}.
   *
   * <ul>
   *   <li>Then {@link SegmentedStringWriter#SegmentedStringWriter(BufferRecycler)} with br is
   *       {@code null} AndClear is {@code "Value"}.
   * </ul>
   *
   * <p>Method under test: {@link JacksonUtil#writeValue(Writer, Object)}
   */
  @Test
  @DisplayName(
      "Test writeValue(Writer, Object); then SegmentedStringWriter(BufferRecycler) with br is 'null' AndClear is '\"Value\"'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void JacksonUtil.writeValue(Writer, Object)"})
  void testWriteValue_thenSegmentedStringWriterWithBrIsNullAndClearIsValue() throws IOException {
    // Arrange
    SegmentedStringWriter writer = new SegmentedStringWriter(null);

    // Act
    JacksonUtil.writeValue(writer, "Value");

    // Assert
    assertEquals("\"Value\"", writer.getAndClear());
  }

  /**
   * Test {@link JacksonUtil#writeValue(Writer, Object)}.
   *
   * <ul>
   *   <li>When Default.
   *   <li>Then throw {@link IllegalArgumentException}.
   * </ul>
   *
   * <p>Method under test: {@link JacksonUtil#writeValue(Writer, Object)}
   */
  @Test
  @DisplayName("Test writeValue(Writer, Object); when Default; then throw IllegalArgumentException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void JacksonUtil.writeValue(Writer, Object)"})
  void testWriteValue_whenDefault_thenThrowIllegalArgumentException() {
    // Arrange, Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () ->
            JacksonUtil.writeValue(
                new SegmentedStringWriter(new BufferRecycler()), FileSystems.getDefault()));
  }

  /**
   * Test {@link JacksonUtil#writeValue(Writer, Object)}.
   *
   * <ul>
   *   <li>When {@code null}.
   *   <li>Then {@link StringWriter#StringWriter()} toString is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link JacksonUtil#writeValue(Writer, Object)}
   */
  @Test
  @DisplayName(
      "Test writeValue(Writer, Object); when 'null'; then StringWriter() toString is 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void JacksonUtil.writeValue(Writer, Object)"})
  void testWriteValue_whenNull_thenStringWriterToStringIsNull() {
    // Arrange
    StringWriter writer = new StringWriter();

    // Act
    JacksonUtil.writeValue(writer, null);

    // Assert
    assertEquals("null", writer.toString());
  }

  /**
   * Test {@link JacksonUtil#writeValue(Writer, Object)}.
   *
   * <ul>
   *   <li>When {@link PipedWriter#PipedWriter()}.
   *   <li>Then throw {@link IllegalArgumentException}.
   * </ul>
   *
   * <p>Method under test: {@link JacksonUtil#writeValue(Writer, Object)}
   */
  @Test
  @DisplayName(
      "Test writeValue(Writer, Object); when PipedWriter(); then throw IllegalArgumentException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void JacksonUtil.writeValue(Writer, Object)"})
  void testWriteValue_whenPipedWriter_thenThrowIllegalArgumentException() {
    // Arrange, Act and Assert
    assertThrows(
        IllegalArgumentException.class, () -> JacksonUtil.writeValue(new PipedWriter(), "Value"));
  }

  /**
   * Test {@link JacksonUtil#writeValue(Writer, Object)}.
   *
   * <ul>
   *   <li>When {@link PipedWriter#PipedWriter()}.
   *   <li>Then throw {@link IllegalArgumentException}.
   * </ul>
   *
   * <p>Method under test: {@link JacksonUtil#writeValue(Writer, Object)}
   */
  @Test
  @DisplayName(
      "Test writeValue(Writer, Object); when PipedWriter(); then throw IllegalArgumentException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void JacksonUtil.writeValue(Writer, Object)"})
  void testWriteValue_whenPipedWriter_thenThrowIllegalArgumentException2() {
    // Arrange, Act and Assert
    assertThrows(
        IllegalArgumentException.class, () -> JacksonUtil.writeValue(new PipedWriter(), "\""));
  }

  /**
   * Test {@link JacksonUtil#writeValue(Writer, Object)}.
   *
   * <ul>
   *   <li>When {@link StringWriter#StringWriter()}.
   *   <li>Then {@link StringWriter#StringWriter()} toString is {@code "Value"}.
   * </ul>
   *
   * <p>Method under test: {@link JacksonUtil#writeValue(Writer, Object)}
   */
  @Test
  @DisplayName(
      "Test writeValue(Writer, Object); when StringWriter(); then StringWriter() toString is '\"Value\"'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
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
   * Test {@link JacksonUtil#writeValue(Writer, Object)}.
   *
   * <ul>
   *   <li>When {@link StringWriter#StringWriter()}.
   *   <li>Then throw {@link IllegalArgumentException}.
   * </ul>
   *
   * <p>Method under test: {@link JacksonUtil#writeValue(Writer, Object)}
   */
  @Test
  @DisplayName(
      "Test writeValue(Writer, Object); when StringWriter(); then throw IllegalArgumentException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void JacksonUtil.writeValue(Writer, Object)"})
  void testWriteValue_whenStringWriter_thenThrowIllegalArgumentException() {
    // Arrange, Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () -> JacksonUtil.writeValue(new StringWriter(), FileSystems.getDefault()));
  }

  /**
   * Test {@link JacksonUtil#addKvEntry(ObjectNode, KvEntry)} with {@code entityNode}, {@code
   * kvEntry}.
   *
   * <p>Method under test: {@link JacksonUtil#addKvEntry(ObjectNode, KvEntry)}
   */
  @Test
  @DisplayName("Test addKvEntry(ObjectNode, KvEntry) with 'entityNode', 'kvEntry'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void JacksonUtil.addKvEntry(ObjectNode, KvEntry)"})
  void testAddKvEntryWithEntityNodeKvEntry() {
    // Arrange
    JsonNodeFactory nc = JsonNodeFactory.withExactBigDecimals(true);
    ObjectNode entityNode = new ObjectNode(nc);

    // Act
    JacksonUtil.addKvEntry(entityNode, new JsonDataEntry("Key", "42"));

    // Assert
    Iterator<JsonNode> iteratorResult = entityNode.iterator();
    JsonNode nextResult = iteratorResult.next();
    assertTrue(nextResult instanceof IntNode);
    assertFalse(((IntNode) nextResult).isNaN());
    assertFalse(iteratorResult.hasNext());
    assertTrue(nextResult.isInt());
    assertTrue(nextResult.isIntegralNumber());
  }

  /**
   * Test {@link JacksonUtil#addKvEntry(ObjectNode, KvEntry)} with {@code entityNode}, {@code
   * kvEntry}.
   *
   * <p>Method under test: {@link JacksonUtil#addKvEntry(ObjectNode, KvEntry)}
   */
  @Test
  @DisplayName("Test addKvEntry(ObjectNode, KvEntry) with 'entityNode', 'kvEntry'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void JacksonUtil.addKvEntry(ObjectNode, KvEntry)"})
  void testAddKvEntryWithEntityNodeKvEntry2() {
    // Arrange
    JsonNodeFactory nc = JsonNodeFactory.withExactBigDecimals(true);
    ObjectNode entityNode = new ObjectNode(nc, new HashMap<>());

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
   * Test {@link JacksonUtil#addKvEntry(ObjectNode, KvEntry)} with {@code entityNode}, {@code
   * kvEntry}.
   *
   * <p>Method under test: {@link JacksonUtil#addKvEntry(ObjectNode, KvEntry)}
   */
  @Test
  @DisplayName("Test addKvEntry(ObjectNode, KvEntry) with 'entityNode', 'kvEntry'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void JacksonUtil.addKvEntry(ObjectNode, KvEntry)"})
  void testAddKvEntryWithEntityNodeKvEntry3() {
    // Arrange
    JsonNodeFactory nc = JsonNodeFactory.withExactBigDecimals(true);
    ObjectNode entityNode = new ObjectNode(nc);

    // Act
    JacksonUtil.addKvEntry(entityNode, new JsonDataEntry("Key", ""));

    // Assert
    Iterator<JsonNode> iteratorResult = entityNode.iterator();
    JsonNode nextResult = iteratorResult.next();
    assertTrue(nextResult instanceof NullNode);
    assertEquals(JsonNodeType.NULL, nextResult.getNodeType());
    assertFalse(nextResult.isNumber());
    assertFalse(iteratorResult.hasNext());
    assertTrue(nextResult.isNull());
  }

  /**
   * Test {@link JacksonUtil#addKvEntry(ObjectNode, KvEntry)} with {@code entityNode}, {@code
   * kvEntry}.
   *
   * <p>Method under test: {@link JacksonUtil#addKvEntry(ObjectNode, KvEntry)}
   */
  @Test
  @DisplayName("Test addKvEntry(ObjectNode, KvEntry) with 'entityNode', 'kvEntry'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void JacksonUtil.addKvEntry(ObjectNode, KvEntry)"})
  void testAddKvEntryWithEntityNodeKvEntry4() {
    // Arrange
    JsonNodeFactory nc = JsonNodeFactory.withExactBigDecimals(true);
    ObjectNode entityNode = new ObjectNode(nc);

    // Act
    JacksonUtil.addKvEntry(entityNode, new StringDataEntry("Key", "42"));

    // Assert
    Iterator<JsonNode> iteratorResult = entityNode.iterator();
    JsonNode nextResult = iteratorResult.next();
    assertTrue(nextResult instanceof TextNode);
    assertEquals(JsonNodeType.STRING, nextResult.getNodeType());
    assertFalse(nextResult.isNumber());
    assertFalse(iteratorResult.hasNext());
    assertTrue(nextResult.isTextual());
  }

  /**
   * Test {@link JacksonUtil#addKvEntry(ObjectNode, KvEntry)} with {@code entityNode}, {@code
   * kvEntry}.
   *
   * <p>Method under test: {@link JacksonUtil#addKvEntry(ObjectNode, KvEntry)}
   */
  @Test
  @DisplayName("Test addKvEntry(ObjectNode, KvEntry) with 'entityNode', 'kvEntry'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void JacksonUtil.addKvEntry(ObjectNode, KvEntry)"})
  void testAddKvEntryWithEntityNodeKvEntry5() {
    // Arrange
    JsonNodeFactory nc = JsonNodeFactory.withExactBigDecimals(true);
    ObjectNode entityNode = new ObjectNode(nc);

    // Act
    JacksonUtil.addKvEntry(entityNode, new StringDataEntry("Key", ""));

    // Assert
    Iterator<JsonNode> iteratorResult = entityNode.iterator();
    JsonNode nextResult = iteratorResult.next();
    assertTrue(nextResult instanceof TextNode);
    assertEquals(JsonNodeType.STRING, nextResult.getNodeType());
    assertFalse(nextResult.isNumber());
    assertFalse(iteratorResult.hasNext());
    assertTrue(nextResult.isTextual());
  }

  /**
   * Test {@link JacksonUtil#addKvEntry(ObjectNode, KvEntry)} with {@code entityNode}, {@code
   * kvEntry}.
   *
   * <p>Method under test: {@link JacksonUtil#addKvEntry(ObjectNode, KvEntry)}
   */
  @Test
  @DisplayName("Test addKvEntry(ObjectNode, KvEntry) with 'entityNode', 'kvEntry'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void JacksonUtil.addKvEntry(ObjectNode, KvEntry)"})
  void testAddKvEntryWithEntityNodeKvEntry6() {
    // Arrange
    JsonNodeFactory nc = JsonNodeFactory.withExactBigDecimals(true);
    ObjectNode entityNode = new ObjectNode(nc);

    // Act
    JacksonUtil.addKvEntry(entityNode, new BooleanDataEntry("Key", true));

    // Assert
    Iterator<JsonNode> iteratorResult = entityNode.iterator();
    JsonNode nextResult = iteratorResult.next();
    assertTrue(nextResult instanceof BooleanNode);
    assertEquals(JsonNodeType.BOOLEAN, nextResult.getNodeType());
    assertFalse(nextResult.isNumber());
    assertFalse(iteratorResult.hasNext());
    assertTrue(nextResult.isBoolean());
  }

  /**
   * Test {@link JacksonUtil#addKvEntry(ObjectNode, KvEntry)} with {@code entityNode}, {@code
   * kvEntry}.
   *
   * <p>Method under test: {@link JacksonUtil#addKvEntry(ObjectNode, KvEntry)}
   */
  @Test
  @DisplayName("Test addKvEntry(ObjectNode, KvEntry) with 'entityNode', 'kvEntry'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void JacksonUtil.addKvEntry(ObjectNode, KvEntry)"})
  void testAddKvEntryWithEntityNodeKvEntry7() {
    // Arrange
    JsonNodeFactory nc = JsonNodeFactory.withExactBigDecimals(true);
    ObjectNode entityNode = new ObjectNode(nc);

    // Act
    JacksonUtil.addKvEntry(entityNode, new DoubleDataEntry("Key", 10.0d));

    // Assert
    Iterator<JsonNode> iteratorResult = entityNode.iterator();
    JsonNode nextResult = iteratorResult.next();
    assertTrue(nextResult instanceof DoubleNode);
    assertFalse(((DoubleNode) nextResult).isNaN());
    assertFalse(iteratorResult.hasNext());
    assertTrue(nextResult.isDouble());
    assertTrue(nextResult.isFloatingPointNumber());
  }

  /**
   * Test {@link JacksonUtil#addKvEntry(ObjectNode, KvEntry)} with {@code entityNode}, {@code
   * kvEntry}.
   *
   * <p>Method under test: {@link JacksonUtil#addKvEntry(ObjectNode, KvEntry)}
   */
  @Test
  @DisplayName("Test addKvEntry(ObjectNode, KvEntry) with 'entityNode', 'kvEntry'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void JacksonUtil.addKvEntry(ObjectNode, KvEntry)"})
  void testAddKvEntryWithEntityNodeKvEntry8() {
    // Arrange
    JsonNodeFactory nc = JsonNodeFactory.withExactBigDecimals(true);
    ObjectNode entityNode = new ObjectNode(nc);

    // Act
    JacksonUtil.addKvEntry(entityNode, new LongDataEntry("Key", 42L));

    // Assert
    Iterator<JsonNode> iteratorResult = entityNode.iterator();
    JsonNode nextResult = iteratorResult.next();
    assertTrue(nextResult instanceof LongNode);
    assertFalse(((LongNode) nextResult).isNaN());
    assertFalse(iteratorResult.hasNext());
    assertTrue(nextResult.isIntegralNumber());
    assertTrue(nextResult.isLong());
  }

  /**
   * Test {@link JacksonUtil#addKvEntry(ObjectNode, KvEntry, String)} with {@code entityNode},
   * {@code kvEntry}, {@code key}.
   *
   * <p>Method under test: {@link JacksonUtil#addKvEntry(ObjectNode, KvEntry, String)}
   */
  @Test
  @DisplayName("Test addKvEntry(ObjectNode, KvEntry, String) with 'entityNode', 'kvEntry', 'key'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void JacksonUtil.addKvEntry(ObjectNode, KvEntry, String)"})
  void testAddKvEntryWithEntityNodeKvEntryKey() {
    // Arrange
    JsonNodeFactory nc = JsonNodeFactory.withExactBigDecimals(true);
    ObjectNode entityNode = new ObjectNode(nc);

    // Act
    JacksonUtil.addKvEntry(entityNode, new JsonDataEntry("Key", "42"), "Key");

    // Assert
    Iterator<JsonNode> iteratorResult = entityNode.iterator();
    JsonNode nextResult = iteratorResult.next();
    assertTrue(nextResult instanceof IntNode);
    assertFalse(((IntNode) nextResult).isNaN());
    assertFalse(iteratorResult.hasNext());
    assertTrue(nextResult.isInt());
    assertTrue(nextResult.isIntegralNumber());
  }

  /**
   * Test {@link JacksonUtil#addKvEntry(ObjectNode, KvEntry, String)} with {@code entityNode},
   * {@code kvEntry}, {@code key}.
   *
   * <p>Method under test: {@link JacksonUtil#addKvEntry(ObjectNode, KvEntry, String)}
   */
  @Test
  @DisplayName("Test addKvEntry(ObjectNode, KvEntry, String) with 'entityNode', 'kvEntry', 'key'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void JacksonUtil.addKvEntry(ObjectNode, KvEntry, String)"})
  void testAddKvEntryWithEntityNodeKvEntryKey2() {
    // Arrange
    JsonNodeFactory nc = JsonNodeFactory.withExactBigDecimals(true);
    ObjectNode entityNode = new ObjectNode(nc);

    // Act
    JacksonUtil.addKvEntry(entityNode, new JsonDataEntry("Key", ""), "Key");

    // Assert
    Iterator<JsonNode> iteratorResult = entityNode.iterator();
    JsonNode nextResult = iteratorResult.next();
    assertTrue(nextResult instanceof NullNode);
    assertEquals(JsonNodeType.NULL, nextResult.getNodeType());
    assertFalse(nextResult.isNumber());
    assertFalse(iteratorResult.hasNext());
    assertTrue(nextResult.isNull());
  }

  /**
   * Test {@link JacksonUtil#addKvEntry(ObjectNode, KvEntry, String)} with {@code entityNode},
   * {@code kvEntry}, {@code key}.
   *
   * <p>Method under test: {@link JacksonUtil#addKvEntry(ObjectNode, KvEntry, String)}
   */
  @Test
  @DisplayName("Test addKvEntry(ObjectNode, KvEntry, String) with 'entityNode', 'kvEntry', 'key'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void JacksonUtil.addKvEntry(ObjectNode, KvEntry, String)"})
  void testAddKvEntryWithEntityNodeKvEntryKey3() {
    // Arrange
    JsonNodeFactory nc = JsonNodeFactory.withExactBigDecimals(true);
    ObjectNode entityNode = new ObjectNode(nc);

    // Act
    JacksonUtil.addKvEntry(entityNode, new StringDataEntry("Key", "42"), "Key");

    // Assert
    Iterator<JsonNode> iteratorResult = entityNode.iterator();
    JsonNode nextResult = iteratorResult.next();
    assertTrue(nextResult instanceof TextNode);
    assertEquals(JsonNodeType.STRING, nextResult.getNodeType());
    assertFalse(nextResult.isNumber());
    assertFalse(iteratorResult.hasNext());
    assertTrue(nextResult.isTextual());
  }

  /**
   * Test {@link JacksonUtil#addKvEntry(ObjectNode, KvEntry, String)} with {@code entityNode},
   * {@code kvEntry}, {@code key}.
   *
   * <p>Method under test: {@link JacksonUtil#addKvEntry(ObjectNode, KvEntry, String)}
   */
  @Test
  @DisplayName("Test addKvEntry(ObjectNode, KvEntry, String) with 'entityNode', 'kvEntry', 'key'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void JacksonUtil.addKvEntry(ObjectNode, KvEntry, String)"})
  void testAddKvEntryWithEntityNodeKvEntryKey4() {
    // Arrange
    JsonNodeFactory nc = JsonNodeFactory.withExactBigDecimals(true);
    ObjectNode entityNode = new ObjectNode(nc);

    // Act
    JacksonUtil.addKvEntry(entityNode, new StringDataEntry("Key", ""), "Key");

    // Assert
    Iterator<JsonNode> iteratorResult = entityNode.iterator();
    JsonNode nextResult = iteratorResult.next();
    assertTrue(nextResult instanceof TextNode);
    assertEquals(JsonNodeType.STRING, nextResult.getNodeType());
    assertFalse(nextResult.isNumber());
    assertFalse(iteratorResult.hasNext());
    assertTrue(nextResult.isTextual());
  }

  /**
   * Test {@link JacksonUtil#addKvEntry(ObjectNode, KvEntry, String)} with {@code entityNode},
   * {@code kvEntry}, {@code key}.
   *
   * <p>Method under test: {@link JacksonUtil#addKvEntry(ObjectNode, KvEntry, String)}
   */
  @Test
  @DisplayName("Test addKvEntry(ObjectNode, KvEntry, String) with 'entityNode', 'kvEntry', 'key'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void JacksonUtil.addKvEntry(ObjectNode, KvEntry, String)"})
  void testAddKvEntryWithEntityNodeKvEntryKey5() {
    // Arrange
    JsonNodeFactory nc = JsonNodeFactory.withExactBigDecimals(true);
    ObjectNode entityNode = new ObjectNode(nc);

    // Act
    JacksonUtil.addKvEntry(entityNode, new BooleanDataEntry("Key", true), "Key");

    // Assert
    Iterator<JsonNode> iteratorResult = entityNode.iterator();
    JsonNode nextResult = iteratorResult.next();
    assertTrue(nextResult instanceof BooleanNode);
    assertEquals(JsonNodeType.BOOLEAN, nextResult.getNodeType());
    assertFalse(nextResult.isNumber());
    assertFalse(iteratorResult.hasNext());
    assertTrue(nextResult.isBoolean());
  }

  /**
   * Test {@link JacksonUtil#addKvEntry(ObjectNode, KvEntry, String)} with {@code entityNode},
   * {@code kvEntry}, {@code key}.
   *
   * <p>Method under test: {@link JacksonUtil#addKvEntry(ObjectNode, KvEntry, String)}
   */
  @Test
  @DisplayName("Test addKvEntry(ObjectNode, KvEntry, String) with 'entityNode', 'kvEntry', 'key'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void JacksonUtil.addKvEntry(ObjectNode, KvEntry, String)"})
  void testAddKvEntryWithEntityNodeKvEntryKey6() {
    // Arrange
    JsonNodeFactory nc = JsonNodeFactory.withExactBigDecimals(true);
    ObjectNode entityNode = new ObjectNode(nc);

    // Act
    JacksonUtil.addKvEntry(entityNode, new DoubleDataEntry("Key", 10.0d), "Key");

    // Assert
    Iterator<JsonNode> iteratorResult = entityNode.iterator();
    JsonNode nextResult = iteratorResult.next();
    assertTrue(nextResult instanceof DoubleNode);
    assertFalse(((DoubleNode) nextResult).isNaN());
    assertFalse(iteratorResult.hasNext());
    assertTrue(nextResult.isDouble());
    assertTrue(nextResult.isFloatingPointNumber());
  }

  /**
   * Test {@link JacksonUtil#addKvEntry(ObjectNode, KvEntry, String)} with {@code entityNode},
   * {@code kvEntry}, {@code key}.
   *
   * <p>Method under test: {@link JacksonUtil#addKvEntry(ObjectNode, KvEntry, String)}
   */
  @Test
  @DisplayName("Test addKvEntry(ObjectNode, KvEntry, String) with 'entityNode', 'kvEntry', 'key'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void JacksonUtil.addKvEntry(ObjectNode, KvEntry, String)"})
  void testAddKvEntryWithEntityNodeKvEntryKey7() {
    // Arrange
    JsonNodeFactory nc = JsonNodeFactory.withExactBigDecimals(true);
    ObjectNode entityNode = new ObjectNode(nc);

    // Act
    JacksonUtil.addKvEntry(entityNode, new LongDataEntry("Key", 42L), "Key");

    // Assert
    Iterator<JsonNode> iteratorResult = entityNode.iterator();
    JsonNode nextResult = iteratorResult.next();
    assertTrue(nextResult instanceof LongNode);
    assertFalse(((LongNode) nextResult).isNaN());
    assertFalse(iteratorResult.hasNext());
    assertTrue(nextResult.isIntegralNumber());
    assertTrue(nextResult.isLong());
  }

  /**
   * Test {@link JacksonUtil#addKvEntry(ObjectNode, KvEntry, String)} with {@code entityNode},
   * {@code kvEntry}, {@code key}.
   *
   * <p>Method under test: {@link JacksonUtil#addKvEntry(ObjectNode, KvEntry, String)}
   */
  @Test
  @DisplayName("Test addKvEntry(ObjectNode, KvEntry, String) with 'entityNode', 'kvEntry', 'key'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void JacksonUtil.addKvEntry(ObjectNode, KvEntry, String)"})
  void testAddKvEntryWithEntityNodeKvEntryKey8() {
    // Arrange
    JsonNodeFactory nc = JsonNodeFactory.withExactBigDecimals(true);
    ObjectNode entityNode = new ObjectNode(nc);

    // Act
    JacksonUtil.addKvEntry(entityNode, new BooleanDataEntry("Key", false), "Key");

    // Assert
    Iterator<JsonNode> iteratorResult = entityNode.iterator();
    JsonNode nextResult = iteratorResult.next();
    assertTrue(nextResult instanceof BooleanNode);
    assertEquals(JsonNodeType.BOOLEAN, nextResult.getNodeType());
    assertFalse(nextResult.isNumber());
    assertFalse(iteratorResult.hasNext());
    assertTrue(nextResult.isBoolean());
  }

  /**
   * Test {@link JacksonUtil#addKvEntry(ObjectNode, KvEntry, String, ObjectMapper)} with {@code
   * entityNode}, {@code kvEntry}, {@code key}, {@code mapper}.
   *
   * <p>Method under test: {@link JacksonUtil#addKvEntry(ObjectNode, KvEntry, String, ObjectMapper)}
   */
  @Test
  @DisplayName(
      "Test addKvEntry(ObjectNode, KvEntry, String, ObjectMapper) with 'entityNode', 'kvEntry', 'key', 'mapper'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void JacksonUtil.addKvEntry(ObjectNode, KvEntry, String, ObjectMapper)"})
  void testAddKvEntryWithEntityNodeKvEntryKeyMapper() {
    // Arrange
    JsonNodeFactory nc = JsonNodeFactory.withExactBigDecimals(true);
    ObjectNode entityNode = new ObjectNode(nc);

    // Act
    JacksonUtil.addKvEntry(
        entityNode,
        new JsonDataEntry("Key", "42"),
        "Key",
        JacksonUtil.IGNORE_UNKNOWN_PROPERTIES_JSON_MAPPER);

    // Assert
    Iterator<JsonNode> iteratorResult = entityNode.iterator();
    JsonNode nextResult = iteratorResult.next();
    assertTrue(nextResult instanceof IntNode);
    assertFalse(((IntNode) nextResult).isNaN());
    assertFalse(iteratorResult.hasNext());
    assertTrue(nextResult.isInt());
    assertTrue(nextResult.isIntegralNumber());
  }

  /**
   * Test {@link JacksonUtil#addKvEntry(ObjectNode, KvEntry, String, ObjectMapper)} with {@code
   * entityNode}, {@code kvEntry}, {@code key}, {@code mapper}.
   *
   * <p>Method under test: {@link JacksonUtil#addKvEntry(ObjectNode, KvEntry, String, ObjectMapper)}
   */
  @Test
  @DisplayName(
      "Test addKvEntry(ObjectNode, KvEntry, String, ObjectMapper) with 'entityNode', 'kvEntry', 'key', 'mapper'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void JacksonUtil.addKvEntry(ObjectNode, KvEntry, String, ObjectMapper)"})
  void testAddKvEntryWithEntityNodeKvEntryKeyMapper2() {
    // Arrange
    JsonNodeFactory nc = JsonNodeFactory.withExactBigDecimals(true);
    ObjectNode entityNode = new ObjectNode(nc, new HashMap<>());

    // Act
    JacksonUtil.addKvEntry(
        entityNode,
        new JsonDataEntry("Key", "42"),
        "Key",
        JacksonUtil.IGNORE_UNKNOWN_PROPERTIES_JSON_MAPPER);

    // Assert
    Iterator<JsonNode> iteratorResult = entityNode.iterator();
    JsonNode nextResult = iteratorResult.next();
    assertTrue(nextResult instanceof IntNode);
    assertTrue(nextResult.traverse() instanceof TreeTraversingParser);
    assertFalse(iteratorResult.hasNext());
  }

  /**
   * Test {@link JacksonUtil#addKvEntry(ObjectNode, KvEntry, String, ObjectMapper)} with {@code
   * entityNode}, {@code kvEntry}, {@code key}, {@code mapper}.
   *
   * <p>Method under test: {@link JacksonUtil#addKvEntry(ObjectNode, KvEntry, String, ObjectMapper)}
   */
  @Test
  @DisplayName(
      "Test addKvEntry(ObjectNode, KvEntry, String, ObjectMapper) with 'entityNode', 'kvEntry', 'key', 'mapper'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void JacksonUtil.addKvEntry(ObjectNode, KvEntry, String, ObjectMapper)"})
  void testAddKvEntryWithEntityNodeKvEntryKeyMapper3() {
    // Arrange
    JsonNodeFactory nc = JsonNodeFactory.withExactBigDecimals(true);
    ObjectNode entityNode = new ObjectNode(nc);
    JsonDataEntry kvEntry = new JsonDataEntry("Key", null);

    // Act
    JacksonUtil.addKvEntry(
        entityNode, kvEntry, "Key", JacksonUtil.IGNORE_UNKNOWN_PROPERTIES_JSON_MAPPER);

    // Assert that nothing has changed
    assertFalse(entityNode.iterator().hasNext());
  }

  /**
   * Test {@link JacksonUtil#addKvEntry(ObjectNode, KvEntry, String, ObjectMapper)} with {@code
   * entityNode}, {@code kvEntry}, {@code key}, {@code mapper}.
   *
   * <p>Method under test: {@link JacksonUtil#addKvEntry(ObjectNode, KvEntry, String, ObjectMapper)}
   */
  @Test
  @DisplayName(
      "Test addKvEntry(ObjectNode, KvEntry, String, ObjectMapper) with 'entityNode', 'kvEntry', 'key', 'mapper'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void JacksonUtil.addKvEntry(ObjectNode, KvEntry, String, ObjectMapper)"})
  void testAddKvEntryWithEntityNodeKvEntryKeyMapper4() {
    // Arrange
    JsonNodeFactory nc = JsonNodeFactory.withExactBigDecimals(true);
    ObjectNode entityNode = new ObjectNode(nc);

    // Act
    JacksonUtil.addKvEntry(
        entityNode,
        new JsonDataEntry("Key", ""),
        "Key",
        JacksonUtil.IGNORE_UNKNOWN_PROPERTIES_JSON_MAPPER);

    // Assert
    Iterator<JsonNode> iteratorResult = entityNode.iterator();
    JsonNode nextResult = iteratorResult.next();
    assertTrue(nextResult instanceof NullNode);
    assertEquals(JsonNodeType.NULL, nextResult.getNodeType());
    assertFalse(nextResult.isNumber());
    assertFalse(iteratorResult.hasNext());
    assertTrue(nextResult.isNull());
  }

  /**
   * Test {@link JacksonUtil#addKvEntry(ObjectNode, KvEntry, String, ObjectMapper)} with {@code
   * entityNode}, {@code kvEntry}, {@code key}, {@code mapper}.
   *
   * <p>Method under test: {@link JacksonUtil#addKvEntry(ObjectNode, KvEntry, String, ObjectMapper)}
   */
  @Test
  @DisplayName(
      "Test addKvEntry(ObjectNode, KvEntry, String, ObjectMapper) with 'entityNode', 'kvEntry', 'key', 'mapper'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void JacksonUtil.addKvEntry(ObjectNode, KvEntry, String, ObjectMapper)"})
  void testAddKvEntryWithEntityNodeKvEntryKeyMapper5() {
    // Arrange
    JsonNodeFactory nc = JsonNodeFactory.withExactBigDecimals(true);
    ObjectNode entityNode = new ObjectNode(nc);

    // Act
    JacksonUtil.addKvEntry(
        entityNode,
        new StringDataEntry("Key", "42"),
        "Key",
        JacksonUtil.IGNORE_UNKNOWN_PROPERTIES_JSON_MAPPER);

    // Assert
    Iterator<JsonNode> iteratorResult = entityNode.iterator();
    JsonNode nextResult = iteratorResult.next();
    assertTrue(nextResult instanceof TextNode);
    assertEquals(JsonNodeType.STRING, nextResult.getNodeType());
    assertFalse(nextResult.isNumber());
    assertFalse(iteratorResult.hasNext());
    assertTrue(nextResult.isTextual());
  }

  /**
   * Test {@link JacksonUtil#addKvEntry(ObjectNode, KvEntry, String, ObjectMapper)} with {@code
   * entityNode}, {@code kvEntry}, {@code key}, {@code mapper}.
   *
   * <p>Method under test: {@link JacksonUtil#addKvEntry(ObjectNode, KvEntry, String, ObjectMapper)}
   */
  @Test
  @DisplayName(
      "Test addKvEntry(ObjectNode, KvEntry, String, ObjectMapper) with 'entityNode', 'kvEntry', 'key', 'mapper'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void JacksonUtil.addKvEntry(ObjectNode, KvEntry, String, ObjectMapper)"})
  void testAddKvEntryWithEntityNodeKvEntryKeyMapper6() {
    // Arrange
    JsonNodeFactory nc = JsonNodeFactory.withExactBigDecimals(true);
    ObjectNode entityNode = new ObjectNode(nc);

    // Act
    JacksonUtil.addKvEntry(
        entityNode,
        new BooleanDataEntry("Key", true),
        "Key",
        JacksonUtil.IGNORE_UNKNOWN_PROPERTIES_JSON_MAPPER);

    // Assert
    Iterator<JsonNode> iteratorResult = entityNode.iterator();
    JsonNode nextResult = iteratorResult.next();
    assertTrue(nextResult instanceof BooleanNode);
    assertEquals(JsonNodeType.BOOLEAN, nextResult.getNodeType());
    assertFalse(nextResult.isNumber());
    assertFalse(iteratorResult.hasNext());
    assertTrue(nextResult.isBoolean());
  }

  /**
   * Test {@link JacksonUtil#addKvEntry(ObjectNode, KvEntry, String, ObjectMapper)} with {@code
   * entityNode}, {@code kvEntry}, {@code key}, {@code mapper}.
   *
   * <p>Method under test: {@link JacksonUtil#addKvEntry(ObjectNode, KvEntry, String, ObjectMapper)}
   */
  @Test
  @DisplayName(
      "Test addKvEntry(ObjectNode, KvEntry, String, ObjectMapper) with 'entityNode', 'kvEntry', 'key', 'mapper'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void JacksonUtil.addKvEntry(ObjectNode, KvEntry, String, ObjectMapper)"})
  void testAddKvEntryWithEntityNodeKvEntryKeyMapper7() {
    // Arrange
    JsonNodeFactory nc = JsonNodeFactory.withExactBigDecimals(true);
    ObjectNode entityNode = new ObjectNode(nc);

    // Act
    JacksonUtil.addKvEntry(
        entityNode,
        new DoubleDataEntry("Key", 10.0d),
        "Key",
        JacksonUtil.IGNORE_UNKNOWN_PROPERTIES_JSON_MAPPER);

    // Assert
    Iterator<JsonNode> iteratorResult = entityNode.iterator();
    JsonNode nextResult = iteratorResult.next();
    assertTrue(nextResult instanceof DoubleNode);
    assertFalse(((DoubleNode) nextResult).isNaN());
    assertFalse(iteratorResult.hasNext());
    assertTrue(nextResult.isDouble());
    assertTrue(nextResult.isFloatingPointNumber());
  }

  /**
   * Test {@link JacksonUtil#addKvEntry(ObjectNode, KvEntry, String, ObjectMapper)} with {@code
   * entityNode}, {@code kvEntry}, {@code key}, {@code mapper}.
   *
   * <p>Method under test: {@link JacksonUtil#addKvEntry(ObjectNode, KvEntry, String, ObjectMapper)}
   */
  @Test
  @DisplayName(
      "Test addKvEntry(ObjectNode, KvEntry, String, ObjectMapper) with 'entityNode', 'kvEntry', 'key', 'mapper'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void JacksonUtil.addKvEntry(ObjectNode, KvEntry, String, ObjectMapper)"})
  void testAddKvEntryWithEntityNodeKvEntryKeyMapper8() {
    // Arrange
    JsonNodeFactory nc = JsonNodeFactory.withExactBigDecimals(true);
    ObjectNode entityNode = new ObjectNode(nc);

    // Act
    JacksonUtil.addKvEntry(
        entityNode,
        new LongDataEntry("Key", 42L),
        "Key",
        JacksonUtil.IGNORE_UNKNOWN_PROPERTIES_JSON_MAPPER);

    // Assert
    Iterator<JsonNode> iteratorResult = entityNode.iterator();
    JsonNode nextResult = iteratorResult.next();
    assertTrue(nextResult instanceof LongNode);
    assertFalse(((LongNode) nextResult).isNaN());
    assertFalse(iteratorResult.hasNext());
    assertTrue(nextResult.isIntegralNumber());
    assertTrue(nextResult.isLong());
  }

  /**
   * Test {@link JacksonUtil#addKvEntry(ObjectNode, KvEntry, String, ObjectMapper)} with {@code
   * entityNode}, {@code kvEntry}, {@code key}, {@code mapper}.
   *
   * <p>Method under test: {@link JacksonUtil#addKvEntry(ObjectNode, KvEntry, String, ObjectMapper)}
   */
  @Test
  @DisplayName(
      "Test addKvEntry(ObjectNode, KvEntry, String, ObjectMapper) with 'entityNode', 'kvEntry', 'key', 'mapper'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void JacksonUtil.addKvEntry(ObjectNode, KvEntry, String, ObjectMapper)"})
  void testAddKvEntryWithEntityNodeKvEntryKeyMapper9() {
    // Arrange
    JsonNodeFactory nc = JsonNodeFactory.withExactBigDecimals(true);
    ObjectNode entityNode = new ObjectNode(nc);

    // Act
    JacksonUtil.addKvEntry(
        entityNode,
        new StringDataEntry("Key", ""),
        "Key",
        JacksonUtil.IGNORE_UNKNOWN_PROPERTIES_JSON_MAPPER);

    // Assert
    Iterator<JsonNode> iteratorResult = entityNode.iterator();
    JsonNode nextResult = iteratorResult.next();
    assertTrue(nextResult instanceof TextNode);
    assertEquals(JsonNodeType.STRING, nextResult.getNodeType());
    assertFalse(nextResult.isNumber());
    assertFalse(iteratorResult.hasNext());
    assertTrue(nextResult.isTextual());
  }

  /**
   * Test {@link JacksonUtil#addKvEntry(ObjectNode, KvEntry, String, ObjectMapper)} with {@code
   * entityNode}, {@code kvEntry}, {@code key}, {@code mapper}.
   *
   * <p>Method under test: {@link JacksonUtil#addKvEntry(ObjectNode, KvEntry, String, ObjectMapper)}
   */
  @Test
  @DisplayName(
      "Test addKvEntry(ObjectNode, KvEntry, String, ObjectMapper) with 'entityNode', 'kvEntry', 'key', 'mapper'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void JacksonUtil.addKvEntry(ObjectNode, KvEntry, String, ObjectMapper)"})
  void testAddKvEntryWithEntityNodeKvEntryKeyMapper10() {
    // Arrange
    JsonNodeFactory nc = JsonNodeFactory.withExactBigDecimals(true);
    ObjectNode entityNode = new ObjectNode(nc);

    // Act
    JacksonUtil.addKvEntry(
        entityNode,
        new BooleanDataEntry("Key", false),
        "Key",
        JacksonUtil.IGNORE_UNKNOWN_PROPERTIES_JSON_MAPPER);

    // Assert
    Iterator<JsonNode> iteratorResult = entityNode.iterator();
    JsonNode nextResult = iteratorResult.next();
    assertTrue(nextResult instanceof BooleanNode);
    assertEquals(JsonNodeType.BOOLEAN, nextResult.getNodeType());
    assertFalse(nextResult.isNumber());
    assertFalse(iteratorResult.hasNext());
    assertTrue(nextResult.isBoolean());
  }

  /**
   * Test {@link JacksonUtil#addKvEntry(ObjectNode, KvEntry, String, ObjectMapper)} with {@code
   * entityNode}, {@code kvEntry}, {@code key}, {@code mapper}.
   *
   * <ul>
   *   <li>Then throw {@link IllegalArgumentException}.
   * </ul>
   *
   * <p>Method under test: {@link JacksonUtil#addKvEntry(ObjectNode, KvEntry, String, ObjectMapper)}
   */
  @Test
  @DisplayName(
      "Test addKvEntry(ObjectNode, KvEntry, String, ObjectMapper) with 'entityNode', 'kvEntry', 'key', 'mapper'; then throw IllegalArgumentException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void JacksonUtil.addKvEntry(ObjectNode, KvEntry, String, ObjectMapper)"})
  void testAddKvEntryWithEntityNodeKvEntryKeyMapper_thenThrowIllegalArgumentException() {
    // Arrange
    JsonNodeFactory nc = JsonNodeFactory.withExactBigDecimals(true);
    ObjectNode entityNode = new ObjectNode(nc);

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () ->
            JacksonUtil.addKvEntry(
                entityNode,
                new JsonDataEntry("Key", "Value"),
                "Key",
                JacksonUtil.IGNORE_UNKNOWN_PROPERTIES_JSON_MAPPER));
  }

  /**
   * Test {@link JacksonUtil#addKvEntry(ObjectNode, KvEntry, String, ObjectMapper)} with {@code
   * entityNode}, {@code kvEntry}, {@code key}, {@code mapper}.
   *
   * <ul>
   *   <li>When {@link ObjectMapper#ObjectMapper()}.
   * </ul>
   *
   * <p>Method under test: {@link JacksonUtil#addKvEntry(ObjectNode, KvEntry, String, ObjectMapper)}
   */
  @Test
  @DisplayName(
      "Test addKvEntry(ObjectNode, KvEntry, String, ObjectMapper) with 'entityNode', 'kvEntry', 'key', 'mapper'; when ObjectMapper()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void JacksonUtil.addKvEntry(ObjectNode, KvEntry, String, ObjectMapper)"})
  void testAddKvEntryWithEntityNodeKvEntryKeyMapper_whenObjectMapper() {
    // Arrange
    JsonNodeFactory nc = JsonNodeFactory.withExactBigDecimals(true);
    ObjectNode entityNode = new ObjectNode(nc);
    JsonDataEntry kvEntry = new JsonDataEntry("Key", "42");

    // Act
    JacksonUtil.addKvEntry(entityNode, kvEntry, "Key", new ObjectMapper());

    // Assert
    Iterator<JsonNode> iteratorResult = entityNode.iterator();
    JsonNode nextResult = iteratorResult.next();
    assertTrue(nextResult instanceof IntNode);
    assertFalse(((IntNode) nextResult).isNaN());
    assertFalse(iteratorResult.hasNext());
    assertTrue(nextResult.isInt());
    assertTrue(nextResult.isIntegralNumber());
  }

  /**
   * Test {@link JacksonUtil#addKvEntry(ObjectNode, KvEntry, String)} with {@code entityNode},
   * {@code kvEntry}, {@code key}.
   *
   * <ul>
   *   <li>Then throw {@link IllegalArgumentException}.
   * </ul>
   *
   * <p>Method under test: {@link JacksonUtil#addKvEntry(ObjectNode, KvEntry, String)}
   */
  @Test
  @DisplayName(
      "Test addKvEntry(ObjectNode, KvEntry, String) with 'entityNode', 'kvEntry', 'key'; then throw IllegalArgumentException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void JacksonUtil.addKvEntry(ObjectNode, KvEntry, String)"})
  void testAddKvEntryWithEntityNodeKvEntryKey_thenThrowIllegalArgumentException() {
    // Arrange
    JsonNodeFactory nc = JsonNodeFactory.withExactBigDecimals(true);
    ObjectNode entityNode = new ObjectNode(nc);

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () -> JacksonUtil.addKvEntry(entityNode, new JsonDataEntry("Key", "Value"), "Key"));
  }

  /**
   * Test {@link JacksonUtil#addKvEntry(ObjectNode, KvEntry, String)} with {@code entityNode},
   * {@code kvEntry}, {@code key}.
   *
   * <ul>
   *   <li>When {@link JsonDataEntry#JsonDataEntry(String, String)} with {@code Key} and value is
   *       {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link JacksonUtil#addKvEntry(ObjectNode, KvEntry, String)}
   */
  @Test
  @DisplayName(
      "Test addKvEntry(ObjectNode, KvEntry, String) with 'entityNode', 'kvEntry', 'key'; when JsonDataEntry(String, String) with 'Key' and value is 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void JacksonUtil.addKvEntry(ObjectNode, KvEntry, String)"})
  void testAddKvEntryWithEntityNodeKvEntryKey_whenJsonDataEntryWithKeyAndValueIsNull() {
    // Arrange
    JsonNodeFactory nc = JsonNodeFactory.withExactBigDecimals(true);
    ObjectNode entityNode = new ObjectNode(nc);
    JsonDataEntry kvEntry = new JsonDataEntry("Key", null);

    // Act
    JacksonUtil.addKvEntry(entityNode, kvEntry, "Key");

    // Assert that nothing has changed
    assertFalse(entityNode.iterator().hasNext());
  }

  /**
   * Test {@link JacksonUtil#addKvEntry(ObjectNode, KvEntry)} with {@code entityNode}, {@code
   * kvEntry}.
   *
   * <ul>
   *   <li>Then throw {@link IllegalArgumentException}.
   * </ul>
   *
   * <p>Method under test: {@link JacksonUtil#addKvEntry(ObjectNode, KvEntry)}
   */
  @Test
  @DisplayName(
      "Test addKvEntry(ObjectNode, KvEntry) with 'entityNode', 'kvEntry'; then throw IllegalArgumentException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void JacksonUtil.addKvEntry(ObjectNode, KvEntry)"})
  void testAddKvEntryWithEntityNodeKvEntry_thenThrowIllegalArgumentException() {
    // Arrange
    JsonNodeFactory nc = JsonNodeFactory.withExactBigDecimals(true);
    ObjectNode entityNode = new ObjectNode(nc);

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () -> JacksonUtil.addKvEntry(entityNode, new JsonDataEntry("Key", "Value")));
  }

  /**
   * Test {@link JacksonUtil#addKvEntry(ObjectNode, KvEntry)} with {@code entityNode}, {@code
   * kvEntry}.
   *
   * <ul>
   *   <li>When {@link JsonDataEntry#JsonDataEntry(String, String)} with {@code Key} and value is
   *       {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link JacksonUtil#addKvEntry(ObjectNode, KvEntry)}
   */
  @Test
  @DisplayName(
      "Test addKvEntry(ObjectNode, KvEntry) with 'entityNode', 'kvEntry'; when JsonDataEntry(String, String) with 'Key' and value is 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void JacksonUtil.addKvEntry(ObjectNode, KvEntry)"})
  void testAddKvEntryWithEntityNodeKvEntry_whenJsonDataEntryWithKeyAndValueIsNull() {
    // Arrange
    JsonNodeFactory nc = JsonNodeFactory.withExactBigDecimals(true);
    ObjectNode entityNode = new ObjectNode(nc);
    JsonDataEntry kvEntry = new JsonDataEntry("Key", null);

    // Act
    JacksonUtil.addKvEntry(entityNode, kvEntry);

    // Assert that nothing has changed
    assertFalse(entityNode.iterator().hasNext());
  }
}
