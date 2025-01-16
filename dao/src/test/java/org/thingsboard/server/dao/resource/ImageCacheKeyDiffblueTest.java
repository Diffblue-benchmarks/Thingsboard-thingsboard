package org.thingsboard.server.dao.resource;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;
import com.google.protobuf.DescriptorProtos;
import com.google.protobuf.Descriptors;
import com.google.protobuf.ProtocolStringList;
import com.google.protobuf.UnknownFieldSet;
import java.util.List;
import org.junit.Test;
import org.thingsboard.server.common.data.id.TenantId;
import org.thingsboard.server.dao.model.ModelConstants;
import org.thingsboard.server.gen.transport.TransportProtos;

public class ImageCacheKeyDiffblueTest {
  /**
   * Test {@link ImageCacheKey#forImage(TenantId, String)} with {@code tenantId},
   * {@code key}.
   * <p>
   * Method under test: {@link ImageCacheKey#forImage(TenantId, String)}
   */
  @Test
  public void testForImageWithTenantIdKey() {
    // Arrange
    TenantId tenantId = ModelConstants.SYSTEM_TENANT;

    // Act
    ImageCacheKey actualForImageResult = ImageCacheKey.forImage(tenantId, "Key");

    // Assert
    assertEquals("Key", actualForImageResult.getResourceKey());
    assertNull(actualForImageResult.getPublicResourceKey());
    assertFalse(actualForImageResult.isPreview());
    assertFalse(actualForImageResult.isPublic());
    TenantId expectedTenantId = tenantId.SYS_TENANT_ID;
    assertSame(expectedTenantId, actualForImageResult.getTenantId());
  }

  /**
   * Test {@link ImageCacheKey#forImage(TenantId, String, boolean)} with
   * {@code tenantId}, {@code key}, {@code preview}.
   * <p>
   * Method under test: {@link ImageCacheKey#forImage(TenantId, String, boolean)}
   */
  @Test
  public void testForImageWithTenantIdKeyPreview() {
    // Arrange
    TenantId tenantId = ModelConstants.SYSTEM_TENANT;

    // Act
    ImageCacheKey actualForImageResult = ImageCacheKey.forImage(tenantId, "Key", true);

    // Assert
    assertEquals("Key", actualForImageResult.getResourceKey());
    assertNull(actualForImageResult.getPublicResourceKey());
    assertFalse(actualForImageResult.isPublic());
    assertTrue(actualForImageResult.isPreview());
    TenantId expectedTenantId = tenantId.SYS_TENANT_ID;
    assertSame(expectedTenantId, actualForImageResult.getTenantId());
  }

  /**
   * Test {@link ImageCacheKey#forPublicImage(String)}.
   * <p>
   * Method under test: {@link ImageCacheKey#forPublicImage(String)}
   */
  @Test
  public void testForPublicImage() {
    // Arrange and Act
    ImageCacheKey actualForPublicImageResult = ImageCacheKey.forPublicImage("Public Key");

    // Assert
    assertEquals("Public Key", actualForPublicImageResult.getPublicResourceKey());
    assertNull(actualForPublicImageResult.getResourceKey());
    assertNull(actualForPublicImageResult.getTenantId());
    assertFalse(actualForPublicImageResult.isPreview());
    assertTrue(actualForPublicImageResult.isPublic());
  }

