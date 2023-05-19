// Licensed to the Apache Software Foundation (ASF) under one
// or more contributor license agreements.  See the NOTICE file
// distributed with this work for additional information
// regarding copyright ownership.  The ASF licenses this file
// to you under the Apache License, Version 2.0 (the
// "License"); you may not use this file except in compliance
// with the License.  You may obtain a copy of the License at
//
//   http://www.apache.org/licenses/LICENSE-2.0
//
// Unless required by applicable law or agreed to in writing,
// software distributed under the License is distributed on an
// "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
// KIND, either express or implied.  See the License for the
// specific language governing permissions and limitations
// under the License.

package org.apache.doris.nereids.pattern;

import org.apache.doris.nereids.analyzer.UnboundOneRowRelation;
import org.apache.doris.nereids.analyzer.UnboundRelation;
import org.apache.doris.nereids.analyzer.UnboundTVFRelation;
import org.apache.doris.nereids.trees.plans.JoinHint;
import org.apache.doris.nereids.trees.plans.JoinType;
import org.apache.doris.nereids.trees.plans.LimitPhase;
import org.apache.doris.nereids.trees.plans.Plan;
import org.apache.doris.nereids.trees.plans.logical.LogicalAggregate;
import org.apache.doris.nereids.trees.plans.logical.LogicalApply;
import org.apache.doris.nereids.trees.plans.logical.LogicalAssertNumRows;
import org.apache.doris.nereids.trees.plans.logical.LogicalCTE;
import org.apache.doris.nereids.trees.plans.logical.LogicalCheckPolicy;
import org.apache.doris.nereids.trees.plans.logical.LogicalEmptyRelation;
import org.apache.doris.nereids.trees.plans.logical.LogicalEsScan;
import org.apache.doris.nereids.trees.plans.logical.LogicalFileScan;
import org.apache.doris.nereids.trees.plans.logical.LogicalFilter;
import org.apache.doris.nereids.trees.plans.logical.LogicalGenerate;
import org.apache.doris.nereids.trees.plans.logical.LogicalHaving;
import org.apache.doris.nereids.trees.plans.logical.LogicalJdbcScan;
import org.apache.doris.nereids.trees.plans.logical.LogicalJoin;
import org.apache.doris.nereids.trees.plans.logical.LogicalLimit;
import org.apache.doris.nereids.trees.plans.logical.LogicalOlapScan;
import org.apache.doris.nereids.trees.plans.logical.LogicalOneRowRelation;
import org.apache.doris.nereids.trees.plans.logical.LogicalProject;
import org.apache.doris.nereids.trees.plans.logical.LogicalRepeat;
import org.apache.doris.nereids.trees.plans.logical.LogicalSchemaScan;
import org.apache.doris.nereids.trees.plans.logical.LogicalSelectHint;
import org.apache.doris.nereids.trees.plans.logical.LogicalSort;
import org.apache.doris.nereids.trees.plans.logical.LogicalSubQueryAlias;
import org.apache.doris.nereids.trees.plans.logical.LogicalTVFRelation;
import org.apache.doris.nereids.trees.plans.logical.LogicalTopN;
import org.apache.doris.nereids.trees.plans.logical.LogicalWindow;
import org.apache.doris.nereids.trees.plans.logical.UsingJoin;
import org.apache.doris.nereids.trees.plans.physical.PhysicalAssertNumRows;
import org.apache.doris.nereids.trees.plans.physical.PhysicalDistribute;
import org.apache.doris.nereids.trees.plans.physical.PhysicalEmptyRelation;
import org.apache.doris.nereids.trees.plans.physical.PhysicalEsScan;
import org.apache.doris.nereids.trees.plans.physical.PhysicalFileScan;
import org.apache.doris.nereids.trees.plans.physical.PhysicalFilter;
import org.apache.doris.nereids.trees.plans.physical.PhysicalGenerate;
import org.apache.doris.nereids.trees.plans.physical.PhysicalHashAggregate;
import org.apache.doris.nereids.trees.plans.physical.PhysicalHashJoin;
import org.apache.doris.nereids.trees.plans.physical.PhysicalJdbcScan;
import org.apache.doris.nereids.trees.plans.physical.PhysicalLimit;
import org.apache.doris.nereids.trees.plans.physical.PhysicalNestedLoopJoin;
import org.apache.doris.nereids.trees.plans.physical.PhysicalOlapScan;
import org.apache.doris.nereids.trees.plans.physical.PhysicalOneRowRelation;
import org.apache.doris.nereids.trees.plans.physical.PhysicalProject;
import org.apache.doris.nereids.trees.plans.physical.PhysicalQuickSort;
import org.apache.doris.nereids.trees.plans.physical.PhysicalRepeat;
import org.apache.doris.nereids.trees.plans.physical.PhysicalSchemaScan;
import org.apache.doris.nereids.trees.plans.physical.PhysicalStorageLayerAggregate;
import org.apache.doris.nereids.trees.plans.physical.PhysicalTVFRelation;
import org.apache.doris.nereids.trees.plans.physical.PhysicalTopN;
import org.apache.doris.nereids.trees.plans.physical.PhysicalWindow;

public interface GeneratedPlanPatterns extends PlanPatterns {
  default PatternDescriptor<LogicalEmptyRelation> logicalEmptyRelation() {
      return new PatternDescriptor<LogicalEmptyRelation>(
          new TypePattern(LogicalEmptyRelation.class),
          defaultPromise()
      );
  }

  default PatternDescriptor<LogicalEsScan> logicalEsScan() {
      return new PatternDescriptor<LogicalEsScan>(
          new TypePattern(LogicalEsScan.class),
          defaultPromise()
      );
  }

  default PatternDescriptor<LogicalFileScan> logicalFileScan() {
      return new PatternDescriptor<LogicalFileScan>(
          new TypePattern(LogicalFileScan.class),
          defaultPromise()
      );
  }

  default PatternDescriptor<LogicalJdbcScan> logicalJdbcScan() {
      return new PatternDescriptor<LogicalJdbcScan>(
          new TypePattern(LogicalJdbcScan.class),
          defaultPromise()
      );
  }

  default PatternDescriptor<LogicalOlapScan> logicalOlapScan() {
      return new PatternDescriptor<LogicalOlapScan>(
          new TypePattern(LogicalOlapScan.class),
          defaultPromise()
      );
  }

  default PatternDescriptor<LogicalOneRowRelation> logicalOneRowRelation() {
      return new PatternDescriptor<LogicalOneRowRelation>(
          new TypePattern(LogicalOneRowRelation.class),
          defaultPromise()
      );
  }

  default PatternDescriptor<LogicalSchemaScan> logicalSchemaScan() {
      return new PatternDescriptor<LogicalSchemaScan>(
          new TypePattern(LogicalSchemaScan.class),
          defaultPromise()
      );
  }

  default PatternDescriptor<LogicalTVFRelation> logicalTVFRelation() {
      return new PatternDescriptor<LogicalTVFRelation>(
          new TypePattern(LogicalTVFRelation.class),
          defaultPromise()
      );
  }

  default PatternDescriptor<UnboundOneRowRelation> unboundOneRowRelation() {
      return new PatternDescriptor<UnboundOneRowRelation>(
          new TypePattern(UnboundOneRowRelation.class),
          defaultPromise()
      );
  }

