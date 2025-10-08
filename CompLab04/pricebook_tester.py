from pricebook import is_sorted, price_average, unsorted_get, unsorted_put, sorted_get, sorted_put
import time

def do_test(output, expected):
    try:
        assert output == expected
        print(f"Output matched expected value! {output}")
    except:
        print(f"Output was {output} but expected value is {expected}")


if __name__ == "__main__":
    print("**** Beginning of Testing ****")
    empty = []
    pb1 = [
        (100.0, "Apple Juice"),
        (91.8, "Jorts"),
        (99.2, "Lingonberry jam"),
        (92.7, "Pepperoni"),
    ]
    pb2 = [
        (88.7, "Red Paint"),
        (65.2, "Newman's Own Salad Dressing"),
        (73.5, "Chewy Granola Bars"),
        (95.6, "Dinosaur Bones (plastic)"),
    ]
    pb3 = [
        (90.0, "Ingredients"),
        (91.9, "Dot matrix Printer"),
        (97.6, "Perfect Parchment Paper"),
        (93.3, "Island Scent Candle"),
    ]
    pb4 = [
        (95.4, "Carton Milk"),
        (68.2, "Kinder Egg"),
        (96.3, "Naan"),
        (84.7, "The best bread I could find"),
    ]
    pb5 = [
        (77.0, "Law books"),
        (86.2, "Alternator for car"),
        (73.4, "Barn (small)"),
        (78.1, "Raddish"),
    ]

    print("\nTesting is_sorted")
    do_test(is_sorted(empty), True)
    do_test(is_sorted(pb1), True)
    do_test(is_sorted(pb2), False)
    new_test = [
        (62.4, "Apple Juice"),
        (42.8, "Apple Pie"),
        (23.6, "Apples"),
        (41.1, "Apple Butter"),
        (89.8, "Apple Sauce"),
    ]
    do_test(is_sorted(new_test), False)
    new_test2 = [
        (62.4, "Lingonberry jam"),
        (42.8, "Basketball"),
        (23.6, "Golf"),
        (41.1, "Table Tennis"),
        (89.8, "Chess"),
    ]
    do_test(is_sorted(new_test2), False)
    new_test3 = [
        (92.7, "Green Pepper"),
        (99.2, "Potato"),
        (91.8, "Perfect Parchment Paper"),
        (100.0, "Tofu"),
    ]
    do_test(is_sorted(pb5), False)
    print("End of all is_sorted tests")

    print("\nTesting price_average")
    do_test(price_average(empty), 0.0)
    do_test(price_average(pb1), 95.925)
    do_test(price_average(pb2), 80.75)
    do_test(price_average(pb3), 93.2)
    do_test(price_average(pb4), 86.15)
    do_test(price_average(pb5), 78.675)
    print("End of all price_average tests")

    print("\nTesting unsorted_get")
    do_test(unsorted_get(empty, "Madhava Grünspan"), None)
    do_test(unsorted_get(pb1, "Lingonberry jam"), 99.2)
    do_test(unsorted_get(pb2, "The best bread I could find"), None)
    do_test(unsorted_get(pb3, "Dot matrix Printer"), 91.9)
    do_test(unsorted_get(pb4, 4), None)
    do_test(unsorted_get(pb5, "Law books"), 77.0)
    do_test(unsorted_get(pb1, "Pepperoni"), 92.7)
    print("End of all unsorted_get tests")

    print("\nTesting unsorted_put")
    pricebook = []
    unsorted_put(pricebook, "Speaker", 92.3)
    do_test(pricebook, [(92.3, 'Speaker')])

    unsorted_put(pricebook, "Speaker", 93.3)
    do_test(pricebook, [(93.3, 'Speaker')])

    unsorted_put(pricebook, "socks", 88.8)
    do_test(pricebook, [(93.3, 'Speaker'), (88.8, 'socks')])

    for x in pb1:
        unsorted_put(pricebook, x[1], x[0])
    do_test(pricebook, [(93.3, 'Speaker'),
                        (88.8, 'socks'),
                        (100.0, "Apple Juice"),
                        (91.8, "Jorts"),
                        (99.2, "Lingonberry jam"),
                        (92.7, "Pepperoni")])
    print("End of all unsorted_get tests")

    empty = []

    print("\nTesting sorted_get")
    do_test(sorted_get(empty, "Matrix"), None)
    do_test(sorted_get(pb1, "Apple Juice"), 100.0)
    do_test(sorted_get(pb1, "Jorts"), 91.8)
    do_test(sorted_get(pb1, "Charger"), None)
    do_test(sorted_get(pb1, "Pepperoni"), 92.7)

    print("** Big sorted_get test **")
    big = []
    for i in range(0, 10000):
        big.append((i, str(i)))
    s = time.time()
    sorted_get(big, "10000")
    e = time.time()
    do_test(e - s < 0.0002, True)


    print("End of all sorted_get tests")

    print("\nTesting sorted_put")
    pricebook = []
    sorted_put(pricebook, "Rib Eyes", 86.2)
    do_test(pricebook, [(86.2, 'Rib Eyes')])
    sorted_put(pricebook, "Yogurt", 81.5)
    do_test(pricebook, [(86.2, 'Rib Eyes'), (81.5, 'Yogurt')])
    sorted_put(pricebook, "Yogurt", 87.5)
    do_test(pricebook, [(86.2, 'Rib Eyes'), (87.5, 'Yogurt')])
    sorted_put(pricebook, "Rice", 65.1)
    do_test(pricebook, [(86.2, 'Rib Eyes'), (65.1, 'Rice'), (87.5, 'Yogurt')])
    sorted_put(pricebook, "Tuna", 93.5)
    do_test(pricebook, [(86.2, 'Rib Eyes'), (65.1, 'Rice'), (93.5, 'Tuna'), (87.5, 'Yogurt')])
    sorted_put(pricebook, "Rib Eyes", 89.6)
    do_test(pricebook, [(89.6, 'Rib Eyes'), (65.1, 'Rice'), (93.5, 'Tuna'), (87.5, 'Yogurt')])
    for x in pb1:
        sorted_put(pricebook, x[1], x[0])
    do_test(pricebook, [(100.0, 'Apple Juice'), (91.8, 'Jorts'),
                        (99.2, 'Lingonberry jam'), (92.7, 'Pepperoni'),
                        (89.6, 'Rib Eyes'), (65.1, 'Rice'), (93.5, 'Tuna'),
                        (87.5, 'Yogurt')])

    print("End of all sorted_put tests")

    print("\n**** End of Testing ****")


