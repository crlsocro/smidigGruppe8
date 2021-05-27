package com.example.smidig.History

object InfoConstants {
    fun getInfo(): ArrayList<Info>{
        val infoList = ArrayList<Info>()
        val info1 = Info(
                1,
                "Nonneseter kloster",
                "Nonneseter kloster ble sannsynligvis grunnlagt i ca. \n" +
                        "1150 og er omtalt av Snorre. Klosteret tilhørte \n" +
                        "benediktinerordens kvinnelige gren. Klosteret var viet \n" +
                        "til den hellige Maria. Klosteret var en stor jordeier og \n" +
                        "eide helt eller delvis 272 gårder i Østlandsområdet.\n" +
                        "Klosteret lå nær Hovinbekken og lå utenfor \n" +
                        "middelalderbyen. Et hjørne av det man mener kan ha \n" +
                        "vært klosterkirken ble funnet da Schweigaards gate ble\n" +
                        "utbedret i 1879. To år tidligere kan store deler av kirken \n" +
                        "ha blitt fjernet da man bygde Schweigaards gate 50. \n" +
                        "Det skal finnes rester under Schweigaards gate 55 og \n" +
                        "Grønlandsleiret 73\n"
        )
        val info2 = Info(
                2,
                "Josephine Thrane",
                "Josephine Thrane ble født 5.april 1820 i Drammen og døde \n" +
                        "av tuberkulose 42 år gammel 20.september 1862 i \n" +
                        "Christiania. Hun var oppvokst I beskjedne kår, men fikk\n" +
                        "likevel en god oppdragelse. \n" +
                        "20 år gammel fikk hun privatundervisning i fransk og \n" +
                        "læreren var Marcus Thrane. Han fridde og de giftet seg.\n" +
                        "Senere flyttet de til Drammen hvor de stiftet den første\n" +
                        "arbeiderforeningen. Bevegelsen fikk en rivende utvikling\n" +
                        "og de flyttet til Christiania. I 1851 ble Marcus Thrane \n" +
                        "arrestert og innsatt på Botsfengslet etter rykter om at \n" +
                        "det var diskutert revolusjon på landsmøtet.\n" +
                        "Josephine bosatte seg i Grønlandsleiret 30 og smuglet\n" +
                        "korrespondanse inn og ut av fengslet til \n" +
                        "arbeiderbevegelsen. I 1854 overtok de\n" +
                        "Arbeider-Foreningernes Blad hvor hun, gravid med sitt\n" +
                        " 5. barn, en periode var ansvarlig redaktør. Hun ble \n" +
                        "Norges første kvinnelige redaktør.\n"
        )
        val info3 = Info(
                3,
                "Vaterlands Bru",
                "Vaterlands bru forbinder Brugata med Grønland. Den er\n" +
                        "den sydligste brua over Akerselva og også en av de \n" +
                        "eldste forbindelsene over elva. Når man kom landeveien \n" +
                        "til byen sydfra så var denne brua hovedinngangen. \n" +
                        "Vaterlands bru ble bygget i 1654. Brua ble fornyet med\n" +
                        "jernrekkverk i 1836 og er senere både utvidet og \n" +
                        "ombygget. Området rundt Vaterlands bru var (og er) \n" +
                        "et folkerikt område, og de mange tilreisende ga \n" +
                        "grobunn for mange slags forretningsvirksomhet.\n" +
                        "Det fantes 11 simple skjænkesteder i området rundt \n" +
                        "Vaterlands bru i 1868. Dagens bru er fra 1942.\n"
        )
        val info4 = Info(
                4,
                "Tøyen Kolera Kirkegård",
                "I 1833 slo koleraen til i Christiania og hardest rammet \n" +
                        "var forstedene. 1400 ble smittet av sykdommen, \n" +
                        "817 døde. Aker kommune anla Tøyen Kolera kirkegård \n" +
                        "for å skaffe seg nok gravplass. Da Tøyen ble innlemmet \n" +
                        "i byen 1859, overtok Christiania kommune kirkegården \n" +
                        "to år senere. Den ble nedlagt ca. 1880. Morderne Knud \n" +
                        "Fredrik Chr. Simonsen og Friedrich W. Priess, ble \n" +
                        "gravlagt her i 1864. De to hadde ranet og drept bonden \n" +
                        "Knut Nilsen Grøte fra Lærdal på bytur i 1863, og de ble \n" +
                        "halshogd på Etterstadsletta 19. april 1864. Henrettelsen \n" +
                        "var en folkeforlystelse som ble bivånet av ca. 5000 \n" +
                        "mennesker. Det var siste gang en offentlig henrettelse \n" +
                        "fant sted i Christiania. Priess og Simonsen  var de første \n" +
                        "som ble avfotografert i politiets forbryteralbum, som \n" +
                        "forbrytere nr. 1 og nr. 3. \n"
        )
        val info5 = Info(
                5,
                "Ulvehiet",
                "Oscar Braathen skrev «Ulvehiet» fra 1919 inspirert av \n" +
                        "boforholdene i Gråbeingårdene på Tøyen. \n" +
                        "Hovedpersonen Jonny bor med sin ugifte mor. \n" +
                        "Det var mye finere å bo i forgården sammenlignet med \n" +
                        "bakgården. Jonny og moren bor i leiligheten over \n" +
                        "porten og deler kjøkken med naboen.\n" +
                        "Oscar Braathen sier dette i «Ulvehiet»: «Ulvehiet kaldes \n" +
                        "de, de to digre murgaardene av alle gatens og \n" +
                        "bydelens mennesker. Graabeinene kaldes de som bor \n" +
                        "der, ja voksne og barn nævnes ved det navnet. Av alle \n" +
                        "utenfor. Men de som bor indenfor portene, nævner \n" +
                        "sig gjerne ved et penere navn. Vi fra Komplekset, sier \n" +
                        "de om sig selv, naar de snakker med andre eller naar \n" +
                        "de er hos kjøbmændene.»\n"
        )
        infoList.add(info1)
        infoList.add(info2)
        infoList.add(info3)
        infoList.add(info4)
        infoList.add(info5)
        return infoList
    }
}