  default PatternDescriptor<UnboundRelation> unboundRelation() {
      return new PatternDescriptor<UnboundRelation>(
          new TypePattern(UnboundRelation.class),
          defaultPromise()
      );
  }

  default PatternDescriptor<UnboundTVFRelation> unboundTVFRelation() {
      return new PatternDescriptor<UnboundTVFRelation>(
          new TypePattern(UnboundTVFRelation.class),
          defaultPromise()
      );
  }

  default PatternDescriptor<LogicalAggregate<Plan>> logicalAggregate() {
      return new PatternDescriptor<LogicalAggregate<Plan>>(
          new TypePattern(LogicalAggregate.class, Pattern.ANY),
          defaultPromise()
      );
  }
  
  default <C1 extends Plan>
  PatternDescriptor<LogicalAggregate<C1>>
          logicalAggregate(PatternDescriptor<C1> child1) {
      return new PatternDescriptor<LogicalAggregate<C1>>(
          new TypePattern(LogicalAggregate.class, child1.pattern),
          defaultPromise()
      );
  }

  default PatternDescriptor<LogicalAssertNumRows<Plan>> logicalAssertNumRows() {
      return new PatternDescriptor<LogicalAssertNumRows<Plan>>(
          new TypePattern(LogicalAssertNumRows.class, Pattern.ANY),
          defaultPromise()
      );
  }
  
  default <C1 extends Plan>
  PatternDescriptor<LogicalAssertNumRows<C1>>
          logicalAssertNumRows(PatternDescriptor<C1> child1) {
      return new PatternDescriptor<LogicalAssertNumRows<C1>>(
          new TypePattern(LogicalAssertNumRows.class, child1.pattern),
          defaultPromise()
      );
  }

  default PatternDescriptor<LogicalCTE<Plan>> logicalCTE() {
      return new PatternDescriptor<LogicalCTE<Plan>>(
          new TypePattern(LogicalCTE.class, Pattern.ANY),
          defaultPromise()
      );
  }
  
  default <C1 extends Plan>
  PatternDescriptor<LogicalCTE<C1>>
          logicalCTE(PatternDescriptor<C1> child1) {
      return new PatternDescriptor<LogicalCTE<C1>>(
          new TypePattern(LogicalCTE.class, child1.pattern),
          defaultPromise()
      );
  }

  default PatternDescriptor<LogicalCheckPolicy<Plan>> logicalCheckPolicy() {
      return new PatternDescriptor<LogicalCheckPolicy<Plan>>(
          new TypePattern(LogicalCheckPolicy.class, Pattern.ANY),
          defaultPromise()
      );
  }
  
  default <C1 extends Plan>
  PatternDescriptor<LogicalCheckPolicy<C1>>
          logicalCheckPolicy(PatternDescriptor<C1> child1) {
      return new PatternDescriptor<LogicalCheckPolicy<C1>>(
          new TypePattern(LogicalCheckPolicy.class, child1.pattern),
          defaultPromise()
      );
  }

  default PatternDescriptor<LogicalFilter<Plan>> logicalFilter() {
      return new PatternDescriptor<LogicalFilter<Plan>>(
          new TypePattern(LogicalFilter.class, Pattern.ANY),
          defaultPromise()
      );
  }
  
  default <C1 extends Plan>
  PatternDescriptor<LogicalFilter<C1>>
          logicalFilter(PatternDescriptor<C1> child1) {
      return new PatternDescriptor<LogicalFilter<C1>>(
          new TypePattern(LogicalFilter.class, child1.pattern),
          defaultPromise()
      );
  }

  default PatternDescriptor<LogicalGenerate<Plan>> logicalGenerate() {
      return new PatternDescriptor<LogicalGenerate<Plan>>(
          new TypePattern(LogicalGenerate.class, Pattern.ANY),
          defaultPromise()
      );
  }
  
  default <C1 extends Plan>
  PatternDescriptor<LogicalGenerate<C1>>
          logicalGenerate(PatternDescriptor<C1> child1) {
      return new PatternDescriptor<LogicalGenerate<C1>>(
          new TypePattern(LogicalGenerate.class, child1.pattern),
          defaultPromise()
      );
  }

  default PatternDescriptor<LogicalHaving<Plan>> logicalHaving() {
      return new PatternDescriptor<LogicalHaving<Plan>>(
          new TypePattern(LogicalHaving.class, Pattern.ANY),
          defaultPromise()
      );
  }
  
  default <C1 extends Plan>
  PatternDescriptor<LogicalHaving<C1>>
          logicalHaving(PatternDescriptor<C1> child1) {
      return new PatternDescriptor<LogicalHaving<C1>>(
          new TypePattern(LogicalHaving.class, child1.pattern),
          defaultPromise()
      );
  }

  default PatternDescriptor<LogicalLimit<Plan>> logicalLimit() {
      return new PatternDescriptor<LogicalLimit<Plan>>(
          new TypePattern(LogicalLimit.class, Pattern.ANY),
          defaultPromise()
      );
  }
  
  default <C1 extends Plan>
  PatternDescriptor<LogicalLimit<C1>>
          logicalLimit(PatternDescriptor<C1> child1) {
      return new PatternDescriptor<LogicalLimit<C1>>(
          new TypePattern(LogicalLimit.class, child1.pattern),
          defaultPromise()
      );
  }
  
  default PatternDescriptor<LogicalLimit<Plan>> localLogicalLimit() {
      return new PatternDescriptor<LogicalLimit<Plan>>(
          new TypePattern(LogicalLimit.class, Pattern.ANY),
          defaultPromise()
      ).when(p -> p.getPhase() == LimitPhase.LOCAL);
  }
  
  default <C1 extends Plan>
  PatternDescriptor<LogicalLimit<C1>>
          localLogicalLimit(PatternDescriptor<C1> child1) {
      return new PatternDescriptor<LogicalLimit<C1>>(
          new TypePattern(LogicalLimit.class, child1.pattern),
          defaultPromise()
      ).when(p -> p.getPhase() == LimitPhase.LOCAL);
  }
  
  default PatternDescriptor<LogicalLimit<Plan>> globalLogicalLimit() {
      return new PatternDescriptor<LogicalLimit<Plan>>(
          new TypePattern(LogicalLimit.class, Pattern.ANY),
          defaultPromise()
      ).when(p -> p.getPhase() == LimitPhase.GLOBAL);
  }
  
  default <C1 extends Plan>
  PatternDescriptor<LogicalLimit<C1>>
          globalLogicalLimit(PatternDescriptor<C1> child1) {
      return new PatternDescriptor<LogicalLimit<C1>>(
          new TypePattern(LogicalLimit.class, child1.pattern),
          defaultPromise()
      ).when(p -> p.getPhase() == LimitPhase.GLOBAL);
  }
  
  default PatternDescriptor<LogicalLimit<Plan>> originLogicalLimit() {
      return new PatternDescriptor<LogicalLimit<Plan>>(
          new TypePattern(LogicalLimit.class, Pattern.ANY),
          defaultPromise()
      ).when(p -> p.getPhase() == LimitPhase.ORIGIN);
  }
  
