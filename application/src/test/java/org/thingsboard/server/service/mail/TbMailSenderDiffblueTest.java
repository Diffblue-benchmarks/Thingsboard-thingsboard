package org.thingsboard.server.service.mail;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.BigIntegerNode;
import java.math.BigInteger;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.aot.DisabledInAotMode;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.thingsboard.server.dao.exception.IncorrectParameterException;
import org.thingsboard.server.dao.settings.AdminSettingsService;

@ContextConfiguration(classes = {TbMailContextComponent.class})
@ExtendWith(SpringExtension.class)
@DisabledInAotMode
class TbMailSenderDiffblueTest {
  @MockBean
  private AdminSettingsService adminSettingsService;

  @MockBean
  private JsonNode jsonNode;

  @Autowired
  private TbMailContextComponent tbMailContextComponent;

  @MockBean
  private TbMailSender tbMailSender;

  /**
   * Test {@link TbMailSender#TbMailSender(TbMailContextComponent, JsonNode)}.
   * <p>
   * Method under test:
   * {@link TbMailSender#TbMailSender(TbMailContextComponent, JsonNode)}
   */
  @Test
  @DisplayName("Test new TbMailSender(TbMailContextComponent, JsonNode)")
  void testNewTbMailSender() {
    // Arrange
    when(jsonNode.asText()).thenReturn("As Text");
    when(jsonNode.asBoolean()).thenReturn(true);
    when(jsonNode.has(Mockito.<String>any())).thenReturn(true);
    when(jsonNode.get(Mockito.<String>any())).thenReturn(jsonNode);

    // Act and Assert
    assertThrows(IncorrectParameterException.class, () -> new TbMailSender(tbMailContextComponent, jsonNode));

    verify(jsonNode).asBoolean();
    verify(jsonNode, atLeast(1)).asText();
    verify(jsonNode, atLeast(1)).get(Mockito.<String>any());
    verify(jsonNode).has(eq("enableOauth2"));
  }

  /**
   * Test {@link TbMailSender#updateOauth2PasswordIfExpired()}.
   * <ul>
   *   <li>Given {@link ArrayNode} {@link JsonNode#has(String)} return
   * {@code false}.</li>
   *   <li>Then calls {@link JsonNode#has(String)}.</li>
   * </ul>
   * <p>
   * Method under test: {@link TbMailSender#updateOauth2PasswordIfExpired()}
   */
  @Test
  @DisplayName("Test updateOauth2PasswordIfExpired(); given ArrayNode has(String) return 'false'; then calls has(String)")
  void testUpdateOauth2PasswordIfExpired_givenArrayNodeHasReturnFalse_thenCallsHas() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    ArrayNode jsonConfig = mock(ArrayNode.class);
    when(jsonConfig.has(Mockito.<String>any())).thenReturn(false);
    when(jsonConfig.get(Mockito.<String>any())).thenReturn(new BigIntegerNode(BigInteger.valueOf(1L)));

    // Act
    (new TbMailSender(mock(TbMailContextComponent.class), jsonConfig)).updateOauth2PasswordIfExpired();

    // Assert that nothing has changed
    verify(jsonConfig, atLeast(1)).has(Mockito.<String>any());
    verify(jsonConfig, atLeast(1)).get(Mockito.<String>any());
  }
}
