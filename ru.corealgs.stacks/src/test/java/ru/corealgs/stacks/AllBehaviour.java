package ru.corealgs.stacks;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

import ru.corealgs.stacks.queue.ListQueueBehaviour;
import ru.corealgs.stacks.queue.TwoStackQueueBehaviour;
import ru.corealgs.stacks.stack.DescendingStackBehaviour;
import ru.corealgs.stacks.stack.MinListStackBehaviour;
import ru.corealgs.stacks.stack.MinNodeStackBehaviour;
import ru.corealgs.stacks.towers.TowersBehaviour;

@RunWith(value = Suite.class)
@SuiteClasses(value = { StacksBehaviour.class, ListQueueBehaviour.class,
		TwoStackQueueBehaviour.class, MinListStackBehaviour.class,
		MinNodeStackBehaviour.class, DescendingStackBehaviour.class,
		TowersBehaviour.class })
public class AllBehaviour {

}