  /**
   * Test {@link ImageCacheKey#toProto()}.
   * <ul>
   *   <li>Given forPublicImage empty string.</li>
   *   <li>Then return SerializedSize is two.</li>
   * </ul>
   * <p>
   * Method under test: {@link ImageCacheKey#toProto()}
   */
  @Test
  public void testToProto_givenForPublicImageEmptyString_thenReturnSerializedSizeIsTwo() {
    // Arrange and Act
    TransportProtos.ImageCacheKeyProto actualToProtoResult = ImageCacheKey.forPublicImage("").toProto();

    // Assert
    Descriptors.Descriptor descriptorForType = actualToProtoResult.getDescriptorForType();
    List<Descriptors.OneofDescriptor> oneofs = descriptorForType.getOneofs();
    assertEquals(2, oneofs.size());
    Descriptors.OneofDescriptor getResult = oneofs.get(0);
    List<Descriptors.FieldDescriptor> fields = getResult.getFields();
    assertEquals(1, fields.size());
    Descriptors.OneofDescriptor getResult2 = oneofs.get(1);
    List<Descriptors.FieldDescriptor> fields2 = getResult2.getFields();
    assertEquals(1, fields2.size());
    Descriptors.FileDescriptor file = descriptorForType.getFile();
    DescriptorProtos.FileDescriptorProto toProtoResult = file.toProto();
    List<DescriptorProtos.EnumDescriptorProto> enumTypeList = toProtoResult.getEnumTypeList();
    assertEquals(10, enumTypeList.size());
    List<Descriptors.EnumDescriptor> enumTypes = file.getEnumTypes();
    assertEquals(10, enumTypes.size());
    List<DescriptorProtos.DescriptorProto> messageTypeList = toProtoResult.getMessageTypeList();
    assertEquals(180, messageTypeList.size());
    List<Descriptors.Descriptor> messageTypes = file.getMessageTypes();
    assertEquals(180, messageTypes.size());
    DescriptorProtos.DescriptorProto toProtoResult2 = descriptorForType.toProto();
    List<DescriptorProtos.FieldDescriptorProto> fieldList = toProtoResult2.getFieldList();
    assertEquals(2, fieldList.size());
    List<DescriptorProtos.OneofDescriptorProto> oneofDeclList = toProtoResult2.getOneofDeclList();
    assertEquals(2, oneofDeclList.size());
    List<Descriptors.FieldDescriptor> fields3 = descriptorForType.getFields();
    assertEquals(2, fields3.size());
    assertEquals(2, actualToProtoResult.getSerializedSize());
    DescriptorProtos.DescriptorProto defaultInstanceForType = toProtoResult2.getDefaultInstanceForType();
    assertSame(defaultInstanceForType.getDefaultInstanceForType(), defaultInstanceForType.getDefaultInstanceForType());
    Descriptors.Descriptor descriptorForType2 = toProtoResult2.getDescriptorForType();
    DescriptorProtos.DescriptorProto defaultInstanceForType2 = descriptorForType2.toProto().getDefaultInstanceForType();
    DescriptorProtos.MessageOptions options = descriptorForType.getOptions();
    Descriptors.Descriptor descriptorForType3 = options.getDescriptorForType();
    DescriptorProtos.DescriptorProto toProtoResult3 = descriptorForType3.toProto();
    assertSame(defaultInstanceForType2, toProtoResult3.getDefaultInstanceForType());
    assertSame(defaultInstanceForType2, defaultInstanceForType2);
    assertSame(fieldList, toProtoResult2.getFieldOrBuilderList());
    assertSame(oneofDeclList, toProtoResult2.getOneofDeclOrBuilderList());
    ProtocolStringList reservedNameList = toProtoResult2.getReservedNameList();
    assertSame(reservedNameList, defaultInstanceForType.getReservedNameList());
    assertSame(reservedNameList, toProtoResult3.getReservedNameList());
    DescriptorProtos.FileDescriptorProto defaultInstanceForType3 = toProtoResult.getDefaultInstanceForType();
    assertSame(reservedNameList, defaultInstanceForType3.getDependencyList());
    assertSame(reservedNameList, toProtoResult.getDependencyList());
    assertSame(defaultInstanceForType3.getDefaultInstanceForType(),
        defaultInstanceForType3.getDefaultInstanceForType());
    assertSame(enumTypeList, toProtoResult.getEnumTypeOrBuilderList());
    assertSame(messageTypeList, toProtoResult.getMessageTypeOrBuilderList());
    DescriptorProtos.SourceCodeInfo sourceCodeInfo = toProtoResult.getSourceCodeInfo();
    assertSame(sourceCodeInfo, defaultInstanceForType3.getSourceCodeInfo());
    assertSame(sourceCodeInfo, defaultInstanceForType3.getSourceCodeInfoOrBuilder());
    assertSame(sourceCodeInfo, toProtoResult.getSourceCodeInfoOrBuilder());
    assertSame(sourceCodeInfo, sourceCodeInfo.getDefaultInstanceForType());
    DescriptorProtos.FileOptions options2 = file.getOptions();
    DescriptorProtos.FileOptions defaultInstanceForType4 = options2.getDefaultInstanceForType();
    assertSame(defaultInstanceForType4.getDefaultInstanceForType(),
        defaultInstanceForType4.getDefaultInstanceForType());
    DescriptorProtos.FeatureSet features = options.getFeatures();
    assertSame(features, features.getDefaultInstanceForType());
    Descriptors.Descriptor getResult3 = messageTypes.get(0);
    assertSame(file, getResult3.getFile());
    Descriptors.Descriptor getResult4 = messageTypes.get(1);
    assertSame(file, getResult4.getFile());
    Descriptors.Descriptor getResult5 = messageTypes.get(178);
    assertSame(file, getResult5.getFile());
    Descriptors.Descriptor getResult6 = messageTypes.get(179);
    assertSame(file, getResult6.getFile());
    assertSame(file, enumTypes.get(0).getFile());
    assertSame(file, enumTypes.get(1).getFile());
    assertSame(file, enumTypes.get(8).getFile());
    assertSame(file, enumTypes.get(9).getFile());
    Descriptors.FieldDescriptor getResult7 = fields3.get(0);
    assertSame(file, getResult7.getFile());
    Descriptors.FieldDescriptor getResult8 = fields3.get(1);
    assertSame(file, getResult8.getFile());
    assertSame(file, getResult.getFile());
    assertSame(file, getResult2.getFile());
    DescriptorProtos.MessageOptions options3 = descriptorForType3.getOptions();
    assertSame(options3, defaultInstanceForType.getOptions());
    assertSame(options3, toProtoResult3.getOptions());
    assertSame(options3, toProtoResult2.getOptions());
    assertSame(options3, defaultInstanceForType.getOptionsOrBuilder());
    assertSame(options3, toProtoResult3.getOptionsOrBuilder());
    assertSame(options3, toProtoResult2.getOptionsOrBuilder());
    assertSame(options3, features.getDescriptorForType().getOptions());
    assertSame(options3, options3);
    assertSame(options3, descriptorForType2.getOptions());
    assertSame(options3, options2.getDescriptorForType().getOptions());
    assertSame(options3, toProtoResult.getDescriptorForType().getOptions());
    assertSame(options3, getResult3.getOptions());
    assertSame(options3, getResult4.getOptions());
    assertSame(options3, getResult5.getOptions());
    assertSame(options3, getResult6.getOptions());
    assertSame(options, options.getDefaultInstanceForType());
    DescriptorProtos.FieldOptions options4 = getResult7.getOptions();
    DescriptorProtos.FieldDescriptorProto toProtoResult4 = getResult7.toProto();
    assertSame(options4, toProtoResult4.getOptions());
    DescriptorProtos.FieldDescriptorProto toProtoResult5 = getResult8.toProto();
    assertSame(options4, toProtoResult5.getOptions());
    assertSame(options4, toProtoResult4.getOptionsOrBuilder());
    assertSame(options4, toProtoResult5.getOptionsOrBuilder());
    assertSame(options4, options4.getDefaultInstanceForType());
    assertSame(options4, getResult8.getOptions());
    assertSame(toProtoResult4, fieldList.get(0));
    DescriptorProtos.OneofOptions options5 = getResult.getOptions();
    DescriptorProtos.OneofDescriptorProto toProtoResult6 = getResult.toProto();
    assertSame(options5, toProtoResult6.getOptions());
    DescriptorProtos.OneofDescriptorProto toProtoResult7 = getResult2.toProto();
    assertSame(options5, toProtoResult7.getOptions());
    assertSame(options5, toProtoResult6.getOptionsOrBuilder());
    assertSame(options5, toProtoResult7.getOptionsOrBuilder());
    assertSame(options5, options5.getDefaultInstanceForType());
    assertSame(options5, getResult2.getOptions());
    assertSame(toProtoResult6, oneofDeclList.get(0));
    assertSame(descriptorForType, getResult7.getContainingType());
    assertSame(descriptorForType, getResult8.getContainingType());
    assertSame(descriptorForType, getResult.getContainingType());
    assertSame(descriptorForType, getResult2.getContainingType());
    TransportProtos.ImageCacheKeyProto defaultInstanceForType5 = actualToProtoResult.getDefaultInstanceForType();
    assertSame(descriptorForType, defaultInstanceForType5.getDescriptorForType());
    UnknownFieldSet unknownFields = actualToProtoResult.getUnknownFields();
    assertSame(unknownFields, defaultInstanceForType.getUnknownFields());
    assertSame(unknownFields, defaultInstanceForType3.getUnknownFields());
    assertSame(unknownFields, sourceCodeInfo.getUnknownFields());
    assertSame(unknownFields, defaultInstanceForType4.getUnknownFields());
    assertSame(unknownFields, features.getUnknownFields());
    assertSame(unknownFields, options.getUnknownFields());
    assertSame(unknownFields, toProtoResult3.getUnknownFields());
    assertSame(unknownFields, toProtoResult2.getUnknownFields());
    assertSame(unknownFields, options4.getUnknownFields());
    assertSame(unknownFields, toProtoResult4.getUnknownFields());
    assertSame(unknownFields, toProtoResult5.getUnknownFields());
    assertSame(unknownFields, options2.getUnknownFields());
    assertSame(unknownFields, toProtoResult.getUnknownFields());
    assertSame(unknownFields, options5.getUnknownFields());
    assertSame(unknownFields, toProtoResult6.getUnknownFields());
    assertSame(unknownFields, toProtoResult7.getUnknownFields());
    assertSame(unknownFields, defaultInstanceForType5.getUnknownFields());
    assertSame(unknownFields, unknownFields.getDefaultInstanceForType());
    assertSame(getResult7, fields.get(0));
    assertSame(getResult8, fields2.get(0));
    assertSame(getResult, getResult7.getContainingOneof());
    assertSame(getResult2, getResult8.getContainingOneof());
    assertSame(defaultInstanceForType5.getDefaultInstanceForType(),
        defaultInstanceForType5.getDefaultInstanceForType());
  }

