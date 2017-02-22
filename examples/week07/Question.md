Using the notation A <: B to indicate A is a subtype of B and assuming:
A
A >: B

Republican <: Politician <: Person and
aRepub aPol aPerson

Shout <: PoliticianSound <: Sound
aShout APolSound aSound

and a method

def thing(executive: Politician => PoliticianSound) : PoliticianSound =
    val donald = Politician("Donald") 
    executive(donald)
}

// argument to thing

a) A function of type Person => Shout = YES
b) A function of type Republican => Shout = NO
c) A function of type Person => Sound = NO

args - contravariant
return types - covariant

[A]
[+A]
[-A]

// whole method = NO
def meth(p: Politician): PoliticianSound = {
    p.aPerson => aPolSound = NO
}