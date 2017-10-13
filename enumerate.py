#This program takes an input pattern some permutation containing '1', '0', and '?'
#The program outputs all the possible permutations where '?' can be either '1' or '0'

import copy


def duplicate(str):
    newlist = copy.deepcopy(str)
    str.extend(newlist)

    return str


def enum(str):
    # This function recursively parses a provided str, branching a tree where wildcards are found
    pattern = list(str)
    all = [[]]

    for i in range(pattern.__len__()):
        if pattern[i] == '?':
            all = duplicate(all)
            for j in range(all.__len__()):
                if j < all.__len__() / 2:
                    all[j].extend('1')
                else:
                    all[j].extend('0')




        else:
            for j in range(all.__len__()):
                all[j].append(pattern[i])

    print(all)


# enum('1100', 0)
# enum('1??0?1', 0)
enum('0?1?')
enum('0?1?')
enum('?0111?')
enum('1010')
