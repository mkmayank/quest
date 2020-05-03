package main

import (
	"fmt"
	"io/ioutil"
	"os"
	"strconv"
	"strings"
)

// type seat_type byte

// const (
// 	WS seat_type = '0'
// 	MS seat_type = '1'
// 	AS seat_type = '2'
// )

// func (s seat_type) String() string {
// 	switch s {
// 	case WS:
// 		return fmt.Sprintf("WS")
// 	case MS:
// 		return fmt.Sprintf("MS")
// 	case AS:
// 		return fmt.Sprintf("AS")
// 	default:
// 		return fmt.Sprintf("")
// 	}
// }

// type seat struct {
// 	n int
// 	s seat_type
// }

// func (s seat) String() string {
// 	return fmt.Sprintf("%d %s", s.n, s.s)
// }

// func seat_map() map[int]seat {
// 	m := map[int]seat{}

// 	m[1] = seat{12, WS}
// 	m[2] = seat{11, MS}
// 	m[3] = seat{10, AS}
// 	m[4] = seat{9, AS}
// 	m[5] = seat{8, MS}
// 	m[6] = seat{7, WS}

// 	m[7] = seat{6, WS}
// 	m[8] = seat{5, MS}
// 	m[9] = seat{4, AS}
// 	m[10] = seat{3, AS}
// 	m[11] = seat{2, MS}
// 	m[12] = seat{1, WS}

// 	for i := 1; i < 108/12; i++ {
// 		for j := 1; j <= 12; j++ {
// 			m[j+12*i] = seat{
// 				n: m[j].n + 12*i,
// 				s: m[j].s,
// 			}
// 		}
// 	}

// 	return m
// }

// func seat_map_() map[int]string {

// 	// m := seat_map()
// 	// for i := 1; i <= 108; i++ {
// 	// 	fmt.Printf("%d : \"%s\",\n", i, m[i])
// 	// }

// 	return map[int]string{
// 		1:   "12 WS",
// 		2:   "11 MS",
// 		3:   "10 AS",
// 		4:   "9 AS",
// 		5:   "8 MS",
// 		6:   "7 WS",
// 		7:   "6 WS",
// 		8:   "5 MS",
// 		9:   "4 AS",
// 		10:  "3 AS",
// 		11:  "2 MS",
// 		12:  "1 WS",
// 		13:  "24 WS",
// 		14:  "23 MS",
// 		15:  "22 AS",
// 		16:  "21 AS",
// 		17:  "20 MS",
// 		18:  "19 WS",
// 		19:  "18 WS",
// 		20:  "17 MS",
// 		21:  "16 AS",
// 		22:  "15 AS",
// 		23:  "14 MS",
// 		24:  "13 WS",
// 		25:  "36 WS",
// 		26:  "35 MS",
// 		27:  "34 AS",
// 		28:  "33 AS",
// 		29:  "32 MS",
// 		30:  "31 WS",
// 		31:  "30 WS",
// 		32:  "29 MS",
// 		33:  "28 AS",
// 		34:  "27 AS",
// 		35:  "26 MS",
// 		36:  "25 WS",
// 		37:  "48 WS",
// 		38:  "47 MS",
// 		39:  "46 AS",
// 		40:  "45 AS",
// 		41:  "44 MS",
// 		42:  "43 WS",
// 		43:  "42 WS",
// 		44:  "41 MS",
// 		45:  "40 AS",
// 		46:  "39 AS",
// 		47:  "38 MS",
// 		48:  "37 WS",
// 		49:  "60 WS",
// 		50:  "59 MS",
// 		51:  "58 AS",
// 		52:  "57 AS",
// 		53:  "56 MS",
// 		54:  "55 WS",
// 		55:  "54 WS",
// 		56:  "53 MS",
// 		57:  "52 AS",
// 		58:  "51 AS",
// 		59:  "50 MS",
// 		60:  "49 WS",
// 		61:  "72 WS",
// 		62:  "71 MS",
// 		63:  "70 AS",
// 		64:  "69 AS",
// 		65:  "68 MS",
// 		66:  "67 WS",
// 		67:  "66 WS",
// 		68:  "65 MS",
// 		69:  "64 AS",
// 		70:  "63 AS",
// 		71:  "62 MS",
// 		72:  "61 WS",
// 		73:  "84 WS",
// 		74:  "83 MS",
// 		75:  "82 AS",
// 		76:  "81 AS",
// 		77:  "80 MS",
// 		78:  "79 WS",
// 		79:  "78 WS",
// 		80:  "77 MS",
// 		81:  "76 AS",
// 		82:  "75 AS",
// 		83:  "74 MS",
// 		84:  "73 WS",
// 		85:  "96 WS",
// 		86:  "95 MS",
// 		87:  "94 AS",
// 		88:  "93 AS",
// 		89:  "92 MS",
// 		90:  "91 WS",
// 		91:  "90 WS",
// 		92:  "89 MS",
// 		93:  "88 AS",
// 		94:  "87 AS",
// 		95:  "86 MS",
// 		96:  "85 WS",
// 		97:  "108 WS",
// 		98:  "107 MS",
// 		99:  "106 AS",
// 		100: "105 AS",
// 		101: "104 MS",
// 		102: "103 WS",
// 		103: "102 WS",
// 		104: "101 MS",
// 		105: "100 AS",
// 		106: "99 AS",
// 		107: "98 MS",
// 		108: "97 WS",
// 	}
// }

