package org.thingsboard.server.transport.lwm2m.secure;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.eclipse.leshan.core.SecurityMode;
import org.eclipse.leshan.server.bootstrap.BootstrapConfig;
import org.eclipse.leshan.server.security.SecurityInfo;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.thingsboard.server.common.data.DeviceProfile;
import org.thingsboard.server.common.transport.auth.ValidateDeviceCredentialsResponse;
import org.thingsboard.server.transport.lwm2m.bootstrap.secure.LwM2MBootstrapConfig;

class TbLwM2MSecurityInfoDiffblueTest {
  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>default or parameterless constructor of {@link TbLwM2MSecurityInfo}
   *   <li>{@link TbLwM2MSecurityInfo#setBootstrapConfig(BootstrapConfig)}
   *   <li>{@link TbLwM2MSecurityInfo#setBootstrapCredentialConfig(LwM2MBootstrapConfig)}
   *   <li>{@link TbLwM2MSecurityInfo#setDeviceProfile(DeviceProfile)}
   *   <li>{@link TbLwM2MSecurityInfo#setEndpoint(String)}
   *   <li>{@link TbLwM2MSecurityInfo#setSecurityInfo(SecurityInfo)}
   *   <li>{@link TbLwM2MSecurityInfo#setSecurityMode(SecurityMode)}
   *   <li>{@link TbLwM2MSecurityInfo#toString()}
   *   <li>{@link TbLwM2MSecurityInfo#getBootstrapConfig()}
   *   <li>{@link TbLwM2MSecurityInfo#getBootstrapCredentialConfig()}
   *   <li>{@link TbLwM2MSecurityInfo#getDeviceProfile()}
   *   <li>{@link TbLwM2MSecurityInfo#getEndpoint()}
   *   <li>{@link TbLwM2MSecurityInfo#getMsg()}
   *   <li>{@link TbLwM2MSecurityInfo#getSecurityInfo()}
   *   <li>{@link TbLwM2MSecurityInfo#getSecurityMode()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void TbLwM2MSecurityInfo.<init>()",
    "BootstrapConfig TbLwM2MSecurityInfo.getBootstrapConfig()",
    "LwM2MBootstrapConfig TbLwM2MSecurityInfo.getBootstrapCredentialConfig()",
    "DeviceProfile TbLwM2MSecurityInfo.getDeviceProfile()",
    "String TbLwM2MSecurityInfo.getEndpoint()",
    "ValidateDeviceCredentialsResponse TbLwM2MSecurityInfo.getMsg()",
    "SecurityInfo TbLwM2MSecurityInfo.getSecurityInfo()",
    "SecurityMode TbLwM2MSecurityInfo.getSecurityMode()",
    "void TbLwM2MSecurityInfo.setBootstrapConfig(BootstrapConfig)",
    "void TbLwM2MSecurityInfo.setBootstrapCredentialConfig(LwM2MBootstrapConfig)",
    "void TbLwM2MSecurityInfo.setDeviceProfile(DeviceProfile)",
    "void TbLwM2MSecurityInfo.setEndpoint(String)",
    "void TbLwM2MSecurityInfo.setMsg(ValidateDeviceCredentialsResponse)",
    "void TbLwM2MSecurityInfo.setSecurityInfo(SecurityInfo)",
    "void TbLwM2MSecurityInfo.setSecurityMode(SecurityMode)",
    "String TbLwM2MSecurityInfo.toString()"
  })
  void testGettersAndSetters() {
    // Arrange and Act
    TbLwM2MSecurityInfo actualTbLwM2MSecurityInfo = new TbLwM2MSecurityInfo();
    BootstrapConfig bootstrapConfig = new BootstrapConfig();
    actualTbLwM2MSecurityInfo.setBootstrapConfig(bootstrapConfig);
    LwM2MBootstrapConfig bootstrapCredentialConfig = new LwM2MBootstrapConfig();
    actualTbLwM2MSecurityInfo.setBootstrapCredentialConfig(bootstrapCredentialConfig);
    DeviceProfile deviceProfile = new DeviceProfile();
    actualTbLwM2MSecurityInfo.setDeviceProfile(deviceProfile);
    actualTbLwM2MSecurityInfo.setEndpoint("https://config.us-east-2.amazonaws.com");
    SecurityInfo securityInfo =
        SecurityInfo.newX509CertInfo("https://config.us-east-2.amazonaws.com");
    actualTbLwM2MSecurityInfo.setSecurityInfo(securityInfo);
    actualTbLwM2MSecurityInfo.setSecurityMode(SecurityMode.PSK);
    String actualToStringResult = actualTbLwM2MSecurityInfo.toString();
    BootstrapConfig actualBootstrapConfig = actualTbLwM2MSecurityInfo.getBootstrapConfig();
    LwM2MBootstrapConfig actualBootstrapCredentialConfig =
        actualTbLwM2MSecurityInfo.getBootstrapCredentialConfig();
    DeviceProfile actualDeviceProfile = actualTbLwM2MSecurityInfo.getDeviceProfile();
    String actualEndpoint = actualTbLwM2MSecurityInfo.getEndpoint();
    ValidateDeviceCredentialsResponse actualMsg = actualTbLwM2MSecurityInfo.getMsg();
    SecurityInfo actualSecurityInfo = actualTbLwM2MSecurityInfo.getSecurityInfo();

    // Assert
    assertEquals(
        "TbLwM2MSecurityInfo(msg=null, deviceProfile=DeviceProfile(tenantId=null, name=null, description=null,"
            + " isDefault=false, type=null, transportType=null, provisionType=null, defaultRuleChainId=null,"
            + " defaultDashboardId=null, defaultQueueName=null, profileData=null, provisionDeviceKey=null, firmwareId=null,"
            + " softwareId=null, defaultEdgeRuleChainId=null, externalId=null, version=null), endpoint=https://config"
            + ".us-east-2.amazonaws.com, securityInfo=SecurityInfo [endpoint=https://config.us-east-2.amazonaws.com,"
            + " identity=null, rawPublicKey=null, useX509Cert=true, oscoreIdentity=], securityMode=PSK, bootstrapCr"
            + "edentialConfig=LwM2MBootstrapConfig(serverConfiguration=null, bootstrapServer=null, lwm2mServer=null),"
            + " bootstrapConfig=BootstrapConfig [servers={}, security={}, acls={}, oscore={}])",
        actualToStringResult);
    assertEquals("https://config.us-east-2.amazonaws.com", actualEndpoint);
    assertNull(actualMsg);
    assertEquals(SecurityMode.PSK, actualTbLwM2MSecurityInfo.getSecurityMode());
    assertSame(bootstrapConfig, actualBootstrapConfig);
    assertSame(deviceProfile, actualDeviceProfile);
    assertSame(bootstrapCredentialConfig, actualBootstrapCredentialConfig);
    assertSame(securityInfo, actualSecurityInfo);
  }
}
