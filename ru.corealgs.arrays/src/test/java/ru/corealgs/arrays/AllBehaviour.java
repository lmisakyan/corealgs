package ru.corealgs.arrays;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

import ru.corealgs.arrays.buffer.StringBufferBehaviour;

@RunWith(value = Suite.class)
@SuiteClasses(value = { StringBufferBehaviour.class, ArraysBehaviour.class })
public class AllBehaviour {

}