  default <C1 extends Plan>
  PatternDescriptor<LogicalLimit<C1>>
          originLogicalLimit(PatternDescriptor<C1> child1) {
      return new PatternDescriptor<LogicalLimit<C1>>(
          new TypePattern(LogicalLimit.class, child1.pattern),
          defaultPromise()
      ).when(p -> p.getPhase() == LimitPhase.ORIGIN);
  }

  default PatternDescriptor<LogicalProject<Plan>> logicalProject() {
      return new PatternDescriptor<LogicalProject<Plan>>(
          new TypePattern(LogicalProject.class, Pattern.ANY),
          defaultPromise()
      );
  }
  
  default <C1 extends Plan>
  PatternDescriptor<LogicalProject<C1>>
          logicalProject(PatternDescriptor<C1> child1) {
      return new PatternDescriptor<LogicalProject<C1>>(
          new TypePattern(LogicalProject.class, child1.pattern),
          defaultPromise()
      );
  }

  default PatternDescriptor<LogicalRepeat<Plan>> logicalRepeat() {
      return new PatternDescriptor<LogicalRepeat<Plan>>(
          new TypePattern(LogicalRepeat.class, Pattern.ANY),
          defaultPromise()
      );
  }
  
  default <C1 extends Plan>
  PatternDescriptor<LogicalRepeat<C1>>
          logicalRepeat(PatternDescriptor<C1> child1) {
      return new PatternDescriptor<LogicalRepeat<C1>>(
          new TypePattern(LogicalRepeat.class, child1.pattern),
          defaultPromise()
      );
  }

  default PatternDescriptor<LogicalSelectHint<Plan>> logicalSelectHint() {
      return new PatternDescriptor<LogicalSelectHint<Plan>>(
          new TypePattern(LogicalSelectHint.class, Pattern.ANY),
          defaultPromise()
      );
  }
  
  default <C1 extends Plan>
  PatternDescriptor<LogicalSelectHint<C1>>
          logicalSelectHint(PatternDescriptor<C1> child1) {
      return new PatternDescriptor<LogicalSelectHint<C1>>(
          new TypePattern(LogicalSelectHint.class, child1.pattern),
          defaultPromise()
      );
  }

  default PatternDescriptor<LogicalSort<Plan>> logicalSort() {
      return new PatternDescriptor<LogicalSort<Plan>>(
          new TypePattern(LogicalSort.class, Pattern.ANY),
          defaultPromise()
      );
  }
  
  default <C1 extends Plan>
  PatternDescriptor<LogicalSort<C1>>
          logicalSort(PatternDescriptor<C1> child1) {
      return new PatternDescriptor<LogicalSort<C1>>(
          new TypePattern(LogicalSort.class, child1.pattern),
          defaultPromise()
      );
  }

  default PatternDescriptor<LogicalSubQueryAlias<Plan>> logicalSubQueryAlias() {
      return new PatternDescriptor<LogicalSubQueryAlias<Plan>>(
          new TypePattern(LogicalSubQueryAlias.class, Pattern.ANY),
          defaultPromise()
      );
  }
  
  default <C1 extends Plan>
  PatternDescriptor<LogicalSubQueryAlias<C1>>
          logicalSubQueryAlias(PatternDescriptor<C1> child1) {
      return new PatternDescriptor<LogicalSubQueryAlias<C1>>(
          new TypePattern(LogicalSubQueryAlias.class, child1.pattern),
          defaultPromise()
      );
  }

  default PatternDescriptor<LogicalTopN<Plan>> logicalTopN() {
      return new PatternDescriptor<LogicalTopN<Plan>>(
          new TypePattern(LogicalTopN.class, Pattern.ANY),
          defaultPromise()
      );
  }
  
  default <C1 extends Plan>
  PatternDescriptor<LogicalTopN<C1>>
          logicalTopN(PatternDescriptor<C1> child1) {
      return new PatternDescriptor<LogicalTopN<C1>>(
          new TypePattern(LogicalTopN.class, child1.pattern),
          defaultPromise()
      );
  }

  default PatternDescriptor<LogicalWindow<Plan>> logicalWindow() {
      return new PatternDescriptor<LogicalWindow<Plan>>(
          new TypePattern(LogicalWindow.class, Pattern.ANY),
          defaultPromise()
      );
  }
  
  default <C1 extends Plan>
  PatternDescriptor<LogicalWindow<C1>>
          logicalWindow(PatternDescriptor<C1> child1) {
      return new PatternDescriptor<LogicalWindow<C1>>(
          new TypePattern(LogicalWindow.class, child1.pattern),
          defaultPromise()
      );
  }

  default PatternDescriptor<LogicalApply<Plan, Plan>> logicalApply() {
      return new PatternDescriptor<LogicalApply<Plan, Plan>>(
          new TypePattern(LogicalApply.class, Pattern.ANY, Pattern.ANY),
          defaultPromise()
      );
  }
  
  default <C1 extends Plan, C2 extends Plan>
  PatternDescriptor<LogicalApply<C1, C2>>
          logicalApply(PatternDescriptor<C1> child1, PatternDescriptor<C2> child2) {
      return new PatternDescriptor<LogicalApply<C1, C2>>(
          new TypePattern(LogicalApply.class, child1.pattern, child2.pattern),
          defaultPromise()
      );
  }

  default PatternDescriptor<LogicalJoin<Plan, Plan>> logicalJoin() {
      return new PatternDescriptor<LogicalJoin<Plan, Plan>>(
          new TypePattern(LogicalJoin.class, Pattern.ANY, Pattern.ANY),
          defaultPromise()
      );
  }
  
  default <C1 extends Plan, C2 extends Plan>
  PatternDescriptor<LogicalJoin<C1, C2>>
          logicalJoin(PatternDescriptor<C1> child1, PatternDescriptor<C2> child2) {
      return new PatternDescriptor<LogicalJoin<C1, C2>>(
          new TypePattern(LogicalJoin.class, child1.pattern, child2.pattern),
          defaultPromise()
      );
  }
  
  default PatternDescriptor<LogicalJoin<Plan, Plan>> innerLogicalJoin() {
      return new PatternDescriptor<LogicalJoin<Plan, Plan>>(
          new TypePattern(LogicalJoin.class, Pattern.ANY, Pattern.ANY),
          defaultPromise()
      ).when(p -> p.getJoinType() == JoinType.INNER_JOIN);
  }
  
  default <C1 extends Plan, C2 extends Plan>
  PatternDescriptor<LogicalJoin<C1, C2>>
          innerLogicalJoin(PatternDescriptor<C1> child1, PatternDescriptor<C2> child2) {
      return new PatternDescriptor<LogicalJoin<C1, C2>>(
          new TypePattern(LogicalJoin.class, child1.pattern, child2.pattern),
          defaultPromise()
      ).when(p -> p.getJoinType() == JoinType.INNER_JOIN);
  }
  
  default PatternDescriptor<LogicalJoin<Plan, Plan>> leftOuterLogicalJoin() {
      return new PatternDescriptor<LogicalJoin<Plan, Plan>>(
          new TypePattern(LogicalJoin.class, Pattern.ANY, Pattern.ANY),
          defaultPromise()
      ).when(p -> p.getJoinType() == JoinType.LEFT_OUTER_JOIN);
  }
  
