package org.thingsboard.server.service.transport;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.google.protobuf.DescriptorProtos;
import com.google.protobuf.Descriptors;
import com.google.protobuf.ProtocolStringList;
import com.google.protobuf.UnknownFieldSet;
import java.util.List;
import java.util.UUID;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.thingsboard.server.cache.ota.OtaPackageDataCache;
import org.thingsboard.server.cluster.TbClusterService;
import org.thingsboard.server.common.data.DeviceProfile;
import org.thingsboard.server.common.data.EntityType;
import org.thingsboard.server.common.data.id.TenantId;
import org.thingsboard.server.common.data.security.DeviceCredentials;
import org.thingsboard.server.dao.device.DeviceCredentialsService;
import org.thingsboard.server.dao.device.DeviceProfileService;
import org.thingsboard.server.dao.device.DeviceProvisionService;
import org.thingsboard.server.dao.device.DeviceService;
import org.thingsboard.server.dao.device.provision.ProvisionFailedException;
import org.thingsboard.server.dao.exception.EntitiesLimitException;
import org.thingsboard.server.dao.ota.OtaPackageService;
import org.thingsboard.server.dao.queue.QueueService;
import org.thingsboard.server.dao.relation.RelationService;
import org.thingsboard.server.dao.resource.ResourceService;
import org.thingsboard.server.dao.tenant.TbTenantProfileCache;
import org.thingsboard.server.gen.transport.TransportProtos;
import org.thingsboard.server.service.apiusage.TbApiUsageStateService;
import org.thingsboard.server.service.profile.TbDeviceProfileCache;

class DefaultTransportApiServiceDiffblueTest {
  /**
   * Test
   * {@link DefaultTransportApiService#validateOrCreateDeviceX509Certificate(String)}.
   * <p>
   * Method under test:
   * {@link DefaultTransportApiService#validateOrCreateDeviceX509Certificate(String)}
   */
  @Test
  @DisplayName("Test validateOrCreateDeviceX509Certificate(String)")
  void testValidateOrCreateDeviceX509Certificate() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    DeviceProfileService deviceProfileService = mock(DeviceProfileService.class);
    when(deviceProfileService.findDeviceProfileByProvisionDeviceKey(Mockito.<String>any()))
        .thenReturn(new DeviceProfile());
    DeviceCredentialsService deviceCredentialsService = mock(DeviceCredentialsService.class);
    when(deviceCredentialsService.findDeviceCredentialsByCredentialsId(Mockito.<String>any()))
        .thenReturn(new DeviceCredentials());

    // Act
    TransportProtos.TransportApiResponseMsg actualValidateOrCreateDeviceX509CertificateResult = (new DefaultTransportApiService(
        mock(TbDeviceProfileCache.class), mock(TbTenantProfileCache.class), mock(TbApiUsageStateService.class),
        mock(DeviceService.class), deviceProfileService, mock(RelationService.class), deviceCredentialsService,
        mock(TbClusterService.class), mock(DeviceProvisionService.class), mock(ResourceService.class),
        mock(OtaPackageService.class), mock(OtaPackageDataCache.class), mock(QueueService.class)))
        .validateOrCreateDeviceX509Certificate("-----BEGIN CERTIFICATE----- UU -----END CERTIFICATE-----");

