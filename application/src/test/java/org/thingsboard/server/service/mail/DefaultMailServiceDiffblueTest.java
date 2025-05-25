package org.thingsboard.server.service.mail;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.ArgumentMatchers.isNull;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.MethodsUnderTest;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.BigIntegerNode;
import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;
import java.io.IOException;
import java.io.StringReader;
import java.io.Writer;
import java.math.BigInteger;
import java.util.Locale;
import java.util.UUID;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.FactoryBeanNotInitializedException;
import org.springframework.context.MessageSource;
import org.springframework.context.NoSuchMessageException;
import org.thingsboard.server.common.data.ApiFeature;
import org.thingsboard.server.common.data.ApiUsageRecordKey;
import org.thingsboard.server.common.data.ApiUsageRecordState;
import org.thingsboard.server.common.data.ApiUsageStateValue;
import org.thingsboard.server.common.data.exception.ThingsboardErrorCode;
import org.thingsboard.server.common.data.exception.ThingsboardException;
import org.thingsboard.server.common.data.id.TenantId;
import org.thingsboard.server.dao.exception.IncorrectParameterException;

@ExtendWith(MockitoExtension.class)
class DefaultMailServiceDiffblueTest {
  @Mock
  private Configuration configuration;

  @InjectMocks
  private DefaultMailService defaultMailService;

  @Mock
  private MessageSource messageSource;