  /**
   * Test {@link ImageCacheKey#isPublic()}.
   * <ul>
   *   <li>Given forPublicImage {@code null}.</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ImageCacheKey#isPublic()}
   */
  @Test
  public void testIsPublic_givenForPublicImageNull_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse(ImageCacheKey.forPublicImage(null).isPublic());
  }

  /**
   * Test {@link ImageCacheKey#isPublic()}.
   * <ul>
   *   <li>Given forPublicImage {@code Public Key}.</li>
   *   <li>Then return {@code true}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ImageCacheKey#isPublic()}
   */
  @Test
  public void testIsPublic_givenForPublicImagePublicKey_thenReturnTrue() {
    // Arrange, Act and Assert
    assertTrue(ImageCacheKey.forPublicImage("Public Key").isPublic());
  }

  /**
   * Test {@link ImageCacheKey#equals(Object)}, and
   * {@link ImageCacheKey#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link ImageCacheKey#equals(Object)}
   *   <li>{@link ImageCacheKey#hashCode()}
   * </ul>
   */
  @Test
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    ImageCacheKey forPublicImageResult = ImageCacheKey.forPublicImage("Public Key");
    ImageCacheKey forPublicImageResult2 = ImageCacheKey.forPublicImage("Public Key");

    // Act and Assert
    assertEquals(forPublicImageResult, forPublicImageResult2);
    int expectedHashCodeResult = forPublicImageResult.hashCode();
    assertEquals(expectedHashCodeResult, forPublicImageResult2.hashCode());
  }

  /**
   * Test {@link ImageCacheKey#equals(Object)}, and
   * {@link ImageCacheKey#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link ImageCacheKey#equals(Object)}
   *   <li>{@link ImageCacheKey#hashCode()}
   * </ul>
   */
  @Test
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual2() {
    // Arrange
    ImageCacheKey forPublicImageResult = ImageCacheKey.forPublicImage(null);
    ImageCacheKey forPublicImageResult2 = ImageCacheKey.forPublicImage(null);

    // Act and Assert
    assertEquals(forPublicImageResult, forPublicImageResult2);
    int expectedHashCodeResult = forPublicImageResult.hashCode();
    assertEquals(expectedHashCodeResult, forPublicImageResult2.hashCode());
  }

  /**
   * Test {@link ImageCacheKey#equals(Object)}, and
   * {@link ImageCacheKey#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link ImageCacheKey#equals(Object)}
   *   <li>{@link ImageCacheKey#hashCode()}
   * </ul>
   */
  @Test
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual3() {
    // Arrange
    ImageCacheKey forImageResult = ImageCacheKey.forImage(ModelConstants.SYSTEM_TENANT, "Public Key", true);
    ImageCacheKey forImageResult2 = ImageCacheKey.forImage(ModelConstants.SYSTEM_TENANT, "Public Key", true);

    // Act and Assert
    assertEquals(forImageResult, forImageResult2);
    int expectedHashCodeResult = forImageResult.hashCode();
    assertEquals(expectedHashCodeResult, forImageResult2.hashCode());
  }

  /**
   * Test {@link ImageCacheKey#equals(Object)}, and
   * {@link ImageCacheKey#hashCode()}.
   * <ul>
   *   <li>When other is same.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link ImageCacheKey#equals(Object)}
   *   <li>{@link ImageCacheKey#hashCode()}
   * </ul>
   */
  @Test
  public void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    ImageCacheKey forPublicImageResult = ImageCacheKey.forPublicImage("Public Key");

    // Act and Assert
    assertEquals(forPublicImageResult, forPublicImageResult);
    int expectedHashCodeResult = forPublicImageResult.hashCode();
    assertEquals(expectedHashCodeResult, forPublicImageResult.hashCode());
  }

  /**
   * Test {@link ImageCacheKey#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link ImageCacheKey#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    ImageCacheKey forPublicImageResult = ImageCacheKey.forPublicImage(null);

    // Act and Assert
    assertNotEquals(forPublicImageResult, ImageCacheKey.forPublicImage("Public Key"));
  }

  /**
   * Test {@link ImageCacheKey#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link ImageCacheKey#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    ImageCacheKey forPublicImageResult = ImageCacheKey
        .forPublicImage("org.thingsboard.server.dao.resource.ImageCacheKey");

    // Act and Assert
    assertNotEquals(forPublicImageResult, ImageCacheKey.forPublicImage("Public Key"));
  }

  /**
   * Test {@link ImageCacheKey#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link ImageCacheKey#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
    // Arrange
    ImageCacheKey forImageResult = ImageCacheKey.forImage(ModelConstants.SYSTEM_TENANT, "Public Key", true);

    // Act and Assert
    assertNotEquals(forImageResult, ImageCacheKey.forPublicImage("Public Key"));
  }

  /**
   * Test {@link ImageCacheKey#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link ImageCacheKey#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual4() {
    // Arrange
    ImageCacheKey forImageResult = ImageCacheKey.forImage(ModelConstants.SYSTEM_TENANT, "Public Key", false);

    // Act and Assert
    assertNotEquals(forImageResult, ImageCacheKey.forPublicImage("Public Key"));
  }

  /**
   * Test {@link ImageCacheKey#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link ImageCacheKey#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual5() {
    // Arrange
    ImageCacheKey forImageResult = ImageCacheKey.forImage(null, "Public Key", false);

    // Act and Assert
    assertNotEquals(forImageResult, ImageCacheKey.forPublicImage("Public Key"));
  }

  /**
   * Test {@link ImageCacheKey#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link ImageCacheKey#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual6() {
    // Arrange
    ImageCacheKey forImageResult = ImageCacheKey.forImage(null, "Public Key", true);

    // Act and Assert
    assertNotEquals(forImageResult, ImageCacheKey.forImage(ModelConstants.SYSTEM_TENANT, "Public Key", true));
  }

  /**
   * Test {@link ImageCacheKey#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link ImageCacheKey#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual7() {
    // Arrange
    ImageCacheKey forImageResult = ImageCacheKey.forImage(ModelConstants.SYSTEM_TENANT, null, true);

    // Act and Assert
    assertNotEquals(forImageResult, ImageCacheKey.forImage(ModelConstants.SYSTEM_TENANT, "Public Key", true));
  }

  /**
   * Test {@link ImageCacheKey#equals(Object)}.
   * <ul>
   *   <li>When other is {@code null}.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link ImageCacheKey#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(ImageCacheKey.forPublicImage("Public Key"), null);
  }

  /**
   * Test {@link ImageCacheKey#equals(Object)}.
   * <ul>
   *   <li>When other is wrong type.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link ImageCacheKey#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(ImageCacheKey.forPublicImage("Public Key"), "Different type to ImageCacheKey");
  }

  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link ImageCacheKey#toString()}
   *   <li>{@link ImageCacheKey#getPublicResourceKey()}
   *   <li>{@link ImageCacheKey#getResourceKey()}
   *   <li>{@link ImageCacheKey#getTenantId()}
   *   <li>{@link ImageCacheKey#isPreview()}
   * </ul>
   */
  @Test
  public void testGettersAndSetters() {
    // Arrange
    ImageCacheKey forPublicImageResult = ImageCacheKey.forPublicImage("Public Key");

    // Act
    String actualToStringResult = forPublicImageResult.toString();
    String actualPublicResourceKey = forPublicImageResult.getPublicResourceKey();
    String actualResourceKey = forPublicImageResult.getResourceKey();
    TenantId actualTenantId = forPublicImageResult.getTenantId();

    // Assert
    assertEquals("ImageCacheKey(tenantId=null, resourceKey=null, preview=false, publicResourceKey=Public Key)",
        actualToStringResult);
    assertEquals("Public Key", actualPublicResourceKey);
    assertNull(actualResourceKey);
    assertNull(actualTenantId);
    assertFalse(forPublicImageResult.isPreview());
  }

  /**
   * Test {@link ImageCacheKey#withPreview(boolean)}.
   * <p>
   * Method under test: {@link ImageCacheKey#withPreview(boolean)}
   */
  @Test
  public void testWithPreview() {
    // Arrange
    ImageCacheKey forImageResult = ImageCacheKey.forImage(ModelConstants.SYSTEM_TENANT, "Key", true);

    // Act and Assert
    assertSame(forImageResult, forImageResult.withPreview(true));
  }

  /**
   * Test {@link ImageCacheKey#withPreview(boolean)}.
   * <ul>
   *   <li>Then return PublicResourceKey is {@code Public Key}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ImageCacheKey#withPreview(boolean)}
   */
  @Test
  public void testWithPreview_thenReturnPublicResourceKeyIsPublicKey() {
    // Arrange and Act
    ImageCacheKey actualWithPreviewResult = ImageCacheKey.forPublicImage("Public Key").withPreview(true);

    // Assert
    assertEquals("Public Key", actualWithPreviewResult.getPublicResourceKey());
    assertNull(actualWithPreviewResult.getResourceKey());
    assertNull(actualWithPreviewResult.getTenantId());
    assertTrue(actualWithPreviewResult.isPublic());
  }
}
