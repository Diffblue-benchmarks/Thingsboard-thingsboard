package org.thingsboard.server.config;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.anyBoolean;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.node.JsonNodeType;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.fasterxml.jackson.databind.node.TreeTraversingParser;
import com.fasterxml.jackson.databind.type.PlaceholderForType;
import io.swagger.v3.core.converter.AnnotatedType;
import io.swagger.v3.core.converter.ModelConverter;
import io.swagger.v3.core.converter.ModelConverterContext;
import io.swagger.v3.core.converter.ModelConverterContextImpl;
import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.Operation;
import io.swagger.v3.oas.models.PathItem;
import io.swagger.v3.oas.models.Paths;
import io.swagger.v3.oas.models.SpecVersion;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import io.swagger.v3.oas.models.media.Content;
import io.swagger.v3.oas.models.media.IntegerSchema;
import io.swagger.v3.oas.models.media.MediaType;
import io.swagger.v3.oas.models.media.Schema;
import io.swagger.v3.oas.models.media.StringSchema;
import io.swagger.v3.oas.models.parameters.RequestBody;
import io.swagger.v3.oas.models.responses.ApiResponse;
import io.swagger.v3.oas.models.responses.ApiResponses;
import io.swagger.v3.oas.models.security.SecurityScheme;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springdoc.core.properties.SpringDocConfigProperties;
import org.springdoc.core.properties.SpringDocConfigProperties.GroupConfig;
import org.springdoc.core.properties.SwaggerUiConfigProperties;

class SwaggerConfigurationDiffblueTest {
  /**
   * Test {@link SwaggerConfiguration#thingsboardApi()}.
   * <p>
   * Method under test: {@link SwaggerConfiguration#thingsboardApi()}
   */
  @Test
  @DisplayName("Test thingsboardApi()")
  void testThingsboardApi() throws IOException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange and Act
    OpenAPI actualThingsboardApiResult = (new SwaggerConfiguration()).thingsboardApi();