    // Assert
    verify(deviceCredentialsService)
        .findDeviceCredentialsByCredentialsId(eq("64ce14fc143a2fb2edbeee035a7ee6fa4aa392a95218cbbc51816f74de559d59"));
    verify(deviceProfileService)
        .findDeviceProfileByProvisionDeviceKey(eq("64ce14fc143a2fb2edbeee035a7ee6fa4aa392a95218cbbc51816f74de559d59"));
    Descriptors.Descriptor descriptorForType = actualValidateOrCreateDeviceX509CertificateResult.getDescriptorForType();
    List<Descriptors.FieldDescriptor> fields = descriptorForType.getFields();
    assertEquals(11, fields.size());
    Descriptors.FileDescriptor file = descriptorForType.getFile();
    DescriptorProtos.FileDescriptorProto toProtoResult = file.toProto();
    List<Integer> expectedWeakDependencyList = toProtoResult.getPublicDependencyList();
    assertSame(expectedWeakDependencyList, toProtoResult.getWeakDependencyList());
    TransportProtos.GetDeviceCredentialsResponseMsg deviceCredentialsResponseMsg = actualValidateOrCreateDeviceX509CertificateResult
        .getDeviceCredentialsResponseMsg();
    Descriptors.Descriptor descriptorForType2 = deviceCredentialsResponseMsg.getDescriptorForType();
    assertSame(file, descriptorForType2.getFile());
    TransportProtos.GetDeviceResponseMsg deviceResponseMsg = actualValidateOrCreateDeviceX509CertificateResult
        .getDeviceResponseMsg();
    assertSame(file, deviceResponseMsg.getDescriptorForType().getFile());
    TransportProtos.GetEntityProfileResponseMsg entityProfileResponseMsg = actualValidateOrCreateDeviceX509CertificateResult
        .getEntityProfileResponseMsg();
    assertSame(file, entityProfileResponseMsg.getDescriptorForType().getFile());
    TransportProtos.GetOrCreateDeviceFromGatewayResponseMsg getOrCreateDeviceResponseMsg = actualValidateOrCreateDeviceX509CertificateResult
        .getGetOrCreateDeviceResponseMsg();
    Descriptors.Descriptor descriptorForType3 = getOrCreateDeviceResponseMsg.getDescriptorForType();
    assertSame(file, descriptorForType3.getFile());
    TransportProtos.LwM2MResponseMsg lwM2MResponseMsg = actualValidateOrCreateDeviceX509CertificateResult
        .getLwM2MResponseMsg();
    assertSame(file, lwM2MResponseMsg.getDescriptorForType().getFile());
    TransportProtos.GetOtaPackageResponseMsg otaPackageResponseMsg = actualValidateOrCreateDeviceX509CertificateResult
        .getOtaPackageResponseMsg();
    assertSame(file, otaPackageResponseMsg.getDescriptorForType().getFile());
    TransportProtos.ProvisionDeviceResponseMsg provisionDeviceResponseMsg = actualValidateOrCreateDeviceX509CertificateResult
        .getProvisionDeviceResponseMsg();
    assertSame(file, provisionDeviceResponseMsg.getDescriptorForType().getFile());
    TransportProtos.GetResourceResponseMsg resourceResponseMsg = actualValidateOrCreateDeviceX509CertificateResult
        .getResourceResponseMsg();
    assertSame(file, resourceResponseMsg.getDescriptorForType().getFile());
    TransportProtos.GetSnmpDevicesResponseMsg snmpDevicesResponseMsg = actualValidateOrCreateDeviceX509CertificateResult
        .getSnmpDevicesResponseMsg();
    assertSame(file, snmpDevicesResponseMsg.getDescriptorForType().getFile());
    TransportProtos.ValidateDeviceCredentialsResponseMsg validateCredResponseMsg = actualValidateOrCreateDeviceX509CertificateResult
        .getValidateCredResponseMsg();
    Descriptors.Descriptor descriptorForType4 = validateCredResponseMsg.getDescriptorForType();
    assertSame(file, descriptorForType4.getFile());
    Descriptors.FieldDescriptor getResult = fields.get(0);
    assertSame(file, getResult.getFile());
    Descriptors.FieldDescriptor getResult2 = fields.get(1);
    assertSame(file, getResult2.getFile());
    Descriptors.FieldDescriptor getResult3 = fields.get(10);
    assertSame(file, getResult3.getFile());
    Descriptors.FieldDescriptor getResult4 = fields.get(9);
    assertSame(file, getResult4.getFile());
    DescriptorProtos.MessageOptions options = descriptorForType.getOptions();
    assertSame(options, options.getDefaultInstanceForType());
    DescriptorProtos.FileOptions options2 = file.getOptions();
    assertSame(options2, toProtoResult.getOptions());
    assertSame(options2, toProtoResult.getOptionsOrBuilder());
    assertSame(descriptorForType2, getResult4.getMessageType());
    assertSame(descriptorForType3, getResult2.getMessageType());
    assertSame(descriptorForType4, getResult.getMessageType());
    assertSame(descriptorForType, getResult.getContainingType());
    assertSame(descriptorForType, getResult2.getContainingType());
    assertSame(descriptorForType, getResult3.getContainingType());
    assertSame(descriptorForType, getResult4.getContainingType());
    TransportProtos.TransportApiResponseMsg defaultInstanceForType = actualValidateOrCreateDeviceX509CertificateResult
        .getDefaultInstanceForType();
    assertSame(descriptorForType, defaultInstanceForType.getDescriptorForType());
    UnknownFieldSet unknownFields = actualValidateOrCreateDeviceX509CertificateResult.getUnknownFields();
    assertSame(unknownFields, options.getUnknownFields());
    DescriptorProtos.DescriptorProto toProtoResult2 = descriptorForType.toProto();
    assertSame(unknownFields, toProtoResult2.getUnknownFields());
    assertSame(unknownFields, options2.getUnknownFields());
    assertSame(unknownFields, toProtoResult.getUnknownFields());
    TransportProtos.DeviceCredentialsProto deviceCredentialsData = deviceCredentialsResponseMsg
        .getDeviceCredentialsData();
    assertSame(unknownFields, deviceCredentialsData.getUnknownFields());
    TransportProtos.ApiUsageStateProto apiState = entityProfileResponseMsg.getApiState();
    assertSame(unknownFields, apiState.getUnknownFields());
    TransportProtos.DeviceProfileProto deviceProfile = entityProfileResponseMsg.getDeviceProfile();
    assertSame(unknownFields, deviceProfile.getUnknownFields());
    TransportProtos.TenantProfileProto tenantProfile = entityProfileResponseMsg.getTenantProfile();
    assertSame(unknownFields, tenantProfile.getUnknownFields());
    TransportProtos.DeviceInfoProto deviceInfo = getOrCreateDeviceResponseMsg.getDeviceInfo();
    assertSame(unknownFields, deviceInfo.getUnknownFields());
    TransportProtos.TbResourceProto resource = resourceResponseMsg.getResource();
    assertSame(unknownFields, resource.getUnknownFields());
    TransportProtos.LwM2MRegistrationResponseMsg registrationMsg = lwM2MResponseMsg.getRegistrationMsg();
    assertSame(unknownFields, registrationMsg.getUnknownFields());
    assertSame(unknownFields, defaultInstanceForType.getUnknownFields());
    assertSame(unknownFields, deviceCredentialsResponseMsg.getUnknownFields());
    assertSame(unknownFields, deviceResponseMsg.getUnknownFields());
    assertSame(unknownFields, entityProfileResponseMsg.getUnknownFields());
    assertSame(unknownFields, getOrCreateDeviceResponseMsg.getUnknownFields());
    assertSame(unknownFields, lwM2MResponseMsg.getUnknownFields());
    assertSame(unknownFields, otaPackageResponseMsg.getUnknownFields());
    assertSame(unknownFields, provisionDeviceResponseMsg.getUnknownFields());
    assertSame(unknownFields, resourceResponseMsg.getUnknownFields());
    assertSame(unknownFields, snmpDevicesResponseMsg.getUnknownFields());
    assertSame(unknownFields, validateCredResponseMsg.getUnknownFields());
    assertSame(unknownFields, unknownFields.getDefaultInstanceForType());
    assertSame(deviceCredentialsData, deviceCredentialsData.getDefaultInstanceForType());
    assertSame(deviceCredentialsData, deviceCredentialsResponseMsg.getDeviceCredentialsDataOrBuilder());
    assertSame(apiState, apiState.getDefaultInstanceForType());
    assertSame(apiState, entityProfileResponseMsg.getApiStateOrBuilder());
    assertSame(deviceProfile, deviceProfile.getDefaultInstanceForType());
    assertSame(deviceProfile, entityProfileResponseMsg.getDeviceProfileOrBuilder());
    assertSame(deviceProfile, getOrCreateDeviceResponseMsg.getDeviceProfile());
    assertSame(deviceProfile, getOrCreateDeviceResponseMsg.getDeviceProfileOrBuilder());
    assertSame(deviceProfile, validateCredResponseMsg.getDeviceProfile());
    assertSame(deviceProfile, validateCredResponseMsg.getDeviceProfileOrBuilder());
    assertSame(tenantProfile, entityProfileResponseMsg.getTenantProfileOrBuilder());
    assertSame(tenantProfile, tenantProfile.getDefaultInstanceForType());
    assertSame(deviceInfo, deviceInfo.getDefaultInstanceForType());
    assertSame(deviceInfo, getOrCreateDeviceResponseMsg.getDeviceInfoOrBuilder());
    assertSame(deviceInfo, registrationMsg.getDeviceInfo());
    assertSame(deviceInfo, registrationMsg.getDeviceInfoOrBuilder());
    assertSame(deviceInfo, validateCredResponseMsg.getDeviceInfo());
    assertSame(deviceInfo, validateCredResponseMsg.getDeviceInfoOrBuilder());
    assertSame(resource, resourceResponseMsg.getResourceOrBuilder());
    assertSame(resource, resource.getDefaultInstanceForType());
    ProtocolStringList idsList = snmpDevicesResponseMsg.getIdsList();
    assertSame(idsList, toProtoResult2.getReservedNameList());
    assertSame(idsList, toProtoResult.getDependencyList());
    assertSame(registrationMsg, registrationMsg.getDefaultInstanceForType());
    assertSame(registrationMsg, lwM2MResponseMsg.getRegistrationMsgOrBuilder());
    assertSame(defaultInstanceForType.getDefaultInstanceForType(), defaultInstanceForType.getDefaultInstanceForType());
    assertSame(deviceCredentialsResponseMsg, deviceCredentialsResponseMsg.getDefaultInstanceForType());
    assertSame(deviceCredentialsResponseMsg, defaultInstanceForType.getDeviceCredentialsResponseMsg());
    assertSame(deviceCredentialsResponseMsg, defaultInstanceForType.getDeviceCredentialsResponseMsgOrBuilder());
    assertSame(deviceCredentialsResponseMsg,
        actualValidateOrCreateDeviceX509CertificateResult.getDeviceCredentialsResponseMsgOrBuilder());
    assertSame(deviceResponseMsg, deviceResponseMsg.getDefaultInstanceForType());
    assertSame(deviceResponseMsg, defaultInstanceForType.getDeviceResponseMsg());
    assertSame(deviceResponseMsg, defaultInstanceForType.getDeviceResponseMsgOrBuilder());
    assertSame(deviceResponseMsg, actualValidateOrCreateDeviceX509CertificateResult.getDeviceResponseMsgOrBuilder());
    assertSame(entityProfileResponseMsg, entityProfileResponseMsg.getDefaultInstanceForType());
    assertSame(entityProfileResponseMsg, defaultInstanceForType.getEntityProfileResponseMsg());
    assertSame(entityProfileResponseMsg, defaultInstanceForType.getEntityProfileResponseMsgOrBuilder());
    assertSame(entityProfileResponseMsg,
        actualValidateOrCreateDeviceX509CertificateResult.getEntityProfileResponseMsgOrBuilder());
    assertSame(getOrCreateDeviceResponseMsg, getOrCreateDeviceResponseMsg.getDefaultInstanceForType());
    assertSame(getOrCreateDeviceResponseMsg, defaultInstanceForType.getGetOrCreateDeviceResponseMsg());
    assertSame(getOrCreateDeviceResponseMsg, defaultInstanceForType.getGetOrCreateDeviceResponseMsgOrBuilder());
    assertSame(getOrCreateDeviceResponseMsg,
        actualValidateOrCreateDeviceX509CertificateResult.getGetOrCreateDeviceResponseMsgOrBuilder());
    assertSame(lwM2MResponseMsg, lwM2MResponseMsg.getDefaultInstanceForType());
    assertSame(lwM2MResponseMsg, defaultInstanceForType.getLwM2MResponseMsg());
    assertSame(lwM2MResponseMsg, defaultInstanceForType.getLwM2MResponseMsgOrBuilder());
    assertSame(lwM2MResponseMsg, actualValidateOrCreateDeviceX509CertificateResult.getLwM2MResponseMsgOrBuilder());
    assertSame(otaPackageResponseMsg, otaPackageResponseMsg.getDefaultInstanceForType());
    assertSame(otaPackageResponseMsg, defaultInstanceForType.getOtaPackageResponseMsg());
    assertSame(otaPackageResponseMsg, defaultInstanceForType.getOtaPackageResponseMsgOrBuilder());
    assertSame(otaPackageResponseMsg,
        actualValidateOrCreateDeviceX509CertificateResult.getOtaPackageResponseMsgOrBuilder());
    assertSame(provisionDeviceResponseMsg, provisionDeviceResponseMsg.getDefaultInstanceForType());
    assertSame(provisionDeviceResponseMsg, defaultInstanceForType.getProvisionDeviceResponseMsg());
    assertSame(provisionDeviceResponseMsg, defaultInstanceForType.getProvisionDeviceResponseMsgOrBuilder());
    assertSame(provisionDeviceResponseMsg,
        actualValidateOrCreateDeviceX509CertificateResult.getProvisionDeviceResponseMsgOrBuilder());
    assertSame(resourceResponseMsg, resourceResponseMsg.getDefaultInstanceForType());
    assertSame(resourceResponseMsg, defaultInstanceForType.getResourceResponseMsg());
    assertSame(resourceResponseMsg, defaultInstanceForType.getResourceResponseMsgOrBuilder());
    assertSame(resourceResponseMsg,
        actualValidateOrCreateDeviceX509CertificateResult.getResourceResponseMsgOrBuilder());
    assertSame(snmpDevicesResponseMsg, snmpDevicesResponseMsg.getDefaultInstanceForType());
    assertSame(snmpDevicesResponseMsg, defaultInstanceForType.getSnmpDevicesResponseMsg());
    assertSame(snmpDevicesResponseMsg, defaultInstanceForType.getSnmpDevicesResponseMsgOrBuilder());
    assertSame(snmpDevicesResponseMsg,
        actualValidateOrCreateDeviceX509CertificateResult.getSnmpDevicesResponseMsgOrBuilder());
    assertSame(validateCredResponseMsg, defaultInstanceForType.getValidateCredResponseMsg());
    assertSame(validateCredResponseMsg, defaultInstanceForType.getValidateCredResponseMsgOrBuilder());
    assertSame(validateCredResponseMsg,
        actualValidateOrCreateDeviceX509CertificateResult.getValidateCredResponseMsgOrBuilder());
    assertSame(validateCredResponseMsg, validateCredResponseMsg.getDefaultInstanceForType());
  }

  /**
   * Test
   * {@link DefaultTransportApiService#validateOrCreateDeviceX509Certificate(String)}.
   * <p>
   * Method under test:
   * {@link DefaultTransportApiService#validateOrCreateDeviceX509Certificate(String)}
   */
  @Test
  @DisplayName("Test validateOrCreateDeviceX509Certificate(String)")
  void testValidateOrCreateDeviceX509Certificate2() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    DeviceCredentialsService deviceCredentialsService = mock(DeviceCredentialsService.class);
    when(deviceCredentialsService.findDeviceCredentialsByCredentialsId(Mockito.<String>any()))
        .thenThrow(new ProvisionFailedException("An error occurred"));

    // Act and Assert
    assertThrows(ProvisionFailedException.class,
        () -> (new DefaultTransportApiService(mock(TbDeviceProfileCache.class), mock(TbTenantProfileCache.class),
            mock(TbApiUsageStateService.class), mock(DeviceService.class), mock(DeviceProfileService.class),
            mock(RelationService.class), deviceCredentialsService, mock(TbClusterService.class),
            mock(DeviceProvisionService.class), mock(ResourceService.class), mock(OtaPackageService.class),
            mock(OtaPackageDataCache.class), mock(QueueService.class)))
            .validateOrCreateDeviceX509Certificate("-----BEGIN CERTIFICATE----- UU -----END CERTIFICATE-----"));
    verify(deviceCredentialsService)
        .findDeviceCredentialsByCredentialsId(eq("64ce14fc143a2fb2edbeee035a7ee6fa4aa392a95218cbbc51816f74de559d59"));
  }

  /**
   * Test
   * {@link DefaultTransportApiService#validateOrCreateDeviceX509Certificate(String)}.
   * <p>
   * Method under test:
   * {@link DefaultTransportApiService#validateOrCreateDeviceX509Certificate(String)}
   */
  @Test
  @DisplayName("Test validateOrCreateDeviceX509Certificate(String)")
  void testValidateOrCreateDeviceX509Certificate3() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    DeviceProfileService deviceProfileService = mock(DeviceProfileService.class);
    when(deviceProfileService.findDeviceProfileByProvisionDeviceKey(Mockito.<String>any())).thenReturn(null);
    DeviceCredentialsService deviceCredentialsService = mock(DeviceCredentialsService.class);
    when(deviceCredentialsService.findDeviceCredentialsByCredentialsId(Mockito.<String>any()))
        .thenReturn(new DeviceCredentials());

    // Act
    TransportProtos.TransportApiResponseMsg actualValidateOrCreateDeviceX509CertificateResult = (new DefaultTransportApiService(
        mock(TbDeviceProfileCache.class), mock(TbTenantProfileCache.class), mock(TbApiUsageStateService.class),
        mock(DeviceService.class), deviceProfileService, mock(RelationService.class), deviceCredentialsService,
        mock(TbClusterService.class), mock(DeviceProvisionService.class), mock(ResourceService.class),
        mock(OtaPackageService.class), mock(OtaPackageDataCache.class), mock(QueueService.class)))
        .validateOrCreateDeviceX509Certificate("-----BEGIN CERTIFICATE----- UU -----END CERTIFICATE-----");

    // Assert
    verify(deviceCredentialsService)
        .findDeviceCredentialsByCredentialsId(eq("64ce14fc143a2fb2edbeee035a7ee6fa4aa392a95218cbbc51816f74de559d59"));
    verify(deviceProfileService)
        .findDeviceProfileByProvisionDeviceKey(eq("64ce14fc143a2fb2edbeee035a7ee6fa4aa392a95218cbbc51816f74de559d59"));
    Descriptors.Descriptor descriptorForType = actualValidateOrCreateDeviceX509CertificateResult.getDescriptorForType();
    List<Descriptors.FieldDescriptor> fields = descriptorForType.getFields();
    assertEquals(11, fields.size());
    Descriptors.FileDescriptor file = descriptorForType.getFile();
    DescriptorProtos.FileDescriptorProto toProtoResult = file.toProto();
    List<Integer> expectedWeakDependencyList = toProtoResult.getPublicDependencyList();
    assertSame(expectedWeakDependencyList, toProtoResult.getWeakDependencyList());
    TransportProtos.GetDeviceCredentialsResponseMsg deviceCredentialsResponseMsg = actualValidateOrCreateDeviceX509CertificateResult
        .getDeviceCredentialsResponseMsg();
    Descriptors.Descriptor descriptorForType2 = deviceCredentialsResponseMsg.getDescriptorForType();
    assertSame(file, descriptorForType2.getFile());
    TransportProtos.GetDeviceResponseMsg deviceResponseMsg = actualValidateOrCreateDeviceX509CertificateResult
        .getDeviceResponseMsg();
    assertSame(file, deviceResponseMsg.getDescriptorForType().getFile());
    TransportProtos.GetEntityProfileResponseMsg entityProfileResponseMsg = actualValidateOrCreateDeviceX509CertificateResult
        .getEntityProfileResponseMsg();
    assertSame(file, entityProfileResponseMsg.getDescriptorForType().getFile());
    TransportProtos.GetOrCreateDeviceFromGatewayResponseMsg getOrCreateDeviceResponseMsg = actualValidateOrCreateDeviceX509CertificateResult
        .getGetOrCreateDeviceResponseMsg();
    Descriptors.Descriptor descriptorForType3 = getOrCreateDeviceResponseMsg.getDescriptorForType();
    assertSame(file, descriptorForType3.getFile());
    TransportProtos.LwM2MResponseMsg lwM2MResponseMsg = actualValidateOrCreateDeviceX509CertificateResult
        .getLwM2MResponseMsg();
    assertSame(file, lwM2MResponseMsg.getDescriptorForType().getFile());
    TransportProtos.GetOtaPackageResponseMsg otaPackageResponseMsg = actualValidateOrCreateDeviceX509CertificateResult
        .getOtaPackageResponseMsg();
    assertSame(file, otaPackageResponseMsg.getDescriptorForType().getFile());
    TransportProtos.ProvisionDeviceResponseMsg provisionDeviceResponseMsg = actualValidateOrCreateDeviceX509CertificateResult
        .getProvisionDeviceResponseMsg();
    assertSame(file, provisionDeviceResponseMsg.getDescriptorForType().getFile());
    TransportProtos.GetResourceResponseMsg resourceResponseMsg = actualValidateOrCreateDeviceX509CertificateResult
        .getResourceResponseMsg();
    assertSame(file, resourceResponseMsg.getDescriptorForType().getFile());
    TransportProtos.GetSnmpDevicesResponseMsg snmpDevicesResponseMsg = actualValidateOrCreateDeviceX509CertificateResult
        .getSnmpDevicesResponseMsg();
    assertSame(file, snmpDevicesResponseMsg.getDescriptorForType().getFile());
    TransportProtos.ValidateDeviceCredentialsResponseMsg validateCredResponseMsg = actualValidateOrCreateDeviceX509CertificateResult
        .getValidateCredResponseMsg();
    Descriptors.Descriptor descriptorForType4 = validateCredResponseMsg.getDescriptorForType();
    assertSame(file, descriptorForType4.getFile());
    Descriptors.FieldDescriptor getResult = fields.get(0);
    assertSame(file, getResult.getFile());
    Descriptors.FieldDescriptor getResult2 = fields.get(1);
    assertSame(file, getResult2.getFile());
    Descriptors.FieldDescriptor getResult3 = fields.get(10);
    assertSame(file, getResult3.getFile());
    Descriptors.FieldDescriptor getResult4 = fields.get(9);
    assertSame(file, getResult4.getFile());
    DescriptorProtos.MessageOptions options = descriptorForType.getOptions();
    assertSame(options, options.getDefaultInstanceForType());
    DescriptorProtos.FileOptions options2 = file.getOptions();
    assertSame(options2, toProtoResult.getOptions());
    assertSame(options2, toProtoResult.getOptionsOrBuilder());
    assertSame(descriptorForType2, getResult4.getMessageType());
    assertSame(descriptorForType3, getResult2.getMessageType());
    assertSame(descriptorForType4, getResult.getMessageType());
    assertSame(descriptorForType, getResult.getContainingType());
    assertSame(descriptorForType, getResult2.getContainingType());
    assertSame(descriptorForType, getResult3.getContainingType());
    assertSame(descriptorForType, getResult4.getContainingType());
    TransportProtos.TransportApiResponseMsg defaultInstanceForType = actualValidateOrCreateDeviceX509CertificateResult
        .getDefaultInstanceForType();
    assertSame(descriptorForType, defaultInstanceForType.getDescriptorForType());
    UnknownFieldSet unknownFields = actualValidateOrCreateDeviceX509CertificateResult.getUnknownFields();
    assertSame(unknownFields, options.getUnknownFields());
    DescriptorProtos.DescriptorProto toProtoResult2 = descriptorForType.toProto();
    assertSame(unknownFields, toProtoResult2.getUnknownFields());
    assertSame(unknownFields, options2.getUnknownFields());
    assertSame(unknownFields, toProtoResult.getUnknownFields());
    TransportProtos.DeviceCredentialsProto deviceCredentialsData = deviceCredentialsResponseMsg
        .getDeviceCredentialsData();
    assertSame(unknownFields, deviceCredentialsData.getUnknownFields());
    TransportProtos.ApiUsageStateProto apiState = entityProfileResponseMsg.getApiState();
    assertSame(unknownFields, apiState.getUnknownFields());
    TransportProtos.DeviceProfileProto deviceProfile = entityProfileResponseMsg.getDeviceProfile();
    assertSame(unknownFields, deviceProfile.getUnknownFields());
    TransportProtos.TenantProfileProto tenantProfile = entityProfileResponseMsg.getTenantProfile();
    assertSame(unknownFields, tenantProfile.getUnknownFields());
    TransportProtos.DeviceInfoProto deviceInfo = getOrCreateDeviceResponseMsg.getDeviceInfo();
    assertSame(unknownFields, deviceInfo.getUnknownFields());
    TransportProtos.TbResourceProto resource = resourceResponseMsg.getResource();
    assertSame(unknownFields, resource.getUnknownFields());
    TransportProtos.LwM2MRegistrationResponseMsg registrationMsg = lwM2MResponseMsg.getRegistrationMsg();
    assertSame(unknownFields, registrationMsg.getUnknownFields());
    assertSame(unknownFields, defaultInstanceForType.getUnknownFields());
    assertSame(unknownFields, deviceCredentialsResponseMsg.getUnknownFields());
    assertSame(unknownFields, deviceResponseMsg.getUnknownFields());
    assertSame(unknownFields, entityProfileResponseMsg.getUnknownFields());
    assertSame(unknownFields, getOrCreateDeviceResponseMsg.getUnknownFields());
    assertSame(unknownFields, lwM2MResponseMsg.getUnknownFields());
    assertSame(unknownFields, otaPackageResponseMsg.getUnknownFields());
    assertSame(unknownFields, provisionDeviceResponseMsg.getUnknownFields());
    assertSame(unknownFields, resourceResponseMsg.getUnknownFields());
    assertSame(unknownFields, snmpDevicesResponseMsg.getUnknownFields());
    assertSame(unknownFields, validateCredResponseMsg.getUnknownFields());
    assertSame(unknownFields, unknownFields.getDefaultInstanceForType());
    assertSame(deviceCredentialsData, deviceCredentialsData.getDefaultInstanceForType());
    assertSame(deviceCredentialsData, deviceCredentialsResponseMsg.getDeviceCredentialsDataOrBuilder());
    assertSame(apiState, apiState.getDefaultInstanceForType());
    assertSame(apiState, entityProfileResponseMsg.getApiStateOrBuilder());
    assertSame(deviceProfile, deviceProfile.getDefaultInstanceForType());
    assertSame(deviceProfile, entityProfileResponseMsg.getDeviceProfileOrBuilder());
    assertSame(deviceProfile, getOrCreateDeviceResponseMsg.getDeviceProfile());
    assertSame(deviceProfile, getOrCreateDeviceResponseMsg.getDeviceProfileOrBuilder());
    assertSame(deviceProfile, validateCredResponseMsg.getDeviceProfile());
    assertSame(deviceProfile, validateCredResponseMsg.getDeviceProfileOrBuilder());
    assertSame(tenantProfile, entityProfileResponseMsg.getTenantProfileOrBuilder());
    assertSame(tenantProfile, tenantProfile.getDefaultInstanceForType());
    assertSame(deviceInfo, deviceInfo.getDefaultInstanceForType());
    assertSame(deviceInfo, getOrCreateDeviceResponseMsg.getDeviceInfoOrBuilder());
    assertSame(deviceInfo, registrationMsg.getDeviceInfo());
    assertSame(deviceInfo, registrationMsg.getDeviceInfoOrBuilder());
    assertSame(deviceInfo, validateCredResponseMsg.getDeviceInfo());
    assertSame(deviceInfo, validateCredResponseMsg.getDeviceInfoOrBuilder());
    assertSame(resource, resourceResponseMsg.getResourceOrBuilder());
    assertSame(resource, resource.getDefaultInstanceForType());
    ProtocolStringList idsList = snmpDevicesResponseMsg.getIdsList();
    assertSame(idsList, toProtoResult2.getReservedNameList());
    assertSame(idsList, toProtoResult.getDependencyList());
    assertSame(registrationMsg, registrationMsg.getDefaultInstanceForType());
    assertSame(registrationMsg, lwM2MResponseMsg.getRegistrationMsgOrBuilder());
    assertSame(defaultInstanceForType.getDefaultInstanceForType(), defaultInstanceForType.getDefaultInstanceForType());
    assertSame(deviceCredentialsResponseMsg, deviceCredentialsResponseMsg.getDefaultInstanceForType());
    assertSame(deviceCredentialsResponseMsg, defaultInstanceForType.getDeviceCredentialsResponseMsg());
    assertSame(deviceCredentialsResponseMsg, defaultInstanceForType.getDeviceCredentialsResponseMsgOrBuilder());
    assertSame(deviceCredentialsResponseMsg,
        actualValidateOrCreateDeviceX509CertificateResult.getDeviceCredentialsResponseMsgOrBuilder());
    assertSame(deviceResponseMsg, deviceResponseMsg.getDefaultInstanceForType());
    assertSame(deviceResponseMsg, defaultInstanceForType.getDeviceResponseMsg());
    assertSame(deviceResponseMsg, defaultInstanceForType.getDeviceResponseMsgOrBuilder());
    assertSame(deviceResponseMsg, actualValidateOrCreateDeviceX509CertificateResult.getDeviceResponseMsgOrBuilder());
    assertSame(entityProfileResponseMsg, entityProfileResponseMsg.getDefaultInstanceForType());
    assertSame(entityProfileResponseMsg, defaultInstanceForType.getEntityProfileResponseMsg());
    assertSame(entityProfileResponseMsg, defaultInstanceForType.getEntityProfileResponseMsgOrBuilder());
    assertSame(entityProfileResponseMsg,
        actualValidateOrCreateDeviceX509CertificateResult.getEntityProfileResponseMsgOrBuilder());
    assertSame(getOrCreateDeviceResponseMsg, getOrCreateDeviceResponseMsg.getDefaultInstanceForType());
    assertSame(getOrCreateDeviceResponseMsg, defaultInstanceForType.getGetOrCreateDeviceResponseMsg());
    assertSame(getOrCreateDeviceResponseMsg, defaultInstanceForType.getGetOrCreateDeviceResponseMsgOrBuilder());
    assertSame(getOrCreateDeviceResponseMsg,
        actualValidateOrCreateDeviceX509CertificateResult.getGetOrCreateDeviceResponseMsgOrBuilder());
    assertSame(lwM2MResponseMsg, lwM2MResponseMsg.getDefaultInstanceForType());
    assertSame(lwM2MResponseMsg, defaultInstanceForType.getLwM2MResponseMsg());
    assertSame(lwM2MResponseMsg, defaultInstanceForType.getLwM2MResponseMsgOrBuilder());
    assertSame(lwM2MResponseMsg, actualValidateOrCreateDeviceX509CertificateResult.getLwM2MResponseMsgOrBuilder());
    assertSame(otaPackageResponseMsg, otaPackageResponseMsg.getDefaultInstanceForType());
    assertSame(otaPackageResponseMsg, defaultInstanceForType.getOtaPackageResponseMsg());
    assertSame(otaPackageResponseMsg, defaultInstanceForType.getOtaPackageResponseMsgOrBuilder());
    assertSame(otaPackageResponseMsg,
        actualValidateOrCreateDeviceX509CertificateResult.getOtaPackageResponseMsgOrBuilder());
    assertSame(provisionDeviceResponseMsg, provisionDeviceResponseMsg.getDefaultInstanceForType());
    assertSame(provisionDeviceResponseMsg, defaultInstanceForType.getProvisionDeviceResponseMsg());
    assertSame(provisionDeviceResponseMsg, defaultInstanceForType.getProvisionDeviceResponseMsgOrBuilder());
    assertSame(provisionDeviceResponseMsg,
        actualValidateOrCreateDeviceX509CertificateResult.getProvisionDeviceResponseMsgOrBuilder());
    assertSame(resourceResponseMsg, resourceResponseMsg.getDefaultInstanceForType());
    assertSame(resourceResponseMsg, defaultInstanceForType.getResourceResponseMsg());
    assertSame(resourceResponseMsg, defaultInstanceForType.getResourceResponseMsgOrBuilder());
    assertSame(resourceResponseMsg,
        actualValidateOrCreateDeviceX509CertificateResult.getResourceResponseMsgOrBuilder());
    assertSame(snmpDevicesResponseMsg, snmpDevicesResponseMsg.getDefaultInstanceForType());
    assertSame(snmpDevicesResponseMsg, defaultInstanceForType.getSnmpDevicesResponseMsg());
    assertSame(snmpDevicesResponseMsg, defaultInstanceForType.getSnmpDevicesResponseMsgOrBuilder());
    assertSame(snmpDevicesResponseMsg,
        actualValidateOrCreateDeviceX509CertificateResult.getSnmpDevicesResponseMsgOrBuilder());
    assertSame(validateCredResponseMsg, defaultInstanceForType.getValidateCredResponseMsg());
    assertSame(validateCredResponseMsg, defaultInstanceForType.getValidateCredResponseMsgOrBuilder());
    assertSame(validateCredResponseMsg,
        actualValidateOrCreateDeviceX509CertificateResult.getValidateCredResponseMsgOrBuilder());
    assertSame(validateCredResponseMsg, validateCredResponseMsg.getDefaultInstanceForType());
  }

  /**
   * Test
   * {@link DefaultTransportApiService#validateOrCreateDeviceX509Certificate(String)}.
   * <p>
   * Method under test:
   * {@link DefaultTransportApiService#validateOrCreateDeviceX509Certificate(String)}
   */
  @Test
  @DisplayName("Test validateOrCreateDeviceX509Certificate(String)")
  void testValidateOrCreateDeviceX509Certificate4() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    DeviceProfile deviceProfile = mock(DeviceProfile.class);
    when(deviceProfile.getProvisionType())
        .thenThrow(new EntitiesLimitException(new TenantId(UUID.randomUUID()), EntityType.TENANT));
    DeviceProfileService deviceProfileService = mock(DeviceProfileService.class);
    when(deviceProfileService.findDeviceProfileByProvisionDeviceKey(Mockito.<String>any())).thenReturn(deviceProfile);
    DeviceCredentialsService deviceCredentialsService = mock(DeviceCredentialsService.class);
    when(deviceCredentialsService.findDeviceCredentialsByCredentialsId(Mockito.<String>any())).thenReturn(null);

    // Act and Assert
    assertThrows(EntitiesLimitException.class,
        () -> (new DefaultTransportApiService(mock(TbDeviceProfileCache.class), mock(TbTenantProfileCache.class),
            mock(TbApiUsageStateService.class), mock(DeviceService.class), deviceProfileService,
            mock(RelationService.class), deviceCredentialsService, mock(TbClusterService.class),
            mock(DeviceProvisionService.class), mock(ResourceService.class), mock(OtaPackageService.class),
            mock(OtaPackageDataCache.class), mock(QueueService.class)))
            .validateOrCreateDeviceX509Certificate("-----BEGIN CERTIFICATE----- UU -----END CERTIFICATE-----"));
    verify(deviceProfile).getProvisionType();
    verify(deviceCredentialsService)
        .findDeviceCredentialsByCredentialsId(eq("64ce14fc143a2fb2edbeee035a7ee6fa4aa392a95218cbbc51816f74de559d59"));
    verify(deviceProfileService)
        .findDeviceProfileByProvisionDeviceKey(eq("64ce14fc143a2fb2edbeee035a7ee6fa4aa392a95218cbbc51816f74de559d59"));
  }

  /**
   * Test
   * {@link DefaultTransportApiService#validateOrCreateDeviceX509Certificate(String)}.
   * <ul>
   *   <li>Then calls {@link DeviceCredentials#getCredentialsType()}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link DefaultTransportApiService#validateOrCreateDeviceX509Certificate(String)}
   */
  @Test
  @DisplayName("Test validateOrCreateDeviceX509Certificate(String); then calls getCredentialsType()")
  void testValidateOrCreateDeviceX509Certificate_thenCallsGetCredentialsType() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    DeviceCredentials deviceCredentials = mock(DeviceCredentials.class);
    when(deviceCredentials.getCredentialsType()).thenThrow(new ProvisionFailedException("An error occurred"));
    DeviceCredentialsService deviceCredentialsService = mock(DeviceCredentialsService.class);
    when(deviceCredentialsService.findDeviceCredentialsByCredentialsId(Mockito.<String>any()))
        .thenReturn(deviceCredentials);

    // Act and Assert
    assertThrows(ProvisionFailedException.class,
        () -> (new DefaultTransportApiService(mock(TbDeviceProfileCache.class), mock(TbTenantProfileCache.class),
            mock(TbApiUsageStateService.class), mock(DeviceService.class), mock(DeviceProfileService.class),
            mock(RelationService.class), deviceCredentialsService, mock(TbClusterService.class),
            mock(DeviceProvisionService.class), mock(ResourceService.class), mock(OtaPackageService.class),
            mock(OtaPackageDataCache.class), mock(QueueService.class)))
            .validateOrCreateDeviceX509Certificate("-----BEGIN CERTIFICATE----- UU -----END CERTIFICATE-----"));
    verify(deviceCredentials).getCredentialsType();
    verify(deviceCredentialsService)
        .findDeviceCredentialsByCredentialsId(eq("64ce14fc143a2fb2edbeee035a7ee6fa4aa392a95218cbbc51816f74de559d59"));
  }

  /**
   * Test
   * {@link DefaultTransportApiService#validateOrCreateDeviceX509Certificate(String)}.
   * <ul>
   *   <li>Then throw {@link EntitiesLimitException}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link DefaultTransportApiService#validateOrCreateDeviceX509Certificate(String)}
   */
  @Test
  @DisplayName("Test validateOrCreateDeviceX509Certificate(String); then throw EntitiesLimitException")
  void testValidateOrCreateDeviceX509Certificate_thenThrowEntitiesLimitException() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    DeviceProfile deviceProfile = mock(DeviceProfile.class);
    when(deviceProfile.getProvisionType())
        .thenThrow(new EntitiesLimitException(new TenantId(UUID.randomUUID()), EntityType.TENANT));
    DeviceProfileService deviceProfileService = mock(DeviceProfileService.class);
    when(deviceProfileService.findDeviceProfileByProvisionDeviceKey(Mockito.<String>any())).thenReturn(deviceProfile);
    DeviceCredentialsService deviceCredentialsService = mock(DeviceCredentialsService.class);
    when(deviceCredentialsService.findDeviceCredentialsByCredentialsId(Mockito.<String>any()))
        .thenReturn(new DeviceCredentials());

    // Act and Assert
    assertThrows(EntitiesLimitException.class,
        () -> (new DefaultTransportApiService(mock(TbDeviceProfileCache.class), mock(TbTenantProfileCache.class),
            mock(TbApiUsageStateService.class), mock(DeviceService.class), deviceProfileService,
            mock(RelationService.class), deviceCredentialsService, mock(TbClusterService.class),
            mock(DeviceProvisionService.class), mock(ResourceService.class), mock(OtaPackageService.class),
            mock(OtaPackageDataCache.class), mock(QueueService.class)))
            .validateOrCreateDeviceX509Certificate("-----BEGIN CERTIFICATE----- UU -----END CERTIFICATE-----"));
    verify(deviceProfile).getProvisionType();
    verify(deviceCredentialsService)
        .findDeviceCredentialsByCredentialsId(eq("64ce14fc143a2fb2edbeee035a7ee6fa4aa392a95218cbbc51816f74de559d59"));
    verify(deviceProfileService)
        .findDeviceProfileByProvisionDeviceKey(eq("64ce14fc143a2fb2edbeee035a7ee6fa4aa392a95218cbbc51816f74de559d59"));
  }

  /**
   * Test
   * {@link DefaultTransportApiService#validateOrCreateDeviceX509Certificate(String)}.
   * <ul>
   *   <li>When a string.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link DefaultTransportApiService#validateOrCreateDeviceX509Certificate(String)}
   */
  @Test
  @DisplayName("Test validateOrCreateDeviceX509Certificate(String); when a string")
  void testValidateOrCreateDeviceX509Certificate_whenAString() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    DeviceCredentials deviceCredentials = mock(DeviceCredentials.class);
    when(deviceCredentials.getCredentialsType()).thenThrow(new ProvisionFailedException("An error occurred"));
    DeviceCredentialsService deviceCredentialsService = mock(DeviceCredentialsService.class);
    when(deviceCredentialsService.findDeviceCredentialsByCredentialsId(Mockito.<String>any()))
        .thenReturn(deviceCredentials);

    // Act and Assert
    assertThrows(ProvisionFailedException.class,
        () -> (new DefaultTransportApiService(mock(TbDeviceProfileCache.class), mock(TbTenantProfileCache.class),
            mock(TbApiUsageStateService.class), mock(DeviceService.class), mock(DeviceProfileService.class),
            mock(RelationService.class), deviceCredentialsService, mock(TbClusterService.class),
            mock(DeviceProvisionService.class), mock(ResourceService.class), mock(OtaPackageService.class),
            mock(OtaPackageDataCache.class), mock(QueueService.class))).validateOrCreateDeviceX509Certificate(
                "-----BEGIN CERTIFICATE----- UU -----END CERTIFICATE----------BEGIN CERTIFICATE----- UU -----END"
                    + " CERTIFICATE-----"));
    verify(deviceCredentials).getCredentialsType();
    verify(deviceCredentialsService)
        .findDeviceCredentialsByCredentialsId(eq("64ce14fc143a2fb2edbeee035a7ee6fa4aa392a95218cbbc51816f74de559d59"));
  }

  /**
   * Test
   * {@link DefaultTransportApiService#validateOrCreateDeviceX509Certificate(String)}.
   * <ul>
   *   <li>When {@code Certificate Chain}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link DefaultTransportApiService#validateOrCreateDeviceX509Certificate(String)}
   */
  @Test
  @DisplayName("Test validateOrCreateDeviceX509Certificate(String); when 'Certificate Chain'")
  void testValidateOrCreateDeviceX509Certificate_whenCertificateChain() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange and Act
    TransportProtos.TransportApiResponseMsg actualValidateOrCreateDeviceX509CertificateResult = (new DefaultTransportApiService(
        mock(TbDeviceProfileCache.class), mock(TbTenantProfileCache.class), mock(TbApiUsageStateService.class),
        mock(DeviceService.class), mock(DeviceProfileService.class), mock(RelationService.class),
        mock(DeviceCredentialsService.class), mock(TbClusterService.class), mock(DeviceProvisionService.class),
        mock(ResourceService.class), mock(OtaPackageService.class), mock(OtaPackageDataCache.class),
        mock(QueueService.class))).validateOrCreateDeviceX509Certificate("Certificate Chain");

    // Assert
    Descriptors.Descriptor descriptorForType = actualValidateOrCreateDeviceX509CertificateResult.getDescriptorForType();
    List<Descriptors.FieldDescriptor> fields = descriptorForType.getFields();
    assertEquals(11, fields.size());
    Descriptors.FileDescriptor file = descriptorForType.getFile();
    DescriptorProtos.FileDescriptorProto toProtoResult = file.toProto();
    List<Integer> expectedWeakDependencyList = toProtoResult.getPublicDependencyList();
    assertSame(expectedWeakDependencyList, toProtoResult.getWeakDependencyList());
    TransportProtos.GetDeviceCredentialsResponseMsg deviceCredentialsResponseMsg = actualValidateOrCreateDeviceX509CertificateResult
        .getDeviceCredentialsResponseMsg();
    Descriptors.Descriptor descriptorForType2 = deviceCredentialsResponseMsg.getDescriptorForType();
    assertSame(file, descriptorForType2.getFile());
    TransportProtos.GetDeviceResponseMsg deviceResponseMsg = actualValidateOrCreateDeviceX509CertificateResult
        .getDeviceResponseMsg();
    assertSame(file, deviceResponseMsg.getDescriptorForType().getFile());
    TransportProtos.GetEntityProfileResponseMsg entityProfileResponseMsg = actualValidateOrCreateDeviceX509CertificateResult
        .getEntityProfileResponseMsg();
    assertSame(file, entityProfileResponseMsg.getDescriptorForType().getFile());
    TransportProtos.GetOrCreateDeviceFromGatewayResponseMsg getOrCreateDeviceResponseMsg = actualValidateOrCreateDeviceX509CertificateResult
        .getGetOrCreateDeviceResponseMsg();
    Descriptors.Descriptor descriptorForType3 = getOrCreateDeviceResponseMsg.getDescriptorForType();
    assertSame(file, descriptorForType3.getFile());
    TransportProtos.LwM2MResponseMsg lwM2MResponseMsg = actualValidateOrCreateDeviceX509CertificateResult
        .getLwM2MResponseMsg();
    assertSame(file, lwM2MResponseMsg.getDescriptorForType().getFile());
    TransportProtos.GetOtaPackageResponseMsg otaPackageResponseMsg = actualValidateOrCreateDeviceX509CertificateResult
        .getOtaPackageResponseMsg();
    assertSame(file, otaPackageResponseMsg.getDescriptorForType().getFile());
    TransportProtos.ProvisionDeviceResponseMsg provisionDeviceResponseMsg = actualValidateOrCreateDeviceX509CertificateResult
        .getProvisionDeviceResponseMsg();
    assertSame(file, provisionDeviceResponseMsg.getDescriptorForType().getFile());
    TransportProtos.GetResourceResponseMsg resourceResponseMsg = actualValidateOrCreateDeviceX509CertificateResult
        .getResourceResponseMsg();
    assertSame(file, resourceResponseMsg.getDescriptorForType().getFile());
    TransportProtos.GetSnmpDevicesResponseMsg snmpDevicesResponseMsg = actualValidateOrCreateDeviceX509CertificateResult
        .getSnmpDevicesResponseMsg();
    assertSame(file, snmpDevicesResponseMsg.getDescriptorForType().getFile());
    TransportProtos.ValidateDeviceCredentialsResponseMsg validateCredResponseMsg = actualValidateOrCreateDeviceX509CertificateResult
        .getValidateCredResponseMsg();
    Descriptors.Descriptor descriptorForType4 = validateCredResponseMsg.getDescriptorForType();
    assertSame(file, descriptorForType4.getFile());
    Descriptors.FieldDescriptor getResult = fields.get(0);
    assertSame(file, getResult.getFile());
    Descriptors.FieldDescriptor getResult2 = fields.get(1);
    assertSame(file, getResult2.getFile());
    Descriptors.FieldDescriptor getResult3 = fields.get(10);
    assertSame(file, getResult3.getFile());
    Descriptors.FieldDescriptor getResult4 = fields.get(9);
    assertSame(file, getResult4.getFile());
    DescriptorProtos.MessageOptions options = descriptorForType.getOptions();
    assertSame(options, options.getDefaultInstanceForType());
    DescriptorProtos.FileOptions options2 = file.getOptions();
    assertSame(options2, toProtoResult.getOptions());
    assertSame(options2, toProtoResult.getOptionsOrBuilder());
    assertSame(descriptorForType2, getResult4.getMessageType());
    assertSame(descriptorForType3, getResult2.getMessageType());
    assertSame(descriptorForType4, getResult.getMessageType());
    assertSame(descriptorForType, getResult.getContainingType());
    assertSame(descriptorForType, getResult2.getContainingType());
    assertSame(descriptorForType, getResult3.getContainingType());
    assertSame(descriptorForType, getResult4.getContainingType());
    TransportProtos.TransportApiResponseMsg defaultInstanceForType = actualValidateOrCreateDeviceX509CertificateResult
        .getDefaultInstanceForType();
    assertSame(descriptorForType, defaultInstanceForType.getDescriptorForType());
    UnknownFieldSet unknownFields = actualValidateOrCreateDeviceX509CertificateResult.getUnknownFields();
    assertSame(unknownFields, options.getUnknownFields());
    DescriptorProtos.DescriptorProto toProtoResult2 = descriptorForType.toProto();
    assertSame(unknownFields, toProtoResult2.getUnknownFields());
    assertSame(unknownFields, options2.getUnknownFields());
    assertSame(unknownFields, toProtoResult.getUnknownFields());
    TransportProtos.DeviceCredentialsProto deviceCredentialsData = deviceCredentialsResponseMsg
        .getDeviceCredentialsData();
    assertSame(unknownFields, deviceCredentialsData.getUnknownFields());
    TransportProtos.ApiUsageStateProto apiState = entityProfileResponseMsg.getApiState();
    assertSame(unknownFields, apiState.getUnknownFields());
    TransportProtos.DeviceProfileProto deviceProfile = entityProfileResponseMsg.getDeviceProfile();
    assertSame(unknownFields, deviceProfile.getUnknownFields());
    TransportProtos.TenantProfileProto tenantProfile = entityProfileResponseMsg.getTenantProfile();
    assertSame(unknownFields, tenantProfile.getUnknownFields());
    TransportProtos.DeviceInfoProto deviceInfo = getOrCreateDeviceResponseMsg.getDeviceInfo();
    assertSame(unknownFields, deviceInfo.getUnknownFields());
    TransportProtos.TbResourceProto resource = resourceResponseMsg.getResource();
    assertSame(unknownFields, resource.getUnknownFields());
    TransportProtos.LwM2MRegistrationResponseMsg registrationMsg = lwM2MResponseMsg.getRegistrationMsg();
    assertSame(unknownFields, registrationMsg.getUnknownFields());
    assertSame(unknownFields, defaultInstanceForType.getUnknownFields());
    assertSame(unknownFields, deviceCredentialsResponseMsg.getUnknownFields());
    assertSame(unknownFields, deviceResponseMsg.getUnknownFields());
    assertSame(unknownFields, entityProfileResponseMsg.getUnknownFields());
    assertSame(unknownFields, getOrCreateDeviceResponseMsg.getUnknownFields());
    assertSame(unknownFields, lwM2MResponseMsg.getUnknownFields());
    assertSame(unknownFields, otaPackageResponseMsg.getUnknownFields());
    assertSame(unknownFields, provisionDeviceResponseMsg.getUnknownFields());
    assertSame(unknownFields, resourceResponseMsg.getUnknownFields());
    assertSame(unknownFields, snmpDevicesResponseMsg.getUnknownFields());
    assertSame(unknownFields, validateCredResponseMsg.getUnknownFields());
    assertSame(unknownFields, unknownFields.getDefaultInstanceForType());
    assertSame(deviceCredentialsData, deviceCredentialsData.getDefaultInstanceForType());
    assertSame(deviceCredentialsData, deviceCredentialsResponseMsg.getDeviceCredentialsDataOrBuilder());
    assertSame(apiState, apiState.getDefaultInstanceForType());
    assertSame(apiState, entityProfileResponseMsg.getApiStateOrBuilder());
    assertSame(deviceProfile, deviceProfile.getDefaultInstanceForType());
    assertSame(deviceProfile, entityProfileResponseMsg.getDeviceProfileOrBuilder());
    assertSame(deviceProfile, getOrCreateDeviceResponseMsg.getDeviceProfile());
    assertSame(deviceProfile, getOrCreateDeviceResponseMsg.getDeviceProfileOrBuilder());
    assertSame(deviceProfile, validateCredResponseMsg.getDeviceProfile());
    assertSame(deviceProfile, validateCredResponseMsg.getDeviceProfileOrBuilder());
    assertSame(tenantProfile, entityProfileResponseMsg.getTenantProfileOrBuilder());
    assertSame(tenantProfile, tenantProfile.getDefaultInstanceForType());
    assertSame(deviceInfo, deviceInfo.getDefaultInstanceForType());
    assertSame(deviceInfo, getOrCreateDeviceResponseMsg.getDeviceInfoOrBuilder());
    assertSame(deviceInfo, registrationMsg.getDeviceInfo());
    assertSame(deviceInfo, registrationMsg.getDeviceInfoOrBuilder());
    assertSame(deviceInfo, validateCredResponseMsg.getDeviceInfo());
    assertSame(deviceInfo, validateCredResponseMsg.getDeviceInfoOrBuilder());
    assertSame(resource, resourceResponseMsg.getResourceOrBuilder());
    assertSame(resource, resource.getDefaultInstanceForType());
    ProtocolStringList idsList = snmpDevicesResponseMsg.getIdsList();
    assertSame(idsList, toProtoResult2.getReservedNameList());
    assertSame(idsList, toProtoResult.getDependencyList());
    assertSame(registrationMsg, registrationMsg.getDefaultInstanceForType());
    assertSame(registrationMsg, lwM2MResponseMsg.getRegistrationMsgOrBuilder());
    assertSame(defaultInstanceForType.getDefaultInstanceForType(), defaultInstanceForType.getDefaultInstanceForType());
    assertSame(deviceCredentialsResponseMsg, deviceCredentialsResponseMsg.getDefaultInstanceForType());
    assertSame(deviceCredentialsResponseMsg, defaultInstanceForType.getDeviceCredentialsResponseMsg());
    assertSame(deviceCredentialsResponseMsg, defaultInstanceForType.getDeviceCredentialsResponseMsgOrBuilder());
    assertSame(deviceCredentialsResponseMsg,
        actualValidateOrCreateDeviceX509CertificateResult.getDeviceCredentialsResponseMsgOrBuilder());
    assertSame(deviceResponseMsg, deviceResponseMsg.getDefaultInstanceForType());
    assertSame(deviceResponseMsg, defaultInstanceForType.getDeviceResponseMsg());
    assertSame(deviceResponseMsg, defaultInstanceForType.getDeviceResponseMsgOrBuilder());
    assertSame(deviceResponseMsg, actualValidateOrCreateDeviceX509CertificateResult.getDeviceResponseMsgOrBuilder());
    assertSame(entityProfileResponseMsg, entityProfileResponseMsg.getDefaultInstanceForType());
    assertSame(entityProfileResponseMsg, defaultInstanceForType.getEntityProfileResponseMsg());
    assertSame(entityProfileResponseMsg, defaultInstanceForType.getEntityProfileResponseMsgOrBuilder());
    assertSame(entityProfileResponseMsg,
        actualValidateOrCreateDeviceX509CertificateResult.getEntityProfileResponseMsgOrBuilder());
    assertSame(getOrCreateDeviceResponseMsg, getOrCreateDeviceResponseMsg.getDefaultInstanceForType());
    assertSame(getOrCreateDeviceResponseMsg, defaultInstanceForType.getGetOrCreateDeviceResponseMsg());
    assertSame(getOrCreateDeviceResponseMsg, defaultInstanceForType.getGetOrCreateDeviceResponseMsgOrBuilder());
    assertSame(getOrCreateDeviceResponseMsg,
        actualValidateOrCreateDeviceX509CertificateResult.getGetOrCreateDeviceResponseMsgOrBuilder());
    assertSame(lwM2MResponseMsg, lwM2MResponseMsg.getDefaultInstanceForType());
    assertSame(lwM2MResponseMsg, defaultInstanceForType.getLwM2MResponseMsg());
    assertSame(lwM2MResponseMsg, defaultInstanceForType.getLwM2MResponseMsgOrBuilder());
    assertSame(lwM2MResponseMsg, actualValidateOrCreateDeviceX509CertificateResult.getLwM2MResponseMsgOrBuilder());
    assertSame(otaPackageResponseMsg, otaPackageResponseMsg.getDefaultInstanceForType());
    assertSame(otaPackageResponseMsg, defaultInstanceForType.getOtaPackageResponseMsg());
    assertSame(otaPackageResponseMsg, defaultInstanceForType.getOtaPackageResponseMsgOrBuilder());
    assertSame(otaPackageResponseMsg,
        actualValidateOrCreateDeviceX509CertificateResult.getOtaPackageResponseMsgOrBuilder());
    assertSame(provisionDeviceResponseMsg, provisionDeviceResponseMsg.getDefaultInstanceForType());
    assertSame(provisionDeviceResponseMsg, defaultInstanceForType.getProvisionDeviceResponseMsg());
    assertSame(provisionDeviceResponseMsg, defaultInstanceForType.getProvisionDeviceResponseMsgOrBuilder());
    assertSame(provisionDeviceResponseMsg,
        actualValidateOrCreateDeviceX509CertificateResult.getProvisionDeviceResponseMsgOrBuilder());
    assertSame(resourceResponseMsg, resourceResponseMsg.getDefaultInstanceForType());
    assertSame(resourceResponseMsg, defaultInstanceForType.getResourceResponseMsg());
    assertSame(resourceResponseMsg, defaultInstanceForType.getResourceResponseMsgOrBuilder());
    assertSame(resourceResponseMsg,
        actualValidateOrCreateDeviceX509CertificateResult.getResourceResponseMsgOrBuilder());
    assertSame(snmpDevicesResponseMsg, snmpDevicesResponseMsg.getDefaultInstanceForType());
    assertSame(snmpDevicesResponseMsg, defaultInstanceForType.getSnmpDevicesResponseMsg());
    assertSame(snmpDevicesResponseMsg, defaultInstanceForType.getSnmpDevicesResponseMsgOrBuilder());
    assertSame(snmpDevicesResponseMsg,
        actualValidateOrCreateDeviceX509CertificateResult.getSnmpDevicesResponseMsgOrBuilder());
    assertSame(validateCredResponseMsg, defaultInstanceForType.getValidateCredResponseMsg());
    assertSame(validateCredResponseMsg, defaultInstanceForType.getValidateCredResponseMsgOrBuilder());
    assertSame(validateCredResponseMsg,
        actualValidateOrCreateDeviceX509CertificateResult.getValidateCredResponseMsgOrBuilder());
    assertSame(validateCredResponseMsg, validateCredResponseMsg.getDefaultInstanceForType());
  }
}
