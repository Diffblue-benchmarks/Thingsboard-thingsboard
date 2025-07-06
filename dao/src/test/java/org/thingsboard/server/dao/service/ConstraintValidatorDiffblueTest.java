package org.thingsboard.server.dao.service;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.MaintainedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import jakarta.validation.ConstraintViolation;
import jakarta.validation.Path;
import jakarta.validation.Path.Node;
import jakarta.validation.metadata.ConstraintDescriptor;
import java.lang.annotation.Annotation;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import org.hibernate.validator.internal.engine.DefaultClockProvider;
import org.hibernate.validator.internal.engine.DefaultParameterNameProvider;
import org.hibernate.validator.internal.engine.ValidatorImpl;
import org.hibernate.validator.internal.engine.path.PathImpl;
import org.hibernate.validator.internal.engine.resolver.JPATraversableResolver;
import org.hibernate.validator.internal.metadata.descriptor.ConstraintDescriptorImpl;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.validation.beanvalidation.LocalValidatorFactoryBean;
import org.springframework.validation.beanvalidation.LocaleContextMessageInterpolator;
import org.springframework.validation.beanvalidation.SpringConstraintValidatorFactory;
import org.thingsboard.server.dao.exception.DataValidationException;

@ContextConfiguration(classes = {ConstraintValidator.class})
@RunWith(SpringJUnit4ClassRunner.class)
public class ConstraintValidatorDiffblueTest {
  @Autowired private ConstraintValidator constraintValidator;