    // Assert
    Components components = actualThingsboardApiResult.getComponents();
    Map<String, Schema> schemas = components.getSchemas();
    assertEquals(5, schemas.size());
    Schema getResult = schemas.get("JsonNode");
    List examples = getResult.getExamples();
    assertEquals(1, examples.size());
    Object getResult2 = examples.get(0);
    JsonParser traverseResult = ((ObjectNode) getResult2).traverse();
    assertTrue(traverseResult instanceof TreeTraversingParser);
    Schema getResult3 = schemas.get("ThingsboardErrorResponse");
    Map<String, Schema> properties = getResult3.getProperties();
    assertEquals(4, properties.size());
    Schema getResult4 = properties.get("errorCode");
    assertTrue(getResult4 instanceof IntegerSchema);
    Schema getResult5 = properties.get("status");
    assertTrue(getResult5 instanceof IntegerSchema);
    Schema getResult6 = schemas.get("LoginRequest");
    Map<String, Schema> properties2 = getResult6.getProperties();
    assertEquals(2, properties2.size());
    Schema getResult7 = properties2.get("password");
    assertTrue(getResult7 instanceof StringSchema);
    Schema getResult8 = properties2.get("username");
    assertTrue(getResult8 instanceof StringSchema);
    Schema getResult9 = schemas.get("LoginResponse");
    Map<String, Schema> properties3 = getResult9.getProperties();
    assertEquals(2, properties3.size());
    Schema getResult10 = properties3.get("refreshToken");
    assertTrue(getResult10 instanceof StringSchema);
    Schema getResult11 = properties3.get(ThingsboardSecurityConfiguration.JWT_TOKEN_QUERY_PARAM);
    assertTrue(getResult11 instanceof StringSchema);
    Schema getResult12 = properties.get("message");
    assertTrue(getResult12 instanceof StringSchema);
    Paths paths = actualThingsboardApiResult.getPaths();
    assertEquals(1, paths.size());
    PathItem getResult13 = paths.get(SwaggerConfiguration.LOGIN_ENDPOINT);
    Operation post = getResult13.getPost();
    RequestBody requestBody = post.getRequestBody();
    Content content = requestBody.getContent();
    assertEquals(1, content.size());
    MediaType getResult14 = content.get("application/json");
    Schema schema = getResult14.getSchema();
    assertEquals("#/components/schemas/LoginRequest", schema.get$ref());
    Map<String, SecurityScheme> securitySchemes = components.getSecuritySchemes();
    assertEquals(1, securitySchemes.size());
    SecurityScheme getResult15 = securitySchemes.get("HTTP login form");
    assertEquals("/api/auth/login|X-Authorization", getResult15.getBearerFormat());
    assertEquals("3.0.1", actualThingsboardApiResult.getOpenapi());
    assertEquals("A value representing the any type (object or primitive)", getResult.getDescription());
    assertEquals("Authentication failed", getResult12.getExample());
    assertEquals("Enter Username / Password", getResult15.getDescription());
    assertEquals("Error message", getResult12.getDescription());
    assertEquals("HTTP Response Status Code", getResult5.getDescription());
    assertEquals("JWT token", getResult11.getDescription());
    assertEquals("JsonNode", getResult.getName());
    assertEquals("Login method to get user JWT token data", post.getSummary());
    assertEquals("Login method used to authenticate user and get JWT token data.\n" + "\n"
        + "Value of the response **token** field can be used as **X-Authorization** header value:\n" + "\n"
        + "`X-Authorization: Bearer $JWT_TOKEN_VALUE`.", post.getDescription());
    assertEquals("Login request", requestBody.getDescription());
    assertEquals("LoginRequest", getResult6.getName());
    assertEquals("LoginResponse", getResult9.getName());
    ApiResponses responses = post.getResponses();
    assertEquals(3, responses.size());
    ApiResponse getResult16 = responses.get("200");
    assertEquals("OK", getResult16.getDescription());
    assertEquals("Platform error code:\n" + "* `2` - General error (HTTP: 500 - Internal Server Error)\n" + "\n"
        + "* `10` - Authentication failed (HTTP: 401 - Unauthorized)\n" + "\n"
        + "* `11` - JWT token expired (HTTP: 401 - Unauthorized)\n" + "\n"
        + "* `15` - Credentials expired (HTTP: 401 - Unauthorized)\n" + "\n"
        + "* `20` - Permission denied (HTTP: 403 - Forbidden)\n" + "\n"
        + "* `30` - Invalid arguments (HTTP: 400 - Bad Request)\n" + "\n"
        + "* `31` - Bad request params (HTTP: 400 - Bad Request)\n" + "\n"
        + "* `32` - Item not found (HTTP: 404 - Not Found)\n" + "\n"
        + "* `33` - Too many requests (HTTP: 429 - Too Many Requests)\n" + "\n"
        + "* `34` - Too many updates (Too many updates over Websocket session)\n" + "\n"
        + "* `40` - Subscription violation (HTTP: 403 - Forbidden)", getResult4.getDescription());
    assertEquals("Refresh token", getResult10.getDescription());
    assertEquals("ThingsboardErrorResponse", getResult3.getName());
    ApiResponse getResult17 = responses.get("401 ");
    assertEquals("Unauthorized (**Expired credentials**)", getResult17.getDescription());
    ApiResponse getResult18 = responses.get("401");
    assertEquals("Unauthorized", getResult18.getDescription());
    assertEquals("User email", getResult8.getDescription());
    assertEquals("User password", getResult7.getDescription());
    assertEquals("any", getResult.getType());
    assertEquals("errorCode", getResult4.getName());
    assertEquals("eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJ0ZW5hbnRAdGhpbmdzYm9hcmQub3JnIi...", getResult10.getExample());
    assertEquals("eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJ0ZW5hbnRAdGhpbmdzYm9hcmQub3JnIi...", getResult11.getExample());
    assertEquals("int32", getResult4.getFormat());
    assertEquals("int32", getResult5.getFormat());
    assertEquals("integer", getResult4.getType());
    assertEquals("integer", getResult5.getType());
    List<String> tags = post.getTags();
    assertEquals(1, tags.size());
    assertEquals("login-endpoint", tags.get(0));
    assertEquals("loginPassword", getResult15.getScheme());
    assertEquals("message", getResult12.getName());
    assertEquals("object", getResult6.getType());
    assertEquals("object", getResult9.getType());
    assertEquals("object", getResult3.getType());
    assertEquals("password", getResult7.getName());
    List<String> required = getResult6.getRequired();
    assertEquals(2, required.size());
    assertEquals("password", required.get(0));
    assertEquals("refreshToken", getResult10.getName());
    List<String> required2 = getResult9.getRequired();
    assertEquals(2, required2.size());
    assertEquals("refreshToken", required2.get(0));
    assertEquals("status", getResult5.getName());
    assertEquals("string", getResult7.getType());
    assertEquals("string", getResult8.getType());
    assertEquals("string", getResult10.getType());
    assertEquals("string", getResult11.getType());
    assertEquals("string", getResult12.getType());
    assertEquals("tenant", getResult7.getExample());
    assertEquals("tenant@thingsboard.org", getResult8.getExample());
    assertEquals("username", getResult8.getName());
    assertEquals("username", required.get(1));
    assertEquals("{ }", ((ObjectNode) getResult2).toPrettyString());
    assertNull(traverseResult.getBinaryValue());
    assertNull(traverseResult.getSchema());
    assertNull(traverseResult.getCurrentToken());
    assertNull(traverseResult.getLastClearedToken());
    assertNull(traverseResult.getCodec());
    assertNull(traverseResult.getNonBlockingInputFeeder());
    assertNull(actualThingsboardApiResult.getExternalDocs());
    assertNull(post.getExternalDocs());
    assertNull(getResult.getExternalDocs());
    assertNull(getResult6.getExternalDocs());
    assertNull(getResult9.getExternalDocs());
    assertNull(getResult3.getExternalDocs());
    assertNull(getResult7.getExternalDocs());
    assertNull(getResult8.getExternalDocs());
    assertNull(getResult10.getExternalDocs());
    assertNull(getResult11.getExternalDocs());
    assertNull(getResult4.getExternalDocs());
    assertNull(getResult12.getExternalDocs());
    assertNull(getResult5.getExternalDocs());
    assertNull(getResult13.getDelete());
    assertNull(getResult13.getGet());
    assertNull(getResult13.getHead());
    assertNull(getResult13.getOptions());
    assertNull(getResult13.getPatch());
    assertNull(getResult13.getPut());
    assertNull(getResult13.getTrace());
    assertNull(schema.getDiscriminator());
    assertNull(getResult.getDiscriminator());
    assertNull(getResult6.getDiscriminator());
    assertNull(getResult9.getDiscriminator());
    assertNull(getResult3.getDiscriminator());
    assertNull(getResult7.getDiscriminator());
    assertNull(getResult8.getDiscriminator());
    assertNull(getResult10.getDiscriminator());
    assertNull(getResult11.getDiscriminator());
    assertNull(getResult4.getDiscriminator());
    assertNull(getResult12.getDiscriminator());
    assertNull(getResult5.getDiscriminator());
    assertNull(schema.getAdditionalItems());
    assertNull(getResult.getAdditionalItems());
    assertNull(getResult6.getAdditionalItems());
    assertNull(getResult9.getAdditionalItems());
    assertNull(getResult3.getAdditionalItems());
    assertNull(getResult7.getAdditionalItems());
    assertNull(getResult8.getAdditionalItems());
    assertNull(getResult10.getAdditionalItems());
    assertNull(getResult11.getAdditionalItems());
    assertNull(getResult4.getAdditionalItems());
    assertNull(getResult12.getAdditionalItems());
    assertNull(getResult5.getAdditionalItems());
    assertNull(schema.getContains());
    assertNull(getResult.getContains());
    assertNull(getResult6.getContains());
    assertNull(getResult9.getContains());
    assertNull(getResult3.getContains());
    assertNull(getResult7.getContains());
    assertNull(getResult8.getContains());
    assertNull(getResult10.getContains());
    assertNull(getResult11.getContains());
    assertNull(getResult4.getContains());
    assertNull(getResult12.getContains());
    assertNull(getResult5.getContains());
    assertNull(schema.getContentSchema());
    assertNull(getResult.getContentSchema());
    assertNull(getResult6.getContentSchema());
    assertNull(getResult9.getContentSchema());
    assertNull(getResult3.getContentSchema());
    assertNull(getResult7.getContentSchema());
    assertNull(getResult8.getContentSchema());
    assertNull(getResult10.getContentSchema());
    assertNull(getResult11.getContentSchema());
    assertNull(getResult4.getContentSchema());
    assertNull(getResult12.getContentSchema());
    assertNull(getResult5.getContentSchema());
    assertNull(schema.getElse());
    assertNull(getResult.getElse());
    assertNull(getResult6.getElse());
    assertNull(getResult9.getElse());
    assertNull(getResult3.getElse());
    assertNull(getResult7.getElse());
    assertNull(getResult8.getElse());
    assertNull(getResult10.getElse());
    assertNull(getResult11.getElse());
    assertNull(getResult4.getElse());
    assertNull(getResult12.getElse());
    assertNull(getResult5.getElse());
    assertNull(getResult.getIf());
    assertNull(getResult6.getIf());
    assertNull(getResult9.getIf());
    assertNull(getResult3.getIf());
    assertNull(getResult7.getIf());
    assertNull(getResult8.getIf());
    assertNull(getResult10.getIf());
    assertNull(getResult11.getIf());
    assertNull(getResult4.getIf());
    assertNull(getResult12.getIf());
    assertNull(getResult5.getIf());
    assertNull(getResult.getNot());
    assertNull(getResult6.getNot());
    assertNull(getResult9.getNot());
    assertNull(getResult3.getNot());
    assertNull(getResult7.getNot());
    assertNull(getResult8.getNot());
    assertNull(getResult10.getNot());
    assertNull(getResult11.getNot());
    assertNull(getResult4.getNot());
    assertNull(getResult12.getNot());
    assertNull(getResult5.getNot());
    assertNull(getResult.getPropertyNames());
    assertNull(getResult6.getPropertyNames());
    assertNull(getResult9.getPropertyNames());
    assertNull(getResult3.getPropertyNames());
    assertNull(getResult7.getPropertyNames());
    assertNull(getResult8.getPropertyNames());
    assertNull(getResult10.getPropertyNames());
    assertNull(getResult11.getPropertyNames());
    assertNull(getResult4.getPropertyNames());
    assertNull(getResult12.getPropertyNames());
    assertNull(getResult5.getPropertyNames());
    assertNull(getResult.getThen());
    assertNull(getResult6.getThen());
    assertNull(getResult9.getThen());
    assertNull(getResult3.getThen());
    assertNull(getResult7.getThen());
    assertNull(getResult8.getThen());
    assertNull(getResult10.getThen());
    assertNull(getResult11.getThen());
    assertNull(getResult4.getThen());
    assertNull(getResult12.getThen());
    assertNull(getResult5.getThen());
    assertNull(getResult.getUnevaluatedItems());
    assertNull(getResult6.getUnevaluatedItems());
    assertNull(getResult9.getUnevaluatedItems());
    assertNull(getResult3.getUnevaluatedItems());
    assertNull(getResult7.getUnevaluatedItems());
    assertNull(getResult8.getUnevaluatedItems());
    assertNull(getResult10.getUnevaluatedItems());
    assertNull(getResult11.getUnevaluatedItems());
    assertNull(getResult4.getUnevaluatedItems());
    assertNull(getResult12.getUnevaluatedItems());
    assertNull(getResult5.getUnevaluatedItems());
    assertNull(getResult.getUnevaluatedProperties());
    assertNull(getResult6.getUnevaluatedProperties());
    assertNull(getResult9.getUnevaluatedProperties());
    assertNull(getResult3.getUnevaluatedProperties());
    assertNull(getResult7.getUnevaluatedProperties());
    assertNull(getResult8.getUnevaluatedProperties());
    assertNull(getResult10.getUnevaluatedProperties());
    assertNull(getResult11.getUnevaluatedProperties());
    assertNull(getResult4.getUnevaluatedProperties());
    assertNull(getResult12.getUnevaluatedProperties());
    assertNull(getResult5.getUnevaluatedProperties());
    assertNull(getResult.getItems());
    assertNull(getResult6.getItems());
    assertNull(getResult9.getItems());
    assertNull(getResult3.getItems());
    assertNull(getResult7.getItems());
    assertNull(getResult8.getItems());
    assertNull(getResult10.getItems());
    assertNull(getResult11.getItems());
    assertNull(getResult4.getItems());
    assertNull(getResult12.getItems());
    assertNull(getResult5.getItems());
    assertNull(getResult.getXml());
    assertNull(getResult6.getXml());
    assertNull(getResult9.getXml());
    assertNull(getResult3.getXml());
    assertNull(getResult7.getXml());
    assertNull(getResult8.getXml());
    assertNull(getResult10.getXml());
    assertNull(getResult11.getXml());
    assertNull(getResult4.getXml());
    assertNull(getResult12.getXml());
    assertNull(getResult5.getXml());
    assertNull(getResult15.getFlows());
    assertNull(getResult15.getIn());
    assertNull(post.getDeprecated());
    assertNull(schema.getBooleanSchemaValue());
    assertNull(getResult.getBooleanSchemaValue());
    assertNull(getResult6.getBooleanSchemaValue());
    assertNull(getResult9.getBooleanSchemaValue());
    assertNull(getResult3.getBooleanSchemaValue());
    assertNull(getResult7.getBooleanSchemaValue());
    assertNull(getResult8.getBooleanSchemaValue());
    assertNull(getResult10.getBooleanSchemaValue());
    assertNull(getResult11.getBooleanSchemaValue());
    assertNull(getResult4.getBooleanSchemaValue());
    assertNull(getResult12.getBooleanSchemaValue());
    assertNull(getResult5.getBooleanSchemaValue());
    assertNull(schema.getDeprecated());
    assertNull(getResult.getDeprecated());
    assertNull(getResult6.getDeprecated());
    assertNull(getResult9.getDeprecated());
    assertNull(getResult3.getDeprecated());
    assertNull(getResult7.getDeprecated());
    assertNull(getResult8.getDeprecated());
    assertNull(getResult10.getDeprecated());
    assertNull(getResult11.getDeprecated());
    assertNull(getResult4.getDeprecated());
    assertNull(getResult12.getDeprecated());
    assertNull(getResult5.getDeprecated());
    assertNull(getResult.getExclusiveMaximum());
    assertNull(getResult6.getExclusiveMaximum());
    assertNull(getResult9.getExclusiveMaximum());
    assertNull(getResult3.getExclusiveMaximum());
    assertNull(getResult7.getExclusiveMaximum());
    assertNull(getResult8.getExclusiveMaximum());
    assertNull(getResult10.getExclusiveMaximum());
    assertNull(getResult11.getExclusiveMaximum());
    assertNull(getResult4.getExclusiveMaximum());
    assertNull(getResult12.getExclusiveMaximum());
    assertNull(getResult5.getExclusiveMaximum());
    assertNull(getResult.getExclusiveMinimum());
    assertNull(getResult6.getExclusiveMinimum());
    assertNull(getResult9.getExclusiveMinimum());
    assertNull(getResult3.getExclusiveMinimum());
    assertNull(getResult7.getExclusiveMinimum());
    assertNull(getResult8.getExclusiveMinimum());
    assertNull(getResult10.getExclusiveMinimum());
    assertNull(getResult11.getExclusiveMinimum());
    assertNull(getResult4.getExclusiveMinimum());
    assertNull(getResult12.getExclusiveMinimum());
    assertNull(getResult5.getExclusiveMinimum());
    assertNull(getResult.getNullable());
    assertNull(getResult6.getNullable());
    assertNull(getResult9.getNullable());
    assertNull(getResult3.getNullable());
    assertNull(getResult7.getNullable());
    assertNull(getResult8.getNullable());
    assertNull(getResult10.getNullable());
    assertNull(getResult11.getNullable());
    assertNull(getResult4.getNullable());
    assertNull(getResult12.getNullable());
    assertNull(getResult5.getNullable());
    assertNull(getResult.getReadOnly());
    assertNull(getResult6.getReadOnly());
    assertNull(getResult9.getReadOnly());
    assertNull(getResult3.getReadOnly());
    assertNull(getResult7.getReadOnly());
    assertNull(getResult8.getReadOnly());
    assertNull(getResult10.getReadOnly());
    assertNull(getResult11.getReadOnly());
    assertNull(getResult.getUniqueItems());
    assertNull(getResult6.getUniqueItems());
    assertNull(getResult9.getUniqueItems());
    assertNull(getResult3.getUniqueItems());
    assertNull(getResult7.getUniqueItems());
    assertNull(getResult8.getUniqueItems());
    assertNull(getResult10.getUniqueItems());
    assertNull(getResult11.getUniqueItems());
    assertNull(getResult4.getUniqueItems());
    assertNull(getResult12.getUniqueItems());
    assertNull(getResult5.getUniqueItems());
    assertNull(getResult.getWriteOnly());
    assertNull(getResult6.getWriteOnly());
    assertNull(getResult9.getWriteOnly());
    assertNull(getResult3.getWriteOnly());
    assertNull(getResult7.getWriteOnly());
    assertNull(getResult8.getWriteOnly());
    assertNull(getResult10.getWriteOnly());
    assertNull(getResult11.getWriteOnly());
    assertNull(getResult4.getWriteOnly());
    assertNull(getResult12.getWriteOnly());
    assertNull(getResult5.getWriteOnly());
    assertNull(requestBody.getRequired());
    assertNull(getResult.getMaxContains());
    assertNull(getResult6.getMaxContains());
    assertNull(getResult9.getMaxContains());
    assertNull(getResult3.getMaxContains());
    assertNull(getResult7.getMaxContains());
    assertNull(getResult8.getMaxContains());
    assertNull(getResult10.getMaxContains());
    assertNull(getResult11.getMaxContains());
    assertNull(getResult4.getMaxContains());
    assertNull(getResult12.getMaxContains());
    assertNull(getResult5.getMaxContains());
    assertNull(getResult.getMaxItems());
    assertNull(getResult6.getMaxItems());
    assertNull(getResult9.getMaxItems());
    assertNull(getResult3.getMaxItems());
    assertNull(getResult7.getMaxItems());
    assertNull(getResult8.getMaxItems());
    assertNull(getResult10.getMaxItems());
    assertNull(getResult11.getMaxItems());
    assertNull(getResult4.getMaxItems());
    assertNull(getResult12.getMaxItems());
    assertNull(getResult5.getMaxItems());
    assertNull(getResult.getMaxLength());
    assertNull(getResult6.getMaxLength());
    assertNull(getResult9.getMaxLength());
    assertNull(getResult3.getMaxLength());
    assertNull(getResult7.getMaxLength());
    assertNull(getResult8.getMaxLength());
    assertNull(getResult10.getMaxLength());
    assertNull(getResult11.getMaxLength());
    assertNull(getResult4.getMaxLength());
    assertNull(getResult12.getMaxLength());
    assertNull(getResult5.getMaxLength());
    assertNull(getResult.getMaxProperties());
    assertNull(getResult6.getMaxProperties());
    assertNull(getResult9.getMaxProperties());
    assertNull(getResult3.getMaxProperties());
    assertNull(getResult7.getMaxProperties());
    assertNull(getResult8.getMaxProperties());
    assertNull(getResult10.getMaxProperties());
    assertNull(getResult11.getMaxProperties());
    assertNull(getResult4.getMaxProperties());
    assertNull(getResult12.getMaxProperties());
    assertNull(getResult5.getMaxProperties());
    assertNull(getResult.getMinContains());
    assertNull(getResult6.getMinContains());
    assertNull(getResult9.getMinContains());
    assertNull(getResult3.getMinContains());
    assertNull(getResult7.getMinContains());
    assertNull(getResult8.getMinContains());
    assertNull(getResult10.getMinContains());
    assertNull(getResult11.getMinContains());
    assertNull(getResult4.getMinContains());
    assertNull(getResult12.getMinContains());
    assertNull(getResult5.getMinContains());
    assertNull(getResult.getMinItems());
    assertNull(getResult6.getMinItems());
    assertNull(getResult9.getMinItems());
    assertNull(getResult3.getMinItems());
    assertNull(getResult7.getMinItems());
    assertNull(getResult8.getMinItems());
    assertNull(getResult10.getMinItems());
    assertNull(getResult11.getMinItems());
    assertNull(getResult4.getMinItems());
    assertNull(getResult12.getMinItems());
    assertNull(getResult5.getMinItems());
    assertNull(getResult.getMinLength());
    assertNull(getResult6.getMinLength());
    assertNull(getResult9.getMinLength());
    assertNull(getResult3.getMinLength());
    assertNull(getResult7.getMinLength());
    assertNull(getResult8.getMinLength());
    assertNull(getResult10.getMinLength());
    assertNull(getResult11.getMinLength());
    assertNull(getResult4.getMinLength());
    assertNull(getResult12.getMinLength());
    assertNull(getResult5.getMinLength());
    assertNull(getResult.getMinProperties());
    assertNull(getResult6.getMinProperties());
    assertNull(getResult9.getMinProperties());
    assertNull(getResult3.getMinProperties());
    assertNull(getResult7.getMinProperties());
    assertNull(getResult8.getMinProperties());
    assertNull(getResult10.getMinProperties());
    assertNull(getResult11.getMinProperties());
    assertNull(getResult4.getMinProperties());
    assertNull(getResult12.getMinProperties());
    assertNull(getResult5.getMinProperties());
    assertNull(getResult4.getConst());
    assertNull(getResult5.getConst());
    assertNull(getResult4.getDefault());
    assertNull(getResult5.getDefault());
    assertNull(traverseResult.getCurrentValue());
    assertNull(traverseResult.getEmbeddedObject());
    assertNull(traverseResult.getInputSource());
    assertNull(traverseResult.getObjectId());
    assertNull(traverseResult.getTypeId());
    assertNull(getResult14.getExample());
    assertNull(schema.getAdditionalProperties());
    assertNull(getResult.getAdditionalProperties());
    assertNull(getResult6.getAdditionalProperties());
    assertNull(getResult9.getAdditionalProperties());
    assertNull(getResult3.getAdditionalProperties());
    assertNull(getResult7.getAdditionalProperties());
    assertNull(getResult8.getAdditionalProperties());
    assertNull(getResult10.getAdditionalProperties());
    assertNull(getResult11.getAdditionalProperties());
    assertNull(getResult4.getAdditionalProperties());
    assertNull(getResult12.getAdditionalProperties());
    assertNull(getResult5.getAdditionalProperties());
    assertNull(schema.getConst());
    assertNull(getResult.getConst());
    assertNull(getResult6.getConst());
    assertNull(getResult9.getConst());
    assertNull(getResult3.getConst());
    assertNull(schema.getDefault());
    assertNull(getResult.getDefault());
    assertNull(getResult6.getDefault());
    assertNull(getResult9.getDefault());
    assertNull(getResult3.getDefault());
    assertNull(schema.getExample());
    assertNull(getResult.getExample());
    assertNull(getResult6.getExample());
    assertNull(getResult9.getExample());
    assertNull(getResult3.getExample());
    assertNull(getResult.getJsonSchemaImpl());
    assertNull(getResult6.getJsonSchemaImpl());
    assertNull(getResult9.getJsonSchemaImpl());
    assertNull(getResult3.getJsonSchemaImpl());
    assertNull(getResult7.getJsonSchemaImpl());
    assertNull(getResult8.getJsonSchemaImpl());
    assertNull(getResult10.getJsonSchemaImpl());
    assertNull(getResult11.getJsonSchemaImpl());
    assertNull(getResult4.getJsonSchemaImpl());
    assertNull(getResult12.getJsonSchemaImpl());
    assertNull(getResult5.getJsonSchemaImpl());
    assertNull(traverseResult.getCurrentName());
    assertNull(traverseResult.getText());
    assertNull(traverseResult.getValueAsString());
    assertNull(actualThingsboardApiResult.getJsonSchemaDialect());
    assertNull(post.getOperationId());
    assertNull(getResult13.get$ref());
    assertNull(getResult13.getDescription());
    assertNull(getResult13.getSummary());
    Info info = actualThingsboardApiResult.getInfo();
    Contact contact = info.getContact();
    assertNull(contact.getEmail());
    assertNull(contact.getName());
    assertNull(contact.getUrl());
    assertNull(info.getDescription());
    assertNull(info.getSummary());
    assertNull(info.getTermsOfService());
    assertNull(info.getTitle());
    assertNull(info.getVersion());
    License license = info.getLicense();
    assertNull(license.getIdentifier());
    assertNull(license.getName());
    assertNull(license.getUrl());
    assertNull(schema.get$anchor());
    assertNull(getResult.get$anchor());
    assertNull(getResult6.get$anchor());
    assertNull(getResult9.get$anchor());
    assertNull(getResult3.get$anchor());
    assertNull(getResult7.get$anchor());
    assertNull(getResult8.get$anchor());
    assertNull(getResult10.get$anchor());
    assertNull(getResult11.get$anchor());
    assertNull(getResult4.get$anchor());
    assertNull(getResult12.get$anchor());
    assertNull(getResult5.get$anchor());
    assertNull(schema.get$comment());
    assertNull(getResult.get$comment());
    assertNull(getResult6.get$comment());
    assertNull(getResult9.get$comment());
    assertNull(getResult3.get$comment());
    assertNull(getResult7.get$comment());
    assertNull(getResult8.get$comment());
    assertNull(getResult10.get$comment());
    assertNull(getResult11.get$comment());
    assertNull(getResult4.get$comment());
    assertNull(getResult12.get$comment());
    assertNull(getResult5.get$comment());
    assertNull(schema.get$id());
    assertNull(getResult.get$id());
    assertNull(getResult6.get$id());
    assertNull(getResult9.get$id());
    assertNull(getResult3.get$id());
    assertNull(getResult7.get$id());
    assertNull(getResult8.get$id());
    assertNull(getResult10.get$id());
    assertNull(getResult11.get$id());
    assertNull(getResult4.get$id());
    assertNull(getResult12.get$id());
    assertNull(getResult5.get$id());
    assertNull(getResult.get$ref());
    assertNull(getResult6.get$ref());
    assertNull(getResult9.get$ref());
    assertNull(getResult3.get$ref());
    assertNull(getResult7.get$ref());
    assertNull(getResult8.get$ref());
    assertNull(getResult10.get$ref());
    assertNull(getResult11.get$ref());
    assertNull(getResult4.get$ref());
    assertNull(getResult12.get$ref());
    assertNull(getResult5.get$ref());
    assertNull(schema.get$schema());
    assertNull(getResult.get$schema());
    assertNull(getResult6.get$schema());
    assertNull(getResult9.get$schema());
    assertNull(getResult3.get$schema());
    assertNull(getResult7.get$schema());
    assertNull(getResult8.get$schema());
    assertNull(getResult10.get$schema());
    assertNull(getResult11.get$schema());
    assertNull(getResult4.get$schema());
    assertNull(getResult12.get$schema());
    assertNull(getResult5.get$schema());
    assertNull(schema.get$vocabulary());
    assertNull(getResult.get$vocabulary());
    assertNull(getResult6.get$vocabulary());
    assertNull(getResult9.get$vocabulary());
    assertNull(getResult3.get$vocabulary());
    assertNull(getResult7.get$vocabulary());
    assertNull(getResult8.get$vocabulary());
    assertNull(getResult10.get$vocabulary());
    assertNull(getResult11.get$vocabulary());
    assertNull(getResult4.get$vocabulary());
    assertNull(getResult12.get$vocabulary());
    assertNull(getResult5.get$vocabulary());
    assertNull(getResult7.getConst());
    assertNull(getResult8.getConst());
    assertNull(getResult10.getConst());
    assertNull(getResult11.getConst());
    assertNull(getResult12.getConst());
    assertNull(schema.getContentEncoding());
    assertNull(getResult.getContentEncoding());
    assertNull(getResult6.getContentEncoding());
    assertNull(getResult9.getContentEncoding());
    assertNull(getResult3.getContentEncoding());
    assertNull(getResult7.getContentEncoding());
    assertNull(getResult8.getContentEncoding());
    assertNull(getResult10.getContentEncoding());
    assertNull(getResult11.getContentEncoding());
    assertNull(getResult4.getContentEncoding());
    assertNull(getResult12.getContentEncoding());
    assertNull(getResult5.getContentEncoding());
    assertNull(schema.getContentMediaType());
    assertNull(getResult.getContentMediaType());
    assertNull(getResult6.getContentMediaType());
    assertNull(getResult9.getContentMediaType());
    assertNull(getResult3.getContentMediaType());
    assertNull(getResult7.getContentMediaType());
    assertNull(getResult8.getContentMediaType());
    assertNull(getResult10.getContentMediaType());
    assertNull(getResult11.getContentMediaType());
    assertNull(getResult4.getContentMediaType());
    assertNull(getResult12.getContentMediaType());
    assertNull(getResult5.getContentMediaType());
    assertNull(getResult7.getDefault());
    assertNull(getResult8.getDefault());
    assertNull(getResult10.getDefault());
    assertNull(getResult11.getDefault());
    assertNull(getResult12.getDefault());
    assertNull(schema.getDescription());
    assertNull(getResult6.getDescription());
    assertNull(getResult9.getDescription());
    assertNull(getResult3.getDescription());
    assertNull(getResult.getFormat());
    assertNull(getResult6.getFormat());
    assertNull(getResult9.getFormat());
    assertNull(getResult3.getFormat());
    assertNull(getResult7.getFormat());
    assertNull(getResult8.getFormat());
    assertNull(getResult10.getFormat());
    assertNull(getResult11.getFormat());
    assertNull(getResult12.getFormat());
    assertNull(getResult.getPattern());
    assertNull(getResult6.getPattern());
    assertNull(getResult9.getPattern());
    assertNull(getResult3.getPattern());
    assertNull(getResult7.getPattern());
    assertNull(getResult8.getPattern());
    assertNull(getResult10.getPattern());
    assertNull(getResult11.getPattern());
    assertNull(getResult4.getPattern());
    assertNull(getResult12.getPattern());
    assertNull(getResult5.getPattern());
    assertNull(getResult.getTitle());
    assertNull(getResult6.getTitle());
    assertNull(getResult9.getTitle());
    assertNull(getResult3.getTitle());
    assertNull(getResult7.getTitle());
    assertNull(getResult8.getTitle());
    assertNull(getResult10.getTitle());
    assertNull(getResult11.getTitle());
    assertNull(getResult4.getTitle());
    assertNull(getResult12.getTitle());
    assertNull(getResult5.getTitle());
    assertNull(requestBody.get$ref());
    assertNull(getResult16.get$ref());
    assertNull(getResult17.get$ref());
    assertNull(getResult18.get$ref());
    assertNull(getResult15.get$ref());
    assertNull(getResult15.getName());
    assertNull(getResult15.getOpenIdConnectUrl());
    assertNull(getResult.getExclusiveMaximumValue());
    assertNull(getResult6.getExclusiveMaximumValue());
    assertNull(getResult9.getExclusiveMaximumValue());
    assertNull(getResult3.getExclusiveMaximumValue());
    assertNull(getResult7.getExclusiveMaximumValue());
    assertNull(getResult8.getExclusiveMaximumValue());
    assertNull(getResult10.getExclusiveMaximumValue());
    assertNull(getResult11.getExclusiveMaximumValue());
    assertNull(getResult4.getExclusiveMaximumValue());
    assertNull(getResult12.getExclusiveMaximumValue());
    assertNull(getResult5.getExclusiveMaximumValue());
    assertNull(getResult.getExclusiveMinimumValue());
    assertNull(getResult6.getExclusiveMinimumValue());
    assertNull(getResult9.getExclusiveMinimumValue());
    assertNull(getResult3.getExclusiveMinimumValue());
    assertNull(getResult7.getExclusiveMinimumValue());
    assertNull(getResult8.getExclusiveMinimumValue());
    assertNull(getResult10.getExclusiveMinimumValue());
    assertNull(getResult11.getExclusiveMinimumValue());
    assertNull(getResult4.getExclusiveMinimumValue());
    assertNull(getResult12.getExclusiveMinimumValue());
    assertNull(getResult5.getExclusiveMinimumValue());
    assertNull(getResult.getMaximum());
    assertNull(getResult6.getMaximum());
    assertNull(getResult9.getMaximum());
    assertNull(getResult3.getMaximum());
    assertNull(getResult7.getMaximum());
    assertNull(getResult8.getMaximum());
    assertNull(getResult10.getMaximum());
    assertNull(getResult11.getMaximum());
    assertNull(getResult4.getMaximum());
    assertNull(getResult12.getMaximum());
    assertNull(getResult5.getMaximum());
    assertNull(getResult.getMinimum());
    assertNull(getResult6.getMinimum());
    assertNull(getResult9.getMinimum());
    assertNull(getResult3.getMinimum());
    assertNull(getResult7.getMinimum());
    assertNull(getResult8.getMinimum());
    assertNull(getResult10.getMinimum());
    assertNull(getResult11.getMinimum());
    assertNull(getResult4.getMinimum());
    assertNull(getResult12.getMinimum());
    assertNull(getResult5.getMinimum());
    assertNull(getResult.getMultipleOf());
    assertNull(getResult6.getMultipleOf());
    assertNull(getResult9.getMultipleOf());
    assertNull(getResult3.getMultipleOf());
    assertNull(getResult7.getMultipleOf());
    assertNull(getResult8.getMultipleOf());
    assertNull(getResult10.getMultipleOf());
    assertNull(getResult11.getMultipleOf());
    assertNull(getResult4.getMultipleOf());
    assertNull(getResult12.getMultipleOf());
    assertNull(getResult5.getMultipleOf());
    assertNull(schema.getEnum());
    assertNull(getResult.getEnum());
    assertNull(getResult6.getEnum());
    assertNull(getResult9.getEnum());
    assertNull(getResult3.getEnum());
    assertNull(getResult6.getExamples());
    assertNull(getResult9.getExamples());
    assertNull(getResult3.getExamples());
    assertNull(schema.getAllOf());
    assertNull(getResult.getAllOf());
    assertNull(getResult6.getAllOf());
    assertNull(getResult9.getAllOf());
    assertNull(getResult3.getAllOf());
    assertNull(getResult7.getAllOf());
    assertNull(getResult8.getAllOf());
    assertNull(getResult10.getAllOf());
    assertNull(getResult11.getAllOf());
    assertNull(getResult4.getAllOf());
    assertNull(getResult12.getAllOf());
    assertNull(getResult5.getAllOf());
    assertNull(schema.getAnyOf());
    assertNull(getResult.getAnyOf());
    assertNull(getResult6.getAnyOf());
    assertNull(getResult9.getAnyOf());
    assertNull(getResult3.getAnyOf());
    assertNull(getResult7.getAnyOf());
    assertNull(getResult8.getAnyOf());
    assertNull(getResult10.getAnyOf());
    assertNull(getResult11.getAnyOf());
    assertNull(getResult4.getAnyOf());
    assertNull(getResult12.getAnyOf());
    assertNull(getResult5.getAnyOf());
    assertNull(getResult.getOneOf());
    assertNull(getResult6.getOneOf());
    assertNull(getResult9.getOneOf());
    assertNull(getResult3.getOneOf());
    assertNull(getResult7.getOneOf());
    assertNull(getResult8.getOneOf());
    assertNull(getResult10.getOneOf());
    assertNull(getResult11.getOneOf());
    assertNull(getResult4.getOneOf());
    assertNull(getResult12.getOneOf());
    assertNull(getResult5.getOneOf());
    assertNull(getResult.getPrefixItems());
    assertNull(getResult6.getPrefixItems());
    assertNull(getResult9.getPrefixItems());
    assertNull(getResult3.getPrefixItems());
    assertNull(getResult7.getPrefixItems());
    assertNull(getResult8.getPrefixItems());
    assertNull(getResult10.getPrefixItems());
    assertNull(getResult11.getPrefixItems());
    assertNull(getResult4.getPrefixItems());
    assertNull(getResult12.getPrefixItems());
    assertNull(getResult5.getPrefixItems());
    assertNull(post.getParameters());
    assertNull(getResult13.getParameters());
    assertNull(actualThingsboardApiResult.getSecurity());
    assertNull(post.getSecurity());
    assertNull(actualThingsboardApiResult.getServers());
    assertNull(post.getServers());
    assertNull(getResult13.getServers());
    assertNull(actualThingsboardApiResult.getTags());
    assertNull(getResult4.getEnum());
    assertNull(getResult5.getEnum());
    assertNull(getResult4.getExamples());
    assertNull(getResult5.getExamples());
    assertNull(getResult7.getEnum());
    assertNull(getResult8.getEnum());
    assertNull(getResult10.getEnum());
    assertNull(getResult11.getEnum());
    assertNull(getResult12.getEnum());
    assertNull(getResult7.getExamples());
    assertNull(getResult8.getExamples());
    assertNull(getResult10.getExamples());
    assertNull(getResult11.getExamples());
    assertNull(getResult12.getExamples());
    assertNull(getResult.getRequired());
    assertNull(getResult3.getRequired());
    assertNull(getResult7.getRequired());
    assertNull(getResult8.getRequired());
    assertNull(getResult10.getRequired());
    assertNull(getResult11.getRequired());
    assertNull(getResult4.getRequired());
    assertNull(getResult12.getRequired());
    assertNull(getResult5.getRequired());
    assertNull(components.getPathItems());
    assertNull(actualThingsboardApiResult.getWebhooks());
    assertNull(components.getCallbacks());
    assertNull(post.getCallbacks());
    assertNull(components.getExamples());
    assertNull(getResult14.getExamples());
    assertNull(components.getHeaders());
    assertNull(getResult16.getHeaders());
    assertNull(getResult17.getHeaders());
    assertNull(getResult18.getHeaders());
    assertNull(components.getLinks());
    assertNull(getResult16.getLinks());
    assertNull(getResult17.getLinks());
    assertNull(getResult18.getLinks());
    assertNull(getResult14.getEncoding());
    assertNull(schema.getDependentSchemas());
    assertNull(getResult.getDependentSchemas());
    assertNull(getResult6.getDependentSchemas());
    assertNull(getResult9.getDependentSchemas());
    assertNull(getResult3.getDependentSchemas());
    assertNull(getResult7.getDependentSchemas());
    assertNull(getResult8.getDependentSchemas());
    assertNull(getResult10.getDependentSchemas());
    assertNull(getResult11.getDependentSchemas());
    assertNull(getResult4.getDependentSchemas());
    assertNull(getResult12.getDependentSchemas());
    assertNull(getResult5.getDependentSchemas());
    assertNull(getResult.getPatternProperties());
    assertNull(getResult6.getPatternProperties());
    assertNull(getResult9.getPatternProperties());
    assertNull(getResult3.getPatternProperties());
    assertNull(getResult7.getPatternProperties());
    assertNull(getResult8.getPatternProperties());
    assertNull(getResult10.getPatternProperties());
    assertNull(getResult11.getPatternProperties());
    assertNull(getResult4.getPatternProperties());
    assertNull(getResult12.getPatternProperties());
    assertNull(getResult5.getPatternProperties());
    assertNull(getResult.getProperties());
    assertNull(getResult7.getProperties());
    assertNull(getResult8.getProperties());
    assertNull(getResult10.getProperties());
    assertNull(getResult11.getProperties());
    assertNull(getResult4.getProperties());
    assertNull(getResult12.getProperties());
    assertNull(getResult5.getProperties());
    assertNull(components.getParameters());
    assertNull(components.getRequestBodies());
    assertNull(components.getResponses());
    assertNull(components.getExtensions());
    assertNull(actualThingsboardApiResult.getExtensions());
    assertNull(post.getExtensions());
    assertNull(getResult13.getExtensions());
    assertNull(contact.getExtensions());
    assertNull(info.getExtensions());
    assertNull(license.getExtensions());
    assertNull(getResult14.getExtensions());
    assertNull(getResult.getExtensions());
    assertNull(getResult6.getExtensions());
    assertNull(getResult9.getExtensions());
    assertNull(getResult3.getExtensions());
    assertNull(getResult7.getExtensions());
    assertNull(getResult8.getExtensions());
    assertNull(getResult10.getExtensions());
    assertNull(getResult11.getExtensions());
    assertNull(getResult4.getExtensions());
    assertNull(getResult12.getExtensions());
    assertNull(getResult5.getExtensions());
    assertNull(getResult.getJsonSchema());
    assertNull(getResult6.getJsonSchema());
    assertNull(getResult9.getJsonSchema());
    assertNull(getResult3.getJsonSchema());
    assertNull(getResult7.getJsonSchema());
    assertNull(getResult8.getJsonSchema());
    assertNull(getResult10.getJsonSchema());
    assertNull(getResult11.getJsonSchema());
    assertNull(getResult4.getJsonSchema());
    assertNull(getResult12.getJsonSchema());
    assertNull(getResult5.getJsonSchema());
    assertNull(requestBody.getExtensions());
    assertNull(getResult16.getExtensions());
    assertNull(getResult17.getExtensions());
    assertNull(getResult18.getExtensions());
    assertNull(getResult15.getExtensions());
    assertNull(schema.getDependentRequired());
    assertNull(getResult.getDependentRequired());
    assertNull(getResult6.getDependentRequired());
    assertNull(getResult9.getDependentRequired());
    assertNull(getResult3.getDependentRequired());
    assertNull(getResult7.getDependentRequired());
    assertNull(getResult8.getDependentRequired());
    assertNull(getResult10.getDependentRequired());
    assertNull(getResult11.getDependentRequired());
    assertNull(getResult4.getDependentRequired());
    assertNull(getResult12.getDependentRequired());
    assertNull(getResult5.getDependentRequired());
    assertNull(getResult.getTypes());
    assertNull(getResult6.getTypes());
    assertNull(getResult9.getTypes());
    assertNull(getResult3.getTypes());
    assertEquals(0, traverseResult.getCurrentTokenId());
    assertEquals(0, traverseResult.getFeatureMask());
    assertEquals(0, traverseResult.getFormatFeatures());
    assertEquals(0, traverseResult.getTextOffset());
    assertEquals(0, traverseResult.getValueAsInt());
    assertEquals(0, ((ObjectNode) getResult2).size());
    assertEquals(0.0d, traverseResult.getValueAsDouble());
    assertEquals(0L, traverseResult.getValueAsLong());
    Content content2 = getResult16.getContent();
    assertEquals(1, content2.size());
    Content content3 = getResult17.getContent();
    assertEquals(1, content3.size());
    Content content4 = getResult18.getContent();
    assertEquals(1, content4.size());
    Map<PathItem.HttpMethod, Operation> readOperationsMapResult = getResult13.readOperationsMap();
    assertEquals(1, readOperationsMapResult.size());
    Set<String> types = getResult8.getTypes();
    assertEquals(1, types.size());
    Set<String> types2 = getResult5.getTypes();
    assertEquals(1, types2.size());
    assertEquals(JsonNodeType.OBJECT, ((ObjectNode) getResult2).getNodeType());
    assertEquals(SpecVersion.V30, actualThingsboardApiResult.getSpecVersion());
    assertEquals(SpecVersion.V30, getResult.getSpecVersion());
    assertEquals(SpecVersion.V30, getResult6.getSpecVersion());
    assertEquals(SpecVersion.V30, getResult9.getSpecVersion());
    assertEquals(SpecVersion.V30, getResult3.getSpecVersion());
    assertEquals(SpecVersion.V30, getResult7.getSpecVersion());
    assertEquals(SpecVersion.V30, getResult8.getSpecVersion());
    assertEquals(SpecVersion.V30, getResult10.getSpecVersion());
    assertEquals(SpecVersion.V30, getResult11.getSpecVersion());
    assertEquals(SpecVersion.V30, getResult4.getSpecVersion());
    assertEquals(SpecVersion.V30, getResult12.getSpecVersion());
    assertEquals(SpecVersion.V30, getResult5.getSpecVersion());
    assertEquals(SecurityScheme.Type.HTTP, getResult15.getType());
    assertFalse(traverseResult.getValueAsBoolean());
    assertFalse(traverseResult.hasCurrentToken());
    assertFalse(traverseResult.hasTextCharacters());
    assertFalse(traverseResult.isClosed());
    assertFalse(traverseResult.isExpectedNumberIntToken());
    assertFalse(traverseResult.isExpectedStartArrayToken());
    assertFalse(traverseResult.isExpectedStartObjectToken());
    assertFalse(traverseResult.isNaN());
    assertFalse(((ObjectNode) getResult2).isArray());
    assertFalse(((ObjectNode) getResult2).isBigDecimal());
    assertFalse(((ObjectNode) getResult2).isBigInteger());
    assertFalse(((ObjectNode) getResult2).isBinary());
    assertFalse(((ObjectNode) getResult2).isBoolean());
    assertFalse(((ObjectNode) getResult2).isDouble());
    assertFalse(((ObjectNode) getResult2).isFloat());
    assertFalse(((ObjectNode) getResult2).isFloatingPointNumber());
    assertFalse(((ObjectNode) getResult2).isInt());
    assertFalse(((ObjectNode) getResult2).isIntegralNumber());
    assertFalse(((ObjectNode) getResult2).isLong());
    assertFalse(((ObjectNode) getResult2).isMissingNode());
    assertFalse(((ObjectNode) getResult2).isNull());
    assertFalse(((ObjectNode) getResult2).isNumber());
    assertFalse(((ObjectNode) getResult2).isPojo());
    assertFalse(((ObjectNode) getResult2).isShort());
    assertFalse(((ObjectNode) getResult2).isTextual());
    assertFalse(((ObjectNode) getResult2).isValueNode());
    assertFalse(getResult14.getExampleSetFlag());
    assertFalse(getResult.getExampleSetFlag());
    assertFalse(getResult6.getExampleSetFlag());
    assertFalse(getResult9.getExampleSetFlag());
    assertFalse(getResult3.getExampleSetFlag());
    assertFalse(((ObjectNode) getResult2).iterator().hasNext());
    assertTrue(((ObjectNode) getResult2).isContainerNode());
    assertTrue(((ObjectNode) getResult2).isEmpty());
    assertTrue(((ObjectNode) getResult2).isObject());
    assertTrue(getResult7.getExampleSetFlag());
    assertTrue(getResult8.getExampleSetFlag());
    assertTrue(getResult10.getExampleSetFlag());
    assertTrue(getResult11.getExampleSetFlag());
    assertTrue(getResult4.getExampleSetFlag());
    assertTrue(getResult12.getExampleSetFlag());
    assertTrue(getResult5.getExampleSetFlag());
    assertTrue(getResult4.getReadOnly());
    assertTrue(getResult12.getReadOnly());
    assertTrue(getResult5.getReadOnly());
    assertTrue(content2.containsKey("application/json"));
    assertTrue(content3.containsKey("application/json"));
    assertTrue(content4.containsKey("application/json"));
    assertTrue(types.contains("string"));
    assertTrue(types2.contains("integer"));
    assertEquals(types, getResult7.getTypes());
    assertEquals(types, getResult10.getTypes());
    assertEquals(types, getResult11.getTypes());
    assertEquals(types, getResult12.getTypes());
    assertEquals(types2, getResult4.getTypes());
    assertEquals(ThingsboardSecurityConfiguration.JWT_TOKEN_QUERY_PARAM, getResult11.getName());
    assertEquals(ThingsboardSecurityConfiguration.JWT_TOKEN_QUERY_PARAM, required2.get(1));
    assertSame(post, readOperationsMapResult.get(PathItem.HttpMethod.POST));
  }

  /**
   * Test {@link SwaggerConfiguration#springDocConfig(SpringDocConfigProperties)}.
   * <ul>
   *   <li>Given {@link GroupConfig}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link SwaggerConfiguration#springDocConfig(SpringDocConfigProperties)}
   */
  @Test
  @DisplayName("Test springDocConfig(SpringDocConfigProperties); given GroupConfig")
  void testSpringDocConfig_givenGroupConfig() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    SwaggerConfiguration swaggerConfiguration = new SwaggerConfiguration();

    SpringDocConfigProperties springDocProperties = new SpringDocConfigProperties();
    springDocProperties.addGroupConfig(mock(SpringDocConfigProperties.GroupConfig.class));

    // Act
    SpringDocConfigProperties actualSpringDocConfigResult = swaggerConfiguration.springDocConfig(springDocProperties);

    // Assert
    assertEquals(SpecVersion.V31, springDocProperties.getSpecVersion());
    assertFalse(springDocProperties.isRemoveBrokenReferenceDefinitions());
    assertTrue(springDocProperties.isOpenapi31());
    assertSame(springDocProperties, actualSpringDocConfigResult);
  }

  /**
   * Test {@link SwaggerConfiguration#springDocConfig(SpringDocConfigProperties)}.
   * <ul>
   *   <li>When {@link SpringDocConfigProperties} (default constructor).</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link SwaggerConfiguration#springDocConfig(SpringDocConfigProperties)}
   */
  @Test
  @DisplayName("Test springDocConfig(SpringDocConfigProperties); when SpringDocConfigProperties (default constructor)")
  void testSpringDocConfig_whenSpringDocConfigProperties() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    SwaggerConfiguration swaggerConfiguration = new SwaggerConfiguration();
    SpringDocConfigProperties springDocProperties = new SpringDocConfigProperties();

    // Act
    SpringDocConfigProperties actualSpringDocConfigResult = swaggerConfiguration.springDocConfig(springDocProperties);

    // Assert
    assertEquals(SpecVersion.V31, springDocProperties.getSpecVersion());
    assertFalse(springDocProperties.isRemoveBrokenReferenceDefinitions());
    assertTrue(springDocProperties.isOpenapi31());
    assertSame(springDocProperties, actualSpringDocConfigResult);
  }

  /**
   * Test {@link SwaggerConfiguration#swaggerUiConfig(SwaggerUiConfigProperties)}.
   * <ul>
   *   <li>Then return Csrf HeaderName is {@code X-XSRF-TOKEN}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link SwaggerConfiguration#swaggerUiConfig(SwaggerUiConfigProperties)}
   */
  @Test
  @DisplayName("Test swaggerUiConfig(SwaggerUiConfigProperties); then return Csrf HeaderName is 'X-XSRF-TOKEN'")
  void testSwaggerUiConfig_thenReturnCsrfHeaderNameIsXXsrfToken() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    SwaggerConfiguration swaggerConfiguration = new SwaggerConfiguration();

    // Act and Assert
    SwaggerUiConfigProperties.Csrf csrf = swaggerConfiguration.swaggerUiConfig(new SwaggerUiConfigProperties())
        .getCsrf();
    assertEquals("X-XSRF-TOKEN", csrf.getHeaderName());
    assertEquals("XSRF-TOKEN", csrf.getCookieName());
    assertEquals("XSRF-TOKEN", csrf.getLocalStorageKey());
    assertEquals("XSRF-TOKEN", csrf.getSessionStorageKey());
    assertFalse(csrf.isEnabled());
    assertFalse(csrf.isUseLocalStorage());
    assertFalse(csrf.isUseSessionStorage());
  }

  /**
   * Test {@link SwaggerConfiguration#swaggerUiConfig(SwaggerUiConfigProperties)}.
   * <ul>
   *   <li>Then {@link SwaggerUiConfigProperties} (default constructor)
   * OperationsSorter is {@code alpha}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link SwaggerConfiguration#swaggerUiConfig(SwaggerUiConfigProperties)}
   */
  @Test
  @DisplayName("Test swaggerUiConfig(SwaggerUiConfigProperties); then SwaggerUiConfigProperties (default constructor) OperationsSorter is 'alpha'")
  void testSwaggerUiConfig_thenSwaggerUiConfigPropertiesOperationsSorterIsAlpha() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    SwaggerConfiguration swaggerConfiguration = new SwaggerConfiguration();
    SwaggerUiConfigProperties.Csrf csrf = mock(SwaggerUiConfigProperties.Csrf.class);
    doNothing().when(csrf).setCookieName(Mockito.<String>any());
    doNothing().when(csrf).setEnabled(anyBoolean());
    doNothing().when(csrf).setHeaderName(Mockito.<String>any());
    doNothing().when(csrf).setLocalStorageKey(Mockito.<String>any());
    doNothing().when(csrf).setSessionStorageKey(Mockito.<String>any());
    doNothing().when(csrf).setUseLocalStorage(anyBoolean());
    doNothing().when(csrf).setUseSessionStorage(anyBoolean());
    csrf.setCookieName("example");
    csrf.setEnabled(true);
    csrf.setHeaderName("example");
    csrf.setLocalStorageKey("example");
    csrf.setSessionStorageKey("example");
    csrf.setUseLocalStorage(true);
    csrf.setUseSessionStorage(true);

    SwaggerUiConfigProperties uiProperties = new SwaggerUiConfigProperties();
    uiProperties.setCsrf(csrf);

    // Act
    SwaggerUiConfigProperties actualSwaggerUiConfigResult = swaggerConfiguration.swaggerUiConfig(uiProperties);

    // Assert
    verify(csrf).setCookieName(eq("example"));
    verify(csrf).setEnabled(eq(true));
    verify(csrf).setHeaderName(eq("example"));
    verify(csrf).setLocalStorageKey(eq("example"));
    verify(csrf).setSessionStorageKey(eq("example"));
    verify(csrf).setUseLocalStorage(eq(true));
    verify(csrf).setUseSessionStorage(eq(true));
    assertEquals("alpha", uiProperties.getOperationsSorter());
    assertEquals("alpha", uiProperties.getTagsSorter());
    assertEquals("example", uiProperties.getDefaultModelRendering());
    assertEquals("list", uiProperties.getDocExpansion());
    assertEquals(1, uiProperties.getDefaultModelExpandDepth().intValue());
    assertEquals(1, uiProperties.getDefaultModelsExpandDepth().intValue());
    assertFalse(uiProperties.getDisplayOperationId());
    assertFalse(uiProperties.getDisplayRequestDuration());
    assertFalse(uiProperties.getShowCommonExtensions());
    assertFalse(uiProperties.getShowExtensions());
    assertTrue(uiProperties.getDeepLinking());
    assertTrue(uiProperties.getPersistAuthorization());
    String expectedFilter = Boolean.FALSE.toString();
    assertEquals(expectedFilter, uiProperties.getFilter());
    assertSame(uiProperties, actualSwaggerUiConfigResult);
  }

  /**
   * Test {@link SwaggerConfiguration#mapAwareConverter()}.
   * <p>
   * Method under test: {@link SwaggerConfiguration#mapAwareConverter()}
   */
  @Test
  @DisplayName("Test mapAwareConverter()")
  void testMapAwareConverter() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange and Act
    ModelConverter actualMapAwareConverterResult = (new SwaggerConfiguration()).mapAwareConverter();
    AnnotatedType annotatedType = new AnnotatedType();
    ModelConverterContextImpl modelConverterContextImpl = new ModelConverterContextImpl(mock(ModelConverter.class));
    ArrayList<ModelConverter> modelConverterList = new ArrayList<>();
    Iterator<ModelConverter> iteratorResult = modelConverterList.iterator();

    // Assert
    assertNull(actualMapAwareConverterResult.resolve(annotatedType, modelConverterContextImpl, iteratorResult));
    assertFalse(actualMapAwareConverterResult.isOpenapi31());
    assertFalse(iteratorResult.hasNext());
  }

  /**
   * Test {@link SwaggerConfiguration#mapAwareConverter()}.
   * <p>
   * Method under test: {@link SwaggerConfiguration#mapAwareConverter()}
   */
  @Test
  @DisplayName("Test mapAwareConverter()")
  void testMapAwareConverter2() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange and Act
    ModelConverter actualMapAwareConverterResult = (new SwaggerConfiguration()).mapAwareConverter();
    AnnotatedType annotatedType = mock(AnnotatedType.class);
    when(annotatedType.getType()).thenReturn(new PlaceholderForType(1));
    ModelConverterContextImpl modelConverterContextImpl = new ModelConverterContextImpl(mock(ModelConverter.class));
    ModelConverter modelConverter = mock(ModelConverter.class);
    Schema schema = new Schema();
    when(modelConverter.resolve(Mockito.<AnnotatedType>any(), Mockito.<ModelConverterContext>any(),
        Mockito.<Iterator<ModelConverter>>any())).thenReturn(schema);
    ArrayList<ModelConverter> modelConverterList = new ArrayList<>();
    modelConverterList.add(modelConverter);
    Iterator<ModelConverter> iteratorResult = modelConverterList.iterator();
    Schema actualResolveResult = actualMapAwareConverterResult.resolve(annotatedType, modelConverterContextImpl,
        iteratorResult);

    // Assert
    verify(annotatedType).getType();
    verify(modelConverter).resolve(isA(AnnotatedType.class), isA(ModelConverterContext.class), isA(Iterator.class));
    assertFalse(iteratorResult.hasNext());
    assertSame(schema, actualResolveResult);
  }
}