  default <C1 extends Plan, C2 extends Plan>
  PatternDescriptor<LogicalJoin<C1, C2>>
          leftOuterLogicalJoin(PatternDescriptor<C1> child1, PatternDescriptor<C2> child2) {
      return new PatternDescriptor<LogicalJoin<C1, C2>>(
          new TypePattern(LogicalJoin.class, child1.pattern, child2.pattern),
          defaultPromise()
      ).when(p -> p.getJoinType() == JoinType.LEFT_OUTER_JOIN);
  }
  
  default PatternDescriptor<LogicalJoin<Plan, Plan>> rightOuterLogicalJoin() {
      return new PatternDescriptor<LogicalJoin<Plan, Plan>>(
          new TypePattern(LogicalJoin.class, Pattern.ANY, Pattern.ANY),
          defaultPromise()
      ).when(p -> p.getJoinType() == JoinType.RIGHT_OUTER_JOIN);
  }
  
  default <C1 extends Plan, C2 extends Plan>
  PatternDescriptor<LogicalJoin<C1, C2>>
          rightOuterLogicalJoin(PatternDescriptor<C1> child1, PatternDescriptor<C2> child2) {
      return new PatternDescriptor<LogicalJoin<C1, C2>>(
          new TypePattern(LogicalJoin.class, child1.pattern, child2.pattern),
          defaultPromise()
      ).when(p -> p.getJoinType() == JoinType.RIGHT_OUTER_JOIN);
  }
  
  default PatternDescriptor<LogicalJoin<Plan, Plan>> fullOuterLogicalJoin() {
      return new PatternDescriptor<LogicalJoin<Plan, Plan>>(
          new TypePattern(LogicalJoin.class, Pattern.ANY, Pattern.ANY),
          defaultPromise()
      ).when(p -> p.getJoinType() == JoinType.FULL_OUTER_JOIN);
  }
  
  default <C1 extends Plan, C2 extends Plan>
  PatternDescriptor<LogicalJoin<C1, C2>>
          fullOuterLogicalJoin(PatternDescriptor<C1> child1, PatternDescriptor<C2> child2) {
      return new PatternDescriptor<LogicalJoin<C1, C2>>(
          new TypePattern(LogicalJoin.class, child1.pattern, child2.pattern),
          defaultPromise()
      ).when(p -> p.getJoinType() == JoinType.FULL_OUTER_JOIN);
  }
  
  default PatternDescriptor<LogicalJoin<Plan, Plan>> leftSemiLogicalJoin() {
      return new PatternDescriptor<LogicalJoin<Plan, Plan>>(
          new TypePattern(LogicalJoin.class, Pattern.ANY, Pattern.ANY),
          defaultPromise()
      ).when(p -> p.getJoinType() == JoinType.LEFT_SEMI_JOIN);
  }
  
  default <C1 extends Plan, C2 extends Plan>
  PatternDescriptor<LogicalJoin<C1, C2>>
          leftSemiLogicalJoin(PatternDescriptor<C1> child1, PatternDescriptor<C2> child2) {
      return new PatternDescriptor<LogicalJoin<C1, C2>>(
          new TypePattern(LogicalJoin.class, child1.pattern, child2.pattern),
          defaultPromise()
      ).when(p -> p.getJoinType() == JoinType.LEFT_SEMI_JOIN);
  }
  
  default PatternDescriptor<LogicalJoin<Plan, Plan>> rightSemiLogicalJoin() {
      return new PatternDescriptor<LogicalJoin<Plan, Plan>>(
          new TypePattern(LogicalJoin.class, Pattern.ANY, Pattern.ANY),
          defaultPromise()
      ).when(p -> p.getJoinType() == JoinType.RIGHT_SEMI_JOIN);
  }
  
  default <C1 extends Plan, C2 extends Plan>
  PatternDescriptor<LogicalJoin<C1, C2>>
          rightSemiLogicalJoin(PatternDescriptor<C1> child1, PatternDescriptor<C2> child2) {
      return new PatternDescriptor<LogicalJoin<C1, C2>>(
          new TypePattern(LogicalJoin.class, child1.pattern, child2.pattern),
          defaultPromise()
      ).when(p -> p.getJoinType() == JoinType.RIGHT_SEMI_JOIN);
  }
  
  default PatternDescriptor<LogicalJoin<Plan, Plan>> leftAntiLogicalJoin() {
      return new PatternDescriptor<LogicalJoin<Plan, Plan>>(
          new TypePattern(LogicalJoin.class, Pattern.ANY, Pattern.ANY),
          defaultPromise()
      ).when(p -> p.getJoinType() == JoinType.LEFT_ANTI_JOIN);
  }
  
  default <C1 extends Plan, C2 extends Plan>
  PatternDescriptor<LogicalJoin<C1, C2>>
          leftAntiLogicalJoin(PatternDescriptor<C1> child1, PatternDescriptor<C2> child2) {
      return new PatternDescriptor<LogicalJoin<C1, C2>>(
          new TypePattern(LogicalJoin.class, child1.pattern, child2.pattern),
          defaultPromise()
      ).when(p -> p.getJoinType() == JoinType.LEFT_ANTI_JOIN);
  }
  
  default PatternDescriptor<LogicalJoin<Plan, Plan>> rightAntiLogicalJoin() {
      return new PatternDescriptor<LogicalJoin<Plan, Plan>>(
          new TypePattern(LogicalJoin.class, Pattern.ANY, Pattern.ANY),
          defaultPromise()
      ).when(p -> p.getJoinType() == JoinType.RIGHT_ANTI_JOIN);
  }
  
  default <C1 extends Plan, C2 extends Plan>
  PatternDescriptor<LogicalJoin<C1, C2>>
          rightAntiLogicalJoin(PatternDescriptor<C1> child1, PatternDescriptor<C2> child2) {
      return new PatternDescriptor<LogicalJoin<C1, C2>>(
          new TypePattern(LogicalJoin.class, child1.pattern, child2.pattern),
          defaultPromise()
      ).when(p -> p.getJoinType() == JoinType.RIGHT_ANTI_JOIN);
  }
  
  default PatternDescriptor<LogicalJoin<Plan, Plan>> crossLogicalJoin() {
      return new PatternDescriptor<LogicalJoin<Plan, Plan>>(
          new TypePattern(LogicalJoin.class, Pattern.ANY, Pattern.ANY),
          defaultPromise()
      ).when(p -> p.getJoinType() == JoinType.CROSS_JOIN);
  }
  
  default <C1 extends Plan, C2 extends Plan>
  PatternDescriptor<LogicalJoin<C1, C2>>
          crossLogicalJoin(PatternDescriptor<C1> child1, PatternDescriptor<C2> child2) {
      return new PatternDescriptor<LogicalJoin<C1, C2>>(
          new TypePattern(LogicalJoin.class, child1.pattern, child2.pattern),
          defaultPromise()
      ).when(p -> p.getJoinType() == JoinType.CROSS_JOIN);
  }
  