  /**
   * Test {@link ConstraintValidator#getErrorMessage(ConstraintViolation)} with {@code
   * constraintViolation}.
   *
   * <p>Method under test: {@link ConstraintValidator#getErrorMessage(ConstraintViolation)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String ConstraintValidator.getErrorMessage(ConstraintViolation)"})
  public void testGetErrorMessageWithConstraintViolation() {
    // Arrange
    ConstraintViolation<Object> constraintViolation = mock(ConstraintViolation.class);
    org.mockito.Mockito.<ConstraintDescriptor<?>>when(constraintViolation.getConstraintDescriptor())
        .thenThrow(new DataValidationException("An error occurred"));

    // Act and Assert
    assertThrows(
        DataValidationException.class,
        () -> ConstraintValidator.getErrorMessage(constraintViolation));
    verify(constraintViolation).getConstraintDescriptor();
  }

  /**
   * Test {@link ConstraintValidator#getErrorMessage(ConstraintViolation)} with {@code
   * constraintViolation}.
   *
   * <p>Method under test: {@link ConstraintValidator#getErrorMessage(ConstraintViolation)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String ConstraintValidator.getErrorMessage(ConstraintViolation)"})
  public void testGetErrorMessageWithConstraintViolation2() {
    // Arrange
    ConstraintDescriptorImpl<Annotation> constraintDescriptorImpl =
        mock(ConstraintDescriptorImpl.class);
    when(constraintDescriptorImpl.getAnnotation()).thenReturn(null);
    when(constraintDescriptorImpl.getAttributes()).thenReturn(new HashMap<>());
    ConstraintViolation<Object> constraintViolation = mock(ConstraintViolation.class);
    when(constraintViolation.getMessage())
        .thenThrow(new DataValidationException("An error occurred"));
    when(constraintViolation.getPropertyPath()).thenReturn(PathImpl.createRootPath());
    org.mockito.Mockito.<ConstraintDescriptor<?>>when(constraintViolation.getConstraintDescriptor())
        .thenReturn(constraintDescriptorImpl);

    // Act and Assert
    assertThrows(
        DataValidationException.class,
        () -> ConstraintValidator.getErrorMessage(constraintViolation));
    verify(constraintViolation).getConstraintDescriptor();
    verify(constraintViolation).getMessage();
    verify(constraintViolation).getPropertyPath();
    verify(constraintDescriptorImpl).getAnnotation();
    verify(constraintDescriptorImpl).getAttributes();
  }

  /**
   * Test {@link ConstraintValidator#getErrorMessage(ConstraintViolation)} with {@code
   * constraintViolation}.
   *
   * <p>Method under test: {@link ConstraintValidator#getErrorMessage(ConstraintViolation)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String ConstraintValidator.getErrorMessage(ConstraintViolation)"})
  public void testGetErrorMessageWithConstraintViolation3() {
    // Arrange
    ConstraintDescriptorImpl<Annotation> constraintDescriptorImpl =
        mock(ConstraintDescriptorImpl.class);
    when(constraintDescriptorImpl.getAnnotation()).thenReturn(null);
    when(constraintDescriptorImpl.getAttributes()).thenReturn(new HashMap<>());
    PathImpl createRootPathResult = PathImpl.createRootPath();
    createRootPathResult.addPropertyNode("Node Name");
    ConstraintViolation<Object> constraintViolation = mock(ConstraintViolation.class);
    when(constraintViolation.getMessage()).thenReturn("Not all who wander are lost");
    when(constraintViolation.getPropertyPath()).thenReturn(createRootPathResult);
    org.mockito.Mockito.<ConstraintDescriptor<?>>when(constraintViolation.getConstraintDescriptor())
        .thenReturn(constraintDescriptorImpl);

    // Act
    String actualErrorMessage = ConstraintValidator.getErrorMessage(constraintViolation);

    // Assert
    verify(constraintViolation).getConstraintDescriptor();
    verify(constraintViolation).getMessage();
    verify(constraintViolation).getPropertyPath();
    verify(constraintDescriptorImpl).getAnnotation();
    verify(constraintDescriptorImpl).getAttributes();
    assertEquals("Node Name Not all who wander are lost", actualErrorMessage);
  }

  /**
   * Test {@link ConstraintValidator#getErrorMessage(ConstraintViolation)} with {@code
   * constraintViolation}.
   *
   * <ul>
   *   <li>Then calls {@link Path#iterator()}.
   * </ul>
   *
   * <p>Method under test: {@link ConstraintValidator#getErrorMessage(ConstraintViolation)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String ConstraintValidator.getErrorMessage(ConstraintViolation)"})
  public void testGetErrorMessageWithConstraintViolation_thenCallsIterator() {
    // Arrange
    ConstraintDescriptorImpl<Annotation> constraintDescriptorImpl =
        mock(ConstraintDescriptorImpl.class);
    when(constraintDescriptorImpl.getAnnotation()).thenReturn(null);
    when(constraintDescriptorImpl.getAttributes()).thenReturn(new HashMap<>());

    ArrayList<Node> nodeList = new ArrayList<>();
    nodeList.add(mock(Node.class));
    nodeList.add(mock(Node.class));
    Path path = mock(Path.class);
    when(path.iterator()).thenReturn(nodeList.iterator());
    ConstraintViolation<Object> constraintViolation = mock(ConstraintViolation.class);
    when(constraintViolation.getMessage()).thenReturn("Not all who wander are lost");
    when(constraintViolation.getPropertyPath()).thenReturn(path);
    org.mockito.Mockito.<ConstraintDescriptor<?>>when(constraintViolation.getConstraintDescriptor())
        .thenReturn(constraintDescriptorImpl);

    // Act
    ConstraintValidator.getErrorMessage(constraintViolation);

    // Assert
    verify(constraintViolation).getConstraintDescriptor();
    verify(constraintViolation).getMessage();
    verify(constraintViolation).getPropertyPath();
    verify(path).iterator();
    verify(constraintDescriptorImpl).getAnnotation();
    verify(constraintDescriptorImpl).getAttributes();
  }

  /**
   * Test {@link ConstraintValidator#getErrorMessage(ConstraintViolation)} with {@code
   * constraintViolation}.
   *
   * <ul>
   *   <li>Then return {@code 42 Not all who wander are lost}.
   * </ul>
   *
   * <p>Method under test: {@link ConstraintValidator#getErrorMessage(ConstraintViolation)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String ConstraintValidator.getErrorMessage(ConstraintViolation)"})
  public void testGetErrorMessageWithConstraintViolation_thenReturn42NotAllWhoWanderAreLost() {
    // Arrange
    HashMap<String, Object> stringObjectMap = new HashMap<>();
    stringObjectMap.put("fieldName", "42");
    ConstraintDescriptorImpl<Annotation> constraintDescriptorImpl =
        mock(ConstraintDescriptorImpl.class);
    when(constraintDescriptorImpl.getAttributes()).thenReturn(stringObjectMap);
    ConstraintViolation<Object> constraintViolation = mock(ConstraintViolation.class);
    when(constraintViolation.getMessage()).thenReturn("Not all who wander are lost");
    org.mockito.Mockito.<ConstraintDescriptor<?>>when(constraintViolation.getConstraintDescriptor())
        .thenReturn(constraintDescriptorImpl);

    // Act
    String actualErrorMessage = ConstraintValidator.getErrorMessage(constraintViolation);

    // Assert
    verify(constraintViolation).getConstraintDescriptor();
    verify(constraintViolation).getMessage();
    verify(constraintDescriptorImpl).getAttributes();
    assertEquals("42 Not all who wander are lost", actualErrorMessage);
  }

  /**
   * Test {@link ConstraintValidator#getErrorMessage(ConstraintViolation)} with {@code
   * constraintViolation}.
   *
   * <ul>
   *   <li>Then return {@code Not all who wander are lost}.
   * </ul>
   *
   * <p>Method under test: {@link ConstraintValidator#getErrorMessage(ConstraintViolation)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String ConstraintValidator.getErrorMessage(ConstraintViolation)"})
  public void testGetErrorMessageWithConstraintViolation_thenReturnNotAllWhoWanderAreLost() {
    // Arrange
    ConstraintDescriptorImpl<Annotation> constraintDescriptorImpl =
        mock(ConstraintDescriptorImpl.class);
    when(constraintDescriptorImpl.getAnnotation()).thenReturn(null);
    when(constraintDescriptorImpl.getAttributes()).thenReturn(new HashMap<>());
    ConstraintViolation<Object> constraintViolation = mock(ConstraintViolation.class);
    when(constraintViolation.getMessage()).thenReturn("Not all who wander are lost");
    when(constraintViolation.getPropertyPath()).thenReturn(PathImpl.createRootPath());
    org.mockito.Mockito.<ConstraintDescriptor<?>>when(constraintViolation.getConstraintDescriptor())
        .thenReturn(constraintDescriptorImpl);

    // Act
    String actualErrorMessage = ConstraintValidator.getErrorMessage(constraintViolation);

    // Assert
    verify(constraintViolation).getConstraintDescriptor();
    verify(constraintViolation).getMessage();
    verify(constraintViolation).getPropertyPath();
    verify(constraintDescriptorImpl).getAnnotation();
    verify(constraintDescriptorImpl).getAttributes();
    assertEquals("Not all who wander are lost", actualErrorMessage);
  }

  /**
   * Test {@link ConstraintValidator#getErrorMessage(Collection)} with {@code
   * constraintsViolations}.
   *
   * <p>Method under test: {@link ConstraintValidator#getErrorMessage(Collection)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String ConstraintValidator.getErrorMessage(Collection)"})
  public void testGetErrorMessageWithConstraintsViolations() {
    // Arrange
    ConstraintViolation<Object> constraintViolation = mock(ConstraintViolation.class);
    org.mockito.Mockito.<ConstraintDescriptor<?>>when(constraintViolation.getConstraintDescriptor())
        .thenThrow(new DataValidationException("An error occurred"));

    ArrayList<ConstraintViolation<Object>> constraintsViolations = new ArrayList<>();
    constraintsViolations.add(constraintViolation);

    // Act and Assert
    assertThrows(
        DataValidationException.class,
        () -> ConstraintValidator.getErrorMessage(constraintsViolations));
    verify(constraintViolation).getConstraintDescriptor();
  }

  /**
   * Test {@link ConstraintValidator#getErrorMessage(Collection)} with {@code
   * constraintsViolations}.
   *
   * <ul>
   *   <li>Then calls {@link ConstraintViolation#getMessage()}.
   * </ul>
   *
   * <p>Method under test: {@link ConstraintValidator#getErrorMessage(Collection)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String ConstraintValidator.getErrorMessage(Collection)"})
  public void testGetErrorMessageWithConstraintsViolations_thenCallsGetMessage() {
    // Arrange
    ConstraintDescriptorImpl<Annotation> constraintDescriptorImpl =
        mock(ConstraintDescriptorImpl.class);
    when(constraintDescriptorImpl.getAnnotation()).thenReturn(null);
    when(constraintDescriptorImpl.getAttributes()).thenReturn(new HashMap<>());
    ConstraintViolation<Object> constraintViolation = mock(ConstraintViolation.class);
    when(constraintViolation.getMessage())
        .thenThrow(new DataValidationException("An error occurred"));
    when(constraintViolation.getPropertyPath()).thenReturn(PathImpl.createRootPath());
    org.mockito.Mockito.<ConstraintDescriptor<?>>when(constraintViolation.getConstraintDescriptor())
        .thenReturn(constraintDescriptorImpl);

    ArrayList<ConstraintViolation<Object>> constraintsViolations = new ArrayList<>();
    constraintsViolations.add(constraintViolation);
    constraintsViolations.add(mock(ConstraintViolation.class));

    // Act and Assert
    assertThrows(
        DataValidationException.class,
        () -> ConstraintValidator.getErrorMessage(constraintsViolations));
    verify(constraintViolation).getConstraintDescriptor();
    verify(constraintViolation).getMessage();
    verify(constraintViolation).getPropertyPath();
    verify(constraintDescriptorImpl).getAnnotation();
    verify(constraintDescriptorImpl).getAttributes();
  }

  /**
   * Test {@link ConstraintValidator#getErrorMessage(Collection)} with {@code
   * constraintsViolations}.
   *
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.
   *   <li>Then return empty string.
   * </ul>
   *
   * <p>Method under test: {@link ConstraintValidator#getErrorMessage(Collection)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String ConstraintValidator.getErrorMessage(Collection)"})
  public void testGetErrorMessageWithConstraintsViolations_whenArrayList_thenReturnEmptyString() {
    // Arrange, Act and Assert
    assertEquals("", ConstraintValidator.getErrorMessage(new ArrayList<>()));
  }

  /**
   * Test {@link ConstraintValidator#validatorFactoryBean()}.
   *
   * <ul>
   *   <li>Given {@link ConstraintValidator} (default constructor).
   * </ul>
   *
   * <p>Method under test: {@link ConstraintValidator#validatorFactoryBean()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"LocalValidatorFactoryBean ConstraintValidator.validatorFactoryBean()"})
  public void testValidatorFactoryBean_givenConstraintValidator() {
    // Arrange, Act and Assert
    assertTrue(
        new ConstraintValidator().validatorFactoryBean().getValidationPropertyMap().isEmpty());
  }

  /**
   * Test {@link ConstraintValidator#validatorFactoryBean()}.
   *
   * <ul>
   *   <li>Then ClockProvider return {@link DefaultClockProvider}.
   * </ul>
   *
   * <p>Method under test: {@link ConstraintValidator#validatorFactoryBean()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"LocalValidatorFactoryBean ConstraintValidator.validatorFactoryBean()"})
  public void testValidatorFactoryBean_thenClockProviderReturnDefaultClockProvider() {
    // Arrange and Act
    LocalValidatorFactoryBean actualValidatorFactoryBeanResult =
        constraintValidator.validatorFactoryBean();

    // Assert
    assertTrue(actualValidatorFactoryBeanResult.getClockProvider() instanceof DefaultClockProvider);
    assertTrue(
        actualValidatorFactoryBeanResult.getParameterNameProvider()
            instanceof DefaultParameterNameProvider);
    assertTrue(actualValidatorFactoryBeanResult.getValidator() instanceof ValidatorImpl);
    assertTrue(
        actualValidatorFactoryBeanResult.getTraversableResolver()
            instanceof JPATraversableResolver);
    assertTrue(
        actualValidatorFactoryBeanResult.getMessageInterpolator()
            instanceof LocaleContextMessageInterpolator);
    assertTrue(
        actualValidatorFactoryBeanResult.getConstraintValidatorFactory()
            instanceof SpringConstraintValidatorFactory);
    assertTrue(actualValidatorFactoryBeanResult.getValidationPropertyMap().isEmpty());
  }
}
