package org.thingsboard.server.dao.model.sql;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;
import com.diffblue.cover.annotations.MaintainedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import com.fasterxml.jackson.databind.JsonNode;
import java.util.UUID;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.thingsboard.server.common.data.ota.ChecksumAlgorithm;
import org.thingsboard.server.common.data.ota.OtaPackageType;
import org.thingsboard.server.dao.customer.CustomerServiceImpl;

public class OtaPackageInfoEntityDiffblueTest {
  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link OtaPackageInfoEntity#OtaPackageInfoEntity()}
   *   <li>{@link OtaPackageInfoEntity#setAdditionalInfo(JsonNode)}
   *   <li>{@link OtaPackageInfoEntity#setChecksum(String)}
   *   <li>{@link OtaPackageInfoEntity#setChecksumAlgorithm(ChecksumAlgorithm)}
   *   <li>{@link OtaPackageInfoEntity#setContentType(String)}
   *   <li>{@link OtaPackageInfoEntity#setDataSize(Long)}
   *   <li>{@link OtaPackageInfoEntity#setDeviceProfileId(UUID)}
   *   <li>{@link OtaPackageInfoEntity#setFileName(String)}
   *   <li>{@link OtaPackageInfoEntity#setHasData(boolean)}
   *   <li>{@link OtaPackageInfoEntity#setTag(String)}
   *   <li>{@link OtaPackageInfoEntity#setTenantId(UUID)}
   *   <li>{@link OtaPackageInfoEntity#setTitle(String)}
   *   <li>{@link OtaPackageInfoEntity#setType(OtaPackageType)}
   *   <li>{@link OtaPackageInfoEntity#setUrl(String)}
   *   <li>{@link OtaPackageInfoEntity#setVersion(String)}
   *   <li>{@link OtaPackageInfoEntity#toString()}
   *   <li>{@link OtaPackageInfoEntity#getAdditionalInfo()}
   *   <li>{@link OtaPackageInfoEntity#getChecksum()}
   *   <li>{@link OtaPackageInfoEntity#getChecksumAlgorithm()}
   *   <li>{@link OtaPackageInfoEntity#getContentType()}
   *   <li>{@link OtaPackageInfoEntity#getDataSize()}
   *   <li>{@link OtaPackageInfoEntity#getDeviceProfileId()}
   *   <li>{@link OtaPackageInfoEntity#getFileName()}
   *   <li>{@link OtaPackageInfoEntity#getTag()}
   *   <li>{@link OtaPackageInfoEntity#getTenantId()}
   *   <li>{@link OtaPackageInfoEntity#getTitle()}
   *   <li>{@link OtaPackageInfoEntity#getType()}
   *   <li>{@link OtaPackageInfoEntity#getUrl()}
   *   <li>{@link OtaPackageInfoEntity#getVersion()}
   *   <li>{@link OtaPackageInfoEntity#isHasData()}
   * </ul>
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void OtaPackageInfoEntity.<init>()", "JsonNode OtaPackageInfoEntity.getAdditionalInfo()",
      "String OtaPackageInfoEntity.getChecksum()", "ChecksumAlgorithm OtaPackageInfoEntity.getChecksumAlgorithm()",
      "String OtaPackageInfoEntity.getContentType()", "Long OtaPackageInfoEntity.getDataSize()",
      "UUID OtaPackageInfoEntity.getDeviceProfileId()", "String OtaPackageInfoEntity.getFileName()",
      "String OtaPackageInfoEntity.getTag()", "UUID OtaPackageInfoEntity.getTenantId()",
      "String OtaPackageInfoEntity.getTitle()", "OtaPackageType OtaPackageInfoEntity.getType()",
      "String OtaPackageInfoEntity.getUrl()", "String OtaPackageInfoEntity.getVersion()",
      "boolean OtaPackageInfoEntity.isHasData()", "void OtaPackageInfoEntity.setAdditionalInfo(JsonNode)",
      "void OtaPackageInfoEntity.setChecksum(String)",
      "void OtaPackageInfoEntity.setChecksumAlgorithm(ChecksumAlgorithm)",
      "void OtaPackageInfoEntity.setContentType(String)", "void OtaPackageInfoEntity.setDataSize(Long)",
      "void OtaPackageInfoEntity.setDeviceProfileId(UUID)", "void OtaPackageInfoEntity.setFileName(String)",
      "void OtaPackageInfoEntity.setHasData(boolean)", "void OtaPackageInfoEntity.setTag(String)",
      "void OtaPackageInfoEntity.setTenantId(UUID)", "void OtaPackageInfoEntity.setTitle(String)",
      "void OtaPackageInfoEntity.setType(OtaPackageType)", "void OtaPackageInfoEntity.setUrl(String)",
      "void OtaPackageInfoEntity.setVersion(String)", "String OtaPackageInfoEntity.toString()"})
  public void testGettersAndSetters() {
    // Arrange and Act
    OtaPackageInfoEntity actualOtaPackageInfoEntity = new OtaPackageInfoEntity();
    JsonNode additionalInfo = CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON;
    actualOtaPackageInfoEntity.setAdditionalInfo(additionalInfo);
    actualOtaPackageInfoEntity.setChecksum("Checksum");
    actualOtaPackageInfoEntity.setChecksumAlgorithm(ChecksumAlgorithm.MD5);
    actualOtaPackageInfoEntity.setContentType("text/plain");
    actualOtaPackageInfoEntity.setDataSize(3L);
    UUID deviceProfileId = UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9");
    actualOtaPackageInfoEntity.setDeviceProfileId(deviceProfileId);
    actualOtaPackageInfoEntity.setFileName("foo.txt");
    actualOtaPackageInfoEntity.setHasData(true);
    actualOtaPackageInfoEntity.setTag("Tag");
    UUID tenantId = UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9");
    actualOtaPackageInfoEntity.setTenantId(tenantId);
    actualOtaPackageInfoEntity.setTitle("Dr");
    actualOtaPackageInfoEntity.setType(OtaPackageType.FIRMWARE);
    actualOtaPackageInfoEntity.setUrl("https://example.org/example");
    actualOtaPackageInfoEntity.setVersion("1.0.2");
    String actualToStringResult = actualOtaPackageInfoEntity.toString();
    JsonNode actualAdditionalInfo = actualOtaPackageInfoEntity.getAdditionalInfo();
    String actualChecksum = actualOtaPackageInfoEntity.getChecksum();
    ChecksumAlgorithm actualChecksumAlgorithm = actualOtaPackageInfoEntity.getChecksumAlgorithm();
    String actualContentType = actualOtaPackageInfoEntity.getContentType();
    Long actualDataSize = actualOtaPackageInfoEntity.getDataSize();
    UUID actualDeviceProfileId = actualOtaPackageInfoEntity.getDeviceProfileId();
    String actualFileName = actualOtaPackageInfoEntity.getFileName();
    String actualTag = actualOtaPackageInfoEntity.getTag();
    UUID actualTenantId = actualOtaPackageInfoEntity.getTenantId();
    String actualTitle = actualOtaPackageInfoEntity.getTitle();
    OtaPackageType actualType = actualOtaPackageInfoEntity.getType();
    String actualUrl = actualOtaPackageInfoEntity.getUrl();
    String actualVersion = actualOtaPackageInfoEntity.getVersion();
    boolean actualIsHasDataResult = actualOtaPackageInfoEntity.isHasData();

    // Assert
    assertEquals("1.0.2", actualVersion);
    assertEquals("784f394c-42b6-435a-983c-b7beff2784f9", actualDeviceProfileId.toString());
    assertEquals("784f394c-42b6-435a-983c-b7beff2784f9", actualTenantId.toString());
    assertEquals("Checksum", actualChecksum);
    assertEquals("Dr", actualTitle);
    assertEquals(
        "OtaPackageInfoEntity(tenantId=784f394c-42b6-435a-983c-b7beff2784f9, deviceProfileId=784f394c-42b6-435a"
            + "-983c-b7beff2784f9, type=FIRMWARE, title=Dr, version=1.0.2, tag=Tag, url=https://example.org/example,"
            + " fileName=foo.txt, contentType=text/plain, checksumAlgorithm=MD5, checksum=Checksum, dataSize=3,"
            + " additionalInfo={\"isPublic\":true}, hasData=true)",
        actualToStringResult);
    assertEquals("Tag", actualTag);
    assertEquals("foo.txt", actualFileName);
    assertEquals("https://example.org/example", actualUrl);
    assertEquals("text/plain", actualContentType);
    assertNull(actualOtaPackageInfoEntity.getId());
    assertNull(actualOtaPackageInfoEntity.getUuid());
    assertEquals(0L, actualOtaPackageInfoEntity.getCreatedTime());
    assertEquals(3L, actualDataSize.longValue());
    assertEquals(ChecksumAlgorithm.MD5, actualChecksumAlgorithm);
    assertEquals(OtaPackageType.FIRMWARE, actualType);
    assertTrue(actualIsHasDataResult);
    assertSame(deviceProfileId, actualDeviceProfileId);
    assertSame(tenantId, actualTenantId);
    assertSame(additionalInfo, actualAdditionalInfo);
  }
}