  default PatternDescriptor<LogicalJoin<Plan, Plan>> nullAwareLeftAntiLogicalJoin() {
      return new PatternDescriptor<LogicalJoin<Plan, Plan>>(
          new TypePattern(LogicalJoin.class, Pattern.ANY, Pattern.ANY),
          defaultPromise()
      ).when(p -> p.getJoinType() == JoinType.NULL_AWARE_LEFT_ANTI_JOIN);
  }
  
  default <C1 extends Plan, C2 extends Plan>
  PatternDescriptor<LogicalJoin<C1, C2>>
          nullAwareLeftAntiLogicalJoin(PatternDescriptor<C1> child1, PatternDescriptor<C2> child2) {
      return new PatternDescriptor<LogicalJoin<C1, C2>>(
          new TypePattern(LogicalJoin.class, child1.pattern, child2.pattern),
          defaultPromise()
      ).when(p -> p.getJoinType() == JoinType.NULL_AWARE_LEFT_ANTI_JOIN);
  }
  
  default PatternDescriptor<LogicalJoin<Plan, Plan>> noneLogicalJoin() {
      return new PatternDescriptor<LogicalJoin<Plan, Plan>>(
          new TypePattern(LogicalJoin.class, Pattern.ANY, Pattern.ANY),
          defaultPromise()
      ).when(p -> p.getHint() == JoinHint.NONE);
  }
  
  default <C1 extends Plan, C2 extends Plan>
  PatternDescriptor<LogicalJoin<C1, C2>>
          noneLogicalJoin(PatternDescriptor<C1> child1, PatternDescriptor<C2> child2) {
      return new PatternDescriptor<LogicalJoin<C1, C2>>(
          new TypePattern(LogicalJoin.class, child1.pattern, child2.pattern),
          defaultPromise()
      ).when(p -> p.getHint() == JoinHint.NONE);
  }
  
  default PatternDescriptor<LogicalJoin<Plan, Plan>> broadcastRightLogicalJoin() {
      return new PatternDescriptor<LogicalJoin<Plan, Plan>>(
          new TypePattern(LogicalJoin.class, Pattern.ANY, Pattern.ANY),
          defaultPromise()
      ).when(p -> p.getHint() == JoinHint.BROADCAST_RIGHT);
  }
  
  default <C1 extends Plan, C2 extends Plan>
  PatternDescriptor<LogicalJoin<C1, C2>>
          broadcastRightLogicalJoin(PatternDescriptor<C1> child1, PatternDescriptor<C2> child2) {
      return new PatternDescriptor<LogicalJoin<C1, C2>>(
          new TypePattern(LogicalJoin.class, child1.pattern, child2.pattern),
          defaultPromise()
      ).when(p -> p.getHint() == JoinHint.BROADCAST_RIGHT);
  }
  
  default PatternDescriptor<LogicalJoin<Plan, Plan>> shuffleRightLogicalJoin() {
      return new PatternDescriptor<LogicalJoin<Plan, Plan>>(
          new TypePattern(LogicalJoin.class, Pattern.ANY, Pattern.ANY),
          defaultPromise()
      ).when(p -> p.getHint() == JoinHint.SHUFFLE_RIGHT);
  }
  
  default <C1 extends Plan, C2 extends Plan>
  PatternDescriptor<LogicalJoin<C1, C2>>
          shuffleRightLogicalJoin(PatternDescriptor<C1> child1, PatternDescriptor<C2> child2) {
      return new PatternDescriptor<LogicalJoin<C1, C2>>(
          new TypePattern(LogicalJoin.class, child1.pattern, child2.pattern),
          defaultPromise()
      ).when(p -> p.getHint() == JoinHint.SHUFFLE_RIGHT);
  }

  default PatternDescriptor<UsingJoin<Plan, Plan>> usingJoin() {
      return new PatternDescriptor<UsingJoin<Plan, Plan>>(
          new TypePattern(UsingJoin.class, Pattern.ANY, Pattern.ANY),
          defaultPromise()
      );
  }
  
  default <C1 extends Plan, C2 extends Plan>
  PatternDescriptor<UsingJoin<C1, C2>>
          usingJoin(PatternDescriptor<C1> child1, PatternDescriptor<C2> child2) {
      return new PatternDescriptor<UsingJoin<C1, C2>>(
          new TypePattern(UsingJoin.class, child1.pattern, child2.pattern),
          defaultPromise()
      );
  }
  
  default PatternDescriptor<UsingJoin<Plan, Plan>> innerUsingJoin() {
      return new PatternDescriptor<UsingJoin<Plan, Plan>>(
          new TypePattern(UsingJoin.class, Pattern.ANY, Pattern.ANY),
          defaultPromise()
      ).when(p -> p.getJoinType() == JoinType.INNER_JOIN);
  }
  
  default <C1 extends Plan, C2 extends Plan>
  PatternDescriptor<UsingJoin<C1, C2>>
          innerUsingJoin(PatternDescriptor<C1> child1, PatternDescriptor<C2> child2) {
      return new PatternDescriptor<UsingJoin<C1, C2>>(
          new TypePattern(UsingJoin.class, child1.pattern, child2.pattern),
          defaultPromise()
      ).when(p -> p.getJoinType() == JoinType.INNER_JOIN);
  }
  
  default PatternDescriptor<UsingJoin<Plan, Plan>> leftOuterUsingJoin() {
      return new PatternDescriptor<UsingJoin<Plan, Plan>>(
          new TypePattern(UsingJoin.class, Pattern.ANY, Pattern.ANY),
          defaultPromise()
      ).when(p -> p.getJoinType() == JoinType.LEFT_OUTER_JOIN);
  }
  
  default <C1 extends Plan, C2 extends Plan>
  PatternDescriptor<UsingJoin<C1, C2>>
          leftOuterUsingJoin(PatternDescriptor<C1> child1, PatternDescriptor<C2> child2) {
      return new PatternDescriptor<UsingJoin<C1, C2>>(
          new TypePattern(UsingJoin.class, child1.pattern, child2.pattern),
          defaultPromise()
      ).when(p -> p.getJoinType() == JoinType.LEFT_OUTER_JOIN);
  }
  
  default PatternDescriptor<UsingJoin<Plan, Plan>> rightOuterUsingJoin() {
      return new PatternDescriptor<UsingJoin<Plan, Plan>>(
          new TypePattern(UsingJoin.class, Pattern.ANY, Pattern.ANY),
          defaultPromise()
      ).when(p -> p.getJoinType() == JoinType.RIGHT_OUTER_JOIN);
  }
  
  default <C1 extends Plan, C2 extends Plan>
  PatternDescriptor<UsingJoin<C1, C2>>
          rightOuterUsingJoin(PatternDescriptor<C1> child1, PatternDescriptor<C2> child2) {
      return new PatternDescriptor<UsingJoin<C1, C2>>(
          new TypePattern(UsingJoin.class, child1.pattern, child2.pattern),
          defaultPromise()
      ).when(p -> p.getJoinType() == JoinType.RIGHT_OUTER_JOIN);
  }
  
  default PatternDescriptor<UsingJoin<Plan, Plan>> fullOuterUsingJoin() {
      return new PatternDescriptor<UsingJoin<Plan, Plan>>(
          new TypePattern(UsingJoin.class, Pattern.ANY, Pattern.ANY),
          defaultPromise()
      ).when(p -> p.getJoinType() == JoinType.FULL_OUTER_JOIN);
  }
  