  /**
   * Test {@link DefaultMailService#sendEmail(TenantId, String, String, String)}.
   * <p>
   * Method under test: {@link DefaultMailService#sendEmail(TenantId, String, String, String)}
   */
  @Test
  @DisplayName("Test sendEmail(TenantId, String, String, String)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void DefaultMailService.sendEmail(TenantId, String, String, String)"})
  void testSendEmail() throws ThingsboardException {
    // Arrange, Act and Assert
    assertThrows(ThingsboardException.class,
        () -> defaultMailService.sendEmail(new TenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")),
            "jane.doe@example.org", "Hello from the Dreaming Spires", "Not all who wander are lost"));
  }

  /**
   * Test {@link DefaultMailService#sendTestMail(JsonNode, String)}.
   * <p>
   * Method under test: {@link DefaultMailService#sendTestMail(JsonNode, String)}
   */
  @Test
  @DisplayName("Test sendTestMail(JsonNode, String)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void DefaultMailService.sendTestMail(JsonNode, String)"})
  void testSendTestMail() throws IOException, NoSuchMessageException, ThingsboardException {
    // Arrange
    when(messageSource.getMessage(Mockito.<String>any(), Mockito.<Object[]>any(), Mockito.<Locale>any()))
        .thenReturn("Not all who wander are lost");
    when(configuration.getTemplate(Mockito.<String>any()))
        .thenThrow(new IncorrectParameterException("An error occurred"));
    ArrayNode jsonConfig = mock(ArrayNode.class);
    when(jsonConfig.has(Mockito.<String>any())).thenReturn(true);
    when(jsonConfig.get(Mockito.<String>any())).thenReturn(new BigIntegerNode(BigInteger.valueOf(1L)));

    // Act and Assert
    assertThrows(ThingsboardException.class, () -> defaultMailService.sendTestMail(jsonConfig, "jane.doe@example.org"));
    verify(jsonConfig, atLeast(1)).has(Mockito.<String>any());
    verify(jsonConfig, atLeast(1)).get(Mockito.<String>any());
    verify(configuration).getTemplate(eq("test.ftl"));
    verify(messageSource).getMessage(eq("test.message.subject"), isNull(), isA(Locale.class));
  }

  /**
   * Test {@link DefaultMailService#sendTestMail(JsonNode, String)}.
   * <ul>
   *   <li>Given {@link BigIntegerNode#BigIntegerNode(BigInteger)} with v is valueOf zero.</li>
   * </ul>
   * <p>
   * Method under test: {@link DefaultMailService#sendTestMail(JsonNode, String)}
   */
  @Test
  @DisplayName("Test sendTestMail(JsonNode, String); given BigIntegerNode(BigInteger) with v is valueOf zero")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void DefaultMailService.sendTestMail(JsonNode, String)"})
  void testSendTestMail_givenBigIntegerNodeWithVIsValueOfZero()
      throws TemplateException, IOException, NoSuchMessageException, ThingsboardException {
    // Arrange
    when(messageSource.getMessage(Mockito.<String>any(), Mockito.<Object[]>any(), Mockito.<Locale>any()))
        .thenReturn("Not all who wander are lost");
    Template template = mock(Template.class);
    doThrow(new IncorrectParameterException("An error occurred")).when(template)
        .process(Mockito.<Object>any(), Mockito.<Writer>any());
    when(configuration.getTemplate(Mockito.<String>any())).thenReturn(template);
    ArrayNode jsonConfig = mock(ArrayNode.class);
    when(jsonConfig.has(Mockito.<String>any())).thenReturn(true);
    when(jsonConfig.get(Mockito.<String>any())).thenReturn(new BigIntegerNode(BigInteger.valueOf(0L)));

    // Act and Assert
    assertThrows(ThingsboardException.class, () -> defaultMailService.sendTestMail(jsonConfig, "jane.doe@example.org"));
    verify(jsonConfig, atLeast(1)).has(Mockito.<String>any());
    verify(jsonConfig, atLeast(1)).get(Mockito.<String>any());
    verify(configuration).getTemplate(eq("test.ftl"));
    verify(template).process(isA(Object.class), isA(Writer.class));
    verify(messageSource).getMessage(eq("test.message.subject"), isNull(), isA(Locale.class));
  }

  /**
   * Test {@link DefaultMailService#sendTestMail(JsonNode, String)}.
   * <ul>
   *   <li>Given {@code false}.</li>
   *   <li>When {@link ArrayNode} {@link JsonNode#has(String)} return {@code false}.</li>
   *   <li>Then calls {@link Template#process(Object, Writer)}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DefaultMailService#sendTestMail(JsonNode, String)}
   */
  @Test
  @DisplayName("Test sendTestMail(JsonNode, String); given 'false'; when ArrayNode has(String) return 'false'; then calls process(Object, Writer)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void DefaultMailService.sendTestMail(JsonNode, String)"})
  void testSendTestMail_givenFalse_whenArrayNodeHasReturnFalse_thenCallsProcess()
      throws TemplateException, IOException, NoSuchMessageException, ThingsboardException {
    // Arrange
    when(messageSource.getMessage(Mockito.<String>any(), Mockito.<Object[]>any(), Mockito.<Locale>any()))
        .thenReturn("Not all who wander are lost");
    Template template = mock(Template.class);
    doThrow(new IncorrectParameterException("An error occurred")).when(template)
        .process(Mockito.<Object>any(), Mockito.<Writer>any());
    when(configuration.getTemplate(Mockito.<String>any())).thenReturn(template);
    ArrayNode jsonConfig = mock(ArrayNode.class);
    when(jsonConfig.has(Mockito.<String>any())).thenReturn(false);
    when(jsonConfig.get(Mockito.<String>any())).thenReturn(new BigIntegerNode(BigInteger.valueOf(1L)));

    // Act and Assert
    assertThrows(ThingsboardException.class, () -> defaultMailService.sendTestMail(jsonConfig, "jane.doe@example.org"));
    verify(jsonConfig, atLeast(1)).has(Mockito.<String>any());
    verify(jsonConfig, atLeast(1)).get(Mockito.<String>any());
    verify(configuration).getTemplate(eq("test.ftl"));
    verify(template).process(isA(Object.class), isA(Writer.class));
    verify(messageSource).getMessage(eq("test.message.subject"), isNull(), isA(Locale.class));
  }

  /**
   * Test {@link DefaultMailService#sendTestMail(JsonNode, String)}.
   * <ul>
   *   <li>Given {@link StringReader#StringReader(String)} with {@code foo}.</li>
   *   <li>Then calls {@link MessageSource#getMessage(String, Object[], Locale)}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DefaultMailService#sendTestMail(JsonNode, String)}
   */
  @Test
  @DisplayName("Test sendTestMail(JsonNode, String); given StringReader(String) with 'foo'; then calls getMessage(String, Object[], Locale)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void DefaultMailService.sendTestMail(JsonNode, String)"})
  void testSendTestMail_givenStringReaderWithFoo_thenCallsGetMessage()
      throws IOException, NoSuchMessageException, ThingsboardException {
    // Arrange
    when(messageSource.getMessage(Mockito.<String>any(), Mockito.<Object[]>any(), Mockito.<Locale>any()))
        .thenReturn("Not all who wander are lost");
    when(configuration.getTemplate(Mockito.<String>any())).thenReturn(new Template("Name", new StringReader("foo")));
    ArrayNode jsonConfig = mock(ArrayNode.class);
    when(jsonConfig.has(Mockito.<String>any())).thenReturn(true);
    when(jsonConfig.get(Mockito.<String>any())).thenReturn(new BigIntegerNode(BigInteger.valueOf(1L)));

    // Act and Assert
    assertThrows(ThingsboardException.class, () -> defaultMailService.sendTestMail(jsonConfig, "jane.doe@example.org"));
    verify(jsonConfig, atLeast(1)).has(Mockito.<String>any());
    verify(jsonConfig, atLeast(1)).get(Mockito.<String>any());
    verify(configuration).getTemplate(eq("test.ftl"));
    verify(messageSource).getMessage(eq("test.message.subject"), isNull(), isA(Locale.class));
  }

  /**
   * Test {@link DefaultMailService#sendTestMail(JsonNode, String)}.
   * <ul>
   *   <li>Given {@link Template} {@link Template#process(Object, Writer)} does nothing.</li>
   *   <li>Then calls {@link Template#process(Object, Writer)}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DefaultMailService#sendTestMail(JsonNode, String)}
   */
  @Test
  @DisplayName("Test sendTestMail(JsonNode, String); given Template process(Object, Writer) does nothing; then calls process(Object, Writer)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void DefaultMailService.sendTestMail(JsonNode, String)"})
  void testSendTestMail_givenTemplateProcessDoesNothing_thenCallsProcess()
      throws TemplateException, IOException, NoSuchMessageException, ThingsboardException {
    // Arrange
    when(messageSource.getMessage(Mockito.<String>any(), Mockito.<Object[]>any(), Mockito.<Locale>any()))
        .thenReturn("Not all who wander are lost");
    Template template = mock(Template.class);
    doNothing().when(template).process(Mockito.<Object>any(), Mockito.<Writer>any());
    when(configuration.getTemplate(Mockito.<String>any())).thenReturn(template);
    ArrayNode jsonConfig = mock(ArrayNode.class);
    when(jsonConfig.has(Mockito.<String>any())).thenReturn(true);
    when(jsonConfig.get(Mockito.<String>any())).thenReturn(new BigIntegerNode(BigInteger.valueOf(1L)));

    // Act and Assert
    assertThrows(ThingsboardException.class, () -> defaultMailService.sendTestMail(jsonConfig, "jane.doe@example.org"));
    verify(jsonConfig, atLeast(1)).has(Mockito.<String>any());
    verify(jsonConfig, atLeast(1)).get(Mockito.<String>any());
    verify(configuration).getTemplate(eq("test.ftl"));
    verify(template).process(isA(Object.class), isA(Writer.class));
    verify(messageSource).getMessage(eq("test.message.subject"), isNull(), isA(Locale.class));
  }

  /**
   * Test {@link DefaultMailService#sendActivationEmail(String, long, String)}.
   * <p>
   * Method under test: {@link DefaultMailService#sendActivationEmail(String, long, String)}
   */
  @Test
  @DisplayName("Test sendActivationEmail(String, long, String)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void DefaultMailService.sendActivationEmail(String, long, String)"})
  void testSendActivationEmail() throws IOException, NoSuchMessageException, ThingsboardException {
    // Arrange
    when(messageSource.getMessage(Mockito.<String>any(), Mockito.<Object[]>any(), Mockito.<Locale>any()))
        .thenReturn("Not all who wander are lost");
    when(configuration.getTemplate(Mockito.<String>any()))
        .thenThrow(new IncorrectParameterException("An error occurred"));

    // Act and Assert
    assertThrows(ThingsboardException.class,
        () -> defaultMailService.sendActivationEmail("Activation Link", 1L, "jane.doe@example.org"));
    verify(configuration).getTemplate(eq("activation.ftl"));
    verify(messageSource).getMessage(eq("activation.subject"), isNull(), isA(Locale.class));
  }

  /**
   * Test {@link DefaultMailService#sendActivationEmail(String, long, String)}.
   * <ul>
   *   <li>Given {@link StringReader#StringReader(String)} with {@code foo}.</li>
   *   <li>Then calls {@link Configuration#getTemplate(String)}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DefaultMailService#sendActivationEmail(String, long, String)}
   */
  @Test
  @DisplayName("Test sendActivationEmail(String, long, String); given StringReader(String) with 'foo'; then calls getTemplate(String)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void DefaultMailService.sendActivationEmail(String, long, String)"})
  void testSendActivationEmail_givenStringReaderWithFoo_thenCallsGetTemplate()
      throws IOException, NoSuchMessageException, ThingsboardException {
    // Arrange
    when(messageSource.getMessage(Mockito.<String>any(), Mockito.<Object[]>any(), Mockito.<Locale>any()))
        .thenReturn("Not all who wander are lost");
    when(configuration.getTemplate(Mockito.<String>any())).thenReturn(new Template("Name", new StringReader("foo")));

    // Act and Assert
    assertThrows(ThingsboardException.class,
        () -> defaultMailService.sendActivationEmail("Activation Link", 1L, "jane.doe@example.org"));
    verify(configuration).getTemplate(eq("activation.ftl"));
    verify(messageSource).getMessage(eq("activation.subject"), isNull(), isA(Locale.class));
  }

  /**
   * Test {@link DefaultMailService#sendActivationEmail(String, long, String)}.
   * <ul>
   *   <li>Given {@link Template} {@link Template#process(Object, Writer)} does nothing.</li>
   *   <li>Then calls {@link Template#process(Object, Writer)}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DefaultMailService#sendActivationEmail(String, long, String)}
   */
  @Test
  @DisplayName("Test sendActivationEmail(String, long, String); given Template process(Object, Writer) does nothing; then calls process(Object, Writer)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void DefaultMailService.sendActivationEmail(String, long, String)"})
  void testSendActivationEmail_givenTemplateProcessDoesNothing_thenCallsProcess()
      throws TemplateException, IOException, NoSuchMessageException, ThingsboardException {
    // Arrange
    when(messageSource.getMessage(Mockito.<String>any(), Mockito.<Object[]>any(), Mockito.<Locale>any()))
        .thenReturn("Not all who wander are lost");
    Template template = mock(Template.class);
    doNothing().when(template).process(Mockito.<Object>any(), Mockito.<Writer>any());
    when(configuration.getTemplate(Mockito.<String>any())).thenReturn(template);

    // Act and Assert
    assertThrows(ThingsboardException.class,
        () -> defaultMailService.sendActivationEmail("Activation Link", 1L, "jane.doe@example.org"));
    verify(configuration).getTemplate(eq("activation.ftl"));
    verify(template).process(isA(Object.class), isA(Writer.class));
    verify(messageSource).getMessage(eq("activation.subject"), isNull(), isA(Locale.class));
  }

  /**
   * Test {@link DefaultMailService#sendAccountActivatedEmail(String, String)}.
   * <p>
   * Method under test: {@link DefaultMailService#sendAccountActivatedEmail(String, String)}
   */
  @Test
  @DisplayName("Test sendAccountActivatedEmail(String, String)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void DefaultMailService.sendAccountActivatedEmail(String, String)"})
  void testSendAccountActivatedEmail() throws IOException, NoSuchMessageException, ThingsboardException {
    // Arrange
    when(messageSource.getMessage(Mockito.<String>any(), Mockito.<Object[]>any(), Mockito.<Locale>any()))
        .thenReturn("Not all who wander are lost");
    when(configuration.getTemplate(Mockito.<String>any()))
        .thenThrow(new IncorrectParameterException("An error occurred"));

    // Act and Assert
    assertThrows(ThingsboardException.class,
        () -> defaultMailService.sendAccountActivatedEmail("Login Link", "jane.doe@example.org"));
    verify(configuration).getTemplate(eq("account.activated.ftl"));
    verify(messageSource).getMessage(eq("account.activated.subject"), isNull(), isA(Locale.class));
  }

  /**
   * Test {@link DefaultMailService#sendAccountActivatedEmail(String, String)}.
   * <ul>
   *   <li>Given {@link StringReader#StringReader(String)} with {@code foo}.</li>
   *   <li>Then calls {@link Configuration#getTemplate(String)}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DefaultMailService#sendAccountActivatedEmail(String, String)}
   */
  @Test
  @DisplayName("Test sendAccountActivatedEmail(String, String); given StringReader(String) with 'foo'; then calls getTemplate(String)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void DefaultMailService.sendAccountActivatedEmail(String, String)"})
  void testSendAccountActivatedEmail_givenStringReaderWithFoo_thenCallsGetTemplate()
      throws IOException, NoSuchMessageException, ThingsboardException {
    // Arrange
    when(messageSource.getMessage(Mockito.<String>any(), Mockito.<Object[]>any(), Mockito.<Locale>any()))
        .thenReturn("Not all who wander are lost");
    when(configuration.getTemplate(Mockito.<String>any())).thenReturn(new Template("Name", new StringReader("foo")));

    // Act and Assert
    assertThrows(ThingsboardException.class,
        () -> defaultMailService.sendAccountActivatedEmail("Login Link", "jane.doe@example.org"));
    verify(configuration).getTemplate(eq("account.activated.ftl"));
    verify(messageSource).getMessage(eq("account.activated.subject"), isNull(), isA(Locale.class));
  }

  /**
   * Test {@link DefaultMailService#sendAccountActivatedEmail(String, String)}.
   * <ul>
   *   <li>Given {@link Template} {@link Template#process(Object, Writer)} does nothing.</li>
   *   <li>Then calls {@link Template#process(Object, Writer)}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DefaultMailService#sendAccountActivatedEmail(String, String)}
   */
  @Test
  @DisplayName("Test sendAccountActivatedEmail(String, String); given Template process(Object, Writer) does nothing; then calls process(Object, Writer)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void DefaultMailService.sendAccountActivatedEmail(String, String)"})
  void testSendAccountActivatedEmail_givenTemplateProcessDoesNothing_thenCallsProcess()
      throws TemplateException, IOException, NoSuchMessageException, ThingsboardException {
    // Arrange
    when(messageSource.getMessage(Mockito.<String>any(), Mockito.<Object[]>any(), Mockito.<Locale>any()))
        .thenReturn("Not all who wander are lost");
    Template template = mock(Template.class);
    doNothing().when(template).process(Mockito.<Object>any(), Mockito.<Writer>any());
    when(configuration.getTemplate(Mockito.<String>any())).thenReturn(template);

    // Act and Assert
    assertThrows(ThingsboardException.class,
        () -> defaultMailService.sendAccountActivatedEmail("Login Link", "jane.doe@example.org"));
    verify(configuration).getTemplate(eq("account.activated.ftl"));
    verify(template).process(isA(Object.class), isA(Writer.class));
    verify(messageSource).getMessage(eq("account.activated.subject"), isNull(), isA(Locale.class));
  }

  /**
   * Test {@link DefaultMailService#sendResetPasswordEmail(String, long, String)}.
   * <p>
   * Method under test: {@link DefaultMailService#sendResetPasswordEmail(String, long, String)}
   */
  @Test
  @DisplayName("Test sendResetPasswordEmail(String, long, String)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void DefaultMailService.sendResetPasswordEmail(String, long, String)"})
  void testSendResetPasswordEmail() throws IOException, NoSuchMessageException, ThingsboardException {
    // Arrange
    when(messageSource.getMessage(Mockito.<String>any(), Mockito.<Object[]>any(), Mockito.<Locale>any()))
        .thenReturn("Not all who wander are lost");
    when(configuration.getTemplate(Mockito.<String>any()))
        .thenThrow(new IncorrectParameterException("An error occurred"));

    // Act and Assert
    assertThrows(ThingsboardException.class,
        () -> defaultMailService.sendResetPasswordEmail("Password Reset Link", 1L, "jane.doe@example.org"));
    verify(configuration).getTemplate(eq("reset.password.ftl"));
    verify(messageSource).getMessage(eq("reset.password.subject"), isNull(), isA(Locale.class));
  }

  /**
   * Test {@link DefaultMailService#sendResetPasswordEmail(String, long, String)}.
   * <ul>
   *   <li>Given {@link StringReader#StringReader(String)} with {@code foo}.</li>
   *   <li>Then calls {@link Configuration#getTemplate(String)}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DefaultMailService#sendResetPasswordEmail(String, long, String)}
   */
  @Test
  @DisplayName("Test sendResetPasswordEmail(String, long, String); given StringReader(String) with 'foo'; then calls getTemplate(String)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void DefaultMailService.sendResetPasswordEmail(String, long, String)"})
  void testSendResetPasswordEmail_givenStringReaderWithFoo_thenCallsGetTemplate()
      throws IOException, NoSuchMessageException, ThingsboardException {
    // Arrange
    when(messageSource.getMessage(Mockito.<String>any(), Mockito.<Object[]>any(), Mockito.<Locale>any()))
        .thenReturn("Not all who wander are lost");
    when(configuration.getTemplate(Mockito.<String>any())).thenReturn(new Template("Name", new StringReader("foo")));

    // Act and Assert
    assertThrows(ThingsboardException.class,
        () -> defaultMailService.sendResetPasswordEmail("Password Reset Link", 1L, "jane.doe@example.org"));
    verify(configuration).getTemplate(eq("reset.password.ftl"));
    verify(messageSource).getMessage(eq("reset.password.subject"), isNull(), isA(Locale.class));
  }

  /**
   * Test {@link DefaultMailService#sendResetPasswordEmail(String, long, String)}.
   * <ul>
   *   <li>Given {@link Template} {@link Template#process(Object, Writer)} does nothing.</li>
   *   <li>Then calls {@link Template#process(Object, Writer)}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DefaultMailService#sendResetPasswordEmail(String, long, String)}
   */
  @Test
  @DisplayName("Test sendResetPasswordEmail(String, long, String); given Template process(Object, Writer) does nothing; then calls process(Object, Writer)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void DefaultMailService.sendResetPasswordEmail(String, long, String)"})
  void testSendResetPasswordEmail_givenTemplateProcessDoesNothing_thenCallsProcess()
      throws TemplateException, IOException, NoSuchMessageException, ThingsboardException {
    // Arrange
    when(messageSource.getMessage(Mockito.<String>any(), Mockito.<Object[]>any(), Mockito.<Locale>any()))
        .thenReturn("Not all who wander are lost");
    Template template = mock(Template.class);
    doNothing().when(template).process(Mockito.<Object>any(), Mockito.<Writer>any());
    when(configuration.getTemplate(Mockito.<String>any())).thenReturn(template);

    // Act and Assert
    assertThrows(ThingsboardException.class,
        () -> defaultMailService.sendResetPasswordEmail("Password Reset Link", 1L, "jane.doe@example.org"));
    verify(configuration).getTemplate(eq("reset.password.ftl"));
    verify(template).process(isA(Object.class), isA(Writer.class));
    verify(messageSource).getMessage(eq("reset.password.subject"), isNull(), isA(Locale.class));
  }

  /**
   * Test {@link DefaultMailService#sendPasswordWasResetEmail(String, String)}.
   * <p>
   * Method under test: {@link DefaultMailService#sendPasswordWasResetEmail(String, String)}
   */
  @Test
  @DisplayName("Test sendPasswordWasResetEmail(String, String)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void DefaultMailService.sendPasswordWasResetEmail(String, String)"})
  void testSendPasswordWasResetEmail() throws IOException, NoSuchMessageException, ThingsboardException {
    // Arrange
    when(messageSource.getMessage(Mockito.<String>any(), Mockito.<Object[]>any(), Mockito.<Locale>any()))
        .thenReturn("Not all who wander are lost");
    when(configuration.getTemplate(Mockito.<String>any()))
        .thenThrow(new IncorrectParameterException("An error occurred"));

    // Act and Assert
    assertThrows(ThingsboardException.class,
        () -> defaultMailService.sendPasswordWasResetEmail("Login Link", "jane.doe@example.org"));
    verify(configuration).getTemplate(eq("password.was.reset.ftl"));
    verify(messageSource).getMessage(eq("password.was.reset.subject"), isNull(), isA(Locale.class));
  }

  /**
   * Test {@link DefaultMailService#sendPasswordWasResetEmail(String, String)}.
   * <ul>
   *   <li>Given {@link StringReader#StringReader(String)} with {@code foo}.</li>
   *   <li>Then calls {@link Configuration#getTemplate(String)}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DefaultMailService#sendPasswordWasResetEmail(String, String)}
   */
  @Test
  @DisplayName("Test sendPasswordWasResetEmail(String, String); given StringReader(String) with 'foo'; then calls getTemplate(String)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void DefaultMailService.sendPasswordWasResetEmail(String, String)"})
  void testSendPasswordWasResetEmail_givenStringReaderWithFoo_thenCallsGetTemplate()
      throws IOException, NoSuchMessageException, ThingsboardException {
    // Arrange
    when(messageSource.getMessage(Mockito.<String>any(), Mockito.<Object[]>any(), Mockito.<Locale>any()))
        .thenReturn("Not all who wander are lost");
    when(configuration.getTemplate(Mockito.<String>any())).thenReturn(new Template("Name", new StringReader("foo")));

    // Act and Assert
    assertThrows(ThingsboardException.class,
        () -> defaultMailService.sendPasswordWasResetEmail("Login Link", "jane.doe@example.org"));
    verify(configuration).getTemplate(eq("password.was.reset.ftl"));
    verify(messageSource).getMessage(eq("password.was.reset.subject"), isNull(), isA(Locale.class));
  }

  /**
   * Test {@link DefaultMailService#sendPasswordWasResetEmail(String, String)}.
   * <ul>
   *   <li>Given {@link Template} {@link Template#process(Object, Writer)} does nothing.</li>
   *   <li>Then calls {@link Template#process(Object, Writer)}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DefaultMailService#sendPasswordWasResetEmail(String, String)}
   */
  @Test
  @DisplayName("Test sendPasswordWasResetEmail(String, String); given Template process(Object, Writer) does nothing; then calls process(Object, Writer)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void DefaultMailService.sendPasswordWasResetEmail(String, String)"})
  void testSendPasswordWasResetEmail_givenTemplateProcessDoesNothing_thenCallsProcess()
      throws TemplateException, IOException, NoSuchMessageException, ThingsboardException {
    // Arrange
    when(messageSource.getMessage(Mockito.<String>any(), Mockito.<Object[]>any(), Mockito.<Locale>any()))
        .thenReturn("Not all who wander are lost");
    Template template = mock(Template.class);
    doNothing().when(template).process(Mockito.<Object>any(), Mockito.<Writer>any());
    when(configuration.getTemplate(Mockito.<String>any())).thenReturn(template);

    // Act and Assert
    assertThrows(ThingsboardException.class,
        () -> defaultMailService.sendPasswordWasResetEmail("Login Link", "jane.doe@example.org"));
    verify(configuration).getTemplate(eq("password.was.reset.ftl"));
    verify(template).process(isA(Object.class), isA(Writer.class));
    verify(messageSource).getMessage(eq("password.was.reset.subject"), isNull(), isA(Locale.class));
  }

  /**
   * Test {@link DefaultMailService#sendAccountLockoutEmail(String, String, Integer)}.
   * <p>
   * Method under test: {@link DefaultMailService#sendAccountLockoutEmail(String, String, Integer)}
   */
  @Test
  @DisplayName("Test sendAccountLockoutEmail(String, String, Integer)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void DefaultMailService.sendAccountLockoutEmail(String, String, Integer)"})
  void testSendAccountLockoutEmail() throws IOException, NoSuchMessageException, ThingsboardException {
    // Arrange
    when(messageSource.getMessage(Mockito.<String>any(), Mockito.<Object[]>any(), Mockito.<Locale>any()))
        .thenReturn("Not all who wander are lost");
    when(configuration.getTemplate(Mockito.<String>any()))
        .thenThrow(new IncorrectParameterException("An error occurred"));

    // Act and Assert
    assertThrows(ThingsboardException.class,
        () -> defaultMailService.sendAccountLockoutEmail("jane.doe@example.org", "jane.doe@example.org", 3));
    verify(configuration).getTemplate(eq("account.lockout.ftl"));
    verify(messageSource).getMessage(eq("account.lockout.subject"), isNull(), isA(Locale.class));
  }

  /**
   * Test {@link DefaultMailService#sendAccountLockoutEmail(String, String, Integer)}.
   * <ul>
   *   <li>Given {@link StringReader#StringReader(String)} with {@code foo}.</li>
   *   <li>Then calls {@link Configuration#getTemplate(String)}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DefaultMailService#sendAccountLockoutEmail(String, String, Integer)}
   */
  @Test
  @DisplayName("Test sendAccountLockoutEmail(String, String, Integer); given StringReader(String) with 'foo'; then calls getTemplate(String)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void DefaultMailService.sendAccountLockoutEmail(String, String, Integer)"})
  void testSendAccountLockoutEmail_givenStringReaderWithFoo_thenCallsGetTemplate()
      throws IOException, NoSuchMessageException, ThingsboardException {
    // Arrange
    when(messageSource.getMessage(Mockito.<String>any(), Mockito.<Object[]>any(), Mockito.<Locale>any()))
        .thenReturn("Not all who wander are lost");
    when(configuration.getTemplate(Mockito.<String>any())).thenReturn(new Template("Name", new StringReader("foo")));

    // Act and Assert
    assertThrows(ThingsboardException.class,
        () -> defaultMailService.sendAccountLockoutEmail("jane.doe@example.org", "jane.doe@example.org", 3));
    verify(configuration).getTemplate(eq("account.lockout.ftl"));
    verify(messageSource).getMessage(eq("account.lockout.subject"), isNull(), isA(Locale.class));
  }

  /**
   * Test {@link DefaultMailService#sendAccountLockoutEmail(String, String, Integer)}.
   * <ul>
   *   <li>Given {@link Template} {@link Template#process(Object, Writer)} does nothing.</li>
   *   <li>Then calls {@link Template#process(Object, Writer)}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DefaultMailService#sendAccountLockoutEmail(String, String, Integer)}
   */
  @Test
  @DisplayName("Test sendAccountLockoutEmail(String, String, Integer); given Template process(Object, Writer) does nothing; then calls process(Object, Writer)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void DefaultMailService.sendAccountLockoutEmail(String, String, Integer)"})
  void testSendAccountLockoutEmail_givenTemplateProcessDoesNothing_thenCallsProcess()
      throws TemplateException, IOException, NoSuchMessageException, ThingsboardException {
    // Arrange
    when(messageSource.getMessage(Mockito.<String>any(), Mockito.<Object[]>any(), Mockito.<Locale>any()))
        .thenReturn("Not all who wander are lost");
    Template template = mock(Template.class);
    doNothing().when(template).process(Mockito.<Object>any(), Mockito.<Writer>any());
    when(configuration.getTemplate(Mockito.<String>any())).thenReturn(template);

    // Act and Assert
    assertThrows(ThingsboardException.class,
        () -> defaultMailService.sendAccountLockoutEmail("jane.doe@example.org", "jane.doe@example.org", 3));
    verify(configuration).getTemplate(eq("account.lockout.ftl"));
    verify(template).process(isA(Object.class), isA(Writer.class));
    verify(messageSource).getMessage(eq("account.lockout.subject"), isNull(), isA(Locale.class));
  }

  /**
   * Test {@link DefaultMailService#sendTwoFaVerificationEmail(String, String, int)}.
   * <p>
   * Method under test: {@link DefaultMailService#sendTwoFaVerificationEmail(String, String, int)}
   */
  @Test
  @DisplayName("Test sendTwoFaVerificationEmail(String, String, int)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void DefaultMailService.sendTwoFaVerificationEmail(String, String, int)"})
  void testSendTwoFaVerificationEmail() throws IOException, NoSuchMessageException, ThingsboardException {
    // Arrange
    when(messageSource.getMessage(Mockito.<String>any(), Mockito.<Object[]>any(), Mockito.<Locale>any()))
        .thenReturn("Not all who wander are lost");
    when(configuration.getTemplate(Mockito.<String>any()))
        .thenThrow(new IncorrectParameterException("An error occurred"));

    // Act and Assert
    assertThrows(ThingsboardException.class,
        () -> defaultMailService.sendTwoFaVerificationEmail("jane.doe@example.org", "Verification Code", 1));
    verify(configuration).getTemplate(eq("2fa.verification.code.ftl"));
    verify(messageSource).getMessage(eq("2fa.verification.code.subject"), isNull(), isA(Locale.class));
  }

  /**
   * Test {@link DefaultMailService#sendTwoFaVerificationEmail(String, String, int)}.
   * <ul>
   *   <li>Given {@link StringReader#StringReader(String)} with {@code foo}.</li>
   *   <li>Then calls {@link Configuration#getTemplate(String)}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DefaultMailService#sendTwoFaVerificationEmail(String, String, int)}
   */
  @Test
  @DisplayName("Test sendTwoFaVerificationEmail(String, String, int); given StringReader(String) with 'foo'; then calls getTemplate(String)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void DefaultMailService.sendTwoFaVerificationEmail(String, String, int)"})
  void testSendTwoFaVerificationEmail_givenStringReaderWithFoo_thenCallsGetTemplate()
      throws IOException, NoSuchMessageException, ThingsboardException {
    // Arrange
    when(messageSource.getMessage(Mockito.<String>any(), Mockito.<Object[]>any(), Mockito.<Locale>any()))
        .thenReturn("Not all who wander are lost");
    when(configuration.getTemplate(Mockito.<String>any())).thenReturn(new Template("Name", new StringReader("foo")));

    // Act and Assert
    assertThrows(ThingsboardException.class,
        () -> defaultMailService.sendTwoFaVerificationEmail("jane.doe@example.org", "Verification Code", 1));
    verify(configuration).getTemplate(eq("2fa.verification.code.ftl"));
    verify(messageSource).getMessage(eq("2fa.verification.code.subject"), isNull(), isA(Locale.class));
  }

  /**
   * Test {@link DefaultMailService#sendTwoFaVerificationEmail(String, String, int)}.
   * <ul>
   *   <li>Given {@link Template} {@link Template#process(Object, Writer)} does nothing.</li>
   *   <li>Then calls {@link Template#process(Object, Writer)}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DefaultMailService#sendTwoFaVerificationEmail(String, String, int)}
   */
  @Test
  @DisplayName("Test sendTwoFaVerificationEmail(String, String, int); given Template process(Object, Writer) does nothing; then calls process(Object, Writer)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void DefaultMailService.sendTwoFaVerificationEmail(String, String, int)"})
  void testSendTwoFaVerificationEmail_givenTemplateProcessDoesNothing_thenCallsProcess()
      throws TemplateException, IOException, NoSuchMessageException, ThingsboardException {
    // Arrange
    when(messageSource.getMessage(Mockito.<String>any(), Mockito.<Object[]>any(), Mockito.<Locale>any()))
        .thenReturn("Not all who wander are lost");
    Template template = mock(Template.class);
    doNothing().when(template).process(Mockito.<Object>any(), Mockito.<Writer>any());
    when(configuration.getTemplate(Mockito.<String>any())).thenReturn(template);

    // Act and Assert
    assertThrows(ThingsboardException.class,
        () -> defaultMailService.sendTwoFaVerificationEmail("jane.doe@example.org", "Verification Code", 1));
    verify(configuration).getTemplate(eq("2fa.verification.code.ftl"));
    verify(template).process(isA(Object.class), isA(Writer.class));
    verify(messageSource).getMessage(eq("2fa.verification.code.subject"), isNull(), isA(Locale.class));
  }

  /**
   * Test {@link DefaultMailService#sendApiFeatureStateEmail(ApiFeature, ApiUsageStateValue, String, ApiUsageRecordState)}.
   * <p>
   * Method under test: {@link DefaultMailService#sendApiFeatureStateEmail(ApiFeature, ApiUsageStateValue, String, ApiUsageRecordState)}
   */
  @Test
  @DisplayName("Test sendApiFeatureStateEmail(ApiFeature, ApiUsageStateValue, String, ApiUsageRecordState)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "void DefaultMailService.sendApiFeatureStateEmail(ApiFeature, ApiUsageStateValue, String, ApiUsageRecordState)"})
  void testSendApiFeatureStateEmail() throws IOException, NoSuchMessageException, ThingsboardException {
    // Arrange
    when(messageSource.getMessage(Mockito.<String>any(), Mockito.<Object[]>any(), Mockito.<Locale>any()))
        .thenReturn("Not all who wander are lost");
    when(configuration.getTemplate(Mockito.<String>any()))
        .thenThrow(new IncorrectParameterException("An error occurred"));

    // Act and Assert
    assertThrows(ThingsboardException.class,
        () -> defaultMailService.sendApiFeatureStateEmail(ApiFeature.TRANSPORT, ApiUsageStateValue.ENABLED,
            "jane.doe@example.org",
            new ApiUsageRecordState(ApiFeature.TRANSPORT, ApiUsageRecordKey.TRANSPORT_MSG_COUNT, 1L, 42L)));
    verify(configuration).getTemplate(eq("state.enabled.ftl"));
    verify(messageSource).getMessage(eq("api.usage.state"), isNull(), isA(Locale.class));
  }

  /**
   * Test {@link DefaultMailService#sendApiFeatureStateEmail(ApiFeature, ApiUsageStateValue, String, ApiUsageRecordState)}.
   * <p>
   * Method under test: {@link DefaultMailService#sendApiFeatureStateEmail(ApiFeature, ApiUsageStateValue, String, ApiUsageRecordState)}
   */
  @Test
  @DisplayName("Test sendApiFeatureStateEmail(ApiFeature, ApiUsageStateValue, String, ApiUsageRecordState)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "void DefaultMailService.sendApiFeatureStateEmail(ApiFeature, ApiUsageStateValue, String, ApiUsageRecordState)"})
  void testSendApiFeatureStateEmail2()
      throws TemplateException, IOException, NoSuchMessageException, ThingsboardException {
    // Arrange
    when(messageSource.getMessage(Mockito.<String>any(), Mockito.<Object[]>any(), Mockito.<Locale>any()))
        .thenReturn("Not all who wander are lost");
    Template template = mock(Template.class);
    doThrow(new IncorrectParameterException("An error occurred")).when(template)
        .process(Mockito.<Object>any(), Mockito.<Writer>any());
    when(configuration.getTemplate(Mockito.<String>any())).thenReturn(template);

    // Act and Assert
    assertThrows(ThingsboardException.class,
        () -> defaultMailService.sendApiFeatureStateEmail(ApiFeature.TRANSPORT, ApiUsageStateValue.WARNING,
            "jane.doe@example.org",
            new ApiUsageRecordState(ApiFeature.TRANSPORT, ApiUsageRecordKey.TRANSPORT_DP_COUNT, 1L, 42L)));
    verify(configuration).getTemplate(eq("state.warning.ftl"));
    verify(template).process(isA(Object.class), isA(Writer.class));
    verify(messageSource).getMessage(eq("api.usage.state"), isNull(), isA(Locale.class));
  }

  /**
   * Test {@link DefaultMailService#sendApiFeatureStateEmail(ApiFeature, ApiUsageStateValue, String, ApiUsageRecordState)}.
   * <p>
   * Method under test: {@link DefaultMailService#sendApiFeatureStateEmail(ApiFeature, ApiUsageStateValue, String, ApiUsageRecordState)}
   */
  @Test
  @DisplayName("Test sendApiFeatureStateEmail(ApiFeature, ApiUsageStateValue, String, ApiUsageRecordState)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "void DefaultMailService.sendApiFeatureStateEmail(ApiFeature, ApiUsageStateValue, String, ApiUsageRecordState)"})
  void testSendApiFeatureStateEmail3()
      throws TemplateException, IOException, NoSuchMessageException, ThingsboardException {
    // Arrange
    when(messageSource.getMessage(Mockito.<String>any(), Mockito.<Object[]>any(), Mockito.<Locale>any()))
        .thenReturn("Not all who wander are lost");
    Template template = mock(Template.class);
    doThrow(new IncorrectParameterException("An error occurred")).when(template)
        .process(Mockito.<Object>any(), Mockito.<Writer>any());
    when(configuration.getTemplate(Mockito.<String>any())).thenReturn(template);

    // Act and Assert
    assertThrows(ThingsboardException.class,
        () -> defaultMailService.sendApiFeatureStateEmail(ApiFeature.TRANSPORT, ApiUsageStateValue.WARNING,
            "jane.doe@example.org",
            new ApiUsageRecordState(ApiFeature.TRANSPORT, ApiUsageRecordKey.RE_EXEC_COUNT, 1L, 42L)));
    verify(configuration).getTemplate(eq("state.warning.ftl"));
    verify(template).process(isA(Object.class), isA(Writer.class));
    verify(messageSource).getMessage(eq("api.usage.state"), isNull(), isA(Locale.class));
  }

  /**
   * Test {@link DefaultMailService#sendApiFeatureStateEmail(ApiFeature, ApiUsageStateValue, String, ApiUsageRecordState)}.
   * <ul>
   *   <li>Given {@code CREATED_ALARMS_COUNT}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DefaultMailService#sendApiFeatureStateEmail(ApiFeature, ApiUsageStateValue, String, ApiUsageRecordState)}
   */
  @Test
  @DisplayName("Test sendApiFeatureStateEmail(ApiFeature, ApiUsageStateValue, String, ApiUsageRecordState); given 'CREATED_ALARMS_COUNT'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "void DefaultMailService.sendApiFeatureStateEmail(ApiFeature, ApiUsageStateValue, String, ApiUsageRecordState)"})
  void testSendApiFeatureStateEmail_givenCreatedAlarmsCount() throws NoSuchMessageException, ThingsboardException {
    // Arrange
    when(messageSource.getMessage(Mockito.<String>any(), Mockito.<Object[]>any(), Mockito.<Locale>any()))
        .thenReturn("Not all who wander are lost");
    ApiUsageRecordState recordState = mock(ApiUsageRecordState.class);
    when(recordState.getThresholdAsString()).thenReturn("Threshold As String");
    when(recordState.getValueAsString()).thenReturn("42");
    when(recordState.getKey()).thenReturn(ApiUsageRecordKey.CREATED_ALARMS_COUNT);

    // Act and Assert
    assertThrows(RuntimeException.class, () -> defaultMailService.sendApiFeatureStateEmail(ApiFeature.TRANSPORT,
        ApiUsageStateValue.WARNING, "jane.doe@example.org", recordState));
    verify(messageSource).getMessage(eq("api.usage.state"), isNull(), isA(Locale.class));
    verify(recordState).getKey();
    verify(recordState).getThresholdAsString();
    verify(recordState).getValueAsString();
  }

  /**
   * Test {@link DefaultMailService#sendApiFeatureStateEmail(ApiFeature, ApiUsageStateValue, String, ApiUsageRecordState)}.
   * <ul>
   *   <li>Given {@code EMAIL_EXEC_COUNT}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DefaultMailService#sendApiFeatureStateEmail(ApiFeature, ApiUsageStateValue, String, ApiUsageRecordState)}
   */
  @Test
  @DisplayName("Test sendApiFeatureStateEmail(ApiFeature, ApiUsageStateValue, String, ApiUsageRecordState); given 'EMAIL_EXEC_COUNT'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "void DefaultMailService.sendApiFeatureStateEmail(ApiFeature, ApiUsageStateValue, String, ApiUsageRecordState)"})
  void testSendApiFeatureStateEmail_givenEmailExecCount()
      throws TemplateException, IOException, NoSuchMessageException, ThingsboardException {
    // Arrange
    when(messageSource.getMessage(Mockito.<String>any(), Mockito.<Object[]>any(), Mockito.<Locale>any()))
        .thenReturn("Not all who wander are lost");
    Template template = mock(Template.class);
    doThrow(new IncorrectParameterException("An error occurred")).when(template)
        .process(Mockito.<Object>any(), Mockito.<Writer>any());
    when(configuration.getTemplate(Mockito.<String>any())).thenReturn(template);
    ApiUsageRecordState recordState = mock(ApiUsageRecordState.class);
    when(recordState.getThresholdAsString()).thenReturn("Threshold As String");
    when(recordState.getValueAsString()).thenReturn("42");
    when(recordState.getKey()).thenReturn(ApiUsageRecordKey.EMAIL_EXEC_COUNT);

    // Act and Assert
    assertThrows(ThingsboardException.class, () -> defaultMailService.sendApiFeatureStateEmail(ApiFeature.TRANSPORT,
        ApiUsageStateValue.WARNING, "jane.doe@example.org", recordState));
    verify(configuration).getTemplate(eq("state.warning.ftl"));
    verify(template).process(isA(Object.class), isA(Writer.class));
    verify(messageSource).getMessage(eq("api.usage.state"), isNull(), isA(Locale.class));
    verify(recordState).getKey();
    verify(recordState).getThresholdAsString();
    verify(recordState).getValueAsString();
  }

  /**
   * Test {@link DefaultMailService#sendApiFeatureStateEmail(ApiFeature, ApiUsageStateValue, String, ApiUsageRecordState)}.
   * <ul>
   *   <li>Given {@code JS_EXEC_COUNT}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DefaultMailService#sendApiFeatureStateEmail(ApiFeature, ApiUsageStateValue, String, ApiUsageRecordState)}
   */
  @Test
  @DisplayName("Test sendApiFeatureStateEmail(ApiFeature, ApiUsageStateValue, String, ApiUsageRecordState); given 'JS_EXEC_COUNT'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "void DefaultMailService.sendApiFeatureStateEmail(ApiFeature, ApiUsageStateValue, String, ApiUsageRecordState)"})
  void testSendApiFeatureStateEmail_givenJsExecCount()
      throws TemplateException, IOException, NoSuchMessageException, ThingsboardException {
    // Arrange
    when(messageSource.getMessage(Mockito.<String>any(), Mockito.<Object[]>any(), Mockito.<Locale>any()))
        .thenReturn("Not all who wander are lost");
    Template template = mock(Template.class);
    doThrow(new IncorrectParameterException("An error occurred")).when(template)
        .process(Mockito.<Object>any(), Mockito.<Writer>any());
    when(configuration.getTemplate(Mockito.<String>any())).thenReturn(template);
    ApiUsageRecordState recordState = mock(ApiUsageRecordState.class);
    when(recordState.getThresholdAsString()).thenReturn("Threshold As String");
    when(recordState.getValueAsString()).thenReturn("42");
    when(recordState.getKey()).thenReturn(ApiUsageRecordKey.JS_EXEC_COUNT);

    // Act and Assert
    assertThrows(ThingsboardException.class, () -> defaultMailService.sendApiFeatureStateEmail(ApiFeature.TRANSPORT,
        ApiUsageStateValue.WARNING, "jane.doe@example.org", recordState));
    verify(configuration).getTemplate(eq("state.warning.ftl"));
    verify(template).process(isA(Object.class), isA(Writer.class));
    verify(messageSource).getMessage(eq("api.usage.state"), isNull(), isA(Locale.class));
    verify(recordState).getKey();
    verify(recordState).getThresholdAsString();
    verify(recordState).getValueAsString();
  }

  /**
   * Test {@link DefaultMailService#sendApiFeatureStateEmail(ApiFeature, ApiUsageStateValue, String, ApiUsageRecordState)}.
   * <ul>
   *   <li>Given {@code SMS_EXEC_COUNT}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DefaultMailService#sendApiFeatureStateEmail(ApiFeature, ApiUsageStateValue, String, ApiUsageRecordState)}
   */
  @Test
  @DisplayName("Test sendApiFeatureStateEmail(ApiFeature, ApiUsageStateValue, String, ApiUsageRecordState); given 'SMS_EXEC_COUNT'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "void DefaultMailService.sendApiFeatureStateEmail(ApiFeature, ApiUsageStateValue, String, ApiUsageRecordState)"})
  void testSendApiFeatureStateEmail_givenSmsExecCount()
      throws TemplateException, IOException, NoSuchMessageException, ThingsboardException {
    // Arrange
    when(messageSource.getMessage(Mockito.<String>any(), Mockito.<Object[]>any(), Mockito.<Locale>any()))
        .thenReturn("Not all who wander are lost");
    Template template = mock(Template.class);
    doThrow(new IncorrectParameterException("An error occurred")).when(template)
        .process(Mockito.<Object>any(), Mockito.<Writer>any());
    when(configuration.getTemplate(Mockito.<String>any())).thenReturn(template);
    ApiUsageRecordState recordState = mock(ApiUsageRecordState.class);
    when(recordState.getThresholdAsString()).thenReturn("Threshold As String");
    when(recordState.getValueAsString()).thenReturn("42");
    when(recordState.getKey()).thenReturn(ApiUsageRecordKey.SMS_EXEC_COUNT);

    // Act and Assert
    assertThrows(ThingsboardException.class, () -> defaultMailService.sendApiFeatureStateEmail(ApiFeature.TRANSPORT,
        ApiUsageStateValue.WARNING, "jane.doe@example.org", recordState));
    verify(configuration).getTemplate(eq("state.warning.ftl"));
    verify(template).process(isA(Object.class), isA(Writer.class));
    verify(messageSource).getMessage(eq("api.usage.state"), isNull(), isA(Locale.class));
    verify(recordState).getKey();
    verify(recordState).getThresholdAsString();
    verify(recordState).getValueAsString();
  }

  /**
   * Test {@link DefaultMailService#sendApiFeatureStateEmail(ApiFeature, ApiUsageStateValue, String, ApiUsageRecordState)}.
   * <ul>
   *   <li>Given {@link StringReader#StringReader(String)} with {@code foo}.</li>
   *   <li>When {@code ENABLED}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DefaultMailService#sendApiFeatureStateEmail(ApiFeature, ApiUsageStateValue, String, ApiUsageRecordState)}
   */
  @Test
  @DisplayName("Test sendApiFeatureStateEmail(ApiFeature, ApiUsageStateValue, String, ApiUsageRecordState); given StringReader(String) with 'foo'; when 'ENABLED'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "void DefaultMailService.sendApiFeatureStateEmail(ApiFeature, ApiUsageStateValue, String, ApiUsageRecordState)"})
  void testSendApiFeatureStateEmail_givenStringReaderWithFoo_whenEnabled()
      throws IOException, NoSuchMessageException, ThingsboardException {
    // Arrange
    when(messageSource.getMessage(Mockito.<String>any(), Mockito.<Object[]>any(), Mockito.<Locale>any()))
        .thenReturn("Not all who wander are lost");
    when(configuration.getTemplate(Mockito.<String>any())).thenReturn(new Template("Name", new StringReader("foo")));

    // Act and Assert
    assertThrows(ThingsboardException.class,
        () -> defaultMailService.sendApiFeatureStateEmail(ApiFeature.TRANSPORT, ApiUsageStateValue.ENABLED,
            "jane.doe@example.org",
            new ApiUsageRecordState(ApiFeature.TRANSPORT, ApiUsageRecordKey.TRANSPORT_MSG_COUNT, 1L, 42L)));
    verify(configuration).getTemplate(eq("state.enabled.ftl"));
    verify(messageSource).getMessage(eq("api.usage.state"), isNull(), isA(Locale.class));
  }

  /**
   * Test {@link DefaultMailService#sendApiFeatureStateEmail(ApiFeature, ApiUsageStateValue, String, ApiUsageRecordState)}.
   * <ul>
   *   <li>Given {@code TBEL_EXEC_COUNT}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DefaultMailService#sendApiFeatureStateEmail(ApiFeature, ApiUsageStateValue, String, ApiUsageRecordState)}
   */
  @Test
  @DisplayName("Test sendApiFeatureStateEmail(ApiFeature, ApiUsageStateValue, String, ApiUsageRecordState); given 'TBEL_EXEC_COUNT'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "void DefaultMailService.sendApiFeatureStateEmail(ApiFeature, ApiUsageStateValue, String, ApiUsageRecordState)"})
  void testSendApiFeatureStateEmail_givenTbelExecCount()
      throws TemplateException, IOException, NoSuchMessageException, ThingsboardException {
    // Arrange
    when(messageSource.getMessage(Mockito.<String>any(), Mockito.<Object[]>any(), Mockito.<Locale>any()))
        .thenReturn("Not all who wander are lost");
    Template template = mock(Template.class);
    doThrow(new IncorrectParameterException("An error occurred")).when(template)
        .process(Mockito.<Object>any(), Mockito.<Writer>any());
    when(configuration.getTemplate(Mockito.<String>any())).thenReturn(template);
    ApiUsageRecordState recordState = mock(ApiUsageRecordState.class);
    when(recordState.getThresholdAsString()).thenReturn("Threshold As String");
    when(recordState.getValueAsString()).thenReturn("42");
    when(recordState.getKey()).thenReturn(ApiUsageRecordKey.TBEL_EXEC_COUNT);

    // Act and Assert
    assertThrows(ThingsboardException.class, () -> defaultMailService.sendApiFeatureStateEmail(ApiFeature.TRANSPORT,
        ApiUsageStateValue.WARNING, "jane.doe@example.org", recordState));
    verify(configuration).getTemplate(eq("state.warning.ftl"));
    verify(template).process(isA(Object.class), isA(Writer.class));
    verify(messageSource).getMessage(eq("api.usage.state"), isNull(), isA(Locale.class));
    verify(recordState).getKey();
    verify(recordState).getThresholdAsString();
    verify(recordState).getValueAsString();
  }

  /**
   * Test {@link DefaultMailService#sendApiFeatureStateEmail(ApiFeature, ApiUsageStateValue, String, ApiUsageRecordState)}.
   * <ul>
   *   <li>Given {@link Template} {@link Template#process(Object, Writer)} does nothing.</li>
   *   <li>When {@code ENABLED}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DefaultMailService#sendApiFeatureStateEmail(ApiFeature, ApiUsageStateValue, String, ApiUsageRecordState)}
   */
  @Test
  @DisplayName("Test sendApiFeatureStateEmail(ApiFeature, ApiUsageStateValue, String, ApiUsageRecordState); given Template process(Object, Writer) does nothing; when 'ENABLED'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "void DefaultMailService.sendApiFeatureStateEmail(ApiFeature, ApiUsageStateValue, String, ApiUsageRecordState)"})
  void testSendApiFeatureStateEmail_givenTemplateProcessDoesNothing_whenEnabled()
      throws TemplateException, IOException, NoSuchMessageException, ThingsboardException {
    // Arrange
    when(messageSource.getMessage(Mockito.<String>any(), Mockito.<Object[]>any(), Mockito.<Locale>any()))
        .thenReturn("Not all who wander are lost");
    Template template = mock(Template.class);
    doNothing().when(template).process(Mockito.<Object>any(), Mockito.<Writer>any());
    when(configuration.getTemplate(Mockito.<String>any())).thenReturn(template);

    // Act and Assert
    assertThrows(ThingsboardException.class,
        () -> defaultMailService.sendApiFeatureStateEmail(ApiFeature.TRANSPORT, ApiUsageStateValue.ENABLED,
            "jane.doe@example.org",
            new ApiUsageRecordState(ApiFeature.TRANSPORT, ApiUsageRecordKey.TRANSPORT_MSG_COUNT, 1L, 42L)));
    verify(configuration).getTemplate(eq("state.enabled.ftl"));
    verify(template).process(isA(Object.class), isA(Writer.class));
    verify(messageSource).getMessage(eq("api.usage.state"), isNull(), isA(Locale.class));
  }

  /**
   * Test {@link DefaultMailService#sendApiFeatureStateEmail(ApiFeature, ApiUsageStateValue, String, ApiUsageRecordState)}.
   * <ul>
   *   <li>Given {@code TRANSPORT_MSG_COUNT}.</li>
   *   <li>When {@code ALARM}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DefaultMailService#sendApiFeatureStateEmail(ApiFeature, ApiUsageStateValue, String, ApiUsageRecordState)}
   */
  @Test
  @DisplayName("Test sendApiFeatureStateEmail(ApiFeature, ApiUsageStateValue, String, ApiUsageRecordState); given 'TRANSPORT_MSG_COUNT'; when 'ALARM'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "void DefaultMailService.sendApiFeatureStateEmail(ApiFeature, ApiUsageStateValue, String, ApiUsageRecordState)"})
  void testSendApiFeatureStateEmail_givenTransportMsgCount_whenAlarm()
      throws TemplateException, IOException, NoSuchMessageException, ThingsboardException {
    // Arrange
    when(messageSource.getMessage(Mockito.<String>any(), Mockito.<Object[]>any(), Mockito.<Locale>any()))
        .thenReturn("Not all who wander are lost");
    Template template = mock(Template.class);
    doThrow(new IncorrectParameterException("An error occurred")).when(template)
        .process(Mockito.<Object>any(), Mockito.<Writer>any());
    when(configuration.getTemplate(Mockito.<String>any())).thenReturn(template);
    ApiUsageRecordState recordState = mock(ApiUsageRecordState.class);
    when(recordState.getThresholdAsString()).thenReturn("Threshold As String");
    when(recordState.getValueAsString()).thenReturn("42");
    when(recordState.getKey()).thenReturn(ApiUsageRecordKey.TRANSPORT_MSG_COUNT);

    // Act and Assert
    assertThrows(ThingsboardException.class, () -> defaultMailService.sendApiFeatureStateEmail(ApiFeature.ALARM,
        ApiUsageStateValue.WARNING, "jane.doe@example.org", recordState));
    verify(configuration).getTemplate(eq("state.warning.ftl"));
    verify(template).process(isA(Object.class), isA(Writer.class));
    verify(messageSource).getMessage(eq("api.usage.state"), isNull(), isA(Locale.class));
    verify(recordState).getKey();
    verify(recordState).getThresholdAsString();
    verify(recordState).getValueAsString();
  }

  /**
   * Test {@link DefaultMailService#sendApiFeatureStateEmail(ApiFeature, ApiUsageStateValue, String, ApiUsageRecordState)}.
   * <ul>
   *   <li>Given {@code TRANSPORT_MSG_COUNT}.</li>
   *   <li>When {@code EMAIL}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DefaultMailService#sendApiFeatureStateEmail(ApiFeature, ApiUsageStateValue, String, ApiUsageRecordState)}
   */
  @Test
  @DisplayName("Test sendApiFeatureStateEmail(ApiFeature, ApiUsageStateValue, String, ApiUsageRecordState); given 'TRANSPORT_MSG_COUNT'; when 'EMAIL'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "void DefaultMailService.sendApiFeatureStateEmail(ApiFeature, ApiUsageStateValue, String, ApiUsageRecordState)"})
  void testSendApiFeatureStateEmail_givenTransportMsgCount_whenEmail()
      throws TemplateException, IOException, NoSuchMessageException, ThingsboardException {
    // Arrange
    when(messageSource.getMessage(Mockito.<String>any(), Mockito.<Object[]>any(), Mockito.<Locale>any()))
        .thenReturn("Not all who wander are lost");
    Template template = mock(Template.class);
    doThrow(new IncorrectParameterException("An error occurred")).when(template)
        .process(Mockito.<Object>any(), Mockito.<Writer>any());
    when(configuration.getTemplate(Mockito.<String>any())).thenReturn(template);
    ApiUsageRecordState recordState = mock(ApiUsageRecordState.class);
    when(recordState.getThresholdAsString()).thenReturn("Threshold As String");
    when(recordState.getValueAsString()).thenReturn("42");
    when(recordState.getKey()).thenReturn(ApiUsageRecordKey.TRANSPORT_MSG_COUNT);

    // Act and Assert
    assertThrows(ThingsboardException.class, () -> defaultMailService.sendApiFeatureStateEmail(ApiFeature.EMAIL,
        ApiUsageStateValue.WARNING, "jane.doe@example.org", recordState));
    verify(configuration).getTemplate(eq("state.warning.ftl"));
    verify(template).process(isA(Object.class), isA(Writer.class));
    verify(messageSource).getMessage(eq("api.usage.state"), isNull(), isA(Locale.class));
    verify(recordState).getKey();
    verify(recordState).getThresholdAsString();
    verify(recordState).getValueAsString();
  }

  /**
   * Test {@link DefaultMailService#sendApiFeatureStateEmail(ApiFeature, ApiUsageStateValue, String, ApiUsageRecordState)}.
   * <ul>
   *   <li>Then throw {@link FactoryBeanNotInitializedException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DefaultMailService#sendApiFeatureStateEmail(ApiFeature, ApiUsageStateValue, String, ApiUsageRecordState)}
   */
  @Test
  @DisplayName("Test sendApiFeatureStateEmail(ApiFeature, ApiUsageStateValue, String, ApiUsageRecordState); then throw FactoryBeanNotInitializedException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "void DefaultMailService.sendApiFeatureStateEmail(ApiFeature, ApiUsageStateValue, String, ApiUsageRecordState)"})
  void testSendApiFeatureStateEmail_thenThrowFactoryBeanNotInitializedException()
      throws NoSuchMessageException, ThingsboardException {
    // Arrange
    when(messageSource.getMessage(Mockito.<String>any(), Mockito.<Object[]>any(), Mockito.<Locale>any()))
        .thenReturn("Not all who wander are lost");
    ApiUsageRecordState recordState = mock(ApiUsageRecordState.class);
    when(recordState.getKey()).thenThrow(new FactoryBeanNotInitializedException("api.usage.state"));

    // Act and Assert
    assertThrows(FactoryBeanNotInitializedException.class,
        () -> defaultMailService.sendApiFeatureStateEmail(ApiFeature.TRANSPORT, ApiUsageStateValue.DISABLED,
            "jane.doe@example.org", recordState));
    verify(messageSource).getMessage(eq("api.usage.state"), isNull(), isA(Locale.class));
    verify(recordState).getKey();
  }

  /**
   * Test {@link DefaultMailService#sendApiFeatureStateEmail(ApiFeature, ApiUsageStateValue, String, ApiUsageRecordState)}.
   * <ul>
   *   <li>When {@code ALARM}.</li>
   *   <li>Then calls {@link Template#process(Object, Writer)}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DefaultMailService#sendApiFeatureStateEmail(ApiFeature, ApiUsageStateValue, String, ApiUsageRecordState)}
   */
  @Test
  @DisplayName("Test sendApiFeatureStateEmail(ApiFeature, ApiUsageStateValue, String, ApiUsageRecordState); when 'ALARM'; then calls process(Object, Writer)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "void DefaultMailService.sendApiFeatureStateEmail(ApiFeature, ApiUsageStateValue, String, ApiUsageRecordState)"})
  void testSendApiFeatureStateEmail_whenAlarm_thenCallsProcess()
      throws TemplateException, IOException, NoSuchMessageException, ThingsboardException {
    // Arrange
    when(messageSource.getMessage(Mockito.<String>any(), Mockito.<Object[]>any(), Mockito.<Locale>any()))
        .thenReturn("Not all who wander are lost");
    Template template = mock(Template.class);
    doThrow(new IncorrectParameterException("An error occurred")).when(template)
        .process(Mockito.<Object>any(), Mockito.<Writer>any());
    when(configuration.getTemplate(Mockito.<String>any())).thenReturn(template);

    // Act and Assert
    assertThrows(ThingsboardException.class,
        () -> defaultMailService.sendApiFeatureStateEmail(ApiFeature.ALARM, ApiUsageStateValue.ENABLED,
            "jane.doe@example.org",
            new ApiUsageRecordState(ApiFeature.TRANSPORT, ApiUsageRecordKey.TRANSPORT_MSG_COUNT, 1L, 42L)));
    verify(configuration).getTemplate(eq("state.enabled.ftl"));
    verify(template).process(isA(Object.class), isA(Writer.class));
    verify(messageSource).getMessage(eq("api.usage.state"), isNull(), isA(Locale.class));
  }

  /**
   * Test {@link DefaultMailService#sendApiFeatureStateEmail(ApiFeature, ApiUsageStateValue, String, ApiUsageRecordState)}.
   * <ul>
   *   <li>When {@link ApiUsageRecordState}.</li>
   *   <li>Then throw {@link RuntimeException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DefaultMailService#sendApiFeatureStateEmail(ApiFeature, ApiUsageStateValue, String, ApiUsageRecordState)}
   */
  @Test
  @DisplayName("Test sendApiFeatureStateEmail(ApiFeature, ApiUsageStateValue, String, ApiUsageRecordState); when ApiUsageRecordState; then throw RuntimeException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "void DefaultMailService.sendApiFeatureStateEmail(ApiFeature, ApiUsageStateValue, String, ApiUsageRecordState)"})
  void testSendApiFeatureStateEmail_whenApiUsageRecordState_thenThrowRuntimeException()
      throws NoSuchMessageException, ThingsboardException {
    // Arrange
    when(messageSource.getMessage(Mockito.<String>any(), Mockito.<Object[]>any(), Mockito.<Locale>any()))
        .thenReturn("Not all who wander are lost");

    // Act and Assert
    assertThrows(RuntimeException.class, () -> defaultMailService.sendApiFeatureStateEmail(ApiFeature.TBEL,
        ApiUsageStateValue.WARNING, "jane.doe@example.org", mock(ApiUsageRecordState.class)));
    verify(messageSource).getMessage(eq("api.usage.state"), isNull(), isA(Locale.class));
  }

  /**
   * Test {@link DefaultMailService#sendApiFeatureStateEmail(ApiFeature, ApiUsageStateValue, String, ApiUsageRecordState)}.
   * <ul>
   *   <li>When {@code DB}.</li>
   *   <li>Then calls {@link Template#process(Object, Writer)}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DefaultMailService#sendApiFeatureStateEmail(ApiFeature, ApiUsageStateValue, String, ApiUsageRecordState)}
   */
  @Test
  @DisplayName("Test sendApiFeatureStateEmail(ApiFeature, ApiUsageStateValue, String, ApiUsageRecordState); when 'DB'; then calls process(Object, Writer)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "void DefaultMailService.sendApiFeatureStateEmail(ApiFeature, ApiUsageStateValue, String, ApiUsageRecordState)"})
  void testSendApiFeatureStateEmail_whenDb_thenCallsProcess()
      throws TemplateException, IOException, NoSuchMessageException, ThingsboardException {
    // Arrange
    when(messageSource.getMessage(Mockito.<String>any(), Mockito.<Object[]>any(), Mockito.<Locale>any()))
        .thenReturn("Not all who wander are lost");
    Template template = mock(Template.class);
    doThrow(new IncorrectParameterException("An error occurred")).when(template)
        .process(Mockito.<Object>any(), Mockito.<Writer>any());
    when(configuration.getTemplate(Mockito.<String>any())).thenReturn(template);

    // Act and Assert
    assertThrows(ThingsboardException.class,
        () -> defaultMailService.sendApiFeatureStateEmail(ApiFeature.DB, ApiUsageStateValue.ENABLED,
            "jane.doe@example.org",
            new ApiUsageRecordState(ApiFeature.TRANSPORT, ApiUsageRecordKey.TRANSPORT_MSG_COUNT, 1L, 42L)));
    verify(configuration).getTemplate(eq("state.enabled.ftl"));
    verify(template).process(isA(Object.class), isA(Writer.class));
    verify(messageSource).getMessage(eq("api.usage.state"), isNull(), isA(Locale.class));
  }

  /**
   * Test {@link DefaultMailService#sendApiFeatureStateEmail(ApiFeature, ApiUsageStateValue, String, ApiUsageRecordState)}.
   * <ul>
   *   <li>When {@code DB}.</li>
   *   <li>Then calls {@link Template#process(Object, Writer)}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DefaultMailService#sendApiFeatureStateEmail(ApiFeature, ApiUsageStateValue, String, ApiUsageRecordState)}
   */
  @Test
  @DisplayName("Test sendApiFeatureStateEmail(ApiFeature, ApiUsageStateValue, String, ApiUsageRecordState); when 'DB'; then calls process(Object, Writer)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "void DefaultMailService.sendApiFeatureStateEmail(ApiFeature, ApiUsageStateValue, String, ApiUsageRecordState)"})
  void testSendApiFeatureStateEmail_whenDb_thenCallsProcess2()
      throws TemplateException, IOException, NoSuchMessageException, ThingsboardException {
    // Arrange
    when(messageSource.getMessage(Mockito.<String>any(), Mockito.<Object[]>any(), Mockito.<Locale>any()))
        .thenReturn("Not all who wander are lost");
    Template template = mock(Template.class);
    doThrow(new IncorrectParameterException("An error occurred")).when(template)
        .process(Mockito.<Object>any(), Mockito.<Writer>any());
    when(configuration.getTemplate(Mockito.<String>any())).thenReturn(template);

    // Act and Assert
    assertThrows(ThingsboardException.class,
        () -> defaultMailService.sendApiFeatureStateEmail(ApiFeature.DB, ApiUsageStateValue.WARNING,
            "jane.doe@example.org",
            new ApiUsageRecordState(ApiFeature.TRANSPORT, ApiUsageRecordKey.TRANSPORT_MSG_COUNT, 1L, 42L)));
    verify(configuration).getTemplate(eq("state.warning.ftl"));
    verify(template).process(isA(Object.class), isA(Writer.class));
    verify(messageSource).getMessage(eq("api.usage.state"), isNull(), isA(Locale.class));
  }

  /**
   * Test {@link DefaultMailService#sendApiFeatureStateEmail(ApiFeature, ApiUsageStateValue, String, ApiUsageRecordState)}.
   * <ul>
   *   <li>When {@code DISABLED}.</li>
   *   <li>Then calls {@link Template#process(Object, Writer)}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DefaultMailService#sendApiFeatureStateEmail(ApiFeature, ApiUsageStateValue, String, ApiUsageRecordState)}
   */
  @Test
  @DisplayName("Test sendApiFeatureStateEmail(ApiFeature, ApiUsageStateValue, String, ApiUsageRecordState); when 'DISABLED'; then calls process(Object, Writer)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "void DefaultMailService.sendApiFeatureStateEmail(ApiFeature, ApiUsageStateValue, String, ApiUsageRecordState)"})
  void testSendApiFeatureStateEmail_whenDisabled_thenCallsProcess()
      throws TemplateException, IOException, NoSuchMessageException, ThingsboardException {
    // Arrange
    when(messageSource.getMessage(Mockito.<String>any(), Mockito.<Object[]>any(), Mockito.<Locale>any()))
        .thenReturn("Not all who wander are lost");
    Template template = mock(Template.class);
    doThrow(new IncorrectParameterException("An error occurred")).when(template)
        .process(Mockito.<Object>any(), Mockito.<Writer>any());
    when(configuration.getTemplate(Mockito.<String>any())).thenReturn(template);

    // Act and Assert
    assertThrows(ThingsboardException.class,
        () -> defaultMailService.sendApiFeatureStateEmail(ApiFeature.TRANSPORT, ApiUsageStateValue.DISABLED,
            "jane.doe@example.org",
            new ApiUsageRecordState(ApiFeature.TRANSPORT, ApiUsageRecordKey.TRANSPORT_MSG_COUNT, 1L, 42L)));
    verify(configuration).getTemplate(eq("state.disabled.ftl"));
    verify(template).process(isA(Object.class), isA(Writer.class));
    verify(messageSource).getMessage(eq("api.usage.state"), isNull(), isA(Locale.class));
  }

  /**
   * Test {@link DefaultMailService#sendApiFeatureStateEmail(ApiFeature, ApiUsageStateValue, String, ApiUsageRecordState)}.
   * <ul>
   *   <li>When {@code EMAIL}.</li>
   *   <li>Then calls {@link Template#process(Object, Writer)}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DefaultMailService#sendApiFeatureStateEmail(ApiFeature, ApiUsageStateValue, String, ApiUsageRecordState)}
   */
  @Test
  @DisplayName("Test sendApiFeatureStateEmail(ApiFeature, ApiUsageStateValue, String, ApiUsageRecordState); when 'EMAIL'; then calls process(Object, Writer)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "void DefaultMailService.sendApiFeatureStateEmail(ApiFeature, ApiUsageStateValue, String, ApiUsageRecordState)"})
  void testSendApiFeatureStateEmail_whenEmail_thenCallsProcess()
      throws TemplateException, IOException, NoSuchMessageException, ThingsboardException {
    // Arrange
    when(messageSource.getMessage(Mockito.<String>any(), Mockito.<Object[]>any(), Mockito.<Locale>any()))
        .thenReturn("Not all who wander are lost");
    Template template = mock(Template.class);
    doThrow(new IncorrectParameterException("An error occurred")).when(template)
        .process(Mockito.<Object>any(), Mockito.<Writer>any());
    when(configuration.getTemplate(Mockito.<String>any())).thenReturn(template);

    // Act and Assert
    assertThrows(ThingsboardException.class,
        () -> defaultMailService.sendApiFeatureStateEmail(ApiFeature.EMAIL, ApiUsageStateValue.ENABLED,
            "jane.doe@example.org",
            new ApiUsageRecordState(ApiFeature.TRANSPORT, ApiUsageRecordKey.TRANSPORT_MSG_COUNT, 1L, 42L)));
    verify(configuration).getTemplate(eq("state.enabled.ftl"));
    verify(template).process(isA(Object.class), isA(Writer.class));
    verify(messageSource).getMessage(eq("api.usage.state"), isNull(), isA(Locale.class));
  }

  /**
   * Test {@link DefaultMailService#sendApiFeatureStateEmail(ApiFeature, ApiUsageStateValue, String, ApiUsageRecordState)}.
   * <ul>
   *   <li>When {@code JS}.</li>
   *   <li>Then calls {@link Template#process(Object, Writer)}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DefaultMailService#sendApiFeatureStateEmail(ApiFeature, ApiUsageStateValue, String, ApiUsageRecordState)}
   */
  @Test
  @DisplayName("Test sendApiFeatureStateEmail(ApiFeature, ApiUsageStateValue, String, ApiUsageRecordState); when 'JS'; then calls process(Object, Writer)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "void DefaultMailService.sendApiFeatureStateEmail(ApiFeature, ApiUsageStateValue, String, ApiUsageRecordState)"})
  void testSendApiFeatureStateEmail_whenJs_thenCallsProcess()
      throws TemplateException, IOException, NoSuchMessageException, ThingsboardException {
    // Arrange
    when(messageSource.getMessage(Mockito.<String>any(), Mockito.<Object[]>any(), Mockito.<Locale>any()))
        .thenReturn("Not all who wander are lost");
    Template template = mock(Template.class);
    doThrow(new IncorrectParameterException("An error occurred")).when(template)
        .process(Mockito.<Object>any(), Mockito.<Writer>any());
    when(configuration.getTemplate(Mockito.<String>any())).thenReturn(template);

    // Act and Assert
    assertThrows(ThingsboardException.class,
        () -> defaultMailService.sendApiFeatureStateEmail(ApiFeature.JS, ApiUsageStateValue.ENABLED,
            "jane.doe@example.org",
            new ApiUsageRecordState(ApiFeature.TRANSPORT, ApiUsageRecordKey.TRANSPORT_MSG_COUNT, 1L, 42L)));
    verify(configuration).getTemplate(eq("state.enabled.ftl"));
    verify(template).process(isA(Object.class), isA(Writer.class));
    verify(messageSource).getMessage(eq("api.usage.state"), isNull(), isA(Locale.class));
  }

  /**
   * Test {@link DefaultMailService#sendApiFeatureStateEmail(ApiFeature, ApiUsageStateValue, String, ApiUsageRecordState)}.
   * <ul>
   *   <li>When {@code JS}.</li>
   *   <li>Then calls {@link Template#process(Object, Writer)}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DefaultMailService#sendApiFeatureStateEmail(ApiFeature, ApiUsageStateValue, String, ApiUsageRecordState)}
   */
  @Test
  @DisplayName("Test sendApiFeatureStateEmail(ApiFeature, ApiUsageStateValue, String, ApiUsageRecordState); when 'JS'; then calls process(Object, Writer)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "void DefaultMailService.sendApiFeatureStateEmail(ApiFeature, ApiUsageStateValue, String, ApiUsageRecordState)"})
  void testSendApiFeatureStateEmail_whenJs_thenCallsProcess2()
      throws TemplateException, IOException, NoSuchMessageException, ThingsboardException {
    // Arrange
    when(messageSource.getMessage(Mockito.<String>any(), Mockito.<Object[]>any(), Mockito.<Locale>any()))
        .thenReturn("Not all who wander are lost");
    Template template = mock(Template.class);
    doThrow(new IncorrectParameterException("An error occurred")).when(template)
        .process(Mockito.<Object>any(), Mockito.<Writer>any());
    when(configuration.getTemplate(Mockito.<String>any())).thenReturn(template);

    // Act and Assert
    assertThrows(ThingsboardException.class,
        () -> defaultMailService.sendApiFeatureStateEmail(ApiFeature.JS, ApiUsageStateValue.WARNING,
            "jane.doe@example.org",
            new ApiUsageRecordState(ApiFeature.TRANSPORT, ApiUsageRecordKey.TRANSPORT_MSG_COUNT, 1L, 42L)));
    verify(configuration).getTemplate(eq("state.warning.ftl"));
    verify(template).process(isA(Object.class), isA(Writer.class));
    verify(messageSource).getMessage(eq("api.usage.state"), isNull(), isA(Locale.class));
  }

  /**
   * Test {@link DefaultMailService#sendApiFeatureStateEmail(ApiFeature, ApiUsageStateValue, String, ApiUsageRecordState)}.
   * <ul>
   *   <li>When {@code RE}.</li>
   *   <li>Then calls {@link Template#process(Object, Writer)}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DefaultMailService#sendApiFeatureStateEmail(ApiFeature, ApiUsageStateValue, String, ApiUsageRecordState)}
   */
  @Test
  @DisplayName("Test sendApiFeatureStateEmail(ApiFeature, ApiUsageStateValue, String, ApiUsageRecordState); when 'RE'; then calls process(Object, Writer)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "void DefaultMailService.sendApiFeatureStateEmail(ApiFeature, ApiUsageStateValue, String, ApiUsageRecordState)"})
  void testSendApiFeatureStateEmail_whenRe_thenCallsProcess()
      throws TemplateException, IOException, NoSuchMessageException, ThingsboardException {
    // Arrange
    when(messageSource.getMessage(Mockito.<String>any(), Mockito.<Object[]>any(), Mockito.<Locale>any()))
        .thenReturn("Not all who wander are lost");
    Template template = mock(Template.class);
    doThrow(new IncorrectParameterException("An error occurred")).when(template)
        .process(Mockito.<Object>any(), Mockito.<Writer>any());
    when(configuration.getTemplate(Mockito.<String>any())).thenReturn(template);

    // Act and Assert
    assertThrows(ThingsboardException.class,
        () -> defaultMailService.sendApiFeatureStateEmail(ApiFeature.RE, ApiUsageStateValue.ENABLED,
            "jane.doe@example.org",
            new ApiUsageRecordState(ApiFeature.TRANSPORT, ApiUsageRecordKey.TRANSPORT_MSG_COUNT, 1L, 42L)));
    verify(configuration).getTemplate(eq("state.enabled.ftl"));
    verify(template).process(isA(Object.class), isA(Writer.class));
    verify(messageSource).getMessage(eq("api.usage.state"), isNull(), isA(Locale.class));
  }

  /**
   * Test {@link DefaultMailService#sendApiFeatureStateEmail(ApiFeature, ApiUsageStateValue, String, ApiUsageRecordState)}.
   * <ul>
   *   <li>When {@code RE}.</li>
   *   <li>Then calls {@link Template#process(Object, Writer)}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DefaultMailService#sendApiFeatureStateEmail(ApiFeature, ApiUsageStateValue, String, ApiUsageRecordState)}
   */
  @Test
  @DisplayName("Test sendApiFeatureStateEmail(ApiFeature, ApiUsageStateValue, String, ApiUsageRecordState); when 'RE'; then calls process(Object, Writer)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "void DefaultMailService.sendApiFeatureStateEmail(ApiFeature, ApiUsageStateValue, String, ApiUsageRecordState)"})
  void testSendApiFeatureStateEmail_whenRe_thenCallsProcess2()
      throws TemplateException, IOException, NoSuchMessageException, ThingsboardException {
    // Arrange
    when(messageSource.getMessage(Mockito.<String>any(), Mockito.<Object[]>any(), Mockito.<Locale>any()))
        .thenReturn("Not all who wander are lost");
    Template template = mock(Template.class);
    doThrow(new IncorrectParameterException("An error occurred")).when(template)
        .process(Mockito.<Object>any(), Mockito.<Writer>any());
    when(configuration.getTemplate(Mockito.<String>any())).thenReturn(template);

    // Act and Assert
    assertThrows(ThingsboardException.class,
        () -> defaultMailService.sendApiFeatureStateEmail(ApiFeature.RE, ApiUsageStateValue.WARNING,
            "jane.doe@example.org",
            new ApiUsageRecordState(ApiFeature.TRANSPORT, ApiUsageRecordKey.TRANSPORT_MSG_COUNT, 1L, 42L)));
    verify(configuration).getTemplate(eq("state.warning.ftl"));
    verify(template).process(isA(Object.class), isA(Writer.class));
    verify(messageSource).getMessage(eq("api.usage.state"), isNull(), isA(Locale.class));
  }

  /**
   * Test {@link DefaultMailService#sendApiFeatureStateEmail(ApiFeature, ApiUsageStateValue, String, ApiUsageRecordState)}.
   * <ul>
   *   <li>When {@code TBEL}.</li>
   *   <li>Then throw {@link RuntimeException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DefaultMailService#sendApiFeatureStateEmail(ApiFeature, ApiUsageStateValue, String, ApiUsageRecordState)}
   */
  @Test
  @DisplayName("Test sendApiFeatureStateEmail(ApiFeature, ApiUsageStateValue, String, ApiUsageRecordState); when 'TBEL'; then throw RuntimeException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "void DefaultMailService.sendApiFeatureStateEmail(ApiFeature, ApiUsageStateValue, String, ApiUsageRecordState)"})
  void testSendApiFeatureStateEmail_whenTbel_thenThrowRuntimeException()
      throws NoSuchMessageException, ThingsboardException {
    // Arrange
    when(messageSource.getMessage(Mockito.<String>any(), Mockito.<Object[]>any(), Mockito.<Locale>any()))
        .thenReturn("Not all who wander are lost");

    // Act and Assert
    assertThrows(RuntimeException.class,
        () -> defaultMailService.sendApiFeatureStateEmail(ApiFeature.TBEL, ApiUsageStateValue.ENABLED,
            "jane.doe@example.org",
            new ApiUsageRecordState(ApiFeature.TRANSPORT, ApiUsageRecordKey.TRANSPORT_MSG_COUNT, 1L, 42L)));
    verify(messageSource).getMessage(eq("api.usage.state"), isNull(), isA(Locale.class));
  }

  /**
   * Test {@link DefaultMailService#sendApiFeatureStateEmail(ApiFeature, ApiUsageStateValue, String, ApiUsageRecordState)}.
   * <ul>
   *   <li>When {@code WARNING}.</li>
   *   <li>Then calls {@link Template#process(Object, Writer)}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DefaultMailService#sendApiFeatureStateEmail(ApiFeature, ApiUsageStateValue, String, ApiUsageRecordState)}
   */
  @Test
  @DisplayName("Test sendApiFeatureStateEmail(ApiFeature, ApiUsageStateValue, String, ApiUsageRecordState); when 'WARNING'; then calls process(Object, Writer)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "void DefaultMailService.sendApiFeatureStateEmail(ApiFeature, ApiUsageStateValue, String, ApiUsageRecordState)"})
  void testSendApiFeatureStateEmail_whenWarning_thenCallsProcess()
      throws TemplateException, IOException, NoSuchMessageException, ThingsboardException {
    // Arrange
    when(messageSource.getMessage(Mockito.<String>any(), Mockito.<Object[]>any(), Mockito.<Locale>any()))
        .thenReturn("Not all who wander are lost");
    Template template = mock(Template.class);
    doThrow(new IncorrectParameterException("An error occurred")).when(template)
        .process(Mockito.<Object>any(), Mockito.<Writer>any());
    when(configuration.getTemplate(Mockito.<String>any())).thenReturn(template);

    // Act and Assert
    assertThrows(ThingsboardException.class,
        () -> defaultMailService.sendApiFeatureStateEmail(ApiFeature.TRANSPORT, ApiUsageStateValue.WARNING,
            "jane.doe@example.org",
            new ApiUsageRecordState(ApiFeature.TRANSPORT, ApiUsageRecordKey.TRANSPORT_MSG_COUNT, 1L, 42L)));
    verify(configuration).getTemplate(eq("state.warning.ftl"));
    verify(template).process(isA(Object.class), isA(Writer.class));
    verify(messageSource).getMessage(eq("api.usage.state"), isNull(), isA(Locale.class));
  }

  /**
   * Test {@link DefaultMailService#isConfigured(TenantId)}.
   * <p>
   * Method under test: {@link DefaultMailService#isConfigured(TenantId)}
   */
  @Test
  @DisplayName("Test isConfigured(TenantId)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean DefaultMailService.isConfigured(TenantId)"})
  void testIsConfigured() {
    // Arrange, Act and Assert
    assertFalse(defaultMailService.isConfigured(new TenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"))));
  }

  /**
   * Test {@link DefaultMailService#handleException(Throwable)}.
   * <ul>
   *   <li>Then return LocalizedMessage is {@code Unable to send mail: null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DefaultMailService#handleException(Throwable)}
   */
  @Test
  @DisplayName("Test handleException(Throwable); then return LocalizedMessage is 'Unable to send mail: null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"ThingsboardException DefaultMailService.handleException(Throwable)"})
  void testHandleException_thenReturnLocalizedMessageIsUnableToSendMailNull() {
    // Arrange and Act
    ThingsboardException actualHandleExceptionResult = defaultMailService.handleException(new Throwable());

    // Assert
    assertEquals("Unable to send mail: null", actualHandleExceptionResult.getLocalizedMessage());
    assertEquals("Unable to send mail: null", actualHandleExceptionResult.getMessage());
    assertNull(actualHandleExceptionResult.getCause());
    assertEquals(0, actualHandleExceptionResult.getSuppressed().length);
    assertEquals(ThingsboardErrorCode.GENERAL, actualHandleExceptionResult.getErrorCode());
  }
}
