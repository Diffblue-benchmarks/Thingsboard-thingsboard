package org.thingsboard.server.dao.service.validator;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertThrows;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.MaintainedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.ArrayList;
import java.util.List;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.thingsboard.server.common.data.rule.NodeConnectionInfo;
import org.thingsboard.server.common.data.rule.RuleChainMetaData;
import org.thingsboard.server.common.data.rule.RuleNode;
import org.thingsboard.server.dao.exception.DataValidationException;

public class RuleChainDataValidatorDiffblueTest {
  /**
   * Test {@link RuleChainDataValidator#validateMetaData(RuleChainMetaData)}.
   * <ul>
   *   <li>Given {@link ArrayList#ArrayList()} add {@link RuleNode#RuleNode()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link RuleChainDataValidator#validateMetaData(RuleChainMetaData)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"List RuleChainDataValidator.validateMetaData(RuleChainMetaData)"})
  public void testValidateMetaData_givenArrayListAddRuleNode() {
    // Arrange
    ArrayList<RuleNode> ruleNodeList = new ArrayList<>();
    ruleNodeList.add(new RuleNode());
    RuleChainMetaData ruleChainMetaData = mock(RuleChainMetaData.class);
    when(ruleChainMetaData.getConnections()).thenReturn(new ArrayList<>());
    when(ruleChainMetaData.getNodes()).thenReturn(ruleNodeList);

    // Act
    List<Throwable> actualValidateMetaDataResult = RuleChainDataValidator.validateMetaData(ruleChainMetaData);

    // Assert
    verify(ruleChainMetaData).getConnections();
    verify(ruleChainMetaData).getNodes();
    assertEquals(1, actualValidateMetaDataResult.size());
    Throwable getResult = actualValidateMetaDataResult.get(0);
    assertNull(getResult.getLocalizedMessage());
    assertNull(getResult.getMessage());
    assertNull(getResult.getCause());
    assertEquals(0, getResult.getSuppressed().length);
  }

  /**
   * Test {@link RuleChainDataValidator#validateMetaData(RuleChainMetaData)}.
   * <ul>
   *   <li>Given {@link ArrayList#ArrayList()} add {@link RuleNode#RuleNode(RuleNode)} with ruleNode is {@link RuleNode#RuleNode()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link RuleChainDataValidator#validateMetaData(RuleChainMetaData)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"List RuleChainDataValidator.validateMetaData(RuleChainMetaData)"})
  public void testValidateMetaData_givenArrayListAddRuleNodeWithRuleNodeIsRuleNode() {
    // Arrange
    ArrayList<RuleNode> ruleNodeList = new ArrayList<>();
    ruleNodeList.add(new RuleNode(new RuleNode()));
    RuleChainMetaData ruleChainMetaData = mock(RuleChainMetaData.class);
    when(ruleChainMetaData.getConnections()).thenReturn(new ArrayList<>());
    when(ruleChainMetaData.getNodes()).thenReturn(ruleNodeList);

    // Act
    List<Throwable> actualValidateMetaDataResult = RuleChainDataValidator.validateMetaData(ruleChainMetaData);

    // Assert
    verify(ruleChainMetaData).getConnections();
    verify(ruleChainMetaData).getNodes();
    assertEquals(1, actualValidateMetaDataResult.size());
    Throwable getResult = actualValidateMetaDataResult.get(0);
    assertNull(getResult.getLocalizedMessage());
    assertNull(getResult.getMessage());
    assertNull(getResult.getCause());
    assertEquals(0, getResult.getSuppressed().length);
  }

  /**
   * Test {@link RuleChainDataValidator#validateMetaData(RuleChainMetaData)}.
   * <ul>
   *   <li>Given {@link ArrayList#ArrayList()} add {@link RuleNode#RuleNode()}.</li>
   *   <li>Then return size is two.</li>
   * </ul>
   * <p>
   * Method under test: {@link RuleChainDataValidator#validateMetaData(RuleChainMetaData)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"List RuleChainDataValidator.validateMetaData(RuleChainMetaData)"})
  public void testValidateMetaData_givenArrayListAddRuleNode_thenReturnSizeIsTwo() {
    // Arrange
    ArrayList<RuleNode> ruleNodeList = new ArrayList<>();
    ruleNodeList.add(new RuleNode());
    ruleNodeList.add(new RuleNode());
    RuleChainMetaData ruleChainMetaData = mock(RuleChainMetaData.class);
    when(ruleChainMetaData.getConnections()).thenReturn(new ArrayList<>());
    when(ruleChainMetaData.getNodes()).thenReturn(ruleNodeList);

    // Act
    List<Throwable> actualValidateMetaDataResult = RuleChainDataValidator.validateMetaData(ruleChainMetaData);

    // Assert
    verify(ruleChainMetaData).getConnections();
    verify(ruleChainMetaData).getNodes();
    assertEquals(2, actualValidateMetaDataResult.size());
    Throwable getResult = actualValidateMetaDataResult.get(1);
    assertNull(getResult.getLocalizedMessage());
    assertNull(getResult.getMessage());
    assertNull(getResult.getCause());
  }

  /**
   * Test {@link RuleChainDataValidator#validateMetaData(RuleChainMetaData)}.
   * <ul>
   *   <li>Then return Empty.</li>
   * </ul>
   * <p>
   * Method under test: {@link RuleChainDataValidator#validateMetaData(RuleChainMetaData)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"List RuleChainDataValidator.validateMetaData(RuleChainMetaData)"})
  public void testValidateMetaData_thenReturnEmpty() {
    // Arrange
    RuleChainMetaData ruleChainMetaData = mock(RuleChainMetaData.class);
    when(ruleChainMetaData.getConnections()).thenReturn(new ArrayList<>());
    when(ruleChainMetaData.getNodes()).thenReturn(new ArrayList<>());

    // Act
    List<Throwable> actualValidateMetaDataResult = RuleChainDataValidator.validateMetaData(ruleChainMetaData);

    // Assert
    verify(ruleChainMetaData).getConnections();
    verify(ruleChainMetaData).getNodes();
    assertTrue(actualValidateMetaDataResult.isEmpty());
  }

  /**
   * Test {@link RuleChainDataValidator#validateMetaData(RuleChainMetaData)}.
   * <ul>
   *   <li>Then throw {@link DataValidationException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link RuleChainDataValidator#validateMetaData(RuleChainMetaData)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"List RuleChainDataValidator.validateMetaData(RuleChainMetaData)"})
  public void testValidateMetaData_thenThrowDataValidationException() {
    // Arrange
    NodeConnectionInfo nodeConnectionInfo = new NodeConnectionInfo();
    nodeConnectionInfo.setFromIndex(1);
    nodeConnectionInfo.setToIndex(1);
    nodeConnectionInfo.setType("Type");

    ArrayList<NodeConnectionInfo> connections = new ArrayList<>();
    connections.add(nodeConnectionInfo);

    RuleChainMetaData ruleChainMetaData = new RuleChainMetaData();
    ruleChainMetaData.setConnections(connections);

    // Act and Assert
    assertThrows(DataValidationException.class, () -> RuleChainDataValidator.validateMetaData(ruleChainMetaData));
  }

  /**
   * Test {@link RuleChainDataValidator#validateMetaData(RuleChainMetaData)}.
   * <ul>
   *   <li>When {@link RuleChainMetaData} (default constructor) Nodes is {@link ArrayList#ArrayList()}.</li>
   *   <li>Then return Empty.</li>
   * </ul>
   * <p>
   * Method under test: {@link RuleChainDataValidator#validateMetaData(RuleChainMetaData)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"List RuleChainDataValidator.validateMetaData(RuleChainMetaData)"})
  public void testValidateMetaData_whenRuleChainMetaDataNodesIsArrayList_thenReturnEmpty() {
    // Arrange
    RuleChainMetaData ruleChainMetaData = new RuleChainMetaData();
    ruleChainMetaData.setNodes(new ArrayList<>());

    // Act
    List<Throwable> actualValidateMetaDataResult = RuleChainDataValidator.validateMetaData(ruleChainMetaData);

    // Assert
    assertTrue(actualValidateMetaDataResult.isEmpty());
  }
}