  default <C1 extends Plan, C2 extends Plan>
  PatternDescriptor<UsingJoin<C1, C2>>
          fullOuterUsingJoin(PatternDescriptor<C1> child1, PatternDescriptor<C2> child2) {
      return new PatternDescriptor<UsingJoin<C1, C2>>(
          new TypePattern(UsingJoin.class, child1.pattern, child2.pattern),
          defaultPromise()
      ).when(p -> p.getJoinType() == JoinType.FULL_OUTER_JOIN);
  }
  
  default PatternDescriptor<UsingJoin<Plan, Plan>> leftSemiUsingJoin() {
      return new PatternDescriptor<UsingJoin<Plan, Plan>>(
          new TypePattern(UsingJoin.class, Pattern.ANY, Pattern.ANY),
          defaultPromise()
      ).when(p -> p.getJoinType() == JoinType.LEFT_SEMI_JOIN);
  }
  
  default <C1 extends Plan, C2 extends Plan>
  PatternDescriptor<UsingJoin<C1, C2>>
          leftSemiUsingJoin(PatternDescriptor<C1> child1, PatternDescriptor<C2> child2) {
      return new PatternDescriptor<UsingJoin<C1, C2>>(
          new TypePattern(UsingJoin.class, child1.pattern, child2.pattern),
          defaultPromise()
      ).when(p -> p.getJoinType() == JoinType.LEFT_SEMI_JOIN);
  }
  
  default PatternDescriptor<UsingJoin<Plan, Plan>> rightSemiUsingJoin() {
      return new PatternDescriptor<UsingJoin<Plan, Plan>>(
          new TypePattern(UsingJoin.class, Pattern.ANY, Pattern.ANY),
          defaultPromise()
      ).when(p -> p.getJoinType() == JoinType.RIGHT_SEMI_JOIN);
  }
  
  default <C1 extends Plan, C2 extends Plan>
  PatternDescriptor<UsingJoin<C1, C2>>
          rightSemiUsingJoin(PatternDescriptor<C1> child1, PatternDescriptor<C2> child2) {
      return new PatternDescriptor<UsingJoin<C1, C2>>(
          new TypePattern(UsingJoin.class, child1.pattern, child2.pattern),
          defaultPromise()
      ).when(p -> p.getJoinType() == JoinType.RIGHT_SEMI_JOIN);
  }
  
  default PatternDescriptor<UsingJoin<Plan, Plan>> leftAntiUsingJoin() {
      return new PatternDescriptor<UsingJoin<Plan, Plan>>(
          new TypePattern(UsingJoin.class, Pattern.ANY, Pattern.ANY),
          defaultPromise()
      ).when(p -> p.getJoinType() == JoinType.LEFT_ANTI_JOIN);
  }
  
  default <C1 extends Plan, C2 extends Plan>
  PatternDescriptor<UsingJoin<C1, C2>>
          leftAntiUsingJoin(PatternDescriptor<C1> child1, PatternDescriptor<C2> child2) {
      return new PatternDescriptor<UsingJoin<C1, C2>>(
          new TypePattern(UsingJoin.class, child1.pattern, child2.pattern),
          defaultPromise()
      ).when(p -> p.getJoinType() == JoinType.LEFT_ANTI_JOIN);
  }
  
  default PatternDescriptor<UsingJoin<Plan, Plan>> rightAntiUsingJoin() {
      return new PatternDescriptor<UsingJoin<Plan, Plan>>(
          new TypePattern(UsingJoin.class, Pattern.ANY, Pattern.ANY),
          defaultPromise()
      ).when(p -> p.getJoinType() == JoinType.RIGHT_ANTI_JOIN);
  }
  
  default <C1 extends Plan, C2 extends Plan>
  PatternDescriptor<UsingJoin<C1, C2>>
          rightAntiUsingJoin(PatternDescriptor<C1> child1, PatternDescriptor<C2> child2) {
      return new PatternDescriptor<UsingJoin<C1, C2>>(
          new TypePattern(UsingJoin.class, child1.pattern, child2.pattern),
          defaultPromise()
      ).when(p -> p.getJoinType() == JoinType.RIGHT_ANTI_JOIN);
  }
  
  default PatternDescriptor<UsingJoin<Plan, Plan>> crossUsingJoin() {
      return new PatternDescriptor<UsingJoin<Plan, Plan>>(
          new TypePattern(UsingJoin.class, Pattern.ANY, Pattern.ANY),
          defaultPromise()
      ).when(p -> p.getJoinType() == JoinType.CROSS_JOIN);
  }
  
  default <C1 extends Plan, C2 extends Plan>
  PatternDescriptor<UsingJoin<C1, C2>>
          crossUsingJoin(PatternDescriptor<C1> child1, PatternDescriptor<C2> child2) {
      return new PatternDescriptor<UsingJoin<C1, C2>>(
          new TypePattern(UsingJoin.class, child1.pattern, child2.pattern),
          defaultPromise()
      ).when(p -> p.getJoinType() == JoinType.CROSS_JOIN);
  }
  
  default PatternDescriptor<UsingJoin<Plan, Plan>> nullAwareLeftAntiUsingJoin() {
      return new PatternDescriptor<UsingJoin<Plan, Plan>>(
          new TypePattern(UsingJoin.class, Pattern.ANY, Pattern.ANY),
          defaultPromise()
      ).when(p -> p.getJoinType() == JoinType.NULL_AWARE_LEFT_ANTI_JOIN);
  }
  
  default <C1 extends Plan, C2 extends Plan>
  PatternDescriptor<UsingJoin<C1, C2>>
          nullAwareLeftAntiUsingJoin(PatternDescriptor<C1> child1, PatternDescriptor<C2> child2) {
      return new PatternDescriptor<UsingJoin<C1, C2>>(
          new TypePattern(UsingJoin.class, child1.pattern, child2.pattern),
          defaultPromise()
      ).when(p -> p.getJoinType() == JoinType.NULL_AWARE_LEFT_ANTI_JOIN);
  }
  
  default PatternDescriptor<UsingJoin<Plan, Plan>> noneUsingJoin() {
      return new PatternDescriptor<UsingJoin<Plan, Plan>>(
          new TypePattern(UsingJoin.class, Pattern.ANY, Pattern.ANY),
          defaultPromise()
      ).when(p -> p.getHint() == JoinHint.NONE);
  }
  
  default <C1 extends Plan, C2 extends Plan>
  PatternDescriptor<UsingJoin<C1, C2>>
          noneUsingJoin(PatternDescriptor<C1> child1, PatternDescriptor<C2> child2) {
      return new PatternDescriptor<UsingJoin<C1, C2>>(
          new TypePattern(UsingJoin.class, child1.pattern, child2.pattern),
          defaultPromise()
      ).when(p -> p.getHint() == JoinHint.NONE);
  }
  
  default PatternDescriptor<UsingJoin<Plan, Plan>> broadcastRightUsingJoin() {
      return new PatternDescriptor<UsingJoin<Plan, Plan>>(
          new TypePattern(UsingJoin.class, Pattern.ANY, Pattern.ANY),
          defaultPromise()
      ).when(p -> p.getHint() == JoinHint.BROADCAST_RIGHT);
  }
  
