package org.thingsboard.server.common.data.util;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.io.IOException;
import javax.xml.transform.Source;
import javax.xml.transform.dom.DOMSource;
import javax.xml.validation.SchemaFactory;
import org.apache.xerces.jaxp.validation.XMLSchemaFactory;
import org.eclipse.leshan.core.LwM2m;
import org.eclipse.leshan.core.LwM2m.LwM2mVersion;
import org.eclipse.leshan.core.model.InvalidDDFFileException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.w3c.dom.Node;
import org.xml.sax.SAXException;

@ContextConfiguration(classes = {TbDefaultDDFFileValidator.class})
@ExtendWith(SpringExtension.class)
class TbDefaultDDFFileValidatorDiffblueTest {
  @Autowired private TbDefaultDDFFileValidator tbDefaultDDFFileValidator;

  /**
   * Test {@link TbDefaultDDFFileValidator#TbDefaultDDFFileValidator(LwM2mVersion)}.
   *
   * <ul>
   *   <li>When Default.
   *   <li>Then does not throw.
   * </ul>
   *
   * <p>Method under test: {@link TbDefaultDDFFileValidator#TbDefaultDDFFileValidator(LwM2mVersion)}
   */
  @Test
  @DisplayName(
      "Test new TbDefaultDDFFileValidator(LwM2mVersion); when Default; then does not throw")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void TbDefaultDDFFileValidator.<init>(LwM2mVersion)"})
  void testNewTbDefaultDDFFileValidator_whenDefault_thenDoesNotThrow() {
    // Arrange, Act and Assert
    assertDoesNotThrow(() -> new TbDefaultDDFFileValidator(LwM2mVersion.getDefault()));
  }

  /**
   * Test {@link TbDefaultDDFFileValidator#TbDefaultDDFFileValidator(LwM2mVersion)}.
   *
   * <ul>
   *   <li>When {@link LwM2mVersion}.
   *   <li>Then throw {@link IllegalStateException}.
   * </ul>
   *
   * <p>Method under test: {@link TbDefaultDDFFileValidator#TbDefaultDDFFileValidator(LwM2mVersion)}
   */
  @Test
  @DisplayName(
      "Test new TbDefaultDDFFileValidator(LwM2mVersion); when LwM2mVersion; then throw IllegalStateException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void TbDefaultDDFFileValidator.<init>(LwM2mVersion)"})
  void testNewTbDefaultDDFFileValidator_whenLwM2mVersion_thenThrowIllegalStateException() {
    // Arrange, Act and Assert
    assertThrows(
        IllegalStateException.class, () -> new TbDefaultDDFFileValidator(mock(LwM2mVersion.class)));
  }

  /**
   * Test {@link TbDefaultDDFFileValidator#TbDefaultDDFFileValidator(LwM2mVersion)}.
   *
   * <ul>
   *   <li>When {@link LwM2mVersion#V1_1}.
   *   <li>Then does not throw.
   * </ul>
   *
   * <p>Method under test: {@link TbDefaultDDFFileValidator#TbDefaultDDFFileValidator(LwM2mVersion)}
   */
  @Test
  @DisplayName("Test new TbDefaultDDFFileValidator(LwM2mVersion); when V1_1; then does not throw")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void TbDefaultDDFFileValidator.<init>(LwM2mVersion)"})
  void testNewTbDefaultDDFFileValidator_whenV1_1_thenDoesNotThrow() {
    // Arrange, Act and Assert
    assertDoesNotThrow(() -> new TbDefaultDDFFileValidator(LwM2mVersion.V1_1));
  }

  /**
   * Test {@link TbDefaultDDFFileValidator#validate(Node)} with {@code Node}.
   *
   * <ul>
   *   <li>When {@code null}.
   *   <li>Then does not throw.
   * </ul>
   *
   * <p>Method under test: {@link TbDefaultDDFFileValidator#validate(Node)}
   */
  @Test
  @DisplayName("Test validate(Node) with 'Node'; when 'null'; then does not throw")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void TbDefaultDDFFileValidator.validate(Node)"})
  void testValidateWithNode_whenNull_thenDoesNotThrow() throws InvalidDDFFileException {
    // Arrange, Act and Assert
    assertDoesNotThrow(() -> tbDefaultDDFFileValidator.validate((Node) null));
  }

  /**
   * Test {@link TbDefaultDDFFileValidator#validate(Source)} with {@code Source}.
   *
   * <ul>
   *   <li>When {@link DOMSource#DOMSource()}.
   *   <li>Then does not throw.
   * </ul>
   *
   * <p>Method under test: {@link TbDefaultDDFFileValidator#validate(Source)}
   */
  @Test
  @DisplayName("Test validate(Source) with 'Source'; when DOMSource(); then does not throw")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void TbDefaultDDFFileValidator.validate(Source)"})
  void testValidateWithSource_whenDOMSource_thenDoesNotThrow() throws IOException, SAXException {
    // Arrange, Act and Assert
    assertDoesNotThrow(() -> tbDefaultDDFFileValidator.validate(new DOMSource()));
  }

  /**
   * Test {@link TbDefaultDDFFileValidator#createSchemaFactory()}.
   *
   * <p>Method under test: {@link TbDefaultDDFFileValidator#createSchemaFactory()}
   */
  @Test
  @DisplayName("Test createSchemaFactory()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"SchemaFactory TbDefaultDDFFileValidator.createSchemaFactory()"})
  void testCreateSchemaFactory() {
    // Arrange and Act
    SchemaFactory actualCreateSchemaFactoryResult =
        new TbDefaultDDFFileValidator().createSchemaFactory();

    // Assert
    assertTrue(actualCreateSchemaFactoryResult instanceof XMLSchemaFactory);
    assertNull(actualCreateSchemaFactoryResult.getResourceResolver());
    assertNull(actualCreateSchemaFactoryResult.getErrorHandler());
  }
}
