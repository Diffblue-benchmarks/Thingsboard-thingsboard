package org.thingsboard.server.service.edge.rpc.constructor.user;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.fasterxml.jackson.databind.node.MissingNode;
import com.google.protobuf.ByteString;
import com.google.protobuf.DescriptorProtos;
import com.google.protobuf.Descriptors;
import java.util.List;
import java.util.UUID;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.thingsboard.server.common.data.User;
import org.thingsboard.server.common.data.id.CustomerId;
import org.thingsboard.server.common.data.id.UserId;
import org.thingsboard.server.common.data.security.Authority;
import org.thingsboard.server.gen.edge.v1.UpdateMsgType;
import org.thingsboard.server.gen.edge.v1.UserUpdateMsg;

class UserMsgConstructorV1DiffblueTest {
  /**
   * Test
   * {@link UserMsgConstructorV1#constructUserUpdatedMsg(UpdateMsgType, User)}.
   * <p>
   * Method under test:
   * {@link UserMsgConstructorV1#constructUserUpdatedMsg(UpdateMsgType, User)}
   */
  @Test
  @DisplayName("Test constructUserUpdatedMsg(UpdateMsgType, User)")
  void testConstructUserUpdatedMsg() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    UserMsgConstructorV1 userMsgConstructorV1 = new UserMsgConstructorV1();
    User user = mock(User.class);
    when(user.getAdditionalInfo()).thenReturn(null);
    when(user.getFirstName()).thenReturn("Jane");
    when(user.getLastName()).thenReturn("Doe");
    when(user.getCustomerId()).thenReturn(new CustomerId(UUID.randomUUID()));
    when(user.getAuthority()).thenReturn(Authority.SYS_ADMIN);
    when(user.getEmail()).thenReturn("jane.doe@example.org");
    when(user.getId()).thenReturn(new UserId(UUID.randomUUID()));

    // Act
    UserUpdateMsg actualConstructUserUpdatedMsgResult = userMsgConstructorV1
        .constructUserUpdatedMsg(UpdateMsgType.ENTITY_CREATED_RPC_MESSAGE, user);