  default <C1 extends Plan, C2 extends Plan>
  PatternDescriptor<UsingJoin<C1, C2>>
          broadcastRightUsingJoin(PatternDescriptor<C1> child1, PatternDescriptor<C2> child2) {
      return new PatternDescriptor<UsingJoin<C1, C2>>(
          new TypePattern(UsingJoin.class, child1.pattern, child2.pattern),
          defaultPromise()
      ).when(p -> p.getHint() == JoinHint.BROADCAST_RIGHT);
  }
  
  default PatternDescriptor<UsingJoin<Plan, Plan>> shuffleRightUsingJoin() {
      return new PatternDescriptor<UsingJoin<Plan, Plan>>(
          new TypePattern(UsingJoin.class, Pattern.ANY, Pattern.ANY),
          defaultPromise()
      ).when(p -> p.getHint() == JoinHint.SHUFFLE_RIGHT);
  }
  
  default <C1 extends Plan, C2 extends Plan>
  PatternDescriptor<UsingJoin<C1, C2>>
          shuffleRightUsingJoin(PatternDescriptor<C1> child1, PatternDescriptor<C2> child2) {
      return new PatternDescriptor<UsingJoin<C1, C2>>(
          new TypePattern(UsingJoin.class, child1.pattern, child2.pattern),
          defaultPromise()
      ).when(p -> p.getHint() == JoinHint.SHUFFLE_RIGHT);
  }

  default PatternDescriptor<PhysicalEmptyRelation> physicalEmptyRelation() {
      return new PatternDescriptor<PhysicalEmptyRelation>(
          new TypePattern(PhysicalEmptyRelation.class),
          defaultPromise()
      );
  }

  default PatternDescriptor<PhysicalEsScan> physicalEsScan() {
      return new PatternDescriptor<PhysicalEsScan>(
          new TypePattern(PhysicalEsScan.class),
          defaultPromise()
      );
  }

  default PatternDescriptor<PhysicalFileScan> physicalFileScan() {
      return new PatternDescriptor<PhysicalFileScan>(
          new TypePattern(PhysicalFileScan.class),
          defaultPromise()
      );
  }

  default PatternDescriptor<PhysicalJdbcScan> physicalJdbcScan() {
      return new PatternDescriptor<PhysicalJdbcScan>(
          new TypePattern(PhysicalJdbcScan.class),
          defaultPromise()
      );
  }

  default PatternDescriptor<PhysicalOlapScan> physicalOlapScan() {
      return new PatternDescriptor<PhysicalOlapScan>(
          new TypePattern(PhysicalOlapScan.class),
          defaultPromise()
      );
  }

  default PatternDescriptor<PhysicalOneRowRelation> physicalOneRowRelation() {
      return new PatternDescriptor<PhysicalOneRowRelation>(
          new TypePattern(PhysicalOneRowRelation.class),
          defaultPromise()
      );
  }

  default PatternDescriptor<PhysicalSchemaScan> physicalSchemaScan() {
      return new PatternDescriptor<PhysicalSchemaScan>(
          new TypePattern(PhysicalSchemaScan.class),
          defaultPromise()
      );
  }

  default PatternDescriptor<PhysicalStorageLayerAggregate> physicalStorageLayerAggregate() {
      return new PatternDescriptor<PhysicalStorageLayerAggregate>(
          new TypePattern(PhysicalStorageLayerAggregate.class),
          defaultPromise()
      );
  }

  default PatternDescriptor<PhysicalTVFRelation> physicalTVFRelation() {
      return new PatternDescriptor<PhysicalTVFRelation>(
          new TypePattern(PhysicalTVFRelation.class),
          defaultPromise()
      );
  }

  default PatternDescriptor<PhysicalAssertNumRows<Plan>> physicalAssertNumRows() {
      return new PatternDescriptor<PhysicalAssertNumRows<Plan>>(
          new TypePattern(PhysicalAssertNumRows.class, Pattern.ANY),
          defaultPromise()
      );
  }
  
  default <C1 extends Plan>
  PatternDescriptor<PhysicalAssertNumRows<C1>>
          physicalAssertNumRows(PatternDescriptor<C1> child1) {
      return new PatternDescriptor<PhysicalAssertNumRows<C1>>(
          new TypePattern(PhysicalAssertNumRows.class, child1.pattern),
          defaultPromise()
      );
  }

  default PatternDescriptor<PhysicalDistribute<Plan>> physicalDistribute() {
      return new PatternDescriptor<PhysicalDistribute<Plan>>(
          new TypePattern(PhysicalDistribute.class, Pattern.ANY),
          defaultPromise()
      );
  }
  
  default <C1 extends Plan>
  PatternDescriptor<PhysicalDistribute<C1>>
          physicalDistribute(PatternDescriptor<C1> child1) {
      return new PatternDescriptor<PhysicalDistribute<C1>>(
          new TypePattern(PhysicalDistribute.class, child1.pattern),
          defaultPromise()
      );
  }

  default PatternDescriptor<PhysicalFilter<Plan>> physicalFilter() {
      return new PatternDescriptor<PhysicalFilter<Plan>>(
          new TypePattern(PhysicalFilter.class, Pattern.ANY),
          defaultPromise()
      );
  }
  
  default <C1 extends Plan>
  PatternDescriptor<PhysicalFilter<C1>>
          physicalFilter(PatternDescriptor<C1> child1) {
      return new PatternDescriptor<PhysicalFilter<C1>>(
          new TypePattern(PhysicalFilter.class, child1.pattern),
          defaultPromise()
      );
  }

  default PatternDescriptor<PhysicalGenerate<Plan>> physicalGenerate() {
      return new PatternDescriptor<PhysicalGenerate<Plan>>(
          new TypePattern(PhysicalGenerate.class, Pattern.ANY),
          defaultPromise()
      );
  }
  
  default <C1 extends Plan>
  PatternDescriptor<PhysicalGenerate<C1>>
          physicalGenerate(PatternDescriptor<C1> child1) {
      return new PatternDescriptor<PhysicalGenerate<C1>>(
          new TypePattern(PhysicalGenerate.class, child1.pattern),
          defaultPromise()
      );
  }

  default PatternDescriptor<PhysicalHashAggregate<Plan>> physicalHashAggregate() {
      return new PatternDescriptor<PhysicalHashAggregate<Plan>>(
          new TypePattern(PhysicalHashAggregate.class, Pattern.ANY),
          defaultPromise()
      );
  }
  
  default <C1 extends Plan>
  PatternDescriptor<PhysicalHashAggregate<C1>>
          physicalHashAggregate(PatternDescriptor<C1> child1) {
      return new PatternDescriptor<PhysicalHashAggregate<C1>>(
          new TypePattern(PhysicalHashAggregate.class, child1.pattern),
          defaultPromise()
      );
  }

  default PatternDescriptor<PhysicalLimit<Plan>> physicalLimit() {
      return new PatternDescriptor<PhysicalLimit<Plan>>(
          new TypePattern(PhysicalLimit.class, Pattern.ANY),
          defaultPromise()
      );
  }
  
