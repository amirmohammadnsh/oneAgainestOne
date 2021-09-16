package ir.fum.game;

import ir.fum.gui.MapPanel;

import java.awt.*;

public class GameBrain {

    public MapPanel getPanel() {
        return panel;
    }

    public void setPanel(MapPanel panel) {
        this.panel = panel;
    }

    private MapPanel panel;
    private Player player;
    private Boolean checkColumnMove;
    private Boolean checkRowMove;

    public Boolean getCheckColumnMove() {
        return checkColumnMove;
    }

    public void setCheckColumnMove(Boolean checkColumnMove) {
        this.checkColumnMove = checkColumnMove;
    }

    public Boolean getCheckRowMove() {
        return checkRowMove;
    }

    public void setCheckRowMove(Boolean checkRowMove) {
        this.checkRowMove = checkRowMove;
    }

    public Player getPlayer() {
        return player;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }

    public GameBrain(Component c, MapPanel panel, int selectedRow, int selectedColumn, Player player) {
        setPanel(panel);
        setPlayer(player);

        int lastRowPlayerPosition = 0;
        int lastColumnPlayerPosition = 0;

        if (getPlayer() instanceof BluePlayer) {

            lastRowPlayerPosition = getPanel().getBluePlayer().getPosition().getRowNumber();
            lastColumnPlayerPosition = getPanel().getBluePlayer().getPosition().getColumnNumber();
        } else if (getPlayer() instanceof RedPlayer) {

            lastRowPlayerPosition = getPanel().getRedPlayer().getPosition().getRowNumber();
            lastColumnPlayerPosition = getPanel().getRedPlayer().getPosition().getColumnNumber();
        }

        if (checkColumnMove(lastColumnPlayerPosition, selectedColumn) && !checkRowMove(lastRowPlayerPosition, selectedRow) ||
                !checkColumnMove(lastColumnPlayerPosition, selectedColumn) && checkRowMove(lastRowPlayerPosition, selectedRow)) {
            if (checkColumnMove) {
                if (checkNumberOfSteps(getPlayer().getPower(), selectedRow, lastRowPlayerPosition)) {
                    if (!isWallAvailableInTheWay(lastRowPlayerPosition, lastColumnPlayerPosition, selectedRow, selectedColumn
                            , getCheckRowMove(), getCheckColumnMove()))
                        new MovePlayer(c, getPanel(), this, selectedRow, selectedColumn, getPlayer());

                }

            } else if (checkRowMove) {
                if (checkNumberOfSteps(getPlayer().getPower(), selectedColumn, lastColumnPlayerPosition)) {
                    if (!isWallAvailableInTheWay(lastRowPlayerPosition, lastColumnPlayerPosition, selectedRow, selectedColumn
                            , getCheckRowMove(), getCheckColumnMove()))
                        new MovePlayer(c, getPanel(), this, selectedRow, selectedColumn, getPlayer());

                }

            }


        }


    }


    public boolean checkColumnMove(int playerColumn, int selectedColumn) {
        Boolean columnMove = false;
        if ((Math.abs(playerColumn - selectedColumn)) == 0) {
            columnMove = true;
            setCheckColumnMove(columnMove);
        } else setCheckColumnMove(columnMove);

        return columnMove;
    }

    public boolean checkRowMove(int playerRow, int selectedRow) {
        Boolean RowMove = false;
        if ((Math.abs(playerRow - selectedRow)) == 0) {
            RowMove = true;
            setCheckRowMove(RowMove);
        } else setCheckRowMove(RowMove);

        return RowMove;
    }

    public boolean checkNumberOfSteps(int playerPower, int selectedPlace, int playerposition) {

        boolean isValidMove = false;
        if (Math.abs(selectedPlace - playerposition) <= playerPower)
            isValidMove = true;

        return isValidMove;


    }

    public Boolean isWallAvailableInTheWay(int lastRowPlayerPosition, int lastColumnPlayerPosition, int selectedRow
            , int selectedColumn, boolean checkRowMove, boolean checkColumnMove) {
        Boolean isWallAvailableInTheWay = false;
        if (checkColumnMove) {
            if (selectedRow - getPlayer().getPosition().getRowNumber() > 0) {
                for (int i = getPlayer().getPosition().getRowNumber(); i < selectedRow; i++) {
                    if (getPanel().getComponentAt(getPanel().getBlocks()[i][selectedColumn].getX(), getPanel().getBlocks()[i][selectedColumn].getY()) instanceof Wall) {
                        isWallAvailableInTheWay = true;
                        break;
                    }


                }


            } else if (selectedRow - getPlayer().getPosition().getRowNumber() < 0) {

                for (int i = getPlayer().getPosition().getRowNumber() - 1; i > selectedRow; i--) {
                    if (getPanel().getComponentAt(getPanel().getBlocks()[i][selectedColumn].getX(), getPanel().getBlocks()[i][selectedColumn].getY()) instanceof Wall) {
                        isWallAvailableInTheWay = true;
                        break;
                    }


                }

            }

        } else if (checkRowMove) {

            if (selectedColumn - getPlayer().getPosition().getColumnNumber() > 0) {
                for (int j = getPlayer().getPosition().getColumnNumber(); j < selectedColumn; j++) {
                    if (getPanel().getComponentAt(getPanel().getBlocks()[selectedRow][j].getX(), getPanel().getBlocks()[selectedRow][j].getY()) instanceof Wall) {
                        isWallAvailableInTheWay = true;
                        break;
                    }


                }


            } else if (selectedColumn - getPlayer().getPosition().getColumnNumber() < 0) {

                for (int j = getPlayer().getPosition().getColumnNumber() - 1; j > selectedColumn; j--) {
                    if (getPanel().getComponentAt(getPanel().getBlocks()[selectedRow][j].getX(), getPanel().getBlocks()[selectedRow][j].getY()) instanceof Wall) {
                        isWallAvailableInTheWay = true;
                        break;
                    }


                }

            }


        }

        return isWallAvailableInTheWay;
    }
}