    // Assert
    verify(user).getAdditionalInfo();
    verify(user).getAuthority();
    verify(user, atLeast(1)).getCustomerId();
    verify(user).getEmail();
    verify(user, atLeast(1)).getFirstName();
    verify(user, atLeast(1)).getId();
    verify(user, atLeast(1)).getLastName();
    ByteString additionalInfoBytes = actualConstructUserUpdatedMsgResult.getAdditionalInfoBytes();
    assertEquals("", additionalInfoBytes.toStringUtf8());
    assertEquals("", actualConstructUserUpdatedMsgResult.getAdditionalInfo());
    Descriptors.Descriptor descriptorForType = actualConstructUserUpdatedMsgResult.getDescriptorForType();
    List<Descriptors.FieldDescriptor> fields = descriptorForType.getFields();
    assertEquals(11, fields.size());
    assertFalse(additionalInfoBytes.iterator().hasNext());
    assertFalse(actualConstructUserUpdatedMsgResult.hasAdditionalInfo());
    assertTrue(additionalInfoBytes.isEmpty());
    assertEquals(additionalInfoBytes, descriptorForType.toProto().getDefaultInstanceForType().getNameBytes());
    DescriptorProtos.FieldDescriptorProto toProtoResult = fields.get(0).toProto();
    assertEquals(additionalInfoBytes, toProtoResult.getDefaultValueBytes());
    DescriptorProtos.FieldDescriptorProto toProtoResult2 = fields.get(1).toProto();
    assertEquals(additionalInfoBytes, toProtoResult2.getDefaultValueBytes());
    DescriptorProtos.FieldDescriptorProto toProtoResult3 = fields.get(10).toProto();
    assertEquals(additionalInfoBytes, toProtoResult3.getDefaultValueBytes());
    DescriptorProtos.FieldDescriptorProto toProtoResult4 = fields.get(9).toProto();
    assertEquals(additionalInfoBytes, toProtoResult4.getDefaultValueBytes());
    assertEquals(additionalInfoBytes, toProtoResult.getExtendeeBytes());
    assertEquals(additionalInfoBytes, toProtoResult2.getExtendeeBytes());
    assertEquals(additionalInfoBytes, toProtoResult3.getExtendeeBytes());
    assertEquals(additionalInfoBytes, toProtoResult4.getExtendeeBytes());
    assertEquals(additionalInfoBytes, toProtoResult.getJsonNameBytes());
    assertEquals(additionalInfoBytes, toProtoResult2.getJsonNameBytes());
    assertEquals(additionalInfoBytes, toProtoResult3.getJsonNameBytes());
    assertEquals(additionalInfoBytes, toProtoResult4.getJsonNameBytes());
    assertEquals(additionalInfoBytes, toProtoResult2.getTypeNameBytes());
    assertEquals(additionalInfoBytes, toProtoResult3.getTypeNameBytes());
    assertEquals(additionalInfoBytes, toProtoResult4.getTypeNameBytes());
    DescriptorProtos.FileOptions options = descriptorForType.getFile().getOptions();
    DescriptorProtos.FileOptions defaultInstanceForType = options.getDefaultInstanceForType();
    assertEquals(additionalInfoBytes, defaultInstanceForType.getCsharpNamespaceBytes());
    assertEquals(additionalInfoBytes, options.getCsharpNamespaceBytes());
    assertEquals(additionalInfoBytes, defaultInstanceForType.getGoPackageBytes());
    assertEquals(additionalInfoBytes, options.getGoPackageBytes());
    assertEquals(additionalInfoBytes, defaultInstanceForType.getJavaOuterClassnameBytes());
    assertEquals(additionalInfoBytes, defaultInstanceForType.getJavaPackageBytes());
    assertEquals(additionalInfoBytes, defaultInstanceForType.getObjcClassPrefixBytes());
    assertEquals(additionalInfoBytes, options.getObjcClassPrefixBytes());
    assertEquals(additionalInfoBytes, defaultInstanceForType.getPhpClassPrefixBytes());
    assertEquals(additionalInfoBytes, options.getPhpClassPrefixBytes());
    assertEquals(additionalInfoBytes, defaultInstanceForType.getPhpMetadataNamespaceBytes());
    assertEquals(additionalInfoBytes, options.getPhpMetadataNamespaceBytes());
    assertEquals(additionalInfoBytes, defaultInstanceForType.getPhpNamespaceBytes());
    assertEquals(additionalInfoBytes, options.getPhpNamespaceBytes());
    assertEquals(additionalInfoBytes, defaultInstanceForType.getRubyPackageBytes());
    assertEquals(additionalInfoBytes, options.getRubyPackageBytes());
    assertEquals(additionalInfoBytes, defaultInstanceForType.getSwiftPrefixBytes());
    assertEquals(additionalInfoBytes, options.getSwiftPrefixBytes());
    UserUpdateMsg defaultInstanceForType2 = actualConstructUserUpdatedMsgResult.getDefaultInstanceForType();
    assertEquals(additionalInfoBytes, defaultInstanceForType2.getAdditionalInfoBytes());
    assertEquals(additionalInfoBytes, defaultInstanceForType2.getAuthorityBytes());
    assertEquals(additionalInfoBytes, defaultInstanceForType2.getEmailBytes());
    assertEquals(additionalInfoBytes, defaultInstanceForType2.getEntityBytes());
    assertEquals(additionalInfoBytes, actualConstructUserUpdatedMsgResult.getEntityBytes());
    assertEquals(additionalInfoBytes, defaultInstanceForType2.getFirstNameBytes());
    assertEquals(additionalInfoBytes, defaultInstanceForType2.getLastNameBytes());
  }

  /**
   * Test
   * {@link UserMsgConstructorV1#constructUserUpdatedMsg(UpdateMsgType, User)}.
   * <ul>
   *   <li>Given Instance.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link UserMsgConstructorV1#constructUserUpdatedMsg(UpdateMsgType, User)}
   */
  @Test
  @DisplayName("Test constructUserUpdatedMsg(UpdateMsgType, User); given Instance")
  void testConstructUserUpdatedMsg_givenInstance() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    UserMsgConstructorV1 userMsgConstructorV1 = new UserMsgConstructorV1();
    User user = mock(User.class);
    when(user.getAdditionalInfo()).thenReturn(MissingNode.getInstance());
    when(user.getFirstName()).thenReturn("Jane");
    when(user.getLastName()).thenReturn("Doe");
    when(user.getCustomerId()).thenReturn(new CustomerId(UUID.randomUUID()));
    when(user.getAuthority()).thenReturn(Authority.SYS_ADMIN);
    when(user.getEmail()).thenReturn("jane.doe@example.org");
    when(user.getId()).thenReturn(new UserId(UUID.randomUUID()));

    // Act
    userMsgConstructorV1.constructUserUpdatedMsg(UpdateMsgType.ENTITY_CREATED_RPC_MESSAGE, user);

    // Assert
    verify(user, atLeast(1)).getAdditionalInfo();
    verify(user).getAuthority();
    verify(user, atLeast(1)).getCustomerId();
    verify(user).getEmail();
    verify(user, atLeast(1)).getFirstName();
    verify(user, atLeast(1)).getId();
    verify(user, atLeast(1)).getLastName();
  }

  /**
   * Test
   * {@link UserMsgConstructorV1#constructUserUpdatedMsg(UpdateMsgType, User)}.
   * <ul>
   *   <li>Then return CustomerIdLSB is zero.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link UserMsgConstructorV1#constructUserUpdatedMsg(UpdateMsgType, User)}
   */
  @Test
  @DisplayName("Test constructUserUpdatedMsg(UpdateMsgType, User); then return CustomerIdLSB is zero")
  void testConstructUserUpdatedMsg_thenReturnCustomerIdLSBIsZero() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    UserMsgConstructorV1 userMsgConstructorV1 = new UserMsgConstructorV1();
    User user = mock(User.class);
    when(user.getAdditionalInfo()).thenReturn(MissingNode.getInstance());
    when(user.getFirstName()).thenReturn("Jane");
    when(user.getLastName()).thenReturn("Doe");
    when(user.getCustomerId()).thenReturn(null);
    when(user.getAuthority()).thenReturn(Authority.SYS_ADMIN);
    when(user.getEmail()).thenReturn("jane.doe@example.org");
    when(user.getId()).thenReturn(new UserId(UUID.randomUUID()));

    // Act
    UserUpdateMsg actualConstructUserUpdatedMsgResult = userMsgConstructorV1
        .constructUserUpdatedMsg(UpdateMsgType.ENTITY_CREATED_RPC_MESSAGE, user);

    // Assert
    verify(user, atLeast(1)).getAdditionalInfo();
    verify(user).getAuthority();
    verify(user).getCustomerId();
    verify(user).getEmail();
    verify(user, atLeast(1)).getFirstName();
    verify(user, atLeast(1)).getId();
    verify(user, atLeast(1)).getLastName();
    assertEquals(0L, actualConstructUserUpdatedMsgResult.getCustomerIdLSB());
    assertEquals(0L, actualConstructUserUpdatedMsgResult.getCustomerIdMSB());
    assertEquals(7, actualConstructUserUpdatedMsgResult.getAllFields().size());
    assertFalse(actualConstructUserUpdatedMsgResult.hasCustomerIdLSB());
    assertFalse(actualConstructUserUpdatedMsgResult.hasCustomerIdMSB());
  }

  /**
   * Test
   * {@link UserMsgConstructorV1#constructUserUpdatedMsg(UpdateMsgType, User)}.
   * <ul>
   *   <li>Then return FirstName is empty string.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link UserMsgConstructorV1#constructUserUpdatedMsg(UpdateMsgType, User)}
   */
  @Test
  @DisplayName("Test constructUserUpdatedMsg(UpdateMsgType, User); then return FirstName is empty string")
  void testConstructUserUpdatedMsg_thenReturnFirstNameIsEmptyString() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    UserMsgConstructorV1 userMsgConstructorV1 = new UserMsgConstructorV1();
    User user = mock(User.class);
    when(user.getAdditionalInfo()).thenReturn(MissingNode.getInstance());
    when(user.getFirstName()).thenReturn(null);
    when(user.getLastName()).thenReturn("Doe");
    when(user.getCustomerId()).thenReturn(new CustomerId(UUID.randomUUID()));
    when(user.getAuthority()).thenReturn(Authority.SYS_ADMIN);
    when(user.getEmail()).thenReturn("jane.doe@example.org");
    when(user.getId()).thenReturn(new UserId(UUID.randomUUID()));

    // Act
    UserUpdateMsg actualConstructUserUpdatedMsgResult = userMsgConstructorV1
        .constructUserUpdatedMsg(UpdateMsgType.ENTITY_CREATED_RPC_MESSAGE, user);

    // Assert
    verify(user, atLeast(1)).getAdditionalInfo();
    verify(user).getAuthority();
    verify(user, atLeast(1)).getCustomerId();
    verify(user).getEmail();
    verify(user).getFirstName();
    verify(user, atLeast(1)).getId();
    verify(user, atLeast(1)).getLastName();
    assertEquals("", actualConstructUserUpdatedMsgResult.getFirstName());
    assertFalse(actualConstructUserUpdatedMsgResult.hasFirstName());
  }

  /**
   * Test
   * {@link UserMsgConstructorV1#constructUserUpdatedMsg(UpdateMsgType, User)}.
   * <ul>
   *   <li>Then return LastName is empty string.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link UserMsgConstructorV1#constructUserUpdatedMsg(UpdateMsgType, User)}
   */
  @Test
  @DisplayName("Test constructUserUpdatedMsg(UpdateMsgType, User); then return LastName is empty string")
  void testConstructUserUpdatedMsg_thenReturnLastNameIsEmptyString() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    UserMsgConstructorV1 userMsgConstructorV1 = new UserMsgConstructorV1();
    User user = mock(User.class);
    when(user.getAdditionalInfo()).thenReturn(MissingNode.getInstance());
    when(user.getFirstName()).thenReturn("Jane");
    when(user.getLastName()).thenReturn(null);
    when(user.getCustomerId()).thenReturn(new CustomerId(UUID.randomUUID()));
    when(user.getAuthority()).thenReturn(Authority.SYS_ADMIN);
    when(user.getEmail()).thenReturn("jane.doe@example.org");
    when(user.getId()).thenReturn(new UserId(UUID.randomUUID()));

    // Act
    UserUpdateMsg actualConstructUserUpdatedMsgResult = userMsgConstructorV1
        .constructUserUpdatedMsg(UpdateMsgType.ENTITY_CREATED_RPC_MESSAGE, user);

    // Assert
    verify(user, atLeast(1)).getAdditionalInfo();
    verify(user).getAuthority();
    verify(user, atLeast(1)).getCustomerId();
    verify(user).getEmail();
    verify(user, atLeast(1)).getFirstName();
    verify(user, atLeast(1)).getId();
    verify(user).getLastName();
    assertEquals("", actualConstructUserUpdatedMsgResult.getLastName());
    assertFalse(actualConstructUserUpdatedMsgResult.hasLastName());
  }
}