  default <C1 extends Plan>
  PatternDescriptor<PhysicalLimit<C1>>
          physicalLimit(PatternDescriptor<C1> child1) {
      return new PatternDescriptor<PhysicalLimit<C1>>(
          new TypePattern(PhysicalLimit.class, child1.pattern),
          defaultPromise()
      );
  }
  
  default PatternDescriptor<PhysicalLimit<Plan>> localPhysicalLimit() {
      return new PatternDescriptor<PhysicalLimit<Plan>>(
          new TypePattern(PhysicalLimit.class, Pattern.ANY),
          defaultPromise()
      ).when(p -> p.getPhase() == LimitPhase.LOCAL);
  }
  
  default <C1 extends Plan>
  PatternDescriptor<PhysicalLimit<C1>>
          localPhysicalLimit(PatternDescriptor<C1> child1) {
      return new PatternDescriptor<PhysicalLimit<C1>>(
          new TypePattern(PhysicalLimit.class, child1.pattern),
          defaultPromise()
      ).when(p -> p.getPhase() == LimitPhase.LOCAL);
  }
  
  default PatternDescriptor<PhysicalLimit<Plan>> globalPhysicalLimit() {
      return new PatternDescriptor<PhysicalLimit<Plan>>(
          new TypePattern(PhysicalLimit.class, Pattern.ANY),
          defaultPromise()
      ).when(p -> p.getPhase() == LimitPhase.GLOBAL);
  }
  
  default <C1 extends Plan>
  PatternDescriptor<PhysicalLimit<C1>>
          globalPhysicalLimit(PatternDescriptor<C1> child1) {
      return new PatternDescriptor<PhysicalLimit<C1>>(
          new TypePattern(PhysicalLimit.class, child1.pattern),
          defaultPromise()
      ).when(p -> p.getPhase() == LimitPhase.GLOBAL);
  }
  
  default PatternDescriptor<PhysicalLimit<Plan>> originPhysicalLimit() {
      return new PatternDescriptor<PhysicalLimit<Plan>>(
          new TypePattern(PhysicalLimit.class, Pattern.ANY),
          defaultPromise()
      ).when(p -> p.getPhase() == LimitPhase.ORIGIN);
  }
  
  default <C1 extends Plan>
  PatternDescriptor<PhysicalLimit<C1>>
          originPhysicalLimit(PatternDescriptor<C1> child1) {
      return new PatternDescriptor<PhysicalLimit<C1>>(
          new TypePattern(PhysicalLimit.class, child1.pattern),
          defaultPromise()
      ).when(p -> p.getPhase() == LimitPhase.ORIGIN);
  }

  default PatternDescriptor<PhysicalProject<Plan>> physicalProject() {
      return new PatternDescriptor<PhysicalProject<Plan>>(
          new TypePattern(PhysicalProject.class, Pattern.ANY),
          defaultPromise()
      );
  }
  
  default <C1 extends Plan>
  PatternDescriptor<PhysicalProject<C1>>
          physicalProject(PatternDescriptor<C1> child1) {
      return new PatternDescriptor<PhysicalProject<C1>>(
          new TypePattern(PhysicalProject.class, child1.pattern),
          defaultPromise()
      );
  }

  default PatternDescriptor<PhysicalQuickSort<Plan>> physicalQuickSort() {
      return new PatternDescriptor<PhysicalQuickSort<Plan>>(
          new TypePattern(PhysicalQuickSort.class, Pattern.ANY),
          defaultPromise()
      );
  }
  
  default <C1 extends Plan>
  PatternDescriptor<PhysicalQuickSort<C1>>
          physicalQuickSort(PatternDescriptor<C1> child1) {
      return new PatternDescriptor<PhysicalQuickSort<C1>>(
          new TypePattern(PhysicalQuickSort.class, child1.pattern),
          defaultPromise()
      );
  }

  default PatternDescriptor<PhysicalRepeat<Plan>> physicalRepeat() {
      return new PatternDescriptor<PhysicalRepeat<Plan>>(
          new TypePattern(PhysicalRepeat.class, Pattern.ANY),
          defaultPromise()
      );
  }
  
  default <C1 extends Plan>
  PatternDescriptor<PhysicalRepeat<C1>>
          physicalRepeat(PatternDescriptor<C1> child1) {
      return new PatternDescriptor<PhysicalRepeat<C1>>(
          new TypePattern(PhysicalRepeat.class, child1.pattern),
          defaultPromise()
      );
  }

  default PatternDescriptor<PhysicalTopN<Plan>> physicalTopN() {
      return new PatternDescriptor<PhysicalTopN<Plan>>(
          new TypePattern(PhysicalTopN.class, Pattern.ANY),
          defaultPromise()
      );
  }
  
  default <C1 extends Plan>
  PatternDescriptor<PhysicalTopN<C1>>
          physicalTopN(PatternDescriptor<C1> child1) {
      return new PatternDescriptor<PhysicalTopN<C1>>(
          new TypePattern(PhysicalTopN.class, child1.pattern),
          defaultPromise()
      );
  }

  default PatternDescriptor<PhysicalWindow<Plan>> physicalWindow() {
      return new PatternDescriptor<PhysicalWindow<Plan>>(
          new TypePattern(PhysicalWindow.class, Pattern.ANY),
          defaultPromise()
      );
  }
  
  default <C1 extends Plan>
  PatternDescriptor<PhysicalWindow<C1>>
          physicalWindow(PatternDescriptor<C1> child1) {
      return new PatternDescriptor<PhysicalWindow<C1>>(
          new TypePattern(PhysicalWindow.class, child1.pattern),
          defaultPromise()
      );
  }

  default PatternDescriptor<PhysicalHashJoin<Plan, Plan>> physicalHashJoin() {
      return new PatternDescriptor<PhysicalHashJoin<Plan, Plan>>(
          new TypePattern(PhysicalHashJoin.class, Pattern.ANY, Pattern.ANY),
          defaultPromise()
      );
  }
  
  default <C1 extends Plan, C2 extends Plan>
  PatternDescriptor<PhysicalHashJoin<C1, C2>>
          physicalHashJoin(PatternDescriptor<C1> child1, PatternDescriptor<C2> child2) {
      return new PatternDescriptor<PhysicalHashJoin<C1, C2>>(
          new TypePattern(PhysicalHashJoin.class, child1.pattern, child2.pattern),
          defaultPromise()
      );
  }

  default PatternDescriptor<PhysicalNestedLoopJoin<Plan, Plan>> physicalNestedLoopJoin() {
      return new PatternDescriptor<PhysicalNestedLoopJoin<Plan, Plan>>(
          new TypePattern(PhysicalNestedLoopJoin.class, Pattern.ANY, Pattern.ANY),
          defaultPromise()
      );
  }
  
  default <C1 extends Plan, C2 extends Plan>
  PatternDescriptor<PhysicalNestedLoopJoin<C1, C2>>
          physicalNestedLoopJoin(PatternDescriptor<C1> child1, PatternDescriptor<C2> child2) {
      return new PatternDescriptor<PhysicalNestedLoopJoin<C1, C2>>(
          new TypePattern(PhysicalNestedLoopJoin.class, child1.pattern, child2.pattern),
          defaultPromise()
      );
  }
}