func main() {

	m := map[int]string{
		1:   "12 WS",
		2:   "11 MS",
		3:   "10 AS",
		4:   "9 AS",
		5:   "8 MS",
		6:   "7 WS",
		7:   "6 WS",
		8:   "5 MS",
		9:   "4 AS",
		10:  "3 AS",
		11:  "2 MS",
		12:  "1 WS",
		13:  "24 WS",
		14:  "23 MS",
		15:  "22 AS",
		16:  "21 AS",
		17:  "20 MS",
		18:  "19 WS",
		19:  "18 WS",
		20:  "17 MS",
		21:  "16 AS",
		22:  "15 AS",
		23:  "14 MS",
		24:  "13 WS",
		25:  "36 WS",
		26:  "35 MS",
		27:  "34 AS",
		28:  "33 AS",
		29:  "32 MS",
		30:  "31 WS",
		31:  "30 WS",
		32:  "29 MS",
		33:  "28 AS",
		34:  "27 AS",
		35:  "26 MS",
		36:  "25 WS",
		37:  "48 WS",
		38:  "47 MS",
		39:  "46 AS",
		40:  "45 AS",
		41:  "44 MS",
		42:  "43 WS",
		43:  "42 WS",
		44:  "41 MS",
		45:  "40 AS",
		46:  "39 AS",
		47:  "38 MS",
		48:  "37 WS",
		49:  "60 WS",
		50:  "59 MS",
		51:  "58 AS",
		52:  "57 AS",
		53:  "56 MS",
		54:  "55 WS",
		55:  "54 WS",
		56:  "53 MS",
		57:  "52 AS",
		58:  "51 AS",
		59:  "50 MS",
		60:  "49 WS",
		61:  "72 WS",
		62:  "71 MS",
		63:  "70 AS",
		64:  "69 AS",
		65:  "68 MS",
		66:  "67 WS",
		67:  "66 WS",
		68:  "65 MS",
		69:  "64 AS",
		70:  "63 AS",
		71:  "62 MS",
		72:  "61 WS",
		73:  "84 WS",
		74:  "83 MS",
		75:  "82 AS",
		76:  "81 AS",
		77:  "80 MS",
		78:  "79 WS",
		79:  "78 WS",
		80:  "77 MS",
		81:  "76 AS",
		82:  "75 AS",
		83:  "74 MS",
		84:  "73 WS",
		85:  "96 WS",
		86:  "95 MS",
		87:  "94 AS",
		88:  "93 AS",
		89:  "92 MS",
		90:  "91 WS",
		91:  "90 WS",
		92:  "89 MS",
		93:  "88 AS",
		94:  "87 AS",
		95:  "86 MS",
		96:  "85 WS",
		97:  "108 WS",
		98:  "107 MS",
		99:  "106 AS",
		100: "105 AS",
		101: "104 MS",
		102: "103 WS",
		103: "102 WS",
		104: "101 MS",
		105: "100 AS",
		106: "99 AS",
		107: "98 MS",
		108: "97 WS",
	}

	bs, _ := ioutil.ReadAll(os.Stdin)
	k := strings.Split(string(bs), "\n")
	for i := 1; i < len(k); i++ {
		n, _ := strconv.Atoi(k[i])
		fmt.Printf("%s\n", m[n])
	}
}
